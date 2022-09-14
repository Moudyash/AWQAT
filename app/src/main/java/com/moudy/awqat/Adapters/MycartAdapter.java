package com.moudy.awqat.Adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.moudy.awqat.Holders.BookingViewHolder;
import com.moudy.awqat.Holders.MyCartViewHolder;
import com.moudy.awqat.Modle.Booking;
import com.moudy.awqat.Modle.Mycart;
import com.moudy.awqat.R;

import java.util.ArrayList;

public class MycartAdapter extends RecyclerView.Adapter<MyCartViewHolder> {

    ArrayList<Mycart> Mycart;
Context context;
int productcount=1;


    public MycartAdapter(ArrayList<com.moudy.awqat.Modle.Mycart> mycart) {
        Mycart = mycart;
    }

    public MycartAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.mycart_item,parent,false);
        return new MyCartViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCartViewHolder holder, int position) {
        Mycart mycart= Mycart.get(position);
        holder.city_name.setText(mycart.getCity_name());
        holder.place_name.setText(mycart.getPlace_name());
        holder.neighborhood_name.setText(mycart.getNeighborhood_name());
        holder.number_of_people_how_rate.setText(mycart.getNumber_of_people_how_rate());
        holder.price.setText(""+mycart.getPrice());
        holder.place_photo.setImageResource(mycart.getPlace_photo());

        holder.increase.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        productcount++;
        holder.count_of_product.setText(String.valueOf(productcount));

    }
});
        holder.decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (productcount>=1){
                    productcount--;
                    holder.count_of_product.setText(String.valueOf(productcount));
                }else{
                    Snackbar snackbar1 = Snackbar.make(v, "Image Deleted!",Snackbar.LENGTH_SHORT);
                    snackbar1.show();

                }

            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rate_Us_Dialog();
            }
        });

    }

    @Override
    public int getItemCount() {
        return Mycart.size();
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
    public void Rate_Us_Dialog( ) {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.rate_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(true);

        RatingBar ratingbar=dialog.findViewById(R.id.ratingbar);

        String rating=String.valueOf(ratingbar.getRating());

        dialog.show();


    }
}
