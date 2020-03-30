package com.example.movieapp.AppLogic;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.Domain.ReviewElements;
import com.example.movieapp.R;

import java.util.ArrayList;

public class MovieReview extends AppCompatActivity {
    private RecyclerView reviewRecylerview;
    private RecyclerView.LayoutManager reviewLayoutManager;
    private RecyclerView.Adapter reviewAdapter;
    private ArrayList<String> reviewElements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_movie);

        reviewElements = new ArrayList<>();
        reviewElements.add("hoeren");
        reviewElements.add("neuken");
        reviewElements.add("nooit");
        reviewElements.add("meer");
        reviewElements.add("werken");

        reviewRecylerview = (RecyclerView) findViewById(R.id.reviewrecyclerview);
        reviewLayoutManager = new LinearLayoutManager(this);
        reviewAdapter = new ReviewAdapter(reviewElements);
        reviewRecylerview.setLayoutManager(reviewLayoutManager);
        reviewRecylerview.setAdapter(reviewAdapter);



    }
}
