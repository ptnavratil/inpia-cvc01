package cz.ptnavratil.upce.inpia.cvc05eshop.model;

import cz.ptnavratil.upce.inpia.cvc05eshop.model.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class OrderForm extends BaseEntity {

    @OneToMany(mappedBy = "id")
    private Set<OrderedProduct> orderedProducts;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

}
