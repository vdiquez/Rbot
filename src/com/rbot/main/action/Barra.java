package com.rbot.main.action;

import com.rbot.chat.ProgramaChat;
import com.rbot.main.VentanaTodo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Barra implements ActionListener {
    public static void main(String[] args) {
        Barra barra = new Barra();
    }

    public void actionPerformed(ActionEvent ae) {
        Opciones(ae.getActionCommand());
    }

    private void Opciones(String comando) {
        if (comando == "Terminar") {
            System.exit(1);
        }
        if (comando == "Prototipo Real") {
        }
        if (comando == "Pelicula 1") {
        }
        if (comando == "Prototipo Virtual") {
            String[] args = {"ROBOTB2.3ds"};
        }
        if (comando == "Establecer Comunicacion") {
            new Thread(new ProgramaChat(), "Pepe").start();
            new Thread(new VentanaTodo(), "Pepe").start();
        }
    }
}
