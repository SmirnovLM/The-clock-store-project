package com.example.demo.Logic;

import com.google.gson.*;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.*;
public class ShopOfClocks implements Serializable {
    private final List<InterfaceOfClock> clocks; // Список Часов
    public ShopOfClocks() {
        clocks = new ArrayList<>();
    }
    private ShopOfClocks(List<InterfaceOfClock> list) {
        clocks = list;
    }
    public void AddOfWatch(InterfaceOfClock clock) {
        clocks.add(clock);
    }
    public void DeleteOfWatch(InterfaceOfClock clock) {
        clocks.remove(clock);
    }
    public int ReturnSize() {
        return clocks.size();
    }

    public List<InterfaceOfClock> ReturnList() {
        return clocks;
    }

    public InterfaceOfClock Information_About_The_Most_Expensive_Watches() {
        // Информация о самых дорогих часах в магазине
        return Collections.max(clocks, Comparator.comparingInt(InterfaceOfClock::getCost));
    }
    public InterfaceOfClock Information_About_The_cheapest_Watches() {
        // Информация о самых дешевых часах в магазине
        return Collections.min(clocks, Comparator.comparingInt(InterfaceOfClock::getCost));
    }
    public void SetStartTimeOfAllWatches(TimeType tt, int value) throws ThrowException {
        // Установка начального времени для всех часов в магазине
        for(InterfaceOfClock o: clocks) {
            o.GetStartTime(tt, value);
        }
    }
    public void PlusTimeOfAllWatches(TimeType tt, int value) throws ThrowException {
        // Прибавить время ко всем часам в магазине
        for (InterfaceOfClock o: clocks) {
            o.PlusTime(tt, value);
        }
    }
    public InterfaceOfClock PrintAllClocks(int i) {
        return clocks.get(i);
    }
    public String The_Most_Popular_Watch_Brand() {
        // Самый популярный бренд часов в магазине
        Map<String, Integer> str = new HashMap<>();
        for(InterfaceOfClock c: clocks) {
            if (str.get(c.getName()) == null)
                str.put(c.getName(), 1);
            else
                str.put(c.getName(), str.get(c.getName()) + 1);
        }
        int max_value = 0;
        String max_name = "";
        for(String s: str.keySet()) {
            if (str.get(s) > max_value) {
                max_value = str.get(s);
                max_name = s;
            }
        }
        return max_name;
    }
    public String PrintBrands() {
        // Информация о всех имеющихся в магазине брендов часов
        TreeSet<String> ts = new TreeSet<>();
        for (InterfaceOfClock c: clocks){
            ts.add(c.getName());
        }
        return ts.toString();
    }

    public final static class JsonSerialize implements JsonSerializer<ShopOfClocks>, JsonDeserializer<ShopOfClocks> {
        private static final Gson gson = new GsonBuilder().create();
        public static final JsonSerialize INSTANCE = new JsonSerialize();
        private JsonSerialize() {
        }

        @Override
        public ShopOfClocks deserialize(JsonElement jsonElement, Type type,
                                        JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

            JsonObject jsonObject = jsonElement.getAsJsonObject();

            JsonArray jsonArray = jsonObject.getAsJsonArray("clocks");

            List<InterfaceOfClock> clocksList = new ArrayList<>(jsonArray.size());

            for (JsonElement element : jsonArray) {
                JsonObject clockAsJsonObject = element.getAsJsonObject();
                String className = clockAsJsonObject.get("className").getAsString();
                clockAsJsonObject.remove("className");

                try {
                    clocksList.add((InterfaceOfClock) gson.fromJson(clockAsJsonObject, Class.forName(className)));
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            return new ShopOfClocks(clocksList);
        }

        @Override
        public JsonElement serialize(ShopOfClocks shop, Type type, JsonSerializationContext jsonSerializationContext) {

            JsonObject jsonObject = new JsonObject();

            JsonArray jsonArray = new JsonArray();

            for (InterfaceOfClock clock : shop.ReturnList()) {
                JsonElement clockAsJson = gson.toJsonTree(clock);
                JsonObject asJsonObject = clockAsJson.getAsJsonObject();
                asJsonObject.addProperty("className", clock.getClass().getName());
                jsonArray.add(asJsonObject);
            }

            jsonObject.add("clocks", jsonArray);
            return jsonObject;
        }
    }
}
