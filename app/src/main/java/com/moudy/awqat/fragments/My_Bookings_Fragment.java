package com.moudy.awqat.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moudy.awqat.Adapters.BookingAdapter;
import com.moudy.awqat.Modle.Booking;
import com.moudy.awqat.R;

import java.util.ArrayList;


public class My_Bookings_Fragment extends Fragment {
ArrayList<Booking> bookings;
RecyclerView recyclerView;
    public My_Bookings_Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_my__bookings_, container, false);
        recyclerView=view.findViewById(R.id.rv);
bookings=new ArrayList<>();
bookings.add(new Booking("عيادة تجميل تخصصية","الرياض","حي الرياض","50",80,R.drawable.beauty_clinic,R.drawable.ic_five_stars));
        bookings.add(new Booking("شاليه  أخضر مع ملعب طائرة","الرياض","حي الرياض","50",50,R.drawable.green_chalet,R.drawable.ic_five_stars));

        BookingAdapter bookingAdapter=new BookingAdapter(bookings);
        recyclerView.setAdapter(bookingAdapter);
        recyclerView.hasFixedSize();
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext());
recyclerView.setLayoutManager(lm);
return view ;
    }
}