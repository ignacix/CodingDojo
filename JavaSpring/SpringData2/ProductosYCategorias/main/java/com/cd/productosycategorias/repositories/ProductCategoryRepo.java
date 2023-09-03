package com.cd.productosycategorias.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.productosycategorias.models.ProductCategoryModel;

@Repository
public interface ProductCategoryRepo extends CrudRepository<ProductCategoryModel,Long> {

}
