package com.waheed.home.auto.mation.web_services;




import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Routes {
    @GET("/")
    Call<Void> getRequest(@Query(encoded = true, value = "pin") int i);



}
