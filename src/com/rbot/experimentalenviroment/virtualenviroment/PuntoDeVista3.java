package com.rbot.experimentalenviroment.virtualenviroment;

import com.rbot.virtualuniverse.VirtualScenary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class PuntoDeVista3 extends JInternalFrame implements ActionListener, KeyListener {

    VirtualScenary pt;

    public PuntoDeVista3(VirtualScenary pt) {
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
        this.pt = pt;
        this.getContentPane().add("Center", pt.dameCanvas());
        pt.dameCanvas().addKeyListener(this);
        addKeyListener(this);
    }

    public void actionPerformed(ActionEvent ae) {

        String caso = ae.getActionCommand();

        if (caso == "Camara") {
            this.setTitle("Vista Camara");
            this.setSize(512, 350);
            //this.pack();
            this.setLocation(512, 0);
            this.setMaximizable(false);
            this.setClosable(true);
            this.setIconifiable(true);
            this.getFrameIcon();
            this.setOpaque(true);

            this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            this.setVisible(true);
        }

    }

    public void keyPressed(KeyEvent evento) {
        String tecla = evento.getKeyText(evento.getKeyCode());
        if (tecla.equals("Arriba")) {
            System.out.println("Rodando pa' lante");
            pt.getCuerpo().moverOrugaDerecha();
            pt.getCuerpo().avanzar();
            pt.avanzar();
        }
        if (tecla.equals("Inactivo")) {
            pt.getCuerpo().moverOrugaIzquierda();
            pt.getCuerpo().retroceder();
            pt.retroceder();
        }
        if (tecla.equals("Derecha")) {
            pt.getCuerpo().moverDerecha();
            pt.getCuerpo().derecha();
            pt.derecha();
        }
        if (tecla.equals("Izquierda")) {
            pt.getCuerpo().moverIzquierda();
            pt.getCuerpo().izquierda();
            pt.izquierda();
        }
    }

    // manejar evento de liberacion de cualquier tecla
    public void keyReleased(KeyEvent evento) {
    }

    // manejar evento de pulsacion de una tecla de accion
    public void keyTyped(KeyEvent evento) {
    }

}

