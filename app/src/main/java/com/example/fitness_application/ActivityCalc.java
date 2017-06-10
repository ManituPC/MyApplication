package com.example.fitness_application;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Денис on 28.02.2017.
 */
public class ActivityCalc extends AppCompatActivity {

    // имя файла настроек
    public static final String APP_PREFERENCES = "SettingsCalc";
    // результат
    public static final String APP_PREFERENCES_RESULT = "ResultCalc";

    SharedPreferences mResultCalc;

    EditText etPaste, etEggs, etChicken, etBeef, etPork, etHek, etMilk, etKefir, etCottageСheese,
            etRice, etOatmeal, etBuckwheat;

    Button btnPaste, btnEggs, btnChicken,  btnBeef, btnPork, btnHek, btnMilk, btnKefir,
            btnCottageСheese, btnRice, btnOatmeal, btnBuckwheat;

    TextView tvResult, tvAllResult;

    double weightPaste, weightEggs, weightChicken, weightBeef, weightPork, weightHek, weightMilk,
            weightKefir, weightCottageСheese, weightRice, weightOatmeal, weightBuckwheat;

    double resultPaste, resultEggs, resultChicken, resultBeef, resultPork, resultHek, resultMilk,
            resultKefir, resultCottageСheese, resultRice, resultOatmeal, resultBuckwheat, result,
            resultDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        // находим элементы
        etPaste = (EditText) findViewById(R.id.etPaste);
        etEggs = (EditText) findViewById(R.id.etEggs);
        etChicken = (EditText)findViewById(R.id.etChicken);
        etBeef = (EditText) findViewById(R.id.etBeef);
        etPork = (EditText) findViewById(R.id.etPork);
        etHek = (EditText) findViewById(R.id.etHek);
        etMilk = (EditText) findViewById(R.id.etMilk);
        etKefir = (EditText) findViewById(R.id.etKefir);
        etCottageСheese = (EditText) findViewById(R.id.etCottageСheese);
        etRice = (EditText) findViewById(R.id.etRice);
        etOatmeal = (EditText) findViewById(R.id.etOatmeal);
        etBuckwheat = (EditText) findViewById(R.id.etBuckwheat);

        btnPaste = (Button) findViewById(R.id.btnPaste);
        btnEggs = (Button) findViewById(R.id.btnEggs);
        btnChicken = (Button) findViewById(R.id.btnChicken);
        btnBeef = (Button) findViewById(R.id.btnBeef);
        btnPork = (Button) findViewById(R.id.btnPork);
        btnHek = (Button) findViewById(R.id.btnHek);
        btnMilk = (Button) findViewById(R.id.btnMilk);
        btnKefir = (Button) findViewById(R.id.btnKefir);
        btnCottageСheese = (Button) findViewById(R.id.btnCottageСheese);
        btnRice = (Button) findViewById(R.id.btnRice);
        btnOatmeal = (Button) findViewById(R.id.btnOatmeal);
        btnBuckwheat = (Button) findViewById(R.id.btnBuckwheat);

        tvResult = (TextView) findViewById(R.id.tvResult);
        tvAllResult = (TextView) findViewById(R.id.tvAllResult);

        mResultCalc = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        //Извлечения данных
        tvResult.setText("0");

        if (mResultCalc.contains(APP_PREFERENCES_RESULT)) {
            // выводим данные в TextView
            tvAllResult.setText(mResultCalc.getString(APP_PREFERENCES_RESULT, ""));
            String strResultDay = tvAllResult.getText().toString();
            resultDay = Double.parseDouble(strResultDay);
        } else {
            tvAllResult.setText("0");
        }
    }

    // определяем нажатую кнопку
    public void clickPaste(View v) {
        clickProd(etPaste, weightPaste, 2.88, resultPaste);
    }

    public void clickEggs(View view) {
        clickProd(etEggs, weightEggs, 1.53, resultEggs);
    }

    public void clickChick(View v) {
        clickProd(etChicken, weightChicken, 1.61, resultChicken);
    }

    public void clickBeef(View view) {
        clickProd(etBeef, weightBeef,1.91, resultBeef);
    }

    public void clicPork(View view) {
        clickProd(etPork, weightPork, 3.18, resultPork);
    }

    public void clickHek(View view) {
        clickProd(etHek, weightHek, 0.84, resultHek);
    }

    public void clickMilk(View v) {
        clickProd(etMilk, weightMilk, 0.43, resultMilk);
    }

    public void clickKefir(View view) {
        clickProd(etKefir, weightKefir, 0.37, resultKefir);
    }

    public void clickCottageСheese(View view) {
        clickProd(etCottageСheese, weightCottageСheese, 1.56, resultCottageСheese);
    }

    public void clickBuckwheat(View v) {
        clickProd(etBuckwheat, weightBuckwheat, 1.37, resultBuckwheat);
    }

    public void clickRice(View view) {
        clickProd(etRice, weightRice, 0.79, resultRice);
    }

    public void clickOatmeal(View view) {
        clickProd(etOatmeal, weightOatmeal, 0.93, resultOatmeal);
    }

    // метод для расчета при нажитии кнопки
    public void clickProd(EditText i, double a, double b, double c) {
        if (i.getText().length() == 0){
            i.setError("Заполните пустое поле");
        } else {
            a = Double.parseDouble(i.getText().toString());
            c = a * b;
            result = 0;
            result = result + c;
            tvResult.setText("" + result);
            resultDay = resultDay + result;
            tvAllResult.setText("" + resultDay);
            i.setText(null);
        }
    }

    // кнопки сохранения "Суммы"
    public void onSaveClick(View v) {
        saveText();
    }

    public void onResetClick(View v) {
        SharedPreferences.Editor editor = mResultCalc.edit();
        editor.clear();
        editor.apply();
        result = 0;
        resultDay = 0;
        tvResult.setText("0");
        tvAllResult.setText("0");
    }

    void saveText() {
        String strResultDay = tvAllResult.getText().toString();
        SharedPreferences.Editor editor = mResultCalc.edit();
        editor.putString(APP_PREFERENCES_RESULT, strResultDay);
        editor.apply();
        Toast.makeText(this, "Результат сохранен", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
    }
}
