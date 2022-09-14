package com.moudy.awqat.fragments;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.moudy.awqat.Adapters.ViewPagerAdapter;
import com.moudy.awqat.ViewPagerTransformer.CubeOutPageTransformer;
import com.moudy.awqat.R;
import com.moudy.awqat.ViewPagerTransformer.RotateUpPageTransformer;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment {
    LinearLayout my_requests, my_reservations;
    ImageView bag, reservations;
    TextView my_requests_tv, reservations_tv;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    int current_page = 0;
    ImageButton edit_profile_photo;
    public Uri imageuri;
    CircleImageView profile_photo;
    String uri;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initViews(view);


        // Reference (or instantiate) a ViewPager instance and apply a transformer


        // Set the adapter
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setPageTransformer(true, new RotateUpPageTransformer());
        viewPagerAdapter.notifyDataSetChanged();
        int currentitem = viewPager.getCurrentItem() + 1;

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    current_page = 0;

                    check();

                } else {
                    current_page = 1;

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

                    current_page = 0;
                }
            }
        });
        my_reservations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentitem = viewPager.getCurrentItem() - 1;
                //  Toast.makeText(getActivity(),currentitem+"",Toast.LENGTH_SHORT).show();

                if (currentitem - 1 < 2) {
                    // move to next screen
                    viewPager.setCurrentItem(currentitem);
                    current_page = 0;
                }


                check();
                ReplaceFragment(new My_Bookings_Fragment());

            }
        });
        edit_profile_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);

                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });
        profile_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage();
            }
        });
        return view;
    }

    private void initViews(View view) {
        my_requests = (LinearLayout) view.findViewById(R.id.my_requests);
        my_reservations = (LinearLayout) view.findViewById(R.id.my_reservations);
        bag = view.findViewById(R.id.bag);
        reservations = view.findViewById(R.id.reservations);
        reservations_tv = view.findViewById(R.id.reservations_tv);
        my_requests_tv = view.findViewById(R.id.my_requests_tv);
        viewPager = view.findViewById(R.id.viewpager);
        edit_profile_photo = view.findViewById(R.id.edit_profile_image);
        profile_photo = view.findViewById(R.id.profile_photo);
        // setting up the adapter
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.add(new My_Bookings_Fragment(), "Page 2");
        viewPagerAdapter.add(new My_Requests_Fragment(), "Page 1");


    }

    private void check() {
        switch (current_page) {
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageuri = data.getData();
            profile_photo.setImageURI(imageuri);
            uri= String.valueOf(imageuri);

        }
    }
    public void showImage(){
        Dialog builder = new Dialog(getActivity(),R.style.PauseDialog);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));

        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //nothing;
            }
        });
        ImageView imageView = new ImageView(getActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(350, 450);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageURI(Uri.parse(uri));
        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT

       ));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.dismiss();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    }
                },1000);
            }




        });
        builder.show();
    }

}