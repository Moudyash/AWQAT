package com.moudy.awqat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Sign_In extends AppCompatActivity {
TextView sign_up,forget_password;
Button sign_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        sign_up= (TextView) findViewById(R.id.sign_up);
        forget_password=(TextView) findViewById(R.id.forgetpass);
        sign_in= (Button) findViewById(R.id.sign_in_button);
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Sign_In.this,Phone_Verification.class) );

            }
        });
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_In.this,Sign_Up.class) );

            }
        });
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Sign_In.this,MainActivity.class) );

            }
        });
    }
}