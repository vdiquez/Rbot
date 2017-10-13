
import javax.media.j3d.*;

public class Oruga extends BranchGroup
{
	Posicion pos1,pos2,pos3,pos4,pos5,pos6,pos7,pos8,pos9,pos10,pos11,pos12,pos13,pos14,
		pos15,pos16,pos17,pos18,pos19,pos20,pos21,pos22,pos23,pos24,pos25,pos26,pos27,pos28,pos29;
	//PiezaOruga po1;
	TransformGroup tg,tg1;
	//Transform3D trans,trans1,trans2,trans3,util;
	double localidad,pasoguardado;

	public Oruga()
	{
			localidad = 1;
			pasoguardado = 0;
		
		this.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		this.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		tg = new TransformGroup();
		tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		tg1 = new TransformGroup();
		tg1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		tg1.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		//trans = new Transform3D();

		//po1 = new PiezaOruga();
		System.out.println("Antes\n \n \n");
		pos1 = new Posicion(-10.61f,0.35f,0.09f,2.19f);
		/*pos2 = new Posicion(-6.61f,0.35f,0.0f,0.0f);
		pos3 = new Posicion(-2.61f,0.35f,0.0f,0.0f);
		pos4 = new Posicion(1.39f,0.35f,0.0f,0.0f);
		pos5 = new Posicion(5.39f,0.35f,0.0f,0.0f);
		pos6 = new Posicion(9.39f,0.35f,0.0f,0.0f);
		pos7 = new Posicion(13.39f,0.35f,0.0f,0.0f);
		pos8 = new Posicion(17.39f,0.35f,-0.06f,1.57f);
		pos9 = new Posicion(21.46f,0.35f,0.67f,-22.15f);
		pos10 = new Posicion(24.89f,0.35f,3.05f,-48.0f);
		pos11 = new Posicion(27.11f,0.35f,6.5f,-70.28f);
		pos12 = new Posicion(27.72f,0.35f,10.68f,-93.76f);
		pos13 = new Posicion(26.54f,0.35f,14.68f,-119.03f);
		pos14 = new Posicion(23.8f,0.35f,17.83f,-144.29f);
		pos15 = new Posicion(20.02f,0.35f,19.62f,-164.0f);
		pos16 = new Posicion(16.0f,0.35f,20.22f,180.43f);
		pos17 = new Posicion(12.0f,0.35f,20.24f,180.0f);
		pos18 = new Posicion(8.0f,0.35f,20.24f,180.0f);
		pos19 = new Posicion(4.0f,0.35f,20.24f,180.0f);
		pos20 = new Posicion(0.0f,0.35f,20.24f,180.0f);
		pos21 = new Posicion(-4.0f,0.35f,20.24f,180.0f);
		pos22 = new Posicion(-8.0f,0.35f,20.19f,180.47f);
		pos23 = new Posicion(-12.0f,0.35f,19.88f,167.14f);
		pos24 = new Posicion(-15.8f,0.35f,18.41f,150.18f);
		pos25 = new Posicion(-18.79f,0.35f,15.43f,119.94f);
		pos26 = new Posicion(-20.19f,0.35f,11.55f,98.72f);
		pos27 = new Posicion(-19.9f,0.35f,7.37f,72.0f);
		pos28 = new Posicion(-17.94f,0.35f,3.66f,49.68f);
		pos29 = new Posicion(-14.77f,0.35f,1.14f,24.2f);*/
		System.out.println("Despues\n \n \n");
		tg.addChild(pos1);
		/*tg.addChild(pos2);
		tg.addChild(pos3);
		tg.addChild(pos4);
		tg.addChild(pos5);
		tg.addChild(pos6);
		tg.addChild(pos7);
		tg.addChild(pos8);
		tg.addChild(pos9);
		tg.addChild(pos10);
		tg.addChild(pos11);
		tg.addChild(pos12);
		tg.addChild(pos13);
		tg.addChild(pos14);
		tg.addChild(pos15);
		tg.addChild(pos16);
		tg.addChild(pos17);
		tg.addChild(pos18);
		tg.addChild(pos19);
		tg.addChild(pos20);
		tg.addChild(pos21);
		tg.addChild(pos22);
		tg.addChild(pos23);
		tg.addChild(pos24);
		tg.addChild(pos25);
		tg.addChild(pos26);
		tg.addChild(pos27);
		tg.addChild(pos28);
		tg.addChild(pos29);*/
		this.addChild(tg);
		this.compile();
		System.out.println("ultimo\n \n \n");
	}
	public void movimiento( double paso)
	{
		double mov = paso - pasoguardado;
		System.out.println("Movimiento\n \n \n");

		if (mov == 1)
		{
			System.out.println("Avanzar\n \n \n");
			avanzar();
			pasoguardado = paso;
		}
		else if(mov == -1)
		{
			System.out.println("Retrocder\n \n \n");
			retroceder();
			pasoguardado = paso;
		}
	}
	public void avanzar()
	{
		if (localidad == 1)
		{
			localidad2();
			localidad = 2;
		}
		else if (localidad == 2)
		{
			localidad3();
			localidad = 3;
		}
		else if (localidad == 3)
		{
			localidad29();
			localidad = 29;
		}
		else if (localidad == 29)
		{
			localidad1();
			localidad = 1;
		}
	}
	public void retroceder()
	{
		if (localidad == 1)
		{
			localidad29();
			localidad = 29;
		}
		else if (localidad == 2)
		{
			localidad1();
			localidad = 1;
		}
		else if (localidad == 3)
		{
			localidad2();
			localidad = 2;
		}
		else if (localidad == 29)
		{
			localidad3();
			localidad = 3;
		}
	}
	public void localidad1()
		{
			System.out.println("localidad1\n \n \n");
			pos1 = new Posicion(-10.61f,0.35f,0.09f,2.19f);
		}
		public void localidad2()
		{
			System.out.println("localidad2\n \n \n");
			pos1 = new Posicion(-6.61f,0.35f,0.0f,0.0f);
		}
		public void localidad3()
		{
			System.out.println("localidad3\n \n \n");
			pos1 = new Posicion(-2.61f,0.35f,0.0f,0.0f);
		}	
		public void localidad29()
		{
			System.out.println("localidad29\n \n \n");
			pos1 = new Posicion(-14.77f,0.35f,1.14f,24.2f);
		}	
}