package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import hilfsklassen.Adresse;
import hilfsklassen.Datum;
import menu.MenuManager;
import objekte.Handwerkerauftrag;
import objekte.Interessent;
import objekte.Mieter;
import objekte.Mitarbeiter;
import objekte.Wohnung;

/*
 *
 * mehrere Testklassen für unterschiedliche Testszenarien sind empfehlenswert @AG
 */
public class Test {

    public static void main(final String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {

        // MenuManager m = new MenuManager();

//    	new File("..\\menumanager.dat").delete();

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

    private static MenuManager generieren() throws FileNotFoundException, ClassNotFoundException, IOException {
        MenuManager m = new MenuManager();
        // Anmeldekonten der Mitarbeiter
        
        Mitarbeiter mFaustmann = new Mitarbeiter(1, "Faustmann", "Gert", "Qualle");
        Mitarbeiter mTsakonas = new Mitarbeiter(2, "Tsakonas", "Felicia", "Boing");
        Mitarbeiter mBebenroth = new Mitarbeiter(3, "Bebenroth", "Mandy", "Boom");
        Mitarbeiter mRuhkieck = new Mitarbeiter(4, "Ruhkieck", "Sophia", "Zisch");
        Mitarbeiter mGuhl = new Mitarbeiter(5, "Guhl", "Alicia", "Rumps");
        Mitarbeiter mMenz = new Mitarbeiter(6, "Menz", "Max", "Wusch");
        m.add(mFaustmann);
        m.add(mTsakonas);
        m.add(mBebenroth);
        m.add(mRuhkieck);
        m.add(mGuhl);
        m.add(mMenz);

        m.add(new Interessent(4021, "Mustermann", "Max", new Datum(3, 9, 2012), new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "mustermann@web.de", "03783476367", "Interessent"));
        m.add(new Interessent(4022, "Mustermann", "Max", new Datum(3, 9, 2012), new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "mustermann@web.de", "03783476367", "Interessent"));
        //
        //
        //      //Mieter
              m.add(new Mieter (90001, "Mustermann", "Max", new Datum(3, 9, 2012), -100, "mustermann@web.de", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "03783476367", "Mieter" ));
              m.add(new Mieter (90002, "Musterfrau", "Jana", new Datum(1, 9, 2014), -100, "musterfrau@web.de", new Adresse("Kleeweg", 23, 13357, "Berlin, Wedding"), "03783476367", "Mieter" ));
//              m.add(new Mieter (90002, "Jana", "Musterfrau","4.6.2002", 100, "musterfrau@web.de", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"),"898389439", "Mieter" ));
//              m.add(new Mieter (90003, "Harry", "Potter", "12.10.1997", -100, "potter@web.de", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "03089653", "Mieter"));
        //
        //       //Wohnungen
        m.add(new Wohnung(301, 4, 80.60, 1100.00, 1, true, true, "Park", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", new Datum(22, 1, 2017), 3, "Rohre neu verlegt", new Handwerkerauftrag(""), mMenz));
        m.add(new Wohnung(302, 6, 80.60, 1100.00, 4, true, true, "Park", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", new Datum(22, 1, 2017), 3, "Rohre neu verlegt", new Handwerkerauftrag(""), mTsakonas));
        m.add(new Wohnung(303, 6, 80.60, 1100.00, 3, true, true, "Spree", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", new Datum(22, 1, 2017), 3, "Rohre neu verlegt", new Handwerkerauftrag(""), mMenz));
        m.add(new Wohnung(304, 3, 80.60, 1100.00, 1, true, true, "Schienen", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", new Datum(22, 1, 2017), 3, "Rohre neu verlegt", new Handwerkerauftrag(""), mTsakonas));
        //
        //      
//              m.add(new Handwerkerauftrag("H-404", 303, 1, "Kaputte Wand", "in Bearbeitung", new Datum (3, 12, 2016), new Datum (0,2,2002)));
//              m.add(new Handwerkerauftrag("H-40003", 302, 1, "Kaputte Tür", "beendet", new Datum (1, 12, 2014), new Datum (0,12,2003)));
//              m.add(new Handwerkerauftrag("H-40002", 303, 2, "Kaputte Badewanne", "beendet", new Datum (1, 11, 2013), new Datum (0,2,2007)));
        //
        //
        m.start();

        return m;
    }

}
