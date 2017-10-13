import javax.swing.*;
import java.awt.*;

public class Portada extends JFrame//Inicio de la Declaración de la Clase
{
	/////////////////////////////Escuchador de Eventos
	Barra barra = new Barra();

	public Portada()//Constructor de la Clase Portada
	{
	///////////////////////////////Boton que Anuncia el Evento
	JButton boton;
	boton = new JButton( "Establecer Comunicacion");
	boton.addActionListener(barra);
	boton.setFont( new Font( "Antique Olive",Font.PLAIN, 15));
	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
	boton.setCursor(cursor);


	/////////////////////////Contenedor
	Container contentPane = getContentPane();
	GridBagLayout  gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	contentPane.setLayout(gbl);
	
	//////////////Posición del boton
	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.insets = new Insets(0,250,150,0);
	gbl.setConstraints(boton,gbc);
	contentPane.add(boton);
	
	//////////////////////////Posición de la Etiqueta Dibujo4.jpg
	JLabel jl = new JLabel(new ImageIcon("Dibujo4.jpg"));
	gbc.fill = GridBagConstraints.BOTH;
	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.insets = new Insets(0,0,0,0);
	gbl.setConstraints(jl,gbc);
	contentPane.add(jl);

	///////////////////////////////JMenuBar, JMenu, JMenuItem	
	JMenuBar mostradores = new JMenuBar();
	JMenu mostrador1 = new JMenu("Sistema");
	JMenuItem sal = new JMenuItem("Terminar");
	sal.addActionListener(barra);
	/*JMenu mostrador2 = new JMenu("Vista");
	JMenuItem prot1 = new JMenuItem("Prototipo Virtual");
	prot1.addActionListener(barra);
	JMenuItem prot2 = new JMenuItem("Prototipo Real");
	prot2.addActionListener(barra);*/
	/*JMenu mostrador3 = new JMenu("Videos");
	JMenu pel = new JMenu("Peliculas");
	JMenu vir = new JMenu("Virtuales");
	JMenuItem vir1 = new JMenuItem("Pelicula 1");
	JMenuItem vir2 = new JMenuItem("Pelicula 2");
	JMenuItem vir3 = new JMenuItem("Pelicula 3");
	JMenu real = new JMenu("Reales");
	JMenuItem real1 = new JMenuItem("Pelicula 1");
	real1.addActionListener(barra);
	JMenuItem real2 = new JMenuItem("Pelicula 2");
	JMenuItem real3 = new JMenuItem("Pelicula 3");*/
	mostrador1.add(sal);
/*	mostrador2.add(prot1);
	mostrador2.add(prot2);
	mostrador3.add(pel);
	pel.add(vir);
	vir.add(vir1);
	vir.add(vir2);
	vir.add(vir3);
	real.add(real1);
	real.add(real2);
	real.add(real3);
	pel.add(real);*/
	this.setJMenuBar(mostradores);
	mostradores.add(mostrador1);
	/*mostradores.add(mostrador2);
	mostradores.add(mostrador3);*/

	////////////////////////Algunas propiedades de la Ventana
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("Dispositivo movil: Ramoncito");
    this.pack();  
	this.setLocation(250,100);
	this.setVisible( true );
	this.setResizable(false);	
	}

	public static void main(String[]args)//Metodo Main
	{
		////////////////////////////Vista Grafica del Sistema Operativo
		try
			{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
		catch ( Exception excepcion ) 
			{
			 excepcion.printStackTrace();
			 }
		Portada port = new Portada();
	}
}