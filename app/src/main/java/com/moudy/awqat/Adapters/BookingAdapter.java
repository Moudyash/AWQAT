package com.moudy.awqat.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moudy.awqat.Holders.BookingViewHolder;
import com.moudy.awqat.Modle.Booking;
import com.moudy.awqat.R;
import com.moudy.awqat.fragments.ProfileFragment;

import java.util.ArrayList;

public class BookingAdapter extends RecyclerView.Adapter<BookingViewHolder> {

    ArrayList<Booking> bookings;
Context context;

    public BookingAdapter(Context context) {
        this.context = context;
    }

    public BookingAdapter(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    @NonNull
    @Override
    public BookingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_item,parent,false);
        return new BookingViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingViewHolder holder, int position) {
    Booking b=bookings.get(position);
holder.place_name.setText(b.getPlace_name().toString());
holder.neighborhood_name.setText(b.getNeighborhood_name().toString());
        holder.city_name.setText(b.getCity_name().toString());
        holder.number_of_people_how_rate.setText(""+b.getNumber_of_people_how_rate());
        holder.place_photo.setImageResource(b.getPlace_photo());
        holder.stars.setImageResource(b.getStars());
        holder.price.setText(""+b.getPrice());

        holder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Done_Dialog("تم الغاء الخدمة");
            }
        });


    }

    @Override
    public int getItemCount() {
        return bookings.size();
    }

    public void Done_Dialog(String desciption) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.done_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(true);

        TextView tv_desciption=dialog.findViewById(R.id.text);
        tv_desciption.setText(desciption);
        ((Button) dialog.findViewById(R.id.btn_done)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        dialog.show();


    }
}
