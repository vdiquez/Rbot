package com.rbot.experimentalenviroment.actions;

import com.rbot.experimentalenviroment.view.CameraControls;
import com.rbot.virtualuniverse.VirtualScenary;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CameraListener implements ActionListener, ChangeListener {

    private CameraControls cameraControls;
    private VirtualScenary pt;

    public CameraListener(VirtualScenary pt) {
        cameraControls = new CameraControls(this);
        this.pt = pt;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        JMenuItem source = (JMenuItem) (actionEvent.getSource());

        if (source.getName() == "panelManejo") {
            cameraControls.setVisible(true);
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