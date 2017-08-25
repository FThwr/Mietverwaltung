package mietverwaltung;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MenueManager {

	protected static ArrayList<MenueEntry> menuList = new ArrayList<MenueEntry>();
	protected static ArrayList<Mitarbeiter> workerList = new ArrayList<Mitarbeiter>();
	protected static ArrayList<Wohnung> flatList = new ArrayList<Wohnung>();
	protected static ArrayList<Mieter> ownerList = new ArrayList<Mieter>();
	protected static ArrayList<Interessent> interestList = new ArrayList<Interessent>();
	protected static ArrayList<Handwerkerauftrag> repairList = new ArrayList<Handwerkerauftrag>();
	protected static ArrayList<Mietvertrag> contractList = new ArrayList<Mietvertrag>();
	protected static ArrayList<Suchanfrage> searchList = new ArrayList<Suchanfrage>();
	
	
	protected static ArrayList<Mitarbeiter> ehemaligeMitarbeiter = new ArrayList<Mitarbeiter>();
	protected static ArrayList<Mieter> ehemaligeMieter = new ArrayList<Mieter>();
	protected static ArrayList<Interessent> ehemaligeInteressenten = new ArrayList<Interessent>();
	protected static ArrayList<Handwerkerauftrag> abgeschlosseneHandwerkeraufträge = new ArrayList<Handwerkerauftrag>();
	protected static ArrayList<Mietvertrag> beendeteMietverträge = new ArrayList<Mietvertrag>();
	

	public void add(MenueEntry menueEintrag) {
		menuList.add(menueEintrag);
	}
	
	public void add(Mietvertrag mietvertrag) {
		contractList.add(mietvertrag);
	}
	
	public void add(Handwerkerauftrag handwerkerauftrag) {
		repairList.add(handwerkerauftrag);
	}
	
	public void add(Mieter mieter) {
		ownerList.add(mieter);
	}
	
	public void add(Interessent interessent) {
		interestList.add(interessent);
	}

	public void add(Mitarbeiter mitarbeiter) {
		workerList.add(mitarbeiter);
	}
	
	public void add(Wohnung wohnung) {
		flatList.add(wohnung);
	}
	
	public void add(Suchanfrage suchanfrage) {
		searchList.add(suchanfrage);
	}
	
	public void addToHistory(Handwerkerauftrag fertige_handwerkerauftrag) {
		abgeschlosseneHandwerkeraufträge.add(fertige_handwerkerauftrag);
	}
	
	public void addToHistory(Mitarbeiter ehemalige_mitarbeiter) {
		ehemaligeMitarbeiter.add(ehemalige_mitarbeiter);
	}
	
	public void addToHistory(Mieter ehemalige_mieter) {
		ehemaligeMieter.add(ehemalige_mieter);
	}
	
	public void addToHistory(Interessent ehemalige_interessenten) {
		ehemaligeInteressenten.add(ehemalige_interessenten);
	}
	
	public void addToHistory(Mietvertrag beendete_mietverträge) {
		beendeteMietverträge.add(beendete_mietverträge);
	}

	public void start() throws FileNotFoundException, IOException, ClassNotFoundException {
		
//		FileInputStream inputWohnungen = new FileInputStream("wohnungen.ser");
//        // Deserialisierung
//        ObjectInputStream objectInputWohnungen = new ObjectInputStream(inputWohnungen);
//        // ArrayList auslesen
//        flatList = (ArrayList <Wohnung>) objectInputWohnungen.readObject();
//        
//        FileInputStream inputMitarbeiter = new FileInputStream("mitarbeiter.ser");
//        // Deserialisierung
//        ObjectInputStream objectInputMitarbeiter = new ObjectInputStream(inputMitarbeiter);
//        // ArrayList auslesen
//        workerList = (ArrayList <Mitarbeiter>) objectInputMitarbeiter.readObject();
//        
//        FileInputStream inputInteressenten = new FileInputStream("interessenten.ser");
//        // Deserialisierung
//        ObjectInputStream objectInputInteressenten = new ObjectInputStream(inputInteressenten);
//        // ArrayList auslesen
//        interestList = (ArrayList <Interessent>) objectInputInteressenten.readObject();
//        
//        FileInputStream inputMieter = new FileInputStream("mieter.ser");
//        // Deserialisierung
//        ObjectInputStream objectInputMieter = new ObjectInputStream(inputMieter);
//        // ArrayList auslesen
//        ownerList = (ArrayList <Mieter>) objectInputMieter.readObject();
//        
//        FileInputStream inputHandwerkeraufträge = new FileInputStream("aktive_handwerkeraufträge.ser");
//        // Deserialisierung
//        ObjectInputStream objectInputHandwerkeraufträge = new ObjectInputStream(inputHandwerkeraufträge);
//        // ArrayList auslesen
//        repairList = (ArrayList <Handwerkerauftrag>) objectInputHandwerkeraufträge.readObject();
//        
		
//		FileInputStream inputFertigeHandwerkeraufträge = new FileInputStream("fertige_handwerkeraufträge.ser");
//      // Deserialisierung
//      ObjectInputStream objectInputFertigeHandwerkeraufträge = new ObjectInputStream(inputFertigeHandwerkeraufträge);
//      // ArrayList auslesen
//      fertigeHandwerkeraufträge = (ArrayList <Handwerkerauftrag>) objectInputFertigeHandwerkeraufträge.readObject();
		
//		try {
//        FileInputStream inputMietverträge = new FileInputStream("mietverträge.ser");
//        // Deserialisierung
//        ObjectInputStream objectInputMietverträge = new ObjectInputStream(inputMietverträge);
//        // ArrayList auslesen
//        contractList = (ArrayList <Mietvertrag>) objectInputMietverträge.readObject();
//	} catch (Exception e) {
//		System.out.println("Datei existiert nicht oder ist leer.");
//	}
		
		String anmeldung = " ";
		boolean passwortÜbereinstimmung = false;

		while (passwortÜbereinstimmung == false) {
			anmeldung = anmelden();
			boolean passwort = passwortExistens(anmeldung);

			if (passwort == false) {
				System.out.println("\nAnmeldung nicht erfolgreich! Programm wird beendet\n");
				System.exit(0);
			} else {
				passwortÜbereinstimmung = true;
			}
		}
		personHerausfinden(anmeldung);

		System.out.println(
				"\nBei Eingabe von \"0\" kehren Sie zum vorherigen Menü zurück. \nBei \"-1\" wird das Programm beendet.");
		MenueEntry meAktuell = ersterEintrag();
		try {
			meAktuell = aufruf(meAktuell);

		} catch (NullPointerException ex) {
			System.out.println("keine Aktion hinterlegt, weil kein Menüeintrag erstellt wurde");
			actionAusfuehren(meAktuell);
			meAktuell = aufruf(meAktuell);
		}
	}

	private void personHerausfinden(String anmeldung) {
		for (Mitarbeiter ma : workerList) {
			if (anmeldung.equals(ma.getPasswort())) {
				System.out.println("\nWillkommen bei der Mietverwaltung " + ma.getName() + "\n");
			}
		}
	}

	private String anmelden() {
		System.out.println("Anmeldungsvorgang");
		String anmeldung = JOptionPane.showInputDialog(null, "Bitte Passwort eingeben!");
		if (anmeldung == null) {
			System.out.println("\nProgramm wird beendet!\n");
			System.exit(0);
		}
		
		return anmeldung;
	}

	public boolean passwortExistens(String anmeldung) {
		for (Mitarbeiter ma : workerList) {
			if (anmeldung.equals(ma.getPasswort())) {
				return true;
			}
		}
		return false;
	}

	public MenueEntry aufruf(MenueEntry meAktuell) throws FileNotFoundException, IOException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		do {
			if (meAktuell.getName().equals("")) {
				System.out.println("________________________________________ Hauptmenü ________________________________________");
			}
			else {
				System.out.println("________________________________________ Obermenü: " + meAktuell.getName() + " ________________________________________");
			}
			System.out.println("                               Wählen Sie einen Menüpunkt aus:                                ");
			zaehleMenuePunkteAuf(meAktuell);

			
			int eingabe = eingabeEinlesen(scanner);
			System.out.println("");
			if (eingabe <= meAktuell.getLocation().length && eingabe > 0) {
				meAktuell = zeigeAufUntermenue(meAktuell, eingabe);
			} else if (eingabe == 0) {
				meAktuell = zeigeAufObermenue(meAktuell);
			} else if (eingabe == -1) {
				System.out.println("Programm wurde beendet.");
				System.exit(0);
			} else {
				System.out.println("------------------------------- Fehler, der ausgewählte Menüpunkt existiert nicht. -------------------------------");
			}
		} while (meAktuell.getLocation() != null);
		meAktuell = actionAusfuehren(meAktuell);
		meAktuell = aufruf(meAktuell);
		return meAktuell;
	}

	public MenueEntry actionAusfuehren(MenueEntry meAktuell) throws FileNotFoundException, IOException, ClassNotFoundException {
		if (meAktuell.getLocation() == null) {
			if (meAktuell.getAction() != null) {
				meAktuell.getAction().action();
			}
		}
		meAktuell = zeigeAufObermenue(meAktuell);
		return meAktuell;
	}

	public int eingabeEinlesen(Scanner scanner) {
		int number = scanner.nextInt();
		return number;
	}

	public void zaehleMenuePunkteAuf(MenueEntry me) {
		for (int i = 0; i < me.getLocation().length; i++) {
			String untermenueName = (me.getLocation())[i];
			System.out.println((i + 1) + ". " + untermenueName);
			
		}
		System.out.println("");
	}

	public MenueEntry zeigeAufObermenue(MenueEntry meAktuell) {
		try {
			String nameObermenue = meAktuell.getName();
			for (MenueEntry meSuche : menuList) {
				String[] array = meSuche.getLocation();
				for (int i = 0; i < array.length; i++) {
					if (nameObermenue.equals(array[i])) {
						return meSuche;
					}
				}
			}
			return null;
		} catch (NullPointerException ex) {
			return meAktuell;
		}
	}

	public MenueEntry zeigeAufUntermenue(MenueEntry me, int nummer) {
		String nameUntermenue = ((me.getLocation())[nummer - 1]);
		for (MenueEntry meSuche : menuList) {
			if ((meSuche.getName()).equals(nameUntermenue)) {
				return meSuche;
			}
		}
		return null;
	}

	public MenueEntry ersterEintrag() {
		for (MenueEntry me : menuList) {
			if (me.getName() == "") {
				return me;
			}
		}
		return null;
	}
}
