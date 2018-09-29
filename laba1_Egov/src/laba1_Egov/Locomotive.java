package laba1_Egov;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Locomotive implements ITransport {
    protected float _startPosX;

    protected float _startPosY;

    protected int _pictureWidth;

    protected int _pictureHeight;

    public int __MaxSpeed;
    
    public int getMaxSpeed() {
        return __MaxSpeed;
    }

    public void setMaxSpeed(int value) {
    	__MaxSpeed = value;
    }

    public float __Weight;
    
    public float getWeight() {
        return __Weight;
    }

    public void setWeight(float value) {
    	__Weight = value;
    }

    public Color __MainColor;
    
    public Color getMainColor() {
        return __MainColor;
    }

    public void setMainColor(Color value) {
    	__MainColor = value;
    }

    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }

    public abstract void Draw(Graphics g);

    public abstract void MoveTransport(Direction direction);
}

