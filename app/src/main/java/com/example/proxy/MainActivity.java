package com.example.proxy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView quoteText;
    private Button fetchButton;
    private QuoteService quoteService = new CachedQuoteProxy();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quoteText = findViewById(R.id.quoteText);
        fetchButton = findViewById(R.id.fetchButton);

        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quoteText.setText("Жүктелуде...");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final String quote = quoteService.getQuote();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                quoteText.setText(quote);
                            }
                        });
                    }
                }).start();
            }
        });
    }
}
