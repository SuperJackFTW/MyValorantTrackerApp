package com.example.myvaloranttrackerapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.litepal.LitePal;

public class SecondFragment extends Fragment {

    private TextView textView3, textView4,fragment2Name, fragment2Developer;
    private ImageView imageView, fragment2ImageView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "name";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        textView3 = view.findViewById(R.id.textView3);
        textView4 = view.findViewById(R.id.textView4);
        fragment2Name = view.findViewById(R.id.fragment2Name);
        fragment2Developer = view.findViewById(R.id.fragment2developer);
        imageView = view.findViewById(R.id.imageView);
        fragment2ImageView = view.findViewById(R.id.fragment2ImageView);

        if(mParam1 != null){
            DatabaseColumn getResults = LitePal.where("displayName = ?", mParam1).findFirst(DatabaseColumn.class);
            textView4.setText(getResults.getDescription());
            Picasso.get().load(getResults.getFullPortrait()).into(imageView);
            textView3.setText(getResults.getUuid());
            fragment2Name.setText("Name: "+ getResults.getDisplayName());
            fragment2Developer.setText("Developer: " + getResults.getDeveloperName());
            Picasso.get().load(getResults.getDisplayIcon()).into(fragment2ImageView);
        }

        return view;
    }
}