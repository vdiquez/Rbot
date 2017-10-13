import javax.media.*;
import javax.media.protocol.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.net.*;

public class RxVideo extends JFrame implements KeyListener,ActionListener
{
	VentanaPanel vp;
	private DatagramPacket dgp;
	public DatagramSocket dgs;
	byte[] buf,bufLect ;
	String mensaje;

 	public RxVideo()
	{
		super("Receptor de Video");
		
		JPopupMenu.setDefaultLightWeightPopupEnabled(false);
		vp = new VentanaPanel();

		JMenuBar barra = new JMenuBar();
		this.setJMenuBar(barra);
		JMenu menuC = new JMenu("Comunicaciones");
		JMenuItem itemDP = new JMenuItem("Ubicacion y Destino");
		itemDP.addActionListener(vp);

		
		barra.add(menuC);
		menuC.add(itemDP);
		


		
		System.out.println("dentro de RxVideo antes de operaciones");
		String rtpURL = "rtp://127.0.0.1:55000/video";
        MediaLocator entradaRxRTP  = new MediaLocator(rtpURL);
		System.out.println("despues de medailocator");
		Player player = null;
		try
		{
			player = Manager.createRealizedPlayer(entradaRxRTP);
		}
		catch(NoPlayerException noPlayerException)
		{
			noPlayerException.printStackTrace();
		}
		catch(CannotRealizeException cannotRealizeException)
		{
			cannotRealizeException.printStackTrace();
		}
		catch(IOException ioException)
		{
			ioException.printStackTrace();
		} 
		System.out.println("antes de palyer start");
		player.start();
		System.out.println("despues de palyer start");

		//this.getContentPane().add("Center",player.getVisualComponent());

		////////////////////////////////////////////

		GridLayout gl =new GridLayout(1,2);

		this.getContentPane().setLayout(gl);

		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel12 = new JPanel();
		JPanel panel121 = new JPanel();
		JPanel panel122 = new JPanel();
		JPanel panel11 = new JPanel();
		JPanel panel13 = new JPanel();

		JButton boton = new JButton("Til +");
		JButton boton1 = new JButton("Til -");
		JButton boton2 = new JButton("Paneo +");
		JButton boton3 = new JButton("Paneo -");

		boton.addKeyListener(this);
		boton1.addKeyListener(this);
		boton2.addKeyListener(this);
		boton3.addKeyListener(this);

		boton.addActionListener(this);
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		boton3.addActionListener(this);


		panel.setLayout(new GridLayout(1, 1));
		panel1.setLayout(new GridLayout(2, 1));
		panel11.setLayout(new BorderLayout());
		panel12.setLayout(new GridLayout(1, 2));
		panel121.setLayout(new GridLayout(4, 1));
		panel122.setLayout(new GridLayout(1, 1));

	

			

		panel.setBorder(new EmptyBorder(10,10,10,5));
		panel1.setBorder(new EmptyBorder(10,5,10,10));	
		panel11.setBorder(new TitledBorder("Vista de Ramoncito"));
		panel12.setBorder(new TitledBorder("Control C�mara"));
		
		player.getVisualComponent().addKeyListener(this);

		//panel13.setBackground(new java.awt.Color(100,100, 92));
		panel.add(panel11);
		panel121.add(boton);
		panel121.add(boton1);
		panel121.add(boton2);
		panel121.add(boton3);
		panel12.add(panel121);
		panel12.add(panel122);
		panel1.add(panel12);
		//panel1.add(panel13);
		this.getContentPane().add(panel);
		this.getContentPane().add(panel1);

		panel11.add("Center",player.getVisualComponent());

		this.setLocation(350,250);
		this.setSize(700,350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		this.setVisible(true);		
	}

	public void keyPressed( KeyEvent evento )
   {
		 String tecla = evento.getKeyText( evento.getKeyCode() );
		/* try
			 {
			/* IPdestino = InetAddress.getByName(vp.getIPDestino().getText());
			 puertoDestino = Float.valueOf(vp.getPuertoDestino().getText()).intValue();
			 }
		 catch (IOException se)
			 {	
			 }*/
			  if (tecla.equals("Espacio"))
		 {
			  mensaje = " ";
			  transmisor();
		 }

		 if (tecla.equals("Arriba"))
		 {
			  mensaje = "b";
			  transmisor();
		 }
		 if (tecla.equals("Inactivo"))
		 {
			  mensaje = "a";
			  transmisor();
		 }
		  if (tecla.equals("Derecha"))
		 {
			   mensaje = "d";
			   transmisor();
		 }
		  if (tecla.equals("Izquierda"))
		 {   
			   mensaje = "c";
			   transmisor();
		 }
		  if (tecla.equals("A"))
		 {   
			   mensaje = "e";
			   transmisor();
		 }
		  if (tecla.equals("S"))
		 {   
			   mensaje = "f";
			   transmisor();
		 }
		  if (tecla.equals("D"))
		 {   
			   mensaje = "h";
			   transmisor();
		 }
		  if (tecla.equals("F"))
		 {   
			   mensaje = "g";
			   transmisor();
		 }
   }
   public void keyReleased( KeyEvent evento )
   {
	    String tecla = evento.getKeyText( evento.getKeyCode() );
		 System.out.println(tecla);
		 if (tecla.equals ("Arriba"))
		{
			mensaje = " ";
			transmisor();
		}
	  if (tecla.equals ("Inactivo"))
		{
			mensaje = " ";
			transmisor();
		}
		if (tecla.equals ("Izquierda"))
		{
			mensaje = " ";
			transmisor();
		}
		if (tecla.equals ("Derecha"))
		{
			
			mensaje = " ";
			transmisor();
		}
			 
   }

   public void keyTyped( KeyEvent evento )
   {
   }

   public void actionPerformed (ActionEvent a)
	{
	    Opciones(a.getActionCommand());
	}
	private void Opciones(String comando)
	{
		if (comando == "Til +")
		{
			System.out.println("Til +");
			mensaje = "e";
			transmisor();
		}
		if (comando == "Til -")
		{
			System.out.println("Til -");
			mensaje = "f";
			transmisor();
		}
		if (comando == "Paneo +")
		{
			System.out.println("Paneo +");
			mensaje = "g";
			transmisor();
		}
		if (comando == "Paneo -")
		{
			System.out.println("Paneo -");
			mensaje = "h";
			transmisor();
		}
	}

  /* public static void main(String[] args) 
	{
		try
			{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
		catch ( Exception excepcion ) 
			{
			excepcion.printStackTrace();
			}

		new VisorVideo();
		new RxVideo();

	}*/

	public void transmisor()
	{
		try
		{
			System.out.println("Mensaje: "+ mensaje);
			dgs = new DatagramSocket();
			InetAddress IPdestino = InetAddress.getByName(vp.getIPDestino().getText());
			int puertoDestino = Float.valueOf(vp.getPuertoDestino().getText()).intValue();			
			System.out.println("Puerto Destino: "+puertoDestino+"\nIP Destino: "+IPdestino);
			dgp = new DatagramPacket(mensaje.getBytes(),mensaje.getBytes().length,IPdestino,puertoDestino);
			dgs.send(dgp);
			 
		}
		catch(SocketException se)
		{
		}
		catch(UnknownHostException uhe)
		{
		}
		catch(IOException ioe)
		{
		}
	}
}