import javax.media.*;
import javax.media.protocol.*;
import javax.media.format.*;
import javax.media.control.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.comm.*;

public class VisorVideo extends JFrame implements Runnable
{
	private Processor procesador;
	private Player player;
	private MediaLocator localizacionCamaraWeb,salidaTxRTP;
	private DataSource fuenteWebCam, clon1FuenteWebCam,clon2FuenteWebCam,entradaTxRTP;
	private boolean procesadorListo = false;
	private boolean unaPista_O_Mas = false;
	private DataSink transmisorRTP;
///////////////////////////////SERIAL//////////////////////
	 static Enumeration portList;
    static CommPortIdentifier portId;
    static String messageString;
    static SerialPort serialPort;
    static OutputStream outputStream;
///////////////////////////////////////////////////////
	VentanaPanel vp;

	private DatagramPacket dgp;
	public DatagramSocket dgs;
	byte[] buf,bufLect ;
	String mensaje;

	Thread readThread; 


	public VisorVideo()
	{
		super("Visor de Video");
		ajustarVentana();
		ajustarLocalizacion_y_FuenteWebCam();
		crearPlayer();
		ajustarVisorPlayer();


		vp = new VentanaPanel();

		JPopupMenu.setDefaultLightWeightPopupEnabled(false);

		JMenuBar barra = new JMenuBar();
		this.setJMenuBar(barra);
		JMenu menuC = new JMenu("Comunicaciones");
		JMenuItem itemDP = new JMenuItem("Ubicacion y Destino");
		itemDP.addActionListener(vp);

		
		barra.add(menuC);
		menuC.add(itemDP);
		


		readThread = new Thread();
		readThread.start();


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


		this.setVisible(true);
		
		crearProcesador();
		ajustarFormatosPistas();
		ajustarEstadoRealizadoProcesador();
		ajusteTransmisor(); 

		
	
	
	}
/****************************************************************
     * Utilidad para manejar los cambios de estado del procesador.
     ****************************************************************/
    
    private Integer stateLock = new Integer(0);
    private boolean failed = false;
    
    Integer getStateLock() {
	return stateLock;
    }

    void setFailed() {
	failed = true;
    }
    
