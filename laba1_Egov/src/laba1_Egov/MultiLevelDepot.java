package laba1_Egov;

import java.util.ArrayList;
import java.io.*;

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

    public boolean SaveData(String fileName)
    {
        try(FileWriter fr = new FileWriter(fileName)) {
            fr.write("CountLeveles:" + depotStages.size() + "\n");
            for (Depot level: depotStages) {

                fr.write("Level" + "\n");
                for (int i = 0; i < countPlaces; i++)
                {
                    ElectricLocomotive car = level[i];
                    if (car != null)
                    {
                        //если место не пустое
                        //Записываем тип поезда
                        if (car.GetType().Name == "ElectricLocomotive")
                        {
                            WriteToFile(i + ":ElectricLocomotive:", fs);
                        }
                        if (car.GetType().Name == "Monorail")
                        {
                            WriteToFile(i + ":Monorail:", fs);
                        }
                        //Записываемые параметры
                        WriteToFile(car + Environment.NewLine, fs);
                    }
                }
            }
        }
        catch(Exception ex) {

        }
    }
}
