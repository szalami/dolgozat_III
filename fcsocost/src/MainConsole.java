/*
 * Sallai András, 2024-02-19
 * Copyright (c) 2024, Sallai András
 * Licenc: MIT
 * Refaktorálás: Faragó Csaba, 2024-02-25
 */

import java.util.Scanner;

public class MainConsole extends Cost {

    private Scanner scanner;

    public MainConsole() {
        drawHeader();
        try (Scanner scanner = new Scanner(System.in)) {
            this.scanner = scanner;
            startInput();
        }

        Cost cost = new Cost(transport, business, repair);

        FileHandler filehandler = new FileHandler();
        filehandler.writeData(cost);

        // Ha adatbázisba is mentünk akkor ezt használjuk
        // DbHandler dbhandler = new DbHandler();
        // dbhandler.writeData(cost);
    }

    private void drawHeader() {
        System.out.println("╔═════════════════════════════════════════╗");
        System.out.printf("║%17s%25s\n", "Projekt költsége", "║");
        System.out.println("╚═════════════════════════════════════════╝");
    }

    private void startInput() {
        transport = Double.parseDouble(input("Szállítási költség: "));
        business = Double.parseDouble(input("Üzleti költség: "));
        repair = Double.parseDouble(input("Javítási költség: "));
    }

    private String input(String txt) {
        System.out.println("──────────────────────────────────────────");
        System.out.print(txt);
        String inData = scanner.nextLine();
        return inData;

    }
}
