package gmongo.product.repository;

import gmongo.AbstractRepositoryImpl;
import gmongo.product.model.ProductMng;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ProductMngRepositoryImpl extends AbstractRepositoryImpl<ProductMng, Integer> implements ProductMngRepository {

    public ProductMngRepositoryImpl(MongoTemplate mongoTemplate) {
        super(mongoTemplate);
    }

    @Override
    public List<ProductMng> findProductByOwnerId(Integer ownerId) {
        Query query = new Query(Criteria.where(ProductMng.OWNER_ID_COLUMN_NAME).is(ownerId));
        return mongoTemplate.find(query, ProductMng.class);
    }

    @Override
    public Optional<ProductMng> findProductByProductIdAndOwnerId(Integer productId, Integer ownerId) {
        Optional<ProductMng> product = findById(productId);
        if (product.isEmpty() || !Objects.equals(product.get().getOwnerId(), ownerId)) {
            return Optional.empty();
        }

        return product;
    }
}
