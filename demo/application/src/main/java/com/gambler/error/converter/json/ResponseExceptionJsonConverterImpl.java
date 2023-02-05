package com.gambler.error.converter.json;

import com.gambler.error.converter.ResponseExceptionConverter;
import com.gambler.error.exception.BackendException;
import com.gambler.error.model.ResponseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ResponseExceptionJsonConverterImpl implements ResponseExceptionConverter {
    private ObjectMapper objectMapper = new ObjectMapper();
    private File file = new File(getClass().getClassLoader().getResource("error/error.json").getFile());

    @Override
    public ResponseEntity<ResponseException> convert(BackendException exception) {
        JsonErrorList errorsList;
        try {
            errorsList = objectMapper.readValue(file, JsonErrorList.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return unknownException();
        }

        for (JsonErrorList.JsonError jsonError : errorsList.getErrors()) {
            if (jsonError.getCode().equals(exception.getError().getCode())) {
                ResponseException responseException = new ResponseException()
                        .setCode(jsonError.getMapCode())
                        .setText(jsonError.getText());
                return new ResponseEntity<>(responseException, exception.getError().getHttpStatus());
            }
        }

        return unknownException();
    }

    private ResponseEntity<ResponseException> unknownException() {
        ResponseException exception = new ResponseException()
                .setText("Что-то сломалось")
                .setCode("0");
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
