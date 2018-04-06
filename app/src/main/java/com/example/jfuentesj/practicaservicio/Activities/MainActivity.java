package com.example.jfuentesj.practicaservicio.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jfuentesj.practicaservicio.Models.YelmocinesResponse;
import com.example.jfuentesj.practicaservicio.R;
import com.example.jfuentesj.practicaservicio.Service.SporaService;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tvShowIdCity, tvShowMovieName, tvShowMovieSynopsis,tvShowMovieHorarios;
    ImageView ivPoster;
    Button btnBuscar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvShowIdCity = findViewById(R.id.tv_id_city);
        tvShowMovieName = findViewById(R.id.tv_movie_name);
        tvShowMovieSynopsis = findViewById(R.id.tv_movie_synopsis);
        tvShowMovieHorarios = findViewById(R.id.tv_movie_horarios);
        ivPoster = findViewById(R.id.iv_poster);

        btnBuscar = findViewById(R.id.btn_buscar);

        YelmocinesCallRetrofitService();
    }

    private void YelmocinesCallRetrofitService() {
        String YelmoUrl = getString(R.string.stage_api_yelmocines);//Se manda a llamar la url

        Retrofit retrofit = new Retrofit.Builder().baseUrl(YelmoUrl).addConverterFactory(GsonConverterFactory.create()).build();

        SporaService sporaService = retrofit.create(SporaService.class);

        sporaService.getYelmocinesResponse().enqueue(new Callback<YelmocinesResponse>() {
            @Override
            public void onResponse(Call<YelmocinesResponse> call, Response<YelmocinesResponse> response) {
                if (response.isSuccessful()) {
                    YelmocinesResponse yelmocinesResponse = response.body();
                    String url = yelmocinesResponse.getMovies().get(1).getMedia().get(0).getResource();
                    String route = yelmocinesResponse.getRoutes().get(1).getSizes().getMedium();

                    int sizeIdMovie = yelmocinesResponse.getSchedules().get(1).getMovieId();

                    tvShowIdCity.setText(String.valueOf(yelmocinesResponse.getMovies().get(1).getId()));
                    tvShowMovieName.setText(yelmocinesResponse.getMovies().get(1).getName());
                    tvShowMovieSynopsis.setText(yelmocinesResponse.getMovies().get(1).getSynopsis());

                    Picasso.get().load(route + "" + url).into(ivPoster);

                    /*for (int i = 0; i<sizeIdMovie; i++){
                        int movieIdResponse = response.body().getSchedules().get(i).getMovieId();
                    }*/
                }
            }

            @Override
            public void onFailure(Call<YelmocinesResponse> call, Throwable t) {
                Log.e("Fail", "onFalilure" + t.getLocalizedMessage());
            }
        });
    }
}
