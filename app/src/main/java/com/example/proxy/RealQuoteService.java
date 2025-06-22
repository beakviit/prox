package com.example.proxy;
import com.example.proxy.QuoteService;

public class RealQuoteService implements QuoteService {
    @Override
    public String getQuote() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Ерлік – елге мұра, ұрпаққа – үлгі.";
    }
}
