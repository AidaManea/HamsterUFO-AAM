package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;

public class GameScreen implements Screen {

    final Main game;

    SpriteBatch batch;

    Texture background;
    Texture playerTexture;
    Texture crystalTexture;
    Texture rockTexture;

    float playerX = 400;
    float playerY = 20;

    int score = 0;
    int lives = 3;

    float spawnTimer = 0;

    ArrayList<FallingObject> objects;

    public GameScreen(Main game){

        this.game = game;

        batch = new SpriteBatch();

        background = new Texture("background.png");
        playerTexture = new Texture("player.png");
        crystalTexture = new Texture("crystal.png");
        rockTexture = new Texture("rock.png");

        objects = new ArrayList<>();
    }

    @Override
    public void render(float delta){

        update(delta);

        if (lives <= 0) return;

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        batch.draw(background,0,0,800,500);

        batch.draw(playerTexture,playerX,playerY,64,64);

        for(FallingObject obj : objects){

            Texture t = obj.type == 0 ? crystalTexture : rockTexture;

            batch.draw(t,obj.x,obj.y,32,32);
        }

        batch.end();
    }

    private void update(float delta){

        // INPUT

        if(Gdx.input.isTouched()){

            playerX = Gdx.input.getX();

            playerX = MathUtils.clamp(playerX,0,736);
        }

        // SPAWN

        spawnTimer += delta;

        if(spawnTimer > 1){

            spawnTimer = 0;

            float x = MathUtils.random(0,760);

            int type = MathUtils.random(0,1);

            objects.add(new FallingObject(x,480,type));
        }

        // UPDATE OBJECTS

        for(int i=0;i<objects.size();i++){

            FallingObject obj = objects.get(i);

            obj.y -= 200 * delta;

            boolean collision =
                obj.x < playerX + 64 &&
                    obj.x + 32 > playerX &&
                    obj.y < playerY + 64 &&
                    obj.y + 32 > playerY;

            if(collision){

                if(obj.type == 0){
                    score++;
                }else{
                    lives--;
                }

                objects.remove(i);
                i--;

                if(lives <= 0){
                    game.setScreen(new GameOverScreen(game,score));
                    dispose();
                    return;
                }

                continue;
            }

            if(obj.y < 0){
                objects.remove(i);
                i--;
            }
        }
    }

    @Override public void show(){}
    @Override public void resize(int width,int height){}
    @Override public void pause(){}
    @Override public void resume(){}
    @Override public void hide(){}

    @Override
    public void dispose(){

        batch.dispose();
        background.dispose();
        playerTexture.dispose();
        crystalTexture.dispose();
        rockTexture.dispose();
    }
}
