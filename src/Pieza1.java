import ncsa.j3d.loaders.ModelLoader;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.io.*;
import com.sun.j3d.loaders.*;

public class Pieza1 extends BranchGroup
{	
	PiezaOruga1 poru1;
	private TransformGroup rotacion,rotacion1;
	private float desX,desZ,desY,gY,DesX,DesY,DesZ,Gy;
	Transform3D trans,trans1,rot,rot1;
	double localidad,pasoguardado,pasoguardado1,posicion;

	public Pieza1()
	{
		DesX = -10.61f;
		DesY = 0.35f;
		DesZ = 0.09f;
		Gy = 2.19f;
		desX = 0.0f;
		desY = 0.0f;
		desZ = 0.0f;
		gY =  0.0f;
		localidad = 1;
		pasoguardado = 0;
		posicion = 1;
		pasoguardado1 = 0;

		rotacion = new TransformGroup();
		rotacion.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		rotacion.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		rotacion1 = new TransformGroup();
		rotacion1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		rotacion1.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		rot = new Transform3D();
		rot1 = new Transform3D();
		trans = new Transform3D();
		trans1 = new Transform3D();

		/////////////////////////////////////////////////////////////1
		
		poru1 = new PiezaOruga1();	

		trans.setTranslation(new Vector3f((DesX-desX),(DesY-desY),(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);
		
		trans1.rotY((Gy-gY)*Math.PI/180.0d);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		desX = DesX;
		desZ = DesZ;
		gY = Gy;

		rotacion1.addChild(poru1);

		rotacion.addChild(rotacion1);

		this.addChild(rotacion);
		this.compile();
	}
	public void movimiento( double paso)
	{
		double mov = paso - pasoguardado;
		//System.out.println("Movimiento\n \n \n");

		if (mov == 1)
		{
			//System.out.println("Avanzar\n \n \n");
			avanzar();
			pasoguardado = paso;
		}
		else if(mov == -1)
		{
			//System.out.println("Retrocder\n \n \n");
			retroceder();
			pasoguardado = paso;
		}
	}
	/*public void movimiento1( double paso1)
	{
		double mov1 = paso1 - pasoguardado;
		//System.out.println("Movimiento\n \n \n");

		if (mov1 == 1)
		{
			//System.out.println("Avanzar\n \n \n");
			avanzar1();
			pasoguardado1 = paso1;
		}
		else if(mov1 == -1)
		{
			//System.out.println("Retrocder\n \n \n");
			retroceder1();
			pasoguardado1 = paso1;
		}
	}*/
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
			localidad4();
			localidad = 4;
		}
		else if (localidad == 4)
		{
			localidad5();
			localidad = 5;
		}
		else if (localidad == 5)
		{
			localidad6();
			localidad = 6;
		}
		else if (localidad == 6)
		{
			localidad7();
			localidad = 7;
		}
		else if (localidad == 7)
		{
			localidad8();
			localidad = 8;
		}
		else if (localidad == 8)
		{
			localidad9();
			localidad = 9;
		}
		else if (localidad == 9)
		{
			localidad10();
			localidad = 10;
		}
		else if (localidad == 10)
		{
			localidad11();
			localidad = 11;
		}
		else if (localidad == 11)
		{
			localidad12();
			localidad = 12;
		}
		else if (localidad == 12)
		{
			localidad13();
			localidad = 13;
		}
		else if (localidad == 13)
		{
			localidad14();
			localidad = 14;
		}
		else if (localidad == 14)
		{
			localidad15();
			localidad = 15;
		}
		else if (localidad == 15)
		{
			localidad16();
			localidad = 16;
		}
		else if (localidad == 16)
		{
			localidad17();
			localidad = 17;
		}
		else if (localidad == 17)
		{
			localidad18();
			localidad = 18;
		}
		else if (localidad == 18)
		{
			localidad19();
			localidad = 19;
		}
		else if (localidad == 19)
		{
			localidad20();
			localidad = 20;
		}
		else if (localidad == 20)
		{
			localidad21();
			localidad = 21;
		}
		else if (localidad == 21)
		{
			localidad22();
			localidad = 22;
		}
		else if (localidad == 22)
		{
			localidad23();
			localidad = 23;
		}
		else if (localidad == 23)
		{
			localidad24();
			localidad = 24;
		}
		else if (localidad == 24)
		{
			localidad25();
			localidad = 25;
		}
		else if (localidad == 25)
		{
			localidad26();
			localidad = 26;
		}
		else if (localidad == 26)
		{
			localidad27();
			localidad = 27;
		}
		else if (localidad == 27)
		{
			localidad28();
			localidad = 28;
		}
		else if (localidad == 28)
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
		else if (localidad == 4)
		{
			localidad3();
			localidad = 3;
		}
		else if (localidad == 5)
		{
			localidad4();
			localidad = 4;
		}
		else if (localidad == 6)
		{
			localidad5();
			localidad = 5;
		}
		else if (localidad == 7)
		{
			localidad6();
			localidad = 6;
		}
		else if (localidad == 8)
		{
			localidad7();
			localidad = 7;
		}
		else if (localidad == 9)
		{
			localidad8();
			localidad = 8;
		}
		else if (localidad == 10)
		{
			localidad9();
			localidad = 9;
		}
		else if (localidad == 11)
		{
			localidad10();
			localidad = 10;
		}
		else if (localidad == 12)
		{
			localidad11();
			localidad = 11;
		}
		else if (localidad == 13)
		{
			localidad12();
			localidad = 12;
		}
		else if (localidad == 14)
		{
			localidad13();
			localidad = 13;
		}
		else if (localidad == 15)
		{
			localidad14();
			localidad = 14;
		}
		else if (localidad == 16)
		{
			localidad15();
			localidad = 15;
		}
		else if (localidad == 17)
		{
			localidad16();
			localidad = 16;
		}
		else if (localidad == 18)
		{
			localidad17();
			localidad = 17;
		}
		else if (localidad == 19)
		{
			localidad18();
			localidad = 18;
		}
		else if (localidad == 20)
		{
			localidad19();
			localidad = 19;
		}
		else if (localidad == 21)
		{
			localidad20();
			localidad = 20;
		}
		else if (localidad == 22)
		{
			localidad21();
			localidad = 21;
		}
		else if (localidad == 23)
		{
			localidad22();
			localidad = 22;
		}
		else if (localidad == 24)
		{
			localidad23();
			localidad = 23;
		}
		else if (localidad == 25)
		{
			localidad24();
			localidad = 24;
		}
		else if (localidad == 26)
		{
			localidad25();
			localidad = 25;
		}
		else if (localidad == 27)
		{
			localidad26();
			localidad = 26;
		}
		else if (localidad == 28)
		{
			localidad27();
			localidad = 27;
		}
		else if (localidad == 29)
		{
			localidad28();
			localidad = 28;
		}
	}
	/*public void avanzar1()
	{
		if (posicion == 1)
		{
			localidad2();
			posicion = 2;
		}
		else if (posicion == 2)
		{
			localidad3();
			posicion = 3;
		}
		else if (posicion == 3)
		{
			localidad4();
			posicion = 4;
		}
		else if (posicion == 4)
		{
			localidad5();
			posicion = 5;
		}
		else if (posicion == 5)
		{
			localidad6();
			posicion = 6;
		}
		else if (posicion == 6)
		{
			localidad7();
			posicion = 7;
		}
		else if (posicion == 7)
		{
			localidad8();
			posicion = 8;
		}
		else if (posicion == 8)
		{
			localidad9();
			posicion = 9;
		}
		else if (posicion == 9)
		{
			localidad10();
			posicion = 10;
		}
		else if (posicion == 10)
		{
			localidad11();
			posicion = 11;
		}
		else if (posicion == 11)
		{
			localidad12();
			posicion = 12;
		}
		else if (posicion == 12)
		{
			localidad13();
			posicion = 13;
		}
		else if (posicion == 13)
		{
			localidad14();
			posicion = 14;
		}
		else if (posicion == 14)
		{
			localidad15();
			posicion = 15;
		}
		else if (posicion == 15)
		{
			localidad16();
			posicion = 16;
		}
		else if (posicion == 16)
		{
			localidad17();
			posicion = 17;
		}
		else if (posicion == 17)
		{
			localidad18();
			posicion = 18;
		}
		else if (posicion == 18)
		{
			localidad19();
			posicion = 19;
		}
		else if (posicion == 19)
		{
			localidad20();
			posicion = 20;
		}
		else if (posicion == 20)
		{
			localidad21();
			posicion = 21;
		}
		else if (posicion == 21)
		{
			localidad22();
			posicion = 22;
		}
		else if (posicion == 22)
		{
			localidad23();
			posicion = 23;
		}
		else if (posicion == 23)
		{
			localidad24();
			posicion = 24;
		}
		else if (posicion == 24)
		{
			localidad25();
			posicion = 25;
		}
		else if (posicion == 25)
		{
			localidad26();
			posicion = 26;
		}
		else if (posicion == 26)
		{
			localidad27();
			posicion = 27;
		}
		else if (posicion == 27)
		{
			localidad28();
			posicion = 28;
		}
		else if (posicion == 28)
		{
			localidad29();
			posicion = 29;
		}
		else if (posicion == 29)
		{
			localidad1();
			posicion = 1;
		}
	}
	public void retroceder1()
	{
		if (posicion == 1)
		{
			localidad29();
			posicion = 29;
		}
		else if (posicion == 2)
		{
			localidad1();
			posicion = 1;
		}
		else if (posicion == 3)
		{
			localidad2();
			posicion = 2;
		}
		else if (localidad == 4)
		{
			localidad3();
			posicion = 3;
		}
		else if (posicion == 5)
		{
			localidad4();
			posicion = 4;
		}
		else if (posicion == 6)
		{
			localidad5();
			posicion = 5;
		}
		else if (posicion == 7)
		{
			localidad6();
			posicion = 6;
		}
		else if (posicion == 8)
		{
			localidad7();
			posicion = 7;
		}
		else if (posicion == 9)
		{
			localidad8();
			posicion = 8;
		}
		else if (posicion == 10)
		{
			localidad9();
			posicion = 9;
		}
		else if (posicion == 11)
		{
			localidad10();
			posicion = 10;
		}
		else if (posicion == 12)
		{
			localidad11();
			posicion = 11;
		}
		else if (posicion == 13)
		{
			localidad12();
			posicion = 12;
		}
		else if (posicion == 14)
		{
			localidad13();
			posicion = 13;
		}
		else if (posicion == 15)
		{
			localidad14();
			posicion = 14;
		}
		else if (posicion == 16)
		{
			localidad15();
			posicion = 15;
		}
		else if (posicion == 17)
		{
			localidad16();
			posicion = 16;
		}
		else if (posicion == 18)
		{
			localidad17();
			posicion = 17;
		}
		else if (posicion == 19)
		{
			localidad18();
			posicion = 18;
		}
		else if (posicion == 20)
		{
			localidad19();
			posicion = 19;
		}
		else if (posicion == 21)
		{
			localidad20();
			posicion = 20;
		}
		else if (posicion == 22)
		{
			localidad21();
			posicion = 21;
		}
		else if (posicion == 23)
		{
			localidad22();
			posicion = 22;
		}
		else if (posicion == 24)
		{
			localidad23();
			posicion = 23;
		}
		else if (posicion == 25)
		{
			localidad24();
			posicion = 24;
		}
		else if (posicion == 26)
		{
			localidad25();
			posicion = 25;
		}
		else if (posicion == 27)
		{
			localidad26();
			posicion = 26;
		}
		else if (posicion == 28)
		{
			localidad27();
			posicion = 27;
		}
		else if (posicion == 29)
		{
			localidad28();
			posicion = 28;
		}
	}*/
	public void localidad1()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = -10.61f;
		DesZ = 0.09f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 2.19f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad2()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = -6.61f;
		DesZ = 0.0f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 0.0f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad3()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = -2.61f;
		DesZ = 0.0f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 0.0f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad4()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = 1.39f;
		DesZ = 0.0f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 0.0f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad5()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = 5.39f;
		DesZ = 0.0f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 0.0f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad6()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = 9.39f;
		DesZ = 0.0f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 0.0f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad7()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = 13.39f;
		DesZ = 0.0f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 0.0f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad8()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = 17.39f;
		DesZ = -0.06f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 1.57f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad9()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = 21.46f;
		DesZ = 0.67f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = -22.15f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad10()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = 24.89f;
		DesZ = 3.05f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = -48.0f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad11()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = 27.11f;
		DesZ = 6.5f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = -70.28f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad12()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = 27.72f;
		DesZ = 10.68f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = -93.76f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad13()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = 26.54f;
		DesZ = 14.68f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = -119.03f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad14()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = 23.8f;
		DesZ = 17.83f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = -144.29f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad15()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = 20.02f;
		DesZ = 19.62f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = -164.0f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad16()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = 16.0f;
		DesZ = 20.22f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 180.43f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad17()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = 12.0f;
		DesZ = 20.24f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 180.0f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad18()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = 8.0f;
		DesZ = 20.24f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 180.0f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad19()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = 4.0f;
		DesZ = 20.24f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 180.0f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad20()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = 0.0f;
		DesZ = 20.24f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 180.0f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad21()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = -4.0f;
		DesZ = 20.24f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 180.41f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad22()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = -8.0f;
		DesZ = 20.19f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 180.47f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad23()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = -12.0f;
		DesZ = 19.88f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 167.14f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad24()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = -15.8f;
		DesZ = 18.41f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 150.18f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad25()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = -18.79f;
		DesZ = 15.43f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 119.94f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad26()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = -20.19f;
		DesZ = 11.55f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 98.72f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad27()
	{
		//System.out.println("localidad1\n \n \n");
			
		DesX = -19.9f;
		DesZ = 7.37f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 72.0f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad28()
	{
		//System.out.println("localidad28\n \n \n");
			
		DesX = -17.94f;
		DesZ = 3.66f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 49.68f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
	public void localidad29()
	{
		//System.out.println("localidad29\n \n \n");
			
		DesX = -14.77f;
		DesZ = 1.14f;

		trans.setTranslation(new Vector3f((DesX-desX),0.0f,(DesZ-desZ)));
		rot.mul(trans);
		rotacion.setTransform(rot);

		Gy = 24.2f;

		trans1.rotY((Gy-gY)*Math.PI/180);
		rot1.mul(trans1);
		rotacion1.setTransform(rot1);

		gY = Gy;

		desX = DesX;
		desZ = DesZ;
	}
}