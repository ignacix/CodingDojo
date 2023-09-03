package com.cd.productosycategorias.services;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.cd.productosycategorias.models.CategoryModel;
import com.cd.productosycategorias.models.ProductCategoryModel;
import com.cd.productosycategorias.models.ProductModel;
import com.cd.productosycategorias.repositories.CategoryRepo;
import com.cd.productosycategorias.repositories.ProductCategoryRepo;
import com.cd.productosycategorias.repositories.ProductRepo;

@Controller
public class MainService {
	// INYECCION DE DEPENDECIAS
	private final ProductRepo productRepo;
	private final CategoryRepo categoryRepo;
	private final ProductCategoryRepo proCatRepo;
	public MainService(ProductRepo productRepo, CategoryRepo categoryRepo, ProductCategoryRepo procatRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
		this.proCatRepo = procatRepo;
	}
	
	

	public ProductModel crearProducto(ProductModel producto) {
		return productRepo.save(producto);
	}
	public CategoryModel crearCategoria(CategoryModel categoria) {
		return categoryRepo.save(categoria);
	}
	public ProductCategoryModel crearVinculo(ProductCategoryModel productoCategorias) {
		return proCatRepo.save(productoCategorias);
	}
	

	public List<CategoryModel> productoSinCategoria(ProductModel producto){
		return categoryRepo.findByProductsNotContains(producto);
	}
	
	public ProductModel unProducto(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	
	public List<ProductModel> todosProductos(){
		return productRepo.findAll();
	}

}
