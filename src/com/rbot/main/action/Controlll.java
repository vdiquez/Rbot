package com.rbot.main.action;

import com.rbot.main.view.JSpinner1;
import com.rbot.virtualuniverse.Proto;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlll implements ActionListener, ChangeListener {

    private JSpinner1 jSpinner1;
    private Proto pt;

    public Controlll(Proto pt) {
        jSpinner1 = new JSpinner1(this);
        this.pt = pt;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        JMenuItem source = (JMenuItem) (actionEvent.getSource());

        if (source.getName() == "panelManejo") {
            jSpinner1.setVisible(true);
        }
    }

    public void stateChanged(ChangeEvent e) {
        JComponent source = (JComponent) e.getSource();
        if (source.getName() == "controlEjeX") {
            double angulo = ((Double) (((JSpinner) source).getValue())).doubleValue();
            pt.getCuerpo().getEstructuraCamara().rotarEjeZ((float) angulo);
            pt.girar((float) angulo);
        }
        if (source.getName() == "controlEjeY") {
            double angulo = ((Double) (((JSpinner) source).getValue())).doubleValue();
            pt.getCuerpo().getEstructuraCamara().getCremallera().getCamara().rotarEjeY((float) angulo);
            pt.elevar((float) angulo);
        }
        if (source.getName() == "controlEjeZ") {
            double angulo = ((Double) (((JSpinner) source).getValue())).doubleValue();
            pt.getCuerpo().getEstructuraCamara().getCremallera().rotarEjeZ((float) angulo);
            pt.subirBajar((float) angulo);
        }
    }
}