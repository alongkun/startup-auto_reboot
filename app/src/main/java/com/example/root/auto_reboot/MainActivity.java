package com.example.root.auto_reboot;

import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button_1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_1 = (Button) findViewById(R.id.button_1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        handler.postDelayed(runnable, 90*1000);

        Toast.makeText(MainActivity.this, "auto_reboot had been run", Toast.LENGTH_LONG).show();
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {

        @Override
        public void run() {
            try {
                //handler.postDelayed(this, TIME);
                PowerManager pManager=(PowerManager) getSystemService(Context.POWER_SERVICE);
                pManager.reboot("reboot");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}
