package gmongo.user.repository;


import gmongo.AbstractRepository;
import gmongo.user.model.UserMng;

import java.util.Optional;

public interface UserMngRepository extends AbstractRepository<UserMng, Integer> {

    /**
     * Ищет пользователя по логину
     */
    Optional<UserMng> findByLogin(String login);
}
