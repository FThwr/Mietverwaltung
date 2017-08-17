package mietverwaltung.menu;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import mietverwaltung.Handwerkerauftrag;
import mietverwaltung.Interessent;
import mietverwaltung.J;
import mietverwaltung.Mieter;
import mietverwaltung.Mietvertrag;
import mietverwaltung.Mitarbeiter;
import mietverwaltung.Wohnung;

public class MenuManager extends J {

	protected static ArrayList<MenuEntry> menuList = new ArrayList<MenuEntry>();
	protected static ArrayList<Mitarbeiter> workerList = new ArrayList<Mitarbeiter>();
	protected static ArrayList<Wohnung> flatList = new ArrayList<Wohnung>();
	protected static ArrayList<Mieter> ownerList = new ArrayList<Mieter>();
	protected static ArrayList<Interessent> interestList = new ArrayList<Interessent>();
	protected static ArrayList<Handwerkerauftrag> repairList = new ArrayList<Handwerkerauftrag>();
	protected static ArrayList<Mietvertrag> contractList = new ArrayList<Mietvertrag>();

	public void add(MenuEntry menueEintrag) {
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

	public void start() {
//		String anmeldung = " ";
//		boolean passwortÜbereinstimmung = false;
//
//		while (passwortÜbereinstimmung == false) {
//			anmeldung = anmelden();
//			boolean passwort = passwortExistens(anmeldung);
//
//			if (passwort == false) {
//				System.out.println("Anmeldung nicht erfolgreich!\n");
//			} else {
//				passwortÜbereinstimmung = true;
//			}
//		}
//		personHerausfinden(anmeldung);

		System.out.println(
				"\nBei Eingabe von \"0\" kehren Sie zum vorherigen Menü zurück. \nBei \"-1\" wird das Programm beendet.");
		MenuEntry meAktuell = ersterEintrag();
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

	public MenuEntry aufruf(MenuEntry meAktuell) {
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

	public MenuEntry actionAusfuehren(MenuEntry meAktuell) {
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

	public void zaehleMenuePunkteAuf(MenuEntry me) {
		for (int i = 0; i < me.getLocation().length; i++) {
			String untermenueName = (me.getLocation())[i];
			System.out.println((i + 1) + ". " + untermenueName);
			
		}
		System.out.println("");
	}

	public MenuEntry zeigeAufObermenue(MenuEntry meAktuell) {
		try {
			String nameObermenue = meAktuell.getName();
			for (MenuEntry meSuche : menuList) {
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

	public MenuEntry zeigeAufUntermenue(MenuEntry me, int nummer) {
		String nameUntermenue = ((me.getLocation())[nummer - 1]);
		for (MenuEntry meSuche : menuList) {
			if ((meSuche.getName()).equals(nameUntermenue)) {
				return meSuche;
			}
		}
		return null;
	}

	public MenuEntry ersterEintrag() {
		for (MenuEntry me : menuList) {
			if (me.getName() == "") {
				return me;
			}
		}
		return null;
	}
}
