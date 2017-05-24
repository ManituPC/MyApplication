package com.example.fitness_application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Денис on 28.02.2017.
 */
public class ActivityCalc extends AppCompatActivity {

    private TextView Sum;
    private double a, b, c, d;
    private double n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Sum = (TextView) findViewById(R.id.textView9);
    }

    public void ClickMilk(View view) {
       a = 60;
       n = n + a;
       String N = Double.toString(n);
       Sum.setText("Сумма: " + N);
    }

    public void ClickChick(View view) {
        b = 200;
        n = n + b;
        String N = Double.toString(n);
        Sum.setText("Сумма: " + N);
    }

    public void ClickBuckwheat(View view) {
        c = 132;
        n = n + c;
        String N = Double.toString(n);
        Sum.setText("Сумма: " + N);
    }

    public void ClickPaste(View view) {
        d = 588;
        n = n + d;
        String N = Double.toString(n);
        Sum.setText("Сумма: " + N);
    }

    public void ClickNewProd(View view) {

    }
}
