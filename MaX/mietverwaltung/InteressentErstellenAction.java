package mietverwaltung;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InteressentErstellenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() throws IOException {

		System.out.println(
				"________________________________________ Interessent erstellen ________________________________________\n");

		boolean erstellVorgang = true;

		int interessentenID = -100;
		String name = "-";
		String vorname = "-";
		Datum geburtsdatum = null;
		String EMail = "-";
		Adresse adresse = null;
		String telefonnummer = "-";
		String status = "Interessent";
		String[] kategorie = { "Interessenten ID", "Name", "Vorname", "Geburtsdatum", "E-Mail", "Adresse",
				"Telefonnummer" };

		/*
		 * Solange der Erstellvorgang nicht beendet ist, wird immer eine
		 * �bersicht �ber den erstellten Wert ausgegeben. Es wird pro Durchlauf
		 * immer 1 Attribut ausgew�hlt, welches man draufhin ver�ndern kann.
		 */
		while (erstellVorgang == true) {

			System.out.println(
					"...............................W�hlen Sie die zu erstellende Eigenschaft aus...............................!");
			if (interessentenID != -100) {
			System.out.println("1. Interessenten ID:      " + interessentenID);
			}
			else {
				System.out.println("1. Interessenten ID:      " + "-");
			}
			System.out.println("2. Name:                  " + name);
			System.out.println("3. Vorname:               " + vorname);
			if (geburtsdatum != null) {
			System.out.println("4. Geburtsdatum:          " + geburtsdatum);
			}
			else {
				System.out.println("4. Geburtsdatum:          " + "-");
			}
			System.out.println("5. E-Mail:                " + EMail);
			if (adresse != null) {
			System.out.println("6. Adresse:               " + adresse);
			}
			else {
				System.out.println("6. Adresse:               " + "-");
			}
			System.out.println("7. Telefon:               " + telefonnummer);
			System.out.println("8. Erstellen abschlie�en");
			System.out.println("0. Abbruch");
			System.out.println("");

			Scanner t = new Scanner(System.in);

			/*
			 * Die try-catch Klammer existiert f�r nicht erw�nschte Eingaben wie
			 * Zeichen, wo Zahlen erwartet werden.
			 */
			try {
				/*
				 * Variable zur Auswahl des zu bearbeitenden Attributs
				 */
				int �nderung = t.nextInt();

				// Abbruch
				if (�nderung == 0) {
					System.out.println(
							"-------------------------------Erstellvorgang wurde abgebrochen!-------------------------------\n");
					erstellVorgang = false;
				}

				// Interessenten-ID
				if (�nderung == 1) {

					int neueID = einlesen_Zahl(kategorie, �nderung);
					if (neueID == 0) {
					} else {

						int vorhanden = 0;
						/*
						 * F�r jedes Element in der Interessentenliste wird
						 * geguckt, ob die eingegebende ID mit einer bereits
						 * existierenden �bereinstimmt.
						 */
						for (Interessent interest : interestList) {
							if (neueID == interest.getKundenID()) {
								vorhanden = 1;
							}
						}
						
						/*
						 * F�r jedes Element in der Liste der ehemaligen Interessenten wird
						 * geguckt, ob die eingegebende ID mit einer bereits
						 * existierenden �bereinstimmt.
						 */
						for (Interessent ehemaligerInteressent : ehemaligeInteressenten) {
							if (neueID == ehemaligerInteressent.getKundenID()) {
								vorhanden = 1;
							}
						}

						/*
						 * Wenn vorhanden = 1 ist, dann existiert ein
						 * Interessent mit dieser ID bereits
						 */
						if (vorhanden == 1) {
							System.out.println(
									"\n------------------------------- Fehler! ------------------------------- \nKunden ID bereits vergeben!\n");
						} else {
							interessentenID = neueID;
						}
					}
				}

				// Name
				if (�nderung == 2) {
					String neuerName = einlesen_Wort(kategorie, �nderung);
					// wenn eine 0 eingegeben wurde, dann wird der alte Wert
					// behalten
					if (neuerName.equals("" + 0)) {
					} else {
						name = neuerName;
					}
				}

				// Vorname
				if (�nderung == 3) {
					String neuerVorname = einlesen_Wort(kategorie, �nderung);
					// wenn eine 0 eingegeben wurde, dann wird der alte Wert
					// behalten
					if (neuerVorname.equals("" + 0)) {
					} else {
						vorname = neuerVorname;
					}
				}

				// Geburtsdatum
				if (�nderung == 4) {

					geburtsdatum = Datum_Eingabe(geburtsdatum);

				}

				// E-Mail
				if (�nderung == 5) {
					String neueEMail = einlesen_Wort(kategorie, �nderung);
					// wenn eine 0 eingegeben wurde, dann wird der alte Wert
					// behalten
					if (neueEMail.equals("" + 0)) {
					} else {
						EMail = neueEMail;
					}
				}

				// Adresse
				if (�nderung == 6) {
					String[] auswahl = { "Stra�e", "Hausnummer", "Platz", "Stadt" };

					int z�hler = 1;
					String stra�e = einlesen_Wort(auswahl, z�hler);
					z�hler = 2;
					int hausnummer = einlesen_Zahl(auswahl, z�hler);
					z�hler = 3;
					int platz = einlesen_Zahl(auswahl, z�hler);
					z�hler = 4;
					String stadt = einlesen_Wort(auswahl, z�hler);

					// wenn eine 0 oder eine falsche Eingabe erfolgt, dann wird
					// die Eingabe nicht angenommen
					if (stra�e.equals("" + 0) || hausnummer == 0 || platz == 0 || stadt.equals("" + 0)
							|| hausnummer == -100 || platz == -100) {
					} else {
						adresse = new Adresse(stra�e, hausnummer, platz, stadt);
					}
				}

				// Telefonnummer
				if (�nderung == 7) {
					String neueTelefonnummer = einlesen_Wort(kategorie, �nderung);
					// wenn eine 0 eingegeben wurde, dann wird der alte Wert
					// behalten
					if (neueTelefonnummer.equals("" + 0)) {
					} else {
						telefonnummer = neueTelefonnummer;
					}
				}

				// Erstellen abschlie�en
				if (�nderung == 8) {
					System.out.println("Interessent wurde erfolgreich angelegt!");
					erstellVorgang = false;

					// Interessent wird zur Interessentenliste hinzugef�gt
					interestList.add(new Interessent(interessentenID, name, vorname, geburtsdatum, EMail, adresse,
							telefonnummer, status));

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
				.println("Eingabe des Eingangdatums: W�hlen Sie bei einem Wert '0' und das Datum bleibt unver�ndert!");
		String[] auswahl = { "Jahr", "Monat", "Tag" };

		Datum neuesDatum = null;
		boolean datumsEingabeErfolgreich = false;

		int z�hler = 1;
		int jahr = einlesen_Zahl(auswahl, z�hler);

		z�hler = 2;
		int monat = 0;
		do {
			monat = einlesen_Zahl(auswahl, z�hler);
			if (monat > 12) {
				System.out.println(
						"\n------------------------------- Fehler! ------------------------------- \nMonat darf nicht h�her als 12 sein!\n");
			}
		} while (monat > 12);

		z�hler = 3;
		int tag = 0;
		do {
			tag = einlesen_Zahl(auswahl, z�hler);
			if (monat == 1 || monat == 3 || monat == 5 || monat == 7 || monat == 8 || monat == 10 || monat == 12) {
				if (tag > 31) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 31 Tage!\n");
				} else {
					datumsEingabeErfolgreich = true;
				}
			}

			if (monat == 4 || monat == 6 || monat == 9 || monat == 11) {
				if (tag > 30) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 30 Tage!\n");
				} else {
					datumsEingabeErfolgreich = true;
				}
			}

			if (monat == 2) {
				if (tag > 29) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 29 Tage!\n");
				} else {
					datumsEingabeErfolgreich = true;
				}
			}
		} while (datumsEingabeErfolgreich == false);

		/*
		 * Wenn einer der Werte versucht wird zu �berspringen/ auszulassen, dann
		 * bleibt es beim unver�nderten Datum.
		 */
		if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
			neuesDatum = aktuellesDatum;
		} else {
			neuesDatum = new Datum(tag, monat, jahr);
		}
		return neuesDatum;
	}

	/**
	 * Methode zum Einlesen einer Zahl vom Nutzer
	 * 
	 * @param auswahl
	 *            = welches "�nderungsfeld" der Nutzer betreten hat (Name des
	 *            Index des Arrays)
	 * @param z�hler
	 *            = welches "�nderungsfeld" der Nutzer betreten hat (Nummer des
	 *            Index des Arrays)
	 * @return die eingelesene Zahl
	 */
	private int einlesen_Zahl(String[] auswahl, int z�hler) {
		Scanner s = new Scanner(System.in);
		int zahl = -100;
		try {

			do {
				System.out.println("Geben Sie ein: " + auswahl[z�hler - 1]);
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
	 * @param auswahl
	 *            = welches "�nderungsfeld" der Nutzer betreten hat (Name des
	 *            Index des Arrays)
	 * @param z�hler
	 *            = welches "�nderungsfeld" der Nutzer betreten hat (Nummer des
	 *            Index des Arrays)
	 * @return das eingelesene Wort
	 */
	private String einlesen_Wort(String[] auswahl, int z�hler) {
		System.out.println("Erstellen: " + auswahl[z�hler - 1]);
		Scanner s = new Scanner(System.in);
		String wort = s.nextLine();
		return wort;
	}
}