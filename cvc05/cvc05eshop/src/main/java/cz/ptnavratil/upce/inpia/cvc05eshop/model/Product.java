package cz.ptnavratil.upce.inpia.cvc05eshop.model;


import cz.ptnavratil.upce.inpia.cvc05eshop.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {

    private String name;
    private String slugName;
    private Double price;
    private String description;
    private Boolean isActive;
}

