package vn.iotstar.grapql_23110274.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iotstar.grapql_23110274.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByOrderByPriceAsc();
    List<Product> findByCategory_Id(Long categoryId);
}
