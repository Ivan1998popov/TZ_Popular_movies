package ru.myproject.tz_popular_movies.ui.fragments;

import android.util.Log;


import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.myproject.tz_popular_movies.model.ListMovies;
import ru.myproject.tz_popular_movies.network.RestApi;
import ru.myproject.tz_popular_movies.network.SingleResponseFlatMap;
import ru.myproject.tz_popular_movies.network.service.MovieService;
import ru.myproject.tz_popular_movies.ui.presenter.MovieListPresenter;


class MovieListPresenterImpl implements MovieListPresenter {

    private View view;
    private MovieService mMovieService;

    protected MovieListPresenterImpl(MovieListPresenter.View view) {
        this.view = view;
        mMovieService = RestApi.createService(MovieService.class);
    }

    @Override
    public void loadMovieList() {

        mMovieService.fetchMovies()
                .subscribeOn(Schedulers.io())
                .flatMap(new SingleResponseFlatMap<>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ListMovies>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(ListMovies movies) {
                        view.addLoadedItems(movies.getMovies());
                    }

                    @Override
                    public void onError(Throwable error) {
                        Log.i("MyError", error.getMessage());
                        System.out.println(error.getMessage());
                        error.printStackTrace();
                    }
                });

    }

}
