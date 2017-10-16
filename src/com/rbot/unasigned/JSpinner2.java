package com.rbot.unasigned;

import javax.swing.*;


public class JSpinner2 extends JFrame {
    public JSpinner2(Controlll cs) {
        super("Oruga");
        Double min1 = new Double(-32000);
        Double max1 = new Double(32000.0);
        Double inic1 = new Double(0.0);
        Double paso1 = new Double(1);

        Double min2 = new Double(-32000);
        Double max2 = new Double(32000.0);
        Double inic2 = new Double(0.0);
        Double paso2 = new Double(1);

        SpinnerNumberModel controlNum1 = new SpinnerNumberModel(inic1, min1, max1, paso1);

        SpinnerNumberModel controlNum2 = new SpinnerNumberModel(inic2, min2, max2, paso2);

        JSpinner avre = new JSpinner(controlNum1);

        JSpinner deiz = new JSpinner(controlNum2);

        JPanel panel = new JPanel();

        JLabel etq1 = new JLabel("Avanzar o Retroceder");
        panel.add(etq1);
        panel.add(avre);

        JLabel etq2 = new JLabel("Derecha o Izquierda");
        panel.add(etq2);
        panel.add(deiz);

        avre.setName("avre");

        deiz.setName("deiz");

        avre.addChangeListener(cs);

        deiz.addChangeListener(cs);

        this.getContentPane().add(panel);
        this.pack();
    }
}