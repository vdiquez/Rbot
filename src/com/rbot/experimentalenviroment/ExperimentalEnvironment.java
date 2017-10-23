package com.rbot.experimentalenviroment;

import com.rbot.experimentalenviroment.actions.CameraListener;
import com.rbot.view.NetworkLocation;
import com.rbot.virtualuniverse.VirtualScenary;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;


public class ExperimentalEnvironment extends JFrame implements Runnable {
    private DatagramPacket dgp;
    public DatagramSocket dgs;
    byte[] buf, bufLect;
    String mensaje;
    Thread readThread;
    float refVertical, refAzimut, refElevacion;
    JPanel panel1, panel2, panel3, panel4;
    VirtualScenary pt;
    CameraListener c;
    NetworkLocation vp;

    public ExperimentalEnvironment() {
        this.setTitle("Receptor");
        JPopupMenu.setDefaultLightWeightPopupEnabled(false);
        refVertical = 0.0f;
        refAzimut = 0.0f;
        refElevacion = 0.0f;
        pt = new VirtualScenary();
        JMenuBar menubar1 = new JMenuBar();
        JMenu menu2 = new JMenu("Puntos de Vista");
        menubar1.add(menu2);
        JMenu menu1 = new JMenu("Comunicación");
        menubar1.add(menu1);
        this.setJMenuBar(menubar1);
        JMenuItem submenu5 = new JMenuItem("Isometrico");
        menu2.add(submenu5);
        JMenuItem submenu6 = new JMenuItem("Superior");
        menu2.add(submenu6);
        JMenuItem submenu7 = new JMenuItem("Camara");
        menu2.add(submenu7);
        vp = new NetworkLocation();
        JMenuItem submenu8 = new JMenuItem("Ubicacion y Destino");
        submenu8.addActionListener(vp);
        menu1.add(submenu8);
        JDesktopPane dtp = new JDesktopPane();
        this.setContentPane(dtp);
        c = new CameraListener(pt);
        JMenu control = new JMenu("Controles");
        JMenuItem panelManejo = construirMenuItem("Panel de Manejo",
                c, "panelManejo");
        control.add(panelManejo);
        menubar1.add(control);
        this.setJMenuBar(menubar1);
        GridLayout gl = new GridLayout(2, 2);
        this.getContentPane().setLayout(gl);
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        panel3.setLayout(new BorderLayout());
        panel4.setLayout(new BorderLayout());
        panel1.add("Center", pt.getCanvas3D());
        panel2.add("Center", pt.getCanvas());
        panel3.add("Center", pt.dameCanvas());
        panel4.add("Center", pt.dameCanvas3());
        panel1.setBorder(new EmptyBorder(10, 10, 5, 5));
        panel2.setBorder(new EmptyBorder(10, 5, 5, 10));
        panel3.setBorder(new EmptyBorder(5, 10, 10, 5));
        panel4.setBorder(new EmptyBorder(5, 5, 10, 10));
        this.getContentPane().add(panel1);
        this.getContentPane().add(panel2);
        this.getContentPane().add(panel3);
        this.getContentPane().add(panel4);
        setSize(500, 500);
        setLocation(250, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            buf = new byte[1000];
            dgp = new DatagramPacket(buf, buf.length);
            dgs = new DatagramSocket(5555);
        } catch (SocketException se) {
        }
        try {
            InetAddress addr = InetAddress.getByName("127.0.0.1");
            vp.getIPLocal().setText(addr.getHostAddress());
            vp.getPuertoLocal().setText(Integer.toString(this.getPuerto()));
        } catch (UnknownHostException uhe) {
        }
        readThread = new Thread();
        readThread.start();
        setVisible(true);
    }

