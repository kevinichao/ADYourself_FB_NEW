package com.example.adyourself_fb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity {

    private TextView showuser;
    private String usernow;
    private Button btn_to_userorderhistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        btn_to_userorderhistory = (Button) findViewById(R.id.btn_to_userorderhistory);

        //接收登入or註冊頁面傳來的使用者資訊
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            usernow = bundle.getString("nowuser");
        }

        //左上角顯示現在使用者
        showuser =(TextView) findViewById(R.id.text_showuser);
        showuser.setText("歡迎使用ADYourSelf，"+usernow+"。");

        //跳轉到訂單紀錄頁面
        btn_to_userorderhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_to_userorderhistory=new Intent(MainPage.this,UserOrderHistory.class);

                Bundle bundle = new Bundle();
                bundle.putString("nowuser", usernow);
                intent_to_userorderhistory.putExtras(bundle);

                startActivity(intent_to_userorderhistory);
            }
        });

    }
}
