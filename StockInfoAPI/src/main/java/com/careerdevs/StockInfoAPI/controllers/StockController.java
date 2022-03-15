package com.careerdevs.StockInfoAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/stocks") // all route handlers added to this controller/class will begin with this.

public class StockController {

    @Autowired
    private Environment env;

    @GetMapping("/overview")
    public Object getStockInfo(@RequestParam(required = false) String symbol, RestTemplate restTemplate) {

        // LINK SHOULD LOOK LIKE: https://www.alphavantage.co/query?function=OVERVIEW&symbol=IBM&apikey=demo

        // LOCALHOST EXAMPLE LINK: http://localhost:4500/api/stocks/overview?symbol=GOOGL

        return restTemplate.getForObject("https://www.alphavantage.co/query?function=OVERVIEW&symbol=" + symbol + "&apikey=" + env.getProperty("ALPHA_KEY"), Object.class);
    }

}
