package com.example.demo.repository;

import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final MongoTemplate mongoTemplate;

    @Override
    public Optional<User> findById(Integer id) {
        Query query = new Query(Criteria.where(User.ID_COLUMN_NAME).is(id));
        return Optional.ofNullable(mongoTemplate.findOne(query, User.class));
    }

    @Override
    public void clear() {
        if (mongoTemplate.collectionExists(User.class)) {
            mongoTemplate.dropCollection(User.class);
        }

        mongoTemplate.createCollection(User.class);
    }

    @Override
    public void insertAll(List<User> users) {
        mongoTemplate.insertAll(users);
    }


}
