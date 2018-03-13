package com.ngocdiem.exercise3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {
    TextView txtMovieName,txtSumarize,txtRealeaseDate;
    RatingBar ratingBar;
    ImageView imgMovie;
    Profile profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtMovieName = findViewById(R.id.txtMovieName);
        txtSumarize = findViewById(R.id.txtSumarize);
        txtRealeaseDate = findViewById(R.id.txtRealeaseDate);
        ratingBar = findViewById(R.id.ratingBar);
        imgMovie = findViewById(R.id.imgMovie);
        ratingBar.setMax(5);
        ratingBar.setFocusable(false);
        Intent intent = getIntent();
        int position = intent.getIntExtra("Position",0);
        profile = MainActivity.moviesList.get(position);
        Picasso.with(this).load("https://image.tmdb.org/t/p/w500"+profile.getBackdropPath()).resize(350, 200).into(imgMovie);
        txtMovieName.setText(profile.getTitle());
        txtSumarize.setText(profile.getOverview());
        txtRealeaseDate.setText(profile.getReleaseDate());
        ratingBar.setRating(profile.getVoteAverage().floatValue()/2);
        txtSumarize.setMovementMethod(new ScrollingMovementMethod());
    }
}
