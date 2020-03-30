package com.example.movieapp.AppLogic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {
    ArrayList<String> reviewElements;
    public ReviewAdapter(ArrayList<String> reviews) {
        reviewElements = reviews;
    }

    @NonNull
    @Override
    public ReviewAdapter.ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_review,parent,false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapter.ReviewViewHolder holder, int position) {
        holder.fullname.setText(reviewElements.get(position));
    }

    @Override
    public int getItemCount() {
        return reviewElements.size();
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        public TextView fullname;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            fullname = (TextView) itemView.findViewById(R.id.fullname);
        }
    }
}
