import ncsa.j3d.loaders.ModelLoader;

import javax.media.j3d.*;
import java.io.*;

import com.sun.j3d.loaders.*;

import javax.vecmath.*;

public class MoverBien extends BranchGroup {

    private TransformGroup rotacion, rotacion1;
    private float desX, desZ, desY, gY, DesX, DesY, DesZ, Gy;
    Transform3D trans, trans1, rot, rot1;
    double localidad, posicion, pasoguardado;

    public MoverBien() {

        DesX = -10.61f;
        DesY = 0.35f;
        DesZ = 0.09f;
        Gy = 2.19f;
        desX = 0.0f;
        desY = 0.0f;
        desZ = 0.0f;
        gY = 0.0f;
        localidad = 1;
        pasoguardado = 0;
        posicion = 1;

        rotacion = new TransformGroup();
        rotacion.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        rotacion.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        rotacion1 = new TransformGroup();
        rotacion1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        rotacion1.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        rot = new Transform3D();
        rot1 = new Transform3D();
        trans = new Transform3D();
        trans1 = new Transform3D();

        BranchGroup pieza = CargarPieza();

        trans.setTranslation(new Vector3f((DesX - desX), (DesY - desY), (DesZ - desZ)));
        rot.mul(trans);
        rotacion.setTransform(rot);

        trans1.rotY((Gy - gY) * Math.PI / 180.0d);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        desX = DesX;
        desZ = DesZ;
        gY = Gy;

        rotacion1.addChild(pieza);

        rotacion.addChild(rotacion1);

        this.addChild(rotacion);
        this.compile();
    }

    public BranchGroup CargarPieza() {
        ModelLoader loader = new ModelLoader();
        Scene s = null;
        try {
            s = loader.load("piezas/Pieza1OrugaNegra.3ds");
            return s.getSceneGroup();
        } catch (FileNotFoundException e) {
            System.out.println("No encuentro el archivo");
            return null;
        }
    }

    public void opcion(double paso) {
        double mov = paso - pasoguardado;
        if (mov == 1) {
            mover();
            pasoguardado = paso;
        } else if (mov == -1) {
            girar();
            pasoguardado = paso;
        }
    }

    public void mover() {
        if (localidad == 1) {
            localidad28();
            localidad = 28;
        } else if (localidad == 28) {
            localidad29();
            localidad = 29;
        } else if (localidad == 29) {
            localidad1();
            localidad = 1;
        }
    }

    public void girar() {
        if (posicion == 1) {
            posicion28();
            posicion = 28;
        } else if (posicion == 28) {
            posicion29();
            posicion = 29;
        } else if (posicion == 29) {
            posicion1();
            posicion = 1;
        }
    }

    public void localidad1() {

        DesX = -10.61f;
        DesZ = 0.09f;

        trans.setTranslation(new Vector3f((DesX - desX), 0.0f, 0.0f));
        rot.mul(trans);
        rotacion.setTransform(rot);

        trans.setTranslation(new Vector3f(0.0f, 0.0f, (DesZ - desZ)));
        rot.mul(trans);
        rotacion.setTransform(rot);

        Gy = 2.19f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;

        desX = DesX;
        desZ = DesZ;
    }

    public void localidad28() {

        DesX = -17.94f;
        DesZ = 3.66f;

        trans.setTranslation(new Vector3f((DesX - desX), 0.0f, 0.0f));
        rot.mul(trans);
        rotacion.setTransform(rot);

        trans.setTranslation(new Vector3f(0.0f, 0.0f, (DesZ - desZ)));
        rot.mul(trans);
        rotacion.setTransform(rot);

        Gy = 49.68f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;

        desX = DesX;
        desZ = DesZ;
    }

    public void localidad29() {

        DesX = -14.77f;
        DesZ = 1.14f;

        trans.setTranslation(new Vector3f((DesX - desX), 0.0f, 0.0f));
        rot.mul(trans);
        rotacion.setTransform(rot);

        trans.setTranslation(new Vector3f(0.0f, 0.0f, (DesZ - desZ)));
        rot.mul(trans);
        rotacion.setTransform(rot);

        Gy = 24.2f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;

        desX = DesX;
        desZ = DesZ;
    }

    public void posicion1() {
    }

    public void posicion28() {
    }

    public void posicion29() {
    }
}