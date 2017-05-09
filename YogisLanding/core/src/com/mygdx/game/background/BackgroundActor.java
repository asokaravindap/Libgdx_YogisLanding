package com.mygdx.game.background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by asok on 2/17/2017.
 */
public class BackgroundActor extends Actor {

    private final TextureRegion textureRegion;
    private Rectangle textureRegionBounds1;
    private Rectangle textureRegionBounds2;
    private int speed;
    private TextureAtlas atlas;
    private AtlasRegion layer;
    int width = 1200;
    int height = 2000;

    public BackgroundActor(String layername, int layerSpeed) {
        atlas = new TextureAtlas(Gdx.files.internal("test.txt"));
        layer = atlas.findRegion(layername);
        textureRegion = new TextureRegion(layer);

        speed = layerSpeed;

        textureRegionBounds1 = new Rectangle(0, 0, width, height);
        textureRegionBounds2 = new Rectangle(0, -height, width, height);
    }

    @Override
    public void act(float delta) {
        if (upperBoundsReached(delta)) {
            resetBounds();
        } else {
            updateXBounds(delta);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, textureRegionBounds1.x, textureRegionBounds1.y, width, height);
        batch.draw(textureRegion, textureRegionBounds2.x, textureRegionBounds2.y, width, height);
    }

    private boolean upperBoundsReached(float delta) {
        return (textureRegionBounds2.y + delta * speed)  >= 0;
    }

    private void updateXBounds(float delta) {

        textureRegionBounds1.y += delta * speed;
        textureRegionBounds2.y += delta * speed;
    }

    private void resetBounds() {
        textureRegionBounds1 = textureRegionBounds2;
        textureRegionBounds2 = new Rectangle(0, -height, width, height);
    }

}
