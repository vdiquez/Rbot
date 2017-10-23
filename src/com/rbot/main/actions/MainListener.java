package com.rbot.main.actions;

import com.rbot.commandcenter.CommandCenter;
import com.rbot.experimentalenviroment.ExperimentalEnvironment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainListener implements ActionListener {
    public static void main(String[] args) {
        MainListener mainListener = new MainListener();
    }

    public void actionPerformed(ActionEvent ae) {
        Opciones(ae.getActionCommand());
    }

    private void Opciones(String comando) {
        if (comando == "Terminar") {
            System.exit(1);
        }
        if (comando == "Establecer Comunicacion") {
            new Thread(new CommandCenter(), "CC").start();
            new Thread(new ExperimentalEnvironment(), "EE").start();
        }
    }
}
