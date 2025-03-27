package com.ecom.ecom_utilities.service;

import com.ecom.ecom_utilities.entity.Item;
import com.ecom.ecom_utilities.entity.LoginData;
import com.ecom.ecom_utilities.entity.RegistrationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ecomService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveUser(RegistrationData regData){
        String sql = "INSERT INTO online_shopping.customers (name, email, phone, address) VALUES (?, ?, ?, ?)";
         jdbcTemplate.update(sql, regData.getName(), regData.getEmail(), 
                regData.getPhone(), regData.getAddress());
    }

    public int loginUser(LoginData loginData){
        String sql = "select COUNT(customer_id) from online_shopping.customers where name=?";
        return jdbcTemplate.queryForObject(sql, new Object[] {loginData.getUsername()}, Integer.class);
    }

    public void saveItem(Item item){
        String sql = "INSERT INTO online_shopping.products (name, description, price, stock) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, item.getName(), item.getDescription(),
                item.getPrice(), item.getStock());
    }

    public void updateItem(Item item){
        String sql = "UPDATE online_shopping.products SET description=?, stock=?, price=? WHERE name=? ";
        jdbcTemplate.update(sql, item.getDescription(),
                item.getStock(), item.getPrice(), item.getName());
    }

    public int deleteItem(String name){
        String sql = "DELETE from online_shopping.products where name=?";
        return jdbcTemplate.update(sql, name);
    }

    public Item getItem(String name){
        String sql = "SELECT * from online_shopping.products where name=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{name},(rs, rowNum) -> {
            Item item = new Item();
            item.setName(rs.getString("name"));
            item.setDescription(rs.getString("description"));
            item.setPrice(rs.getDouble("price"));
            item.setStock(rs.getInt("stock"));
            return item;
        });
    }

    public List<Item> getItems(){
        String sql = "SELECT * from online_shopping.products";
        return jdbcTemplate.query(sql,(rs, rowNum) -> {
            Item item = new Item();
            item.setName(rs.getString("name"));
            item.setDescription(rs.getString("description"));
            item.setPrice(rs.getDouble("price"));
            item.setStock(rs.getInt("stock"));
            return item;
        });
    }
}
