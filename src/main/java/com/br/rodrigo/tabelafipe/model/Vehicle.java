package com.br.rodrigo.tabelafipe.model;

import com.google.gson.annotations.SerializedName;

public record Vehicle (
        @SerializedName("Marca") String brand,
        @SerializedName("Modelo") String model,
        @SerializedName("AnoModelo") int year,
        @SerializedName("Valor") String value,
        @SerializedName("Combustivel") String fuel
){

    @Override
    public String toString() {
        return
                brand + " " + model +
                " ano: " + year +
                " valor: R$" + value + '\'' +
                " combustível: " + fuel;

    }
}
