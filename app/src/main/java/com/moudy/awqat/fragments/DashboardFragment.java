package com.moudy.awqat.fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.moudy.awqat.Categories.MealDetails;
import com.moudy.awqat.Categories.Meals;
import com.moudy.awqat.R;


public class DashboardFragment extends Fragment implements View.OnClickListener{
    CardView clinics, funny_places, shopping, meals;

    public DashboardFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        clinics = view.findViewById(R.id.clinics);
        funny_places = view.findViewById(R.id.funny_places);
        shopping = view.findViewById(R.id.shopping);
        meals = view.findViewById(R.id.meals);
        meals.setOnClickListener(this);
                shopping.setOnClickListener(this);
        funny_places.setOnClickListener(this);
                clinics.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.clinics:
                startActivity(new Intent(getActivity(), MealDetails.class));

                break;
            case R.id.funny_places:

                break;
            case R.id.shopping:

                break;
            case R.id.meals:
             startActivity(new Intent(getActivity(), Meals.class));
                break;

        }
    }
}