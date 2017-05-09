package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.util.Constants;

/**
 * Created by asok on 2/24/2017.
 */

public class Yogi extends Actor {

    private float stateTime;
    private Animation runningAnimation;

    private float width = 0;
    private float height = 0;

    float accelX = 0;

    public Yogi(){
        createAnimation();
        setBounds((Gdx.graphics.getWidth()/2) - (Constants.YOGI_WIDTH / 2),
                 (Gdx.graphics.getHeight()) - (Constants.YOGI_HEIGHT + 60),
                 this.width, this.height);
    }

    private void createAnimation(){
        TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("yogi.txt"));
        TextureRegion[] runningFrames = new TextureRegion[5];
        for (int i = 0; i < 5; i++) {
            String path = "yogi" + String.valueOf(i + 1) + ".jpeg";
            runningFrames[i] = textureAtlas.findRegion(path);
        }
        runningAnimation = new Animation(0.1f, runningFrames);
        stateTime = 0f;

        this.width = runningFrames[0].getRegionWidth();
        this.height = runningFrames[0].getRegionHeight();

    }

    private boolean isAtLeftEdge(){

        return (getX() <= 0);
    }

    private boolean isAtRightEdge(){

        return (Gdx.graphics.getWidth() - (getX() + Constants.YOGI_WIDTH) <= 0);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        stateTime += Gdx.graphics.getDeltaTime();
        batch.draw(runningAnimation.getKeyFrame(stateTime, true), getX(), getY(),width,height);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        accelX = -1 * Gdx.input.getAccelerometerX() ;
//        System.out.println(String.valueOf(Gdx.input.getNativeOrientation()) + " Rotation :" + Gdx.input.getGyroscopeX());

        if((!isAtLeftEdge() && accelX < 0 ) || (!isAtRightEdge() && accelX > 0)) {
            setPosition(getX() + (accelX * 6.5f), getY());
        }

    }

}
