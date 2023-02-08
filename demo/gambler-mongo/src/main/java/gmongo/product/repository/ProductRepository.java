package gmongo.product.repository;

import gmongo.AbstractRepository;
import gmongo.product.model.ProductMng;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends AbstractRepository<ProductMng, Integer> {
    /**
     * Ищет все продукты пользователя
     */
    List<ProductMng> findProductByOwnerId(Integer ownerId);

    /**
     * Ищет продукт
     */
    Optional<ProductMng> findProductByProductIdAndOwnerId(Integer productId, Integer ownerId);
}
