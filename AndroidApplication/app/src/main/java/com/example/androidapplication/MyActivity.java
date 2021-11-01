package com.example.androidapplication;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        
        String searchrs=getIntent().getStringExtra("extra");//获得从SearchActivity传入的字符串
        TextView textView1=(TextView) findViewById(R.id.mytext);
        textView1.setText(searchrs);//将信息进行显示
        
        Button button2=(Button) findViewById(R.id.Button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MyActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}