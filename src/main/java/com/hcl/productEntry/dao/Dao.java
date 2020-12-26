package com.hcl.productEntry.dao;

import java.util.List;
import com.hcl.productEntry.entity.ProductEntity;

public interface Dao {
    void saveProduct(ProductEntity product);

    List<?> getAllProducts();
    // TODO: add remaining CRUD operations
}
