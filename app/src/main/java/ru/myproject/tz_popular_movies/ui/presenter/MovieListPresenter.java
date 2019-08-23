package ru.myproject.tz_popular_movies.ui.presenter;

import java.util.ArrayList;
import java.util.List;

import ru.myproject.tz_popular_movies.model.Main;
import ru.myproject.tz_popular_movies.model.Movie;


public interface MovieListPresenter {


    void loadItemMovieList();
    void loadMovieList();

    interface View {
        void addLoadedItems(ArrayList<Movie> items);
    }
    interface ViewMovie {
        void addLoadedMovie(Movie movie);
    }
}
