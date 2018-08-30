package com.puzzlersworld.wp.service;

import com.puzzlersworld.wp.dto.X;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AndroAppService {
    @GET("/appCreator/info.php")
    Call<X> fetchInfo(@Query("clientId") String str, @Query("versionName") String str2);
}
