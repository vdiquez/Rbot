import ncsa.j3d.loaders.ModelLoader;

import javax.media.j3d.*;
import javax.vecmath.*;
import java.io.*;

import com.sun.j3d.loaders.*;

public class MovimientoRueda extends BranchGroup {
    Rueda rd;
    private TransformGroup rotacion, rotacion1;
    Transform3D trans, trans1, rot, rot1;
    private float DesX, DesY, DesZ, Gy, gY;
    double localidad, pasoguardado;

    public MovimientoRueda() {
        DesX = 19.16f;
        DesY = 25.65f;
        DesZ = 2.76f;
        Gy = 0.0f;
        gY = 0.0f;
        localidad = 1;
        pasoguardado = 0;

        rd = new Rueda();

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

        trans.setTranslation(new Vector3f(DesX, DesY, DesZ));
        rot.mul(trans);
        rotacion.setTransform(rot);

        trans1.rotY((Gy - gY) * Math.PI / 180.0d);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        Gy = -24.0f;

        gY = Gy;

        rotacion1.addChild(rd);

        rotacion.addChild(rotacion1);

        this.addChild(rotacion);
        this.compile();
    }

    public void movimiento(double paso) {
        double mov = paso - pasoguardado;

        if (mov == 1) {
            avanzar();
            pasoguardado = paso;
        } else if (mov == -1) {
            retroceder();
            pasoguardado = paso;
        }
    }

    public void avanzar() {
        if (localidad == 1) {
            localidad2();
            localidad = 2;
        } else if (localidad == 2) {
            localidad3();
            localidad = 3;
        } else if (localidad == 3) {
            localidad4();
            localidad = 4;
        } else if (localidad == 4) {
            localidad5();
            localidad = 5;
        } else if (localidad == 5) {
            localidad6();
            localidad = 6;
        } else if (localidad == 6) {
            localidad7();
            localidad = 7;
        } else if (localidad == 7) {
            localidad8();
            localidad = 8;
        } else if (localidad == 8) {
            localidad9();
            localidad = 9;
        } else if (localidad == 9) {
            localidad10();
            localidad = 10;
        } else if (localidad == 10) {
            localidad11();
            localidad = 11;
        } else if (localidad == 11) {
            localidad12();
            localidad = 12;
        } else if (localidad == 12) {
            localidad13();
            localidad = 13;
        } else if (localidad == 13) {
            localidad14();
            localidad = 14;
        } else if (localidad == 14) {
            localidad15();
            localidad = 15;
        } else if (localidad == 15) {
            localidad1();
            localidad = 1;
        }

    }

    public void retroceder() {
        if (localidad == 1) {
            localidad15();
            localidad = 15;
        } else if (localidad == 2) {
            localidad1();
            localidad = 1;
        } else if (localidad == 3) {
            localidad2();
            localidad = 2;
        } else if (localidad == 4) {
            localidad3();
            localidad = 3;
        } else if (localidad == 5) {
            localidad4();
            localidad = 4;
        } else if (localidad == 6) {
            localidad5();
            localidad = 5;
        } else if (localidad == 7) {
            localidad6();
            localidad = 6;
        } else if (localidad == 8) {
            localidad7();
            localidad = 7;
        } else if (localidad == 9) {
            localidad8();
            localidad = 8;
        } else if (localidad == 10) {
            localidad9();
            localidad = 9;
        } else if (localidad == 11) {
            localidad10();
            localidad = 10;
        } else if (localidad == 12) {
            localidad11();
            localidad = 11;
        } else if (localidad == 13) {
            localidad12();
            localidad = 12;
        } else if (localidad == 14) {
            localidad13();
            localidad = 13;
        } else if (localidad == 15) {
            localidad14();
            localidad = 14;
        }
    }

    public void localidad1() {
        Gy = -24.0f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;
    }

    public void localidad2() {
        Gy = -48.0f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;
    }

    public void localidad3() {
        Gy = -72.0f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;
    }

    public void localidad4() {
        Gy = -96.0f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;
    }

    public void localidad5() {
        Gy = -120.0f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;
    }

    public void localidad6() {
        Gy = -144.0f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;
    }

    public void localidad7() {
        Gy = -168.0f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;
    }

    public void localidad8() {
        Gy = -192.0f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;
    }

    public void localidad9() {
        Gy = -216.0f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;
    }

    public void localidad10() {
        Gy = -240.0f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;
    }

    public void localidad11() {
        Gy = -264.0f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;
    }

    public void localidad12() {
        Gy = -288.0f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;
    }

    public void localidad13() {
        Gy = -312.0f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;
    }

    public void localidad14() {
        Gy = -336.0f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;
    }

    public void localidad15() {
        Gy = -360.0f;

        trans1.rotY((Gy - gY) * Math.PI / 180);
        rot1.mul(trans1);
        rotacion1.setTransform(rot1);

        gY = Gy;
    }
}