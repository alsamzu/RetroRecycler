package com.example.retrorecycler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BusApiHolder {

        @GET("posts")
    Call<List<BusInfo>> getAllBuses();
}
