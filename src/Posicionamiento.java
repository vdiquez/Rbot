import ncsa.j3d.loaders.ModelLoader;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.io.*;
import com.sun.j3d.loaders.*;

public class Posicionamiento extends BranchGroup
{
		robot rbt;
		
		EstructuraCamara ecm;

		TransformGroup tg;
		Transform3D trans,utility,utility1;
		private double refX,refY,refZ;
		private float refX1,refY1,refZ1,girX1,girY1,girZ1;
		
		public Posicionamiento()
		{
			rbt = new robot();

			ecm = new EstructuraCamara();

			tg = new TransformGroup();
			tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
			tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

			trans = new Transform3D();
			utility = new Transform3D();
			utility1 = new Transform3D();

			//tg.addChild(rbt);
			//tg.addChild(ecm);

			this.addChild(tg);
		}
		public void trasladaEjeZ(float DezZ)
		{
			trans.setTranslation(new Vector3f(0.0f,0.0f,(DezZ-refZ1)));
			utility.mul(trans);
			tg.setTransform(utility);
			refZ1 = DezZ;
		}
		public void trasladaEjeY(float DezY)
		{
			trans.setTranslation(new Vector3f(0.0f,(DezY-refY1),0.0f));
			utility.mul(trans);
			tg.setTransform(utility);
			refY1 = DezY;
		}
		public void trasladaEjeX(float DezX)
		{
			trans.setTranslation(new Vector3f((DezX-refX1),0.0f,0.0f));
			utility.mul(trans);
			tg.setTransform(utility);
			refX1 = DezX;
		}
		public void girarEjeZ(float GirZ)
		{
			utility1.rotZ((GirZ-girZ1)*Math.PI/180);
			utility.mul(utility1);
			tg.setTransform(utility);
			girZ1 = GirZ;
		}
		public void girarEjeY(float GirY)
		{
			utility1.rotY((GirY-girY1)*Math.PI/180);
			utility.mul(utility1);
			tg.setTransform(utility);
			girY1 = GirY;
		}
		public void girarEjeX(float GirX)
		{
			utility1.rotX((GirX-girX1)*Math.PI/180);
			utility.mul(utility1);
			tg.setTransform(utility);
			girX1 = GirX;
		}
}