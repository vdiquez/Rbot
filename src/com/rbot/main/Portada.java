package com.rbot.main;

import com.rbot.main.actions.MainListener;

import javax.swing.*;
import java.awt.*;

public class Portada extends JFrame//Inicio de la Declaracion de la Clase
{
    //Escuchador de Eventos
    MainListener mainListener = new MainListener();

    public Portada()//Constructor de la Clase Portada
    {
        //Boton que Anuncia el Evento
        JButton boton;
        boton = new JButton("Establecer Comunicacion");
        boton.addActionListener(mainListener);
        boton.setFont(new Font("Antique Olive", Font.PLAIN, 15));
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        boton.setCursor(cursor);


        /////////////////////////Contenedor
        Container contentPane = getContentPane();
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        contentPane.setLayout(gbl);

        //////////////Posicion del boton
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 250, 150, 0);
        gbl.setConstraints(boton, gbc);
        contentPane.add(boton);

        //////////////////////////Posicion de la Etiqueta Dibujo4.jpg
        JLabel jl = new JLabel(new ImageIcon("Dibujo4.jpg"));
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbl.setConstraints(jl, gbc);
        contentPane.add(jl);

        ///////////////////////////////JMenuBar, JMenu, JMenuItem
        JMenuBar mostradores = new JMenuBar();
        JMenu mostrador1 = new JMenu("Sistema");
        JMenuItem sal = new JMenuItem("Terminar");
        sal.addActionListener(mainListener);
        mostrador1.add(sal);
        this.setJMenuBar(mostradores);
        mostradores.add(mostrador1);

        //Propiedades de la Ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Dispositivo movil: Ramoncito");
        this.pack();
        this.setLocation(250, 100);
        this.setVisible(true);
        this.setResizable(false);
    }

    public static void main(String[] args)//Metodo Main
    {
        //Vista Grafica del Sistema Operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception excepcion) {
            excepcion.printStackTrace();
        }
        Portada port = new Portada();
    }
}