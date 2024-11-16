package com.br.rodrigo.tabelafipe.services;

import com.br.rodrigo.tabelafipe.model.Model;
import com.br.rodrigo.tabelafipe.model.Vehicle;
import com.google.gson.Gson;
import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;

public class ConvertData {
    Gson gson = new Gson();
    Type listType = new TypeToken<ArrayList<Model>>(){}.getType();

    public <T> T[] getDataToArray(String json, Class<T[]> clazz) {
        return gson.fromJson(json, clazz);
    }

    public <T> T[] getDataToObject(String jsonObject, Class<T[]> clazz) {
        JsonObject jsonObj = gson.fromJson(jsonObject, JsonObject.class);
        JsonElement arrayElement = jsonObj.get("modelos");

        return gson.fromJson(arrayElement, clazz);
    }

    public Vehicle convertFinalData(String json) {
        return gson.fromJson(json, Vehicle.class);
    }

}
