package com.buycode.buycart.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name field is required")
    private  String name;

    @Column(nullable = false)
    @NotNull(message = "Price field is required")
    @PositiveOrZero(message = "Value must be zero or greater than zero")
    private  Double price;

    @NotBlank(message = "Name field is required")
    private  String description;

    private String category;

    private Double ratings = 0.0;

    @NotBlank(message = "Seller field is required")
    private  String seller;

    @NotNull(message = "Stock field is required")
    private  Integer stock=0;

    private Integer numOfReviews = 0;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductImage> images;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductReview> reviews;

    public Product(Long id, String name, Double price, String description, String category, Double ratings, String seller, Integer stock,List<String> images) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.ratings = ratings;
        this.seller = seller;
        this.stock = stock;
        this.images = images.stream().map(url -> new ProductImage(url,this)).collect(Collectors.toList());
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Name field is required") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name field is required") String name) {
        this.name = name;
    }

    public @NotNull(message = "Price field is required") @PositiveOrZero(message = "Value must be zero or greater than zero") Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "Price field is required") @PositiveOrZero(message = "Value must be zero or greater than zero") Double price) {
        this.price = price;
    }

    public @NotBlank(message = "Name field is required") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Name field is required") String description) {
        this.description = description;
    }

    public Double getRatings() {
        return ratings;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    public @NotBlank(message = "Seller field is required") String getSeller() {
        return seller;
    }

    public void setSeller(@NotBlank(message = "Seller field is required") String seller) {
        this.seller = seller;
    }

    public @NotNull(message = "Stock field is required") Integer getStock() {
        return stock;
    }

    public void setStock(@NotNull(message = "Stock field is required") Integer stock) {
        this.stock = stock;
    }

    public Integer getNumOfReviews() {
        return numOfReviews;
    }

    public void setNumOfReviews(Integer numOfReviews) {
        this.numOfReviews = numOfReviews;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<ProductReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProductReview> reviews) {
        this.reviews = reviews;
    }

    public List<ProductImage> getImages() {
        return images;
    }

    public void setImages(List<ProductImage> images) {
        this.images = images;
    }
}
