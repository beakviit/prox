package com.example.proxy;

import com.example.proxy.QuoteService;

public class CachedQuoteProxy implements QuoteService {
    private RealQuoteService realService;
    private String cachedQuote;

    @Override
    public String getQuote() {
        if (cachedQuote == null) {
            realService = new RealQuoteService();
            cachedQuote = realService.getQuote();
        }
        return cachedQuote;
    }
}
