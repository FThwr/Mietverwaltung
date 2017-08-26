package mietverwaltung;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
	
	//https://java-tutorial.org/jcombobox.html
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		MenueManager m = new MenueManager();
		// Anmeldekonten der Mitarbeiter
		m.add(new Mitarbeiter (1, "Faustmann", "Gert", "Qualle"));
//		m.add(new Mitarbeiter (2, "Tsakonas", "Felicia", "Boing"));
//		m.add(new Mitarbeiter (3, "Bebenroth", "Mandy", "Boom"));
//		m.add(new Mitarbeiter (4, "Ruhkieck", "Sophia", "Zisch"));
//		m.add(new Mitarbeiter (5, "Guhl", "Alicia", "Rumps"));
//		m.add(new Mitarbeiter (6, "Menz", "Max", "Wusch"));
//		
		m.add(new Interessent (4021, "Mustermann", "Max", new Datum(3, 9, 2012), "mustermann@web.de", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "03783476367", "Interessent" ));
		m.add(new Interessent (4022, "Mustermann", "Max", new Datum(3, 9, 2012), "mustermann@web.de", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "03783476367", "Interessent" ));
//
//		
//		//Mieter
		m.add(new Mieter (90001, "Mustermann", "Max", new Datum(3, 9, 2012), -100, "mustermann@web.de", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "03783476367", "Mieter" ));
