package com.engeto.project.Controller;

import com.engeto.project.model.Product;
import com.engeto.project.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/product/{id}")               //FUNGUJE
    public Product getProductById(@PathVariable(value = "id") int id) throws SQLException {
        return productRepository.getProductById(id);
    }

//    @PostMapping(value = "/product")
//    public String saveProducts(@RequestBody Product product) throws SQLException {
//        productRepository.saveProduct(product);
//        return "Saved ...";
//    }
//
    @PostMapping(value = "/product")
    public String saveProducts(@RequestBody Product product) throws SQLException {
        productRepository.saveProduct(product);
        return "Saved ...";
    }

    @PostMapping("/update_price")    //FUNGUJE
    public String updateProducts(@ModelAttribute("product") Product product) throws SQLException {
        productRepository.update(15,BigDecimal.valueOf(2356));
        return "redirect:/";
    }

    @GetMapping("/delete_not_available_products")   //FUNGUJE
    public String deleteProducts() throws SQLException {
        productRepository.deleteOutOfStock();
        return "deleted ...";
    }

    @GetMapping("/delete_all_products")
    public String deleteAll() throws SQLException {
        productRepository.deleteAll();
        return "all deleted ...";
    }
}
