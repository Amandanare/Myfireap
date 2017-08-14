package com.example.admin.myfireap;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Admin on 8/3/2017.
 */

public class tourAdapter extends ArrayAdapter<Tours> {



    public tourAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Tours> objects) {
        super(context, resource, objects);

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_tour_guide_soshanguve,parent,false);
        }
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        TextView headTextView = (TextView) listItemView.findViewById(R.id.head);
        TextView descrTextView = (TextView) listItemView.findViewById(R.id.description);

        Tours tour = getItem(position);
        boolean isPhoto = tour.getPhotoUrl() != null;
        if (isPhoto){
            Glide.with(imageView.getContext())
                    .load(tour.getPhotoUrl())
                    .into(imageView);
            headTextView.setText(tour.getHead());
            descrTextView.setText(tour.getDescription());
        }else{
            imageView.setVisibility(View.GONE);
            headTextView.setText(tour.getHead());
            descrTextView.setText(tour.getDescription());

        }

        return listItemView;

    }
}
