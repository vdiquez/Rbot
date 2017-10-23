package com.rbot.experimentalenviroment.body.movement;

import com.sun.j3d.loaders.Scene;
import ncsa.j3d.loaders.ModelLoader;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.TransformGroup;
import java.io.FileNotFoundException;

public class Rueda extends BranchGroup {
    public Rueda() {
        this.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        this.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
        this.addChild(createSceneGraph());
        this.compile();
    }

    public BranchGroup createSceneGraph() {
        ModelLoader loader = new ModelLoader();
        Scene s;
        try {
            s = loader.load("piezas/Rueda.3ds");
            return s.getSceneGroup();
        } catch (FileNotFoundException e) {
            System.out.println("No encuentro el archivo");
            return null;
        }
    }
}