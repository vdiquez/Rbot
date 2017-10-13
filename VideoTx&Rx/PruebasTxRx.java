import javax.swing.*;
public class PruebasTxRx 
{
	public static void main(String[] args) 
	{
		try
			{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
		catch ( Exception excepcion ) 
			{
			excepcion.printStackTrace();
			}

			
		//new Thread ( new VisorVideo() , "Transmisor de Video").start();
		new RxVideo();
	}
}