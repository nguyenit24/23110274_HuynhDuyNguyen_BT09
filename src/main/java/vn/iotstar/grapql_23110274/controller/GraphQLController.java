package vn.iotstar.grapql_23110274.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import vn.iotstar.grapql_23110274.entity.Category;
import vn.iotstar.grapql_23110274.entity.Product;
import vn.iotstar.grapql_23110274.entity.User;
import vn.iotstar.grapql_23110274.repository.CategoryRepository;
import vn.iotstar.grapql_23110274.repository.ProductRepository;
import vn.iotstar.grapql_23110274.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class GraphQLController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @QueryMapping
    public List<Product> productsOrderByPrice() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    @QueryMapping
    public List<Product> productsByCategory(@Argument Long categoryId) {
        return productRepository.findByCategory_Id(categoryId);
    }


    @MutationMapping
    public Product createProduct(@Argument String title, @Argument Integer quantity, @Argument String desc, @Argument Float price,
                                 @Argument Long userid, @Argument Long categoryid) {
        Product p = new Product();
        p.setTitle(title); p.setQuantity(quantity); p.setDescription(desc); p.setPrice(price.doubleValue());
        User u = userRepository.findById(userid).orElse(null);
        Category c = categoryRepository.findById(categoryid).orElse(null);
        p.setUser(u); p.setCategory(c);
        return productRepository.save(p);
    }

    @MutationMapping
    public Product updateProduct(@Argument Long id, @Argument String title, @Argument Integer quantity, @Argument String desc, @Argument Float price) {
        Optional<Product> opt = productRepository.findById(id);
        if (opt.isPresent()) {
            Product p = opt.get();
            if (title != null) p.setTitle(title);
            if (quantity != null) p.setQuantity(quantity);
            if (desc != null) p.setDescription(desc);
            if (price != null) p.setPrice(price.doubleValue());
            return productRepository.save(p);
        }
        return null;
    }

    @MutationMapping
    public Boolean deleteProduct(@Argument Long id) {
        productRepository.deleteById(id);
        return true;
    }

    // Mutation - Category
    @MutationMapping
    public Category createCategory(@Argument String name, @Argument String images) {
        Category c = new Category();
        c.setName(name); c.setImages(images);
        return categoryRepository.save(c);
    }

    @MutationMapping
    public Category updateCategory(@Argument Long id, @Argument String name, @Argument String images) {
        Optional<Category> opt = categoryRepository.findById(id);
        if (opt.isPresent()) {
            Category c = opt.get();
            if (name != null) c.setName(name);
            if (images != null) c.setImages(images);
            return categoryRepository.save(c);
        }
        return null;
    }

    @MutationMapping
    public Boolean deleteCategory(@Argument Long id) {
        categoryRepository.deleteById(id);
        return true;
    }

    // Query: lấy tất cả các user
    @QueryMapping
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    // Query: lấy tất cả các category
    @QueryMapping
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    // Query: lấy tất cả các product
    @QueryMapping
    public List<Product> allProducts() {
        return productRepository.findAll();
    }

    // Query: lấy user theo id
    @QueryMapping
    public User getUser(@Argument Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Query: lấy product theo id
    @QueryMapping
    public Product getProduct(@Argument Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Query: lấy category theo id
    @QueryMapping
    public Category getCategory(@Argument Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    // Mutation: tạo user
    @MutationMapping
    public User createUser(@Argument String fullname, @Argument String email, @Argument String password, @Argument String phone) {
        User user = new User();
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        return userRepository.save(user);
    }

    // Mutation: cập nhật user
    @MutationMapping
    public User updateUser(@Argument Long id, @Argument String fullname, @Argument String email, @Argument String password, @Argument String phone) {
        Optional<User> opt = userRepository.findById(id);
        if (opt.isPresent()) {
            User user = opt.get();
            if (fullname != null) user.setFullname(fullname);
            if (email != null) user.setEmail(email);
            if (password != null) user.setPassword(password);
            if (phone != null) user.setPhone(phone);
            return userRepository.save(user);
        }
        return null;
    }

    @MutationMapping
    public Boolean deleteUser(@Argument Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
