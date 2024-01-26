package com.example.myvaloranttrackerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Agents_RecyclerViewAdapter extends RecyclerView.Adapter<Agents_RecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<Users> usersModel;
    public Agents_RecyclerViewAdapter(Context context, ArrayList<Users> usersModel){
        this.context = context;
        this.usersModel = usersModel;
    }

    @NonNull
    @Override
    public Agents_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Give a look of layout to each of the rows
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_layout, parent,false);
        return new Agents_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Agents_RecyclerViewAdapter.MyViewHolder holder, int position) {
        //Assigning the values to each views created in the recycler view layout file
        holder.recyclerName.setText(usersModel.get(position).getUuid());
    }

    @Override
    public int getItemCount() {
        //just wants the number of items wanted to be displayed
        return usersModel.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView recyclerImage;
        TextView recyclerName, recyclerDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            recyclerImage = itemView.findViewById(R.id.recyclerImage);
            recyclerName = itemView.findViewById(R.id.recyclerName);
            recyclerDescription = itemView.findViewById(R.id.recyclerDescription);
        }
    }
}
