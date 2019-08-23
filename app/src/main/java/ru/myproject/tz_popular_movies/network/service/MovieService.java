package ru.myproject.tz_popular_movies.network.service;


import java.util.ArrayList;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import ru.myproject.tz_popular_movies.model.Main;



public interface MovieService {
    @GET("/3/movie/popular?api_key=befc7872520fd736c58948abb2f4a53c")
    Single<Response<Main>> fetchMovies();

}
