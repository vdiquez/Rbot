package com.rbot.body;

import com.rbot.body.cam.EstructuraCamara;
import com.rbot.body.movement.*;
import com.rbot.position.Posicionamiento;
import com.rbot.body.cam.EngranajeBaseMotor;
import ncsa.j3d.loaders.ModelLoader;

import javax.media.j3d.*;
import java.io.*;

import com.sun.j3d.loaders.*;

import javax.vecmath.*;

public class Cuerpo extends BranchGroup {

    EstructuraCamara ecm;
    EngranajeBaseMotor ebm;
    Posicionamiento posm;
    MovimientoRueda mr;
    MovimientoRueda1 mr1;
    MovimientoRueda2 mr2;
    MovimientoRueda3 mr3;
    OrugaDerecha od;
    OrugaDerecha1 od1;
    TransformGroup tg, tg1, tg2, tg3;
    Transform3D trans, utility, utility1, trans1, utility11;
    float paso = 1;
    float refX = 0;
    double der = 0.1;
    double refIZ = 0;
    Transform3D util2 = new Transform3D();
    Transform3D util4 = new Transform3D();
    Transform3D utility55 = new Transform3D();

    public Cuerpo() {
        posm = new Posicionamiento();
        mr = new MovimientoRueda();
        mr1 = new MovimientoRueda1();
        mr2 = new MovimientoRueda2();
        mr3 = new MovimientoRueda3();
        ecm = new EstructuraCamara();
        ebm = new EngranajeBaseMotor();

        od = new OrugaDerecha();
        od1 = new OrugaDerecha1();

        tg1 = new TransformGroup();
        tg1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tg1.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        tg2 = new TransformGroup();
        tg2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tg2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        tg3 = new TransformGroup();
        tg3.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tg3.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        Transform3D trans = new Transform3D();
        Transform3D utility = new Transform3D();
        trans.setTranslation(new Vector3f(-26.31f, -1.87f, -3.46f));
        utility.mul(trans);
        tg3.setTransform(utility);

        tg = new TransformGroup();
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        tg.addChild(createSceneGraph());

        trans = new Transform3D();
        utility = new Transform3D();
        utility1 = new Transform3D();

        trans1 = new Transform3D();
        utility11 = new Transform3D();

        trans.setTranslation(new Vector3f(1.45f, 25.45f, -7.13f));
        utility.mul(trans);
        tg1.setTransform(utility);

        trans1.setTranslation(new Vector3f(1.45f, -25.45f, -7.13f));
        utility11.mul(trans1);
        tg2.setTransform(utility11);

        tg1.addChild(od);
        tg2.addChild(od1);

        tg.addChild(mr);
        tg.addChild(mr1);
        tg.addChild(mr2);
        tg.addChild(mr3);
        tg.addChild(ecm);
        tg.addChild(ebm);
        tg.addChild(tg1);
        tg.addChild(tg2);
        this.addChild(tg);


        this.compile();
    }

