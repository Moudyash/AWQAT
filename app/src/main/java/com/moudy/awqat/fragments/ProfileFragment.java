package com.moudy.awqat.fragments;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.moudy.awqat.Adapters.ViewPagerAdapter;
import com.moudy.awqat.ViewPagerTransformer.CubeOutPageTransformer;
import com.moudy.awqat.R;


public class ProfileFragment extends Fragment {
    LinearLayout my_requests,my_reservations;
    ImageView bag,reservations;
    TextView my_requests_tv,reservations_tv;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    int current_page=0;
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        initViews(view);



        // Reference (or instantiate) a ViewPager instance and apply a transformer



        // Set the adapter
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setPageTransformer(true, new CubeOutPageTransformer());
        viewPagerAdapter.notifyDataSetChanged();
        int currentitem = viewPager.getCurrentItem()+1 ;

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position==0){
                    current_page=0;

                    check();

                }else{
                    current_page=1;

                    check();
                    // Toast.makeText(getActivity(),"1",Toast.LENGTH_SHORT).show();


                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        my_requests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentitem < 2) {
                    // move to next screen
                    viewPager.setCurrentItem(currentitem);
                   //  Toast.makeText(getActivity(),currentitem+"",Toast.LENGTH_SHORT).show();

                    current_page=0;
                }
            }
        });
        my_reservations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentitem = viewPager.getCurrentItem()-1 ;
              //  Toast.makeText(getActivity(),currentitem+"",Toast.LENGTH_SHORT).show();

                if (currentitem-1 < 2) {
                    // move to next screen
                    viewPager.setCurrentItem(currentitem);
                    current_page=0;              }



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
        viewPager = view.findViewById(R.id.viewpager);

        // setting up the adapter
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.add(new My_Bookings_Fragment(), "Page 2");
        viewPagerAdapter.add(new My_Requests_Fragment(), "Page 1");









    }

    private void check() {
        switch (current_page){
            case 0:
                my_requests.setBackground((ContextCompat.getDrawable(getContext(), R.drawable.btn3)));
                my_requests_tv.setTextColor(getResources().getColor(R.color.grey));
                bag.setImageDrawable((ContextCompat.getDrawable(getContext(), R.drawable.ic_bag)));
                //*************************************************************************************
                my_reservations.setBackground((ContextCompat.getDrawable(getContext(), R.drawable.btn3_white)));
                reservations.setImageDrawable((ContextCompat.getDrawable(getContext(), R.drawable.ic_reservations_blue)));
                reservations_tv.setTextColor(getResources().getColor(R.color.blue_text));
                break;
            case 1:
                my_reservations.setBackground((ContextCompat.getDrawable(getContext(), R.drawable.btn3)));
                reservations.setImageDrawable((ContextCompat.getDrawable(getContext(), R.drawable.ic_reservations)));
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
  //      transaction.replace(R.id.profile_fragment_container, fragment);
        transaction.commit();

    }
}