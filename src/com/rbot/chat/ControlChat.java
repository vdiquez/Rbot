package com.rbot.chat;

import com.rbot.virtualuniverse.Proto;
import com.rbot.main.view.VentanaPanel;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class ControlChat implements ChangeListener, KeyListener {
    private DatagramPacket dgp;
    private DatagramSocket dgs;
    private Proto pt;
    private VentanaPanel vp;
    String a;
    StringBuffer buffer;
    double gradRef, mov, pasoRef, angRef;
    InetAddress IPdestino;
    int puertoDestino;

    public ControlChat(Proto pt, VentanaPanel vp) {
        this.pt = pt;
        this.vp = vp;

        buffer = new StringBuffer();
        angRef = 0;
        gradRef = 0;
        pasoRef = 0;
        a = new String();
    }

    public void stateChanged(ChangeEvent e) {

        JComponent source = (JComponent) e.getSource();
        try {
            IPdestino = InetAddress.getByName(vp.getIPDestino().getText());
            puertoDestino = Float.valueOf(vp.getPuertoDestino().getText()).intValue();
        } catch (IOException se) {
        }
        if (source.getName() == "movVertical") {
            double angulo = ((Double) (((JSpinner) source).getValue())).doubleValue();
            mov = angulo - angRef;

            if (mov == 1) {
                a = "a";
                angRef = angulo;
                transmisor();
            } else if (mov == -1) {
                a = "b";
                angRef = angulo;
                transmisor();
            }
        }
        if (source.getName() == "azimut") {

            double grado = ((Double) (((JSpinner) source).getValue())).doubleValue();

            mov = grado - gradRef;

            if (mov == 2) {
                a = "c";
                gradRef = grado;
                transmisor();
            } else if (mov == -2) {
                a = "d";
                gradRef = grado;
                transmisor();
            }
        }
        if (source.getName() == "elevacion") {

            double paso = ((Double) (((JSpinner) source).getValue())).doubleValue();

            mov = paso - pasoRef;

            if (mov == 2) {
                a = "e";
                pasoRef = paso;
                transmisor();
            } else if (mov == -2) {
                a = "f";
                pasoRef = paso;
                transmisor();
            }
        }

    }

    public void keyPressed(KeyEvent evento) {
        String tecla = evento.getKeyText(evento.getKeyCode());
        try {
            IPdestino = InetAddress.getByName(vp.getIPDestino().getText());
            puertoDestino = Float.valueOf(vp.getPuertoDestino().getText()).intValue();
        } catch (IOException se) {
        }

        if (tecla.equals("Arriba")) {
            a = "g";
            transmisor();
        }
        if (tecla.equals("Abajo")) {
            a = "h";
            transmisor();
        }
        if (tecla.equals("Derecha")) {
            a = "i";
            transmisor();
        }
        if (tecla.equals("Izquierda")) {
            a = "j";
            transmisor();
        }
    }

    public void keyReleased(KeyEvent evento) {
    }

    public void keyTyped(KeyEvent evento) {
    }

    public void transmisor() {
        try {
            dgp = new DatagramPacket(a.getBytes(),
                    a.getBytes().length,
                    IPdestino, puertoDestino);
            dgs = new DatagramSocket();
            dgs.send(dgp);
            byte[] bufLect = dgp.getData();
            String mensaje = new String(bufLect, 0, dgp.getLength());
        } catch (SocketException se) {
        } catch (UnknownHostException uHE) {
        } catch (IOException se) {
        }
    }
}
