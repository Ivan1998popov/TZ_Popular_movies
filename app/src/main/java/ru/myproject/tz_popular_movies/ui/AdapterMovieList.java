package ru.myproject.tz_popular_movies.ui;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ru.myproject.tz_popular_movies.R;
import ru.myproject.tz_popular_movies.model.Movie;
import ru.myproject.tz_popular_movies.ui.activities.MainActivity;
import ru.myproject.tz_popular_movies.ui.fragments.MovieItemFragment;


public class AdapterMovieList extends RecyclerView.Adapter<AdapterMovieList.MyViewHolder> {

    private ArrayList<Movie> items;
    private Context context;

    public AdapterMovieList(Context context) {

        items = new ArrayList<>();
        this.context = context;
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
        view.setOnClickListener(v -> {
            int position = myViewHolder.getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                MainActivity activity = (MainActivity) v.getContext();

                MovieItemFragment movieItemFragment = MovieItemFragment.newInstance(items.get(position));
                activity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, movieItemFragment)
                        .addToBackStack(null)
                        .commit();


            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMovieList.MyViewHolder holder, int i) {
        holder.title.setText(items.get(i).getTitle());
        Picasso.with(holder.itemView.getContext())
                .load(context.getResources().getString(R.string.key_api_image) + items.get(i).getPosterPath())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
