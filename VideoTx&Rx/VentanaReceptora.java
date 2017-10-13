import javax.media.*;
import javax.media.protocol.*;
import javax.media.format.*;
import javax.media.control.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class VentanaReceptora extends JFrame implements Runnable
{
	VentanaPanel vp;

	private DatagramPacket dgp;
	public DatagramSocket dgs;
	byte[] buf,bufLect ;
	String mensaje;

	Thread readThread; 


	public VentanaReceptora()
	{
		super("Visor de Video");


		vp = new VentanaPanel();

		JPopupMenu.setDefaultLightWeightPopupEnabled(false);

		JMenuBar barra = new JMenuBar();
		this.setJMenuBar(barra);
		JMenu menuC = new JMenu("Comunicaciones");
		JMenuItem itemDP = new JMenuItem("Ubicacion y Destino");
		itemDP.addActionListener(vp);

		
		barra.add(menuC);
		menuC.add(itemDP);
		


		

			try
		{
			buf = new byte[1000];
			dgp = new DatagramPacket(buf,buf.length);
			dgs = new DatagramSocket();
		}
		catch(SocketException se)
		{
		}

		try
		{
			InetAddress addr = InetAddress.getLocalHost();
		//InetAddress addr = InetAddress.getByName("127.0.0.1");
		vp.getIPLocal().setText(addr.getHostAddress());
		vp.getPuertoLocal().setText(Integer.toString(this.getPuerto()));
		}
		catch(UnknownHostException uhe)
		{
		}

		readThread = new Thread();
		readThread.start();

		this.setVisible(true);

		
	
	
	}
		public void run( )
	{
	while(true)
		{
			try
			{
			
			dgs.receive(dgp); 
			bufLect = dgp.getData();
			mensaje = new String(bufLect,0,dgp.getLength());
			System.out.println("Lleg� algo: " + mensaje);
			if (mensaje.equals("a"))
			{
				System.out.println("Lleg� a");
			}
			}
			catch(IOException ioE)
			{
			}
		}
	}


	public int getPuerto()
	{
		return dgs.getLocalPort();
	}



}