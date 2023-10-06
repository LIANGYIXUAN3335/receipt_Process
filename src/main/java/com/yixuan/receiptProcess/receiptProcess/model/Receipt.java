package com.yixuan.receiptProcess.receiptProcess.model;
import com.yixuan.receiptProcess.receiptProcess.service.validator.ValidDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@ValidDateTime
public class Receipt {
	private UUID id;

	@NotNull(message = "Retailer cannot be null")
	@Size(min = 1, message = "Retailer cannot be empty")
	private String retailer;

	@NotNull(message = "Purchase date cannot be null")
	@PastOrPresent(message = "Purchase date cannot be in the future")
	private LocalDate purchaseDate;

	@NotNull(message = "Purchase time cannot be null")
	private LocalTime purchaseTime;

	@Valid
	@NotNull(message = "Items list cannot be null")
	private List<Item> items;

	@NotNull(message = "Total cannot be null")
	@Positive(message = "Total cannot be negative or zero")
	private double total;
}
