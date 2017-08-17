package mietverwaltung.action;

import java.util.InputMismatchException;
import java.util.Scanner;

import mietverwaltung.Interessent;
import mietverwaltung.menu.MenuManager;

public class InteressentSuchenAction extends MenuManager implements Action {

	@Override
	public void action() {

		System.out.println(
				"________________________________________ Interessent suchen ________________________________________");

		boolean suchVorgang = true;

		int interessentenID = -100;
		int such_interessentenID = interessentenID;

		String name = "-";
		String such_name = name;

		String vorname = "-";
		String such_vorname = vorname;

		String EMail = "-";
		String such_EMail = EMail;

		String straße = "";
		int hausnummer = -100;
		int platz = -100;
		String stadt = "";

		String such_adresse_straße = "-";
		int such_adresse_hausnummer = -100;
		int such_adresse_platz = -100;
		String such_adresse_stadt = "-";

		String telefon = "-";
		String such_telefon = telefon;

		String[] kategorie = { "Interessenten ID", "Name", "Vorname", "E-Mail", "Adresse", "Telefonnummer" };

		String check = "";

		while (suchVorgang == true) {

			Scanner s = new Scanner(System.in);
			System.out.println(
					"............................... Wählen Sie die zu suchende Eigenschaft aus! ..............................."
							+ "\n Drücke '1' für Interessenten ID  " 
							+ "\n Drücke '2' für Name  "
							+ "\n Drücke '3' für Vorname  " 
							+ "\n Drücke '4' für E-Mail  "
							+ "\n Drücke '5' für Adresse  " 
							+ "\n Drücke '6' für Telefonnummer  "
							+ "\n Drücke '7' für bestätigen  " 
							+ "\n Drücke '0' für abbruch der Suche!\n");

			System.out.println("........... Aktuelle Suche nach: ...........");
			if (such_interessentenID != -100) {
				System.out.println("Interessenten ID:                 " + such_interessentenID);
			} 
			else {
				System.out.println("Interessenten ID:                 " + "-");
			}
			System.out.println("Name:                  " + such_name);
			System.out.println("Vorname:                  " + such_vorname);
			System.out.println("E-Mail:                    " + such_EMail);
			System.out.println("Adresse Straße:            " + such_adresse_straße);
			if (hausnummer != -100) {
				System.out.println("Adresse Hausnummer:        " + such_adresse_hausnummer);
			}
			else {
				System.out.println("Adresse Hausnummer: " + "-" );
			}
			if (platz != -100) {
			System.out.println("Adresse Platz:             " + such_adresse_platz);
			}
			else {
				System.out.println("Adresse Platz: " + "-");
			}
			System.out.println("Adresse Stadt:             " + such_adresse_stadt);
			System.out.println("Telefonnummer:             " + such_telefon);
			System.out.println("");
			try {
				int eingabe = s.nextInt();

				if (eingabe == 0) {
					suchVorgang = false;
				}
				if (eingabe == 1) {
					try {
						such_interessentenID = einlesen_Zahl(kategorie, eingabe);
						if (such_interessentenID == 0) {
							such_interessentenID = interessentenID;
						} else {
							check = check + "a";
						}
					} catch (InputMismatchException e) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
					}
				}
				if (eingabe == 2) {
					such_name = einlesen_Wort(kategorie, eingabe);
					if (such_name.equals("" + 0)) {
						such_name = name;
					} else {
						check = check + "b";
					}
				}
				if (eingabe == 3) {
					such_name = einlesen_Wort(kategorie, eingabe);
					if (such_vorname.equals("" + 0)) {
						such_vorname = vorname;
					} else {
						check = check + "c";
					}
				}
				if (eingabe == 4) {
					such_EMail = einlesen_Wort(kategorie, eingabe);
					if (such_EMail.equals("" + 0)) {
						such_EMail = EMail;
					} else {
						check = check + "d";
					}
				}
				if (eingabe == 5) {
					System.out.println("Spezialisierung der zu suchenden Adresse: ");
					System.out.println("Drücke '1' für Straße: ");
					System.out.println("Drücke '2' für Hausnummer: ");
					System.out.println("Drücke '3' für Platz: ");
					System.out.println("Drücke '4' für Stadt: ");
					System.out.println("Drücke '5' für Abbruch: ");

					String[] auswahl = { "Straße", "Hausnummer", "Platz", "Stadt" };
					boolean adresseingabe = true;

					while (adresseingabe == true) {

						Scanner q = new Scanner(System.in);
						int zähler = q.nextInt();

						if (zähler == 1) {
							such_adresse_straße = einlesen_Wort(auswahl, zähler);
							if (such_adresse_straße.equals("" + 0)) {
								such_adresse_straße = straße;
							} else {
								check = check + "w";
							}
						}

						if (zähler == 2) {
							such_adresse_hausnummer = einlesen_Zahl(auswahl, zähler);
							if (such_adresse_hausnummer == 0 || such_adresse_hausnummer == -100) {
								such_adresse_hausnummer = hausnummer;
							} else {
								check = check + "x";
							}
						}
						if (zähler == 3) {
							such_adresse_platz = einlesen_Zahl(auswahl, zähler);
							if (such_adresse_platz == 0 || such_adresse_platz == -100) {
								such_adresse_platz = platz;
							} else {
								check = check + "y";
							}
						}
						
						if (zähler == 4) {
							such_adresse_stadt = einlesen_Wort(auswahl, zähler);
							if (such_adresse_stadt.equals("" + 0)) {
								such_adresse_stadt = stadt;
							} else {
								check = check + "z";
							}
						}
						if (zähler == 5) {
							adresseingabe = false;
						}
					}
				}
				if (eingabe == 6) {
					such_telefon = einlesen_Wort(kategorie, eingabe);
					if (such_telefon.equals("" + 0)) {
						such_telefon = telefon;
					} else {
						check = check + "e";
					}
				}

				if (eingabe == 7) {
					suchVorgang = false;

					int vgl_interessentenID = -100;
					String vgl_name = "-";
					String vgl_vorname = "-";

					String vgl_adresse_straße = "-";
					int vgl_adresse_hausnummer = -100;
					int vgl_adresse_platz = -100;
					String vgl_adresse_stadt = "-";
					
					String vgl_EMail = "-"; 
					String vgl_telefon = "-";

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
						if (check.contains("w")) {
							vgl_adresse_straße = interest.getAdresse().getStrasse();
						}
						if (check.contains("x")) {
							vgl_adresse_hausnummer = interest.getAdresse().getHausnummer();
						}
						if (check.contains("y")) {
							vgl_adresse_platz = interest.getAdresse().getPlz();
						}
						if (check.contains("z")) {	
						vgl_adresse_stadt = interest.getAdresse().getStadt();
						}
						if (check.contains("e")) {
							vgl_telefon = interest.getTelefonnummer();
						}

						if (vgl_interessentenID == such_interessentenID && vgl_name.contains(such_name) && vgl_vorname.contains(such_vorname)
								&& vgl_EMail.contains(such_EMail)
								&& vgl_adresse_straße.contains(such_adresse_straße)
								&& vgl_adresse_stadt.contains(such_adresse_stadt)
								&& vgl_adresse_hausnummer == such_adresse_hausnummer
								&& vgl_adresse_platz == such_adresse_platz && vgl_telefon.contains(such_telefon)) {
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
			} catch (InputMismatchException e) {
				System.out.println(
						"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
			}
		}
	}

	private int einlesen_Zahl(String[] auswahl, int zähler) {
		System.out.println("Geben Sie ein: " + auswahl[zähler - 1]);
		Scanner s = new Scanner(System.in);
		int wort = s.nextInt();
		return wort;
	}

	private String einlesen_Wort(String[] auswahl, int zähler) {
		System.out.println("Geben Sie ein: " + auswahl[zähler - 1]);
		Scanner s = new Scanner(System.in);
		String wort = s.next();
		return wort;
	}
}
