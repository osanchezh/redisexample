package com.buffer.rediscache.repo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "order_details")
public class Order implements Serializable {

	private static final long serialVersionUID = 214101981905645865L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String details;

	private int qty;

	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(details, id, price, qty);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(details, other.details) && id == other.id && price == other.price && qty == other.qty;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", details=" + details + ", qty=" + qty + ", price=" + price + "]";
	}

	public Order(int id, String details, int qty, long price) {
		super();
		this.id = id;
		this.details = details;
		this.qty = qty;
		this.price = price;
	}

	public Order() {
		super();
	}
	
}