    public void moverOrugaDerecha() {
        this.getOrugaDerecha().getPieza1().avanzar();
        this.getOrugaDerecha().getPieza2().avanzar();
        this.getOrugaDerecha().getPieza3().avanzar();
        this.getOrugaDerecha().getPieza4().avanzar();
        this.getOrugaDerecha().getPieza5().avanzar();
        this.getOrugaDerecha().getPieza6().avanzar();
        this.getOrugaDerecha().getPieza7().avanzar();
        this.getOrugaDerecha().getPieza8().avanzar();
        this.getOrugaDerecha().getPieza9().avanzar();
        this.getOrugaDerecha().getPieza10().avanzar();
        this.getOrugaDerecha().getPieza11().avanzar();
        this.getOrugaDerecha().getPieza12().avanzar();
        this.getOrugaDerecha().getPieza13().avanzar();
        this.getOrugaDerecha().getPieza14().avanzar();
        this.getOrugaDerecha().getPieza15().avanzar();
        this.getOrugaDerecha().getPieza16().avanzar();
        this.getOrugaDerecha().getPieza17().avanzar();
        this.getOrugaDerecha().getPieza18().avanzar();
        this.getOrugaDerecha().getPieza19().avanzar();
        this.getOrugaDerecha().getPieza20().avanzar();
        this.getOrugaDerecha().getPieza21().avanzar();
        this.getOrugaDerecha().getPieza22().avanzar();
        this.getOrugaDerecha().getPieza23().avanzar();
        this.getOrugaDerecha().getPieza24().avanzar();
        this.getOrugaDerecha().getPieza25().avanzar();
        this.getOrugaDerecha().getPieza26().avanzar();
        this.getOrugaDerecha().getPieza27().avanzar();
        this.getOrugaDerecha().getPieza28().avanzar();
        this.getOrugaDerecha().getPieza29().avanzar();
        //Rueda 1
        this.getMovimientoRueda().avanzar();
        this.getMovimientoRueda1().avanzar();
        this.getMovimientoRueda2().avanzar();
        this.getMovimientoRueda3().avanzar();
        //Oruga Izquierda
        this.getOrugaDerecha1().getPieza1().avanzar();
        this.getOrugaDerecha1().getPieza2().avanzar();
        this.getOrugaDerecha1().getPieza3().avanzar();
        this.getOrugaDerecha1().getPieza4().avanzar();
        this.getOrugaDerecha1().getPieza5().avanzar();
        this.getOrugaDerecha1().getPieza6().avanzar();
        this.getOrugaDerecha1().getPieza7().avanzar();
        this.getOrugaDerecha1().getPieza8().avanzar();
        this.getOrugaDerecha1().getPieza9().avanzar();
        this.getOrugaDerecha1().getPieza10().avanzar();
        this.getOrugaDerecha1().getPieza11().avanzar();
        this.getOrugaDerecha1().getPieza12().avanzar();
        this.getOrugaDerecha1().getPieza13().avanzar();
        this.getOrugaDerecha1().getPieza14().avanzar();
        this.getOrugaDerecha1().getPieza15().avanzar();
        this.getOrugaDerecha1().getPieza16().avanzar();
        this.getOrugaDerecha1().getPieza17().avanzar();
        this.getOrugaDerecha1().getPieza18().avanzar();
        this.getOrugaDerecha1().getPieza19().avanzar();
        this.getOrugaDerecha1().getPieza20().avanzar();
        this.getOrugaDerecha1().getPieza21().avanzar();
        this.getOrugaDerecha1().getPieza22().avanzar();
        this.getOrugaDerecha1().getPieza23().avanzar();
        this.getOrugaDerecha1().getPieza24().avanzar();
        this.getOrugaDerecha1().getPieza25().avanzar();
        this.getOrugaDerecha1().getPieza26().avanzar();
        this.getOrugaDerecha1().getPieza27().avanzar();
        this.getOrugaDerecha1().getPieza28().avanzar();
        this.getOrugaDerecha1().getPieza29().avanzar();
    }

