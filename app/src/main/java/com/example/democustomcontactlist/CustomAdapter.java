package com.example.democustomcontactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter
{
    Context parent_context;
    int layout_id;
    ArrayList<Contact> contactList;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Contact> objects)
    {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        contactList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater =(LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id,parent,false);
        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvCode = rowView.findViewById(R.id.textViewCountryCode);
        TextView tvNum = rowView.findViewById(R.id.textViewPhoneNum);
        ImageView ivGender = rowView.findViewById(R.id.imageView);
        RatingBar rb = rowView.findViewById(R.id.ratingBar);

        Contact currentItem = contactList.get(position);
        tvName.setText(currentItem.getName());
        tvCode.setText("+" + currentItem.getCountryCode());
        tvNum.setText(currentItem.getPhoneNum() + "");

        if(currentItem.getGender() == 'M' || currentItem.getGender()=='m')
        {
            ivGender.setImageResource(R.drawable.male);
        }
        else if(currentItem.getGender()== 'F'|| currentItem.getGender() =='f')
        {
            ivGender.setImageResource(R.drawable.female);
        }
        else
        {
            ivGender.setVisibility(View.INVISIBLE);
        }

        rb.setRating(currentItem.getRating());
        return rowView;
    }
}
