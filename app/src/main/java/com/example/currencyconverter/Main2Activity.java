package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main2Activity extends AppCompatActivity {

    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView2 = (TextView) findViewById(R.id.textView2);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message");

        Double dollars = Double.parseDouble(str);
        Double pounds = dollars * 0.77;

        BigDecimal bd = BigDecimal.valueOf(pounds);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        pounds = bd.doubleValue();

        DecimalFormat df = new DecimalFormat("#.00");


        textView2.setText("£ " + df.format(pounds));
    }
}
