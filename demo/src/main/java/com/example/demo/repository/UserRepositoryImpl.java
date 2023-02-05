package com.example.demo.repository;

import com.example.demo.model.UserMng;
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
    public Optional<UserMng> findById(Integer id) {
        Query query = new Query(Criteria.where(UserMng.ID_COLUMN_NAME).is(id));
        return Optional.ofNullable(mongoTemplate.findOne(query, UserMng.class));
    }

    @Override
    public void clear() {
        if (mongoTemplate.collectionExists(UserMng.class)) {
            mongoTemplate.dropCollection(UserMng.class);
        }

        mongoTemplate.createCollection(UserMng.class);
    }

    @Override
    public void insertAll(List<UserMng> users) {
        mongoTemplate.insertAll(users);
    }


}
