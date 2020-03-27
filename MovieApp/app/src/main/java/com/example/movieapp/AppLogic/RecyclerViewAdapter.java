package com.example.movieapp.AppLogic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieapp.Domain.MovieElements;
import com.example.movieapp.R;
import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<MovieElements> movieElements;

    public RecyclerViewAdapter(Context mContext, ArrayList<MovieElements> movieElements) {
        this.mContext = mContext;
        this.movieElements = movieElements;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_movie,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.movieTitle.setText(movieElements.get(position).getFilmTitel());
        Picasso.get()
                //.load(movieElements.get(position).getImageUrl())
                .load("D:\\Pictures\\Pictures\\Other Pictures\\Croissant Man (cut version).png")
                .into(holder.img_Cover);
        //holder.img_Cover.setImageResource(movieElements.get(position).getThumbnail());
        holder.releasedate.setText(movieElements.get(position).getDate().substring(0,4));
    }


    @Override
    public int getItemCount() {
        return movieElements.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView movieTitle;
        ImageView img_Cover;
        TextView releasedate;

        public MyViewHolder(View itemView) {
            super(itemView);
            movieTitle = (TextView) itemView.findViewById(R.id.MovieTitle);
            img_Cover = (ImageView) itemView.findViewById(R.id.MovieCover);
            releasedate = (TextView) itemView.findViewById(R.id.ReleaseDate);
        }
    }
}
