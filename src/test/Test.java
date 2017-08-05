package test;

import action.MieterAktion;
import hilfsklassen.Adresse;
import menue.MenueEntry;
import menue.MenueManager;
import objekte.*;

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
		
//		ich denke Wohnungen, Mieter, Mitarbeiter usw. sollten sollten wir in einer separaten Testklasse erstellen und dann auch in einer Datei abspeichern (für die Persistenz) @AG
		// Wohnungen
		m.add(new Wohnung (301, 4, 80.60, 1100.00, 3, true, true, "Osten", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", "22.1.2017", 3, "Rohre neu verlegt", new Mitarbeiter ("Max")));
		m.add(new Wohnung (302, 4, 80.60, 1200.00, 3, true, true, "Westen", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "vermietet", "23.3.2017", 1, "Tapeten gewechselt", new Mitarbeiter ("Felicia")));

		
		//1. Menueebene
		m.add(new MenueEntry("", new String [] {"Mieter", "Wohnung", "Handwerkerauftrag", "Mietvertrag", "Interessenten", "Suche"}));
		
		
//		Sollte es auch einen Menueeintrag "loeschen" geben??? @AG
		//2. Menueebene
		m.add(new MenueEntry("Mieter", new String [] {"Mieter anzeigen", "neuen Mieter erstellen", "Mieter bearbeiten", "Mieter suchen"}));
		m.add(new MenueEntry("Wohnung", new String [] {"Wohnung anzeigen", "neue Wohnung erstellen", "Wohnung bearbeiten", "Handwerkeraufträge"}));
		m.add(new MenueEntry("Handwerkerauftrag", new String [] {"Handwerkerauftrag anzeigen", "neuen Handwerkerauftrag erstellen", "Handwerkerauftrag bearbeiten"}));
		m.add(new MenueEntry("Mietvertrag", new String [] {"Mietvertrag anzeigen", "neuen Mietvertrag erstellen", "Mietvertrag bearbeiten"}));
		m.add(new MenueEntry("Interessenten", new String [] {"Interessent anzeigen", "neuen Interessenten erstellen", "Interessent bearbeiten", "Suchauftrag"}));
		m.add(new MenueEntry("Suche", new String [] {}));
		
		//3. Menueebene
		m.add(new MenueEntry("Mieter anzeigen", new MieterAktion()));
		m.add(new MenueEntry("neuen Mieter erstellen", new MieterAktion()));
		m.add(new MenueEntry("Mieter bearbeiten", new MieterAktion()));
		m.add(new MenueEntry("Mieter suchen", new MieterAktion()));
		
		//Aktionen müssten noch erstellt werden @AG
//		m.add(new MenueEntry("Wohnung anzeigen", action));
//		m.add(new MenueEntry("neue Wohnung erstellen", action));
//		m.add(new MenueEntry("Wohnung bearbeiten", action));
//		m.add(new MenueEntry("Handwerkeraufträge", action));
//		
//		m.add(new MenueEntry("Handwerkerauftrag anzeigen", action));
//		m.add(new MenueEntry("neuen Handwerkerauftrag erstellen", action));
//		m.add(new MenueEntry("Handwerkerauftrag bearbeiten", action));
//		
//		m.add(new MenueEntry("Mietvertrag anzeigen", action));
//		m.add(new MenueEntry("neuen Mietvertrag erstellen", action));
//		m.add(new MenueEntry("Mietvertrag bearbeiten", action));
//		
//		m.add(new MenueEntry("Interessent anzeigen", action));
//		m.add(new MenueEntry("neuen Interessenten erstellen", action));
//		m.add(new MenueEntry("Interessent bearbeiten", action));
//		m.add(new MenueEntry("Suchauftrag", action));
		
		
		m.start();
		
	}

}
