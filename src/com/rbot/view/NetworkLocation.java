package com.rbot.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NetworkLocation extends JFrame implements ActionListener {

    private JTextField puertoDestino, IPDestino;
    private JLabel IPLocal, puertoLocal;
    JLabel etqPuertoLocal, etqPuertoDestino, etqIPLocal, etqIPDestino;

    JPanel panel;


    public NetworkLocation() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 8));

        Container contenedor = getContentPane();

        etqIPLocal = new JLabel("IP Local");
        panel.add(etqIPLocal);
        IPLocal = new JLabel("0.0.0.0");
        panel.add(IPLocal);

        etqIPDestino = new JLabel("IP Destino");
        panel.add(etqIPDestino);
        IPDestino = new JTextField("127.0.0.1");
        panel.add(IPDestino);

        etqPuertoLocal = new JLabel("Puerto Local");
        panel.add(etqPuertoLocal);
        puertoLocal = new JLabel("0000");
        panel.add(puertoLocal);

        etqPuertoDestino = new JLabel("Puerto Destino");
        panel.add(etqPuertoDestino);
        puertoDestino = new JTextField("0000");
        panel.add(puertoDestino);

        contenedor.add(panel, BorderLayout.NORTH);
        this.pack();
        setLocation(250, 100);

    }

    public void actionPerformed(ActionEvent ae) {

        String caso = ae.getActionCommand();

        if (caso == "Ubicacion y Destino") {

            this.setTitle("Direccion IP y Puerto Local");
            this.setVisible(true);

        }

    }

    public JLabel getIPLocal() {
        return IPLocal;
    }

    public JLabel getPuertoLocal() {
        return puertoLocal;
    }

    public JTextField getPuertoDestino() {
        return puertoDestino;
    }

    public JTextField getIPDestino() {
        return IPDestino;
    }
}
