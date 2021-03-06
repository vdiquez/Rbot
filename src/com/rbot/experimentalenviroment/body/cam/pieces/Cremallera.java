package com.rbot.experimentalenviroment.body.cam.pieces;

import com.sun.j3d.loaders.Scene;
import ncsa.j3d.loaders.ModelLoader;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;
import java.io.FileNotFoundException;

public class Cremallera extends BranchGroup {
    Camara cm;
    TransformGroup tg;
    Transform3D trans, utility, utility1;
    private double refZ;
    private float refZ1;

    public Cremallera() {
        cm = new Camara();
        refZ = 0.0;
        this.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        this.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        BranchGroup scene = CargarBase();

        tg = new TransformGroup();
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        trans = new Transform3D();
        utility = new Transform3D();
        trans.setTranslation(new Vector3f(0.0f, 0.0f, 17.0f));
        utility.mul(trans);
        tg.setTransform(utility);

        utility1 = new Transform3D();
        utility1.rotZ(18 * Math.PI / 180);
        utility.mul(utility1);
        tg.setTransform(utility);

        tg.addChild(scene);

        tg.addChild(cm);

        this.addChild(tg);
    }

    public BranchGroup CargarBase() {
        ModelLoader loader = new ModelLoader();
        Scene s;
        try {
            s = loader.load("piezas/Cremallera final.3ds");
            return s.getSceneGroup();
        } catch (FileNotFoundException e) {
            System.out.println("No encuentro el archivo");
            return null;
        }
    }

    public void rotarEjeZ(float DezZ) {
        trans.setTranslation(new Vector3f(0.0f, 0.0f, (DezZ - refZ1)));
        utility.mul(trans);
        tg.setTransform(utility);
        refZ1 = DezZ;
    }

    public Camara getCamara() {
        return cm;
    }
}