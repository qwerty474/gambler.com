package gmongo;

import org.springframework.data.mongodb.core.MongoTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public abstract class AbstractRepositoryImpl<MngType, Id> implements AbstractRepository<MngType, Id> {
    protected MongoTemplate mongoTemplate;

    protected AbstractRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Optional<MngType> findById(Id id) {
        return Optional.of(mongoTemplate.findById(id, getGenericType()));
    }

    public void clear() {
        Class<MngType> clazz = getGenericType();
        if (mongoTemplate.collectionExists(clazz)) {
            mongoTemplate.dropCollection(clazz);
        }

        mongoTemplate.createCollection(clazz);
    }

    public void insertAll(List<MngType> objects) {
        mongoTemplate.insertAll(objects);
    }

    private Class<MngType> getGenericType() {
        return (Class<MngType>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
