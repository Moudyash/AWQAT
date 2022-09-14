package com.moudy.awqat.Holders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moudy.awqat.R;

public class MyCartViewHolder extends RecyclerView.ViewHolder {
    public ImageView place_photo, stars,delete;
    public TextView place_name, city_name, neighborhood_name, number_of_people_how_rate,price,count_of_product;
    public Button increase,decrease;
    public MyCartViewHolder(@NonNull View itemView) {
        super(itemView);

        price=itemView.findViewById(R.id.price);
        place_photo = itemView.findViewById(R.id.product_image);
        stars = itemView.findViewById(R.id.stars);
        place_name = itemView.findViewById(R.id.product_name);
        city_name = itemView.findViewById(R.id.city_name);
        neighborhood_name = itemView.findViewById(R.id.neighborhood_name);
        number_of_people_how_rate = itemView.findViewById(R.id.number_of_people_how_rate);
        increase = itemView.findViewById(R.id.increase_btn);
        decrease = itemView.findViewById(R.id.decrease_btn);
delete=itemView.findViewById(R.id.delete_btn);
        count_of_product=itemView.findViewById(R.id.count_of_product);


    }
}
