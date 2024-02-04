package com.example.myvaloranttrackerapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.litepal.LitePal;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Agents_RecyclerViewAdapter extends RecyclerView.Adapter<Agents_RecyclerViewAdapter.MyViewHolder> {

    Context context;
    List<Users.DataClass> usersModel;

    private OnItemClickListener listener;

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
        RelativeLayout myRelativeLayout = holder.itemView.findViewById(R.id.myRelativeLayout);


        myRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numOfRows = LitePal.count(DatabaseColumn.class);
                String agentName = holder.recyclerName.getText().toString();

                Context newContext = v.getContext();
                Intent myIntent = new Intent(newContext, AgentsActivity.class);
                myIntent.putExtra("NAME",agentName);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                newContext.startActivity(myIntent);
            }
        });
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

    public interface OnItemClickListener{
        void onItemClick(String newText);
    }
}
