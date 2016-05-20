package com.fobsoftware.satt.Entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by danielordonez on 5/19/16.
 */
public class Token {

    @SerializedName("account") @Expose public Account acc;
    public class Account{
        @SerializedName("href") @Expose public String href;
    }


}