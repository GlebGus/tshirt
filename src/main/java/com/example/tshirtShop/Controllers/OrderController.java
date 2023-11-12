package com.example.tshirtShop.Controllers;

import com.example.tshirtShop.Entities.Order;
import com.example.tshirtShop.Entities.TShirt;
import com.example.tshirtShop.Entities.User;
import com.example.tshirtShop.Repositories.OrderRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/cart/create", method = RequestMethod.POST)
    public String createOrder(@RequestParam("nameOfUser") String nameOfUser,
                              @RequestParam("postOffice") String postOffice,
                              @RequestParam("postalCode") String postalCode,
                              @RequestParam("phoneNumber") String phoneNumber,
                              HttpSession session) {
        List<TShirt> cartItems = (List<TShirt>) session.getAttribute("cartItems");
        if (cartItems == null || cartItems.isEmpty()) {
            // Если нет товаров, то возвращаем ошибку или перенаправляем на страницу с сообщением об ошибке
            return "redirect:/error";
        }

        Order order = new Order();
        order.setNameOfUser(nameOfUser);
        order.setPostOffice(postOffice);
        order.setPostalCode(postalCode);
        order.setPhoneNumber(phoneNumber);
        order.setOrderStatus(Order.OrderStatus.PROCESSING);
        User user = (User) session.getAttribute("user");
        order.setUser(user);
        order.setTshirts(cartItems);
        orderRepository.save(order);
        session.removeAttribute("cartItems");

        return "redirect:/tshirts";
    }

    @GetMapping("/orders")
    public String getAllOrders(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "orders";
    }
}
