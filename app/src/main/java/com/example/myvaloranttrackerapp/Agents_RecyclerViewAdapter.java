package com.example.myvaloranttrackerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Agents_RecyclerViewAdapter extends RecyclerView.Adapter<Agents_RecyclerViewAdapter.MyViewHolder> {

    Context context;
    List<Users.DataClass> usersModel;

    public Agents_RecyclerViewAdapter(Context context, List<Users.DataClass> usersModel){
        this.context = context;
        this.usersModel = usersModel;
    }

    @NonNull
    @Override
    public Agents_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Give a look of layout to each of the rows
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Agents_RecyclerViewAdapter.MyViewHolder holder, int position) {
        //Assigning the values to each views created in the recycler view layout file
        holder.recyclerName.setText(usersModel.get(position).getDisplayName());
        Picasso.get().load(usersModel.get(position).getDisplayIcon()).into(holder.recyclerImage);
    }

    @Override
    public int getItemCount() {
        //just wants the number of items wanted to be displayed
        return usersModel.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView recyclerImage;
        TextView recyclerName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            recyclerImage = itemView.findViewById(R.id.recyclerImage);
            recyclerName = itemView.findViewById(R.id.recyclerName);
        }
    }
}