    public void moverOrugaIzquierda() {
        this.getOrugaDerecha().getPieza1().retroceder();
        this.getOrugaDerecha().getPieza2().retroceder();
        this.getOrugaDerecha().getPieza3().retroceder();
        this.getOrugaDerecha().getPieza4().retroceder();
        this.getOrugaDerecha().getPieza5().retroceder();
        this.getOrugaDerecha().getPieza6().retroceder();
        this.getOrugaDerecha().getPieza7().retroceder();
        this.getOrugaDerecha().getPieza8().retroceder();
        this.getOrugaDerecha().getPieza9().retroceder();
        this.getOrugaDerecha().getPieza10().retroceder();
        this.getOrugaDerecha().getPieza11().retroceder();
        this.getOrugaDerecha().getPieza12().retroceder();
        this.getOrugaDerecha().getPieza13().retroceder();
        this.getOrugaDerecha().getPieza14().retroceder();
        this.getOrugaDerecha().getPieza15().retroceder();
        this.getOrugaDerecha().getPieza16().retroceder();
        this.getOrugaDerecha().getPieza17().retroceder();
        this.getOrugaDerecha().getPieza18().retroceder();
        this.getOrugaDerecha().getPieza19().retroceder();
        this.getOrugaDerecha().getPieza20().retroceder();
        this.getOrugaDerecha().getPieza21().retroceder();
        this.getOrugaDerecha().getPieza22().retroceder();
        this.getOrugaDerecha().getPieza23().retroceder();
        this.getOrugaDerecha().getPieza24().retroceder();
        this.getOrugaDerecha().getPieza25().retroceder();
        this.getOrugaDerecha().getPieza26().retroceder();
        this.getOrugaDerecha().getPieza27().retroceder();
        this.getOrugaDerecha().getPieza28().retroceder();
        this.getOrugaDerecha().getPieza29().retroceder();
        //Rueda 1
        this.getMovimientoRueda().retroceder();
        this.getMovimientoRueda1().retroceder();
        this.getMovimientoRueda2().retroceder();
        this.getMovimientoRueda3().retroceder();
        //Oruga Izquierda
        this.getOrugaDerecha1().getPieza1().retroceder();
        this.getOrugaDerecha1().getPieza2().retroceder();
        this.getOrugaDerecha1().getPieza3().retroceder();
        this.getOrugaDerecha1().getPieza4().retroceder();
        this.getOrugaDerecha1().getPieza5().retroceder();
        this.getOrugaDerecha1().getPieza6().retroceder();
        this.getOrugaDerecha1().getPieza7().retroceder();
        this.getOrugaDerecha1().getPieza8().retroceder();
        this.getOrugaDerecha1().getPieza9().retroceder();
        this.getOrugaDerecha1().getPieza10().retroceder();
        this.getOrugaDerecha1().getPieza11().retroceder();
        this.getOrugaDerecha1().getPieza12().retroceder();
        this.getOrugaDerecha1().getPieza13().retroceder();
        this.getOrugaDerecha1().getPieza14().retroceder();
        this.getOrugaDerecha1().getPieza15().retroceder();
        this.getOrugaDerecha1().getPieza16().retroceder();
        this.getOrugaDerecha1().getPieza17().retroceder();
        this.getOrugaDerecha1().getPieza18().retroceder();
        this.getOrugaDerecha1().getPieza19().retroceder();
        this.getOrugaDerecha1().getPieza20().retroceder();
        this.getOrugaDerecha1().getPieza21().retroceder();
        this.getOrugaDerecha1().getPieza22().retroceder();
        this.getOrugaDerecha1().getPieza23().retroceder();
        this.getOrugaDerecha1().getPieza24().retroceder();
        this.getOrugaDerecha1().getPieza25().retroceder();
        this.getOrugaDerecha1().getPieza26().retroceder();
        this.getOrugaDerecha1().getPieza27().retroceder();
        this.getOrugaDerecha1().getPieza28().retroceder();
        this.getOrugaDerecha1().getPieza29().retroceder();
    }

