package com.mygdx.game.stages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;


/**
 * Created by asok on 5/28/2017.
 */
public class MainStage extends Stage {

    private OrthographicCamera camera;
    private static final int VIEWPORT_WIDTH = 100;
    private static final int VIEWPORT_HEIGHT = 90;

    public MainStage(){
        setupCamera();
    }

    private void setupCamera() {
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

}
