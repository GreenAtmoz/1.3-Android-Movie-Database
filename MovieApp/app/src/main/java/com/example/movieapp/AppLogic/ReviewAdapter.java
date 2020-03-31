package com.example.movieapp.AppLogic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.DataStorrage.Review;
import com.example.movieapp.R;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {
    private ArrayList<Review> reviews;
    private ScrollView scrollView;
    private TextView reviewName;
    private TextView reviewScrollviewContent;


    public ReviewAdapter(ArrayList<Review> reviews, ScrollView scrollView, TextView one, TextView reviewScrollviewContent) {
        this.reviews = reviews;
        this.scrollView = scrollView;
        this.reviewName = one;
        this.reviewScrollviewContent = reviewScrollviewContent;
    }

    @NonNull
    @Override
    public ReviewAdapter.ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_review,parent,false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ReviewAdapter.ReviewViewHolder holder, final int position) {
        holder.fullName.setAllCaps(true);
        holder.fullName.setText(reviews.get(position).getAuthor());
        holder.reviewContent.setText(reviews.get(position).getContent());
        holder.expandreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reviewName.setText(reviews.get(position).getAuthor());
                reviewScrollviewContent.setText(reviews.get(position).getContent());
                scrollView.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {

        public TextView fullName;
        public TextView reviewContent;
        private TextView expandreview;


        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            fullName = (TextView) itemView.findViewById(R.id.fullname);
            reviewContent = (TextView) itemView.findViewById(R.id.reviewcontent);
            expandreview = (TextView) itemView.findViewById(R.id.expandreview);


        }
    }
}
