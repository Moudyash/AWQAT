package com.moudy.awqat;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationBarView;
import com.moudy.awqat.fragments.DashboardFragment;
import com.moudy.awqat.fragments.FavouriteFragment;
import com.moudy.awqat.fragments.HomeFragment;
import com.moudy.awqat.fragments.ProfileFragment;
import com.moudy.awqat.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ImageView nav, myCart, img_first_filter, img_second_filter, img_third_filter, img_fourth_filter, img_fifth_filter;
    LinearLayout SearchBar,filter_emoji;
    ImageButton filter_btn;
    LinearLayout first_filter, second_filter, third_filter, fourth_filter, fifth_filter;
    TextView tv_first_filter, tv_second_filter, tv_third_filter, tv_fourth_filter, tv_fifth_filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int itemId = item.getItemId();
                switch (item.getItemId()) {
                    case R.id.settings:
                        ReplaceFragment(new SettingsFragment());
                        SearchBar.setVisibility(GONE);
                        filter_emoji.setVisibility(GONE);


                        break;
                    case R.id.profile:
                        ReplaceFragment(new ProfileFragment());
                        SearchBar.setVisibility(GONE);
                        filter_emoji.setVisibility(GONE);


                        break;
                    case R.id.favourite:
                        ReplaceFragment(new FavouriteFragment());
                        SearchBar.setVisibility(VISIBLE);
                        filterbar(R.drawable.waving_hand,"الكل"
                                ,R.drawable.home,"أماكن الترفيه",
                                R.drawable.hospital, "العيادات",
                                R.drawable.meals, "الوجبات",
                                R.drawable.shopping,"التسوق");

                        break;
                    case R.id.dashboard:
                        ReplaceFragment(new DashboardFragment());
                        SearchBar.setVisibility(VISIBLE);
                        filter_emoji.setVisibility(GONE);

                        break;
                    case R.id.home:
                        ReplaceFragment(new HomeFragment());
                        filter_emoji.setVisibility(GONE);

                        SearchBar.setVisibility(VISIBLE);

                        filterbar(R.drawable.waving_hand,"الكل"
                                ,R.drawable.home,"أماكن الترفيه",
                                R.drawable.hospital, "العيادات",
                                R.drawable.meals, "الوجبات",
                                R.drawable.shopping,"التسوق");

                        break;

                }

                return true;
            }
        });
        filter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog();
            }
        });
        myCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, My_Cart.class));
            }
        });
    }

    private void ReplaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
        // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

    }

    private void initViews() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        nav = (ImageView) findViewById(R.id.nav);
        myCart = (ImageView) findViewById(R.id.myCart);
        SearchBar = findViewById(R.id.search_bar_layout);
        filter_btn = findViewById(R.id.filter_btn);
        first_filter = (LinearLayout) findViewById(R.id.first_filter);

        second_filter = (LinearLayout) findViewById(R.id.second_filter);
        third_filter = (LinearLayout) findViewById(R.id.third_filter);
        fourth_filter = (LinearLayout) findViewById(R.id.fourth_filter);
        fifth_filter = (LinearLayout) findViewById(R.id.fifth_filter);


        tv_first_filter = findViewById(R.id.tv_first_filter);
        tv_second_filter = findViewById(R.id.tv_second_filter);
        tv_third_filter = findViewById(R.id.tv_third_filter);
        tv_fourth_filter = findViewById(R.id.tv_fourth_filter);
        tv_fifth_filter = findViewById(R.id.tv_fifth_filter);
        img_first_filter = findViewById(R.id.img_first_filter);
        img_second_filter = findViewById(R.id.img_second_filter);
        img_third_filter = findViewById(R.id.img_third_filter);
        img_fourth_filter = findViewById(R.id.img_fourth_filter);
        img_fifth_filter = findViewById(R.id.img_fifth_filter);
        filter_emoji=findViewById(R.id.filter_emoji);
        filter_emoji.setVisibility(GONE);

    }

    private void showBottomSheetDialog() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog_layout);

        bottomSheetDialog.show();
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