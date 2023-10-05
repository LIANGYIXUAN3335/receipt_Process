package com.yixuan.receiptProcess.receiptProcess.Model;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

public class Item {
	@NotNull(message = "Short description cannot be null")
	@Size(min = 1, message = "Short description cannot be empty")
	private String shortDescription;

	@NotNull(message = "Price cannot be null")
	@PositiveOrZero(message = "Price cannot be negative")
	private Double price;
	
//	@ManyToOne
//	@JsonIgnore
//	private Receipt receipt;
	
	public Item(String shortDescription, Double price) {
		super();
		this.shortDescription = shortDescription;
		this.price = price;
	}
	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}



}
