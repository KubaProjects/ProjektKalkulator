package com.mwo.calculator.service;

import com.mwo.calculator.model.StockCalc;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

public interface HistoryService {

    void addToStockHistory(HttpSession session, StockCalc stockCalc);

    List<StockCalc> getLastOperationsFromStackHistory(HttpSession session, Integer limit);

    StockCalc getLastOperationFromStackHistory(HttpSession session);

    StockCalc getFirstOperationFromStackHistory(HttpSession session);

    StockCalc getAndRemoveLastOperationFromStackHistory(HttpSession session);

    StockCalc getAndRemoveFirstOperationFromStackHistory(HttpSession session);

    LinkedList<StockCalc> getStockHistory(HttpSession session);

    void clearHistory(HttpSession session);
}
