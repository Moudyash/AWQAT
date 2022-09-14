package com.moudy.awqat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.moudy.awqat.Adapters.MycartAdapter;
import com.moudy.awqat.Modle.Mycart;

import java.util.ArrayList;

public class My_Cart extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<Mycart> my_carts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);
        initToolbar();

        recyclerView= (RecyclerView) findViewById(R.id.mycart_rv);
        my_carts=new ArrayList<Mycart>();
        my_carts.add(new Mycart("عيادة تجميل تخصصية","الرياض","حي الرياض","50","1",80,R.drawable.beauty_clinic,R.drawable.ic_five_stars));
        MycartAdapter mycartAdapter =new MycartAdapter(my_carts);
        recyclerView.setAdapter(mycartAdapter);
        recyclerView.hasFixedSize();
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);
    }
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("عربتي");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}