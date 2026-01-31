package com.buycode.buycart.spec;

import com.buycode.buycart.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {
    public static Specification<Product> hasCategory(String category){
        return ((root, query, criteriaBuilder) -> category == null ? null : criteriaBuilder.equal(root.get("category"),category) );
    }

    public static Specification<Product> priceBetween(Double min,Double max){
        return (root, query, criteriaBuilder) -> {
          if(min == null && max == null) return null;
          if(min == null) return criteriaBuilder.lessThanOrEqualTo(root.get("price"),max);
          if(max == null) return criteriaBuilder.greaterThanOrEqualTo(root.get("price"),min);
          return criteriaBuilder.between(root.get("price"),min,max);
        };
    }

    public static Specification<Product> hasNameOrDescriptionLike(String keyword){
        return (root, query, criteriaBuilder) -> {
            if(keyword == null || keyword.isEmpty()) return null;
            return criteriaBuilder.or(
                    criteriaBuilder.like(root.get("name"), "%" + keyword.toLowerCase() + "%"),
                    criteriaBuilder.like(root.get("description"), "%" + keyword.toLowerCase() + "%")
            );
        };
    }

    public static Specification<Product> ratingGreaterThan(Double ratings){
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.greaterThanOrEqualTo(root.get("ratings"),ratings);
        };
    }
}
