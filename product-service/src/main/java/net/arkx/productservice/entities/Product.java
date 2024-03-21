package net.arkx.productservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity @Builder
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    //@OneToMany(mappedBy = "product")
    //private List<Promo> promos;
    @ManyToMany
    @JoinTable(
            name = "product_subcategory",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "subcategory_id")
    )
    private List<SubCategory> subcategories;
    private String description;
    private String image;
}
