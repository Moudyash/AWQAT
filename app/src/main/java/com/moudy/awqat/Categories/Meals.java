package com.moudy.awqat.Categories;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.moudy.awqat.R;


public class Meals extends AppCompatActivity {
    ImageView img_first_filter, img_second_filter, img_third_filter, img_fourth_filter, img_fifth_filter;
    LinearLayout first_filter, second_filter, third_filter, fourth_filter, fifth_filter;
    TextView tv_first_filter, tv_second_filter, tv_third_filter, tv_fourth_filter, tv_fifth_filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
        initViews();
        initToolbar();
        filterbar(R.drawable.waving_hand,"الكل"
                ,R.drawable.meals,"  البرجر   ",
                R.drawable.pizza_icon, "البيتزا",
                R.drawable.chicken_icon, "الدجاج",
                R.drawable.donut_icon,"الحلويات");
        onClick();
}
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("الوجبات");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    private void initViews() {


        first_filter = (LinearLayout) findViewById(R.id.first_filter);
        second_filter = (LinearLayout) findViewById(R.id.second_filter);
        third_filter = (LinearLayout) findViewById(R.id.third_filter);
        fourth_filter = (LinearLayout) findViewById(R.id.fourth_filter);
        fifth_filter = (LinearLayout) findViewById(R.id.fifth_filter);

        tv_first_filter = findViewById(R.id.tv_first_filter);
        tv_second_filter = findViewById(R.id.tv_second_filter);
        tv_third_filter = findViewById(R.id.tv_third_filter);
        tv_fourth_filter =findViewById(R.id.tv_fourth_filter);
        tv_fifth_filter = findViewById(R.id.tv_fifth_filter);
        img_first_filter = findViewById(R.id.img_first_filter);
        img_second_filter = findViewById(R.id.img_second_filter);
        img_third_filter = findViewById(R.id.img_third_filter);
        img_fourth_filter = findViewById(R.id.img_fourth_filter);
        img_fifth_filter = findViewById(R.id.img_fifth_filter);
    }
    public void onClick() {
        first_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterbar(R.color.white,R.drawable.price_bg,
                        R.color.black_text,R.drawable.price_bg_gery,
                        R.color.black_text,R.drawable.price_bg_gery,
                        R.color.black_text,R.drawable.price_bg_gery,
                        R.color.black_text,R.drawable.price_bg_gery);
            }
        });
        second_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterbar(R.color.black_text,R.drawable.price_bg_gery,
                        R.color.white,R.drawable.price_bg,
                        R.color.black_text,R.drawable.price_bg_gery,
                        R.color.black_text,R.drawable.price_bg_gery,
                        R.color.black_text,R.drawable.price_bg_gery);
            }
        });
        third_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterbar(R.color.black_text,R.drawable.price_bg_gery,
                        R.color.black_text,R.drawable.price_bg_gery,
                        R.color.white,R.drawable.price_bg,
                        R.color.black_text,R.drawable.price_bg_gery,
                        R.color.black_text,R.drawable.price_bg_gery);
            }
        });
        fourth_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterbar(R.color.black_text,R.drawable.price_bg_gery,
                        R.color.black_text,R.drawable.price_bg_gery,
                        R.color.black_text,R.drawable.price_bg_gery,
                        R.color.white,R.drawable.price_bg,
                        R.color.black_text,R.drawable.price_bg_gery);
            }
        });
        fifth_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterbar(R.color.black_text,R.drawable.price_bg_gery,
                        R.color.black_text,R.drawable.price_bg_gery,
                        R.color.black_text,R.drawable.price_bg_gery,
                        R.color.black_text,R.drawable.price_bg_gery,
                        R.color.white,R.drawable.price_bg);
            }
        });



    }
    private void filterbar(int c_1, int bg_1,
                           int c_2, int bg_2,
                           int c_3, int bg_3,
                           int c_4, int bg_4,
                           int c_5, int bg_5) {

        // first_filter.setBackground(getActivity().getResources().getDrawable( bg_1));

        tv_first_filter.setTextColor(getResources().getColor(c_1));
        first_filter.setBackground(ContextCompat.getDrawable(this, bg_1));
        tv_second_filter.setTextColor(getResources().getColor(c_2));
        second_filter.setBackground(ContextCompat.getDrawable(this,  bg_2));
        tv_third_filter.setTextColor(getResources().getColor(c_3));
        third_filter.setBackground(ContextCompat.getDrawable(this,  bg_3));
        tv_fourth_filter.setTextColor(getResources().getColor(c_4));
        fourth_filter.setBackground(ContextCompat.getDrawable(this,  bg_4));
        tv_fifth_filter.setTextColor(getResources().getColor(c_5));
        fifth_filter.setBackground(ContextCompat.getDrawable(this,  bg_5));


    }
    private void filterbar(int d_1, String s_1,
                           int d_2, String s_2,
                           int d_3, String s_3,
                           int d_4, String s_4,
                           int d_5, String s_5) {


        tv_first_filter.setText(s_1);
        img_first_filter.setImageDrawable((ContextCompat.getDrawable(getApplicationContext(),d_1)));
        tv_second_filter.setText(s_2);
        img_second_filter.setImageDrawable((ContextCompat.getDrawable(getApplicationContext(),d_2)));
        tv_third_filter.setText(s_3);
        img_third_filter.setImageDrawable((ContextCompat.getDrawable(getApplicationContext(),d_3)));
        tv_fourth_filter.setText(s_4);
        img_fourth_filter.setImageDrawable((ContextCompat.getDrawable(getApplicationContext(),d_4)));
        tv_fifth_filter.setText(s_5);
        img_fifth_filter.setImageDrawable((ContextCompat.getDrawable(getApplicationContext(),d_5)));
    }
}