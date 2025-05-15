package com.store.store.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data // getter,setter,tostring
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=2)
    private String name;

    @Min(1)
    private double price;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String description;

    //relacion 1 a 1
    @JsonManagedReference
    @OneToOne(mappedBy = "product",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private ProductDetail detail;

    //relacion 1 a muchos
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id")
    private Category category;

    //relacion muchos a muchos
    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "orders_has_products",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Order> orders;
    
}
