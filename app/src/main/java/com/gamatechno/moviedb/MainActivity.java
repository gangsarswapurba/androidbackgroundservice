package com.gamatechno.moviedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.gamatechno.moviedb.MainPresenter;
import com.gamatechno.moviedb.MainView;
import com.gamatechno.moviedb.MovieModel;
import com.gamatechno.moviedb.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView.View {

    MainPresenter mainPresenter;
    ArrayList<MovieModel> movieModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenter( this, this );
        mainPresenter.onGetMovie();
    }

    @Override
    public void onSuksesMovie(ArrayList<MovieModel> list) {
        for (MovieModel movieModel : list) {
            movieModels.add(movieModel);
        }

        Toast.makeText( this, movieModels.get(1).getTitle(), Toast.LENGTH_SHORT).show();
    }
}
