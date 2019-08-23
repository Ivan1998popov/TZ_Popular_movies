package ru.myproject.tz_popular_movies.ui.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ru.myproject.tz_popular_movies.R;
import ru.myproject.tz_popular_movies.model.Movie;

public class MovieItemFragment extends Fragment {

    private Movie movie;
    private TextView title;
    private TextView overview;
    private ImageView image;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_movie_description_item, container,
                false);

        if (getArguments() != null) {

            System.out.println();

            movie = getArguments().getParcelable("my_movie");
        }

        title=v.findViewById(R.id.title);
        overview=v.findViewById(R.id.text_description_movie);
        image=v.findViewById(R.id.image_poster_movie);

        setData();

        return v;
    }

    private void setData() {
        title.setText(movie.getTitle());
        overview.setText(movie.getOverview());

        Picasso.with(getContext())
                .load("https://image.tmdb.org/t/p/w500"+movie.getPosterPath())
                .into(image);
    }

    public static MovieItemFragment newInstance(Movie movie) {
        MovieItemFragment fragment = new MovieItemFragment();
        Bundle args = new Bundle();
        args.putParcelable("my_movie",  movie);
        fragment.setArguments(args);
        return fragment;
    }
}
