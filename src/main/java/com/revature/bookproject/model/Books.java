package com.revature.bookproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="books")
public class Books {
	@Id
	@GeneratedValue
	private long id;
	@Column(name="bookName")
	private String bookName;
	@Column(name="authorName")
	private String authorName;
	@Column(name="description")
	private String description;
	@Column(name="bookPages")
	private int bookPages;
	@Column(name="bookPrice")
	private double bookPrice;
	@Column(name="genre")
	private String genre;
	@Column(name="readingagefrom")
	private int readingAgeFrom;
	@Column(name="readingageto")
	private int readingAgeTo;
	@Column(name="stock")
	private long stock;
	@JsonIgnore
	@OneToMany(mappedBy="book",cascade = {CascadeType.ALL})
	private Set<OrderDetails> orderDetails=new HashSet<>();
	
	
    
	public Books(String bookName, String authorName, String description, int bookPages, double bookPrice, String genre,
			int readingAgeFrom, int readingAgeTo, long stock, Set<OrderDetails> orderDetails) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.description = description;
		this.bookPages = bookPages;
		this.bookPrice = bookPrice;
		this.genre = genre;
		this.readingAgeFrom = readingAgeFrom;
		this.readingAgeTo = readingAgeTo;
		this.stock = stock;
		this.orderDetails = orderDetails;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getBookPages() {
		return bookPages;
	}

	public void setBookPages(int bookPages) {
		this.bookPages = bookPages;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getReadingAgeFrom() {
		return readingAgeFrom;
	}

	public void setReadingAgeFrom(int readingAgeFrom) {
		this.readingAgeFrom = readingAgeFrom;
	}

	public int getReadingAgeTo() {
		return readingAgeTo;
	}

	public void setReadingAgeTo(int readingAgeTo) {
		this.readingAgeTo = readingAgeTo;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public void addOrderDetail(OrderDetails orderDetail)
	{
		this.orderDetails.add(orderDetail);
	}

}
