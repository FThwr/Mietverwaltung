package mietverwaltung;

import mietverwaltung.action.HandwerkerauftragAnzeigenAction;
import mietverwaltung.action.HandwerkerauftragBearbeitenAction;
import mietverwaltung.action.HandwerkerauftragErstellenAction;
import mietverwaltung.action.HandwerkerauftragSuchenAction;
import mietverwaltung.action.InteressentAnzeigenAction;
import mietverwaltung.action.InteressentBearbeitenAction;
import mietverwaltung.action.InteressentErstellenAction;
import mietverwaltung.action.InteressentSuchenAction;
import mietverwaltung.action.MieterAnzeigenAction;
import mietverwaltung.action.MieterBearbeitenAction;
import mietverwaltung.action.MieterErstellenAction;
import mietverwaltung.action.MieterSuchenAction;
import mietverwaltung.action.MietvertragAnzeigenAction;
import mietverwaltung.action.MietvertragBearbeitenAction;
import mietverwaltung.action.MietvertragErstellenAction;
import mietverwaltung.action.MietvertragSuchenAction;
import mietverwaltung.action.MitarbeiterAnzeigenAction;
import mietverwaltung.action.MitarbeiterBearbeitenAction;
import mietverwaltung.action.MitarbeiterErstellenAction;
import mietverwaltung.action.WohnungAnzeigenAction;
import mietverwaltung.action.WohnungErstellenAction;
import mietverwaltung.action.WohnungBearbeitenAction;
import mietverwaltung.action.WohnungSuchenAction;
import mietverwaltung.menu.MenuEntry;
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

        m.add(new MenuEntry("", new String[] { "Kunde", "Wohnung", "Mitarbeiter", "Handwerkerauftrag", "Mietvertrag", "Suche" }));
        m.add(new MenuEntry("Kunde", new String[] { "Mieter", "Interessent" }));
        m.add(new MenuEntry("Wohnung", new String[] { "Wohnung anzeigen", "neue Wohnung erstellen", "Wohnung bearbeiten", "Handwerkeraufträge", "Wohnung suchen" }));
        m.add(new MenuEntry("Mitarbeiter", new String[] { "Mitarbeiter anzeigen", "neuen Mitarbeiter erstellen", "Mitarbeiter bearbeiten" }));
        m.add(new MenuEntry("Mietvertrag", new String[] { "Mietvertrag anzeigen", "Mietvertrag erstellen", "Mietvertrag bearbeiten", "Mietvertrag suchen" }));

        m.add(new MenuEntry("Handwerkerauftrag", new String[] { "Handwerkerauftrag anzeigen", "Handwerkerauftrag erstellen", "Handwerkerauftrag bearbeiten", "Handwerkerauftrag suchen" }));

        m.add(new MenuEntry("Mieter", new String[] { "Mieter anzeigen", "neuen Mieter erstellen", "Mieter bearbeiten", "Mieter suchen" }));
        m.add(new MenuEntry("Interessent", new String[] { "Interessenten anzeigen", "neuen Interessenten erstellen", "Interessent bearbeiten", "Interessenten suchen" }));

        m.add(new MenuEntry("Wohnung suchen", new WohnungSuchenAction()));
        m.add(new MenuEntry("Wohnung anzeigen", new WohnungAnzeigenAction()));
        m.add(new MenuEntry("neue Wohnung erstellen", new WohnungErstellenAction()));
        m.add(new MenuEntry("Wohnung bearbeiten", new WohnungBearbeitenAction()));
        m.add(new MenuEntry("Mieter anzeigen", new MieterAnzeigenAction()));
        m.add(new MenuEntry("Mieter bearbeiten", new MieterBearbeitenAction()));
        m.add(new MenuEntry("neuen Mieter erstellen", new MieterErstellenAction()));
        m.add(new MenuEntry("Mieter suchen", new MieterSuchenAction()));
        m.add(new MenuEntry("Interessenten anzeigen", new InteressentAnzeigenAction()));
        m.add(new MenuEntry("Interessent bearbeiten", new InteressentBearbeitenAction()));
        m.add(new MenuEntry("neuen Interessenten erstellen", new InteressentErstellenAction()));
        m.add(new MenuEntry("Interessenten suchen", new InteressentSuchenAction()));
        m.add(new MenuEntry("Mitarbeiter anzeigen", new MitarbeiterAnzeigenAction()));
        m.add(new MenuEntry("neuen Mitarbeiter erstellen", new MitarbeiterErstellenAction()));
        m.add(new MenuEntry("Mitarbeiter bearbeiten", new MitarbeiterBearbeitenAction()));
        m.add(new MenuEntry("Handwerkerauftrag suchen", new HandwerkerauftragSuchenAction()));
        m.add(new MenuEntry("Handwerkerauftrag anzeigen", new HandwerkerauftragAnzeigenAction()));
        m.add(new MenuEntry("Handwerkerauftrag erstellen", new HandwerkerauftragErstellenAction()));
        m.add(new MenuEntry("Handwerkerauftrag bearbeiten", new HandwerkerauftragBearbeitenAction()));
        m.add(new MenuEntry("Mietvertrag suchen", new MietvertragSuchenAction()));
        m.add(new MenuEntry("Mietvertrag anzeigen", new MietvertragAnzeigenAction()));
        m.add(new MenuEntry("Mietvertrag erstellen", new MietvertragErstellenAction()));
        m.add(new MenuEntry("Mietvertrag bearbeiten", new MietvertragBearbeitenAction()));

        //		m.add(new MenueEntry("Kiefer", new HalloAktion()));
        m.start();

    }

}
