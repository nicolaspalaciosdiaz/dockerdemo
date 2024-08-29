package com.example.demo.rest;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService theProductService) {
        this.productService = theProductService;

    }

    @RequestMapping("/showform")
    public String showForm() {
        return "showform";
    }

    // Expose "/products" and return a list of products
    @GetMapping("/products")
    public String findAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products-page";
    }

    // Get by id and show edit page
    // TODO change method name to something more fitting.
    @GetMapping("/products/{productId}")
    public String getProduct(@PathVariable int productId, Model model) {

        // Hämta id
        Product theProduct = productService.findById(productId);

        // Kolla om den finns
        if (theProduct == null) {
            throw new RuntimeException("The product with id : " + productId + " can't be found!");
        }

        // Returnera
        model.addAttribute("product", theProduct);
        return "edit-product-page";
//        return theProduct;
    }

    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute("product") @Valid Product theProduct, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "showform";
        }

        // Sätt id till 0 ifall man skickar in id
        theProduct.setId(0);

        productService.save(theProduct);

        return "redirect:/api/products";
    }

//    @PostMapping("/products/edit/{productId}")
//    public String updateProduct(@PathVariable("id") int id, @Valid Product product,
//                                BindingResult result, Model model) {
//
//        if (result.hasErrors()) {
//            product.setId(id);
//            return "edit-product-page";
//        }
//
//        productService.save(product);
//        return "redirect:/api/products";
//    }

    @PostMapping("/products/edit/{productId}")
    public String updateProduct(@PathVariable int productId, @ModelAttribute("product") @Valid Product product,
                                BindingResult result) {

        if (result.hasErrors()) {
            return "edit-product-page";
        }
        product.setId(productId);
        productService.save(product);
        return "redirect:/api/products";
    }

    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable int productId) {

        // Hämta id
        Product theProduct = productService.findById(productId);

        // Kolla om den finns
        if (theProduct == null) {
            throw new RuntimeException("The product with id : " + productId + " can't be found!");
        } else {
            // raderar producten
            productService.deleteById(productId);
        }
        // returnerar en bekräftelse på radering
        return "The Product with the id of: " + productId + " was deleted";
    }
}
