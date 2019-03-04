package com.example.calculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textMath;
    private TextView textResult;
    public static final int MY_REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textMath=(TextView)this.findViewById(R.id.tvMath);
        this.textResult=(TextView)this.findViewById(R.id.tvResult);
    }

    // The method is called when the user clicks on "Show Greeting" button.
    public void MoveClick(View view)  {

        String textMath= this.textMath.getText().toString();
        String textResult= this.textResult.getText().toString();

        Intent intent = new Intent(this,ConActivity.class);
        intent.putExtra("tvMath", textMath);
        intent.putExtra("tvResult", textResult);
        // Start Activity and no need feedback.
        // this.startActivity(intent);

        // Start Activity and get feedback.
        this.startActivityForResult(intent, MY_REQUEST_CODE);
    }
}
