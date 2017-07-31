package test;

import action.MieterAktion;
import all.*;
import menue.MenueEntry;
import menue.MenueManager;

/*
 * 
 * mehrere Testklassen für unterschiedliche Testszenarien sind empfehlenswert @AG
 */
public class Test {
	
	public static void main(String[] args) {
		
		MenueManager m = new MenueManager();
		// Anmeldekonten der Mitarbeiter
		m.add(new Mitarbeiter ("Qualle", "Herr Faustmann"));
		m.add(new Mitarbeiter ("Boing", "Felicia"));
		m.add(new Mitarbeiter ("Boom", "Mandy"));
		m.add(new Mitarbeiter ("Zisch", "Sophia"));
		m.add(new Mitarbeiter ("Rumps", "Alicia"));
		m.add(new Mitarbeiter ("Wusch", "Max"));
		
		// Wohnungen
		m.add(new Wohnung (301, 4, 80.60, 1100.00, 3, true, true, "Osten", " Kleeweg Nr 22, 13357 Berlin, Wedding", "frei", "22.1.2017", 3, "Rohre neu verlegt", new Mitarbeiter ("Max")));
		m.add(new Wohnung (302, 4, 80.60, 1200.00, 3, true, true, "Westen", " Kleeweg Nr 22, 13357 Berlin, Wedding", "vermietet", "23.3.2017", 1, "Tapeten gewechselt", new Mitarbeiter ("Felicia")));
//		m.add(new Wohnung (6, 106, 1600, 3, true, "Süden"));
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
		
		
		m.add(new MenueEntry("", new String [] {"Mieter", "Wohnung", "Handwerkerauftrag", "Mietvertrag", "Interessenten", "Suche"}));
		m.add(new MenueEntry("Mieter", new String [] {"Mieter anzeigen", "neuen Mieter erstellen", "Mieter bearbeiten", "Mieter suchen"}));
		m.add(new MenueEntry("Mieter anzeigen", new MieterAktion()));
		m.add(new MenueEntry("Wohnung", new String [] {"Wohnung anzeigen", "neue Wohnung erstellen", "Wohnung bearbeiten", "Handwerkeraufträge", "Buche", "Trauerweide"}));
		m.add(new MenueEntry("Nadelbäume", new String [] {"Tanne", "Kiefer"}));
		
		m.add(new MenueEntry("Wohnung anzeigen", new MieterAktion()));
//		m.add(new MenueEntry("Kastanie", new HalloAktion()));
//		m.add(new MenueEntry("Ahorn", new IchBinAktion()));
//		m.add(new MenueEntry("Birke", new HalloAktion()));
//		m.add(new MenueEntry("Buche", new IchBinAktion()));
//		m.add(new MenueEntry("Trauerweide", new HalloAktion()));
//		m.add(new MenueEntry("Tanne", new IchBinAktion()));
//		m.add(new MenueEntry("Kiefer", new HalloAktion()));
		m.start();
		
	}

}
