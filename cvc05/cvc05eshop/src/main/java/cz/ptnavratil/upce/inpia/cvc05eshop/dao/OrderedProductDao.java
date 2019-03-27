package cz.ptnavratil.upce.inpia.cvc05eshop.dao;

import cz.ptnavratil.upce.inpia.cvc05eshop.model.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedProductDao extends JpaRepository<OrderedProduct,Integer> {
}
