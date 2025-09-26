package vn.iotstar.grapql_23110274.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Set;
@Setter
@Getter
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String images;

    @ManyToMany(mappedBy = "categories")
    private Set<User> users;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    // Getters, setters
}
