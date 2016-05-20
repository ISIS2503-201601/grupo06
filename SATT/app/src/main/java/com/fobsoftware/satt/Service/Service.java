package com.fobsoftware.satt.Service;


import com.fobsoftware.satt.Entities.Boletin;
import com.fobsoftware.satt.Entities.Evento;
import com.fobsoftware.satt.Entities.LoginBody;
import com.fobsoftware.satt.Entities.Sensor;
import com.fobsoftware.satt.Entities.Token;
import com.fobsoftware.satt.User;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Service {

    //SATT
    @GET("/webresources/SATT/sensores")
    Call<List<Sensor>> adquirirSensores( @Header("Authorization") String auth);

    @GET("/webresources/SATT/boletines")
    Call<List<Boletin>> adquirirBoletines(@Header("Authorization") String auth);

    @GET("/webresources/SATT/eventos")
    Call<List<Evento>> adquirirEventos(@Header("Authorization") String auth);
    //LOGIN
    @Headers({
            "Authorization: Basic M05PTEIwUzlJWVNGUzI5RVlHUE9aVUU4RzpXQnZUd3Vkd001WFBUWC9ZSHpNRTNZR1hpRENxSnp0OUxvSnpQbVY1WkFF"
    })
    @POST("/v1/applications/1caYptSjY0Zv8dAy6j6mW/loginAttempts")
    Call<Token> login(@Body LoginBody value);

}