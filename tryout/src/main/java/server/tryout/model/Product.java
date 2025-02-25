package server.tryout.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

@Column(name="id")
int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public Product() {
	super();
}
@Column(name="name")
String pname;
public Product(String pname, int price, int quantity) {
	super();
	this.pname = pname;
	this.price = price;
	this.quantity = quantity;
}
@Column(name="price")
int price;
@Column(name="quantity")
int quantity;

}
