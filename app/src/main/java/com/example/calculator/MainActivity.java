package com.example.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

import com.example.calculator.Presenter.CalculatorPresenter;
import com.github.bgora.rpnlibrary.exceptions.NoSuchFunctionFound;
import com.github.bgora.rpnlibrary.exceptions.WrongArgumentException;

public class    MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private  String tvMath;
    private  String tvResult;
    private TextView textMath;
    private TextView textResult;
    private CalculatorPresenter calculatorPresenter;
    private  int[] idButton={
            R.id.btnZero,R.id.btnOne,R.id.btnTwo,R.id.btnThree,R.id.btnFour,
            R.id.btnFive,R.id.btnSix,R.id.btnSeven,R.id.btnEight,R.id.btnNine,
            R.id.btnAdd,R.id.btnSub,R.id.btnMul,R.id.btnDiv,
            R.id.btnPlus
           ,R.id.btnAns,R.id.btnSpace,
            R.id.btnResult,R.id.btnReset, R.id.btnDelete
    };
    public static final int MY_REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = this.getIntent();
        this.textMath=(TextView)this.findViewById(R.id.tvMath);
        this.textResult=(TextView)this.findViewById(R.id.tvResult);
        this.tvMath=intent.getStringExtra("tvMath");
        this.tvResult=intent.getStringExtra("tvResult");
        TextView txtMath=(TextView) this.findViewById(R.id.tvMath);
        txtMath.setText(tvMath);
        TextView txtResult=(TextView)this.findViewById(R.id.tvResult);
        txtResult.setText(tvResult);
        connectView();

    }


    //Bắt sự kiện cho từng Button
    private void connectView() {
        textMath = (TextView) findViewById(R.id.tvMath);
        textResult = (TextView) findViewById(R.id.tvResult);

        for (int i = 0; i < idButton.length; i++) {
            findViewById(idButton[i]).setOnClickListener(this);
        }
    }
    //Hàm xóa hết biểu thức và kết quả
    private void init() {
        textMath.setText("");
        textResult.setText("0");
    }


    @Override
    public void onClick(View view) {
        Double result= null;
        String expression =null;


        int id = view.getId();
        String text="";
        // check button number and button operator
        for (int i = 0; i < idButton.length - 3; i++) {
            if (id == idButton[i]) {
                 text = ((Button) findViewById(id)).getText().toString();
                // clear char | on top
                if (textMath.getText().toString().trim().equals("|")) {
                    textResult.setText("");
                }

                textMath.append(text+"");

                //if button is number then compute
                if(i<10)
                {
                    expression=textMath.getText().toString();
                    calculatorPresenter=new CalculatorPresenter(expression);
                    try {
                        result=calculatorPresenter.compute();
                        textResult.setText(result.toString());
                    } catch (WrongArgumentException e) {
                        e.printStackTrace();
                    } catch (NoSuchFunctionFound noSuchFunctionFound) {
                        noSuchFunctionFound.printStackTrace();
                    }
                }

                return;
            }
        }
        if(id==R.id.btnDelete){
            try {
                String a = textMath.getText().toString();
                String b = a.substring(0, a.length() - 1);
                textMath.setText(b);
            } catch (Exception e)
            {

            }


        }

        // clear screen
        if (id == R.id.btnReset) {
            init();
            return;
        }

        // calculation
        if (id == R.id.btnResult) {
            expression=textMath.getText().toString();
            calculatorPresenter=new CalculatorPresenter(expression);
            try {
                result = calculatorPresenter.compute();
            } catch (WrongArgumentException e) {
                e.printStackTrace();
            } catch (NoSuchFunctionFound noSuchFunctionFound) {
                noSuchFunctionFound.printStackTrace();
            }

            textMath.setText(result.toString());
            textResult.setText("");
        }

    }







    // The method is called when the user clicks on "Show Greeting" button.
    public void moveRightClick(View view)  {

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
