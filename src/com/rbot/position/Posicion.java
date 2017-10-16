package com.rbot.position;

import com.rbot.body.movement.PiezaOruga;

import javax.vecmath.*;
import javax.media.j3d.*;

public class Posicion extends BranchGroup
{
	PiezaOruga po;
	float x,y,z,gy;
	TransformGroup tg;
	Transform3D trans,trans1,trans2,trans3,util;
	public Posicion(float x, float y, float z, float gy)
	{
		System.out.println("Adentro\n \n \n");
		this.x = x;
		this.y = y;
		this.z = z;
		this.gy = gy;

		this.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		this.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

		tg = new TransformGroup();
		tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		trans = new Transform3D();
		trans1 = new Transform3D();
		trans2 = new Transform3D();
		trans3 = new Transform3D();
		util = new Transform3D();
		
		po = new PiezaOruga();
		
		trans.setTranslation(new Vector3f(x,0.0f,0.0f));
		util.mul(trans);
		tg.setTransform(util);

		trans1.setTranslation(new Vector3f(0.0f,y,0.0f));
		util.mul(trans1);
		tg.setTransform(util);

		trans2.setTranslation(new Vector3f(0.0f,0.0f,z));
		util.mul(trans2);
		tg.setTransform(util);

		trans3.rotY(gy*Math.PI/180);
		util.mul(trans3);

		tg.setTransform(util);

		tg.addChild(po);

		this.addChild(tg);
		System.out.println("Ultimo\n \n \n");
		this.compile();
	}
}