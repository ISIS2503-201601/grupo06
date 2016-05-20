package com.fobsoftware.satt.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by danielordonez on 5/19/16.
 */
public class Evento {
    @SerializedName("id") @Expose public Integer id;
    @SerializedName("longitud") @Expose public double longitud;

    @SerializedName("latitud") @Expose public double latitud;

    @SerializedName("distanciaCosta") @Expose public double distancia;
    @SerializedName("zonaGeografica") @Expose public String zona;


}
