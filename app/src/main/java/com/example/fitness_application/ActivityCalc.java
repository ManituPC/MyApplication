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
    TextView tvAllResult;


    double weightPaste, weightChicken, weightMilk, weightBuckwheat;
    double resultPaste, resultChicken, resultMilk, resultBuckwheat, resultDay;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        // находим элементы
        etPaste = (EditText) findViewById(R.id.etPaste);
        etChicken = (EditText)findViewById(R.id.etChicken);
        etMilk = (EditText) findViewById(R.id.etMilk);
        etBuckwheat = (EditText) findViewById(R.id.etBuckwheat);

        btnPaste = (Button) findViewById(R.id.btnPaste);
        btnChicken = (Button) findViewById(R.id.btnChicken);
        btnMilk = (Button) findViewById(R.id.btnMilk);
        btnBuckwheat = (Button) findViewById(R.id.btnBuckwheat);
        btnNewProd = (Button) findViewById(R.id.btnNewProd);

        tvResult = (TextView) findViewById(R.id.tvResult);
        tvAllResult = (TextView) findViewById(R.id.tvAllResult);

        mResultCalc = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        // Bзвлечения данных
        if (mResultCalc.contains(APP_PREFERENCES_RESULT)) {
            // выводим данные в TextView
            tvAllResult.setText(mResultCalc.getString(APP_PREFERENCES_RESULT, ""));
            String strResultDay = tvAllResult.getText().toString();
            resultDay = Double.parseDouble(strResultDay);
        }
    }

    // определяем нажатую кнопку
    public void clickPaste(View v) {
        clickProd(etPaste, weightPaste, 2.88, resultPaste);
    }

    public void clickChick(View v) {
        clickProd(etChicken, weightChicken, 1.61, resultChicken);
    }

    public void clickMilk(View v) {
        clickProd(etMilk, weightMilk, 0.43, resultMilk);
    }

    public void clickBuckwheat(View v) {
        clickProd(etBuckwheat, weightBuckwheat, 1.37, resultBuckwheat);
    }

    public void clickNewProd(View v) {

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

    // метод для расчета при нажитии кнопки
    public void clickProd(EditText i, double a, double b, double c) {
        if (i.getText().length() == 0){
            i.setError("Заполните пустое поле");
        } else {
            a = Double.parseDouble(i.getText().toString());
            c = a * b;
            result = 0;
            result = result + c;
            tvResult.setText(" " + result);
            resultDay = resultDay + result;
            tvAllResult.setText(" " + resultDay);
        }
    }

    // кнопки сохранения "Суммы"
    public void onSaveClick(View v) {
        saveText();
    }

    void saveText() {
        // здесь содержится значение, введенное в текстовом поле
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
