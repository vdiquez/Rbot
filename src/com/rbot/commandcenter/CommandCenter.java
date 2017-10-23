package com.rbot.commandcenter;

import com.rbot.commandcenter.communications.Transmitter;
import com.rbot.commandcenter.view.ViewFinder;
import com.rbot.commandcenter.communications.Transceiver;
import com.rbot.view.NetworkLocation;
import com.rbot.virtualuniverse.VirtualScenary;

import javax.swing.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class CommandCenter extends Thread {
    ViewFinder viewFinder;
    Transmitter transmitter;
    NetworkLocation vp;
    Transceiver transceiver;
    private VirtualScenary pt;
    Thread readThread;

    public CommandCenter() {
        pt = new VirtualScenary();
        vp = new NetworkLocation();
        transceiver = new Transceiver(pt);
        transmitter = new Transmitter(vp);
        viewFinder = new ViewFinder(transmitter, pt, vp);
        try {
            InetAddress adr = InetAddress.getLocalHost();
            //InetAddress adr = InetAddress.getByName("127.0.0.1");
            vp.getIPLocal().setText(adr.getHostAddress());
            vp.getPuertoLocal().setText(Integer.toString(transceiver.getPuertoLocal()));
            readThread = new Thread(transceiver);
            transceiver.start();
        } catch (UnknownHostException uhe) {
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception excepcion) {
            excepcion.printStackTrace();
        }
     /* new Thread ( new CommandCenter() , "CC").start();
	  new Thread ( new ExperimentalEnvironment() , "EE").start();*/

        //CommandCenter programaChat = new CommandCenter();

    }
}
