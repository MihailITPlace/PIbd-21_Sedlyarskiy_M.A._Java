package laba1_Egov;

import javax.swing.*;
import java.awt.*;

public class JPanelDepot extends JPanel {
    private Depot<ITransport> depot;

    public void setDepot(Depot depot)
    {
        this.depot = depot;
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        try {
            if (depot != null) {
                depot.Draw(g);
            }
        }
        catch(Exception ex){

        }
    }
}
