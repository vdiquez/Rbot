package com.rbot.main.view;

import com.rbot.main.action.Controlll;

import javax.swing.*;
import java.awt.*;


public class JSpinner1 extends JFrame {
    public JSpinner1(Controlll cs) {
        super("Controles");
        Double min1 = new Double(-90.0);
        Double max1 = new Double(90.0);
        Double inic1 = new Double(0.0);
        Double paso1 = new Double(2);

        Double min2 = new Double(-50.0);
        Double max2 = new Double(50.0);
        Double inic2 = new Double(0.0);
        Double paso2 = new Double(2);

        Double min3 = new Double(-1.8);
        Double max3 = new Double(5.8);
        Double inic3 = new Double(0.0);
        Double paso3 = new Double(0.1);

        SpinnerNumberModel controlNum1 = new SpinnerNumberModel(inic1, min1, max1, paso1);

        SpinnerNumberModel controlNum2 = new SpinnerNumberModel(inic2, min2, max2, paso2);

        SpinnerNumberModel controlNum3 = new SpinnerNumberModel(inic3, min3, max3, paso3);

        JSpinner controlEjeX = new JSpinner(controlNum1);

        JSpinner controlEjeY = new JSpinner(controlNum2);

        JSpinner controlEjeZ = new JSpinner(controlNum3);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(3, 2));

        JLabel etq1 = new JLabel("Girar");
        panel.add(etq1);
        panel.add(controlEjeX);

        JLabel etq2 = new JLabel("Elevacion +-");
        panel.add(etq2);
        panel.add(controlEjeY);

        JLabel etq3 = new JLabel("Subir o Bajar");
        panel.add(etq3);
        panel.add(controlEjeZ);

        controlEjeX.setName("controlEjeX");

        controlEjeY.setName("controlEjeY");

        controlEjeZ.setName("controlEjeZ");

        controlEjeX.addChangeListener(cs);

        controlEjeY.addChangeListener(cs);

        controlEjeZ.addChangeListener(cs);

        this.getContentPane().add(panel);
        setSize(200, 100);
    }
}