    public void moverDerecha() {
        this.getOrugaDerecha().getPieza1().retroceder();
        this.getOrugaDerecha().getPieza2().retroceder();
        this.getOrugaDerecha().getPieza3().retroceder();
        this.getOrugaDerecha().getPieza4().retroceder();
        this.getOrugaDerecha().getPieza5().retroceder();
        this.getOrugaDerecha().getPieza6().retroceder();
        this.getOrugaDerecha().getPieza7().retroceder();
        this.getOrugaDerecha().getPieza8().retroceder();
        this.getOrugaDerecha().getPieza9().retroceder();
        this.getOrugaDerecha().getPieza10().retroceder();
        this.getOrugaDerecha().getPieza11().retroceder();
        this.getOrugaDerecha().getPieza12().retroceder();
        this.getOrugaDerecha().getPieza13().retroceder();
        this.getOrugaDerecha().getPieza14().retroceder();
        this.getOrugaDerecha().getPieza15().retroceder();
        this.getOrugaDerecha().getPieza16().retroceder();
        this.getOrugaDerecha().getPieza17().retroceder();
        this.getOrugaDerecha().getPieza18().retroceder();
        this.getOrugaDerecha().getPieza19().retroceder();
        this.getOrugaDerecha().getPieza20().retroceder();
        this.getOrugaDerecha().getPieza21().retroceder();
        this.getOrugaDerecha().getPieza22().retroceder();
        this.getOrugaDerecha().getPieza23().retroceder();
        this.getOrugaDerecha().getPieza24().retroceder();
        this.getOrugaDerecha().getPieza25().retroceder();
        this.getOrugaDerecha().getPieza26().retroceder();
        this.getOrugaDerecha().getPieza27().retroceder();
        this.getOrugaDerecha().getPieza28().retroceder();
        this.getOrugaDerecha().getPieza29().retroceder();
        //Rueda 1
        this.getMovimientoRueda().retroceder();
        this.getMovimientoRueda1().avanzar();
        this.getMovimientoRueda2().retroceder();
        this.getMovimientoRueda3().avanzar();
        //Oruga Izquierda
        this.getOrugaDerecha1().getPieza1().avanzar();
        this.getOrugaDerecha1().getPieza2().avanzar();
        this.getOrugaDerecha1().getPieza3().avanzar();
        this.getOrugaDerecha1().getPieza4().avanzar();
        this.getOrugaDerecha1().getPieza5().avanzar();
        this.getOrugaDerecha1().getPieza6().avanzar();
        this.getOrugaDerecha1().getPieza7().avanzar();
        this.getOrugaDerecha1().getPieza8().avanzar();
        this.getOrugaDerecha1().getPieza9().avanzar();
        this.getOrugaDerecha1().getPieza10().avanzar();
        this.getOrugaDerecha1().getPieza11().avanzar();
        this.getOrugaDerecha1().getPieza12().avanzar();
        this.getOrugaDerecha1().getPieza13().avanzar();
        this.getOrugaDerecha1().getPieza14().avanzar();
        this.getOrugaDerecha1().getPieza15().avanzar();
        this.getOrugaDerecha1().getPieza16().avanzar();
        this.getOrugaDerecha1().getPieza17().avanzar();
        this.getOrugaDerecha1().getPieza18().avanzar();
        this.getOrugaDerecha1().getPieza19().avanzar();
        this.getOrugaDerecha1().getPieza20().avanzar();
        this.getOrugaDerecha1().getPieza21().avanzar();
        this.getOrugaDerecha1().getPieza22().avanzar();
        this.getOrugaDerecha1().getPieza23().avanzar();
        this.getOrugaDerecha1().getPieza24().avanzar();
        this.getOrugaDerecha1().getPieza25().avanzar();
        this.getOrugaDerecha1().getPieza26().avanzar();
        this.getOrugaDerecha1().getPieza27().avanzar();
        this.getOrugaDerecha1().getPieza28().avanzar();
        this.getOrugaDerecha1().getPieza29().avanzar();
    }

