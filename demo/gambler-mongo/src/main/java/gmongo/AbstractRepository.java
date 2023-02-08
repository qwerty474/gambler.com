package gmongo;

import java.util.List;
import java.util.Optional;

/**
 * Общий интерфейс для классов Repository
 *
 * @param <MngType> Тип сущности в монге
 * @param <Id>      Тип id сущности
 */
public interface AbstractRepository<MngType, Id> {
    /**
     * Ищет пользователя в бд, по его id
     */
    Optional<MngType> findById(Id id);

    /**
     * Очищает коллекцию в бд, если ее нет, то создаст
     */
    void clear();

    /**
     * Добавляет в бд всех пользователей
     */
    void insertAll(List<MngType> objects);
}
