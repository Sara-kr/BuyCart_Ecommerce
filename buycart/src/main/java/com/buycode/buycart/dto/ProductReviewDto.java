package com.buycode.buycart.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductReviewDto {
    @NotNull(message = "Product ID is Required")
    private Long productId;

    @NotBlank(message = "Comment cannot be blank")
    private String comment;

    @NotNull(message = "ratings is required")
    private Double rating;

    public Long getProductId() {
        return productId;
    }

    public ProductReviewDto(Long productId, String comment, Double rating) {
        this.productId = productId;
        this.comment = comment;
        this.rating = rating;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public ProductReviewDto() {
    }
}
