package com.moudy.awqat.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.moudy.awqat.R;


public class My_Requests_Fragment extends Fragment {

    public My_Requests_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_my__requests_, container, false);
        setRetainInstance(true);


        return view ;
    }
}