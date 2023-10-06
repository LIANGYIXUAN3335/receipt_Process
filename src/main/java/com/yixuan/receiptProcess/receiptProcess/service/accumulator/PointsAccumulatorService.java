package com.yixuan.receiptProcess.receiptProcess.service.accumulator;

import com.yixuan.receiptProcess.receiptProcess.model.Receipt;
import com.yixuan.receiptProcess.receiptProcess.service.calculator.PointsCalculator;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;
import java.util.List;

@Component
public class PointsAccumulatorService {

    private List<PointsCalculator> calculators;

    public PointsAccumulatorService(List<PointsCalculator> calculators) {
        this.calculators = calculators;
    }

    public int accumulate(Receipt receipt) {
        return calculators.stream()
                .map(calculator -> calculator.calculate(receipt))
                .mapToInt(Integer::intValue)
                .sum();
    }
    public List<Integer> getCalculatorPoints(Receipt receipt) {
        return calculators.stream()
                .map(calculator -> calculator.calculate(receipt))
                .collect(Collectors.toList());
    }

}
