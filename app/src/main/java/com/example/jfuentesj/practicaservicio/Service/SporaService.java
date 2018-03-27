package com.example.jfuentesj.practicaservicio.Service;

import com.example.jfuentesj.practicaservicio.Models.YelmocinesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by jfuentesj on 3/27/2018.
 */

public interface SporaService {
    @Headers("api_key:es_cinepolis_test_android")

    @GET("v2/schedules?country_code=ES&cities=32&include_cinemas=true&include_movies=true")
    Call<YelmocinesResponse> getYelmocinesResponse();

}
