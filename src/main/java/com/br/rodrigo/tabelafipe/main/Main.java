package com.br.rodrigo.tabelafipe.main;
import com.br.rodrigo.tabelafipe.model.Model;
import com.br.rodrigo.tabelafipe.model.Vehicle;
import com.br.rodrigo.tabelafipe.services.ApiConsumer;
import com.br.rodrigo.tabelafipe.services.ConvertData;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    Scanner input = new Scanner(System.in);
    ApiConsumer consumer = new ApiConsumer();
    ConvertData converter = new ConvertData();
    String address = "https://parallelum.com.br/fipe/api/v1/";

    public void showMenu() {
        System.out.println("----- Menu -----");
        System.out.println("> Carros\n> Motos\n> Caminhões");
        String model = input.nextLine().toLowerCase();
        String jsonArray = consumer.getData(address + model + "/marcas");

        Model[] modelArray = converter.getDataToArray(jsonArray, Model[].class);
        Arrays.stream(modelArray).forEach(System.out::println);

        System.out.println("\n----------\nCódigo: ");
        int code = input.nextInt();
        input.nextLine();
        String jsonObject = consumer.getData(address + model + "/marcas/" + code + "/modelos");
        Model[] modelObject = converter.getDataToObject(jsonObject, Model[].class);
        Arrays.stream(modelObject)
                .forEach(System.out::println);

        System.out.println("-=-=-=-=-=-\nPesquise por nome: ");
        String name = input.nextLine().toLowerCase();

        List<Model> newModel = Arrays.stream(modelObject)
                .filter(n -> n.name().toLowerCase().contains(name))
                .collect(Collectors.toList());

        System.out.println("Pesquisando por: " + name.toLowerCase());
        newModel.forEach(System.out::println);

        System.out.println("-=-=-=-=-=-\nCódigo: ");
        int finalCode = input.nextInt();
        jsonArray = consumer
                .getData(address + model + "/marcas/" + code + "/modelos/" + finalCode + "/anos");

        Model[] modelYear = converter.getDataToArray(jsonArray, Model[].class);
        String finalAdress = address + model + "/marcas/" + code + "/modelos/" + finalCode + "/anos/";



        for(int i = 0; i < modelYear.length; i++) {
            String yearCode = modelYear[i].code();
            String updatedAdress = finalAdress + yearCode;
            String finalJsonObject = consumer.getData(updatedAdress);
            Vehicle vehicle = converter.convertFinalData(finalJsonObject);

            System.out.println(vehicle);

        }



    }
}
