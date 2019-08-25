package com.gamatechno.moviedb;

import java.util.ArrayList;

public interface MainView {

    interface Presenter {
        void onGetMovie();
    }

    interface View {
        void onSuksesMovie(ArrayList<MovieModel> movieModels);
    }
}
