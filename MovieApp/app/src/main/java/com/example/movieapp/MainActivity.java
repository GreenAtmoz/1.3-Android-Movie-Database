package com.example.movieapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movieapp.AppLogic.RecyclerViewAdapter;
import com.example.movieapp.DataStorrage.DataProcessing.AsyncResponse;
import com.example.movieapp.DataStorrage.DataProcessing.DateDataProcessing;
import com.example.movieapp.DataStorrage.DataProcessing.ExpectedDataProcessing;
import com.example.movieapp.DataStorrage.DataProcessing.PopularDataProcessing;
import com.example.movieapp.DataStorrage.DataProcessing.RatingDataProcessing;
import com.example.movieapp.Domain.Review;
import com.example.movieapp.DataStorrage.DataProcessing.SearchDataProcessing;
import com.example.movieapp.DataStorrage.NetworkConnection.NetworkUtils;
import com.example.movieapp.Domain.Language;
import com.example.movieapp.Domain.MovieElements;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AsyncResponse {
    public ImageView imageView2;
    public Button popular;
    public Button date;
    public Button rating;
    public Button expected;
    public EditText EditText;
    private ArrayList<MovieElements> movieElements;
    private int buttonColorOffState;
    private int orange;
    private ImageView settingsmenu;
    private TextView dutch;
    private TextView english;
    private Button buttonClicked;
    private LinearLayout settingstab;
    private ImageView loop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Mainactivity","oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dutch = (TextView) findViewById(R.id.dutch);
        dutch.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                dutch.setTextColor(getResources().getColor(R.color.playbuttongreen));
                english.setTextColor(getResources().getColor(R.color.darker_white));
                NetworkUtils.language = Language.NEDERLANDS;
                buttonClicked.performClick();

                Context context = getApplicationContext();
                CharSequence text = getString(R.string.languageChangedNL);
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        english = (TextView) findViewById(R.id.english);
        english.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                dutch.setTextColor(getResources().getColor(R.color.darker_white));
                english.setTextColor(getResources().getColor(R.color.playbuttongreen));
                NetworkUtils.language = Language.ENGLISH;
                buttonClicked.performClick();

                Context context = getApplicationContext();
                CharSequence text = getString(R.string.languageChangedEN);
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setImageResource(R.drawable.mainmenucover);

        settingstab = (LinearLayout) findViewById(R.id.settingstab);
        settingstab.setVisibility(View.GONE);
        settingsmenu = (ImageView) findViewById(R.id.settingsmenu);
        settingsmenu.setImageResource(R.drawable.settingsmenu);
        settingsmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (settingstab.getVisibility() == View.GONE) {
                    settingstab.setVisibility(View.VISIBLE);

                } else {
                    settingstab.setVisibility(View.GONE);

                }
            }
        });

        EditText = (EditText) findViewById(R.id.EditText);
        EditText.setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_NULL
                                && event.getAction() == KeyEvent.ACTION_DOWN &&
                                    event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                            movieElements = new ArrayList<>();
                            SearchDataProcessing searchDataProcessing = new SearchDataProcessing(movieElements, String.valueOf(EditText.getText()) );
                            searchDataProcessing.asyncResponse = MainActivity.this;
                            searchDataProcessing.execute();
                        }
                        return true;
                    }
                }
        );

        loop = (ImageView) findViewById(R.id.loop);
        loop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieElements = new ArrayList<>();
                SearchDataProcessing searchDataProcessing = new SearchDataProcessing(movieElements, String.valueOf(EditText.getText()) );
                searchDataProcessing.asyncResponse = MainActivity.this;
                searchDataProcessing.execute();
            }
        });

        EditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText("");

            }
        });



        buttonColorOffState = getResources().getColor(R.color.white);
        orange = getResources().getColor(R.color.orange);
        NetworkUtils.language = Language.ENGLISH;

        movieElements = new ArrayList<>();
        PopularDataProcessing popularDataProcessing = new PopularDataProcessing(movieElements);
        popularDataProcessing.asyncResponse = MainActivity.this;
        popularDataProcessing.execute();

        popular = (Button) findViewById(R.id.POPULAR);
        popular.setTextColor(orange);
        popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked = popular;
                popular.setTextColor(orange);
                date.setTextColor(buttonColorOffState);
                rating.setTextColor(buttonColorOffState);
                expected.setTextColor(buttonColorOffState);

                movieElements = new ArrayList<>();
                PopularDataProcessing popularDataProcessing = null;
                popularDataProcessing = new PopularDataProcessing(movieElements);
                popularDataProcessing.asyncResponse = MainActivity.this;
                popularDataProcessing.execute();
            }
        });

        buttonClicked = popular;


        date = (Button) findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked = date;
                popular.setTextColor(buttonColorOffState);
                date.setTextColor(orange);
                rating.setTextColor(buttonColorOffState);
                expected.setTextColor(buttonColorOffState);

                movieElements = new ArrayList<>();
                DateDataProcessing dateDataProcessing = null;
                dateDataProcessing = new DateDataProcessing(movieElements);
                dateDataProcessing.asyncResponse = MainActivity.this;
                dateDataProcessing.execute();
            }
        });

        rating = (Button) findViewById(R.id.rating);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked = rating;
                popular.setTextColor(buttonColorOffState);
                date.setTextColor(buttonColorOffState);
                rating.setTextColor(orange);
                expected.setTextColor(buttonColorOffState);

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
                buttonClicked = expected;
                popular.setTextColor(buttonColorOffState);
                date.setTextColor(buttonColorOffState);
                rating.setTextColor(buttonColorOffState);
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
        myrv.setAdapter(myAdapter);
    }

    @Override
    public void processStringFinish(String output) {

    }

    @Override
    public void processArrayStringsFinish(ArrayList<Review> output) {

    }
}
