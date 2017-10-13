import ncsa.j3d.loaders.ModelLoader;
import javax.media.j3d.*;
import java.io.*;
import com.sun.j3d.loaders.*;
import javax.vecmath.*;

public class PiezaOruga extends TransformGroup
{	
	public PiezaOruga()
	{
		this.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		this.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		TransformGroup tg = new TransformGroup();
		tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		Transform3D trans = new Transform3D();
		Transform3D trans1 = new Transform3D();
		Transform3D utility = new Transform3D();
		trans.setTranslation(new Vector3f(-0.04f,-0.14f,0.0f));
		utility.mul(trans);

		trans1.rotY((2.19)*Math.PI/180);
		utility.mul(trans1);

		tg.setTransform(utility);

		tg.addChild(createSceneGraph());
		this.addChild(tg);

	}
	
	public BranchGroup createSceneGraph()
	{
		ModelLoader loader = new ModelLoader();
		Scene s = null;
		try
		{
			s =  loader.load("piezas/Pieza de oruga Pintada.3ds");
			System.out.println("Tengo Problemas\n \n \n");
			return s.getSceneGroup();
		}
			catch(FileNotFoundException e)
		{
			System.out.println("No encuentro el archivo");
			return null;
		}
	}	
}