package ru.myproject.tz_popular_movies;

import android.app.Application;

import ru.myproject.tz_popular_movies.network.RestApi;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RestApi.init();
    }
}
