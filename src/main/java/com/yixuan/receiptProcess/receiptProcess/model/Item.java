package com.yixuan.receiptProcess.receiptProcess.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
	@NotNull(message = "Short description cannot be null")
	@Size(min = 1, message = "Short description cannot be empty")
	private String shortDescription;

	@NotNull(message = "Price cannot be null")
	@PositiveOrZero(message = "Price cannot be negative")
	private Double price;

}
