package com.sourav.ProductManager.controller;

import com.sourav.ProductManager.entity.Product;
import com.sourav.ProductManager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Product> listPoducts = productService.listAll();
        model.addAttribute("listProducts", listPoducts);
        return "index";
    }

    @RequestMapping("/new")
    public String showProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/";
    }
}