    public void run() {
        while (true) {
            try {
                dgs.receive(dgp);
                bufLect = dgp.getData();
                mensaje = new String(bufLect, 0, dgp.getLength());
                if (mensaje.equals("a")) {
                    pt.getCuerpo().getEstructuraCamara().getCremallera().rotarEjeZ(refVertical);
                    pt.getCuerpo().getEstructuraCamara().dameEngranajeElevador().girarEjeY(refVertical);
                    pt.subirBajar(refVertical);

                    refVertical = refVertical + 0.1f;
                    transmisor();
                }
                if (mensaje.equals("b")) {
                    pt.getCuerpo().getEstructuraCamara().getCremallera().rotarEjeZ(refVertical);
                    pt.getCuerpo().getEstructuraCamara().dameEngranajeElevador().girarEjeY(refVertical);
                    pt.subirBajar(refVertical);
                    refVertical = refVertical - 0.1f;
                    transmisor();
                }
                if (mensaje.equals("c")) {
                    pt.getCuerpo().getEstructuraCamara().rotarEjeZ(refAzimut);
                    pt.getCuerpo().dameEngranajeBaseMotor().girarEjeZ(-refAzimut);
                    pt.girar(refAzimut);
                    refAzimut = refAzimut + 2;
                    transmisor();
                }
                if (mensaje.equals("d")) {
                    pt.getCuerpo().getEstructuraCamara().rotarEjeZ(refAzimut);
                    pt.getCuerpo().dameEngranajeBaseMotor().girarEjeZ(-refAzimut);
                    pt.girar(refAzimut);
                    refAzimut = refAzimut - 2;
                    transmisor();
                }
                if (mensaje.equals("e")) {
                    pt.getCuerpo().getEstructuraCamara().getCremallera().getCamara().rotarEjeY(refElevacion);
                    pt.elevar(refElevacion);
                    refElevacion = refElevacion + 2;
                    transmisor();
                }
                if (mensaje.equals("f")) {
                    pt.getCuerpo().getEstructuraCamara().getCremallera().getCamara().rotarEjeY(refElevacion);
                    pt.elevar(refElevacion);
                    refElevacion = refElevacion - 2;
                    transmisor();
                }
                if (mensaje.equals("g")) {
                    pt.getCuerpo().moverOrugaDerecha();
                    pt.getCuerpo().avanzar();
                    pt.avanzar();
                    pt.avanzarCanvas3();
                    transmisor();
                }
                if (mensaje.equals("h")) {
                    pt.getCuerpo().moverOrugaIzquierda();
                    pt.getCuerpo().retroceder();
                    pt.retroceder();
                    pt.retrocederCanvas3();
                    transmisor();
                }
                if (mensaje.equals("i")) {
                    pt.getCuerpo().moverDerecha();
                    pt.getCuerpo().derecha();
                    pt.derecha();
                    pt.derechaCanvas3();
                    transmisor();
                }
                if (mensaje.equals("j")) {
                    pt.getCuerpo().moverIzquierda();
                    pt.getCuerpo().izquierda();
                    pt.izquierda();
                    pt.izquierdaCanvas3();
                    transmisor();
                } else {
                }

            } catch (IOException ioE) {
            }
        }

    }

    public int getPuerto() {
        return dgs.getLocalPort();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception excepcion) {
            excepcion.printStackTrace();
        }
        new Thread(new ExperimentalEnvironment(), "EE").start();
        //new Thread(new CommandCenter(), "CC").start();
    }

    private JMenuItem construirMenuItem(String etiqueta, ActionListener escucha, String nombre) {
        JMenuItem jMenuItem = new JMenuItem(etiqueta.toString());
        jMenuItem.addActionListener(escucha);
        jMenuItem.setName(nombre.toString());
        return jMenuItem;
    }

    public void transmisor() {
        try {
            InetAddress IPdestino = InetAddress.getByName(vp.getIPDestino().getText());
            int puertoDestino = Float.valueOf(vp.getPuertoDestino().getText()).intValue();
            String a = new String();

            dgp = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, IPdestino, puertoDestino);
            dgs.send(dgp);
        } catch (SocketException se) {
        } catch (UnknownHostException uhe) {
        } catch (IOException ioe) {
        }
    }
}