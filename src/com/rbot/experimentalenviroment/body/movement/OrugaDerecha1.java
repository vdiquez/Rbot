package com.rbot.experimentalenviroment.body.movement;

import com.rbot.experimentalenviroment.body.pieces.*;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.TransformGroup;

public class OrugaDerecha1 extends BranchGroup {
    Pieza1 p1;
    Pieza2 p2;
    Pieza3 p3;
    Pieza4 p4;
    Pieza5 p5;
    Pieza6 p6;
    Pieza7 p7;
    Pieza8 p8;
    Pieza9 p9;
    Pieza10 p10;
    Pieza11 p11;
    Pieza12 p12;
    Pieza13 p13;
    Pieza14 p14;
    Pieza15 p15;
    Pieza16 p16;
    Pieza17 p17;
    Pieza18 p18;
    Pieza19 p19;
    Pieza20 p20;
    Pieza21 p21;
    Pieza22 p22;
    Pieza23 p23;
    Pieza24 p24;
    Pieza25 p25;
    Pieza26 p26;
    Pieza27 p27;
    Pieza28 p28;
    Pieza29 p29;
    TransformGroup tg;

    public OrugaDerecha1() {
        tg = new TransformGroup();
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

        p1 = new Pieza1();
        p2 = new Pieza2();
        p3 = new Pieza3();
        p4 = new Pieza4();
        p5 = new Pieza5();
        p6 = new Pieza6();
        p7 = new Pieza7();
        p8 = new Pieza8();
        p9 = new Pieza9();
        p10 = new Pieza10();
        p11 = new Pieza11();
        p12 = new Pieza12();
        p13 = new Pieza13();
        p14 = new Pieza14();
        p15 = new Pieza15();
        p16 = new Pieza16();
        p17 = new Pieza17();
        p18 = new Pieza18();
        p19 = new Pieza19();
        p20 = new Pieza20();
        p21 = new Pieza21();
        p22 = new Pieza22();
        p23 = new Pieza23();
        p24 = new Pieza24();
        p25 = new Pieza25();
        p26 = new Pieza26();
        p27 = new Pieza27();
        p28 = new Pieza28();
        p29 = new Pieza29();

        tg.addChild(p1);
        tg.addChild(p2);
        tg.addChild(p3);
        tg.addChild(p4);
        tg.addChild(p5);
        tg.addChild(p6);
        tg.addChild(p7);
        tg.addChild(p8);
        tg.addChild(p9);
        tg.addChild(p10);
        tg.addChild(p11);
        tg.addChild(p12);
        tg.addChild(p13);
        tg.addChild(p14);
        tg.addChild(p15);
        tg.addChild(p16);
        tg.addChild(p17);
        tg.addChild(p18);
        tg.addChild(p19);
        tg.addChild(p20);
        tg.addChild(p21);
        tg.addChild(p22);
        tg.addChild(p23);
        tg.addChild(p24);
        tg.addChild(p25);
        tg.addChild(p26);
        tg.addChild(p27);
        tg.addChild(p28);
        tg.addChild(p29);

        this.addChild(tg);
        this.compile();
    }

    public Pieza1 getPieza1() {

        return p1;
    }

    public Pieza2 getPieza2() {

        return p2;
    }

    public Pieza3 getPieza3() {

        return p3;
    }

    public Pieza4 getPieza4() {

        return p4;
    }

    public Pieza5 getPieza5() {

        return p5;
    }

    public Pieza6 getPieza6() {

        return p6;
    }

    public Pieza7 getPieza7() {

        return p7;
    }

    public Pieza8 getPieza8() {

        return p8;
    }

    public Pieza9 getPieza9() {

        return p9;
    }

    public Pieza10 getPieza10() {

        return p10;
    }

    public Pieza11 getPieza11() {

        return p11;
    }

    public Pieza12 getPieza12() {

        return p12;
    }

    public Pieza13 getPieza13() {

        return p13;
    }

    public Pieza14 getPieza14() {

        return p14;
    }

    public Pieza15 getPieza15() {

        return p15;
    }

    public Pieza16 getPieza16() {

        return p16;
    }

    public Pieza17 getPieza17() {

        return p17;
    }

    public Pieza18 getPieza18() {

        return p18;
    }

    public Pieza19 getPieza19() {

        return p19;
    }

    public Pieza20 getPieza20() {

        return p20;
    }

    public Pieza21 getPieza21() {

        return p21;
    }

    public Pieza22 getPieza22() {

        return p22;
    }

    public Pieza23 getPieza23() {

        return p23;
    }

    public Pieza24 getPieza24() {

        return p24;
    }

    public Pieza25 getPieza25() {

        return p25;
    }

    public Pieza26 getPieza26() {

        return p26;
    }

    public Pieza27 getPieza27() {

        return p27;
    }

    public Pieza28 getPieza28() {

        return p28;
    }

    public Pieza29 getPieza29() {

        return p29;
    }
}