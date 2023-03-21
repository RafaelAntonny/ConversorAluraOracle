package org.example;

import javax.swing.*;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;

public class ConversorDeMoedaApiConsumer {

    static void sendHttpGETRequest(String deMoeda, String paraMoeda, double valorRecebido) throws IOException {

        DecimalFormat f = new DecimalFormat("00.00");

        String GET_URL = "https://api.apilayer.com/fixer/convert?to="+paraMoeda+"&from="+deMoeda+"&amount="+valorRecebido;
        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.addRequestProperty("apikey", "djylSoc6CSGeuirIj5r8IUtTKBQE8ZX7");
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == httpURLConnection.HTTP_OK) { //sucesso
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }in.close();

            JSONObject obj = new JSONObject(response.toString());
            double resultadoDaConversao = obj.getDouble("result");
            JOptionPane.showMessageDialog(null, "Você tem " + f.format(resultadoDaConversao) + " em " + paraMoeda);
        }
        else {
            JOptionPane.showMessageDialog(null, "GET falhou", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
