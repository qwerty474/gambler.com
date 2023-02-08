package gmongo.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("users")
@Getter
@Setter
@Accessors(chain = true)
public class UserMng {
    public static final String ID_COLUMN_NAME = "id";
    public static final String NAME_COLUMN_NAME = "name";
    public static final String LASTNAME_COLUMN_NAME = "lastname";
    public static final String LOGIN_COLUMN_NAME = "login";
    public static final String PASSWORD_COLUMN_NAME = "password";

    @Id
    @Field(ID_COLUMN_NAME)
    private Integer id;
    @Field(NAME_COLUMN_NAME)
    private String name;
    @Field(LASTNAME_COLUMN_NAME)
    private String lastname;
    @Field(LOGIN_COLUMN_NAME)
    private String login;
    @Field(PASSWORD_COLUMN_NAME)
    private String password;
}