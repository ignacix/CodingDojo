package com.cd.productosycategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cd.productosycategorias.models.ProductModel;

@Repository
public interface ProductRepo extends CrudRepository<ProductModel, Long>{
	
	List<ProductModel> findAll();
}
