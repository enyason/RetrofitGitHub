package com.nexdev.enyason.retrofitgithub;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by enyason on 5/24/18.
 */

public class MyArrayAdapter extends ArrayAdapter<GitHubRepo> {

    public MyArrayAdapter(@NonNull Context context,  @NonNull List<GitHubRepo> objects) {
        super(context, 0, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Get the data item for this position
        GitHubRepo user = getItem(position);


        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_item,parent,false);
        }



        // Lookup view for data population
        TextView tvName =  convertView.findViewById(R.id.tv_repo);

        // Populate the data into the template view using the data object

        tvName.setText(user.getName());
        // Return the completed view to render on screen
        return convertView;



    }
}
