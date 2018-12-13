package com.example.mind.broadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_sendBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_sendBroadcast = (Button) findViewById(R.id.btn_sendBroadcast);

        btn_sendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something after 1000ms
                        sendMessage();
                    }
                }, 1000);
            }
        });
    }

    private void sendMessage() {
        Log.d("sender", "Broadcasting message");
        Intent intent = new Intent(AppConstant.ACTION);
        intent.putExtra(AppConstant.MESSAGE, AppConstant.THIS_IS_MY_MESSAGE);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
