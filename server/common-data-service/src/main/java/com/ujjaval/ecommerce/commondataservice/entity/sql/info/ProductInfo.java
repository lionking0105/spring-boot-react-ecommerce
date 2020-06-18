package com.ujjaval.ecommerce.commondataservice.entity.sql.info;

import com.fasterxml.jackson.annotation.*;
import com.ujjaval.ecommerce.commondataservice.entity.sql.categories.ClothesTypeCategory;
import com.ujjaval.ecommerce.commondataservice.entity.sql.categories.GenderCategory;
import com.ujjaval.ecommerce.commondataservice.entity.sql.categories.ProductBrandCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(indexes = {@Index(columnList = "maincategory_id, subcategory_id, brand_id, price")})
public class ProductInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private int sellerId;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private ProductBrandCategory productBrandCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maincategory_id")
    @JsonIgnore
    private GenderCategory genderCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id")
    @JsonIgnore
    private ClothesTypeCategory clothesTypeCategory;

    private double price;

    private int availableQuantity;

    private int deliveryTime;

    private float ratings;

    private boolean verificationStatus;

    private String imageName;

    @OneToMany(mappedBy = "orderInfo")
    @JsonIgnore
    private List<OrderInfo> orders;

    public ProductInfo(int sellerId, String name, Date publicationDate, ProductBrandCategory productBrandCategory,
                       GenderCategory genderCategory, ClothesTypeCategory clothesTypeCategory,
                       double price, int availableQuantity, int deliveryTime, float ratings,
                       boolean verificationStatus, String imageName) {
        this.sellerId = sellerId;
        this.name = name;
        this.publicationDate = publicationDate;
        this.productBrandCategory = productBrandCategory;
        this.genderCategory = genderCategory;
        this.clothesTypeCategory = clothesTypeCategory;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.deliveryTime = deliveryTime;
        this.ratings = ratings;
        this.verificationStatus = verificationStatus;
        this.imageName = imageName;
    }
}