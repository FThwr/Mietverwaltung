package mietverwaltung;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HandwerkerauftragSuchenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() {

		System.out.println(
				"________________________________________ Handwerkerauftrag suchen ________________________________________");

		boolean suchVorgang = true;

		// Variablen zum Rücksetzen, falls 0 eingegeben wurde
		String auftragsID = "-";
		int wohnungsID = -100;
		int mitarbeiterID = -100;
		String mängelbeschreibung = "-";
		String status = "-";
		int eingangsTag = -100;
		int eingangsMonat = -100;
		int eingangsJahr = -100;
		int fertigTag = -100;
		int fertigMonat = -100;
		int fertigJahr = -100;

		// Variablen zur Speicherung des Suchwertes
		String such_auftragsID = auftragsID;
		int such_wohnungsID = wohnungsID;
		int such_mitarbeiterID = mitarbeiterID;
		String such_mängelbeschreibung = mängelbeschreibung;
		String such_status = status;
		int such_eingangsTag = eingangsTag;
		int such_eingangsMonat = eingangsMonat;
		int such_eingangsJahr = eingangsJahr;
		int such_fertigTag = fertigTag;
		int such_fertigMonat = fertigMonat;
		int such_fertigJahr = fertigJahr;

		/*
		 * Array beeinhaltet alle Attribute, die verändert werden können und
		 * dient zur Ausgabe durch Zugriff auf deren Index
		 */
		String[] kategorie = { "Auftrags ID ", "Wohnungs ID", "Mitarbeiter ID", "Mängelbeschreibung", "Status",
				"Eingangsdatum", "Fertigstellungsdatum" };

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
			System.out.println("1. Auftrags ID:          " + such_auftragsID);
			if (such_wohnungsID != -100) {
				System.out.println("2. Wohnungs ID:          " + such_wohnungsID);
			} else {
				System.out.println("2. Wohnungs ID:          " + "-");
			}
			if (such_mitarbeiterID != -100) {
				System.out.println("3. Mitarbeiter ID:       " + such_mitarbeiterID);
			} else {
				System.out.println("3. Mitarbeiter ID:       " + "-");
			}
			System.out.println("4. Mängelbeschreibung:   " + such_mängelbeschreibung);
			System.out.println("5. Status:               " + such_status);
			System.out.print("6. Eingangsdatum:        ");

			if (such_eingangsTag != -100) {
				System.out.print(such_eingangsTag);
			} else {
				System.out.print("--.");
			}
			if (such_eingangsMonat != -100) {
				System.out.print(such_eingangsMonat);
			} else {
				System.out.print("--.");
			}
			if (such_eingangsJahr != -100) {
				System.out.println(such_eingangsJahr);
			} else {
				System.out.println("----");
			}

			System.out.print("7. Fertigstellungsdatum: ");
			if (such_fertigTag != -100) {
				System.out.println(such_fertigTag);
			} else {
				System.out.print("--.");
			}
			if (such_fertigMonat != -100) {
				System.out.print(such_fertigMonat);
			} else {
				System.out.print("--.");
			}
			if (such_fertigJahr != -100) {
				System.out.println(such_fertigJahr);
			} else {
				System.out.println("----");
			}
			System.out.println("8. Suchen abschließen");
			System.out.println("0. Abbruch");
			System.out.println("");

			/*
			 * Die try-catch Klammer existiert für nicht erwünschte Eingaben wie
			 * Zeichen, wo Zahlen erwartet werden.
			 */
			try {

				/*
				 * Variable zur Auswahl des zu bearbeitenden Attributs.
				 */
				int eingabe = s.nextInt();

				// Abbruch
				if (eingabe == 0) {
					System.out.println(
							"-------------------------------Suchvorgang wurde abgebrochen!-------------------------------\n");
					suchVorgang = false;
				}

				// Auftrags-ID
				if (eingabe == 1) {

					such_auftragsID = einlesen_Wort(kategorie, eingabe);
					if (such_auftragsID.equals("" + 0)) {
						such_auftragsID = auftragsID;
					} else {
						/*
						 * Der Nutzer hat das Attribut Auftrags-ID betreten.
						 * Somit erhält 'check' ein 'a' um sich zu merken, dass
						 * es die Abfrage betreten hatte.
						 */
						check = check + "a";
					}
				}

				// Wohnung
				if (eingabe == 2) {

					such_wohnungsID = einlesen_Zahl(kategorie, eingabe);
					if (such_wohnungsID == 0) {
						such_wohnungsID = wohnungsID;
					} else {
						/*
						 * Der Nutzer hat das Attribut Wohnung betreten. Somit
						 * erhält 'check' ein 'b' um sich zu merken, dass es die
						 * Abfrage betreten hatte.
						 */
						check = check + "b";
					}

				} // Mitarbeiter
				if (eingabe == 3) {

					such_mitarbeiterID = einlesen_Zahl(kategorie, eingabe);
					if (such_mitarbeiterID == 0) {
						such_mitarbeiterID = mitarbeiterID;
					} else {
						/*
						 * Der Nutzer hat das Attribut Mitarbeiter betreten.
						 * Somit erhält 'check' ein 'c' um sich zu merken, dass
						 * es die Abfrage betreten hatte.
						 */
						check = check + "c";
					}
				}

				// Mängelbeschreibung
				if (eingabe == 4) {

					such_mängelbeschreibung = einlesen_Wort(kategorie, eingabe);
					if (such_mängelbeschreibung.equals("" + 0)) {
						such_mängelbeschreibung = mängelbeschreibung;
					} else {
						/*
						 * Der Nutzer hat das Attribut Mängelbeschreibung
						 * betreten. Somit erhält 'check' ein 'd' um sich zu
						 * merken, dass es die Abfrage betreten hatte.
						 */
						check = check + "d";
					}
				}

				// Status
				if (eingabe == 5) {
					System.out.println(
							"Geben Sie die Zahl vom gewünschten Status aus: '1' = in Bearbeitung, '2' = beendet, '0' = Abbruch!");
					int auswahl = einlesen_Zahl(kategorie, eingabe);

					if (auswahl == 1) {
						such_status = "in Bearbeitung";
						/*
						 * Der Nutzer hat das Attribut Status betreten. Somit
						 * erhält 'check' ein 'e' um sich zu merken, dass es die
						 * Abfrage betreten hatte.
						 */
						check = check + "e";
					}
					if (auswahl == 2) {
						such_status = "beendet";
						/*
						 * Der Nutzer hat das Attribut Status betreten. Somit
						 * erhält 'check' ein 'e' um sich zu merken, dass es die
						 * Abfrage betreten hatte.
						 */
						check = check + "e";
					}

					if (auswahl == 0) {
						such_status = status;
					}

					// Jede andere Eingabe führt zu einer Fehlermeldung.
					if (auswahl > 2) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit existiert nicht!");
					}

				}

				// Eingangsdatum
				if (eingabe == 6) {

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

						System.out.println("Spezialisierung des zu suchenden Eingangsdatums: Ihre Auswahl: Monat = "
								+ such_eingangsMonat + ", Jahr = " + such_eingangsJahr);
						System.out.println("Drücke '1' für Monat: ");
						System.out.println("Drücke '2' für Jahr: ");
						System.out.println("Drücke '3' für Bestätigen: ");
						System.out.println("Drücke '0' für Abbruch: ");

						Scanner q = new Scanner(System.in);
						int zähler = q.nextInt();

						// Monat
						if (zähler == 1) {

							do {
								such_eingangsMonat = einlesen_Zahl(auswahl, zähler);
								if (such_eingangsMonat > 12) {
									System.out.println(
											"\n------------------------------- Fehler! ------------------------------- \nMonat darf nicht höher als 12 sein!");
								}

							} while (such_eingangsMonat > 12);
							if (such_eingangsMonat == 0) {
								such_eingangsMonat = eingangsMonat;
							} else {
								/*
								 * Der Nutzer hat das Attribut Eingangsmonat
								 * betreten. Somit erhält 'safecheck' ein 's' um
								 * sich zu merken, dass es die Abfrage betreten
								 * hatte.
								 */
								saveCheck = saveCheck + "s";
							}
						}

						// Jahr
						if (zähler == 2) {

							such_eingangsJahr = einlesen_Zahl(auswahl, zähler);
							if (such_eingangsJahr == 0) {
								such_eingangsJahr = eingangsJahr;
							} else {
								/*
								 * Der Nutzer hat das Attribut Eingangsjahr
								 * betreten. Somit erhält 'safecheck' ein 't' um
								 * sich zu merken, dass es die Abfrage betreten
								 * hatte.
								 */
								saveCheck = saveCheck + "t";
							}
						}

						// 'Eingangsdatum' Sucheingabe abschließen
						if (zähler == 3) {
							datumseingabe = false;
							check = check + saveCheck;
						}

						// 'Eingangsdatum' Sucheingabe abbrechen
						if (zähler == 0) {
							datumseingabe = false;
						} else {
							System.out.println(
									"\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit existiert nicht!");
						}
					}
				}

				// Fertigstellungsdatum
				if (eingabe == 7) {

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

						System.out.println(
								"Spezialisierung des zu suchenden Fertigstellungsdatums: Ihre Auswahl: Monat = "
										+ such_fertigMonat + ", Jahr = " + such_fertigJahr);
						System.out.println("Drücke '1' für Monat: ");
						System.out.println("Drücke '2' für Jahr: ");
						System.out.println("Drücke '3' für Bestätigen: ");
						System.out.println("Drücke '4' für Abbruch: ");

						Scanner q = new Scanner(System.in);
						int zähler = q.nextInt();

						// Monat
						if (zähler == 1) {

							do {
								such_fertigMonat = einlesen_Zahl(auswahl, zähler);
								if (such_fertigMonat > 12) {
									System.out.println(
											"\n------------------------------- Fehler! ------------------------------- \nMonat darf nicht höher als 12 sein!");
								}

							} while (such_fertigMonat > 12);
							if (such_fertigMonat == 0) {
								such_fertigMonat = fertigMonat;
							} else {
								/*
								 * Der Nutzer hat das Attribut
								 * Fertigstellungsmonat betreten. Somit erhält
								 * 'safecheck' ein 'y' um sich zu merken, dass
								 * es die Abfrage betreten hatte.
								 */
								saveCheck = saveCheck + "y";
							}
						}

						// Jahr
						if (zähler == 2) {

							such_fertigJahr = einlesen_Zahl(auswahl, zähler);
							if (such_fertigJahr == 0) {
								such_fertigJahr = fertigJahr;
							} else {
								/*
								 * Der Nutzer hat das Attribut
								 * Fertigstellungsjahr betreten. Somit erhält
								 * 'safecheck' ein 'z' um sich zu merken, dass
								 * es die Abfrage betreten hatte.
								 */
								saveCheck = saveCheck + "z";
							}
						}

						// 'Eingangsdatum' Sucheingabe abschließen
						if (zähler == 3) {
							datumseingabe = false;
							check = check + saveCheck;
						}

						// 'Eingangsdatum' Sucheingabe abbrechen
						if (zähler == 4) {
							datumseingabe = false;
						} else {
							System.out.println(
									"\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit existiert nicht!");
						}
					}
				}

				// Suchvorgang abschließen
				if (eingabe == 8) {
					suchVorgang = false;

					// Vergleichsvariablen zu den Suchvariablen
					String vgl_auftragsID = "-";
					int vgl_wohnungsID = -100;
					int vgl_mitarbeiterID = -100;
					String vgl_mängelbeschreibung = "-";
					String vgl_status = "-";
					int vgl_eingangsMonat = -100;
					int vgl_eingangsJahr = -100;
					int vgl_fertigMonat = -100;
					int vgl_fertigJahr = -100;

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
					for (Handwerkerauftrag repair : repairList) {

						if (check.contains("a")) {
							vgl_auftragsID = repair.getAuftragsID();
						}
						if (check.contains("b")) {
							vgl_wohnungsID = repair.getWohnungsID();
						}
						if (check.contains("c")) {
							vgl_mitarbeiterID = repair.getMitarbeiterID();
						}
						if (check.contains("d")) {
							vgl_mängelbeschreibung = repair.getMängelbeschreibung();
						}
						if (check.contains("e")) {
							vgl_status = repair.getStatus();
						}
						if (check.contains("s")) {
							vgl_eingangsMonat = repair.getEingangsdatum().getMonat();
						}
						if (check.contains("t")) {
							vgl_eingangsJahr = repair.getEingangsdatum().getJahr();
						}
						if (check.contains("y")) {
							vgl_fertigMonat = repair.getFertigstellungsDatum().getMonat();
						}
						if (check.contains("z")) {
							vgl_fertigJahr = repair.getFertigstellungsDatum().getJahr();
						}

						/*
						 * Wenn alle Suchwerte mit den Vergleichswerten
						 * übereinstimmen wird der Handwerkerauftrag ausgegeben.
						 */
						if (vgl_auftragsID.equals(such_auftragsID) && vgl_wohnungsID == such_wohnungsID
								&& vgl_mitarbeiterID == such_mitarbeiterID
								&& vgl_mängelbeschreibung.contains(such_mängelbeschreibung)
								&& vgl_status.contains(such_status) && vgl_eingangsMonat == such_eingangsMonat
								&& vgl_eingangsJahr == such_eingangsJahr && vgl_fertigMonat == such_fertigMonat
								&& vgl_fertigJahr == such_fertigJahr) {
							System.out.println("Auftrags ID:          " + repair.getAuftragsID());
							System.out.println("Wohnungs ID:          " + repair.getWohnungsID());
							System.out.println("Mitarbeiter ID:       " + repair.getMitarbeiterID());
							System.out.println("Mängelbeschreibung:   " + repair.getMängelbeschreibung());
							System.out.println("Status:               " + repair.getStatus());
							System.out.println("Eingangsdatum:        " + repair.getEingangsdatum());
							System.out.println("Fertigstellungsdatum: " + repair.getFertigstellungsDatum());
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
