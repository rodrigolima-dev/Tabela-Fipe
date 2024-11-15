package com.br.rodrigo.tabelafipe.main;

import com.br.rodrigo.tabelafipe.model.DataModel;
import com.br.rodrigo.tabelafipe.model.Vehicle;
import com.br.rodrigo.tabelafipe.services.ApiConsumer;
import com.br.rodrigo.tabelafipe.services.ConvertData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner input = new Scanner(System.in);
    ApiConsumer consumer = new ApiConsumer();
    ConvertData converter = new ConvertData();

    private String address = "https://parallelum.com.br/fipe/api/v1/";

    public void showMenu() {
        System.out.println("--- Veículo ---");
        System.out.println("> Carros\n> Motos\n> Caminhões");
        System.out.print("Escolha: ");
        String model = input.nextLine().toLowerCase();

        String json = consumer.getData(address + model + "/marcas");
        List<DataModel> datamodels = converter.getData(json);
        datamodels.forEach(System.out::println);



    }

}
