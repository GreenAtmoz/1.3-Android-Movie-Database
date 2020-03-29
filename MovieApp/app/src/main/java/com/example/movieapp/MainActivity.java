package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.movieapp.AppLogic.MovieActivity;
import com.example.movieapp.AppLogic.RecyclerViewAdapter;
import com.example.movieapp.DataStorrage.AsyncResponse;
import com.example.movieapp.DataStorrage.PopularDataProcessing;
import com.example.movieapp.Domain.MovieElements;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AsyncResponse {
    public ImageView imageView2;
    public Button all;
    public Button date;
    public Button rating;
    public Button expected;
    private ArrayList<MovieElements> movieElements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Mainactivity","oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setImageResource(R.drawable.mainmenucover);

        movieElements = new ArrayList<>();
        PopularDataProcessing popularDataProcessing = new PopularDataProcessing(movieElements);
        popularDataProcessing.asyncResponse = this;
        popularDataProcessing.execute();

        all = (Button) findViewById(R.id.all);
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


    }

    @Override
    public void processFinish(ArrayList<MovieElements> output) {
        Log.d("MainActivity", "processFinish: is called");
        movieElements = output;
        RecyclerView myrv = (RecyclerView) findViewById(R.id.recycleview);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, movieElements);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);
    }
}
