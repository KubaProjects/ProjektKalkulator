package com.mwo.calculator.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class StockCalc implements Serializable {

    private Date timestamp;

    private String stockSymbol;

    private BigDecimal buyValue;

    private BigInteger buyQuantity;

    private BigDecimal sellValue;

    private BigInteger sellQuantity;

    public StockCalc() {
    }

    public StockCalc(Date timestamp, String stockSymbol, BigDecimal buyValue, BigInteger buyQuantity, BigDecimal sellValue, BigInteger sellQuantity) {
        this.timestamp = timestamp;
        this.stockSymbol = stockSymbol;
        this.buyValue = buyValue;
        this.buyQuantity = buyQuantity;
        this.sellValue = sellValue;
        this.sellQuantity = sellQuantity;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public BigDecimal getBuyValue() {
        return buyValue;
    }

    public void setBuyValue(BigDecimal buyValue) {
        this.buyValue = buyValue;
    }

    public BigInteger getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(BigInteger buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public BigDecimal getSellValue() {
        return sellValue;
    }

    public void setSellValue(BigDecimal sellValue) {
        this.sellValue = sellValue;
    }

    public BigInteger getSellQuantity() {
        return sellQuantity;
    }

    public void setSellQuantity(BigInteger sellQuantity) {
        this.sellQuantity = sellQuantity;
    }

    @Override
    public String toString() {
        return "StockCalc{" +
                "timestamp=" + timestamp +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", buyValue=" + buyValue +
                ", buyQuantity=" + buyQuantity +
                ", sellValue=" + sellValue +
                ", sellQuantity=" + sellQuantity +
                '}';
    }
}
