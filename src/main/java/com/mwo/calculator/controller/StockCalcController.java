package com.mwo.calculator.controller;

import com.mwo.calculator.model.StockCalc;
import com.mwo.calculator.service.HistoryServiceImpl;
import com.mwo.calculator.service.StockCalcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StockCalcController {

    @Autowired
    private StockCalcServiceImpl stockCalcService;

    @Autowired
    private HistoryServiceImpl historyServiceImpl;


    @PostMapping(name = "/calc")
    public ResponseEntity<Map<String, BigDecimal>> getLossGains(@RequestBody StockCalc stockCalc, HttpSession session) {

        BigDecimal result = stockCalcService.calculateLossGains(stockCalc.getBuyValue(), stockCalc.getBuyQuantity(), stockCalc.getSellValue(), stockCalc.getSellQuantity());

        HashMap<String, BigDecimal> resultMap = new HashMap<String, BigDecimal>();
        resultMap.put("result", result);

        historyServiceImpl.addToStockHistory(stockCalc);

        return new ResponseEntity<Map<String, BigDecimal>>(resultMap, HttpStatus.OK);
    }
}
