package com.example.dogapp.viewmodel;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogapp.R;
import com.example.dogapp.model.DogBreed;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.ViewHolder> {
    private List<DogBreed> dogs;

    public DogsAdapter(List<DogBreed> dogs) {
        this.dogs = dogs;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final TextView name, description;

        public ViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.image);
            name = (TextView) view.findViewById(R.id.name);
            description = (TextView) view.findViewById(R.id.description);
        }

        public ImageView getImage() {
            return image;
        }
        public TextView getName() { return name; }
        public TextView getDescription() { return description; }
    }

    @NonNull
    @Override
    public DogsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dog_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogsAdapter.ViewHolder holder, int position) {
        holder.getName().setText(dogs.get(position).getName());
        holder.getDescription().setText(dogs.get(position).getBredFor());
        Picasso.get()
                .load(dogs.get(position).getUrl())
                .placeholder(R.drawable.ic_baseline_photo_24)
                .fit()
                .into(holder.getImage());
    }

    @Override
    public int getItemCount() {
        return dogs.size();
    }
}
