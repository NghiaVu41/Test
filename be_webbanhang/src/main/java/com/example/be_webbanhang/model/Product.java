package com.example.be_webbanhang.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;
    private String nameProduct;
    private int price;
    private String description;
    private String imagemain;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CategoryProduct category_product;

    @JsonIgnore
    @OneToMany(mappedBy="product",cascade=CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<ProductImage> product_images;

}
