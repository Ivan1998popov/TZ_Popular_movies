package ru.myproject.tz_popular_movies.ui.presenter;

import java.util.ArrayList;

import ru.myproject.tz_popular_movies.model.Movie;


public interface MovieListPresenter {

    void loadMovieList();

    interface View {
        void addLoadedItems(ArrayList<Movie> items);
    }
}
