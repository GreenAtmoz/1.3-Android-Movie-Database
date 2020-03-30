package com.example.movieapp.AppLogic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movieapp.DataStorrage.AsyncResponse;
import com.example.movieapp.DataStorrage.Review;
import com.example.movieapp.DataStorrage.TrailerLinkFinder;
import com.example.movieapp.Domain.MovieElements;
import com.example.movieapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity implements AsyncResponse {
    private TextView mFilmTitel;
    private TextView mDescription;
    private ImageView mTrailerButton;
    private ImageView mImage;
    private TextView mRating;
    private TextView mDate;
    public ImageView heart;
    WebView webView;
    public ImageView trailerExit;
    private MovieElements movieElement;
    private String youtubeLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        mFilmTitel = (TextView) findViewById(R.id.myImageViewText);
        mDescription = (TextView) findViewById(R.id.filmdescription);
        mImage = (ImageView) findViewById(R.id.movieImage);
        mTrailerButton = (ImageView) findViewById(R.id.trailerButton);
        mRating = (TextView) findViewById(R.id.rating);
        mDate = (TextView) findViewById(R.id.filmdata);
        heart = (ImageView) findViewById(R.id.heart);

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        final WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setEnabled(false);
        webView.setVisibility(View.GONE);

        trailerExit = (ImageView) findViewById(R.id.exittrailer);
        trailerExit.setEnabled(false);
        trailerExit.setVisibility(View.GONE);

        Bundle extras = getIntent().getExtras();
        movieElement = (MovieElements) extras.getSerializable("ELEMENT");


        Picasso.get()
                .load(movieElement.getImageUrlW500())
                .into(mImage);

        mTrailerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrailerLinkFinder trailerLinkFinder = new TrailerLinkFinder(movieElement.getId());
                trailerLinkFinder.asyncResponse = MovieActivity.this;
                trailerLinkFinder.execute();
            }
        });

        trailerExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.setVisibility(View.GONE);
                webView.setEnabled(false);
                webView.loadUrl(youtubeLink);
                heart.setVisibility(View.VISIBLE);
                heart.setEnabled(true);
                trailerExit.setEnabled(false);
                trailerExit.setVisibility(View.GONE);
                mTrailerButton.setEnabled(true);
                mTrailerButton.setVisibility(View.VISIBLE);
            }
        });
        trailerExit.setImageResource(R.drawable.exit);
        mTrailerButton.setImageResource(R.drawable.playbutton);
        heart.setImageResource(R.drawable.heart);

        mFilmTitel.setText(movieElement.getFilmTitel());
        mDescription.setText(movieElement.getDescription());
        mRating.setText("★ " + movieElement.getRating());
        mDate.setText(movieElement.getDate());
        mDate.setText(movieElement.getDate());
    }

    @Override
    public void processStringFinish(String output) {
        youtubeLink = output;
        webView.loadUrl(youtubeLink);
        webView.setVisibility(View.VISIBLE);
        webView.setEnabled(true);
        heart.setVisibility(View.GONE);
        heart.setEnabled(false);
        trailerExit.setEnabled(true);
        trailerExit.setVisibility(View.VISIBLE);
        mTrailerButton.setEnabled(false);
        mTrailerButton.setVisibility(View.GONE);
    }

    @Override
    public void processArrayStringsFinish(ArrayList<Review> output) {
    }

    @Override
    public void processFinish(ArrayList<MovieElements> output) {
    }
}
