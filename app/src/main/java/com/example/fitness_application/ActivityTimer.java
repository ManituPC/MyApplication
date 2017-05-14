package com.example.fitness_application;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Денис on 28.02.2017.
 */
public class ActivityTimer extends AppCompatActivity {

    private TextView mTextField;
    private NumberPicker PickerSecWork;
    private NumberPicker PickerSecRest;
    long secWork;
    long secRest;
    boolean mIsRunning = false;
    int mCurrentPeriod = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        mTextField = (TextView) findViewById(R.id.textView10);
        PickerSecWork = (NumberPicker) findViewById(R.id.PickerWO);
        PickerSecRest = (NumberPicker) findViewById(R.id.PickerR);
        PickerSecWork.setMinValue(0);
        PickerSecWork.setMaxValue(59);
        PickerSecRest.setMinValue(0);
        PickerSecRest.setMaxValue(59);
        PickerSecWork.setOnValueChangedListener(onValueChanged);
//        secWork = PickerSecWork.getValue();
//        secRest = PickerSecRest.getValue();
        int value = PickerSecWork.getValue();
        secWork = Long.parseLong(String.valueOf(value));
    }

    public void TimerWorkOut() {
        new CountDownTimer(secWork, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText(" " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mTextField.setText("Rest!");
            }
        }.start();
    }

    public void TimerRest() {
        new CountDownTimer(secRest, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText(" " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mTextField.setText("Just do it!");
            }
        }.start();
    }

    public void ClickStart(View view) {
        TimerWorkOut();
        if(secWork == 0) {
            TimerRest();
        }
    }

    public void ClickCancel(View v) {

    }

    NumberPicker.OnValueChangeListener onValueChanged = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            if (!mIsRunning) {
                mTextField.setText(intToTime(newVal));
                mCurrentPeriod = newVal;
            }
        }
    };



    private String intToTime(int i) {
        return (new SimpleDateFormat("ss")).format(new Date(i * 1000));
    }
}
