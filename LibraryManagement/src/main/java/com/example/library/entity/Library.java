package com.example.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Library {
	
	@Id
	private int id;
	private int quantity;
	private String bookName;
	private String genre;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