    public void moverIzquierda() {
        this.getOrugaDerecha().getPieza1().avanzar();
        this.getOrugaDerecha().getPieza2().avanzar();
        this.getOrugaDerecha().getPieza3().avanzar();
        this.getOrugaDerecha().getPieza4().avanzar();
        this.getOrugaDerecha().getPieza5().avanzar();
        this.getOrugaDerecha().getPieza6().avanzar();
        this.getOrugaDerecha().getPieza7().avanzar();
        this.getOrugaDerecha().getPieza8().avanzar();
        this.getOrugaDerecha().getPieza9().avanzar();
        this.getOrugaDerecha().getPieza10().avanzar();
        this.getOrugaDerecha().getPieza11().avanzar();
        this.getOrugaDerecha().getPieza12().avanzar();
        this.getOrugaDerecha().getPieza13().avanzar();
        this.getOrugaDerecha().getPieza14().avanzar();
        this.getOrugaDerecha().getPieza15().avanzar();
        this.getOrugaDerecha().getPieza16().avanzar();
        this.getOrugaDerecha().getPieza17().avanzar();
        this.getOrugaDerecha().getPieza18().avanzar();
        this.getOrugaDerecha().getPieza19().avanzar();
        this.getOrugaDerecha().getPieza20().avanzar();
        this.getOrugaDerecha().getPieza21().avanzar();
        this.getOrugaDerecha().getPieza22().avanzar();
        this.getOrugaDerecha().getPieza23().avanzar();
        this.getOrugaDerecha().getPieza24().avanzar();
        this.getOrugaDerecha().getPieza25().avanzar();
        this.getOrugaDerecha().getPieza26().avanzar();
        this.getOrugaDerecha().getPieza27().avanzar();
        this.getOrugaDerecha().getPieza28().avanzar();
        this.getOrugaDerecha().getPieza29().avanzar();
        //Rueda 1
        this.getMovimientoRueda().avanzar();
        this.getMovimientoRueda1().retroceder();
        this.getMovimientoRueda2().avanzar();
        this.getMovimientoRueda3().retroceder();
        //Oruga Izquierda
        this.getOrugaDerecha1().getPieza1().retroceder();
        this.getOrugaDerecha1().getPieza2().retroceder();
        this.getOrugaDerecha1().getPieza3().retroceder();
        this.getOrugaDerecha1().getPieza4().retroceder();
        this.getOrugaDerecha1().getPieza5().retroceder();
        this.getOrugaDerecha1().getPieza6().retroceder();
        this.getOrugaDerecha1().getPieza7().retroceder();
        this.getOrugaDerecha1().getPieza8().retroceder();
        this.getOrugaDerecha1().getPieza9().retroceder();
        this.getOrugaDerecha1().getPieza10().retroceder();
        this.getOrugaDerecha1().getPieza11().retroceder();
        this.getOrugaDerecha1().getPieza12().retroceder();
        this.getOrugaDerecha1().getPieza13().retroceder();
        this.getOrugaDerecha1().getPieza14().retroceder();
        this.getOrugaDerecha1().getPieza15().retroceder();
        this.getOrugaDerecha1().getPieza16().retroceder();
        this.getOrugaDerecha1().getPieza17().retroceder();
        this.getOrugaDerecha1().getPieza18().retroceder();
        this.getOrugaDerecha1().getPieza19().retroceder();
        this.getOrugaDerecha1().getPieza20().retroceder();
        this.getOrugaDerecha1().getPieza21().retroceder();
        this.getOrugaDerecha1().getPieza22().retroceder();
        this.getOrugaDerecha1().getPieza23().retroceder();
        this.getOrugaDerecha1().getPieza24().retroceder();
        this.getOrugaDerecha1().getPieza25().retroceder();
        this.getOrugaDerecha1().getPieza26().retroceder();
        this.getOrugaDerecha1().getPieza27().retroceder();
        this.getOrugaDerecha1().getPieza28().retroceder();
        this.getOrugaDerecha1().getPieza29().retroceder();
    }

    public BranchGroup createSceneGraph() {
        ModelLoader loader = new ModelLoader();
        Scene s;
        try {
            s = loader.load("piezas/Cuerpo Robot Pintado.3ds");
            return s.getSceneGroup();
        } catch (FileNotFoundException e) {
            System.out.println("No encuentro el archivo");
            return null;
        }
    }

    public Posicionamiento getPosicionamiento() {
        return posm;
    }

    public OrugaDerecha getOrugaDerecha() {
        return od;
    }

    public OrugaDerecha1 getOrugaDerecha1() {
        return od1;
    }

    public MovimientoRueda getMovimientoRueda() {
        return mr;
    }

    public MovimientoRueda1 getMovimientoRueda1() {
        return mr1;
    }

    public MovimientoRueda2 getMovimientoRueda2() {
        return mr2;
    }

    public MovimientoRueda3 getMovimientoRueda3() {
        return mr3;
    }

    public EstructuraCamara getEstructuraCamara() {
        return ecm;
    }

    public EngranajeBaseMotor dameEngranajeBaseMotor() {
        return ebm;
    }

    public void avanzar() {
        util4.setTranslation(new Vector3f(paso - refX, 0.0f, 0.0f));
        util2.mul(util4);
        tg.setTransform(util2);
        refX = paso;
        paso -= 4;
    }

    public void retroceder() {
        util4.setTranslation(new Vector3f(paso - refX, 0.0f, 0.0f));
        util2.mul(util4);
        tg.setTransform(util2);
        refX = paso;
        paso += 4;
    }

    public void derecha() {
        utility55.rotZ((der - refIZ) * Math.PI / 180);
        util2.mul(utility55);
        tg.setTransform(util2);
        refIZ = der;
        der -= 4.0f;
    }

    public void izquierda() {
        utility55.rotZ((der - refIZ) * Math.PI / 180);
        util2.mul(utility55);
        tg.setTransform(util2);
        refIZ = der;
        der += 4.0f;
    }
}