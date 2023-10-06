package com.yixuan.receiptProcess.receiptProcess.controller;


import com.yixuan.receiptProcess.receiptProcess.model.Receipt;
import com.yixuan.receiptProcess.receiptProcess.model.dto.CreateReceiptResponseDto;
import com.yixuan.receiptProcess.receiptProcess.model.dto.GetPointsResponseDto;
import com.yixuan.receiptProcess.receiptProcess.service.ReceiptService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
public class ReceiptController {
	private final ReceiptService service;
	public ReceiptController(ReceiptService service ) {
		this.service = service;
	}
	@GetMapping("/receipts")
	public List<Receipt> retrieveAllReceipts() {
		return service.findAllReceipts();
	}
	@GetMapping("/receipts/{id}/points")
	public GetPointsResponseDto getReceiptPoints(@PathVariable UUID id) {
		int points = service.getReceiptPoints(id);
		return new GetPointsResponseDto(points);
	}
	@PostMapping(value = "/receipts/process", produces = "application/json")
	public CreateReceiptResponseDto createReceipt(@RequestBody  @Valid Receipt receipt) {
		Receipt saved = service.saveReceipt(receipt);
	    return new CreateReceiptResponseDto(saved.getId().toString());
	}

}
