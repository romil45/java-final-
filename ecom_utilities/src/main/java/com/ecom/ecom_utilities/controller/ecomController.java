package com.ecom.ecom_utilities.controller;

import com.ecom.ecom_utilities.service.ecomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ecom_utilities.entity.Item;
import com.ecom.ecom_utilities.entity.LoginData;
import com.ecom.ecom_utilities.entity.RegistrationData;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ecomController {

	@Autowired
	ecomService ecomServiceObject;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody RegistrationData regData) {
		System.out.print("Registration Data:" + regData.getName());
		ecomServiceObject.saveUser(regData);
		return ResponseEntity.ok("User registered successfully: " + regData.name);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginData loginData) {
		System.out.print("Login Data:" + loginData.getUsername());
		if(ecomServiceObject.loginUser(loginData) > 0){
			return ResponseEntity.ok("User Logged In successfully.");
		}else {
			return ResponseEntity.ok("User is not registerd!!!");
		}

	}

	@PostMapping("/addItem")
	public ResponseEntity<String> addItem(@RequestBody Item item) {
		System.out.print("Item Data:" + item);
		ecomServiceObject.saveItem(item);
		return ResponseEntity.ok("Item stored successfully");
	}

	@PostMapping("/updateItem")
	public ResponseEntity<String> updateItem(@RequestBody Item item) {
		System.out.print("update item Data:" + item);
		ecomServiceObject.updateItem(item);
		return ResponseEntity.ok("Item updated successfully");
	}

	@DeleteMapping("/deleteItems/{name}")
	public ResponseEntity<String> deleteItem(@PathVariable String name) {

		if (ecomServiceObject.deleteItem(name) > 0) {
			return ResponseEntity.ok("Item deleted successfully");
		} else {
			return ResponseEntity.status(404).body("Item not found!!!");
		}
	}

	@GetMapping("/getItem/{name}")
	public ResponseEntity<Item> readItems(@PathVariable String name) {

		return ResponseEntity.ok(ecomServiceObject.getItem(name));
	}

	@GetMapping("/getItems")
	public ResponseEntity<List<Item>> readItems() {
		return ResponseEntity.ok(ecomServiceObject.getItems());
	}
}
