package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.enemy.GameActor;
import com.mygdx.game.player.Yogi;
import com.mygdx.game.stages.GameStage;

import java.util.List;

/**
 * Created by asok on 2/15/2017.
 */

public class GameScreen implements Screen {

    private GameStage stage;

    public GameScreen() {
        stage = new GameStage();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act(delta);

        isCollided();
    }

    private boolean isCollided(){
        Yogi yogi = stage.getYogi();
        List<GameActor> enemies = stage.getEnemies();

        for(GameActor enemy : enemies){
            if(yogi.getBounds().overlaps(enemy.getBounds())){
                System.out.println("HIT HIT HIT");
            }
        }
        return false;
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
