package com.rbot.experimentalenviroment.body.cam;

import com.sun.j3d.loaders.Scene;
import ncsa.j3d.loaders.ModelLoader;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;
import java.io.FileNotFoundException;

public class EngranajeBaseMotor extends BranchGroup {
    TransformGroup tg;
    Transform3D trans;
    Transform3D trans1;
    Transform3D utility;
    float girZ1;

    public EngranajeBaseMotor() {
        tg = new TransformGroup();
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        trans = new Transform3D();
        trans1 = new Transform3D();
        utility = new Transform3D();
        trans.setTranslation(new Vector3f(-7.26f, 5.19f, 0.29f));
        utility.mul(trans);
        tg.setTransform(utility);
        tg.addChild(createSceneGraph2());
        this.addChild(tg);
        this.compile();
    }

    public BranchGroup createSceneGraph2() {
        ModelLoader loader = new ModelLoader();
        Scene s;
        try {
            s = loader.load("piezas/Engranaje Base-Motor.3ds");
            return s.getSceneGroup();
        } catch (FileNotFoundException e) {
            System.out.println("No encuentro el archivo");
            return null;
        }
    }

    public void girarEjeZ(float GirZ) {
        trans1.rotZ((GirZ - girZ1) * Math.PI / 180);
        utility.mul(trans1);
        tg.setTransform(utility);
        girZ1 = GirZ;
    }
}