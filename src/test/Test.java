package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import hilfsklassen.Adresse;
import menu.MenuManager;
import objekte.Mitarbeiter;
import objekte.Wohnung;

/*
 *
 * mehrere Testklassen für unterschiedliche Testszenarien sind empfehlenswert @AG
 */
public class Test {

    public static void main(final String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {

        // MenuManager m = new MenuManager();

        MenuManager m;
        try {
            m = MenuManager.laden();
        } catch (FileNotFoundException e) {
            m = generieren();
            MenuManager.speichern();
        }
        //MenuManager.speichern();
        m.start();
    }

    private static MenuManager generieren() {
        MenuManager m = new MenuManager();

        // Anmeldekonten der Mitarbeiter
        m.add(new Mitarbeiter(1, "Faustmann", "Gert", "Qualle"));
        m.add(new Mitarbeiter(2, "Tsakonas", "Felicia", "Boing"));
        m.add(new Mitarbeiter(3, "Bebenroth", "Mandy", "Boom"));
        m.add(new Mitarbeiter(4, "Ruhkieck", "Sophia", "Zisch"));
        m.add(new Mitarbeiter(5, "Guhl", "Alicia", "Rumps"));
        m.add(new Mitarbeiter(6, "Menz", "Max", "Wusch"));

        //		ich denke Wohnungen, Mieter, Mitarbeiter usw. sollten sollten wir in einer separaten Testklasse erstellen und dann auch in einer Datei abspeichern (für die Persistenz) @AG
        // Wohnungen
        m.add(new Wohnung(301, 4, 80.60, 1100.00, 3, true, true, "Osten", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", "22.1.2017", 3, "Rohre neu verlegt", new Mitarbeiter(6, "Menz", "Max")));
        m.add(new Wohnung(302, 4, 80.60, 1200.00, 3, true, true, "Westen", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "vermietet", "23.3.2017", 1, "Tapeten gewechselt", new Mitarbeiter(2, "Tsakonas", "Felicia")));

        m.start();
        return m;
    }

}
