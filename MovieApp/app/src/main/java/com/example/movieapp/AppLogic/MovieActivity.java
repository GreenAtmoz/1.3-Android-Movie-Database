package com.example.movieapp.AppLogic;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.movieapp.Domain.MovieElements;
import com.example.movieapp.R;
import com.squareup.picasso.Picasso;

public class MovieActivity extends AppCompatActivity {
    private TextView mFilmTitel;
    private TextView mDescription;
    private ImageView mTrailerButton;
    private ImageView mImage;
    private TextView mRating;
    private TextView mDate;

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

        Bundle extras = getIntent().getExtras();
        final MovieElements movieElement = (MovieElements) extras.getSerializable("ELEMENT");

        Picasso.get()
                .load(movieElement.getImageUrlW500())
                .into(mImage);

        mTrailerButton.setImageResource(R.drawable.playbutton);
        mFilmTitel.setText(movieElement.getFilmTitel());
        mDescription.setText(movieElement.getDescription());
        mRating.setText("★ " + movieElement.getRating());
        mDate.setText(movieElement.getDate());
        mDate.setText(movieElement.getDate());
    }
}
