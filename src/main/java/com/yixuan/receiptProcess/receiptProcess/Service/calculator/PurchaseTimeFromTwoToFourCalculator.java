package com.yixuan.receiptProcess.receiptProcess.Service.calculator;

import com.yixuan.receiptProcess.receiptProcess.Model.Receipt;
import org.springframework.stereotype.Component;

@Component
public class PurchaseTimeFromTwoToFourCalculator implements PointsCalculator{
    @Override
    public int calculate(Receipt receipt) {
        int points = 0;
        if(receipt.getPurchaseTime().getHour()== 14 || receipt.getPurchaseTime().getHour() == 15) {
            points += 10;
        }
        if(receipt.getPurchaseTime().getHour()==16 && receipt.getPurchaseTime().getMinute()==0){
            points +=10;
        }
        return points;
    }
}