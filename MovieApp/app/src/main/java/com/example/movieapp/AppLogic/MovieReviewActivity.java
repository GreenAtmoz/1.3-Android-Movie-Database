package com.example.movieapp.AppLogic;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.movieapp.DataStorrage.DataProcessing.AsyncResponse;
import com.example.movieapp.DataStorrage.DataProcessing.ReviewsDataProcessing;
import com.example.movieapp.Domain.Review;
import com.example.movieapp.Domain.MovieElements;
import com.example.movieapp.R;
import java.util.ArrayList;

public class MovieReviewActivity extends AppCompatActivity implements AsyncResponse {
    private RecyclerView reviewRecylerview;
    private RecyclerView.LayoutManager reviewLayoutManager;
    private RecyclerView.Adapter reviewAdapter;
    private ArrayList<Review> reviews;
    private MovieElements movieElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_movie);

        Bundle extras = getIntent().getExtras();
        movieElement = (MovieElements) extras.getSerializable("ELEMENT");

        reviews = new ArrayList<>();
        ReviewsDataProcessing reviewsDataProcessing = new ReviewsDataProcessing(movieElement.getId());
        reviewsDataProcessing.asyncResponse = this;
        reviewsDataProcessing.execute();
    }

    @Override
    public void processArrayStringsFinish(ArrayList<Review> output) {
        reviews = output;
        reviewRecylerview = (RecyclerView) findViewById(R.id.reviewrecyclerview);
        reviewLayoutManager = new LinearLayoutManager(this);
        reviewAdapter = new ReviewAdapter(reviews);
        reviewRecylerview.setLayoutManager(reviewLayoutManager);
        reviewRecylerview.setAdapter(reviewAdapter);
    }

    @Override
    public void processFinish(ArrayList<MovieElements> output) {

    }

    @Override
    public void processStringFinish(String output) {

    }
}
