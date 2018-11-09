package laba1_Egov;

import javax.swing.*;
import java.awt.*;

public class JPanelDepot extends JPanel {
    private MultiLevelDepot depot;
    private JList list;

    public void setDepot(MultiLevelDepot depot)
    {
        this.depot = depot;
    }
    public void setList(JList list)
    {
        this.list = list;
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        try {
            if (depot != null) {
                if (list.getSelectedIndex() != -1 ) {
                    depot.getAt(list.getSelectedIndex()).Draw(g);
                }
            }
        }
        catch(Exception ex){

        }
    }
}
