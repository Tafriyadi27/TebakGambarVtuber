package com.skullbreraker.tebakgambarvtuber.api;

import com.skullbreraker.tebakgambarvtuber.model.ConfirmModel;
import com.skullbreraker.tebakgambarvtuber.model.VtuberModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface apiservice {
    @GET("/getVtuber")
    Call<List<VtuberModel>> getImage();

    @POST("/confirmVtuber")
    Call<ConfirmModel> confirmVtuber(@Query("nama_vtuber") String nama_vtuber);

}
