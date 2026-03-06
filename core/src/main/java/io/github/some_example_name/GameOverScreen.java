package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOverScreen implements Screen {

    final Main game;

    SpriteBatch batch;
    Texture gameover;

    int score;

    public GameOverScreen(Main game,int score){

        this.game = game;
        this.score = score;

        batch = new SpriteBatch();
        gameover = new Texture("gameover.png");
    }

    @Override
    public void render(float delta){

        if(Gdx.input.justTouched()){
            game.setScreen(new MenuScreen(game));
            dispose();
            return;
        }

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(gameover,0,0,800,500);
        batch.end();
    }

    @Override public void show(){}
    @Override public void resize(int width,int height){}
    @Override public void pause(){}
    @Override public void resume(){}
    @Override public void hide(){}

    @Override
    public void dispose(){
        batch.dispose();
        gameover.dispose();
    }
}
