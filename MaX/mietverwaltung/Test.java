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
		m.add(new MenuEntry("", new String [] {"Kunde", "Wohnung", "Mitarbeiter", "Handwerkerauftrag", "Mietvertrag", "Suche"}));
		m.add(new MenuEntry("Kunde", new String [] {"Interessent", "Mieter"}));
		
		m.add(new MenuEntry("Mieter", new String [] {"ehemalige Mieter anzeigen", "aktuelle Mieter anzeigen", "Mieter bearbeiten", "Mieter suchen"}));
				m.add(new MenuEntry("Interessent", new String [] {"ehemalige Interessenten anzeigen", "aktuelle Interessenten anzeigen", "neuen Interessenten erstellen", "Interessent bearbeiten", "Interessenten suchen"}));
		m.add(new MenuEntry("Wohnung", new String [] {"Wohnung anzeigen", "neue Wohnung erstellen", "Wohnung bearbeiten", "Wohnung suchen"}));
		m.add(new MenuEntry("Mitarbeiter", new String [] {"ehemalige Mitarbeiter anzeigen", "aktuelle Mitarbeiter anzeigen", "neuen Mitarbeiter erstellen", "Mitarbeiter bearbeiten"}));
		m.add(new MenuEntry("Mietvertrag", new String [] {"abgeschlossene Mietverträge anzeigen", "aktive Mietverträge anzeigen", "Mietvertrag erstellen", "Mietvertrag bearbeiten", "Mietvertrag suchen"}));
		m.add(new MenuEntry("Handwerkerauftrag", new String [] {"fertige Handwerkeraufträge anzeigen" , "aktive Handwerkeraufträge anzeigen", "Handwerkerauftrag erstellen", "Handwerkerauftrag bearbeiten", "Handwerkerauftrag suchen"}));
		m.add(new MenuEntry("Suche", new String [] {"Suchanfrage erstellen", "Suchanfragen anzeigen"}));	

		m.add(new MenuEntry("aktuelle Mieter anzeigen", new AktuelleMieterAnzeigenAction()));
		m.add(new MenuEntry("ehemalige Mieter anzeigen", new EhemaligeMieterAnzeigenAction()));
		m.add(new MenuEntry("Mieter bearbeiten", new MieterBearbeitenAction()));
		m.add(new MenuEntry("Mieter suchen", new MieterSuchenAction()));
				
		
		m.add(new MenuEntry("aktuelle Interessenten anzeigen", new AktuelleInteressentAnzeigenAction()));
		m.add(new MenuEntry("ehemalige Interessenten anzeigen", new EhemaligeInteressentenAnzeigenAction()));
		m.add(new MenuEntry("Interessent bearbeiten", new InteressentBearbeitenAction()));
		m.add(new MenuEntry("neuen Interessenten erstellen", new InteressentErstellenAction()));
		m.add(new MenuEntry("Interessenten suchen", new InteressentSuchenAction()));
		
		
				
		
		m.add(new MenuEntry("Wohnung anzeigen", new WohnungAnzeigenAction()));
		m.add(new MenuEntry("neue Wohnung erstellen", new WohnungCreate()));
		m.add(new MenuEntry("Wohnung bearbeiten", new WohnungEdit()));
		m.add(new MenuEntry("Wohnung suchen", new WohnungSuchenAktion()));
		
		
		
		
		m.add(new MenuEntry("ehemalige Mitarbeiter anzeigen", new EhemligeMitarbeiterAnzeigenAction()));
		m.add(new MenuEntry("aktuelle Mitarbeiter anzeigen", new AktuelleMitarbeiterAnzeigenAction()));
		m.add(new MenuEntry("neuen Mitarbeiter erstellen", new MitarbeiterErstellenAction()));
		m.add(new MenuEntry("Mitarbeiter bearbeiten", new MitarbeiterBearbeitenAction()));
		
		
		
		
		m.add(new MenuEntry("Mietvertrag suchen", new MietvertragSuchenAction()));
		m.add(new MenuEntry("abgeschlossene Mietverträge anzeigen", new AbgeschlosseneMietverträgeAnzeigenAction()));
		m.add(new MenuEntry("aktive Mietverträge anzeigen", new AktuelleMietverträgeAnzeigenAction()));
		m.add(new MenuEntry("Mietvertrag erstellen", new MietvertragErstellenAction()));
		m.add(new MenuEntry("Mietvertrag bearbeiten", new MietvertragBearbeitenAction()));
		
		
		
		
		m.add(new MenuEntry("Handwerkerauftrag suchen", new HandwerkerauftragSuchenAction()));
		m.add(new MenuEntry("fertige Handwerkeraufträge anzeigen", new AbgeschlossenenHandwerkeraufträgeAnzeigenAction()));
		m.add(new MenuEntry("aktive Handwerkeraufträge anzeigen", new AktiveHandwerkeraufträgeAnzeigenAction()));
		m.add(new MenuEntry("Handwerkerauftrag erstellen", new HandwerkerauftragErstellenAction()));
		m.add(new MenuEntry("Handwerkerauftrag bearbeiten", new HandwerkerauftragBearbeitenAction()));
		
		
		
		
		m.add(new MenuEntry("Suchanfrage erstellen", new SuchanfrageWohnungSuchenAction()));
		m.add(new MenuEntry("Suchanfragen anzeigen", new SuchanfragenAnzeigenAction()));
		
		m.start();
		
	}

}
