package mietverwaltung;

import java.io.FileNotFoundException;
import java.io.IOException;

import mietverwaltung.menu.MenuManager;

public class Test {

    //https://java-tutorial.org/jcombobox.html

    public static void main(final String[] args) throws IOException {

        //MenuManager m = generieren();
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

        m.add(new Interessent(4021, "Mustermann", "Max", new Datum(3, 9, 2012), "mustermann@web.de", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "03783476367", "Interessent"));
        m.add(new Interessent(4022, "Mustermann", "Max", new Datum(3, 9, 2012), "mustermann@web.de", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "03783476367", "Interessent"));

        //Mieter
        m.add(new Mieter(90001, "Mustermann", "Max", new Datum(3, 9, 2012), -100, "mustermann@web.de", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "03783476367", "Mieter"));
        m.add(new Mieter(90002, "Musterfrau", "Jana", new Datum(1, 9, 2014), -100, "musterfrau@web.de", new Adresse("Kleeweg", 23, 13357, "Berlin, Wedding"), "03783476367", "Mieter"));
        //      m.add(new Mieter (90002, "Jana", "Musterfrau","4.6.2002", 100, "musterfrau@web.de", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"),"898389439", "Mieter" ));
        //      m.add(new Mieter (90003, "Harry", "Potter", "12.10.1997", -100, "potter@web.de", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "03089653", "Mieter"));

        //Wohnungen
        //      m.add(new Wohnung (301, 4, 80.60, 1100.00, 1, true, true, "Park", new Adresse ("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", new Datum(22,1,2017), 3, "Rohre neu verlegt", new Handwerkerauftrag ("") , new Mitarbeiter (6, "Menz", "Max")));
        //      m.add(new Wohnung (302, 6, 80.60, 1100.00, 4, true, true, "Park", new Adresse ("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", new Datum(22,1,2017), 3, "Rohre neu verlegt", new Handwerkerauftrag (""), new Mitarbeiter (2, "Tsakonas", "Felicia")));
        //      m.add(new Wohnung (303, 6, 80.60, 1100.00, 3, true, true, "Spree", new Adresse ("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", new Datum(22,1,2017), 3, "Rohre neu verlegt", new Handwerkerauftrag (""), new Mitarbeiter (6, "Menz", "Max")));
        //      m.add(new Wohnung (304, 3, 80.60, 1100.00, 1, true, true, "Schienen", new Adresse ("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", new Datum(22,1,2017), 3, "Rohre neu verlegt", new Handwerkerauftrag (""), new Mitarbeiter (2, "Tsakonas", "Felicia")));

        return m;
    }

}
