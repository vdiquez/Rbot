package com.rbot.body.movement;

import ncsa.j3d.loaders.ModelLoader;

import javax.media.j3d.*;
import java.io.*;

import com.sun.j3d.loaders.*;

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