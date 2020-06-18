package com.ujjaval.ecommerce.commondataservice.entity.sql.categories;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class PriceRangeCategory {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String priceRange;

    public PriceRangeCategory(String priceRange) {
        this.priceRange = priceRange;
    }
}
