package cz.ptnavratil.upce.inpia.cvc05eshop.controller;

import cz.ptnavratil.upce.inpia.cvc05eshop.dao.OrderFormDao;
import cz.ptnavratil.upce.inpia.cvc05eshop.model.OrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrderFormController {

    @Autowired
    private OrderFormDao orderFormDao;

    @GetMapping("/order-form")
    public String getOrderForms(Model model){

        List<OrderForm> listOfOrderForms = orderFormDao.findAll();
        model.addAttribute("listOfOrderForms",listOfOrderForms);

        return "order-form-list";
    }



}
