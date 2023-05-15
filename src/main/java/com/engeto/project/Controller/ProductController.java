package com.engeto.project.Controller;

import com.engeto.project.Product;
import com.engeto.project.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

//    @Autowired
//    public ProductController(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World";
    }


//    @GetMapping("/products")
//    public List<Product> getAllProducts(Model model) throws SQLException {
//        //model.addAttribute("allProducts",productRepository.getAllProducts());
//        return productRepository.getAllProducts();
//    }

    @GetMapping("/products")
    public List<Product> getAllProducts(Product product) throws SQLException {
        //model.addAttribute("allProducts",productRepository.getAllProducts());
        return productRepository.getAllProducts();
    }

//    @GetMapping("/products/{id}")
//    public Product getProductById(@RequestParam int id) throws SQLException {
//        return productRepository.getProductById(id);
//    }

    @GetMapping("/products/{id}")
    public Product getProductById(@RequestParam(value = "id") int id) throws SQLException {
        return productRepository.getProductById(id);
    }

    @PostMapping(value = "/save")
    public String saveProducts(@RequestBody Product product) throws SQLException {
        productRepository.saveProduct(product);
        return "Saved ...";
    }

    @PostMapping("/update_price")    //FUNGUJE
    public String updateProducts(@ModelAttribute("product") Product product) throws SQLException {
        productRepository.update(5,BigDecimal.valueOf(356));
        return "redirect:/";
    }

    @GetMapping("/deleteProducts")   //FUNGUJE
    public String deleteProducts() throws SQLException {
        productRepository.deleteOutOfStock();
        return "redirect:/";
    }
}
