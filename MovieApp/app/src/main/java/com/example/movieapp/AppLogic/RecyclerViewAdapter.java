package com.example.movieapp.AppLogic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieapp.Movie;
import com.example.movieapp.R;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Movie> mdata;

    public RecyclerViewAdapter(Context mContext, List<Movie> mdata) {
        this.mContext = mContext;
        this.mdata = mdata;
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
        //TODO omzetten naar online api
        holder.movieTitle.setText(mdata.get(position).getTitle());
        holder.img_Cover.setImageResource(mdata.get(position).getThumbnail());
        holder.releasedate.setText(mdata.get(position).getYear());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView movieTitle;
        ImageView img_Cover;
        TextView releasedate;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            movieTitle = (TextView) itemView.findViewById(R.id.MovieTitle);
            img_Cover = (ImageView) itemView.findViewById(R.id.MovieCover);
            releasedate = (TextView) itemView.findViewById(R.id.ReleaseDate);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }

    }
}