    private synchronized boolean waitForState(Processor p, int state) {
	p.addControllerListener(new StateListener());
	failed = false;

	// Call the required method on the processor
	if (state == Processor.Configured) {
	    p.configure();
	} else if (state == Processor.Realized) {
	    p.realize();
	}
	
	// Wait until we get an event that confirms the
	// success of the method, or a failure event.
	// See StateListener inner class
	while (p.getState() < state && !failed) {
	    synchronized (getStateLock()) {
		try {
		    getStateLock().wait();
		} catch (InterruptedException ie) {
		    return false;
		}
	    }
	}

	if (failed)
	    return false;
	else
	    return true;
    }
class StateListener implements ControllerListener
	{
	  public void controllerUpdate(ControllerEvent ce)
		  {

				// If there was an error during configure or
				// realize, the processor will be closed
				if (ce instanceof ControllerClosedEvent)
					setFailed();
				// All controller events, send a notification
				// to the waiting thread in waitForState method.
				if (ce instanceof ControllerEvent)
					{
						synchronized (getStateLock())
						{
							getStateLock().notifyAll();
						}
					}
		  }
	}
    Format ajustarFormatoEstandardVideo(Format original, Format supported) {
	int width, height;
	Dimension size = ((VideoFormat)original).getSize();
	Format jpegFmt = new Format(VideoFormat.JPEG_RTP);
	Format h263Fmt = new Format(VideoFormat.H263_RTP);

	if (supported.matches(jpegFmt)) {
	    // For JPEG, make sure width and height are divisible by 8.
	    width = (size.width % 8 == 0 ? size.width :
				(int)(size.width / 8) * 8);
	    height = (size.height % 8 == 0 ? size.height :
				(int)(size.height / 8) * 8);
	} else if (supported.matches(h263Fmt)) {
	    // For H.263, we only support some specific sizes.
	    if (size.width < 128) {
		width = 128;
		height = 96;
	    } else if (size.width < 176) {
		width = 176;
		height = 144;
	    } else {
		width = 352;
		height = 288;
	    }
	} else {
	    // We don't know this particular format.  We'll just
	    // leave it alone then.
	    return supported;
	}

	return (new VideoFormat(null, 
				new Dimension(width, height), 
				Format.NOT_SPECIFIED,
				null,
				Format.NOT_SPECIFIED)).intersects(supported);
    }
private void ajustarVentana()
{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(0,250);
		this.setSize(350,320);
}
private void ajustarLocalizacion_y_FuenteWebCam()
{
	localizacionCamaraWeb = null;
	localizacionCamaraWeb = new MediaLocator("vfw://0");
	if(localizacionCamaraWeb != null)
	 {
		System.out.println("Creacion exitosa del localizador de Camara Web");
	 }
	else
	 {
		System.out.println("mLocator es nulo");
	 }
	 fuenteWebCam = null;
	 clon1FuenteWebCam = null;
	 clon1FuenteWebCam = null;
	 try
		{
		 fuenteWebCam     = Manager.createDataSource(localizacionCamaraWeb);
		 clon1FuenteWebCam = Manager.createCloneableDataSource(fuenteWebCam);
		 clon2FuenteWebCam =  ((SourceCloneable)clon1FuenteWebCam).createClone();
		}
		catch(NoDataSourceException noDataSourceException)
			{
			  noDataSourceException.printStackTrace();
			}
		catch(IOException ioException)
		{
			ioException.printStackTrace();
		}

		if( clon1FuenteWebCam != null)
		{
			System.out.println("Se creo fuente");
		}
		else
		{
			System.out.println("fuente es nula");
		}
		if( clon2FuenteWebCam != null)
		{
			System.out.println("Se creo clonFuente");
		}
		else
		{
			System.out.println("clonFuente es nula");
    	}
}
private void crearPlayer()
{
   player = null;
   try
	{
	   player = Manager.createRealizedPlayer(clon1FuenteWebCam);
	}
	catch(NoPlayerException noPlayerException)
	{}
	catch(CannotRealizeException cannotRealizeException)
	{}
	catch(IOException ioException)
	{}
 }
private void crearProcesador()
	{
		procesador = null;
      try
	{
	  procesador = Manager.createProcessor(clon2FuenteWebCam);
	}
	catch(NoProcessorException noProcessorException)
	{}
	catch(NoPlayerException noPlayerException)
	{}
	catch(IOException ioException)
	{}
    boolean pruebaEstadoProcesador = waitForState(procesador,procesador.Configured);
	if(pruebaEstadoProcesador == false)
		{
			System.out.println("el procesador no se puede configurar");
			System.exit(-1);
		}
		
	}
private void ajustarFormatosPistas()
{
// Obteniendo las pistas del procesador
	TrackControl [] pistas = procesador.getTrackControls();
// Existe al menos una pista?
	if (pistas == null || pistas.length < 1)
		{   
			System.out.println( "No se pueden hallar pistas en el  procesador");
        }
		else
		{
			unaPista_O_Mas = true;
			System.out.println("Se hallaron: " + pistas.length + " pistas");
		}
	Format formatoElejido;
	Format[] formatosSoportados;
	if(unaPista_O_Mas)
	for (int i = 0; i < pistas.length; i++)
		{
	      formatosSoportados = pistas[i].getSupportedFormats();
		  listarFormatosSoportados(i, formatosSoportados);
		 Format formato = pistas[i].getFormat();
		 Dimension cuadroVideo = ((VideoFormat)(formato)).getSize();
		 float frecCuadros =   ((VideoFormat)(formato)).getFrameRate();
		 int ancho = (cuadroVideo.width%8 == 0 ? cuadroVideo.width
			                                    :(int)(cuadroVideo.width/8)*8);
		 int alto = (cuadroVideo.height%8 == 0 ? cuadroVideo.height
			                                    :(int)(cuadroVideo.height/8)*8);
		 VideoFormat formatoJPG;
		 formatoJPG = new VideoFormat(VideoFormat.JPEG_RTP,
			                          new Dimension(ancho,alto),
			                          Format.NOT_SPECIFIED,
			                          Format.byteArray,
			                          frecCuadros);
		 pistas[i].setFormat(formatoJPG);
		 System.out.println("\n\n\nFormato de Pista ajustado a:");
		 System.out.println(formatoJPG + "\n\n\n");
		// Se asume exito
		}
	ContentDescriptor cd = new ContentDescriptor(ContentDescriptor.RAW_RTP);
	procesador.setContentDescriptor(cd);
}
private void ajustarVisorPlayer()
{
	player.start();
	this.getContentPane().add("Center",player.getVisualComponent());
	
}
private void ajusteTransmisor()
{
    
	String rtpURL = "rtp://127.0.0.1:55000/video";
	salidaTxRTP = null;
	salidaTxRTP= new MediaLocator(rtpURL);
	if(salidaTxRTP == null)
	 {
		System.out.println("problemas creando salidaTxRTP");
	}
	try
 	{   
		setJPEGQuality(procesador, 0.5f);
		entradaTxRTP = procesador.getDataOutput();
		transmisorRTP = Manager.createDataSink(entradaTxRTP,salidaTxRTP);
		procesador.start();
		transmisorRTP.open();
		transmisorRTP.start();
		entradaTxRTP.start();
	}
	catch(MediaException mediaException)
		{
			mediaException.printStackTrace();
		}
	catch(SecurityException securityException)
		{
			System.out.println("Error tipo IOException");
			securityException.printStackTrace();
		}
	catch(IOException ioException)
		{
			System.out.println("Error tipo IOException");
			ioException.printStackTrace();
		}

}
private void listarFormatosSoportados(int nroPista,Format[] formatosSoportados)
	{
	  if(formatosSoportados.length > 0)
		{
		  System.out.println("LISTA DE FORMATOS PRESENTADOS por PISTA");
		  System.out.println("PISTA Nro:  " + nroPista);
		  for (int i=0;i<formatosSoportados.length ;i++ )
		  {
			  System.out.println("Pista: " + nroPista + "  " + 
				                 "Formato: " + i + " " +  formatosSoportados[i]);
		  }
		  System.out.println("Fin Listado PISTA, pista nro: " + nroPista);
		}
	}
  private void ajustarEstadoRealizadoProcesador()
	{
		boolean pruebaEstadoProcesador = waitForState(procesador,procesador.Realized);
		if(pruebaEstadoProcesador == false)
		{
			System.out.println("el procesador no se puede Realizar");
			System.exit(-1);
		}
        procesadorListo = true;
	}
void setJPEGQuality(Player p, float val) 
		{
		Control cs[] = p.getControls();
		QualityControl qc = null;
		VideoFormat jpegFmt = new VideoFormat(VideoFormat.JPEG);
		// Bucle para encontrar el control de calidad del codificador JPEG.
		for (int i = 0; i < cs.length; i++) 
			{
			if (cs[i] instanceof QualityControl && cs[i] instanceof Owned) 
				{
				Object owner = ((Owned)cs[i]).getOwner();
				// Chequeo para saber si el propietario (Owner) es un Codec.
				// Si es asi, se chequea el formato de salida.
				if (owner instanceof Codec) 
					{
					Format fmts[] = ((Codec)owner).getSupportedOutputFormats(null);
					for (int j = 0; j < fmts.length; j++)
						{
						if (fmts[j].matches(jpegFmt)) 
							{
							qc = (QualityControl)cs[i];
							qc.setQuality(val);
							System.err.println("- Setting quality to " + val + " on " + qc);
							break;
							}
						}
					}
					if (qc != null)
						break;
				}
			}
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
				messageString = "w";
				escribe();
			}
			if (mensaje.equals("b"))
			{
				System.out.println("Lleg� a");
				messageString = "s";
				escribe();
			}
			if (mensaje.equals("c"))
			{
				System.out.println("Lleg� a");
				messageString = "d";
				escribe();
			}
			if (mensaje.equals("d"))
			{
				System.out.println("Lleg� a");
				messageString = "a";
				escribe();
			}
			if (mensaje.equals("e"))
			{
				System.out.println("Lleg� a");
				messageString = "4";
				escribe();
			}
			if (mensaje.equals("f"))
			{
				System.out.println("Lleg� a");
				messageString = "6";
				escribe();
			}
			if (mensaje.equals("g"))
			{
				System.out.println("Lleg� a");
				messageString = "8";
				escribe();
			}
			if (mensaje.equals("h"))
			{
				System.out.println("Lleg� a");
				messageString = "2";
				escribe();
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
public void escribe(){
 portList = CommPortIdentifier.getPortIdentifiers();

        while (portList.hasMoreElements()) {
            portId = (CommPortIdentifier) portList.nextElement();
			
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
               if (portId.getName().equals("COM1")) {
               // if (portId.getName().equals("/dev/term/a")) {
                    try {
                        serialPort = (SerialPort)
                            portId.open("SimpleWriteApp", 2000);
                    } catch (PortInUseException e) {}
                    try {
                        outputStream = serialPort.getOutputStream();
                    } catch (IOException e) {}
                    try {
                        serialPort.setSerialPortParams(9600,
                            SerialPort.DATABITS_8,
                            SerialPort.STOPBITS_1,
                            SerialPort.PARITY_NONE);
                    } catch (UnsupportedCommOperationException e) {}
                    try {
                        outputStream.write(messageString.getBytes());
						System.out.println(messageString);
                    } catch (IOException e) {}
                }
            }
        }
    }

}