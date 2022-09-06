package com.moudy.awqat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputEditText;

public class Reset_Password_Verification extends AppCompatActivity {
    TextInputEditText  first_number,second_number,third_number,fourth_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password_verification);
        initToolbar();
        initViews();

        edittextontextchange(first_number);
        edittextontextchange(second_number);
        edittextontextchange(third_number);
        edittextontextchange(fourth_number);


    }

    private void initViews() {
        first_number= (TextInputEditText) findViewById(R.id.first_number);
        second_number= (TextInputEditText) findViewById(R.id.second_number);
        third_number= (TextInputEditText) findViewById(R.id.third_number);
        fourth_number= (TextInputEditText) findViewById(R.id.fourth_number);
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
                        third_number.requestFocus();

                        break;
                    case "3rd":
                        fourth_number.requestFocus();

                        break;
                    case "1st":
                        second_number.requestFocus();
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
        getSupportActionBar().setTitle("تأكيد رقم الهاتف");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }}
