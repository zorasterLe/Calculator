package com.example.myapplication15;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_pt;
    Button btn_mul,btn_div,btn_add,btn_sub,btn_L,btn_R,btn_cos,btn_sin,btn_10,btn_02,btn_ch,btn_help;
    Button btn_clr,btn_del,btn_eq;
    EditText et_input;
    boolean clr_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_main);
        btn_0= (Button) findViewById(R.id.btn_0);
        btn_1= (Button) findViewById(R.id.btn_1);
        btn_2= (Button) findViewById(R.id.btn_2);
        btn_3= (Button) findViewById(R.id.btn_3);
        btn_4= (Button) findViewById(R.id.btn_4);
        btn_5= (Button) findViewById(R.id.btn_5);
        btn_6= (Button) findViewById(R.id.btn_6);
        btn_7= (Button) findViewById(R.id.btn_7);
        btn_8= (Button) findViewById(R.id.btn_8);
        btn_9= (Button) findViewById(R.id.btn_9);
        btn_pt= (Button) findViewById(R.id.btn_pt);
        btn_add= (Button) findViewById(R.id.btn_add);
        btn_sub= (Button) findViewById(R.id.btn_sub);
        btn_mul= (Button) findViewById(R.id.btn_mul);
        btn_div= (Button) findViewById(R.id.btn_div);
        btn_clr= (Button) findViewById(R.id.btn_clr);
        btn_del= (Button) findViewById(R.id.btn_del);
        btn_eq= (Button) findViewById(R.id.btn_eq);
        btn_L= (Button) findViewById(R.id.btn_L);
        btn_R= (Button) findViewById(R.id.btn_R);
        btn_cos= (Button) findViewById(R.id.btn_cos);
        btn_sin= (Button) findViewById(R.id.btn_sin);
        btn_10= (Button) findViewById(R.id.btn_10);
        btn_02= (Button) findViewById(R.id.btn_02);
        btn_ch= (Button) findViewById(R.id.btn_ch);
        btn_help= (Button) findViewById(R.id.btn_help);
        et_input= (EditText) findViewById(R.id.et_input);

        //给按钮设置的点击事件
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_pt.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_clr.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_L.setOnClickListener(this);
        btn_R.setOnClickListener(this);
        btn_cos.setOnClickListener(this);
        btn_sin.setOnClickListener(this);
        btn_10.setOnClickListener(this);
        btn_02.setOnClickListener(this);
        btn_help.setOnClickListener(this);
        btn_ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        btn_eq.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str=et_input.getText().toString();
        switch (v.getId()){
            case   R.id.btn_0:
            case   R.id.btn_1:
            case   R.id.btn_2:
            case   R.id.btn_3:
            case   R.id.btn_4:
            case   R.id.btn_5:
            case   R.id.btn_6:
            case   R.id.btn_7:
            case   R.id.btn_8:
            case   R.id.btn_9:
            case   R.id.btn_L:
            case   R.id.btn_R:
                if(clr_flag){
                    clr_flag=false;
                    str="";
                    et_input.setText("");
                }
                et_input.setText(str+((Button)v).getText());
                break;
            case R.id.btn_add:
            case R.id.btn_sub:
            case R.id.btn_mul:
            case R.id.btn_div:
                if(clr_flag){
                    clr_flag=false;
                    str="";
                    et_input.setText("");
                }
                if(str.contains("+")||str.contains("-")||str.contains("*")||str.contains("/")) {
                    String str1 = str.substring(str.length()-1);
                    if(str1.equals("+")||str1.equals("-")||str1.equals("*")||str1.equals("/")) {
                        et_input.setText(str+"");
                        break;
                    }
                    else {
                        et_input.setText(str+((Button) v).getText());
                        break;
                    }
                }
                et_input.setText(str+((Button)v).getText());
                break;
            case R.id.btn_cos:
                if(clr_flag){
                    clr_flag=false;
                    return;
                }
                clr_flag=true;
                double c = Double.parseDouble(et_input.getText().toString()) ;
                double d = Math.cos(Math.toRadians(c));
                et_input.setText(Double.toString(d));
                break;
            case R.id.btn_sin:
                if(clr_flag){
                    clr_flag=false;
                    return;
                }
                clr_flag=true;
                double e = Double.parseDouble(et_input.getText().toString()) ;
                double f = Math.sin(Math.toRadians(e));
                et_input.setText(Double.toString(f));
                break;
            case R.id.btn_10:
                int x = Integer.parseInt(et_input.getText().toString(),2);

                et_input.setText(Integer.toString(x));
                break;
            case R.id.btn_02:
                int n = Integer.parseInt(et_input.getText().toString());
                et_input.setText(Integer.toBinaryString(n));
                break;
            case R.id.btn_help:
                Toast toast = Toast.makeText(getApplicationContext(),"这是帮助",Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.btn_pt:
                if(clr_flag){
                    clr_flag=false;
                    str="";
                    et_input.setText("");
                }
                String str3 = str.substring(str.length()-1);
                if(str3.equals(".")||str3.equals("")){
                    et_input.setText(str+"");
                    break;
                }
                else {
                    et_input.setText(str + ".");
                    break;
                }

            case R.id.btn_clr:
                if(clr_flag)
                    clr_flag=false;
                str="";
                et_input.setText("");
                break;
            case R.id.btn_del: //判断是否为空，然后在进行删除
                if(clr_flag){
                    clr_flag=false;
                    str="";
                    et_input.setText("");
                }
                else if(str!=null&&!str.equals("")){
                    et_input.setText(str.substring(0,str.length()-1));
                }
                break;
            case R.id.btn_eq: //单独运算最后结果
                getResult();//调用下面的方法
                break;
        }
    }

    private void getResult() {
        if(clr_flag){
            clr_flag=false;
            return;
        }
        clr_flag = true;
        String exp=et_input.getText().toString();
        String result = new FormulaUtil().caculate(exp);
        et_input.setText(result);
    }
}