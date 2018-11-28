package com.mwo.calculator.service;

import com.mwo.calculator.model.StockCalc;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Override
    public void addToStockHistory(HttpSession session, StockCalc stockCalc) {
        if (session.getAttribute("stockHistory") == null) {
            LinkedList<StockCalc> stockHistory = new LinkedList<StockCalc>();
            stockHistory.add(stockCalc);
            session.setAttribute("stockHistory", stockHistory);
        } else {
            LinkedList<StockCalc> stockHistory = (LinkedList<StockCalc>) session.getAttribute("stockHistory");

            if (stockHistory.size() < 100) {
                stockHistory.add(stockCalc);
            } else {
                stockHistory.poll();
                stockHistory.add(stockCalc);
            }
            session.setAttribute("stockHistory", stockHistory);
        }
    }

    @Override
    public List<StockCalc> getLastOperationsFromStackHistory(HttpSession session, Integer limit) {
        if (session.getAttribute("stockHistory") == null) {
            return null;
        } else {
            LinkedList<StockCalc> stockHistory = (LinkedList<StockCalc>) session.getAttribute("stockHistory");
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

    @Override
    public StockCalc getLastOperationFromStackHistory(HttpSession session) {
        if (session.getAttribute("stockHistory") == null) {
            return null;
        } else {
            LinkedList<StockCalc> stockHistory = (LinkedList<StockCalc>) session.getAttribute("stockHistory");
            return stockHistory.peekLast();
        }
    }

    @Override
    public StockCalc getFirstOperationFromStackHistory(HttpSession session) {
        if (session.getAttribute("stockHistory") == null) {
            return null;
        } else {
            LinkedList<StockCalc> stockHistory = (LinkedList<StockCalc>) session.getAttribute("stockHistory");
            return stockHistory.peekFirst();
        }
    }

    @Override
    public StockCalc getAndRemoveLastOperationFromStackHistory(HttpSession session) {
        if (session.getAttribute("stockHistory") == null) {
            return null;
        } else {
            LinkedList<StockCalc> stockHistory = (LinkedList<StockCalc>) session.getAttribute("stockHistory");
            return stockHistory.pollLast();
        }
    }

    @Override
    public StockCalc getAndRemoveFirstOperationFromStackHistory(HttpSession session) {
        if (session.getAttribute("stockHistory") == null) {
            return null;
        } else {
            LinkedList<StockCalc> stockHistory = (LinkedList<StockCalc>) session.getAttribute("stockHistory");
            return stockHistory.pollFirst();
        }
    }

    @Override
    public LinkedList<StockCalc> getStockHistory(HttpSession session) {
        return (LinkedList<StockCalc>) session.getAttribute("stockHistory");
    }

    @Override
    public void clearHistory(HttpSession session) {
        if (session.getAttribute("stockHistory") != null) {
            LinkedList<StockCalc> stockHistory = (LinkedList<StockCalc>) session.getAttribute("stockHistory");
            stockHistory.clear();
            session.setAttribute("stockHistory", stockHistory);
        }
    }
}
