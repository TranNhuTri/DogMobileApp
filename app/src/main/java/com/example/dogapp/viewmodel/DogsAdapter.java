package com.example.dogapp.viewmodel;


import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogapp.R;
import com.example.dogapp.model.DogBreed;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DogsAdapter extends RecyclerView.Adapter<DogsAdapter.ViewHolder> {
    private static List<DogBreed> dogs;

    public DogsAdapter(List<DogBreed> dogs) {
        this.dogs = dogs;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final TextView name, description, dtName, dtOrigin, dtLifeSpan, dtTemp;
        public LinearLayout about;
        public LinearLayout detail;

        public ViewHolder(View view) {
            super(view);
            about = view.findViewById(R.id.about);
            detail = view.findViewById(R.id.detail);
            image = (ImageView) view.findViewById(R.id.image);
            name = (TextView) view.findViewById(R.id.name);
            description = (TextView) view.findViewById(R.id.description);
            dtName = view.findViewById(R.id.dt_name);
            dtOrigin = view.findViewById(R.id.dt_origin);
            dtLifeSpan = view.findViewById(R.id.dt_life_span);
            dtTemp = view.findViewById(R.id.dt_temp);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DogBreed dog = dogs.get(getPosition());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("dogBreed", dog);
                    Navigation.findNavController(view).navigate(R.id.detailFragment, bundle);
                }
            });

            view.setOnTouchListener(new OnSwipeTouchListener(){
                @Override
                public boolean onSwipeLeft() {
                    if (about.getVisibility() == View.GONE) {
                        about.setVisibility(View.VISIBLE);
                        detail.setVisibility(View.GONE);
                    } else {
                        about.setVisibility(View.GONE);
                        detail.setVisibility(View.VISIBLE);
                    }
                    return true;
                }

                @Override
                public boolean onSwipeRight() {
                    onSwipeLeft();
                    return true;
                }
            });
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
        holder.dtName.setText(dogs.get(position).getName());
        holder.dtOrigin.setText(dogs.get(position).getOrigin());
        holder.dtLifeSpan.setText(dogs.get(position).getLifeSpan());
        holder.dtTemp.setText(dogs.get(position).getTemperament());
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

class OnSwipeTouchListener implements View.OnTouchListener {

    private final GestureDetector gestureDetector = new GestureDetector(new GestureListener());

    public boolean onTouch(final View v, final MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;


        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            result = onSwipeRight();
                        } else {
                            result = onSwipeLeft();
                        }
                    }
                } else {
                    if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffY > 0) {
                            result = onSwipeBottom();
                        } else {
                            result = onSwipeTop();
                        }
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }

    public boolean onSwipeRight() {
        return false;
    }

    public boolean onSwipeLeft() {
        return false;
    }

    public boolean onSwipeTop() {
        return false;
    }

    public boolean onSwipeBottom() {
        return false;
    }
}

