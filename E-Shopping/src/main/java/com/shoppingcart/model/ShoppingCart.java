package com.shoppingcart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="shoppingcart")
@EntityListeners(AuditingEntityListener.class)
public class ShoppingCart implements Serializable{
private static final long serialVersionUID = 1143993377101043360L;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String name;
private int qty;
private float price;


public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}

	public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
	
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getQty() {
	return qty;
}

public void setQty(int qty) {
	this.qty = qty;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}





}

