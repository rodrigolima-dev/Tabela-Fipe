package com.br.rodrigo.tabelafipe.services;

import com.br.rodrigo.tabelafipe.model.DataModel;
import com.br.rodrigo.tabelafipe.model.Vehicle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class ConvertData {
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public List<DataModel> getData(String json) {
        Type type = new TypeToken<List<DataModel>>(){}.getType();
        return gson.fromJson(json, type);
    }
}
