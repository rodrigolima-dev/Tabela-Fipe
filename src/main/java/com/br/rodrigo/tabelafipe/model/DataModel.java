package com.br.rodrigo.tabelafipe.model;

import com.google.gson.annotations.SerializedName;

public record DataModel(
        @SerializedName("codigo") String code,
        @SerializedName("nome") String model
) {

    @Override
    public String toString() {
        return "Código: " + this.code + " Modelo: " + this.model;
    }
}
