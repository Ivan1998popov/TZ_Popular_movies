package ru.myproject.tz_popular_movies.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.myproject.tz_popular_movies.R;
import ru.myproject.tz_popular_movies.ui.fragments.MovieListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MovieListFragment movieListFragment =
                MovieListFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, movieListFragment)
                .commit();
    }
}
