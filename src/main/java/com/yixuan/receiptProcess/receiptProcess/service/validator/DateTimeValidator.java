package com.yixuan.receiptProcess.receiptProcess.service.validator;

import com.yixuan.receiptProcess.receiptProcess.model.Receipt;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.LocalTime;


public class DateTimeValidator implements ConstraintValidator<ValidDateTime, Receipt> {

    @Override
    public boolean isValid(Receipt receipt, ConstraintValidatorContext context) {
        if (receipt == null) {
            return true;
        }

        LocalDate purchaseDate = receipt.getPurchaseDate();
        LocalTime purchaseTime = receipt.getPurchaseTime();

        if (purchaseDate == null || purchaseTime == null) {
            return true;
        }

        // If the purchase date is today, check the time
        if (LocalDate.now().equals(purchaseDate) && LocalTime.now().isBefore(purchaseTime)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Purchase time cannot be in the future for today's date.")
                    .addPropertyNode("purchaseTime").addConstraintViolation();
            return false;
        }

        return true;
    }
}


