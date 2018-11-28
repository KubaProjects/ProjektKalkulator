package com.mwo.calculator.service;

import com.mwo.calculator.model.StockCalc;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

public interface HistoryService {

    void addToStockHistory(StockCalc stockCalc);

    List<StockCalc> getLastOperationsFromStackHistory(Integer limit);

    void clearHistory();
}
