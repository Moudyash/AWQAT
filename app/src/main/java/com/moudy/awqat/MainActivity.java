package com.moudy.awqat;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.slider.RangeSlider;
import com.moudy.awqat.fragments.DashboardFragment;
import com.moudy.awqat.fragments.FavouriteFragment;
import com.moudy.awqat.fragments.HomeFragment;
import com.moudy.awqat.fragments.ProfileFragment;
import com.moudy.awqat.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ImageView nav, shop;
    LinearLayout SearchBar;
ImageButton filter_btn;
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
                        break;
                    case R.id.profile:
                        ReplaceFragment(new ProfileFragment());
                        SearchBar.setVisibility(GONE);


                        break;
                    case R.id.favourite:
                        ReplaceFragment(new FavouriteFragment());
                        SearchBar.setVisibility(VISIBLE);


                        break;
                    case R.id.dashboard:
                        ReplaceFragment(new DashboardFragment());
                        SearchBar.setVisibility(VISIBLE);

                        break;
                    case R.id.home:
                        ReplaceFragment(new HomeFragment());
                        SearchBar.setVisibility(VISIBLE);


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
        shop = (ImageView) findViewById(R.id.shop);
        SearchBar=findViewById(R.id.search_bar_layout);
        filter_btn=findViewById(R.id.filter_btn);

    }
    private void showBottomSheetDialog() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog_layout);

        bottomSheetDialog.show();
    }
}