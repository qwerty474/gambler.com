package gmongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("users")
@Data
@AllArgsConstructor
public class UserMng {
    public static final String ID_COLUMN_NAME = "id";
    public static final String NAME_COLUMN_NAME = "name";
    public static final String SURNAME_COLUMN_NAME = "surname";
    public static final String AGE_COLUMN_NAME = "age";

    @Id
    @Field(ID_COLUMN_NAME)
    private Integer id;
    @Field(NAME_COLUMN_NAME)
    private String name;
    @Field(SURNAME_COLUMN_NAME)
    private String surname;
    @Field(AGE_COLUMN_NAME)
    private Integer age;
}