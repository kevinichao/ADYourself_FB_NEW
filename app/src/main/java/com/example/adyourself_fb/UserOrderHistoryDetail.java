package com.example.adyourself_fb;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserOrderHistoryDetail extends AppCompatActivity {

    private Button btn_penOK;

    //資料庫
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_order_history_detail);

        //取從待審核訂單獲得的資料
        Bundle bundleclass =this.getIntent().getExtras();
        final String D_AD = bundleclass.getString("t_AD");
        String D_BoardID = bundleclass.getString("t_BoardID");
        String D_Date = bundleclass.getString("t_Date");
        String D_Completion = bundleclass.getString("t_Completion");
        String D_Price = bundleclass.getString("t_Price");
        String D_Time = bundleclass.getString("t_Time");
        String D_User = bundleclass.getString("t_User");
        String D_OrderID = bundleclass.getString("t_OrderID");

        //顯示在頁面上
        TextView TV_AD = findViewById(R.id.UDetail_AD);
        TextView TV_BoardID = findViewById(R.id.UDetail_Board);
        TextView TV_Date = findViewById(R.id.UDetail_Date);
        TextView TV_Completion = findViewById(R.id.UDetail_Pending);
        TextView TV_Price = findViewById(R.id.UDetail_Price);
        TextView TV_Time = findViewById(R.id.UDetail_Time);
        TextView TV_User = findViewById(R.id.UDetail_User);
        TextView TV_OrderID = findViewById(R.id.UDetail_OrderID);

        TV_AD.setText(""+D_AD);
        TV_BoardID.setText(""+D_BoardID);
        TV_Date.setText(""+D_Date);
        TV_Completion.setText(""+D_Completion);
        TV_Price.setText(""+D_Price);
        TV_Time.setText(""+D_Time);
        TV_User.setText(""+D_User);
        TV_OrderID.setText(""+D_OrderID);

        //審核通過按鈕
        //將此筆訂單的Pending狀態改為Yes
        /*btn_penOK=(Button) findViewById(R.id.btn_Penging_OK);
        btn_penOK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                myRef.child("Order").child(""+D_OrderID).child("Pending").setValue("Yes");
                Toast.makeText(AdminorderDetail.this, "審核通過！", Toast.LENGTH_SHORT).show();
                Intent intent_pendingsuccess = new Intent(AdminorderDetail.this, AdminMainPage.class);
                startActivity(intent_pendingsuccess);
            }
        });*/
    }
}
