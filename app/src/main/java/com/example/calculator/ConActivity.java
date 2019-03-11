package com.example.calculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConActivity extends AppCompatActivity {

    //Khởi tạo 2 biến tvMath, tvResult
    private  String tvMath;
    private  String tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con);
        Intent intent = this.getIntent();
        this.tvMath=intent.getStringExtra("tvMath");
        this.tvResult=intent.getStringExtra("tvResult");
        TextView txtMath=(TextView) this.findViewById(R.id.tvMath);
        txtMath.setText(tvMath);
        TextView txtResult=(TextView)this.findViewById(R.id.tvResult);
        txtResult.setText(tvResult);

    }
    // Quay về giao diện ban đầu.
    public void moveLeftClick(View view)  {
        // Calling onBackPressed().
        // Gọi phương thức onBackPressed().
        this.onBackPressed();
    }
}
