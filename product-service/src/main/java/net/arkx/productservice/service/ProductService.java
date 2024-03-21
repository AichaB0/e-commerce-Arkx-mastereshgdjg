package net.arkx.productservice.service;

import jakarta.persistence.EntityNotFoundException;
import net.arkx.productservice.entities.Product;
import net.arkx.productservice.entities.SubCategory;
import net.arkx.productservice.repository.ProductRepository;
import net.arkx.productservice.repository.PromoRepository;
import net.arkx.productservice.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    private final SubCategoryRepository subcategoryRepository;
    public ProductService(ProductRepository productRepository,SubCategoryRepository subCategoryRepository)
    {
        this.productRepository = productRepository;
        this.subcategoryRepository=subCategoryRepository;
    }
    //code



    public void addProductToSubcategories(Product product, List<Long> subcategoryIds) {
        List<SubCategory> subcategories = new ArrayList<>();
        for (Long subcategoryId : subcategoryIds) {
            SubCategory subcategory = subcategoryRepository.findById(subcategoryId)
                    .orElseThrow(() -> new EntityNotFoundException("Subcategory not found"));
            subcategories.add(subcategory);
        }
        product.setSubcategories(subcategories);
         productRepository.save(product);
    }

public List<Product> getAllProducts()
{
    return productRepository.findAll();
}
public Product getProductById(Long idProduct)
{
    return productRepository.findById(idProduct).get();
}

    public void delete(Long idToDelete)
    {
        productRepository.deleteById(idToDelete);
    }

    //fin code

}
