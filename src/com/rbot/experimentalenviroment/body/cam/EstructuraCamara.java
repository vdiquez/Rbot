package com.rbot.experimentalenviroment.body.cam;

import com.rbot.experimentalenviroment.body.cam.pieces.Cremallera;
import com.rbot.experimentalenviroment.body.cam.pieces.EngranajeElevador;
import com.sun.j3d.loaders.Scene;
import ncsa.j3d.loaders.ModelLoader;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;
import java.io.FileNotFoundException;

public class EstructuraCamara extends BranchGroup {
    Transform3D trans, trans1, trans2, trans3;
    TransformGroup tg;
    private double refX;
    Cremallera cll;
    EngranajeElevador ee;

    public EstructuraCamara() {

        tg = new TransformGroup();
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        cll = new Cremallera();
        ee = new EngranajeElevador();
        BranchGroup scene = CargarBase();

        trans = new Transform3D();
        trans1 = new Transform3D();
        trans2 = new Transform3D();
        trans3 = new Transform3D();

        trans2.setTranslation(new Vector3f(-7.27f, 0.07f, -0.5f));
        trans1.mul(trans2);
        tg.setTransform(trans1);

        trans3.rotZ(-110 * Math.PI / 180);
        trans1.mul(trans3);
        tg.setTransform(trans1);

        tg.addChild(cll);
        tg.addChild(ee);
        tg.addChild(scene);
        this.addChild(tg);

    }

    public BranchGroup CargarBase() {
        ModelLoader loader = new ModelLoader();
        Scene s;
        try {
            s = loader.load("piezas/Base final.3ds");
            return s.getSceneGroup();
        } catch (FileNotFoundException e) {
            System.out.println("No encuentro el archivo");
            return null;
        }
    }

    public void rotarEjeZ(float giroEjeX) {
        trans.rotZ((giroEjeX - refX) * Math.PI / 180.0d);
        trans1.mul(trans);
        tg.setTransform(trans1);
        refX = giroEjeX;
    }

    public Cremallera getCremallera() {
        return cll;
    }

    public EngranajeElevador dameEngranajeElevador() {
        return ee;
    }
}