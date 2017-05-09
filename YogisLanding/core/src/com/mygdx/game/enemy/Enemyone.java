package com.mygdx.game.enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.util.Constants;

/**
 * Created by asok on 5/8/2017.
 */
public class Enemyone extends Actor {

    private float stateTime;
    private Animation runningAnimation;

    private float width = 0;
    private float height = 0;

    public Enemyone(){
        createAnimation();
        setBounds((Gdx.graphics.getWidth()/2) - (Constants.YOGI_WIDTH / 2), 0,
                this.width, this.height);
    }

    private void createAnimation(){
        TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("zombout.txt"));
        TextureRegion[] runningFrames = new TextureRegion[6];
        for (int i = 0; i < 6; i++) {
            String path = "zomb" + String.valueOf(i + 1) + ".png";
            runningFrames[i] = textureAtlas.findRegion(path);
        }
        runningAnimation = new Animation(0.1f, runningFrames);
        stateTime = 0f;

        this.width = runningFrames[0].getRegionWidth();
        this.height = runningFrames[0].getRegionHeight();

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        stateTime += Gdx.graphics.getDeltaTime();
        batch.draw(runningAnimation.getKeyFrame(stateTime, true), getX(), getY(), width, height);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

            setPosition(getX() , getY() + (1.4f * 6.5f));

    }

}
