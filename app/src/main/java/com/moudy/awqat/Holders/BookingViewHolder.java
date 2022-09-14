package com.moudy.awqat.Holders;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.moudy.awqat.R;

public class BookingViewHolder extends RecyclerView.ViewHolder {
   public ImageView place_photo, stars;
    public TextView place_name, city_name, neighborhood_name, number_of_people_how_rate,price;
    public Button cancel,rate;
    public BookingViewHolder(@NonNull View itemView) {
        super(itemView);

price=itemView.findViewById(R.id.price);
        place_photo = itemView.findViewById(R.id.place_photo);
        stars = itemView.findViewById(R.id.stars);
        place_name = itemView.findViewById(R.id.place_name);
        city_name = itemView.findViewById(R.id.city_name);
        neighborhood_name = itemView.findViewById(R.id.neighborhood_name);
        number_of_people_how_rate = itemView.findViewById(R.id.number_of_people_how_rate);
        rate = itemView.findViewById(R.id.rate_service);

        cancel=itemView.findViewById(R.id.cancel_booking_btn);
    }


}
