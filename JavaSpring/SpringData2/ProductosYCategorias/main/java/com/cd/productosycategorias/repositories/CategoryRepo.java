package com.cd.productosycategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.productosycategorias.models.CategoryModel;
import com.cd.productosycategorias.models.ProductModel;

@Repository
public interface CategoryRepo extends CrudRepository<CategoryModel, Long>{

	List<CategoryModel> findByProductsNotContains(ProductModel producto);
}
