package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.movieapp.AppLogic.RecyclerViewAdapter;
import com.example.movieapp.DataStorrage.AsyncResponse;
import com.example.movieapp.Domain.MovieElements;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AsyncResponse {
    public ImageView imageView2;
    public Button all;
    public Button date;
    public Button rating;
    public Button expected;
    List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setImageResource(R.drawable.mainmenucover);


        all = (Button) findViewById(R.id.POPULAR);
        all.setTextColor(Color.parseColor("#ffa500"));
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all.setTextColor(Color.parseColor("#ffa500"));
                date.setTextColor(Color.parseColor("#FFFFFF"));
                rating.setTextColor(Color.parseColor("#FFFFFF"));
                expected.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });

        date = (Button) findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all.setTextColor(Color.parseColor("#FFFFFF"));
                date.setTextColor(Color.parseColor("#ffa500"));
                rating.setTextColor(Color.parseColor("#FFFFFF"));
                expected.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });

        rating = (Button) findViewById(R.id.rating);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all.setTextColor(Color.parseColor("#FFFFFF"));
                date.setTextColor(Color.parseColor("#FFFFFF"));
                rating.setTextColor(Color.parseColor("#ffa500"));
                expected.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });

        expected = (Button) findViewById(R.id.expected);
        expected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all.setTextColor(Color.parseColor("#FFFFFF"));
                date.setTextColor(Color.parseColor("#FFFFFF"));
                rating.setTextColor(Color.parseColor("#FFFFFF"));
                expected.setTextColor(Color.parseColor("#ffa500"));
            }
        });
        movies = new ArrayList<>();
        movies.add(new Movie("Battlefield Earth","2020",R.drawable.dave));
        movies.add(new Movie("john wick","2003",R.drawable.cover2));
        movies.add(new Movie("john wick 2","2009",R.drawable.cover1));
        movies.add(new Movie("iron man","2012",R.drawable.cover3));
        movies.add(new Movie("thor","1980",R.drawable.cover1));
        movies.add(new Movie("lion king","2004",R.drawable.cover2));
        movies.add(new Movie("harry potter","201",R.drawable.cover2));
        movies.add(new Movie("Battlefield Earth","2020",R.drawable.dave));
        movies.add(new Movie("john wick","2003",R.drawable.cover2));
        movies.add(new Movie("john wick 2","2009",R.drawable.cover1));
        movies.add(new Movie("iron man","2012",R.drawable.cover3));
        movies.add(new Movie("thor","1980",R.drawable.cover1));
        movies.add(new Movie("lion king","2004",R.drawable.cover2));
        movies.add(new Movie("harry potter","201",R.drawable.cover2));
        movies.add(new Movie("Battlefield Earth","2020",R.drawable.cover1));
        movies.add(new Movie("john wick","2003",R.drawable.cover2));
        movies.add(new Movie("john wick 2","2009",R.drawable.cover1));
        movies.add(new Movie("iron man","2012",R.drawable.cover3));
        movies.add(new Movie("thor","1980",R.drawable.cover1));
        movies.add(new Movie("lion king","2004",R.drawable.cover2));
        movies.add(new Movie("harry potter","201",R.drawable.cover2));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recycleview);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,movies);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);

    }

    @Override
    public void processFinish(ArrayList<MovieElements> output) {
        //zooi voor recyclerview, en adapter
    }
}
