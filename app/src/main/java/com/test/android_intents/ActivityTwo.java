package com.test.android_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTwo extends AppCompatActivity {

    Button btnSubmit;
    TextView txtName;
    TextView txtAge;
    TextView txtWeight;
    TextView txtHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        txtAge = findViewById(R.id.txtAge);
        txtHeight = findViewById(R.id.txtHeight);
        txtName = findViewById(R.id.txtName);
        txtWeight = findViewById(R.id.txtWeight);

        btnSubmit = findViewById(R.id.btnSubmit);
    }

    public void submitData(View view) {

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateButtonClick(view);
               if(changeEditTtextColor()){
                    Toast.makeText(ActivityTwo.this, "Please fill all text boxes with correct details!!", Toast.LENGTH_LONG).show();
               }else{



                   Intent intent = new Intent(ActivityTwo.this, MainActivity.class);
                   intent.putExtra("user_name", txtName.getText().toString());
                   intent.putExtra("age", txtAge.getText().toString());
                   intent.putExtra("weight", txtWeight.getText().toString());
                   intent.putExtra("height", txtHeight.getText().toString());
                   startActivity(intent);
                   txtName.setText("");
                   txtAge.setText("");
                   txtHeight.setText("");
                   txtWeight.setText("");
               }
            }
        });

    }

    private boolean changeEditTtextColor(){
        boolean isTrue = false;
        if(txtName.getText().toString().isEmpty()){
            txtName.setBackgroundColor(Color.parseColor("#ffb1a8"));
            isTrue = true;
        }else{
            txtName.setBackgroundColor(Color.WHITE);
        }

        if(txtWeight.getText().toString().isEmpty()){
            txtWeight.setBackgroundColor(Color.parseColor("#ffb1a8"));
            isTrue = true;
        }else{
            if(Integer.parseInt(txtWeight.getText().toString()) > 200 || Integer.parseInt(txtWeight.getText().toString()) < 5){
                txtWeight.setBackgroundColor(Color.parseColor("#ffb1a8"));
                isTrue = true;
            }else {
                txtWeight.setBackgroundColor(Color.WHITE);
            }
        }

        if(txtHeight.getText().toString().isEmpty()){
            txtHeight.setBackgroundColor(Color.parseColor("#ffb1a8"));
            isTrue = true;
        }else{
            if(Double.parseDouble(txtHeight.getText().toString()) > 2.8 || Double.parseDouble(txtHeight.getText().toString()) < 0.4){
                txtHeight.setBackgroundColor(Color.parseColor("#ffb1a8"));
                isTrue = true;
            }else {
                txtHeight.setBackgroundColor(Color.WHITE);
            }
        }

        if(txtAge.getText().toString().isEmpty()){
            txtAge.setBackgroundColor(Color.parseColor("#ffb1a8"));
            isTrue = true;
        }else{
            if(Integer.parseInt(txtAge.getText().toString()) > 120 || Integer.parseInt(txtAge.getText().toString())  < 2){
                txtAge.setBackgroundColor(Color.parseColor("#ffb1a8"));
                isTrue = true;
            }else {
                txtAge.setBackgroundColor(Color.WHITE);
            }
        }

        return isTrue;
    }
    private void animateButtonClick(View view) {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.button_click_anim);
        view.startAnimation(anim);
    }


}
