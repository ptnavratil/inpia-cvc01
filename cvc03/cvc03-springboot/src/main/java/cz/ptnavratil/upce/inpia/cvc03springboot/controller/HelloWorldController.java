package cz.ptnavratil.upce.inpia.cvc03springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @GetMapping("/")
    @ResponseBody
    public String sayHello() {
        return "<html><head><link rel=\"stylesheet\" href=\"./style.css\" /></head><body>Hello world</body>";
    }
}
