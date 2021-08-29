package com.revature.bookproject.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="order_details")
public class OrderDetails {
	
	@Id
	@GeneratedValue
	private int oid;
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="book_id")
	private Books book;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="order_id")
	private Order order;
	
	private long quantity;
	private double subTotal;
	

	public OrderDetails(Books book, Order order, long quantity, double subTotal) {
		super();
		this.book = book;
		this.order = order;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	

}
