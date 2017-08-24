package mietverwaltung;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MietvertragSuchenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() {

		System.out.println(
				"________________________________________ Mietvertrag suchen ________________________________________");

		boolean suchVorgang = true;

		// Variablen zum Rücksetzen, falls 0 eingegeben wurde

		String mietvertragID = "-";
		int wohnungsID = -100;
		int kundenID = -100;
		int mitarbeiterID = -100;
		int beginnMonat = -100;
		int beginnJahr = -100;
		int endeMonat = -100;
		int endeJahr = 100;
		String status = "-";

		// Variablen zur Speicherung des Suchwertes
		String such_mietvertragID = mietvertragID;
		int such_wohnungsID = wohnungsID;
		int such_kundenID = kundenID;
		int such_mitarbeiterID = mitarbeiterID;
		int such_beginnMonat = beginnMonat;
		int such_beginnJahr = beginnJahr;
		int such_endeMonat = endeMonat;
		int such_endeJahr = endeJahr;
		String such_status = status;

		/*
		 * Array beeinhaltet alle Attribute, die verändert werden können und
		 * dient zur Ausgabe durch Zugriff auf deren Index
		 */
		String[] kategorie = { "Mietvertrag-ID", "Wohnungs-ID", "Kunden-ID", "Mitarbeiter-ID", "Mietbeginn", "Mietende",
				"Status" };

		/*
		 * Mit der Variable wird überprüft, welche Attribut-Abfragen der Nutzer
		 * benutzt hatte. Es wird immer ein Buchstabe gespeichert, wodruch die
		 * Variable weiß, dass er in der Abfrage was ausgewählt hatte. Später
		 * wird anhand dieses Kriteriums die Suche ermöglicht.
		 */
		String check = "";

		/*
		 * Solange der Suchvorgang nicht beendet ist, wird immer eine Übersicht
		 * über die zu suchenden Werte ausgegeben, sofern das Attribut
		 * ausgewählt wurde. Wenn das Attribut nicht ausgewählt wurde, wird ein
		 * '-' angezeigt. Es wird pro Durchlauf immer 1 Attribut ausgewählt,
		 * welches man draufhin verändern kann.
		 */
		while (suchVorgang == true) {

			Scanner s = new Scanner(System.in);
			System.out.println(
					"............................... Wählen Sie die zu suchende Eigenschaft aus! ...............................");

			System.out.println("........... Aktuelle Suche nach: ...........");

			System.out.println("1. Mievertrag-ID:                 " + such_mietvertragID);
			if (such_wohnungsID != -100) {
				System.out.println("2. Wohnungs-ID:                  " + such_wohnungsID);
			} else {
				System.out.println("2. Wohnungs-ID:                 " + "-");
			}
			if (such_kundenID != -100) {
				System.out.println("3. Kunden-ID:                      " + such_kundenID);
			} else {
				System.out.println("3. Kunden-ID");
			}
			if (such_mitarbeiterID != -100) {
				System.out.println("4. Mitarbeiter-ID:                   " + such_mitarbeiterID);
			} else {
				System.out.println("4. Mitarbeiter-ID:                   " + "-");
			}
			System.out.print("5. Mietbeginn:        ");
			System.out.print("--.");

			if (such_beginnMonat != -100) {
				System.out.print(such_beginnMonat);
			} else {
				System.out.print("--.");
			}
			if (such_beginnJahr != -100) {
				System.out.println(such_beginnJahr);
			} else {
				System.out.println("----");
			}

			System.out.print("6. Mietende: ");
			System.out.print("--.");

			if (such_endeMonat != -100) {
				System.out.print(such_endeMonat);
			} else {
				System.out.print("--.");
			}
			if (such_endeJahr != -100) {
				System.out.println(such_endeJahr);
			} else {
				System.out.println("----");
			}
			System.out.println("7. Status                         " + such_status);
			System.out.println("8. Suche bestätigen");
			System.out.println("0. Abbruch");

			/*
			 * Die try-catch Klammer existiert für nicht erwünschte Eingaben wie
			 * Zeichen, wo Zahlen erwartet werden.
			 */
			try {
				int eingabe = s.nextInt();

				// Abbruch
				if (eingabe == 0) {
					System.out.println(
							"-------------------------------Suchvorgang wurde abgebrochen!-------------------------------\n");
					suchVorgang = false;
				}

				// Mietvertrags-ID
				if (eingabe == 1) {

					such_mietvertragID = einlesen_Wort(kategorie, eingabe);
					if (such_mietvertragID.equals("" + 0)) {
						such_mietvertragID = mietvertragID;
					} else {
						
						/*
						 * Der Nutzer hat das Attribut Mietvertrag-ID betreten. Somit
						 * erhält 'check' ein 'a' um sich zu merken, dass es die
						 * Abfrage betreten hatte.
						 */
						check = check + "a";
					}
				}

				// Wohnungsnummer
				if (eingabe == 2) {
					such_wohnungsID = einlesen_Zahl(kategorie, eingabe);
					if (such_wohnungsID == 0) {
						such_wohnungsID = wohnungsID;
					} else {
						
						/*
						 * Der Nutzer hat das Attribut Wohnungsnummer betreten. Somit
						 * erhält 'check' ein 'b' um sich zu merken, dass es die
						 * Abfrage betreten hatte.
						 */
						check = check + "b";
					}
				}

				// Mieter-ID
				if (eingabe == 3) {
					such_kundenID = einlesen_Zahl(kategorie, eingabe);
					if (such_kundenID == 0) {
						such_kundenID = kundenID;
					} else {
						
						/*
						 * Der Nutzer hat das Attribut Mieter-ID betreten. Somit
						 * erhält 'check' ein 'c' um sich zu merken, dass es die
						 * Abfrage betreten hatte.
						 */
						check = check + "c";
					}
				}

				// Mitarbeiter-ID
				if (eingabe == 4) {

					such_mitarbeiterID = einlesen_Zahl(kategorie, eingabe);
					if (such_mitarbeiterID == 0) {
						such_mitarbeiterID = mitarbeiterID;
					} else {
						
						/*
						 * Der Nutzer hat das Attribut Mitarbeiter-ID betreten. Somit
						 * erhält 'check' ein 'd' um sich zu merken, dass es die
						 * Abfrage betreten hatte.
						 */
						check = check + "d";
					}
				}

				// Mietbeginn
				if (eingabe == 5) {
					System.out.println("Spezialisierung des zu suchenden Mietbeginns: ");
					System.out.println("Drücke '1' für Monat: " + such_beginnMonat);
					System.out.println("Drücke '2' für Jahr:  " + such_beginnJahr);
					System.out.println("Drücke '3' für Bestätigen: ");
					System.out.println("Drücke '0' für Abbruch: ");

					String[] auswahl = { "Monat", "Jahr" };
					boolean datumseingabe = true;
					
					/*
					 * Variable um zu merken, welche Attributsveränderungen der
					 * Nutzer betreten hat. Hinzugefügt zum 'check' werden die
					 * Buchstaben jedoch erst, wenn die Suche abgeschlossen ist,
					 * weil sonst Buchstaben enthalten wären für
					 * Attributänderungen, die garnicht existieren.
					 */
					String saveCheck = check;

					while (datumseingabe == true) {

						Scanner q = new Scanner(System.in);
						int zähler = q.nextInt();

						// Monat
						if (zähler == 1) {
							such_beginnMonat = einlesen_Zahl(auswahl, zähler);
							if (such_beginnMonat == 0) {
								such_beginnMonat = beginnMonat;
							} else {
								
								/*
								 * Der Nutzer hat das Attribut Mietbeginn-Monat betreten. Somit
								 * erhält 'savecheck' ein 'e' um sich zu merken, dass es die
								 * Abfrage betreten hatte.
								 */
								saveCheck = saveCheck + "e";
							}
						}
						
						// Jahr
						if (zähler == 2) {
							such_beginnJahr = einlesen_Zahl(auswahl, zähler);
							if (such_beginnJahr == 0) {
								such_beginnJahr = beginnJahr;
							} else {
								
								/*
								 * Der Nutzer hat das Attribut Mietbeginn-Jahr betreten. Somit
								 * erhält 'savecheck' ein 'f' um sich zu merken, dass es die
								 * Abfrage betreten hatte.
								 */
								saveCheck = saveCheck + "f";
							}
						}
						
						// Datum bestätigen
						if (zähler == 3) {
							datumseingabe = false;
							check = check + saveCheck;
						}
						
						// Eingabe abbrechen
						if (zähler == 0) {
							datumseingabe = false;
						} 
						
						// Eingabe > 3
						if (zähler > 3) {
							System.out.println(
									"\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit existiert nicht!");
						}
					}
				}
				
				// Mietende
				if (eingabe == 6) {
					System.out.println("Spezialisierung des zu suchenden Mietendes: ");
					System.out.println("Drücke '1' für Monat: " + such_endeMonat);
					System.out.println("Drücke '2' für Jahr:  " + such_endeJahr);
					System.out.println("Drücke '3' für Bestätigen: ");
					System.out.println("Drücke '0' für Abbruch: ");

					String[] auswahl = { "Monat", "Jahr" };
					boolean datumseingabe = true;
					
					/*
					 * Variable um zu merken, welche Attributsveränderungen der
					 * Nutzer betreten hat. Hinzugefügt zum 'check' werden die
					 * Buchstaben jedoch erst, wenn die Suche abgeschlossen ist,
					 * weil sonst Buchstaben enthalten wären für
					 * Attributänderungen, die garnicht existieren.
					 */
					String saveCheck = check;

					while (datumseingabe == true) {

						Scanner q = new Scanner(System.in);
						int zähler = q.nextInt();

						// Monat
						if (zähler == 1) {
							such_beginnMonat = einlesen_Zahl(auswahl, zähler);
							if (such_endeMonat == 0) {
								such_endeMonat = endeMonat;
							} else {
								
								/*
								 * Der Nutzer hat das Attribut Mietende-Monat betreten. Somit
								 * erhält 'savecheck' ein 'g' um sich zu merken, dass es die
								 * Abfrage betreten hatte.
								 */
								saveCheck = saveCheck + "g";
							}
						}
						
						// Jahr
						if (zähler == 2) {
							such_endeJahr = einlesen_Zahl(auswahl, zähler);
							if (such_endeJahr == 0) {
								such_endeJahr = endeJahr;
							} else {
								
								/*
								 * Der Nutzer hat das Attribut Mietende-Jahr betreten. Somit
								 * erhält 'savecheck' ein 'h' um sich zu merken, dass es die
								 * Abfrage betreten hatte.
								 */
								saveCheck = saveCheck + "h";
							}
						}
						
						// Datum bestätigen
						if (zähler == 3) {
							datumseingabe = false;
							check = check + saveCheck;
						}
						
						// Eingabe abbrechen
						if (zähler == 0) {
							datumseingabe = false;
						}
						
						// Eingabe > 3
						if (zähler > 3) {
							System.out.println(
									"\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit existiert nicht!");
						}
					}
				}
				
				// Status
				if (eingabe == 7) {
					if (eingabe == 1) {

						such_status = einlesen_Wort(kategorie, eingabe);
						if (such_status.equals("" + 0)) {
							such_status = status;
						} else {
							
							/*
							 * Der Nutzer hat das Attribut Status betreten. Somit
							 * erhält 'check' ein 'i' um sich zu merken, dass es die
							 * Abfrage betreten hatte.
							 */
							check = check + "i";
						}
					}
				}
					
				// Suche bestätigen
				if (eingabe == 8) {
					suchVorgang = false;

					// Vergleichsvariablen zu den Suchvariablen
					String vgl_mietvertragID = "-";
					int vgl_wohnungsID = -100;
					int vgl_kundenID = -100;
					int vgl_mitarbeiterID = -100;
					int vgl_beginnMonat = -100;
					int vgl_beginnJahr = -100;
					int vgl_endeMonat = -100;
					int vgl_endeJahr = -100;
					String vgl_status = "-";

					
					/*
					 * Wenn 'check' ein Buchstaben enthält war der Nutzer bei
					 * einer bestimmten Attributveränderung. Wenn ein Buchstabe
					 * nicht enthalten ist, so ist der Suchwert und der
					 * Vergleichswert gleich. Wenn nun ein Buchstabe enthalten
					 * ist wird in jedem Handwerkerauftrag nach der zu suchenden
					 * Eigenschaft gesucht und wenn diese gefunden wurde, wird
					 * das dazugehörige Objekt ausgegeben. Bei mehreren
					 * Buchstaben müssen alle eingegebene Suchattribute in einem
					 * Handwerkerauftrag vorhanden sein, damit eine Ausgabe
					 * ermöglicht werden kann.
					 */
					for (Mietvertrag contract : contractList) {

						if (check.contains("a")) {
							vgl_mietvertragID = contract.getMietvertragID();
						}
						if (check.contains("b")) {
							vgl_wohnungsID = contract.getWohnungsID();
						}
						if (check.contains("c")) {
							vgl_kundenID = contract.getKundenID();
						}
						if (check.contains("d")) {
							vgl_mitarbeiterID = contract.getMitarbeiterID();
						}
						if (check.contains("e")) {
							vgl_beginnMonat = contract.getMietbeginn().getMonat();
						}
						if (check.contains("f")) {
							vgl_beginnJahr = contract.getMietbeginn().getJahr();
						}
						if (check.contains("g")) {
							vgl_endeMonat = contract.getMietende().getMonat();
						}
						if (check.contains("h")) {
							vgl_endeJahr = contract.getMietende().getJahr();
						}
						if (check.contains("h")) {
							vgl_status = contract.getStatus();
						}

						/*
						 * Wenn alle Suchwerte mit den Vergleichswerten
						 * übereinstimmen wird der Mietvertrag ausgegeben.
						 */
						if (vgl_mietvertragID.equals(such_mietvertragID) && vgl_wohnungsID == such_wohnungsID
								&& vgl_kundenID == such_kundenID && vgl_mitarbeiterID == such_mitarbeiterID
								&& vgl_beginnMonat == such_beginnMonat && vgl_beginnJahr == such_beginnJahr
								&& vgl_endeMonat == such_endeMonat && vgl_endeJahr == such_endeJahr && vgl_status.equals(such_status)) {
							System.out.println("Mietvertrag-ID:       " + contract.getMietvertragID());
							System.out.println("Wohnungs-ID:          " + contract.getWohnungsID());
							System.out.println("Kunden-ID:            " + contract.getKundenID());
							System.out.println("Mitarbeiter-ID:       " + contract.getMitarbeiterID());
							System.out.println("Mietbeginn:           " + contract.getMietbeginn());
							System.out.println("Mietende:             " + contract.getMietende());
							System.out.println("Status:               " + contract.getStatus());
							System.out.println("");
						}
					}
				}
				// Eingabe > 8
				if (eingabe > 8) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit existiert nicht!");
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
