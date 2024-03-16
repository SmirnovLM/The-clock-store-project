package com.example.demo.Data;

import com.example.demo.Logic.ShopOfClocks;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonDeserializer {

    private static final Gson gson = new GsonBuilder()
            .setLenient()
            .setPrettyPrinting()
            .registerTypeAdapter(ShopOfClocks.class, ShopOfClocks.JsonSerialize.INSTANCE)
            .create();

    private final String json;

    public JsonDeserializer(String json) {
        this.json = json;
    }

    public ShopOfClocks deserialize() {
        return gson.fromJson(json, ShopOfClocks.class);
    }

}
