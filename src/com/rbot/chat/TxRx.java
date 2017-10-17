package com.rbot.chat;

import com.rbot.virtualuniverse.Proto;

import java.net.*;
import java.io.*;

public class TxRx extends Thread {
    private DatagramPacket dgp;
    private DatagramSocket dgs;
    private float refVertical, refAzimut, refElevacion;
    private byte[] buf, bufLect;
    private String mensaje;
    private Proto pt;

    public TxRx(Proto pt) {

        this.pt = pt;
        try {
            buf = new byte[1000];
            dgp = new DatagramPacket(buf, buf.length);
            dgs = new DatagramSocket(8080);

        } catch (SocketException se) {
        }

    }

    public void run() {

        while (true) {
            try {
                dgs.receive(dgp);
                bufLect = dgp.getData();
                mensaje = new String(bufLect, 0, dgp.getLength());

                if (mensaje.equals("a")) {
                    pt.getCuerpo().getEstructuraCamara().getCremallera().rotarEjeZ(refVertical);
                    pt.subirBajar(refVertical);
                    refVertical = refVertical + 0.1f;
                } else if (mensaje.equals("b")) {
                    pt.getCuerpo().getEstructuraCamara().getCremallera().rotarEjeZ(refVertical);
                    pt.subirBajar(refVertical);
                    refVertical = refVertical - 0.1f;
                } else if (mensaje.equals("c")) {
                    pt.getCuerpo().getEstructuraCamara().rotarEjeZ(refAzimut);
                    pt.girar(refAzimut);
                    refAzimut = refAzimut + 2;
                } else if (mensaje.equals("d")) {
                    pt.getCuerpo().getEstructuraCamara().rotarEjeZ(refAzimut);
                    pt.girar(refAzimut);
                    refAzimut = refAzimut - 2;
                } else if (mensaje.equals("e")) {
                    pt.getCuerpo().getEstructuraCamara().getCremallera().getCamara().rotarEjeY(refElevacion);
                    pt.elevar(refElevacion);
                    refElevacion = refElevacion + 2;
                } else if (mensaje.equals("f")) {
                    pt.getCuerpo().getEstructuraCamara().getCremallera().getCamara().rotarEjeY(refElevacion);
                    pt.elevar(refElevacion);
                    refElevacion = refElevacion - 2;
                } else if (mensaje.equals("g")) {
                    pt.getCuerpo().moverOrugaDerecha();
                    pt.getCuerpo().avanzar();
                    pt.avanzar();
                } else if (mensaje.equals("h")) {
                    pt.getCuerpo().moverOrugaIzquierda();
                    pt.getCuerpo().retroceder();
                    pt.retroceder();
                } else if (mensaje.equals("i")) {
                    pt.getCuerpo().moverDerecha();
                    pt.getCuerpo().derecha();
                    pt.derecha();
                } else if (mensaje.equals("j")) {
                    pt.getCuerpo().moverIzquierda();
                    pt.getCuerpo().izquierda();
                    pt.izquierda();
                }
            } catch (IOException ioE) {
            }
        }
    }

    public int getPuertoLocal() {
        return dgs.getLocalPort();
    }
}
