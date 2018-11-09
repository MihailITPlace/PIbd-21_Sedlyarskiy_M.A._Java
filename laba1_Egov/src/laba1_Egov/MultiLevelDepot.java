package laba1_Egov;

import java.util.ArrayList;

public class MultiLevelDepot {
    ArrayList<Depot<ITransport>> depotStages;

    private final int countPlaces = 20;

    public MultiLevelDepot(int countStages, int pictureWidth, int pictureHeight) {
        depotStages = new ArrayList<Depot<ITransport>>();
        for (int i = 0; i < countStages; ++i)
        {
            depotStages.add(new Depot<ITransport>(countPlaces, pictureWidth, pictureHeight));
        }
    }

    public Depot<ITransport> getAt(int index) {
        if (index > -1 && index < depotStages.size()) {
            return depotStages.get(index);
        }

        return null;
    }
}
