package com.example.androidapplication;

import android.content.Context;
import android.content.Intent;
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
        Button button1 = (Button) findViewById(R.id.Button_1);//按钮，引用已经在xml文件里配置好的button_1
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"点赞成功",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,MyActivity.class);
                startActivity(intent);
            }

        });
        Log.v("MainActivity","onCreate");
        Log.d(TAG, "onCreate: ");
        Log.i(TAG, "onCreate: information");
        Log.w(TAG, "onCreate: warning");
        Log.e(TAG, "onCreate: error");
    }
//    public static void start(Context context) {
//        Intent intent = new Intent(MainActivity.this, MyActivity.class);
//        intent.putExtra("extra","From MainActivity");
//        context.startActivity(intent);
//    }
//    Intent intent = new Intent(MainActivity.this,MyActivity.class);
//    intent.putExtra("extra","FromMainactivity");
//    startActivity(intent);

}
