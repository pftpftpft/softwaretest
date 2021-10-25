package com.example.androidapplication;

import android.nfc.Tag;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.Button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"点赞成功",Toast.LENGTH_LONG).show();
            }
        });
        Log.v("MainActivity","onCreate");
        Log.d(TAG, "onCreate: ");
        Log.i(TAG, "onCreate: information");
        Log.w(TAG, "onCreate: warning");
        Log.e(TAG, "onCreate: error");
    }
}