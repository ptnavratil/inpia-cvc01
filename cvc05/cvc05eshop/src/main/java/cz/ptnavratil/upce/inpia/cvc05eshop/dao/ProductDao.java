package cz.ptnavratil.upce.inpia.cvc05eshop.dao;

import cz.ptnavratil.upce.inpia.cvc05eshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Integer> {
}
