package menue;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import objekte.*;

public class MenueManager {

	private ArrayList<MenueEntry> menuList = new ArrayList<MenueEntry>();
	private ArrayList<Mitarbeiter> workerList = new ArrayList<Mitarbeiter>();
	public ArrayList<Wohnung> flatList = new ArrayList<Wohnung>();

	public void add(MenueEntry menueEintrag) {
		menuList.add(menueEintrag);
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
		MenueEntry meAktuell = ersterEintrag();
		try {
			meAktuell = aufruf(meAktuell);

		} catch (NullPointerException ex) {
			System.out.println("keine Aktion hinterlegt, weil kein Menüeintrag erstellt wurde");
			actionAusfuehren(meAktuell);
			// meAktuell = zeigeAufObermenue(meAktuell);
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

	public MenueEntry aufruf(MenueEntry meAktuell) {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println(meAktuell.getName());
			zaehleMenuePunkteAuf(meAktuell);

			System.out.print("Wählen Sie einen Menüpunkt aus: ");
			int eingabe = eingabeEinlesen(scanner);
			if (eingabe <= meAktuell.getLocation().length && eingabe > 0) {
				meAktuell = zeigeAufUntermenue(meAktuell, eingabe);
			} else if (eingabe == 0) {
				meAktuell = zeigeAufObermenue(meAktuell);
			} else if (eingabe == -1) {
				System.out.println("Programm wurde beendet.");
				System.exit(0);
			} else {
				System.out.println("Fehler, der ausgewählte Menüpunkt existiert nicht.");
			}
		} while (meAktuell.getLocation() != null);
		meAktuell = actionAusfuehren(meAktuell);
		meAktuell = aufruf(meAktuell);
		return meAktuell;
	}

	public MenueEntry actionAusfuehren(MenueEntry meAktuell) {
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
