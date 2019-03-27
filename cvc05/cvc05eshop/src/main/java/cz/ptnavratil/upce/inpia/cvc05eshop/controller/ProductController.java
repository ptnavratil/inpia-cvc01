package cz.ptnavratil.upce.inpia.cvc05eshop.controller;

import cz.ptnavratil.upce.inpia.cvc05eshop.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.PostConstruct;

@Controller
public class ProductController {

    @Autowired
    private ProductDao productDao;


    @GetMapping("/")
    public String showAllProducts(Model model){
        model.addAttribute("products",productDao.findAll());
        return "product-list";
    }

    @GetMapping("/product/detail/{id}")
    public String showProductDetail(@PathVariable("id") Integer id, Model model){
        model.addAttribute("product",productDao.findById(id).get());

        return "product-detail";
    }

}
