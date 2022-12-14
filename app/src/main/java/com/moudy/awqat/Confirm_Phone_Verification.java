package com.moudy.awqat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Confirm_Phone_Verification extends AppCompatActivity {
    TextInputEditText  first_number,second_number,third_number,fourth_number;
    Button confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_phone_verification);
        initToolbar();
        initViews();

        edittextontextchange(first_number);
        edittextontextchange(second_number);
        edittextontextchange(third_number);
        edittextontextchange(fourth_number);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Confirm_Phone_Verification.this,Reset_Password_Verification.class));
            }
        });

    }

    private void initViews() {
        first_number= (TextInputEditText) findViewById(R.id.first_number);
        second_number= (TextInputEditText) findViewById(R.id.second_number);
        third_number= (TextInputEditText) findViewById(R.id.third_number);
        fourth_number= (TextInputEditText) findViewById(R.id.fourth_number);
        confirm= (Button) findViewById(R.id.confirmcode_btn);
    }

    private void edittextontextchange(TextInputEditText editText) {
        editText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if (editText.getText().toString().equals("") ){
                    editText.setBackground(getDrawable(R.drawable.rounded_edittext));
                }else {
                    editText.setBackground(getDrawable(R.drawable.rounded_edittext_blue));
                }
                switch (editText.getContentDescription().toString()){

                    case "2nd":
                        if (!editText.getText().toString().equals("")){
                            third_number.requestFocus();

                        }

                        break;
                    case "3rd":
                        if (!editText.getText().toString().equals("")){
                            fourth_number.requestFocus();

                        }

                        break;
                    case "1st":
                        if (!editText.getText().toString().equals("")){
                            second_number.requestFocus();

                        }
                        break;
                    default:
                        first_number.requestFocus();

                }

            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {

            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {


            }
        });

    }


    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("?????????? ?????? ????????????");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}