package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RESTAPIClientTask {

    public static void main(String[] args) {
        String endpointURL = "https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda";

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(endpointURL).openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println("Resposta da API:");
            System.out.println(response.toString());

            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
