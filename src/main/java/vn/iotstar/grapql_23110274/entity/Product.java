package vn.iotstar.grapql_23110274.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer quantity;
    private String desc;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    // Getters and setters
}