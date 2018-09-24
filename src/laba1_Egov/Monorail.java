package laba1_Egov;

import java.awt.Color;
import java.awt.Graphics;

public class Monorail   
{
    private float _startPosX;
    private float _startPosY;
    private int _pictureWidth;
    private int _pictureHeight;
    
    // Ширина отрисовки автомобиля
    
    private static final int carWidth = 100;
    
    // Ширина отрисовки автомобиля
    
    private static final int carHeight = 60;
    private int __MaxSpeed;
    public int getMaxSpeed() {
        return __MaxSpeed;
    }

    public void setMaxSpeed(int value) {
        __MaxSpeed = value;
    }

    private float __Weight;
    public float getWeight() {
        return __Weight;
    }

    public void setWeight(float value) {
        __Weight = value;
    }

    private Color __MainColor;
    public Color getMainColor() {
        return __MainColor;
    }

    public void setMainColor(Color value) {
        __MainColor = value;
    }

    private Color __AddColor;
    public Color getAddColor() {
        return __AddColor;
    }

    public void setAddColor(Color value) {
        __AddColor = value;
    }

    private boolean __FrontSpoiler;
    public boolean getFrontSpoiler() {
        return __FrontSpoiler;
    }

    public void setFrontSpoiler(boolean value) {
        __FrontSpoiler = value;
    }

    /**
    * Признак наличия заднего спойлера
    */
    private boolean __BackSpoiler;
    public boolean getBackSpoiler() {
        return __BackSpoiler;
    }

    public void setBackSpoiler(boolean value) {
        __BackSpoiler = value;
    }

    public Monorail(int maxSpeed, float weight, Color mainColor, Color addColor, boolean frontSpoiler, boolean backSpoiler) throws Exception {
        setMaxSpeed(maxSpeed);
        setWeight(weight);
        setMainColor(mainColor);
        setAddColor(addColor);
        setFrontSpoiler(frontSpoiler);
        setBackSpoiler(backSpoiler);
    }

    public void setPosition(int x, int y, int width, int height) throws Exception {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }

    public void moveMonorail(Direction direction) throws Exception {
        float step = getMaxSpeed() * 100 / getWeight();
        switch(direction)
        {
            case Right: 
                // вправо
                if (_startPosX + step < _pictureWidth - carWidth)
                {
                    _startPosX += step;
                }
                 
                break;
            case Left: 
                //влево
                if (_startPosX - step > 5)
                {
                    _startPosX -= step;
                }
                 
                break;
            case Up: 
                //вверх
                if (_startPosY - step > 30)
                {
                    _startPosY -= step;
                }
                 
                break;
            case Down: 
                //вниз
                if (_startPosY + step < _pictureHeight - carHeight)
                {
                    _startPosY += step;
                }
                 
                break;
        
        }
    }

    public void drawMonorail(Graphics g) throws Exception {
        //Pen pen = new Pen(Color.Black);
        // отрисуем сперва передний спойлер автомобиля (чтобы потом отрисовка автомобиля на него "легла")
        //корпус
    	g.setColor(Color.black);    	
        g.drawLine((int)_startPosX, (int)_startPosY, (int)_startPosX + 70, (int)_startPosY);
        g.drawLine((int)_startPosX, (int)_startPosY, (int)_startPosX, (int)_startPosY + 50);
        g.drawLine((int)_startPosX, (int)_startPosY + 50, (int)_startPosX + 90, (int)_startPosY + 50);
        g.drawLine((int)_startPosX, (int)_startPosY + 45, (int)_startPosX + 90, (int)_startPosY + 45);
        //лобовое стекло
        g.drawArc((int)_startPosX + 50, (int)_startPosY, 40, 100, 90, -90);
        //Brush brMain = new SolidBrush(getMainColor());
        
        g.setColor(getMainColor());
        g.fillRect((int)_startPosX, (int)_startPosY, 70, 45);
        //Brush brAdd = new SolidBrush(getAddColor());
        g.setColor(getAddColor());
        g.fillRect((int)_startPosX, (int)_startPosY + 45, 90, 5);
        //окна и лобовое стекло
        //Brush brAqua = new SolidBrush(Color.Aqua);
        
        g.setColor(Color.BLUE);
        g.fillArc((int)_startPosX + 50, (int)_startPosY, 40, 90, 90, -90);
        g.fillRect((int)_startPosX + 11, (int)_startPosY + 20, 11, 10);
        g.fillRect((int)_startPosX + 44, (int)_startPosY + 20, 11, 10);
        
        if (getBackSpoiler())
        {
            //Brush spoiler = new SolidBrush(Color.Black);
        	g.setColor(Color.black);
            g.fillRect((int)_startPosX, (int)_startPosY, 5, 50);
            g.drawRect((int)_startPosX, (int)_startPosY, 5, 50);
        }
         
        if (getFrontSpoiler())
        {
            //Brush spoiler = new SolidBrush(Color.Coral);
        	g.setColor(Color.black);
            g.fillRect((int)_startPosX + 70, (int)_startPosY + 45, 20, 5);
            g.drawRect((int)_startPosX + 70, (int)_startPosY + 45, 20, 5);
        }
         
    }

}