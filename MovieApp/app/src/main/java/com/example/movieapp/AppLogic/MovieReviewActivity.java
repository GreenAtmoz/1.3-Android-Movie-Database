package com.example.movieapp.AppLogic;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

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
    private ScrollView reviewScrollview;
    private TextView fullnamereview;
    private TextView contentreview;
    private ImageView backbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_movie);

        hideNavigationBar();

        reviewScrollview = (ScrollView) findViewById(R.id.reviewScrollview);
        reviewScrollview.setVisibility(View.GONE);
        fullnamereview = (TextView) findViewById(R.id.fullnamereview);
        contentreview = (TextView) findViewById(R.id.contentreview);
        backbutton = (ImageView) findViewById(R.id.backbutton);
        backbutton.setImageResource(R.drawable.backarrow);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reviewScrollview.setVisibility(View.GONE);
            }
        });


        Bundle extras = getIntent().getExtras();
        movieElement = (MovieElements) extras.getSerializable("ELEMENT");

        reviews = new ArrayList<>();
        ReviewsDataProcessing reviewsDataProcessing = new ReviewsDataProcessing(movieElement.getId());
        reviewsDataProcessing.asyncResponse = this;
        reviewsDataProcessing.execute();
    }

    @Override
    protected void onResume() {
        super.onResume();

        hideNavigationBar();
    }

    private void hideNavigationBar() {
        this.getWindow()
                .getDecorView()
                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }

    @Override
    public void processArrayStringsFinish(ArrayList<Review> output) {
        reviews = output;
        reviewRecylerview = (RecyclerView) findViewById(R.id.reviewrecyclerview);
        reviewLayoutManager = new LinearLayoutManager(this);
        reviewAdapter = new ReviewAdapter(reviews,reviewScrollview,fullnamereview,contentreview);
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
