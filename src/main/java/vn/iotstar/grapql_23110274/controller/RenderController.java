package vn.iotstar.grapql_23110274.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RenderController {
    @GetMapping({"/", "/products"})
    public String home() {
        return "index";
    }

    // User CRUD pages
    @GetMapping("/users")
    public String users() {
        return "users";
    }

    @GetMapping("/users/create")
    public String createUser() {
        return "create-user";
    }

    @GetMapping("/users/edit")
    public String editUser() {
        return "edit-user";
    }

    // Category CRUD pages
    @GetMapping("/categories")
    public String categories() {
        return "categories";
    }

    @GetMapping("/categories/create")
    public String createCategory() {
        return "create-category";
    }

    @GetMapping("/categories/edit")
    public String editCategory() {
        return "edit-category";
    }

    // Product CRUD pages
    @GetMapping("/products/create")
    public String createProduct() {
        return "create-product";
    }

    @GetMapping("/products/edit")
    public String editProduct() {
        return "edit-product";
    }
}
