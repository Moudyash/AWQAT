package com.moudy.awqat.fragments;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.moudy.awqat.R;


public class ProfileFragment extends Fragment {
    LinearLayout my_requests,my_reservations;
    ImageView bag,reservations;
    TextView my_requests_tv,reservations_tv;
    int current=0;
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        initViews(view);
    ReplaceFragment(new My_Bookings_Fragment());
        my_requests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                current=1;

                check();
                ReplaceFragment(new My_Requests_Fragment());
            }
        });
        my_reservations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                current=0;

                check();
                ReplaceFragment(new My_Bookings_Fragment());

            }
        });
        return view;
    }
    private void initViews(View view) {
        my_requests= (LinearLayout) view.findViewById(R.id.my_requests);
        my_reservations= (LinearLayout) view.findViewById(R.id.my_reservations);
        bag=view.findViewById(R.id.bag);
        reservations=view.findViewById(R.id.reservations);
        reservations_tv=view.findViewById(R.id.reservations_tv);
        my_requests_tv=view.findViewById(R.id.my_requests_tv);
    }

    private void check() {
        switch (current){
            case 0:
                my_requests.setBackground((ContextCompat.getDrawable(getContext(), R.drawable.btn3)));
                my_requests_tv.setTextColor(getResources().getColor(R.color.grey));
                bag.setImageDrawable((ContextCompat.getDrawable(getContext(), R.drawable.ic_bag)));
                //*************************************************************************************
                my_reservations.setBackground((ContextCompat.getDrawable(getContext(), R.drawable.btn3_white)));
                reservations.setImageDrawable((ContextCompat.getDrawable(getContext(), R.drawable.ic_bag_blue)));
                reservations_tv.setTextColor(getResources().getColor(R.color.blue_text));
                break;
            case 1:
                my_reservations.setBackground((ContextCompat.getDrawable(getContext(), R.drawable.btn3)));
                reservations.setImageDrawable((ContextCompat.getDrawable(getContext(), R.drawable.ic_bag)));
                reservations_tv.setTextColor(getResources().getColor(R.color.grey));
                //*************************************************************************************

                my_requests.setBackground((ContextCompat.getDrawable(getContext(), R.drawable.btn3_white)));
                my_requests_tv.setTextColor(getResources().getColor(R.color.blue_text));
                bag.setImageDrawable((ContextCompat.getDrawable(getContext(), R.drawable.ic_bag_blue)));
                break;
        }

    }
    private void ReplaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.profile_fragment_container, fragment);
        transaction.commit();

    }
}