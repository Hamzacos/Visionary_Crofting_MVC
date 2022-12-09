package com.visonarycrafting.vs_mvc.Dao;

import com.visonarycrafting.vs_mvc.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product,Long> {
    public List<Product> findProductByStockIdOrderByQuantity(Integer stockid);
    public List<Product> findProductByStockIdOrderByProductPrice(Integer stockid);

    List<Product> findByProductName(String productName);
    long countByProductName(String productName);


    List<Product> findByStockId(Long id);
}
