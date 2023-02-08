package gmongo.user.repository;

import gmongo.AbstractRepositoryImpl;
import gmongo.user.model.UserMng;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Optional;

public class UserRepositoryImpl extends AbstractRepositoryImpl<UserMng, Integer> implements UserRepository {

    public UserRepositoryImpl(MongoTemplate mongoTemplate) {
        super(mongoTemplate);
    }

    @Override
    public Optional<UserMng> findByLogin(String login) {
        Query query = new Query(Criteria.where(UserMng.LOGIN_COLUMN_NAME).is(login));
        return Optional.ofNullable(mongoTemplate.findOne(query, UserMng.class));
    }
}
