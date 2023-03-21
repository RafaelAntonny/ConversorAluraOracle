package org.example;

import javax.swing.*;
import java.io.IOException;

import static org.example.ConversorDeMoedaApiConsumer.sendHttpGETRequest;

public class Applayer {

    public void converterMoeda(double valorRecebido) throws IOException {
        String deMoeda = JOptionPane.showInputDialog(null, "Escolha qual moeda a ser convertida", "Conversor de Moedas",
                JOptionPane.PLAIN_MESSAGE, null,
                new Object[]{"BRL", "USD", "EUR", "GBP", "ARS", "CLP"}, "Escolha").toString();

        String paraMoeda = JOptionPane.showInputDialog(null, "Escolha qual moeda você quer seja convertida para", "Conversor de Moedas",
                JOptionPane.PLAIN_MESSAGE, null,
                new Object[]{"BRL", "USD", "EUR", "GBP", "ARS", "CLP"}, "Escolha").toString();

        sendHttpGETRequest(deMoeda, paraMoeda, valorRecebido);
    }

    ConversorDeDistancia conversorDeDistancia = new ConversorDeDistancia();

    public void converterDistancia(double valorRecebido) {
        String deDistancia = JOptionPane.showInputDialog(null, "Escolha qual a unidade a ser convertida", "Conversor de Distância",
                JOptionPane.PLAIN_MESSAGE, null,
                new Object[]{"Quilometro", "Milhas"}, "Escolha").toString();

        String paraDistancia = JOptionPane.showInputDialog(null, "Escolha qual unidade você quer que seja convertida para", "Conversor de Distância",
                JOptionPane.PLAIN_MESSAGE, null,
                new Object[]{"Quilometro", "Milhas"}, "Escolha").toString();

        switch (deDistancia) {
            case "Quilometro" -> conversorDeDistancia.quilometroParaMilhas(valorRecebido);
            case "Milhas" -> conversorDeDistancia.milhaParaQuilometro(valorRecebido);
        }
    }
}
