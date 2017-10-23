package com.rbot.experimentalenviroment.body.movement;

import com.sun.j3d.loaders.Scene;
import ncsa.j3d.loaders.ModelLoader;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;
import java.io.FileNotFoundException;

public class PiezaOruga extends TransformGroup {
    public PiezaOruga() {
        this.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        this.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        TransformGroup tg = new TransformGroup();
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        Transform3D trans = new Transform3D();
        Transform3D trans1 = new Transform3D();
        Transform3D utility = new Transform3D();
        trans.setTranslation(new Vector3f(-0.04f, -0.14f, 0.0f));
        utility.mul(trans);

        trans1.rotY((2.19) * Math.PI / 180);
        utility.mul(trans1);

        tg.setTransform(utility);

        tg.addChild(createSceneGraph());
        this.addChild(tg);

    }

    public BranchGroup createSceneGraph() {
        ModelLoader loader = new ModelLoader();
        Scene s;
        try {
            s = loader.load("piezas/Pieza de oruga Pintada.3ds");
            return s.getSceneGroup();
        } catch (FileNotFoundException e) {
            System.out.println("No encuentro el archivo");
            return null;
        }
    }
}