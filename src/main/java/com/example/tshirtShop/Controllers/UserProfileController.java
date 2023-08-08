package com.example.tshirtShop.Controllers;

import com.example.tshirtShop.Entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserProfileController {
    @GetMapping("/profile")
    public String showUserProfile(Model model, Principal principal) {
        String email = principal.getName(); // Получение email текущего пользователя
        model.addAttribute("user", new User(email)); // Передача email в модель Thymeleaf
        return "profile";

    }
}
