package test;

import action.*;
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
		m.add(new Mitarbeiter(1, "Faustmann", "Gert", "Qualle"));
		m.add(new Mitarbeiter (2, "Tsakonas", "Felicia", "Boing"));
		m.add(new Mitarbeiter (3, "Bebenroth", "Mandy", "Boom"));
		m.add(new Mitarbeiter (4, "Ruhkieck", "Sophia", "Zisch"));
		m.add(new Mitarbeiter (5, "Guhl", "Alicia", "Rumps"));
		m.add(new Mitarbeiter (6, "Menz", "Max", "Wusch"));
		
//		ich denke Wohnungen, Mieter, Mitarbeiter usw. sollten sollten wir in einer separaten Testklasse erstellen und dann auch in einer Datei abspeichern (für die Persistenz) @AG
		// Wohnungen
		m.add(new Wohnung (301, 4, 80.60, 1100.00, 3, true, true, "Osten", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", "22.1.2017", 3, "Rohre neu verlegt", new Mitarbeiter (6, "Menz","Max")));
		m.add(new Wohnung (302, 4, 80.60, 1200.00, 3, true, true, "Westen", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "vermietet", "23.3.2017", 1, "Tapeten gewechselt", new Mitarbeiter (2, "Tsakonas","Felicia")));

		
		//1. Menueebene
		m.add(new MenueEntry("", new String [] {"Mieter", "Wohnung", "Handwerkerauftrag", "Mietvertrag", "Interessenten", "Suche"}));
		
		
//		Sollte es auch einen Menueeintrag "loeschen" geben??? @AG
//		Sollten die SuchenAktion in den Unterpunkte "Suche"? Wir können auch auf die Aktionen doppelt verweisen @AG
		//2. Menueebene
		m.add(new MenueEntry("Mieter", new String [] {"Mieter anzeigen", "neuen Mieter erstellen", "Mieter bearbeiten", "Mieter suchen"}));
		m.add(new MenueEntry("Wohnung", new String [] {"Wohnung anzeigen", "neue Wohnung erstellen", "Wohnung bearbeiten", "Wohnung suchen", "Handwerkeraufträge"}));
		m.add(new MenueEntry("Handwerkerauftrag", new String [] {"Handwerkerauftrag anzeigen", "neuen Handwerkerauftrag erstellen", "Handwerkerauftrag suchen", "Handwerkerauftrag bearbeiten"}));
		m.add(new MenueEntry("Mietvertrag", new String [] {"Mietvertrag anzeigen", "neuen Mietvertrag erstellen", "Mietvertrag bearbeiten", "Mietvertrag suchen"}));
		m.add(new MenueEntry("Interessenten", new String [] {"Interessent anzeigen", "neuen Interessenten erstellen", "Interessent bearbeiten", "Interessenten suchen", "Suchauftrag"}));
//		m.add(new MenueEntry("Suche", new String [] {}));	
		
		//3. Menueebene
//		m.add(new MenueEntry("Mieter anzeigen", new MieterAktion()));
//		m.add(new MenueEntry("neuen Mieter erstellen", new MieterAktion()));
//		m.add(new MenueEntry("Mieter bearbeiten", new MieterAktion()));
//		m.add(new MenueEntry("Mieter suchen", new MieterAktion()));
		
		m.add(new MenueEntry("Wohnung anzeigen", new WohnungAnzeigenAction()));
		m.add(new MenueEntry("neue Wohnung erstellen", new neueWohnungAction()));
		m.add(new MenueEntry("Wohnung bearbeiten", new WohnungBearbeitenAction()));
		m.add(new MenueEntry("Wohnung suchen", new WohnungSuchenAktion()));
//		m.add(new MenueEntry("Handwerkeraufträge", action));
//		
//		m.add(new MenueEntry("Handwerkerauftrag anzeigen", action));
//		m.add(new MenueEntry("neuen Handwerkerauftrag erstellen", action));
//		m.add(new MenueEntry("Handwerkerauftrag bearbeiten", action));
//		m.add(new MenueEntry("Handwerkerauftrag suchen", action));
		
//		m.add(new MenueEntry("Mietvertrag anzeigen", action));
//		m.add(new MenueEntry("neuen Mietvertrag erstellen", action));
//		m.add(new MenueEntry("Mietvertrag bearbeiten", action));
//		m.add(new MenueEntry("Mietvertrag suchen", action));
		
//		m.add(new MenueEntry("Interessent anzeigen", action));
//		m.add(new MenueEntry("neuen Interessenten erstellen", action));
//		m.add(new MenueEntry("Interessent bearbeiten", action));
//		m.add(new MenueEntry("Interessent suchen", action));
//		m.add(new MenueEntry("Suchauftrag", action));
		
		
		m.start();
		
	}

}
