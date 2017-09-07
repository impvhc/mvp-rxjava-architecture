package com.impvhc.xat.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by victor on 9/6/17.
 */

public class BeerResponse {
    @SerializedName("name")
    String name;
    @SerializedName("description")
    String description;
    @SerializedName("image_url")
    String image_url;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage_url() {
        return image_url;
    }
}
