package ru.myproject.tz_popular_movies.ui.fragments;

import android.os.Bundle;
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

    private static final String MY_MOVIE = "my_movie";


    public static MovieItemFragment newInstance(Movie movie) {
        MovieItemFragment fragment = new MovieItemFragment();
        Bundle args = new Bundle();
        args.putParcelable(MY_MOVIE, movie);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_movie_description_item, container,
                false);
        assert getArguments() != null;
        movie = getArguments().getParcelable(MY_MOVIE);
        title = v.findViewById(R.id.title);
        overview = v.findViewById(R.id.text_description_movie);
        image = v.findViewById(R.id.image_poster_movie);
        setData();
        return v;
    }

    private void setData() {
        title.setText(movie.getTitle());
        overview.setText(movie.getOverview());

        Picasso.with(getContext())
                .load(getActivity().getResources().getString(R.string.key_api_image)
                        + movie.getPosterPath())
                .into(image);
    }


}
