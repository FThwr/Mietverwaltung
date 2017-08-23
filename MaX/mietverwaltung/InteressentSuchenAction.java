package mietverwaltung;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InteressentSuchenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() {

		System.out.println(
				"________________________________________ Interessent suchen ________________________________________");

		boolean suchVorgang = true;

		// Variablen zum R�cksetzen, falls 0 eingegeben wurde
		int interessentenID = -100;
		String name = "-";
		String vorname = "-";
		String EMail = "-";
		String stra�e = "";
		int plz = -100;
		String telefon = "-";

		// Variablen zur Speicherung des Suchwertes
		int such_interessentenID = interessentenID;
		String such_name = name;
		String such_vorname = vorname;
		String such_EMail = EMail;
		String such_adresse_stra�e = "-";
		int such_adresse_plz = -100;
		String such_telefon = telefon;

		String[] kategorie = { "Interessenten ID", "Name", "Vorname", "E-Mail", "Adresse", "Telefonnummer" };

		/*
		 * Mit der Variable wird �berpr�ft, welche Attribut-Abfragen der Nutzer
		 * benutzt hatte. Es wird immer ein Buchstabe gespeichert, wodruch die
		 * Variable wei�, dass er in der Abfrage was ausgew�hlt hatte. Sp�ter
		 * wird anhand dieses Kriteriums die Suche erm�glicht.
		 */
		String check = "";

		/*
		 * Solange der Suchvorgang nicht beendet ist, wird immer eine �bersicht
		 * �ber die zu suchenden Werte ausgegeben, sofern das Attribut
		 * ausgew�hlt wurde. Wenn das Attribut nicht ausgew�hlt wurde, wird ein
		 * '-' angezeigt. Es wird pro Durchlauf immer 1 Attribut ausgew�hlt,
		 * welches man draufhin ver�ndern kann.
		 */
		while (suchVorgang == true) {

			Scanner s = new Scanner(System.in);
			System.out.println(
					"............................... W�hlen Sie die zu suchende Eigenschaft aus! ...............................");

			System.out.println("........... Aktuelle Suche nach: ...........");
			if (such_interessentenID != -100) {
				System.out.println("1. Interessenten ID:          " + such_interessentenID);
			} else {
				System.out.println("1. Interessenten ID:          " + "-");
			}
			System.out.println("2. Name:                      " + such_name);
			System.out.println("3. Vorname:                   " + such_vorname);
			System.out.println("4. E-Mail:                    " + such_EMail);
			System.out.println("5. Adresse Stra�e:            " + such_adresse_stra�e);
			System.out.println("   Adresse Hausnummer:        " + "-");

			if (plz != -100) {
				System.out.println("5. Adresse Platz:             " + such_adresse_plz);
			} else {
				System.out.println("5. Adresse Platz:             " + "-");
			}
			System.out.println("   Adresse Stadt:             " + "-");
			System.out.println("6. Telefonnummer:             " + such_telefon);
			System.out.println("7. Suche best�tigen");
			System.out.println("0. Abbruch ");
			System.out.println("");

			/*
			 * Die try-catch Klammer existiert f�r nicht erw�nschte Eingaben wie
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

				// Interessenten-ID
				if (eingabe == 1) {

					such_interessentenID = einlesen_Zahl(kategorie, eingabe);
					if (such_interessentenID == 0) {
						such_interessentenID = interessentenID;
					} else {
						check = check + "a";
					}
				}

				// Name
				if (eingabe == 2) {
					such_name = einlesen_Wort(kategorie, eingabe);
					if (such_name.equals("" + 0)) {
						such_name = name;
					} else {
						check = check + "b";
					}
				}

				// Vorname
				if (eingabe == 3) {
					such_name = einlesen_Wort(kategorie, eingabe);
					if (such_vorname.equals("" + 0)) {
						such_vorname = vorname;
					} else {
						check = check + "c";
					}
				}

				// E-Mail
				if (eingabe == 4) {
					such_EMail = einlesen_Wort(kategorie, eingabe);
					if (such_EMail.equals("" + 0)) {
						such_EMail = EMail;
					} else {
						check = check + "d";
					}
				}

				// Adresse
				if (eingabe == 5) {
					System.out.println("Spezialisierung der zu suchenden Adresse: ");
					System.out.println("Dr�cke '1' f�r Stra�e: ");
					System.out.println("Dr�cke '2' f�r Platz: ");
					System.out.println("Dr�cke '3' f�r Abbruch: ");

					String[] auswahl = { "Stra�e", "Platz"};
					boolean adresseingabe = true;

					while (adresseingabe == true) {

						Scanner q = new Scanner(System.in);
						int z�hler = q.nextInt();

						if (z�hler == 1) {
							such_adresse_stra�e = einlesen_Wort(auswahl, z�hler);
							if (such_adresse_stra�e.equals("" + 0)) {
								such_adresse_stra�e = stra�e;
							} else {
								check = check + "y";
							}
						}
						if (z�hler == 2) {
							such_adresse_plz = einlesen_Zahl(auswahl, z�hler);
							if (such_adresse_plz == 0 || such_adresse_plz == -100) {
								such_adresse_plz = plz;
							} else {
								check = check + "z";
							}
						}
						if (z�hler == 3) {
							adresseingabe = false;
						}
						else {
							System.out.println(
									"\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit existiert nicht!");
						}
					}
				}

				// Telefonnummer
				if (eingabe == 6) {
					such_telefon = einlesen_Wort(kategorie, eingabe);
					if (such_telefon.equals("" + 0)) {
						such_telefon = telefon;
					} else {
						check = check + "e";
					}
				}

				// Suche abschlie�en
				if (eingabe == 7) {
					suchVorgang = false;

					// Vergleichsvariablen zu den Suchvariablen
					int vgl_interessentenID = -100;
					String vgl_name = "-";
					String vgl_vorname = "-";

					String vgl_adresse_stra�e = "-";
					int vgl_adresse_plz = -100;

					String vgl_EMail = "-";
					String vgl_telefon = "-";

					/*
					 * Wenn 'check' ein Buchstaben enth�lt war der Nutzer bei
					 * einer bestimmten Attributver�nderung. Wenn ein Buchstabe
					 * nicht enthalten ist, so ist der Suchwert und der
					 * Vergleichswert gleich. Wenn nun ein Buchstabe enthalten
					 * ist wird in jedem Interessentenobjekt nach der zu
					 * suchenden Eigenschaft gesucht und wenn diese gefunden
					 * wurde, wird das dazugeh�rige Objekt ausgegeben. Bei
					 * mehreren Buchstaben m�ssen alle eingegebene Suchattribute
					 * in einem Interessentenobjekt vorhanden sein, damit eine
					 * Ausgabe erm�glicht werden kann.
					 */
					for (Interessent interest : interestList) {

						if (check.contains("a")) {
							vgl_interessentenID = interest.getKundenID();
						}
						if (check.contains("b")) {
							vgl_name = interest.getName();
						}
						if (check.contains("c")) {
							vgl_vorname = interest.getVorname();
						}
						if (check.contains("d")) {
							vgl_EMail = interest.getEmail();
						}
						if (check.contains("y")) {
							vgl_adresse_stra�e = interest.getAdresse().getStrasse();
						}
						if (check.contains("z")) {
							vgl_adresse_plz = interest.getAdresse().getPlz();
						}
						if (check.contains("e")) {
							vgl_telefon = interest.getTelefonnummer();
						}

						/*
						 * Wenn alle Suchwerte mit den Vergleichswerten
						 * �bereinstimmen wird der Interessent ausgegeben.
						 */
						if (vgl_interessentenID == such_interessentenID && vgl_name.contains(such_name)
								&& vgl_vorname.contains(such_vorname) && vgl_EMail.contains(such_EMail)
								&& vgl_adresse_stra�e.contains(such_adresse_stra�e)
								&& vgl_adresse_plz == such_adresse_plz && vgl_telefon.contains(such_telefon)) {
							System.out.println("Interessenten ID:          " + interest.getKundenID());
							System.out.println("Name:                      " + interest.getName());
							System.out.println("Vorname:                   " + interest.getVorname());
							System.out.println("Geburtsdatum:              " + interest.getGeburtsdatum());
							System.out.println("E-Mail:                    " + interest.getEmail());
							System.out.println("Adresse:                   " + interest.getAdresse());
							System.out.println("Telefonnummer:             " + interest.getTelefonnummer());
							System.out.println("");
						}
					}
				}
				// Eingabe > 7
				else {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit existiert nicht!");
				}
			} catch (InputMismatchException e) {
				System.out.println(
						"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
			}
		}

	}

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

	private String einlesen_Wort(String[] auswahl, int z�hler) {
		System.out.println("Geben Sie ein: " + auswahl[z�hler - 1]);
		Scanner s = new Scanner(System.in);
		String wort = s.nextLine();
		return wort;
	}
}
