package laba1_Egov;

import java.awt.Color;
import java.awt.Graphics;

public class ElectricLocomotive extends Locomotive{

    protected final int monorailWidth = 100;
    protected final int monorailHeight = 60;
    
    public ElectricLocomotive(int maxSpeed, float weight, Color mainColor)
    {
        __MaxSpeed = maxSpeed;
        __Weight = weight;
        __MainColor = mainColor;
    }
    
	@Override
	public void Draw(Graphics g) {        
        //корпус
    	g.setColor(Color.black);    	
        g.drawLine((int)_startPosX, (int)_startPosY, (int)_startPosX + 70, (int)_startPosY);
        g.drawLine((int)_startPosX, (int)_startPosY, (int)_startPosX, (int)_startPosY + 50);
        g.drawLine((int)_startPosX, (int)_startPosY + 50, (int)_startPosX + 90, (int)_startPosY + 50);
        g.drawLine((int)_startPosX, (int)_startPosY + 45, (int)_startPosX + 90, (int)_startPosY + 45);
        //лобовое стекло
        g.drawArc((int)_startPosX + 50, (int)_startPosY, 40, 100, 90, -90);
        
        g.setColor(getMainColor());
        g.fillRect((int)_startPosX, (int)_startPosY, 70, 45);
        
        g.setColor(Color.BLUE);
        g.fillArc((int)_startPosX + 50, (int)_startPosY, 40, 90, 90, -90);
        g.fillRect((int)_startPosX + 11, (int)_startPosY + 20, 11, 10);
        g.fillRect((int)_startPosX + 44, (int)_startPosY + 20, 11, 10);
	}

	@Override
	public void MoveTransport(Direction direction) {
		float step = getMaxSpeed() * 100 / getWeight();
        switch (direction)
        {
            // вправо
            case Right:
                if (_startPosX + step < _pictureWidth - monorailWidth)
                {
                    _startPosX += step;
                }
                break;
            //влево
            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;
            //вверх
            case Up:
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;
            //вниз
            case Down:
                if (_startPosY + step < _pictureHeight - monorailHeight)
                {
                    _startPosY += step;
                }
                break;
        }		
	}

}
