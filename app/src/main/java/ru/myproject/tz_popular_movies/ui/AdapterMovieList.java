package ru.myproject.tz_popular_movies.ui;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ru.myproject.tz_popular_movies.R;
import ru.myproject.tz_popular_movies.model.Main;
import ru.myproject.tz_popular_movies.model.Movie;
import ru.myproject.tz_popular_movies.ui.activities.MainActivity;
import ru.myproject.tz_popular_movies.ui.fragments.MovieItemFragment;
import ru.myproject.tz_popular_movies.ui.fragments.MovieListFragment;
import ru.myproject.tz_popular_movies.ui.presenter.MovieListPresenter;


public class AdapterMovieList extends RecyclerView.Adapter<AdapterMovieList.MyViewHolder> {

    private ArrayList<Movie> items;
    private MovieListFragment fragment;
    MovieListPresenter presenter;

    public AdapterMovieList(MovieListFragment fragment, MovieListPresenter presenter) {

        this.fragment = fragment;
        items = new ArrayList<>();
        this.presenter = presenter;
    }


    public void loadItems(ArrayList<Movie> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView title;


        public MyViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.image_poster_movie);
            title = v.findViewById(R.id.title);

        }

    }

    @NonNull
    @Override
    public AdapterMovieList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie_recyclerview,
                viewGroup, false);

        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = myViewHolder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    MainActivity activity = (MainActivity) v.getContext();

                    Movie movie=items.get(position);
                    System.out.println(movie.getTitle());

                    MovieItemFragment movieItemFragment = MovieItemFragment.newInstance(movie);
                    activity.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, movieItemFragment)
                            .addToBackStack(null)
                            .commit();


                }
            }
        });

        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull AdapterMovieList.MyViewHolder holder, int i) {
        holder.title.setText(items.get(i).getTitle());
        Picasso.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w500" + items.get(i).getPosterPath())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
