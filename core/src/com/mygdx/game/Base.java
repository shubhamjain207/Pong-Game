package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class Base {

    private ShapeRenderer baseShape;
    private float shapePosX,shapePosY;
    private Color color;
    private Rectangle baseRect;

    public float getShapePosX() {
        return shapePosX;
    }

    public void setShapePosX(float shapePosX) {
        this.shapePosX = shapePosX;
    }

    public float getShapePosY() {
        return shapePosY;
    }

    public void setShapePosY(float shapePosY) {
        this.shapePosY = shapePosY;
    }

    public Base(float shapePosX, float shapePosY){
        this.shapePosX = shapePosX;
        this.shapePosY = shapePosY;
        baseShape = new ShapeRenderer();
        color = Color.WHITE;
        baseRect = new Rectangle(shapePosX,shapePosY,50f,150f);

    }

    public void generateShape(){
        baseRect.setPosition(shapePosX,shapePosY);
        baseShape.begin(ShapeRenderer.ShapeType.Filled);
        baseShape.setColor(color);
        baseShape.rect(shapePosX,shapePosY,50f,150f);
        baseShape.end();
    }

    public boolean isCollided(Circle ballCircle){
        if(Intersector.overlaps(ballCircle,baseRect)){
            return true;
        }
        return false;
    }

}
