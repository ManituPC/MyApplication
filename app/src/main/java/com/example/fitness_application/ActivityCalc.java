package com.example.fitness_application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Денис on 28.02.2017.
 */
public class ActivityCalc extends AppCompatActivity {

    EditText etPaste;
    EditText etChicken;
    EditText etMilk;
    EditText etBuckwheat;

    Button btnPaste;
    Button btnChicken;
    Button btnMilk;
    Button btnBuckwheat;
    Button btnNewProd;

    TextView tvResult;

    double weightPaste, weightChicken, weightMilk, weightBuckwheat;
    double resultPaste, resultChicken, resultMilk, resultBuckwheat;
    double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        // находим элементы
        etPaste = (EditText) findViewById(R.id.etPaste);
        etChicken = (EditText) findViewById(R.id.etChicken);
        etMilk = (EditText) findViewById(R.id.etMilk);
        etBuckwheat = (EditText) findViewById(R.id.etBuckwheat);

        btnPaste = (Button) findViewById(R.id.btnPaste);
        btnChicken = (Button) findViewById(R.id.btnChicken);
        btnMilk = (Button) findViewById(R.id.btnMilk);
        btnBuckwheat = (Button) findViewById(R.id.btnBuckwheat);
        btnNewProd = (Button) findViewById(R.id.btnNewProd);

        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    // метод для расчета при нажитии кнопки
    public void clickProd(EditText i, double a, double b) {
        if (i.getText().length() == 0){
            i.setError("Заполните пустое поле");
        } else {
            a = Double.parseDouble(i.getText().toString());
            b = a * 2;
            result = result + b;
            tvResult.setText(" " + result);
        }
    }

    // определяем нажатую кнопку
    public void clickPaste(View v) {
        clickProd(etPaste, weightPaste, resultPaste);
    }

    public void clickChick(View v) {
        clickProd(etChicken, weightChicken, resultChicken);
    }

    public void clickMilk(View v) {
        clickProd(etMilk, weightMilk, resultMilk);
    }

    public void clickBuckwheat(View v) {
        clickProd(etBuckwheat, weightBuckwheat, resultBuckwheat);
    }

    public void clickNewProd(View v) {

    }
}
