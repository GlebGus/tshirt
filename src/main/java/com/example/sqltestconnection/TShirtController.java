package com.example.sqltestconnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TShirtController {

    @Autowired
    private TShirtRepository tShirtRepository;

    @Autowired
    private TShirtsService tShirtsService;
    @Autowired
private ImageRepository imageRepository;
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
@PostMapping("/tshirts/delete/{id}")
public String deleteTShirt(@PathVariable Long id){
        tShirtRepository.deleteById(id);
return "redirect:/tshirts";
}


    @PostMapping("/tshirts/create")
    public String createTShirt(@ModelAttribute("tShirt") TShirt tShirt,
                               @RequestParam("file1") MultipartFile file1,
                               @RequestParam("file2") MultipartFile file2)  throws IOException{
        tShirtsService.saveTShirt(tShirt,file1,file2);
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
    @GetMapping("/tshirts/sortByAvailable")
    public String sortByAvailable(Model model, @RequestParam("available") String available) {
        List<TShirt> tShirts;
        if (available.equals("true")) {
            tShirts = tShirtRepository.findAllByOrderByAvailable();
        } else {
            tShirts = tShirtRepository.findAll();
        }
        model.addAttribute("tShirts", tShirts);
        return "tshirts";
    }
    @GetMapping("/tshirts/sortBySize")
    public String sortBySize(@RequestParam("size") String size, Model model) {
        List<TShirt> tShirts;
        if (size.isEmpty()) {
            tShirts = tShirtsService.getAllTShirts();
        } else {
            tShirts = tShirtsService.getTShirtsBySize(size);
        }
        model.addAttribute("tShirts", tShirts);
        return "tshirts";
    }
}
