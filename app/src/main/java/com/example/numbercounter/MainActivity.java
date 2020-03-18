package com.example.numbercounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public TextView countView;
    public Button button;
    public Handler handler;
    public int count;
    public updateCount update;
    public boolean on;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countView = findViewById(R.id.countView);
        button = findViewById(R.id.button);
        handler = new Handler();
        count = 0;
        on = false;
        update = new updateCount();

    }
    public void buttonPressed(View v) {
        //if the button is pressed already clicking it again will stop it
        if (on) {
            on = false;
            //removes handler and stops counter
            handler.removeCallbacks(update);
        } else {
            //else if its on keep and has not been clicked a second time counter keeps going
            on = true;
            //creates handler starts counter
            handler.postDelayed(update, 1000);
        }
    }
    public class updateCount implements Runnable{
        //counts up from zero
        public void run(){
                count++;
                countView.setText(count + "");
                handler.postDelayed(update, 1000);

        }
    }
}
