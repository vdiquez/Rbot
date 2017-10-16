package com.rbot.unasigned;

import ncsa.j3d.loaders.ModelLoader;

import javax.media.j3d.*;
import java.io.*;

import com.sun.j3d.loaders.*;

import javax.vecmath.*;

public class EngranajeElevador extends BranchGroup {

    Transform3D utility1;
    Transform3D utility;
    TransformGroup tg;
    float girY1;

    public EngranajeElevador() {
        tg = new TransformGroup();
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        Transform3D trans = new Transform3D();
        Transform3D trans1 = new Transform3D();
        Transform3D trans2 = new Transform3D();
        utility = new Transform3D();
        utility1 = new Transform3D();
        Transform3D utility2 = new Transform3D();

        trans1.rotY((90) * Math.PI / 180);
        utility.mul(trans1);

        trans2.rotX((-20) * Math.PI / 180);
        utility.mul(trans2);

        trans.setTranslation(new Vector3f(-11.9f, -3.75f, -0.67f));
        utility.mul(trans);

        tg.setTransform(utility);

        tg.addChild(createSceneGraph2());

        this.addChild(tg);
        this.compile();
    }

    public BranchGroup createSceneGraph2() {
        ModelLoader loader = new ModelLoader();
        Scene s = null;
        try {
            s = loader.load("piezas/Engranaje Elevador.3ds");
            return s.getSceneGroup();
        } catch (FileNotFoundException e) {
            System.out.println("No encuentro el archivo");
            return null;
        }
    }

    public void girarEjeY(float GirY) {
        utility1.rotZ((18 * (GirY - girY1)) * Math.PI / 180);
        utility.mul(utility1);
        tg.setTransform(utility);
        girY1 = GirY;
    }
}