package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Circle;

import java.util.Random;

public class Main extends ApplicationAdapter implements InputProcessor{

	Base base1,base2;
    Ball ball;
    Circle ballCircle;
    Random rand;
    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    BitmapFont font1,font2;
    SpriteBatch batch;
    int score1,score2;
	
	@Override
	public void create () {

		Gdx.input.setInputProcessor(this);



	   base1 = new Base(0f,Gdx.graphics.getHeight()/2);
	   base2 = new Base(Gdx.graphics.getWidth() - 50f,Gdx.graphics.getHeight()/2);
	   ball = new Ball();
	   ballCircle = ball.getBallCircle();
	   rand = new Random();

	   batch = new SpriteBatch();

	   generator = new FreeTypeFontGenerator(Gdx.files.internal("roboto.ttf"));
	   parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
	   parameter.size = 150;
	   parameter.color = Color.YELLOW;
	   font1 = generator.generateFont(parameter);
	   font2 = generator.generateFont(parameter);

	   score1 = 0;
	   score2 = 0;

    }

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		base1.generateShape();
		base2.generateShape();
		ball.generateShape();
		ball.boundaryCollision();
		ball.moveBall();

		batch.begin();
		font1.draw(batch,String.valueOf(score1),50f,200f);
		font2.draw(batch,String.valueOf(score2),Gdx.graphics.getWidth() - 170f,200f);
		batch.end();

        if(Gdx.input.isKeyPressed(Input.Keys.W)){
        	 if(base1.getShapePosY() + 150f < Gdx.graphics.getHeight()){
        	 	 base1.setShapePosY(base1.getShapePosY() + 5f);
			 }
		}

		if(Gdx.input.isKeyPressed(Input.Keys.S)){
			if(base1.getShapePosY() > 0f){
				base1.setShapePosY(base1.getShapePosY() - 5f);
			}
		}

		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			if(base2.getShapePosY() + 150f < Gdx.graphics.getHeight()){
				base2.setShapePosY(base2.getShapePosY() + 5f);
			}
		}

		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			if(base2.getShapePosY() > 0f){
				base2.setShapePosY(base2.getShapePosY() - 5f);
			}
		}

		if(base1.isCollided(ballCircle)){
			ball.setDirX(20f);
			ball.setDirY((float)(rand.nextInt(20) - 6));
		}

		if(base2.isCollided(ballCircle)){
			ball.setDirX(-20f);
			ball.setDirY((float)(rand.nextInt(20) - 6));
		}

		if(ball.getBallPosX() < 0f){
			score2++;
			ball.setBallPosX(Gdx.graphics.getWidth()/2);
			ball.setBallPosY(Gdx.graphics.getHeight()/2);
		}

		else if(ball.getBallPosX() > Gdx.graphics.getWidth()){
			score1++;
			ball.setBallPosX(Gdx.graphics.getWidth()/2);
			ball.setBallPosY(Gdx.graphics.getHeight()/2);
		}



	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		if(screenX < Gdx.graphics.getWidth()/2 + 200f){
			base1.setShapePosX(screenX);
			base1.setShapePosY(Gdx.graphics.getHeight()  -  screenY);
		}

		if(screenX > Gdx.graphics.getWidth()/2 - 200f){
			base2.setShapePosX(screenX);
			base2.setShapePosY(Gdx.graphics.getHeight()  -  screenY);
		}

		return false;



	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return false;
	}
}
