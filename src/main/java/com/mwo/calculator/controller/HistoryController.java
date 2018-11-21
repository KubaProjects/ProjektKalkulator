package com.mwo.calculator.controller;

import com.mwo.calculator.model.StockCalc;
import com.mwo.calculator.service.HistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/hist")
public class HistoryController {

    @Autowired
    private HistoryServiceImpl historyServiceImpl;

    @GetMapping
    ResponseEntity<List<StockCalc>> histGet(@RequestParam(value = "limit", required = false) Integer limit, HttpSession session) {

        List<StockCalc> stockHistory = historyServiceImpl.getLastOperationsFromStackHistory(session, limit);

        if (stockHistory == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<StockCalc>>(stockHistory, HttpStatus.OK);
        }

    }

    @DeleteMapping(value = "/clear")
    public void clearHistory(HttpSession session) {
        historyServiceImpl.clearHistory(session);
    }

}
