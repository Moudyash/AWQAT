package com.moudy.awqat.fragments;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.moudy.awqat.R;

public class FavouriteFragment extends Fragment {
    ImageView img_first_filter, img_second_filter, img_third_filter, img_fourth_filter, img_fifth_filter;
    LinearLayout first_filter, second_filter, third_filter, fourth_filter, fifth_filter;
    TextView tv_first_filter, tv_second_filter, tv_third_filter, tv_fourth_filter, tv_fifth_filter;
    public FavouriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_favourite, container, false);
        initViews(view);
        filterbar(R.drawable.waving_hand,"الكل"
                ,R.drawable.home,"أماكن الترفيه",
                R.drawable.hospital, "العيادات",
                R.drawable.meals, "الوجبات",
                R.drawable.shopping,"التسوق");
        onClick();
        return view ;
    }

    private void initViews(View view) {


        first_filter = (LinearLayout) view.findViewById(R.id.first_filter);
        second_filter = (LinearLayout) view.findViewById(R.id.second_filter);
        third_filter = (LinearLayout) view.findViewById(R.id.third_filter);
        fourth_filter = (LinearLayout) view.findViewById(R.id.fourth_filter);
        fifth_filter = (LinearLayout) view.findViewById(R.id.fifth_filter);

        tv_first_filter = view.findViewById(R.id.tv_first_filter);
        tv_second_filter = view.findViewById(R.id.tv_second_filter);
        tv_third_filter = view.findViewById(R.id.tv_third_filter);
        tv_fourth_filter = view.findViewById(R.id.tv_fourth_filter);
        tv_fifth_filter = view.findViewById(R.id.tv_fifth_filter);
        img_first_filter = view.findViewById(R.id.img_first_filter);
        img_second_filter = view.findViewById(R.id.img_second_filter);
        img_third_filter = view.findViewById(R.id.img_third_filter);
        img_fourth_filter = view.findViewById(R.id.img_fourth_filter);
        img_fifth_filter = view.findViewById(R.id.img_fifth_filter);
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
        first_filter.setBackground(getActivity().getDrawable( bg_1));
        tv_second_filter.setTextColor(getResources().getColor(c_2));
        second_filter.setBackground((getActivity().getDrawable( bg_2)));
        tv_third_filter.setTextColor(getResources().getColor(c_3));
        third_filter.setBackground((getActivity().getDrawable( bg_3)));
        tv_fourth_filter.setTextColor(getResources().getColor(c_4));
        fourth_filter.setBackground((getActivity().getDrawable( bg_4)));
        tv_fifth_filter.setTextColor(getResources().getColor(c_5));
        fifth_filter.setBackground((getActivity().getDrawable( bg_5)));


    }
    private void filterbar(int d_1, String s_1,
                           int d_2, String s_2,
                           int d_3, String s_3,
                           int d_4, String s_4,
                           int d_5, String s_5) {


        tv_first_filter.setText(s_1);
        img_first_filter.setImageDrawable((ContextCompat.getDrawable(getContext(),d_1)));
        tv_second_filter.setText(s_2);
        img_second_filter.setImageDrawable((ContextCompat.getDrawable(getContext(),d_2)));
        tv_third_filter.setText(s_3);
        img_third_filter.setImageDrawable((ContextCompat.getDrawable(getContext(),d_3)));
        tv_fourth_filter.setText(s_4);
        img_fourth_filter.setImageDrawable((ContextCompat.getDrawable(getContext(),d_4)));
        tv_fifth_filter.setText(s_5);
        img_fifth_filter.setImageDrawable((ContextCompat.getDrawable(getContext(),d_5)));
    }

}