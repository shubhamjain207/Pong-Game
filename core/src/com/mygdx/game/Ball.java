package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;

public class Ball {

    private ShapeRenderer ballShape;
    float ballPosX,ballPosY;
    private float dirX,dirY;
    private Circle ballCircle;



    public float getBallPosX() {
        return ballPosX;
    }

    public void setBallPosX(float ballPosX) {
        this.ballPosX = ballPosX;
    }

    public float getBallPosY() {
        return ballPosY;
    }

    public void setBallPosY(float ballPosY) {
        this.ballPosY = ballPosY;
    }

    public float getDirX() {
        return dirX;
    }

    public void setDirX(float dirX) {
        this.dirX = dirX;
    }

    public float getDirY() {
        return dirY;
    }

    public void setDirY(float dirY) {
        this.dirY = dirY;
    }

    public Circle getBallCircle() {
        return ballCircle;
    }

    public void setBallCircle(Circle ballCircle) {
        this.ballCircle = ballCircle;
    }

    public Ball(){
        ballPosX = Gdx.graphics.getWidth()/2;
        ballPosY = Gdx.graphics.getHeight()/2;
        ballShape = new ShapeRenderer();
        dirX = 10f;
        dirY = 4f;
        ballCircle = new Circle(ballPosX,ballPosY,30f);
    }

    public void generateShape(){
        ballCircle.setPosition(ballPosX,ballPosY);
        ballShape.begin(ShapeRenderer.ShapeType.Filled);
        ballShape.setColor(Color.YELLOW);
        ballShape.circle(ballPosX,ballPosY,30f);
        ballShape.end();
    }

    public void moveBall(){
        ballPosX+=dirX;
        ballPosY+=dirY;
    }

    public void boundaryCollision(){
        if(ballPosY - 40f < 0f || ballPosY + 40f > Gdx.graphics.getHeight()){
            dirY = dirY * -1;
        }

    }

}
