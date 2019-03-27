package cz.ptnavratil.upce.inpia.cvc05eshop.dao;

import cz.ptnavratil.upce.inpia.cvc05eshop.model.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderFormDao extends JpaRepository<OrderForm,Integer> {
}
