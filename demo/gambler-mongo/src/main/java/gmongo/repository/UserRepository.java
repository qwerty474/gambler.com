package gmongo.repository;


import gmongo.model.UserMng;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    /**
     * Ищет пользователя в бд, по его id
     */
    Optional<UserMng> findById(Integer id);

    /**
     * Очищает коллекцию в бд, если ее нет, то создаст
     */
    void clear();

    /**
     * Добавляет в бд всех пользователей
     */
    void insertAll(List<UserMng> users);

    /**
     * Возвращает данные всех пользователей
     */
    List<UserMng> getAll();

    Optional<UserMng> findByLogin(String login);
}
