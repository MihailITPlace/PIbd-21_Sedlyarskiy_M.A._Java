package laba1_Egov;

import java.awt.Color;
import java.awt.Graphics;

public class Monorail extends ElectricLocomotive{
    
    private static final int carWidth = 100;
    private static final int carHeight = 60;

    private Color __AddColor;
    
    public Color getAddColor() {
        return __AddColor;
    }

    public void setAddColor(Color value) {
        __AddColor = value;
    }
    
    private boolean __MagneticCushion;
    
    public boolean getMagneticCushion() {
        return __MagneticCushion;
    }

    public void setMagneticCushion(boolean value) {
        __MagneticCushion = value;
    }

    private boolean __BackSpoiler;
    
    public boolean getBackSpoiler() {
        return __BackSpoiler;
    }

    public void setBackSpoiler(boolean value) {
        __BackSpoiler = value;
    }

    private boolean __TopStabilizer;
    
    public boolean getTopStabilizer() {
        return __TopStabilizer;
    }

    public void setTopStabilizer(boolean value) {
    	__TopStabilizer = value;
    }
    
    private int __MaxTonnage;
    
    public int getMaxTonnage() {
        return __MaxTonnage;
    }

    public void setMaxTonnage(int value) {
    	__MaxTonnage = value;
    }
    
    public Monorail(int maxSpeed, float weight, Color mainColor, Color addColor, boolean magneticCushion, boolean backSpoiler, boolean topStabilizer, int maxTonnage) {
    	super(maxSpeed, weight, mainColor);
        __MaxSpeed = maxSpeed;
        __Weight = weight;
        __MainColor = mainColor;
        __AddColor = addColor;
        __MagneticCushion = magneticCushion;            
        __BackSpoiler = backSpoiler;
        __TopStabilizer = topStabilizer;
        __MaxTonnage = maxTonnage;
    }    
    
    @Override
    public void Draw(Graphics g) {
    	super.Draw(g);
    	
        if (getBackSpoiler())
        {
        	g.setColor(Color.black);
            g.fillRect((int)_startPosX, (int)_startPosY, 5, 50);
            g.drawRect((int)_startPosX, (int)_startPosY, 5, 50);
        }
         
        if (getTopStabilizer())
        {            
        	g.setColor(Color.MAGENTA);
            g.fillRect((int)_startPosX, (int)_startPosY, 69, 5);
            g.drawRect((int)_startPosX, (int)_startPosY, 69, 5);
        }
        
        if (getMagneticCushion())
        {
        	g.setColor(Color.black);
            g.fillRect((int)_startPosX + 70, (int)_startPosY + 45, 20, 5);
            g.drawRect((int)_startPosX + 70, (int)_startPosY + 45, 20, 5);
        }
    }
}