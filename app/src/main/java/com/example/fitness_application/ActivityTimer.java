package com.example.fitness_application;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Денис on 28.02.2017.
 */
public class ActivityTimer extends AppCompatActivity {

    private TextView mTextWork;
    private TextView mTextRest;
    private TextView mTextRound;
    private NumberPicker pickerSecWork;
    private NumberPicker pickerSecRest;
    private NumberPicker pickerRound;
    int n = 0;
    long secWork;
    long secRest;
    int numberRound;
    boolean mIsRunning = false;
    int mCurrentPeriod = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        mTextWork = (TextView) findViewById(R.id.textViewWork);
        mTextRest = (TextView) findViewById(R.id.textViewRest);
        mTextRound = (TextView) findViewById(R.id.textViewRound);
        pickerSecWork = (NumberPicker) findViewById(R.id.pickerWO);
        pickerSecRest = (NumberPicker) findViewById(R.id.pickerR);
        pickerRound = (NumberPicker) findViewById(R.id.pickerRound);
        pickerSecWork.setMinValue(0);
        pickerSecWork.setMaxValue(59);
        pickerSecRest.setMinValue(0);
        pickerSecRest.setMaxValue(59);
        pickerRound.setMinValue(0);
        pickerRound.setMaxValue(8);
        pickerSecWork.setOnValueChangedListener(onValueChangedWork);
        pickerSecRest.setOnValueChangedListener(onValueChangedRest);
//        pickerRound.setOnValueChangedListener(onValueChangedRound);
        numberRound = pickerRound.getValue();
    }

    // Реализация таймеров

    public void TimerWorkOut() {
        new CountDownTimer(secWork, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextWork.setText(" " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mTextWork.setText("Rest!");
                TimerRest();
            }
        }.start();
    }

    public void TimerRest() {
        new CountDownTimer(secRest, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextRest.setText(" " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mTextRest.setText("Just do it!");
                n++;
            }
        }.start();
    }

//    public void NumberRound() {
//        while (n <= numberRound) {
//            mTextRound.setText(" " + n);
//            n++;
//        }
//    }

    // Кнопки

    public void ClickStart(View view) {
        secWork = pickerSecWork.getValue() * 1000;
        secRest = pickerSecRest.getValue() * 1000;
        numberRound = pickerRound.getValue();

        while (n <= numberRound) {
            TimerWorkOut();
            mTextRound.setText(" " + n);
        }
    }

    public void ClickCancel(View v) {

    }

    // слушатели NumberPicker, и передача данных в TextWiew

    NumberPicker.OnValueChangeListener onValueChangedWork = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            if (!mIsRunning) {
                mTextWork.setText(intToTime(newVal));
                mCurrentPeriod = newVal;
            }
        }
    };

    NumberPicker.OnValueChangeListener onValueChangedRest = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            if (!mIsRunning) {
                mTextRest.setText(intToTime(newVal));
                mCurrentPeriod = newVal;
            }
        }
    };

//    NumberPicker.OnValueChangeListener onValueChangedRound = new NumberPicker.OnValueChangeListener() {
//        @Override
//        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
//            if (!mIsRunning) {
//                mTextRound.setText(strNumberRound(newVal));
//                mCurrentPeriod = newVal;
//            }
//        }
//    };

    // методы для чтения данных с NumberPicker

//    private String strNumberRound (int i) {
//        return (new String(String.valueOf(i)));
//    }

    private String intToTime(int i) {
        return (new SimpleDateFormat("ss")).format(new Date(i * 1000));
    }
}
