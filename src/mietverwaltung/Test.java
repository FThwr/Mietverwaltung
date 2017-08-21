package mietverwaltung;

import mietverwaltung.menu.MenuManager;

public class Test {

    //https://java-tutorial.org/jcombobox.html

    public static void main(final String[] args) {

        MenuManager m = new MenuManager();
        // Anmeldekonten der Mitarbeiter
        m.add(new Mitarbeiter(1, "Faustmann", "Gert", "Qualle"));
        m.add(new Mitarbeiter(2, "Tsakonas", "Felicia", "Boing"));
        m.add(new Mitarbeiter(3, "Bebenroth", "Mandy", "Boom"));
        m.add(new Mitarbeiter(4, "Ruhkieck", "Sophia", "Zisch"));
        m.add(new Mitarbeiter(5, "Guhl", "Alicia", "Rumps"));
        m.add(new Mitarbeiter(6, "Menz", "Max", "Wusch"));

        //Mieter
        m.add(new Mieter(90001, "Mustermann", "Max", new Datum(3, 9, 2012), -100, "mustermann@web.de", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "03783476367", "Mieter"));
        m.add(new Mieter(90002, "Musterfrau", "Jana", new Datum(1, 9, 2014), -100, "musterfrau@web.de", new Adresse("Kleeweg", 23, 13357, "Berlin, Wedding"), "03783476367", "Mieter"));
        //		m.add(new Mieter (90002, "Jana", "Musterfrau","4.6.2002", 100, "musterfrau@web.de", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"),"898389439", "Mieter" ));
        //		m.add(new Mieter (90003, "Harry", "Potter", "12.10.1997", -100, "potter@web.de", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "03089653", "Mieter"));

        //Wohnungen
        m.add(new Wohnung(301, 4, 80.60, 1100.00, 1, true, true, "Osten", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", new Datum(22, 1, 2017), 3, "Rohre neu verlegt", new Handwerkerauftrag(""), new Mitarbeiter(6, "Menz", "Max")));
        m.add(new Wohnung(302, 5, 80.60, 1100.00, 2, true, true, "Osten", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", new Datum(22, 1, 2017), 3, "Rohre neu verlegt", new Handwerkerauftrag(""), new Mitarbeiter(2, "Tsakonas", "Felicia")));
        m.add(new Wohnung(303, 4, 80.60, 1100.00, 3, true, true, "Osten", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", new Datum(22, 1, 2017), 3, "Rohre neu verlegt", new Handwerkerauftrag(""), new Mitarbeiter(6, "Menz", "Max")));
        m.add(new Wohnung(304, 3, 80.60, 1100.00, 4, true, true, "Osten", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", new Datum(22, 1, 2017), 3, "Rohre neu verlegt", new Handwerkerauftrag(""), new Mitarbeiter(2, "Tsakonas", "Felicia")));

        //
        m.add(new Handwerkerauftrag("H-404", 303, 1, "Kaputte Wand", "in Arbeit", new Datum(3, 12, 2016), new Datum(0, 0, 0)));
        m.add(new Handwerkerauftrag("H-40003", 302, 1, "Kaputte Tür", "fertig", new Datum(1, 12, 2014), new Datum(0, 0, 0)));
        m.add(new Handwerkerauftrag("H-40002", 303, 2, "Kaputte Badewanne", "fertig", new Datum(1, 11, 2013), new Datum(0, 0, 0)));

        //		m.add(new Wohnung (1, 31, 650, 2, true, "Westen"));
        //		m.add(new Wohnung (1, 31, 650, 2, true, "Westen"));
        //		m.add(new Wohnung (1, 31, 650, 2, true, "Westen"));
        //		m.add(new Wohnung (1, 31, 650, 2, true, "Westen"));
        //		m.add(new Wohnung (1, 31, 650, 2, true, "Westen"));
        //		m.add(new Wohnung (2, 51, 700, 2, true, "Osten"));
        //		m.add(new Wohnung (2, 51, 700, 2, true, "Osten"));
        //		m.add(new Wohnung (2, 51, 700, 2, true, "Osten"));
        //		m.add(new Wohnung (1, 31, 550, 1, true, "Westen"));
        //		m.add(new Wohnung (1, 31, 550, 1, true, "Westen"));
        //		m.add(new Wohnung (1, 31, 550, 1, true, "Westen"));
        //		m.add(new Wohnung (1, 31, 550, 1, true, "Westen"));
        //		m.add(new Wohnung (1, 31, 550, 1, true, "Westen"));
        //		m.add(new Wohnung (2, 51, 600, 1, true, "Osten"));
        //		m.add(new Wohnung (2, 51, 600, 1, true, "Osten"));
        //		m.add(new Wohnung (2, 51, 600, 1, true, "Osten"));

        //		m.add(new MenueEntry("Kiefer", new HalloAktion()));
        m.start();

    }

}
