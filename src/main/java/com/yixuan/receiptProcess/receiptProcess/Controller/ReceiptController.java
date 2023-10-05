package com.yixuan.receiptProcess.receiptProcess.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.yixuan.receiptProcess.receiptProcess.Model.Item;
import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import com.yixuan.receiptProcess.receiptProcess.Service.ReceiptService;
import com.yixuan.receiptProcess.receiptProcess.Repository.ReceiptRepository;
import com.yixuan.receiptProcess.receiptProcess.Service.accumulator.PointsAccumulatorService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;


@RestController
public class ReceiptController {

	private ReceiptService service;
	private ReceiptRepository repository;
	private PointsAccumulatorService accumulator;

	public ReceiptController(ReceiptService service,ReceiptRepository repository,PointsAccumulatorService accumulator ) {

		this.service = service;
		this.repository=repository;
		this.accumulator = accumulator;
	}

	@GetMapping("/receipts")
	public List<Receipt> retrieveAllReceipts() {
		return repository.findAll();
	}

	@GetMapping("/receipts/{id}/points")
	@ResponseBody
	public HashMap<String, Integer> retrieveReceipt(@PathVariable UUID id) {
		return service.getReceiptPoints(id);
	}


	@PostMapping("/receipts/process")
	public ResponseEntity<?> createReceipt(@RequestBody  @Valid Receipt receipt) {

	    receipt.setId(UUID.randomUUID());
	    repository.save(receipt);
	    HashMap<String, UUID> map = new HashMap<>();
	    map.put("id", receipt.getId());
	    return ResponseEntity.ok(map);
	}

}
