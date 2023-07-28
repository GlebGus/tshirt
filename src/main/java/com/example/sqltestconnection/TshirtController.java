package com.example.sqltestconnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TshirtController {

    @Autowired
    private TShirtRepository tShirtRepository;

    @GetMapping("/tshirts")
    public String getAllTShirts(Model model) {
        List<TShirt> tShirts = tShirtRepository.findAll();
        model.addAttribute("tShirts", tShirts);
        return "tshirts";
    }

    @GetMapping("/tshirts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("tShirt", new TShirt());
        return "create-tshirt";
    }

    @PostMapping("/tshirts/create")
    public String createTShirt(@ModelAttribute("tShirt") TShirt tShirt) {
        tShirtRepository.save(tShirt);
        return "redirect:/tshirts";
    }
    @GetMapping("/tshirts/sortByPrice")
    public String sortByPrice(Model model, @RequestParam("order") String order) {
        List<TShirt> tShirts;
        if (order.equals("asc")) {
            tShirts = tShirtRepository.findAllByOrderByPriceAsc();
        } else {
            tShirts = tShirtRepository.findAllByOrderByPriceDesc();
        }
        model.addAttribute("tShirts", tShirts);
        return "tshirts";
    }

}


//    @GetMapping("/tshirts/sort")
//    public String sortTShirts(@RequestParam("sortBy") String sortBy, Model model){
//        List<TShirt> tShirts;
//        if (sortBy.equals("priceDesc")){
//            tShirts = tShirtRepository.findAllByOrderByPriceDesc();
//        }else if (sortBy.equals("priceAsc")){
//            tShirts = tShirtRepository.findAllByOrderByPriceAsc();
//        }else if (sortBy.equals("size")){
//            tShirts = tShirtRepository.findAllByOrderBySize();
//        }else if (sortBy.equals("available")){
//            tShirts = tShirtRepository.findAllByOrderByAvailable();
//        }else {
//            tShirts = tShirtRepository.findAll();
//        }
//        model.addAttribute("tShirts", tShirts);
//        return "tShirts";
