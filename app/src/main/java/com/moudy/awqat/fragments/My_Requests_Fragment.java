package com.moudy.awqat.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.moudy.awqat.Categories.DeliveryOffers;
import com.moudy.awqat.R;


public class My_Requests_Fragment extends Fragment {
    Button show_delivery_offers;
    public My_Requests_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_my__requests_, container, false);

        initViews(view);
        show_delivery_offers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(getActivity(), DeliveryOffers.class));
            }
        });
        return view ;
    }

    private void initViews(View view) {
        show_delivery_offers=view.findViewById(R.id.show_delivery_offers);   }
}