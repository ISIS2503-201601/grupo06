package com.fobsoftware.satt.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by danielordonez on 5/18/16.
 */
public class Sensores {

        @SerializedName("userId") @Expose public Integer userId;
        @SerializedName("id") @Expose public Integer id;
        @SerializedName("title") @Expose public String title;


}
