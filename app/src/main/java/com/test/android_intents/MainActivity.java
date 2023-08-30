package com.test.android_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String name;
    int age;
    double weight;
    double height;

    TextView txtView;
    TextView txtAge;
    TextView txtWeight;
    TextView txtHeight;
    TextView txtName;
    TextView txtBmi;
    TextView clr;
    TextView txtAdvice;

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        txtView = findViewById(R.id.txtWelcome);
        txtAge = findViewById(R.id.txtA);
        txtWeight = findViewById(R.id.txtW);
        txtHeight = findViewById(R.id.txtH);
        txtName = findViewById(R.id.txtN);
        txtBmi = findViewById(R.id.txtBMIValue);
        txtAdvice = findViewById(R.id.textAdvice);
        clr = findViewById(R.id.txtColor);

        img = findViewById(R.id.imgBmi);

        if(intent != null){
            name = intent.getStringExtra("user_name");
            age = Integer.parseInt(intent.getStringExtra("age"));
            weight = Double.parseDouble(intent.getStringExtra("weight"));
            height = Double.parseDouble(intent.getStringExtra("height"));

            if(name.length() < 7){
                txtView.setText("Welcome, " + name+ " !");
            }else{
                txtView.setText("Welcome, " + name.substring(0,6)+ " !");
            }

            Toast.makeText(MainActivity.this, "Welcome to BMI Bliss!", Toast.LENGTH_SHORT).show();
            txtAge.setText("Age: " + String.valueOf(age));
            txtHeight.setText("Height: " + String.valueOf(height));
            txtWeight.setText("Weight: " + String.valueOf(weight));
            txtName.setText("Name: " + name);

            Double bmi = weight / (height * height);
            result(bmi);

            if(bmi < 18.5){
                txtBmi.setText("");
            }else {
                txtBmi.setText("BMI: " + bmi);
            }
        }
    }



    private void result(Double bmi){

        if(bmi > 40){
            img.setImageResource(R.drawable.morbi);
            clr.setBackgroundColor(Color.parseColor("#C02830"));
            txtAdvice.setText("\"Your BMI suggests potential health risks, \nconsider taking steps for improvement.\"");
        }else if(bmi > 30){
            img.setImageResource(R.drawable.obese);
            clr.setBackgroundColor(Color.parseColor("#F4D036"));
            txtAdvice.setText("\"Choose health, one step at a time.\"");
        }else if(bmi > 25){
            img.setImageResource(R.drawable.over);
            clr.setBackgroundColor(Color.parseColor("#379F42"));
            txtAdvice.setText("\"Focus on balanced choices for a healthier you.\"");
        }else if(bmi > 18.5){
            clr.setBackgroundColor(Color.parseColor("#199CD9"));
            txtAdvice.setText("\"Maintain your healthy habits, they're your best asset.\"");
        }else{
            img.setImageResource(R.drawable.err);
            txtAdvice.setText("Please re-check your etered values.");

        }


    }
}
