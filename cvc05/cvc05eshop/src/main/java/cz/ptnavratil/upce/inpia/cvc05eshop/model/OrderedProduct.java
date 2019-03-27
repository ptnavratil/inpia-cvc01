package cz.ptnavratil.upce.inpia.cvc05eshop.model;

import cz.ptnavratil.upce.inpia.cvc05eshop.model.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
public class OrderedProduct extends BaseEntity {

    @ManyToOne
    private OrderForm orderForm;
    @ManyToOne
    private Product product;

    private Integer amount;

}
