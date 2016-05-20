package com.fobsoftware.satt.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by danielordonez on 5/19/16.
 */
public class Sensor {
    @SerializedName("id") @Expose public Integer id;
    @SerializedName("zonaGeografica") @Expose public String zona;
    @SerializedName("longitud") @Expose public double longitud;

    @SerializedName("latitud") @Expose public double latitud;

    @SerializedName("numeroDeSerie") @Expose public Integer serie;
    @SerializedName("ultimaMedicion") @Expose public Medicion ultMed;
    public class Medicion{
        @SerializedName("idSensor") @Expose public Integer idSensor;
        @SerializedName("altura") @Expose public double altura;
        @SerializedName("velocidad") @Expose public double velocidad;

    }

}
