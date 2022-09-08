package com.moudy.awqat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sign_Up extends AppCompatActivity implements View.OnClickListener {
Button SignUp;
TextView sign_in;
TextView PrivacyPolicy,TermsofService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initViews();


    }
    private void initViews(){
        SignUp= (Button) findViewById(R.id.signupbtn);

        sign_in= (TextView) findViewById(R.id.sign_in);
        PrivacyPolicy= (TextView) findViewById(R.id.PrivacyPolicy);
        TermsofService= (TextView) findViewById(R.id.TermsofService);
        //*****************************************************************
        sign_in.setOnClickListener(this);
        PrivacyPolicy.setOnClickListener(this);
        TermsofService.setOnClickListener(this);
        SignUp.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signupbtn:
                startActivity(new Intent(Sign_Up.this,Steps.class) );

                break;
            case R.id.sign_in:
                startActivity(new Intent(Sign_Up.this,Sign_In.class) );

                break;
            case R.id.PrivacyPolicy:
                startActivity(new Intent(Sign_Up.this,PrivacyPolicy.class) );

                break;
            case R.id.TermsofService:
                startActivity(new Intent(Sign_Up.this,TermsofService.class) );

                break;
        }
    }
}