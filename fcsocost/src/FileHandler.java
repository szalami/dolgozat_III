/*
 * Sallai András, 2024-02-19
 * Copyright (c) 2024, Sallai András
 * Licenc: MIT
 * Refaktorálás: Faragó Csaba, 2024-02-25
 */

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements DataStorage {
    private FileWriter fw;
    private String fileName = "adat.txt";

    public void writeData(Cost cost) {
        try {
            tryWriteData(cost);
        } catch (IOException e) {
            System.err.println("Hiba!");
            System.err.println(e.getMessage());
        }
    }

    public void tryWriteData(Cost cost) throws IOException {
        fw = new FileWriter(fileName, true);
        fw.write(createRow("Szállítási költség", cost.transport));
        fw.write(createRow("Üzleti költség", cost.business));
        fw.write(createRow("Javítási költség", cost.repair));
        fw.close();
    }

    public String createRow(String txt, Double num) {
        return (txt + ": " + num.toString() + "$\n");
    }
}
