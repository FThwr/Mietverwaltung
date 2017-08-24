package mietverwaltung;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MieterErstellenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() {

		System.out.println(
				"________________________________________ Mieter erstellen ________________________________________");

		/*
		 * Variable zum Öffnen des richtigen JFrames und zur Auswahl des zu
		 * bearbeitenden Attributs.
		 */
		int änderung = 0;

		boolean erstellVorgang = true;

		int mieterID = -100;
		String name = "-";
		String vorname = "-";
		Datum geburtsdatum = null;
		int wohnung = -100;
		String EMail = "-";
		Adresse adresse = null;
		String telefon = "-";
		String status = "Mieter";
		String[] kategorie = { "Mieter ID", "Name", "Vorname", "Geburtsdatum", "Wohnung", "E-Mail", "Adresse",
				"Telefonnummer" };

		/*
		 * Solange der Erstellvorgang nicht beendet ist, wird immer eine
		 * Übersicht über den erstellten Wert ausgegeben. Es wird pro Durchlauf
		 * immer 1 Attribut ausgewählt, welches man draufhin verändern kann.
		 */

		while (erstellVorgang == true) {

			System.out.println(
					"...............................Wählen Sie die zu erstellende Eigenschaft aus...............................!  ");
			System.out.println("1. Mieter ID:      " + mieterID);
			System.out.println("2. Name:           " + name);
			System.out.println("3. Vorname:        " + vorname);
			System.out.println("4. Geburtsdatum:   " + geburtsdatum);
			System.out.println("5. Wohnung:        " + wohnung);
			System.out.println("6. E-Mail:         " + EMail);
			System.out.println("7. Adresse:        " + adresse);
			System.out.println("8. Telefon:        " + telefon);
			System.out.println("9. Erstellen abschließen");
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

				// Mieter-ID
				if (änderung == 1) {

					int eingabe = einlesen_Zahl(kategorie, änderung);
					if (eingabe == 0) {
					} else {

						int vorhanden = 0;
						/*
						 * Für jedes Element in der Handwerkerliste der aktiven
						 * Aufträge wird geguckt, ob die eingegebende ID mit
						 * einer bereits existierenden übereinstimmt.
						 */
						for (Mieter owner : ownerList) {
							if (eingabe == owner.getKundenID()) {
								vorhanden = 1;
							}
						}

						/*
						 * Für jedes Element in der Handwerkerliste der
						 * abgeschlossenen Aufträge wird geguckt, ob die
						 * eingegebende ID mit einer bereits existierenden
						 * übereinstimmt.
						 */
						for (Mieter ehemaligerMieter : ehemaligeMieter) {
							if (eingabe == ehemaligerMieter.getKundenID()) {
								vorhanden = 1;
							}
						}

						/*
						 * Wenn die Variable 'vorhanden' = 1, dann existierte
						 * ein Handwerkerauftrag mit dieser ID bereits. Sonst
						 * wird die eingegebene ID die ID des Auftrags.
						 */
						if (vorhanden == 1) {
							System.out.println(
									"\n------------------------------- Fehler! ------------------------------- \nMieter ID bereits vergeben!\n");
						} else {
							mieterID = eingabe;
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

				// Geburtsdatum
				if (änderung == 4) {

					geburtsdatum = Datum_Eingabe(geburtsdatum);

				}

				// Wohnung
				if (änderung == 5) {

					int eingabe = einlesen_Zahl(kategorie, änderung);
					if (eingabe == 0) {
					} else {
						int nichtVorhanden = 0;
						for (Wohnung flat : flatList) {
							for (Mieter owner : ownerList) {
								/*
								 * nur wenn die Wohnung von keinem anderen
								 * Mieter belegt ist und die Wohnung existiert
								 */
								if (owner.getWohnungsnummer() != eingabe && eingabe == flat.getWohnungsID()
										&& flat.getStatus().equals("frei")) {
									nichtVorhanden = 1;
								}
								/*
								 * wenn ein Mieter bereits in der Wohnung
								 * existiert
								 */
								if (owner.getWohnungsnummer() == eingabe) {
									nichtVorhanden = 2;
								}
							}
						}
						
						// Eingabe erfolgreich
						if (nichtVorhanden == 1) {
							wohnung = eingabe;
						}
						
						// Eingabe fehlgeschlagen, bereits bewohnt
						if (nichtVorhanden == 2) {
							System.out.println(
									"------------------------------- Fehler! ------------------------------- \nWohnung bereits von einem anderen Mieter belegt!\n");
						}
						if (nichtVorhanden != 2 && nichtVorhanden != 1) {
							System.out.println(
									"------------------------------- Fehler! ------------------------------- \nWohnung existiert nicht!\n");
						}
					}
				}
				
				// E-Mail
				if (änderung == 6) {
					String eingabe = einlesen_Wort(kategorie, änderung);
					if (eingabe.equals("" + 0)) {
					} else {
						EMail = eingabe;
					}
				}
				
				// Adresse
				if (änderung == 7) {
					String[] auswahl = { "Straße", "Hausnummer", "Platz", "Stadt" };

					int zähler = 1;
					String straße = einlesen_Wort(auswahl, zähler);
					zähler = 2;
					int hausnummer = einlesen_Zahl(auswahl, zähler);
					zähler = 3;
					int platz = einlesen_Zahl(auswahl, zähler);
					zähler = 4;
					String stadt = einlesen_Wort(auswahl, zähler);

					if (straße.equals("" + 0) || hausnummer == 0 || platz == 0 || stadt.equals("" + 0)
							|| hausnummer == -100 || platz == -100) {
					} else {
						adresse = new Adresse(straße, hausnummer, platz, stadt);
					}
				}
				
				// Telefonnummer
				if (änderung == 8) {
					String eingabe = einlesen_Wort(kategorie, änderung);
					if (eingabe.equals("" + 0)) {	
					} else {
						telefon = eingabe;
					}
				}
				
				// Erstellen abschließen
				if (änderung == 9) {
					System.out.println("Mieter wurde erfolgreich angelegt!");
					erstellVorgang = false;
					
					// Hinzufügen zur Mieterliste
					ownerList.add(new Mieter(mieterID, name, vorname, geburtsdatum, wohnung, EMail, adresse, telefon,
							status));
				}
				
				//Eingabe > 9
				if (änderung > 9) {
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
	 * Methode zur Eingabe des Datums
	 * 
	 * @param aktuellesDatum,
	 *            was der Handwerkerauftrag zu dem Zeitpunkt noch benutzt
	 * @return das neue Datum, welches weiterverwendet werden soll
	 */
	public Datum Datum_Eingabe(Datum aktuellesDatum) {

		System.out
				.println("Eingabe des Eingangdatums: Wählen Sie bei einem Wert '0' und das Datum bleibt unverändert!");
		String[] auswahl = { "Jahr", "Monat", "Tag" };

		Datum neuesDatum = null;
		boolean datumsEingabeErfolgreich = false;

		int zähler = 1;
		int jahr = einlesen_Zahl(auswahl, zähler);

		zähler = 2;
		int monat = 0;
		do {
			monat = einlesen_Zahl(auswahl, zähler);
			if (monat > 12) {
				System.out.println(
						"\n------------------------------- Fehler! ------------------------------- \nMonat darf nicht höher als 12 sein!");
			}
		} while (monat > 12);

		zähler = 3;
		int tag = 0;
		do {
			tag = einlesen_Zahl(auswahl, zähler);
			if (monat == 1 || monat == 3 || monat == 5 || monat == 7 || monat == 8 || monat == 10 || monat == 12) {
				if (tag > 31) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 31 Tage!");
				} else {
					datumsEingabeErfolgreich = true;
				}
			}

			if (monat == 4 || monat == 6 || monat == 9 || monat == 11) {
				if (tag > 30) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 30 Tage!");
				} else {
					datumsEingabeErfolgreich = true;
				}
			}

			if (monat == 2) {
				if (tag > 29) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 29 Tage!");
				} else {
					datumsEingabeErfolgreich = true;
				}
			}
		} while (datumsEingabeErfolgreich == false);

		/*
		 * Wenn einer der Werte versucht wird zu überspringen/ auszulassen, dann
		 * bleibt es beim unveränderten Datum.
		 */
		if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
			neuesDatum = aktuellesDatum;
		} else {
			neuesDatum = new Datum(tag, monat, jahr);
		}
		return neuesDatum;
	}

	private int einlesen_Zahl(String[] auswahl, int zähler) {
		System.out.println("Erstellen: " + auswahl[zähler - 1]);
		Scanner s = new Scanner(System.in);
		int zahl = -100;
		try {
			zahl = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(
					"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
		}
		return zahl;
	}

	private String einlesen_Wort(String[] auswahl, int zähler) {
		System.out.println("Erstellen: " + auswahl[zähler - 1]);
		Scanner s = new Scanner(System.in);
		String wort = s.next();
		return wort;
	}
}