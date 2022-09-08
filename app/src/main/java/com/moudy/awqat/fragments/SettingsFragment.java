package com.moudy.awqat.fragments;

import static android.view.View.GONE;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.moudy.awqat.PrivacyPolicy;
import com.moudy.awqat.R;
import com.moudy.awqat.Reset_Password;
import com.moudy.awqat.Sign_Up;
import com.moudy.awqat.TermsofService;


public class SettingsFragment extends Fragment implements View.OnClickListener {
    LinearLayout PrivacyPolicy, TermsofService, ContactUs, ChangePassword, Help, RateUs, Logout;


    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        PrivacyPolicy = view.findViewById(R.id.PrivacyPolicy);
        TermsofService = view.findViewById(R.id.TermsofService);
        ContactUs = view.findViewById(R.id.ContactUs);
        ChangePassword = view.findViewById(R.id.ChangePassword);
        Help = view.findViewById(R.id.Help);
        RateUs = view.findViewById(R.id.RateUs);
        Logout = view.findViewById(R.id.Logout);
    //***************************************************************************
        PrivacyPolicy.setOnClickListener(this);
        TermsofService.setOnClickListener(this);
        ContactUs.setOnClickListener(this);
        ChangePassword.setOnClickListener(this);
        Help.setOnClickListener(this);
        RateUs.setOnClickListener(this);
        Logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.PrivacyPolicy:
                startActivity(new Intent(getActivity(), com.moudy.awqat.PrivacyPolicy.class) );

                break;
            case R.id.TermsofService:
                startActivity(new Intent(getActivity(), TermsofService.class) );

                break;
            case R.id.ContactUs:
                break;
            case R.id.ChangePassword:

                startActivity(new Intent(getActivity(), Reset_Password.class));
                break;
            case R.id.Help:
                break;
            case R.id.RateUs:
                break;
            case R.id.Logout:
                break;

        }
        }
}