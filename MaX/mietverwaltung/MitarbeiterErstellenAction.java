package mietverwaltung;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MitarbeiterErstellenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() {

		System.out.println(
				"________________________________________ Mitarbeiter erstellen ________________________________________");

		/*
		 * Variable zum Öffnen des richtigen JFrames und zur Auswahl des zu
		 * bearbeitenden Attributs.
		 */
		int änderung = -99;

		boolean erstellVorgang = true;

		int mitarbeiterID = -100;
		String name = "";
		String vorname = "";
		String benutzername = "";
		String passwort = "";

		/*
		 * Solange der Erstellvorgang nicht beendet ist, wird immer eine
		 * Übersicht über den erstellten Wert ausgegeben. Es wird pro Durchlauf
		 * immer 1 Attribut ausgewählt, welches man draufhin verändern kann.
		 */
		while (erstellVorgang == true) {

			/*
			 * Array beeinhaltet alle Attribute, die verändert werden können und
			 * dient zur Ausgabe durch Zugriff auf deren Index
			 */
			String[] kategorie = { "Mitarbeiter ID", "Name", "Vorname", "Passwort" };

			System.out.println(
					"...............................Wählen Sie die zu erstellende Eigenschaft aus...............................!  ");
			System.out.println("1. Mitarbeiter ID: " + mitarbeiterID);
			System.out.println("2. Name:           " + name);
			System.out.println("3. Vorname:        " + vorname);
			System.out.println("4. Passwort:       " + passwort);
			System.out.println("5. Erstellen abschließen");
			System.out.println("0. Abbruch");
			System.out.println("");

			Scanner t = new Scanner(System.in);

			/*
			 * Die try-catch Klammer existiert für nicht erwünschte Eingaben wie
			 * Zeichen, wo Zahlen erwartet werden.
			 */
			try {
				änderung = t.nextInt();

				// Abbruch
				if (änderung == 0) {
					System.out.println(
							"-------------------------------Erstellvorgang wurde abgebrochen!-------------------------------\n");
					erstellVorgang = false;
				}

				// Mitarbeiter-ID
				if (änderung == 1) {

					int eingabe = einlesen_Zahl(kategorie, änderung);
					if (eingabe == 0) {
					} else {
						int Vorhanden = 0;

						/*
						 * In der Liste aller aktiven Mitarbeiter wird überprüft, ob es
						 * einen Mitarbeiter mit der gewünschten ID bereits
						 * gibt.
						 */
						for (Mitarbeiter worker : workerList) {
							if (eingabe == worker.getMitarbeiterID()) {
								Vorhanden = 1;
							}
						}
						
						/*
						 * In der Liste aller ehemaligen Mitarbeiter wird überprüft, ob es
						 * einen Mitarbeiter mit der gewünschten ID bereits
						 * gibt.
						 */
						for (Mitarbeiter ehemaligerMitarbeiter : ehemaligeMitarbeiter) {
							if (eingabe == ehemaligerMitarbeiter.getMitarbeiterID()) {
								Vorhanden = 1;
							}
						}
						
						// ID bereits vorhanden
						if (Vorhanden == 1) {
							System.out.println(
									"\n------------------------------- Fehler! ------------------------------- \nMitarbeiter ID bereits vergeben!\n");
						}

						// ID nicht vorhanden
						else {
							mitarbeiterID = eingabe;
						}
					}
				}

				// Name
				if (änderung == 2) {
					String eingabe = einlesen_Wort(kategorie, änderung);
					if (eingabe.equals("" + 0)) {
					} else {
						name = eingabe;
					}
				}

				// Vorname
				if (änderung == 3) {
					String eingabe = einlesen_Wort(kategorie, änderung);

					if (eingabe.equals("" + 0)) {
					} else {
						vorname = eingabe;
					}
				}

				// Passwort
				if (änderung == 4) {
					String eingabe = einlesen_Wort(kategorie, änderung);

					if (eingabe.equals("" + 0)) {
					} else {
						passwort = eingabe;
					}
				}

				// Erstelle abschließen
				if (änderung == 5) {
					System.out.println("Mitarbeiter wurde erfolgreich angelegt!");
					erstellVorgang = false;
					benutzername = vorname.trim().substring(0, 1) + "." + name;

					// Mitarbeiter wird zur Mitarbeiterliste hinzugefügt
					workerList.add(new Mitarbeiter(mitarbeiterID, name, vorname, benutzername, passwort));
				}
				
				// Eingabe > 5
				if (änderung > 5) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit nicht vorhanden!\n");
				}
			} catch (InputMismatchException e) {
				System.out.println(
						"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
			}
		}
	}

	/**
	 * Methode zum Einlesen einer Zahl vom Nutzer
	 * 
	 * @param auswahl = welches "Änderungsfeld" der Nutzer betreten hat (Name des Index des Arrays)
	 * @param zähler  = welches "Änderungsfeld" der Nutzer betreten hat (Nummer des Index des Arrays)
	 * @return die eingelesene Zahl
	 */
	private int einlesen_Zahl(String[] auswahl, int zähler) {
		Scanner s = new Scanner(System.in);
		int zahl = -100;
		try {

			do {
				System.out.println("Geben Sie ein: " + auswahl[zähler - 1]);
				zahl = s.nextInt();
				if (zahl < 0) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nNur positive Zahlen erlaubt!");
				}
			} while (zahl < 0);
		} catch (InputMismatchException e) {
			System.out.println(
					"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
		}
		return zahl;
	}

	/**
	 * Methode zum Einlesen eines Wortes oder Satzes vom Nutzer
	 * 
	 * @param auswahl = welches "Änderungsfeld" der Nutzer betreten hat (Name des Index des Arrays)
	 * @param zähler = welches "Änderungsfeld" der Nutzer betreten hat (Nummer des Index des Arrays)
	 * @return das eingelesene Wort
	 */
	private String einlesen_Wort(String[] auswahl, int zähler) {
		System.out.println("Erstellen: " + auswahl[zähler - 1]);
		Scanner s = new Scanner(System.in);
		String wort = s.nextLine();
		return wort;
	}
}