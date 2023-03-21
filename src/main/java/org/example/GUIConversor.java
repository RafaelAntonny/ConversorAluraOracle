package org.example;

import javax.swing.*;
import java.io.IOException;

public class GUIConversor {
    public static void main(String[] args) throws IOException {
        int resposta;
        String entrada;
        do {
            String opcoes = JOptionPane.showInputDialog(null, "Escolha oque você quer converter", "Menu", JOptionPane.QUESTION_MESSAGE,
                    null, new Object[]{"Converter Moeda", "Converter Distância"}, "Escolha").toString();
            try {
                entrada = JOptionPane.showInputDialog("Insira um valor");

                Applayer applayer = new Applayer();

                switch (opcoes) {
                    case "Converter Moeda":
                        double valorRecebido = Double.parseDouble(entrada);
                        applayer.converterMoeda(valorRecebido);
                        break;
                    case "Converter Distância":
                        valorRecebido = Double.parseDouble(entrada);
                        applayer.converterDistancia(valorRecebido);
                        break;
                }
            }
            catch(NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(null,"Valor inválido, por favor digite apenas numeros", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            resposta = JOptionPane.showConfirmDialog(null, "Você deseja continuar ?");
        } while (resposta == JOptionPane.OK_OPTION);
        switch (resposta) {
            case 1 -> JOptionPane.showMessageDialog(null, "Programa finalizado");
            case 2 -> JOptionPane.showMessageDialog(null, "Programa concluído");
        }
    }
}