package com.mygdx.game.stages;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.background.BackgroundActor;
import com.mygdx.game.enemy.Enemyone;
import com.mygdx.game.enemy.GameActor;
import com.mygdx.game.player.Yogi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asok on 2/15/2017.
 */

public class GameStage extends Stage {

    private OrthographicCamera camera;
    private static final int VIEWPORT_WIDTH = 100;
    private static final int VIEWPORT_HEIGHT = 90;

    private Yogi yogi;
    List<GameActor> enemies = new ArrayList<GameActor>();

    public GameStage() {
        setUpBackground();
        setUpPlayer();
        setupCamera();
        setupEnemy();
    }

    private void setUpBackground() {
        addActor(new BackgroundActor("layer1", 100));
        addActor(new BackgroundActor("layer2", 200));
        addActor(new BackgroundActor("layer3", 300));
    }

    private void setUpPlayer(){
        yogi = new Yogi();
        addActor(yogi);
    }

    private void setupEnemy(){
        enemies.add(new Enemyone());
        for (GameActor enemy : enemies){
            addActor(enemy);
        }
    }

    private void setupCamera() {
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    public Yogi getYogi() {
        return yogi;
    }

    public List<GameActor> getEnemies() {
        return enemies;
    }
}
