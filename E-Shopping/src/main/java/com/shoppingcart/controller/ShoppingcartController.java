package com.shoppingcart.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shoppingcart.dao.ShoppingcartDAO;
import com.shoppingcart.model.ShoppingCart;

@RestController
@RequestMapping("/shopping")
public class ShoppingcartController {
@Autowired
ShoppingcartDAO shoppingcartDAO;


@PostMapping("/items")
public ShoppingCart createEmployee(@Valid @RequestBody ShoppingCart itm) {
return shoppingcartDAO.save(itm);
}


@GetMapping("/items")
public List<ShoppingCart> getAllItem(){
return shoppingcartDAO.findAll();
}

@GetMapping("/items/{id}")
public ResponseEntity<ShoppingCart> getShoppingCartById(@PathVariable(value="id") Long
itmId){
ShoppingCart itm = shoppingcartDAO.findOne(itmId);
if(itm==null) {
return ResponseEntity.notFound().build();
}
return ResponseEntity.ok().body(itm);
}

@PutMapping("/items/{id}")
public ResponseEntity<ShoppingCart> updateShoppingCart(@PathVariable(value="id") Long itmId,
@Valid @RequestBody ShoppingCart itmDetails){
ShoppingCart itm= shoppingcartDAO.findOne(itmId);
if(itm==null) {
return ResponseEntity.notFound().build();
}
itm.setName(itmDetails.getName());
itm.setQty(itmDetails.getQty());
itm.setPrice(itmDetails.getPrice());

ShoppingCart updaShoppingCart=shoppingcartDAO.save(itm);
return ResponseEntity.ok().body(updaShoppingCart);
}

@DeleteMapping("/items/{id}")
public ResponseEntity<ShoppingCart> deleteShoppingCarte(@PathVariable(value="id") Long itmId){
ShoppingCart itm = shoppingcartDAO.findOne(itmId);
if(itm==null) {
return ResponseEntity.notFound().build();
}
shoppingcartDAO.delete(itm);
return ResponseEntity.ok().build();
}
}