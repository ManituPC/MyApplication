package com.example.fitness_application;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Денис on 28.02.2017.
 */
public class ActivityTimer extends AppCompatActivity implements SoundPool.OnLoadCompleteListener {

    private TextView mTextWork;
    private TextView mTextRest;
    private TextView mTextRound;
    private NumberPicker pickerSecWork;
    private NumberPicker pickerSecRest;
    private NumberPicker pickerRound;
    int n = 1;
    long secWork;
    long secRest;
    int numberRound;
    boolean mIsRunning = false;
    int mCurrentPeriod = 0;

    final String LOG_TAG = "myLogs";

    SoundPool sp;
    int soundWork;
    int soundRest;

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

        sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        sp.setOnLoadCompleteListener(this);

        soundWork = sp.load(this, R.raw.zvonok, 1);
        soundRest = sp.load(this, R.raw.old, 1);

    }

    public void playMusicWork() {
        sp.play(soundWork, 1, 1, 0, 1, 1);
    }

    public void playMusicRest() {
        sp.play(soundRest, 1, 1, 0, 1, 1);
    }

    // Реализация таймеров
    public void TimerWorkOut() {
        new CountDownTimer(secWork, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextWork.setText(" " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                playMusicWork();
                mTextWork.setText("Rest!");
                TimerRest();
            }
        }.start();
    }

    public void TimerRest() {
        new CountDownTimer(secRest, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextRest.setText(" " + millisUntilFinished / 1000);
//                int last = Integer.parseInt(mTextRest.getText().toString());
                if(millisUntilFinished < 7)
                    playMusicRest();
            }

            public void onFinish() {
                playMusicRest();
                mTextRest.setText("Just do it!");
                if(n < numberRound) {
                    TimerWorkOut();
                    n++;
                }
                mTextRound.setText("№" + n);
            }
        }.start();
    }

    // Кнопки
    public void ClickStart(View view) {
        secWork = pickerSecWork.getValue() * 1000;
        secRest = pickerSecRest.getValue() * 1000;
        numberRound = pickerRound.getValue();
        TimerWorkOut();
        mTextRound.setText("№" + n);
    }

    public void ClickCancel(View v) {
        secWork = 0;
        secRest = 0;
        n = 0;
        mTextWork.setText("00");
        mTextRest.setText("00");
        mTextRound.setText("№" + n);
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

    private String intToTime(int i) {
        return (new SimpleDateFormat("ss")).format(new Date(i * 1000));
    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
        Log.d(LOG_TAG, "onLoadComplete, sampleId = " + sampleId + ", status = " + status);
    }
}
