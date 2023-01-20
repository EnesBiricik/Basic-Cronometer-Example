package com.enesbiricik.basiccronometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Runnable runnable;
    Handler handler;
    Button button;
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        number=0;
        button = findViewById(R.id.button);

    }

    public void start(View view){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("TIME: "+number);
                number++;
                textView.setText("TIME: "+number);
                handler.postDelayed(runnable , 1000);
            }
        };
         handler.post(runnable);
         button.setEnabled(false);
    }
    public  void stop(View view){
        button.setEnabled(true);
        handler.removeCallbacks(runnable);
        textView.setText("TIME: "+number);
        Toast.makeText(getApplicationContext(), "TIMER IS PAUSED!", Toast.LENGTH_LONG).show();
    }
    public void reset(View view){
        handler.removeCallbacks(runnable);
        number=0;
        textView.setText("TIME: "+number);
        Toast.makeText(getApplicationContext(), "TIMER IS RESETED!", Toast.LENGTH_LONG).show();
    }
}