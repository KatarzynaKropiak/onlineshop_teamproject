package com.kodilla.ecommercee.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name="\"groups\"")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "groupId")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            fetch = FetchType.EAGER
    )
    private List<Product> products;

    public Group(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }
}
