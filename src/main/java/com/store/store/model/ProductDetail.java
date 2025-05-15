package com.store.store.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detail")
@Data // getter,setter,tostring
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String longDescription;

    @Min(1)
    private int stock;

    //relacion 1 a 1
    @JsonBackReference
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id") //FK //este objeto es dependiente de Product
    private Product product;
}
