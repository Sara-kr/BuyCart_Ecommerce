package com.buycode.buycart.seed;

import com.buycode.buycart.entity.Product;
import com.buycode.buycart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if(productRepository.count()==0){
            List<Product> demoProducts = List.of(
                    new Product(null, "Apple iPhone 15", 799.0, "Smartphone with A16 chip", "Phone", 4.8, "Amazon", 5, List.of("/products/1.png")),
                    new Product(null, "Samsung Galaxy S24", 749.0, "Flagship Android smartphone", "Phone", 4.7, "Flipkart", 6,List.of("/products/2.png")),
                    new Product(null, "OnePlus 12", 699.0, "Fast performance and smooth UI", "Phone", 4.6, "Amazon", 4,List.of("/products/3.png")),
                    new Product(null, "Google Pixel 8", 729.0, "Best camera with clean Android", "Phone", 4.5, "Flipkart", 3,List.of("/products/4.webp")),
                    new Product(null, "Xiaomi 14 Pro", 599.0, "Premium specs at competitive price", "Phone", 4.4, "Amazon", 5,List.of("/products/5.webp")),

                    new Product(null, "Apple MacBook Air M2", 1199.0, "Lightweight laptop with M2 chip", "Laptop", 4.8, "Apple Store", 2,List.of("/products/6.webp")),
                    new Product(null, "Dell XPS 13", 999.0, "Premium ultrabook design", "Laptop", 4.6, "Dell Store", 3,List.of("/products/7.webp")),

                    new Product(null, "Sony WH-1000XM5", 349.0, "Noise cancelling wireless headphones", "Headphones", 4.9, "Amazon", 7,List.of("/products/8.webp")),
                    new Product(null, "iPad Pro 11", 799.0, "High-performance tablet with M2 chip", "Tablet", 4.7, "Amazon", 4,List.of("/products/9.webp")),
                    new Product(null, "Samsung Galaxy Watch 6", 299.0, "Advanced fitness & health tracking", "Smartwatch", 4.5, "Flipkart", 8,List.of("/products/410.webp"))
            );

            productRepository.saveAll(demoProducts);
            System.out.println("Seeded demo Products");
        }
        else {
            System.out.println("Products  Already exists! Skipping Seed");

        }
    }
}
