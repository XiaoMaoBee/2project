package com.engeto.project.Repository;

import com.engeto.project.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    public ProductRepository() throws SQLException {
    }

    Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/eshop",
            "root",
            "3465");
    Statement statement = connection.createStatement();

    // 1. load all available items
    //Vrací seznam (list) všech druhů zboží v evidenci (v databázové tabulce)
    public List<Product> getAllProducts() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

        List<Product> allProducts = new ArrayList<>();

        while (resultSet.next()) {
            Product product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("Name"));
            product.setPartNo(resultSet.getInt("PartNo"));
            product.setDescription(resultSet.getString("Description"));
            product.setisForSale(resultSet.getBoolean("IsForSale"));
            product.setPrice(resultSet.getBigDecimal("Price"));
            allProducts.add(product);
        }
        return allProducts;
    }

    // 2. load product by ID
    //Vrátí informace o produktu se zadaným ID.
    public Product getProductById(int id) throws SQLException {
        String query = "select * from products where id= " + id;
        ResultSet resultSet = statement.executeQuery(query);
        Product product = new Product();
        if (resultSet.next()) {
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("Name"));
            product.setPartNo(resultSet.getInt("PartNo"));
            product.setDescription(resultSet.getString("Description"));
            product.setisForSale(resultSet.getBoolean("IsForSale"));
            product.setPrice(resultSet.getBigDecimal("Price"));
        }
        return product;
    }

    // 3. save item
    //Přidá do databáze nový produkt.
    //Jako parametr dostane objekt třídy Product.

    public void saveProduct(Product product) throws SQLException {
        String query = "INSERT INTO products (Name, PartNo, Description,IsForSale,Price ) VALUES ('"
                + product.getName() + "', '"
                + product.getPartNo() + "', '"
                + product.getDescription() + "', '"
                + (product.getisForSale() ? 1:0) + "', '"
                + product.getPrice() + "')";
        statement.executeUpdate(query);
    }

    // 4. update price by ID
    //Změní cenu uvedeného produktu.
    //Jako parametry vyžaduje ID produktu a novou cenu.

    public void update(int id, BigDecimal price) throws SQLException {
        String query = "UPDATE products SET "
                + "Price = '" + price + "' WHERE id = " + id;
        statement.executeUpdate(query);
    }


    // 5. delete out of sale items
    //Odstraní z databázové tabulky záznamy o produktech, které již nenabízíme (is for sale je false)

    public void deleteOutOfStock() throws SQLException {
        String query = "DELETE FROM products WHERE IsForSale = " + false;
        statement.executeUpdate(query);
    }

    public void deleteAll() throws SQLException {
        String query = "delete from products";
        statement.executeUpdate(query);
    }
}


