package com.example.iMove;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.imovenew8jan.R;

import java.util.Locale;
import java.util.Random;

public class StartWorkAct extends AppCompatActivity {

    TextView intropage, subintropage, fitonetitle, fitonedesc, timerValue, btnexercise;
    View divpage,bgprogress,screenView;
    Button clickMe;
    int [] images;

    LinearLayout fitone;
    ImageView imgTimer;

    private static final long START_TIME_IN_MILLIS=15000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis= START_TIME_IN_MILLIS;

    Animation btthree,bttfour,ttbone,ttbtwo,alphago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_work);

        images = new int[]{R.drawable.natura,R.drawable.img2,R.drawable.img3};
        screenView=findViewById(R.id.rView);
        clickMe= (Button) findViewById(R.id.button);

        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int aryLength= images.length;
                Random random= new Random();
                int rNum= random.nextInt(aryLength);
                screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(),images[rNum]));
            }
        });

        intropage= (TextView) findViewById(R.id.intropage);
        intropage= (TextView) findViewById(R.id.subintropage);
        fitonetitle= (TextView) findViewById(R.id.fitonetitle);
        fitonedesc= (TextView) findViewById(R.id.fitonedesc);
        timerValue= (TextView) findViewById(R.id.timerValue);
        btnexercise= (TextView) findViewById(R.id.btnexercise);

        divpage= (View) findViewById(R.id.divpage);
        bgprogress= (View) findViewById(R.id.bgprogress);

        fitone= (LinearLayout) findViewById(R.id.fitone);

        imgTimer= (ImageView) findViewById(R.id.imgtimer);
        btnexercise.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent a= new Intent(StartWorkAct.this, BmiCalc.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


        startTimer();

    }
    private void startTimer(){
        countDownTimer= new CountDownTimer(mTimeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {

                Toast.makeText(getApplicationContext(),"WELL DONE! You're One Step Closer to Achieve your GOAL!",Toast.LENGTH_SHORT).show();

            }
        }.start();
        mTimerRunning= true;
    }
    private void updateCountDownText(){
        int minutes=(int)(mTimeLeftInMillis/1000)/60;
        int seconds=(int)(mTimeLeftInMillis/1000)%60;

        String timeLeft=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        timerValue.setText(timeLeft);
    }
}