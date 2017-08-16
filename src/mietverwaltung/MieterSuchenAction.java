package mietverwaltung;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MieterSuchenAction extends MenueManager implements Action {

	@Override
	public void action() {

		System.out.println(
				"________________________________________ Mieter suchen ________________________________________");

		boolean suchVorgang = true;

		int mieterID = -100;
		int such_mieterID = mieterID;

		String name = "-";
		String such_name = name;

		String vorname = "-";
		String such_vorname = vorname;

		int wohnung = -100;
		int such_wohnung = wohnung;

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

		String[] kategorie = { "Mieter ID", "Name", "Vorname", "Wohnung", "E-Mail", "Adresse", "Telefonnummer" };

		String check = "";

		while (suchVorgang == true) {

			Scanner s = new Scanner(System.in);
			System.out.println(
					"............................... W�hlen Sie die zu suchende Eigenschaft aus! ..............................."
							+ "\n Dr�cke '1' f�r Kunden ID  " 
							+ "\n Dr�cke '2' f�r Nachname  "
							+ "\n Dr�cke '3' f�r Name  " 
							+ "\n Dr�cke '4' f�r Wohnung  " 
							+ "\n Dr�cke '5' f�r E-Mail  "
							+ "\n Dr�cke '6' f�r Adresse  " 
							+ "\n Dr�cke '7' f�r Telefonnummer  "
							+ "\n Dr�cke '8' f�r best�tigen  " 
							+ "\n Dr�cke '0' f�r abbruch der Suche!\n");

			System.out.println("........... Aktuelle Suche nach: ...........");
			if (such_mieterID != -100) {
				System.out.println("Kunden ID:                 " + such_mieterID);
			} else {
				System.out.println("Kunden ID:                 " + "-");
			}
			System.out.println("Name:                  " + such_name);
			System.out.println("Vorname:                      " + such_vorname);
			if (such_wohnung != -100) {
				System.out.println("Wohnung:                   " + such_wohnung);
			} else {
				System.out.println("Wohnung:                   " + "-");
			}
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
						such_mieterID = einlesen_Zahl(kategorie, eingabe);
						if (such_mieterID == 0) {
							such_mieterID = mieterID;
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

					try {
						such_wohnung = einlesen_Zahl(kategorie, eingabe);
						if (such_wohnung == 0) {
							such_wohnung = wohnung;
						} else {
							check = check + "d";
						}
					} catch (InputMismatchException e) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
					}
				}
				if (eingabe == 5) {
					such_EMail = einlesen_Wort(kategorie, eingabe);
					if (such_EMail.equals("" + 0)) {
						such_EMail = EMail;
					} else {
						check = check + "e";
					}
				}
				if (eingabe == 6) {
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
				if (eingabe == 7) {
					such_telefon = einlesen_Wort(kategorie, eingabe);
					if (such_telefon.equals("" + 0)) {
						such_telefon = telefon;
					} else {
						check = check + "f";
					}
				}

				if (eingabe == 8) {
					suchVorgang = false;

					int vgl_mieterID = -100;
					String vgl_name = "-";
					String vgl_vorname = "-";

					int vgl_wohnung = -100;
					String vgl_EMail = "-";

					String vgl_adresse_stra�e = "-";
					int vgl_adresse_hausnummer = -100;
					int vgl_adresse_platz = -100;
					String vgl_adresse_stadt = "-";

					String vgl_telefon = "-";

					for (Mieter owner : ownerList) {

						if (check.contains("a")) {
							vgl_mieterID = owner.getKundenID();
						}
						if (check.contains("b")) {
							vgl_name = owner.getName();
						}
						if (check.contains("c")) {
							vgl_vorname = owner.getVorname();
						}
						if (check.contains("d")) {
							vgl_wohnung = owner.getWohnungsnummer();
						}
						if (check.contains("e")) {
							vgl_EMail = owner.getEmail();
						}
						if (check.contains("w")) {
							vgl_adresse_stra�e = owner.getAdresse().getStrasse();
						}
						if (check.contains("x")) {
							vgl_adresse_hausnummer = owner.getAdresse().getHausnummer();
						}
						if (check.contains("y")) {
							vgl_adresse_platz = owner.getAdresse().getPlz();
						}
						if (check.contains("z")) {	
						vgl_adresse_stadt = owner.getAdresse().getStadt();
						}
						if (check.contains("f")) {
							vgl_telefon = owner.getTelefonnummer();
						}

						if (vgl_mieterID == such_mieterID && vgl_name.contains(such_name) && vgl_vorname.contains(such_vorname)
								&& vgl_wohnung == such_wohnung && vgl_EMail.contains(such_EMail)
								&& vgl_adresse_stra�e.contains(such_adresse_stra�e)
								&& vgl_adresse_stadt.contains(such_adresse_stadt)
								&& vgl_adresse_hausnummer == such_adresse_hausnummer
								&& vgl_adresse_platz == such_adresse_platz && vgl_telefon.contains(such_telefon)) {
							System.out.println("Mieter ID:          " + owner.getKundenID());
							System.out.println("Name:               " + owner.getName());
							System.out.println("Vorname:            " + owner.getVorname());
							System.out.println("Geburtsdatum:       " + owner.getGeburtsdatum());
							System.out.println("Wohnung:            " + owner.getWohnungsnummer());
							System.out.println("E-Mail:             " + owner.getEmail());
							System.out.println("Adresse:            " + owner.getAdresse());
							System.out.println("Telefonnummer:      " + owner.getTelefonnummer());
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