package com.rbot.virtualenviroment;

import com.sun.j3d.loaders.Scene;
import ncsa.j3d.loaders.ModelLoader;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;
import java.io.FileNotFoundException;

public class Robot extends BranchGroup {
    public Robot() {
        TransformGroup tg = new TransformGroup();
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        tg.addChild(createSceneGraph());

        Transform3D trans = new Transform3D();
        Transform3D utility = new Transform3D();
        trans.setTranslation(new Vector3f(100.0f, 0.0f, -10.0f));
        //trans.setTranslation(new Vector3f(0.0f,0.0f,0.0f));
        utility.mul(trans);
        tg.setTransform(utility);

//		this.addChild(createSceneGraph2());
        this.addChild(tg);
        this.compile();
    }

    public BranchGroup createSceneGraph() {
        ModelLoader loader = new ModelLoader();
        Scene s;
        try {
            s = loader.load("piezas/Cuarto.3DS");
            return s.getSceneGroup();
        } catch (FileNotFoundException e)//caja de color.3ds
        {
            System.out.println("No encuentro el archivo");
            return null;
        }
    }
}