package com.example.jfuentesj.practicaservicio.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.jfuentesj.practicaservicio.Models.YelmocinesResponse;
import com.example.jfuentesj.practicaservicio.R;
import com.example.jfuentesj.practicaservicio.Service.SporaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tvShowIdCity, tvShowMovieName, tvShowMovieSynopsis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvShowIdCity = findViewById(R.id.tv_id_city);
        tvShowMovieName = findViewById(R.id.tv_movie_name);
        tvShowMovieSynopsis = findViewById(R.id.tv_movie_synopsis);

        YelmocinesCallRetrofitService();
    }

    private void YelmocinesCallRetrofitService(){
        String YelmoUrl = getString(R.string.stage_api_yelmocines);//Se manda a llamar la url

        Retrofit retrofit = new Retrofit.Builder().baseUrl(YelmoUrl).addConverterFactory(GsonConverterFactory.create()).build();

        SporaService sporaService = retrofit.create(SporaService.class);

        sporaService.getYelmocinesResponse().enqueue(new Callback<YelmocinesResponse>() {
            @Override
            public void onResponse(Call<YelmocinesResponse> call, Response<YelmocinesResponse> response) {
                if (response.isSuccessful()){
                    tvShowIdCity.setText(String.valueOf(response.body().getMovies().get(1).getId()));
                    tvShowMovieName.setText(response.body().getMovies().get(1).getName());
                    tvShowMovieSynopsis.setText(response.body().getMovies().get(1).getSynopsis());

                }
            }

            @Override
            public void onFailure(Call<YelmocinesResponse> call, Throwable t) {
                Log.e("Fail", "onFalilure" + t.getLocalizedMessage());
            }
        });
    }
}
