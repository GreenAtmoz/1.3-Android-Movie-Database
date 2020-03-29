package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.example.movieapp.AppLogic.RecyclerViewAdapter;
import com.example.movieapp.DataStorrage.AsyncResponse;
import com.example.movieapp.DataStorrage.DataProcessing.DateDataProcessing;
import com.example.movieapp.DataStorrage.DataProcessing.ExpectedDataProcessing;
import com.example.movieapp.DataStorrage.DataProcessing.PopularDataProcessing;
import com.example.movieapp.DataStorrage.DataProcessing.RatingDataProcessing;
import com.example.movieapp.DataStorrage.NetworkUtils;
import com.example.movieapp.Domain.MovieElements;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AsyncResponse {
    public ImageView imageView2;
    public Button all;
    public Button date;
    public Button rating;
    public Button expected;
    private ArrayList<MovieElements> movieElements;
    private int white;
    private int orange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Mainactivity","oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setImageResource(R.drawable.mainmenucover);

        white = getResources().getColor(R.color.white);
        orange = getResources().getColor(R.color.orange);
        NetworkUtils.language = Language.ENGLISH;

        movieElements = new ArrayList<>();
        PopularDataProcessing popularDataProcessing = null;
        popularDataProcessing = new PopularDataProcessing(movieElements);
        popularDataProcessing.asyncResponse = MainActivity.this;
        popularDataProcessing.execute();

        all = (Button) findViewById(R.id.POPULAR);
        all.setTextColor(orange);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all.setTextColor(orange);
                date.setTextColor(white);
                rating.setTextColor(white);
                expected.setTextColor(white);

                movieElements = new ArrayList<>();
                PopularDataProcessing popularDataProcessing = null;
                popularDataProcessing = new PopularDataProcessing(movieElements);
                popularDataProcessing.asyncResponse = MainActivity.this;
                popularDataProcessing.execute();
            }
        });

        date = (Button) findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all.setTextColor(white);
                date.setTextColor(orange);
                rating.setTextColor(white);
                expected.setTextColor(white);

                movieElements = new ArrayList<>();
                DateDataProcessing dateDataProcessing = new DateDataProcessing(movieElements);
                dateDataProcessing.asyncResponse = MainActivity.this;
                dateDataProcessing.execute();
            }
        });

        rating = (Button) findViewById(R.id.rating);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all.setTextColor(white);
                date.setTextColor(white);
                rating.setTextColor(orange);
                expected.setTextColor(white);

                movieElements = new ArrayList<>();
                RatingDataProcessing ratingDataProcessing = null;
                ratingDataProcessing = new RatingDataProcessing(movieElements);
                ratingDataProcessing.asyncResponse = MainActivity.this;
                ratingDataProcessing.execute();
            }
        });

        expected = (Button) findViewById(R.id.expected);
        expected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all.setTextColor(white);
                date.setTextColor(white);
                rating.setTextColor(white);
                expected.setTextColor(orange);

                movieElements = new ArrayList<>();
                ExpectedDataProcessing expectedDataProcessing = null;
                expectedDataProcessing = new ExpectedDataProcessing(movieElements);
                expectedDataProcessing.asyncResponse = MainActivity.this;
                expectedDataProcessing.execute();
            }
        });
    }

    @Override
    public void processFinish(ArrayList<MovieElements> output) {
        Log.d("MainActivity", "processFinish: is called");
        movieElements = output;
        RecyclerView myrv = (RecyclerView) findViewById(R.id.recycleview);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, movieElements);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);//.
    }
}
