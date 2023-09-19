package com.miniproject.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText calculation,result;
    private String curr,res;
    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnAC,btnDel,btnDivision,btnMultiplication,btnAddition,btnSubtraction,btnEqual,btnDot;
    private boolean dot_inserted,operator_inserted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = findViewById(R.id.calculation);
        result = findViewById(R.id.result);

        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnAC = findViewById(R.id.btnAC);
        btnDel = findViewById(R.id.btnDel);
        btnDivision = findViewById(R.id.btndiv);
        btnMultiplication = findViewById(R.id.btnmul);
        btnAddition = findViewById(R.id.btnadd);
        btnSubtraction = findViewById(R.id.btnsub);
        btnEqual = findViewById(R.id.btnequ);
        btnDot = findViewById(R.id.btndot);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "0";
                displayOne();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "1";
                displayOne();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "2";
                displayOne();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "3";
                displayOne();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "4";
                displayOne();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "5";
                displayOne();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "6";
                displayOne();
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "7";
                displayOne();
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "8";
                displayOne();
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "9";
                displayOne();
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(curr.isEmpty()){
                    curr = "0.";
                    dot_inserted = true;
                }

                if(dot_inserted == false){
                    curr = curr + ".";
                    dot_inserted = true;
                }
                displayOne();
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                displayOne();
                displayTwo();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backspace();
                displayOne();
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_inserted = false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();
                    }
                    if(operator_inserted == false){
                        curr = curr + " / ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });

        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_inserted = false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();
                    }
                    if(operator_inserted == false){
                        curr = curr + " * ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });

        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_inserted = false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();
                    }
                    if(operator_inserted == false){
                        curr = curr + " - ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });

        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_inserted = false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();
                    }
                    if(operator_inserted == false){
                        curr = curr + " + ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operator_inserted == true && !curr.substring(curr.length()-1,curr.length()).equals(" ")){
                    String [] tokens = curr.split(" ");

                    switch (tokens[1].charAt(0)){
                        case '+':
                            res = Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                            break;
                        case '-':
                            res = Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                            break;
                        case '*':
                            res = Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                            break;
                        case '/':
                            res = Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                            break;
                    }
                    displayTwo();
                }
            }
        });
    }

    public void displayOne(){

        calculation.setText(curr);
    }

    public void displayTwo(){

        result.setText(res);
    }

    public void clear(){
        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;
    }

    public void backspace(){
        if(!curr.isEmpty()){
            if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                dot_inserted = false;
            }

            if(curr.substring(curr.length()-1, curr.length()).equals(" ")){
                curr = curr.substring(0,curr.length()-3);
                operator_inserted = false;
            }else{
                curr = curr.substring(0, curr.length()-1);
            }
        }
    }
}