//		m.add(new Mieter (90002, "Musterfrau", "Jana", new Datum(1, 9, 2014), -100, "musterfrau@web.de", new Adresse("Kleeweg", 23, 13357, "Berlin, Wedding"), "03783476367", "Mieter" ));
//		//		m.add(new Mieter (90002, "Jana", "Musterfrau","4.6.2002", 100, "musterfrau@web.de", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"),"898389439", "Mieter" ));
////		m.add(new Mieter (90003, "Harry", "Potter", "12.10.1997", -100, "potter@web.de", new Adresse("Kleeweg", 22, 13357, "Berlin, Wedding"), "03089653", "Mieter"));
//		
//		 //Wohnungen
		m.add(new Wohnung (301, 4, 80.60, 1100.00, 1, true, true, "Park", new Adresse ("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", new Datum(22,1,2017), 3, "Rohre neu verlegt", new Handwerkerauftrag ("") , new Mitarbeiter (6, "Menz", "Max")));
		m.add(new Wohnung (302, 6, 80.60, 1100.00, 4, true, true, "Park", new Adresse ("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", new Datum(22,1,2017), 3, "Rohre neu verlegt", new Handwerkerauftrag (""), new Mitarbeiter (2, "Tsakonas", "Felicia")));
		m.add(new Wohnung (303, 6, 80.60, 1100.00, 3, true, true, "Spree", new Adresse ("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", new Datum(22,1,2017), 3, "Rohre neu verlegt", new Handwerkerauftrag (""), new Mitarbeiter (6, "Menz", "Max")));
		m.add(new Wohnung (304, 3, 80.60, 1100.00, 1, true, true, "Schienen", new Adresse ("Kleeweg", 22, 13357, "Berlin, Wedding"), "frei", new Datum(22,1,2017), 3, "Rohre neu verlegt", new Handwerkerauftrag (""), new Mitarbeiter (2, "Tsakonas", "Felicia")));
//
//		//		
//		m.add(new Handwerkerauftrag("H-404", 303, 1, "Kaputte Wand", "in Bearbeitung", new Datum (3, 12, 2016), new Datum (0,2,2002)));
//		m.add(new Handwerkerauftrag("H-40003", 302, 1, "Kaputte Tür", "beendet", new Datum (1, 12, 2014), new Datum (0,12,2003)));
//		m.add(new Handwerkerauftrag("H-40002", 303, 2, "Kaputte Badewanne", "beendet", new Datum (1, 11, 2013), new Datum (0,2,2007)));
//		
//		
		m.add(new MenueEntry("", new String [] {"Kunde", "Wohnung", "Mitarbeiter", "Handwerkerauftrag", "Mietvertrag", "Suche"}));
		m.add(new MenueEntry("Kunde", new String [] {"Interessent", "Mieter"}));
		
		m.add(new MenueEntry("Mieter", new String [] {"ehemalige Mieter anzeigen", "aktuelle Mieter anzeigen", "Mieter bearbeiten", "Mieter suchen"}));
				m.add(new MenueEntry("Interessent", new String [] {"ehemalige Interessenten anzeigen", "aktuelle Interessenten anzeigen", "neuen Interessenten erstellen", "Interessent bearbeiten", "Interessenten suchen"}));
		m.add(new MenueEntry("Wohnung", new String [] {"Wohnung anzeigen", "neue Wohnung erstellen", "Wohnung bearbeiten", "Wohnung suchen"}));
		m.add(new MenueEntry("Mitarbeiter", new String [] {"ehemalige Mitarbeiter anzeigen", "aktuelle Mitarbeiter anzeigen", "neuen Mitarbeiter erstellen", "Mitarbeiter bearbeiten"}));
		m.add(new MenueEntry("Mietvertrag", new String [] {"abgeschlossene Mietverträge anzeigen", "aktive Mietverträge anzeigen", "Mietvertrag erstellen", "Mietvertrag bearbeiten", "Mietvertrag suchen"}));
		m.add(new MenueEntry("Handwerkerauftrag", new String [] {"fertige Handwerkeraufträge anzeigen" , "aktive Handwerkeraufträge anzeigen", "Handwerkerauftrag erstellen", "Handwerkerauftrag bearbeiten", "Handwerkerauftrag suchen"}));
		m.add(new MenueEntry("Suche", new String [] {"Suchanfrage erstellen", "Suchanfragen anzeigen"}));	

		m.add(new MenueEntry("aktuelle Mieter anzeigen", new AktuelleMieterAnzeigenAction()));
		m.add(new MenueEntry("ehemalige Mieter anzeigen", new EhemaligeMieterAnzeigenAction()));
		m.add(new MenueEntry("Mieter bearbeiten", new MieterBearbeitenAction()));
		m.add(new MenueEntry("Mieter suchen", new MieterSuchenAction()));
				
		
		m.add(new MenueEntry("aktuelle Interessenten anzeigen", new AktuelleInteressentAnzeigenAction()));
		m.add(new MenueEntry("ehemalige Interessenten anzeigen", new EhemaligeInteressentenAnzeigenAction()));
		m.add(new MenueEntry("Interessent bearbeiten", new InteressentBearbeitenAction()));
		m.add(new MenueEntry("neuen Interessenten erstellen", new InteressentErstellenAction()));
		m.add(new MenueEntry("Interessenten suchen", new InteressentSuchenAction()));
		
		
				
		
		m.add(new MenueEntry("Wohnung anzeigen", new WohnungAnzeigenAction()));
		m.add(new MenueEntry("neue Wohnung erstellen", new WohnungCreate()));
		m.add(new MenueEntry("Wohnung bearbeiten", new WohnungEdit()));
		m.add(new MenueEntry("Wohnung suchen", new WohnungSuchenAktion()));
		
		
		
		
		m.add(new MenueEntry("ehemalige Mitarbeiter anzeigen", new EhemligeMitarbeiterAnzeigenAction()));
		m.add(new MenueEntry("aktuelle Mitarbeiter anzeigen", new AktuelleMitarbeiterAnzeigenAction()));
		m.add(new MenueEntry("neuen Mitarbeiter erstellen", new MitarbeiterErstellenAction()));
		m.add(new MenueEntry("Mitarbeiter bearbeiten", new MitarbeiterBearbeitenAction()));
		
		
		
		
		m.add(new MenueEntry("Mietvertrag suchen", new MietvertragSuchenAction()));
		m.add(new MenueEntry("abgeschlossene Mietverträge anzeigen", new AbgeschlosseneMietverträgeAnzeigenAction()));
		m.add(new MenueEntry("aktive Mietverträge anzeigen", new AktuelleMietverträgeAnzeigenAction()));
		m.add(new MenueEntry("Mietvertrag erstellen", new MietvertragErstellenAction()));
		m.add(new MenueEntry("Mietvertrag bearbeiten", new MietvertragBearbeitenAction()));
		
		
		
		
		m.add(new MenueEntry("Handwerkerauftrag suchen", new HandwerkerauftragSuchenAction()));
		m.add(new MenueEntry("fertige Handwerkeraufträge anzeigen", new AbgeschlossenenHandwerkeraufträgeAnzeigenAction()));
		m.add(new MenueEntry("aktive Handwerkeraufträge anzeigen", new AktiveHandwerkeraufträgeAnzeigenAction()));
		m.add(new MenueEntry("Handwerkerauftrag erstellen", new HandwerkerauftragErstellenAction()));
		m.add(new MenueEntry("Handwerkerauftrag bearbeiten", new HandwerkerauftragBearbeitenAction()));
		
		
		
		
		m.add(new MenueEntry("Suchanfrage erstellen", new SuchanfrageWohnungSuchenAction()));
		m.add(new MenueEntry("Suchanfragen anzeigen", new SuchanfragenAnzeigenAction()));
		
		m.start();
		
	}

}
