package com.buycode.buycart.dto;

public class ProductImageDto {
    private String url;

    public ProductImageDto(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
