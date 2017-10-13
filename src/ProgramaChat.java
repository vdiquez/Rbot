import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class ProgramaChat extends Thread
{
	Chat chat;
	ControlChat controlChat;
	VentanaPanel vp;
	TxRx txRx;
	private Proto pt;
	Thread readThread; 
	
	public ProgramaChat()
	{
		pt = new Proto();
		vp = new VentanaPanel();
		txRx = new TxRx(pt);
		controlChat = new ControlChat(pt,vp);
		chat = new Chat(controlChat,pt,vp);
		try
		{
		InetAddress adr = InetAddress.getLocalHost();
		//InetAddress adr = InetAddress.getByName("127.0.0.1");
		vp.getIPLocal().setText(adr.getHostAddress());
		vp.getPuertoLocal().setText(Integer.toString(txRx.getPuertoLocal()));
		readThread = new Thread(txRx);
		txRx.start();
		}
		catch(UnknownHostException uhe)
		{
		}
	}

	public static void main(String[]args)
	{
		 try
		 {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		 }

      
      catch ( Exception excepcion ) {
         excepcion.printStackTrace();
      }
	 /* new Thread ( new ProgramaChat() , "Pepe").start();
	  new Thread ( new VentanaTodo() , "Pepe").start();*/

		//ProgramaChat programaChat = new ProgramaChat();
		
	}
}