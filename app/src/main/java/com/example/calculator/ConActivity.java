package com.example.calculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConActivity extends AppCompatActivity implements  View.OnClickListener{

    //Khởi tạo 2 biến tvMath, tvResult
    private  String tvMath;
    private  String tvResult;
    private  TextView textMath;
    private  TextView textResult;
    private  int[] idButton={
            R.id.btnSin,R.id.btnCos,R.id.btnTan,R.id.btnCot,
            R.id.btnPi,R.id.btnSquareroot,R.id.btnOpenbrackets,R.id.btnClosebrackets
    };
    public static final int MY_REQUEST_CODE = 100;
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
        connectView();

    }
    // Quay về giao diện ban đầu.
    public void moveLeftClick(View view)  {
        // Calling onBackPressed().
        String textMath= this.textMath.getText().toString();
        String textResult= this.textResult.getText().toString();
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("tvMath", textMath);
        intent.putExtra("tvResult", textResult);
        // Start Activity and no need feedback.
        // this.startActivity(intent);

        // Start Activity and get feedback.
        this.startActivityForResult(intent, MY_REQUEST_CODE);
       // this.onBackPressed();
    }
    //Bắt sự kiện cho từng Button
    private void connectView() {
        textMath = (TextView) findViewById(R.id.tvMath);
        textResult = (TextView) findViewById(R.id.tvResult);

        for (int i = 0; i < idButton.length; i++) {
            findViewById(idButton[i]).setOnClickListener(this);
        }
    }
    private void init() {
        textMath.setText("");
        textResult.setText("0");
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        String text = "";
        // check button number and button operator
        for (int i = 0; i < idButton.length ; i++) {
            if (id == idButton[i]) {
                text = ((Button) findViewById(id)).getText().toString();
                // clear char | on top
                if (textMath.getText().toString().trim().equals("|")) {
                    textResult.setText(" ");
                }
                textMath.append(text + " ");
                return;
            }
        }

    }
}
