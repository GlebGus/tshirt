package com.example.tshirtShop.Controllers;

import com.example.tshirtShop.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class DeliveryController {


    @GetMapping("/delivery")
    public String showDeliveryForm(Model model) {
        List<String> streets = getAllStreets();
        model.addAttribute("streets", streets);
        return "delivery-form";
    }
    public List<String> getAllStreets() {
        return null;  // здесь нужно реализовать логику получения списка всех улиц Минска
        // и вернуть его
    }
}
