package com.example.paymentservice.service;

import com.example.paymentservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final List<Product> productList = new ArrayList<>();

    public List<Product> getAllProducts(){
        return productList;
    }

    public Product addProduct(Product product){
        productList.add(product);
        return product;
    }

    public Product updateProduct(int id, Product updatedProduct){
        Optional<Product> existing  = productList.stream().filter(p->p.getId() == id).findFirst();

        if(existing.isPresent()){
            Product p = existing.get();
            p.setName(updatedProduct.getName());
            p.setPrice(updatedProduct.getPrice());
            return p;

        } else {
            return null;
        }
    }

    public boolean deleteProduct(int id){
        return productList.removeIf(p->p.getId() == id);
    }

}
