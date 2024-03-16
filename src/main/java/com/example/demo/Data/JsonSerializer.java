package com.example.demo.Data;

import com.example.demo.Logic.ShopOfClocks;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonSerializer {
    private static final Gson gson = new GsonBuilder()
            .setLenient()
            .setPrettyPrinting()
            .registerTypeAdapter(ShopOfClocks.class, ShopOfClocks.JsonSerialize.INSTANCE)
            .create();
    private final ShopOfClocks shop;

    public JsonSerializer(ShopOfClocks shop) {
        this.shop = shop;
    }
    public String serialize() {
        return gson.toJson(shop);
    }

}
