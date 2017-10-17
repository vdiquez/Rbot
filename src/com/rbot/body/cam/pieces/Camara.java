package com.rbot.body.cam.pieces;

import ncsa.j3d.loaders.ModelLoader;

import javax.media.j3d.*;
import javax.vecmath.*;
import java.io.*;

import com.sun.j3d.loaders.*;

public class Camara extends BranchGroup {
    Transform3D trans, trans1, utility, utility1, utility2;
    TransformGroup tg;
    private double refY;

    public Camara() {
        refY = 0;
        BranchGroup scene = cargarBase();

        tg = new TransformGroup();
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        trans = new Transform3D();
        trans1 = new Transform3D();
        utility = new Transform3D();
        trans.setTranslation(new Vector3f(0.0f, 0.0f, 1.75f));
        utility.mul(trans);
        tg.setTransform(utility);

        utility1 = new Transform3D();
        utility1.rotX(90 * Math.PI / 180);
        utility.mul(utility1);
        tg.setTransform(utility);

        utility2 = new Transform3D();
        utility2.rotY(-90 * Math.PI / 180);
        utility.mul(utility2);
        tg.setTransform(utility);

        tg.addChild(scene);


        this.addChild(tg);
    }

    public BranchGroup cargarBase() {
        ModelLoader loader = new ModelLoader();
        Scene s;
        try {
            s = loader.load("piezas/Camara1.3ds");
            return s.getSceneGroup();
        } catch (FileNotFoundException e) {
            System.out.println("No encuentro el archivo");
            return null;
        }
    }

    public void rotarEjeY(double giroEjeY) {
        trans1.rotZ((giroEjeY - refY) * Math.PI / 180.0d);
        utility.mul(trans1);
        tg.setTransform(utility);
        refY = giroEjeY;
    }
}