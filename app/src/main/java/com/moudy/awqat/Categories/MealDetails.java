package com.moudy.awqat.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.moudy.awqat.R;
import com.moudy.awqat.Reset_Password;
import com.moudy.awqat.Sign_In;

public class MealDetails extends AppCompatActivity implements View.OnClickListener {
ImageView  favourite_btn,back_btn,facebook,whatsapp,instagram;
    static int count =0;
    MapView mapView;
    GoogleMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);


        initViews();
    }

    private void initViews() {
        favourite_btn =findViewById(R.id.meal_detaild_fav);
        back_btn =findViewById(R.id.meal_detaild_back);
        facebook=findViewById(R.id.facebook_img);
        whatsapp=findViewById(R.id.whatsapp_img);
        instagram=findViewById(R.id.instagram_img);
        favourite_btn.setOnClickListener(this);
        back_btn.setOnClickListener(this);
        facebook.setOnClickListener(this);
                whatsapp.setOnClickListener(this);
        instagram.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.meal_detaild_fav:
                if (count%2 ==0) {
                    favourite_btn.setImageDrawable(getDrawable(R.drawable.ic_filled_heart));
                    Done_Dialog("تم الإضافة للمفضلة بنجاح");                }else{
                    favourite_btn.setImageDrawable(getDrawable(R.drawable.ic_empty_heart));
                    Done_Dialog("تم الحذف من المفضلة بنجاح");                   }
                count++;


                break;
            case R.id.meal_detaild_back:
                break;
            case R.id.whatsapp_img:
                gotowebsite("https://github.com/moudyash");
                break;
            case R.id.facebook_img:
                gotowebsite("https://github.com/moudyash");
                break;
            case R.id.instagram_img:
                gotowebsite("https://github.com/moudyash");
                break;
        }
    }
    public void Done_Dialog(String desciption) {
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
    public void gotowebsite(String websitelink) {
        Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
        openURL.setData(Uri.parse(websitelink));
        startActivity(openURL);
    }
}