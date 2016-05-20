package com.fobsoftware.satt.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by danielordonez on 5/19/16.
 */
public class Boletin {
    @SerializedName("id") @Expose public Integer id;
    @SerializedName("perfil") @Expose public String perfil;

    @SerializedName("zonaGeografica") @Expose public String zona;

    @SerializedName("tiempoLlegada") @Expose public double tiempo;

    @SerializedName("altura") @Expose public double altura;

}
