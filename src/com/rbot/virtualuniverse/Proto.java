package com.rbot.virtualuniverse;

import java.awt.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import javax.media.j3d.Locale;

import com.rbot.body.Cuerpo;
import com.rbot.virtualenviroment.Robot;
import com.sun.j3d.utils.universe.*;

public class Proto
	{
		Cuerpo cup;
		Robot rbt;
		private Canvas3D fondo3D,canvas1,canvas2,canvas3;
		private VirtualUniverse universoV;
		private Locale local;
		private View vista,vista1,vista2,vista3;
		private BranchGroup BG1;
		private BranchGroup ramaContenido; //Nodo raiz de la rama volumen
		private BranchGroup ramaGrafica; //Nodo raiz de la rama de visualizacion
		private TransformGroup tgGrafico,tgGrafico40,tgGrafico1,tgGrafico2,
			tgGrafico3,tgGrafico4,tgGrafico5,tgGrafico6,tgGrafico7,tgGrafico70,tgGrafico8,tgGrafico9; // nodo de transformacion unido al nodoRaizVista
		private TransformGroup tgContenido; //nodo de transformacion unido al nodoRaizVolumen
		private Point3d foco;
		Transform3D puntoVista3D = new Transform3D();
		Transform3D puntoVista3D1 = new Transform3D();
		Transform3D puntoVista3D2 = new Transform3D();
		Transform3D puntoVista3D3 = new Transform3D();

		TransformGroup sistVista = new TransformGroup();
		Transform3D util1,util2,util3,util4,util5,util6,util7,util8,util9,util10,util11,util12,util13,util14,util15,util16,util17,util18,
			util19,util20,util21,util22,util23,util24,util25,util26,util27,util28,util29,util30;
		private double refX,refY,ref;
		private float refZ,refD,alejarAcercarZ,refAva,alejarAcercarZCanvas3,refAvaCanvas3,refIZCanvas3,
			derCanvas3;
		double der = 0.1;
		double refIZ = 0;
		public Proto()
		{
			alejarAcercarZ = 1.0f;
			refAva = 0.0f;
			
			//Rama Grafica
			GraphicsConfiguration gc = SimpleUniverse.getPreferredConfiguration();
			fondo3D = new Canvas3D(gc);

			canvas1 = new Canvas3D(gc);

			canvas2 = new Canvas3D(gc);

			canvas3 = new Canvas3D(gc);

			this.universoV =new VirtualUniverse();
			this.local = new Locale(this.universoV);

			this.ramaGrafica = new BranchGroup();
			ramaGrafica.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
			ramaGrafica.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
			puntoVista3D.set(new Vector3f(0.0f, 0.0f, 0.0f));

			this.tgGrafico = new TransformGroup(puntoVista3D);
			tgGrafico.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
			tgGrafico.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

			this.tgGrafico40 = new TransformGroup();
			tgGrafico40.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
			tgGrafico40.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
			

			/////////////////////////// ISOMETRICO ///////////////////////////////////	
			util17 = new Transform3D();
			util18 = new Transform3D();
			util19 = new Transform3D();
			util20 = new Transform3D();
			util21 = new Transform3D();
			util22 = new Transform3D();

			util20.setTranslation(new Vector3f(580.0f, -695.0f, 300.0f));
			util18.mul(util20);
			
			util17.rotZ(45*Math.PI/180);
			util18.mul(util17);
			util19.rotX(60*Math.PI/180);
			util18.mul(util19);
			/*util22.rotX(-45*Math.PI/180);
			util18.mul(util22);*/

			tgGrafico.setTransform(util18);


			this.tgGrafico40.addChild(this.tgGrafico);
			this.ramaGrafica.addChild(this.tgGrafico40);
	

			ViewPlatform plataformaGrafica = new ViewPlatform();
			this.tgGrafico.addChild(plataformaGrafica);

			this.vista = new View();
			
			PhysicalBody cuerpoFisico  = new PhysicalBody();
			PhysicalEnvironment ambienteFisico = new PhysicalEnvironment();
			
			this.vista.attachViewPlatform(plataformaGrafica);

			this.vista.setBackClipDistance(1000.0);
			this.vista.setPhysicalBody(cuerpoFisico);
			this.vista.setPhysicalEnvironment(ambienteFisico);
			
			vista.addCanvas3D(fondo3D);

			//Rama de Contenido
			this.ramaContenido = new BranchGroup();
			ramaContenido.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
			ramaContenido.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
			
			this.tgContenido = new TransformGroup();
			tgContenido.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
			tgContenido.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

			BoundingSphere bounds = new BoundingSphere(new Point3d(0, 0, 0), Double.MAX_VALUE);
			Background backg = new Background(0.28f, 0.5f, 0.75f);
			backg.setApplicationBounds(bounds);
			ramaContenido.addChild(backg);

				////////////////////////////////////////Construccion de Rama Grafica 2

				//Vista Superior

		puntoVista3D1.set(new Vector3f(190.0f, -180f, 1000.0f));

		this.tgGrafico1 = new TransformGroup(puntoVista3D1);
		tgGrafico1.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		tgGrafico1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

		this.ramaGrafica.addChild(this.tgGrafico1);

		ViewPlatform plataformaGrafica1 = new ViewPlatform();
		this.tgGrafico1.addChild(plataformaGrafica1);

		this.vista1 = new View();

		PhysicalBody cuerpoFisico1  = new PhysicalBody();
		PhysicalEnvironment ambienteFisico1 = new PhysicalEnvironment();

		this.vista1.attachViewPlatform(plataformaGrafica1);

		this.vista1.setBackClipDistance(1000.0);
		this.vista1.setPhysicalBody(cuerpoFisico1);
		this.vista1.setPhysicalEnvironment(ambienteFisico1);

		vista1.addCanvas3D(canvas1);
		///////////////////////////////////////Fin de Rama Grafica 2

		////////////////////////////////////////Construccion de Rama Grafica 3

		puntoVista3D2.set(new Vector3f(0.0f, 0.0f, 0.0f));

		this.sistVista = new TransformGroup();
		sistVista.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		sistVista.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

		this.tgGrafico2 = new TransformGroup();
		tgGrafico2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		tgGrafico2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

		this.tgGrafico3 = new TransformGroup();
		tgGrafico3.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		tgGrafico3.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

		this.tgGrafico4 = new TransformGroup();
		tgGrafico4.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		tgGrafico4.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

		this.tgGrafico5 = new TransformGroup(puntoVista3D2);
		tgGrafico5.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		tgGrafico5.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

		this.tgGrafico6 = new TransformGroup();
		tgGrafico6.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		tgGrafico6.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		this.ramaGrafica.addChild(this.tgGrafico6);

		util1 = new Transform3D();
		util2 = new Transform3D();
		util3 = new Transform3D();
		util4 = new Transform3D();
		util5 = new Transform3D();
		util6 = new Transform3D();
		util7 = new Transform3D();
		util8 = new Transform3D();
		util9 = new Transform3D();
		util10 = new Transform3D();
		util11 = new Transform3D();
		util12 = new Transform3D();
		util13 = new Transform3D();
		util14 = new Transform3D();

		util1.setTranslation(new Vector3f(-7.27f, 0.125f, 18.2f));

		util2.rotX(90*Math.PI/180);
		util1.mul(util2);
		util3.rotY(90*Math.PI/180);
		util1.mul(util3);
		sistVista.setTransform(util1);

		util10.setTranslation(new Vector3f(0.0f, 4.9f, -1.2f));
		util11.mul(util10);
		tgGrafico5.setTransform(util11);

		ViewPlatform plataformaGrafica2 = new ViewPlatform();
		this.tgGrafico5.addChild(plataformaGrafica2);

		this.vista2 = new View();

		PhysicalBody cuerpoFisico2  = new PhysicalBody();
		PhysicalEnvironment ambienteFisico2 = new PhysicalEnvironment();

		this.vista2.attachViewPlatform(plataformaGrafica2);

		this.vista2.setBackClipDistance(1000.0);
		this.vista2.setPhysicalBody(cuerpoFisico2);
		this.vista2.setPhysicalEnvironment(ambienteFisico2);

		vista2.addCanvas3D(canvas2);

		this.tgGrafico4.addChild(this.tgGrafico5);
		this.tgGrafico3.addChild(this.tgGrafico4);
		this.tgGrafico2.addChild(this.tgGrafico3);
		this.sistVista.addChild(this.tgGrafico2);
		this.tgGrafico6.addChild(this.sistVista);
		
		///////////////////////////////////////Fin de Rama Gr�fica 3

		///////////////////////////////////////Construcci�n de Rama Gr�fica de Contenido 4

		puntoVista3D3.set(new Vector3f(0.0f,0.0f,0.0f));

		tgGrafico7 = new TransformGroup();
		tgGrafico7.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		tgGrafico7.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

		tgGrafico70 = new TransformGroup();
		tgGrafico70.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		tgGrafico70.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);		

		tgGrafico8 = new TransformGroup(puntoVista3D3);
		tgGrafico8.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		tgGrafico8.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

		

		util23 = new Transform3D();
		util24 = new Transform3D();
		util25 = new Transform3D();
		util26 = new Transform3D();
		util27 = new Transform3D();
		util28 = new Transform3D();
		util29 = new Transform3D();
		util30 = new Transform3D();

		util23.setTranslation(new Vector3f( -70f , 0.0f, 70f));
		util24.mul(util23);
		//tgGrafico8.setTransform(util24);

		util25.rotZ(-90*Math.PI/180);
		util24.mul(util25);
		util27.rotX(45*Math.PI/180);
		util24.mul(util27);
		tgGrafico8.setTransform(util24);



		
		
	

		ViewPlatform plataformaGrafica3 = new ViewPlatform();
		tgGrafico8.addChild(plataformaGrafica3);

		vista3 = new View();

		PhysicalBody cuerpoFisico3  = new PhysicalBody();
		PhysicalEnvironment ambienteFisico3 = new PhysicalEnvironment();

		vista3.attachViewPlatform(plataformaGrafica3);

		vista3.setBackClipDistance(1000.0);
		vista3.setPhysicalBody(cuerpoFisico3);
		vista3.setPhysicalEnvironment(ambienteFisico3);

		vista3.addCanvas3D(canvas3);

		tgGrafico7.addChild(tgGrafico8);
		ramaGrafica.addChild(tgGrafico7);

		


		/////////////////////////////////////////////////////////////////////Fin de Rama Gr�fica de Contenido 4

			//////////////////////////////////////////////////

		/*	MouseZoom lupa = new MouseZoom();
			lupa.setTransformGroup(tgContenido);
			lupa.setSchedulingBounds(bounds);
			ramaContenido.addChild(lupa);

			MouseTranslate mover = new MouseTranslate();
			mover.setTransformGroup(tgContenido);
			mover.setSchedulingBounds(bounds);
			ramaContenido.addChild(mover);

			MouseRotate rotar = new MouseRotate();
			rotar.setTransformGroup(tgContenido);
			rotar.setSchedulingBounds(bounds);
			ramaContenido.addChild(rotar);*/

			//////////////////////////////////////////////////////


			DirectionalLight lightD1 = new DirectionalLight(new Color3f(0.3f, 0.3f, 0.3f),new Vector3f(700.0f, 500.0f, 900.0f));
			lightD1.setInfluencingBounds(bounds);
			ramaContenido.addChild(lightD1);


			DirectionalLight lightD2 = new DirectionalLight(new Color3f(0.3f, 0.3f, 0.3f),new Vector3f(700.0f, -500.0f, -900.0f));
			lightD2.setInfluencingBounds(bounds);
			ramaContenido.addChild(lightD2);


			DirectionalLight lightD3 = new DirectionalLight(new Color3f(0.3f, 0.3f, 0.3f),new Vector3f(-700.0f, -500.0f, 900.0f));
			lightD3.setInfluencingBounds(bounds);
			ramaContenido.addChild(lightD3);


			DirectionalLight lightD4 = new DirectionalLight(new Color3f(0.3f, 0.3f, 0.3f),new Vector3f(-700.0f, 500.0f, -900.0f));
			lightD4.setInfluencingBounds(bounds);
			ramaContenido.addChild(lightD4);

			Color3f ambientColor = new Color3f(0.4f, 0.4f, 0.4f);
			AmbientLight ambientLightNode = new AmbientLight(ambientColor);
			ambientLightNode.setInfluencingBounds(bounds);
			ramaContenido.addChild(ambientLightNode);

			Color3f ambientColor2 = new Color3f(0.4f, 0.4f, 0.4f);
			AmbientLight ambientLightNode2 = new AmbientLight(ambientColor2);
			ambientLightNode.setInfluencingBounds(bounds);
			ramaContenido.addChild(ambientLightNode2);

			Color3f ambientColor3 = new Color3f(0.3f, 0.3f, 0.3f);
			AmbientLight ambientLightNode3 = new AmbientLight(ambientColor3);
			ambientLightNode.setInfluencingBounds(bounds);
			ramaContenido.addChild(ambientLightNode3);

			Color3f ambientColor4 = new Color3f(0.4f, 0.4f, 0.4f);
			AmbientLight ambientLightNode4 = new AmbientLight(ambientColor4);
			ambientLightNode.setInfluencingBounds(bounds);
			ramaContenido.addChild(ambientLightNode4);

			/////////////////////////////////////////////////////

			rbt = new Robot();
			this.tgContenido.addChild(rbt);

			cup = new Cuerpo();
			this.tgContenido.addChild(cup);			

			/////////////////////////////////////////////////////////
			this.ramaContenido.addChild(this.tgContenido);


			this.local.addBranchGraph(ramaGrafica);
			this.local.addBranchGraph(ramaContenido);

			Color3f colorLuz = new Color3f(1.0f,1.0f,1.0f);

		}
		public Canvas3D getCanvas3D()
		{
			return fondo3D;
		}

		public Canvas3D getCanvas()
		{
			return canvas1;
		}

		public Canvas3D dameCanvas()
		{
			return canvas2;
		}

		public Canvas3D dameCanvas3()
		{
			return canvas3;
		}

		public View getView()
		{
			return vista;
		}
		public Cuerpo getCuerpo()
		{
			return cup;
		}
		public void subirBajar(float subirBajarY)
		{	
	
			util4.setTranslation(new Vector3f(0.0f,(subirBajarY-refZ),0.0f));
			util5.mul(util4);
			tgGrafico2.setTransform(util5);
			refZ = subirBajarY;
		}
		public void girar(double giroEjeY)
		{	
		
			util6.rotY((giroEjeY-refY)*Math.PI/180);
			util7.mul(util6);
			tgGrafico3.setTransform(util7);
			refY = giroEjeY;
		}
		public void elevar(double elevarX)
		{	
			util8.rotX((elevarX-refX)*Math.PI/180);
			util9.mul(util8);
			tgGrafico4.setTransform(util9);	
			refX = elevarX;
		}
		public void avanzar()
		{	
			util12.setTranslation(new Vector3f(alejarAcercarZ-refAva,0.0f,0.0f));
			util13.mul(util12);
			tgGrafico6.setTransform(util13);
			refAva = alejarAcercarZ;
			alejarAcercarZ -= 4;
		}
		public void retroceder()
		{	
			util12.setTranslation(new Vector3f(alejarAcercarZ-refAva,0.0f,0.0f));
			util13.mul(util12);
			tgGrafico6.setTransform(util13);
			refAva = alejarAcercarZ;
			alejarAcercarZ += 4;
		}
		public void derecha()
		{	
			util14.rotZ((der-refIZ)*Math.PI/180);
			util13.mul(util14);
			tgGrafico6.setTransform(util13);
			refIZ = der;
			der -= 4.0f;
		}
		public void izquierda()
		{	
			util14.rotZ((der-refIZ)*Math.PI/180);
			util13.mul(util14);
			tgGrafico6.setTransform(util13);
			refIZ = der;
			der += 4.0f;
		}
		public void avanzarCanvas3()
		{	
			util28.setTranslation(new Vector3f(alejarAcercarZCanvas3-refAvaCanvas3,0.0f,0.0f));
			util30.mul(util28);
			tgGrafico7.setTransform(util30);
			refAvaCanvas3 = alejarAcercarZCanvas3;
			alejarAcercarZCanvas3 -= 4;
		}
		public void retrocederCanvas3()
		{	
			util29.setTranslation(new Vector3f(alejarAcercarZCanvas3-refAvaCanvas3,0.0f,0.0f));
			util30.mul(util29);
			tgGrafico7.setTransform(util30);
			refAvaCanvas3 = alejarAcercarZCanvas3;
			alejarAcercarZCanvas3 += 4;
		}
		public void derechaCanvas3()
		{	
			util26.rotZ((derCanvas3-refIZCanvas3)*Math.PI/180);
			util30.mul(util26);
			tgGrafico7.setTransform(util30);
			refIZCanvas3 = derCanvas3;
			derCanvas3 -= 4.0f;
		}
		public void izquierdaCanvas3()
		{	
			util26.rotZ((derCanvas3-refIZCanvas3)*Math.PI/180);
			util30.mul(util26);
			tgGrafico7.setTransform(util30);
			refIZCanvas3 = derCanvas3;
			derCanvas3 += 4.0f;
		}
}