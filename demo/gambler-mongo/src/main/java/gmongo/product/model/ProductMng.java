package gmongo.product.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("products")
@Getter
@Setter
@Accessors(chain = true)
public class ProductMng {

    public static final String ID_COLUMN_NAME = "id";
    public static final String NAME_COLUMN_NAME = "name";
    public static final String OWNER_ID_COLUMN_NAME = "ownerId";

    @Id
    @Field(ID_COLUMN_NAME)
    private Integer id;

    @Field(NAME_COLUMN_NAME)
    private String name;

    @Field(OWNER_ID_COLUMN_NAME)
    private Integer ownerId;
}
