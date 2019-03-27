package cz.ptnavratil.upce.inpia.cvc05eshop.controller;

import cz.ptnavratil.upce.inpia.cvc05eshop.dao.ProductDao;
import cz.ptnavratil.upce.inpia.cvc05eshop.model.Product;
import cz.ptnavratil.upce.inpia.cvc05eshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import java.util.Optional;

@Controller
public class CartController {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String showCart( Model model){

        Map<Product,Integer> productsInCart = cartService.getProductsInCart();
        model.addAttribute("productsInCart",productsInCart);

        return "cart-list";
    }

    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable("id") Integer id, Model model){
        Optional<Product> selectedProductOptional = productDao.findById(id);
        if(selectedProductOptional.isPresent()){
            Product selectedProduct = selectedProductOptional.get();
            cartService.addProductToCart(selectedProduct,1);
        }
        return "cart-add";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable("id") Integer id, Model model){
        Optional<Product> selectedProductOptional = productDao.findById(id);
        if(selectedProductOptional.isPresent()){
            Product selectedProduct = selectedProductOptional.get();
            cartService.removeProductFromCart(selectedProduct,1);
        }
        return "cart-remove";
    }


    @GetMapping("/cart/checkout")
    public String cartCheckout(){
        cartService.checkout();

        return "cart-checkout";
    }


}
