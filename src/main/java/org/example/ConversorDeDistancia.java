package org.example;

import javax.swing.*;

public class ConversorDeDistancia {

    public void quilometroParaMilhas(double Quilometro) {
        double Milhas = Quilometro * 0.6214;
        JOptionPane.showMessageDialog(null, "" + Quilometro + " equivale a " + Milhas + " em milhas");
    }

    public void milhaParaQuilometro(double Milhas) {
        double Quilometro = Milhas * 1.609;
        JOptionPane.showMessageDialog(null, "" + Milhas + " equivale a " + Quilometro + " em quilometros");
    }
}
