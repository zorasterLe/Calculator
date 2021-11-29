package com.example.myapplication15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    Button bg1,cl1,bg2,cl2;
    EditText et_input1,et_input2,et_input3,et_input4,et_input5,et_input6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bg1= (Button) findViewById(R.id.bg1);
        bg2= (Button) findViewById(R.id.bg2);
        cl1= (Button) findViewById(R.id.cl1);
        cl2= (Button) findViewById(R.id.cl2);
        et_input1= (EditText) findViewById(R.id.et_input1);
        et_input2= (EditText) findViewById(R.id.et_input2);
        et_input3= (EditText) findViewById(R.id.et_input3);
        et_input4= (EditText) findViewById(R.id.et_input4);
        et_input5= (EditText) findViewById(R.id.et_input5);
        et_input6= (EditText) findViewById(R.id.et_input6);

        bg1.setOnClickListener(this);
        bg2.setOnClickListener(this);
        cl1.setOnClickListener(this);
        cl2.setOnClickListener(this);
        Button button = findViewById(R.id.re);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cl1:
                et_input1.setText("");
                et_input2.setText("");
                et_input3.setText("");
                break;
            case R.id.cl2:
                et_input4.setText("");
                et_input5.setText("");
                et_input6.setText("");
                break;
            case R.id.bg1:
                if(et_input2.getText().toString().equals("")&&et_input3.getText().toString().equals("")) {
                    Double d = Double.parseDouble(et_input1.getText().toString());
                    et_input2.setText(Double.toString(d/10));
                    et_input3.setText(Double.toString(d/100));
                    break;
                }
                else if(et_input1.getText().toString().equals("")&&et_input3.getText().toString().equals("")){
                    Double d = Double.parseDouble(et_input2.getText().toString());
                    et_input1.setText(Double.toString(d*10));
                    et_input3.setText(Double.toString(d/10));
                    break;
                }
                else {
                    Double d = Double.parseDouble(et_input3.getText().toString());
                    et_input1.setText(Double.toString(d*100));
                    et_input2.setText(Double.toString(d*10));
                    break;
                }
            case R.id.bg2:
                if(et_input5.getText().toString().equals("")&&et_input6.getText().toString().equals("")) {
                    Double d = Double.parseDouble(et_input4.getText().toString());
                    et_input5.setText(Double.toString(d/1000));
                    et_input6.setText(Double.toString(d/1000000));
                    break;
                }
                else if(et_input4.getText().toString().equals("")&&et_input6.getText().toString().equals("")){
                    Double d = Double.parseDouble(et_input5.getText().toString());
                    et_input4.setText(Double.toString(d*1000));
                    et_input6.setText(Double.toString(d/1000));
                    break;
                }
                else {
                    Double d = Double.parseDouble(et_input6.getText().toString());
                    et_input4.setText(Double.toString(d*1000000));
                    et_input5.setText(Double.toString(d*1000));
                    break;
                }
        }

    }
}