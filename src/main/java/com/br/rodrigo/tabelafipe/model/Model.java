package com.br.rodrigo.tabelafipe.model;

import com.google.gson.annotations.SerializedName;

public record Model (
    @SerializedName("codigo")  String code,
    @SerializedName("nome")  String name,
    @SerializedName("ano")  String year,
    @SerializedName("valor")  String value,
    @SerializedName("combustivel") String fuel

){

    @Override
    public String toString() {
        return "Código: " + code + " Modelo: " + name;
    }
}
