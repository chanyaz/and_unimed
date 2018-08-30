package com.puzzlersworld.wp.service;

import com.puzzlersworld.wp.dto.WpJson;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WpJsonService {
    @GET("wp-json")
    Call<WpJson> getWpJson();
}
