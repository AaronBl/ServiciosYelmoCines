package com.example.jfuentesj.practicaservicio.Activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jfuentesj.practicaservicio.Adapter.HorariosAdapter;
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

    Context context;
    RecyclerView rvConteiner;
    HorariosAdapter horariosAdapter;
    YelmocinesResponse yelmocinesResponse;


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

        /*rvConteiner = findViewById(R.id.rv_contenedor);
        rvConteiner.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rvConteiner.hasFixedSize();*/


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

                    tvShowIdCity.setText(String.valueOf(yelmocinesResponse.getMovies().get(1).getId()));
                    tvShowMovieName.setText(yelmocinesResponse.getMovies().get(1).getName());
                    tvShowMovieSynopsis.setText(yelmocinesResponse.getMovies().get(1).getSynopsis());

                    //ivPoster.setImageResource(Picasso.with(context).load(yelmocinesResponse.Routes.Sizes));

                    //tvShowMovieHorarios.setText(yelmocinesResponse.getSchedules().get(1).getDates().get(1).getDate());

                    /*horariosAdapter = new HorariosAdapter(yelmocinesResponse.Schedules.Dates.Formats.Showtimes.class);
                    rvConteiner.setAdapter(horariosAdapter);
                    horariosAdapter.notifyDataSetChanged();*/

                }
            }

            @Override
            public void onFailure(Call<YelmocinesResponse> call, Throwable t) {
                Log.e("Fail", "onFalilure" + t.getLocalizedMessage());
            }
        });
    }
}
