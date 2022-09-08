package com.moudy.awqat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;

public class Reset_Password_Verification extends AppCompatActivity {
    TextInputEditText  first_number,second_number,third_number,fourth_number;
TextView resend_code;
Button check;
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
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Reset_Password_Verification.this,Reset_Password.class));
            }
        });
resend_code.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        resetdone("تم إعادة تعين كلمة السر بنجاح");
    }
});

    }

    private void initViews() {
        check = (Button) findViewById(R.id.checkbtn);
        resend_code= (TextView) findViewById(R.id.tv_resendcode);
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
        getSupportActionBar().setTitle("إعادة تعيين كلمة المرور");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void resetdone(String desciption) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.done_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(true);
TextView tv_desciption=dialog.findViewById(R.id.text);
        tv_desciption.setText(desciption);
        ((Button) dialog.findViewById(R.id.btn_done)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        dialog.show();


    }
}
