package com.example.be_webbanhang.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_image")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProductImage;
    private String nameImage;
    private String urlImage;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Product product;
}
