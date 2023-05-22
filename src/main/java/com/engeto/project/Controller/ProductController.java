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

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(Product product) throws SQLException {
        //model.addAttribute("allProducts",productRepository.getAllProducts());
        return productRepository.getAllProducts();
    }

    @GetMapping("/product/{id}")               //FUNGUJE
    public Product getProductById(@PathVariable(value = "id") int id) throws SQLException {
        return productRepository.getProductById(id);
    }


    @PostMapping(value = "/product")
    public String saveProducts(@RequestBody Product product) throws SQLException {
        productRepository.saveProduct(product);
        return "Saved ...";
    }

    @PutMapping("/update_price")
    public String updateProducts(@RequestBody Product productForUpdate) throws SQLException {
        productRepository.update(productForUpdate.getId(), productForUpdate.getPrice());
        return "redirect:/";
    }

    @GetMapping("/delete_not_available_products")
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
