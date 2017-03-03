package com.example.sanchit.stopwatchbhaiki;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity_stopwatch extends Activity {
    private int sec=0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_stopwatch);
        if(savedInstanceState !=null)
        {
            sec=savedInstanceState.getInt("sec");
            running=savedInstanceState.getBoolean("running");
        }
        runTime();


    }

    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("sec",sec);
        savedInstanceState.putBoolean("running",running);
    }
    public void starton(View view)
    {
        running =true;
    }
    public void stopon(View view)
    {
        running=false;
    }
    public void reseton(View view)
    {
    running=false;
        sec=0;
    }
    private void runTime()
    {
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                final TextView textView=(TextView) findViewById(R.id.textView);
                int hrs=sec/3600;
                int min=(sec%3600)/60;
                int secs=sec%60;
                String time=String.format("%d:%02d:%2d",hrs,min,secs);
                textView.setText(time);
                if(running)
                {
                    sec++;
                }
                handler.postDelayed(this,1000);
            }
        });

    }

}
