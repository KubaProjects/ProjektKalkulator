package com.mwo.calculator.service;

import com.mwo.calculator.model.StockCalc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    LinkedList<StockCalc> stockHistory;

    @Autowired
    public HistoryServiceImpl() {
        stockHistory = new LinkedList<StockCalc>();
    }

    @Override
    public void addToStockHistory(StockCalc stockCalc) {

        if (stockHistory.size() < 100) {
            stockHistory.add(stockCalc);
        } else {
            stockHistory.poll();
            stockHistory.add(stockCalc);
        }
    }

    @Override
    public void clearHistory() {
        stockHistory.clear();
    }

    @Override
    public List<StockCalc> getLastOperationsFromStackHistory(Integer limit) {
        int sizeOfStackHistory = stockHistory.size();

        limit = (limit == null) ? sizeOfStackHistory : limit;
        limit = (limit < 0) ? 0 : limit;

        int start = sizeOfStackHistory - limit;

        if (start > 0) {
            return stockHistory.subList(start, sizeOfStackHistory);
        } else {
            return stockHistory.subList(0, sizeOfStackHistory);
        }
    }
}
