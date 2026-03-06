package io.github.some_example_name;

import io.github.some_example_name.Main;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuScreen implements Screen {

    final Main game;

    SpriteBatch batch;
    Texture menu;

    public MenuScreen(Main game) {
        this.game = game;
        batch = new SpriteBatch();
        menu = new Texture("menu.png");
    }

    @Override
    public void render(float delta) {

        if(Gdx.input.justTouched()){
            game.setScreen(new GameScreen(game));
            dispose();
            return;
        }

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(menu,0,0,800,500);
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
        menu.dispose();
    }
}
