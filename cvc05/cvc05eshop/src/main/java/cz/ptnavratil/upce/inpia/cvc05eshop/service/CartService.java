package cz.ptnavratil.upce.inpia.cvc05eshop.service;

import cz.ptnavratil.upce.inpia.cvc05eshop.dao.OrderFormDao;
import cz.ptnavratil.upce.inpia.cvc05eshop.dao.OrderedProductDao;
import cz.ptnavratil.upce.inpia.cvc05eshop.model.OrderForm;
import cz.ptnavratil.upce.inpia.cvc05eshop.model.OrderState;
import cz.ptnavratil.upce.inpia.cvc05eshop.model.OrderedProduct;
import cz.ptnavratil.upce.inpia.cvc05eshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class CartService {

    private Map<Product, Integer> cart;
    @Autowired
    private OrderFormDao orderFormDao;
    @Autowired
    private OrderedProductDao orderedProductDao;

    public CartService() {
        cart = new HashMap<>();
    }

    public void addProductToCart(Product product, Integer amount) {
        if (cart.containsKey(product)) {
            int oldAmount = cart.get(product);
            cart.replace(product, ++oldAmount);
        } else {
            cart.put(product, amount);
        }
    }

    public void removeProductFromCart(Product product, Integer amount) {
        if (cart.containsKey(product)) {
            int oldAmount = cart.get(product);
            cart.replace(product, --oldAmount);
        } else {

        }
    }

    public Map<Product, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(cart);
    }


    public void checkout() {
        OrderForm orderForm = new OrderForm();
        orderForm.setOrderState(OrderState.NEW);
        orderForm = orderFormDao.save(orderForm);

        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            OrderedProduct orderedProduct = new OrderedProduct();
            orderedProduct.setProduct(entry.getKey());
            orderedProduct.setAmount(entry.getValue());
            orderedProduct.setOrderForm(orderForm);
            orderedProductDao.save(orderedProduct);
        }

        cart.clear();
    }

}
