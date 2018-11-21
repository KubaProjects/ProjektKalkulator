package com.mwo.calculator.service;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface StockCalcService {

    BigDecimal calculateLossGains(BigDecimal buyValue, BigInteger buyQuantity, BigDecimal sellValue, BigInteger sellQuantity);

}
