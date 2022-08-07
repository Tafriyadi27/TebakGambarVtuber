package com.skullbreraker.tebakgambarvtuber.api;

import com.skullbreraker.tebakgambarvtuber.model.VtuberModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface apiservice {
    @GET("/getVtuber")
    Call<List<VtuberModel>> getImage();
}
