package com.mwo.calculator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class StockCalcServiceImpl implements StockCalcService {

    @Override
    public BigDecimal calculateLossGains(BigDecimal buyValue, BigInteger buyQuantity, BigDecimal sellValue, BigInteger sellQuantity) {
        BigDecimal buy = buyValue.multiply(new BigDecimal(buyQuantity));
        BigDecimal sell = sellValue.multiply(new BigDecimal(sellQuantity));
        return sell.subtract(buy);
    }

}
