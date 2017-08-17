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

		String stra�e = "";
		int hausnummer = -100;
		int platz = -100;
		String stadt = "";

		String such_adresse_stra�e = "-";
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
					"............................... W�hlen Sie die zu suchende Eigenschaft aus! ..............................."
							+ "\n Dr�cke '1' f�r Interessenten ID  " 
							+ "\n Dr�cke '2' f�r Name  "
							+ "\n Dr�cke '3' f�r Vorname  " 
							+ "\n Dr�cke '4' f�r E-Mail  "
							+ "\n Dr�cke '5' f�r Adresse  " 
							+ "\n Dr�cke '6' f�r Telefonnummer  "
							+ "\n Dr�cke '7' f�r best�tigen  " 
							+ "\n Dr�cke '0' f�r abbruch der Suche!\n");

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
			System.out.println("Adresse Stra�e:            " + such_adresse_stra�e);
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
					System.out.println("Dr�cke '1' f�r Stra�e: ");
					System.out.println("Dr�cke '2' f�r Hausnummer: ");
					System.out.println("Dr�cke '3' f�r Platz: ");
					System.out.println("Dr�cke '4' f�r Stadt: ");
					System.out.println("Dr�cke '5' f�r Abbruch: ");

					String[] auswahl = { "Stra�e", "Hausnummer", "Platz", "Stadt" };
					boolean adresseingabe = true;

					while (adresseingabe == true) {

						Scanner q = new Scanner(System.in);
						int z�hler = q.nextInt();

						if (z�hler == 1) {
							such_adresse_stra�e = einlesen_Wort(auswahl, z�hler);
							if (such_adresse_stra�e.equals("" + 0)) {
								such_adresse_stra�e = stra�e;
							} else {
								check = check + "w";
							}
						}

						if (z�hler == 2) {
							such_adresse_hausnummer = einlesen_Zahl(auswahl, z�hler);
							if (such_adresse_hausnummer == 0 || such_adresse_hausnummer == -100) {
								such_adresse_hausnummer = hausnummer;
							} else {
								check = check + "x";
							}
						}
						if (z�hler == 3) {
							such_adresse_platz = einlesen_Zahl(auswahl, z�hler);
							if (such_adresse_platz == 0 || such_adresse_platz == -100) {
								such_adresse_platz = platz;
							} else {
								check = check + "y";
							}
						}
						
						if (z�hler == 4) {
							such_adresse_stadt = einlesen_Wort(auswahl, z�hler);
							if (such_adresse_stadt.equals("" + 0)) {
								such_adresse_stadt = stadt;
							} else {
								check = check + "z";
							}
						}
						if (z�hler == 5) {
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

					String vgl_adresse_stra�e = "-";
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
							vgl_adresse_stra�e = interest.getAdresse().getStrasse();
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
								&& vgl_adresse_stra�e.contains(such_adresse_stra�e)
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

	private int einlesen_Zahl(String[] auswahl, int z�hler) {
		System.out.println("Geben Sie ein: " + auswahl[z�hler - 1]);
		Scanner s = new Scanner(System.in);
		int wort = s.nextInt();
		return wort;
	}

	private String einlesen_Wort(String[] auswahl, int z�hler) {
		System.out.println("Geben Sie ein: " + auswahl[z�hler - 1]);
		Scanner s = new Scanner(System.in);
		String wort = s.next();
		return wort;
	}
}
