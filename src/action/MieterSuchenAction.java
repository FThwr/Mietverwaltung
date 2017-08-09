package action;

import java.util.InputMismatchException;
import java.util.Scanner;

import hilfsklassen.Adresse;
import hilfsklassen.Datum;
import menue.MenueManager;
import objekte.Mieter;

public class MieterSuchenAction extends MenueManager implements Action {

	@Override
	public void action() {

		boolean suchVorgang = true;

		int kID = -100;
		int such_kID = kID;

		String nachname = "-";
		String such_nachname = nachname;

		String name = "-";
		String such_name = name;

		String geburtsdatum = "-";
		String such_geburtsdatum = geburtsdatum;

		int wohnung = -100;
		int such_wohnung = wohnung;

		String EMail = "-";
		String such_EMail = EMail;

		String adresse = "-";
		String such_adresse = adresse;

		String telefon = "-";
		String such_telefon = telefon;

		String check = "";

		while (suchVorgang == true) {

			Scanner s = new Scanner(System.in);
			System.out.println(
					"............................... W�hlen Sie die zu suchende Eigenschaft aus! ..............................."
							+ "\n Dr�cke '1' f�r Kunden ID  " + "\n Dr�cke '2' f�r Nachname  "
							+ "\n Dr�cke '3' f�r Name  " + "\n Dr�cke '4' f�r Geburtsdatum  " 
							
							+ "\n Dr�cke '5' f�r Wohnung  " + "\n Dr�cke '6' f�r E-Mail  "
							+ "\n Dr�cke '7' f�r Adresse  " + "\n Dr�cke '8' f�r Telefonnummer  "
							+ "\n Dr�cke '9' f�r best�tigen  " + "\n Dr�cke '0' f�r abbruch der Suche!\n");

			System.out.println("........... Aktuelle Suche nach: ..........." + "\n Kunden ID:           " + such_kID
					+ "\n Nachname:            " + such_nachname + "\n Name:                " + such_name
					+ "\n Geburtsdatum:        " + such_geburtsdatum + "\n Wohnung:             " + such_wohnung
					+ "\n E-Mail:        	   " + such_EMail + "\n Adresse:             " + such_adresse
					+ "\n Telefonnummer:       " + such_telefon);
			System.out.println("");
			try {
				int eingabe = s.nextInt();

				if (eingabe == 0) {
					suchVorgang = false;
				}
				if (eingabe == 1) {
					Scanner t = new Scanner(System.in);
					System.out.println("........... Suchen: Kunden ID eingeben! ...........");
					try {
						such_kID = t.nextInt();
						if (such_kID == 0) {
							such_kID = kID;
						} else {
							check = check + "a";
						}
					} catch (InputMismatchException e) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
					}
				}
				if (eingabe == 2) {
					Scanner t = new Scanner(System.in);
					System.out.println("........... Suchen: Nachname eingeben! ...........");
					such_nachname = t.next();
					if (such_nachname.equals("" + 0)) {
						such_nachname = nachname;
					} else {
						check = check + "b";
					}
				}
				if (eingabe == 3) {
					Scanner t = new Scanner(System.in);
					System.out.println("........... Suchen: Name eingeben! ...........");
					such_name = t.next();
					if (such_name.equals("" + 0)) {
						such_name = name;
					} else {
						check = check + "c";
					}
				}
				if (eingabe == 4) {
					Scanner t = new Scanner(System.in);
					System.out.println("........... Suchen: Geburtsdatum eingeben! ...........");
					such_nachname = t.next();
					if (such_geburtsdatum.equals("" + 0)) {
						such_geburtsdatum = geburtsdatum;
					} else {
						check = check + "d";
					}
				}
				if (eingabe == 5) {
					Scanner t = new Scanner(System.in);
					System.out.println("........... Suchen: Wohnung eingeben! ...........");
					try {
						such_wohnung = t.nextInt();
						if (such_wohnung == 0) {
							such_wohnung = wohnung;
						} else {
							check = check + "e";
						}
					} catch (InputMismatchException e) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
					}
				}
				if (eingabe == 6) {
					Scanner t = new Scanner(System.in);
					System.out.println("........... Suchen: EMail eingeben! ...........");
					such_EMail = t.next();
					if (such_EMail.equals("" + 0)) {
						such_EMail = EMail;
					} else {
						check = check + "f";
					}
				}
				if (eingabe == 7) {
					Scanner t = new Scanner(System.in);
					System.out.println("........... Suchen: Adresse eingeben! ...........");
					such_adresse = t.nextLine();
					if (such_adresse.equals("" + 0)) {
						such_adresse = adresse;
					} else {
						check = check + "g";
					}
				}
				if (eingabe == 8) {
					Scanner t = new Scanner(System.in);
					System.out.println("........... Suchen: Telefonnummer eingeben! ...........");
					such_telefon = t.next();
					if (such_telefon.equals("" + 0)) {
						such_telefon = telefon;
					} else {
						check = check + "h";
					}
				}

				if (eingabe == 9) {
					suchVorgang = false;

					int vgl_kID = -100;
					String vgl_nachname = "-";
					String vgl_name = "-";
					Datum vgl_geburtsdatum;
					int vgl_wohnung = -100;
					String vgl_EMail = "-";
					Adresse vgl_adresse;
					String vgl_telefon = "-";

					for (Mieter owner : ownerList) {

						if (check.contains("a")) {
							vgl_kID = owner.getKundenID();
						}
						if (check.contains("b")) {
							vgl_nachname = owner.getName();
						}
						if (check.contains("c")) {
							vgl_name = owner.getVorname();
						}
						if (check.contains("d")) {
							vgl_geburtsdatum = owner.getGeburtsdatum();
						}
						if (check.contains("e")) {
							vgl_wohnung = owner.getWohnungsnummer();
						}
						if (check.contains("f")) {
							vgl_EMail = owner.getEmail();
						}
						if (check.contains("g")) {
							vgl_adresse = owner.getAdresse();
						}
						if (check.contains("h")) {
							vgl_telefon = owner.getTelefonnummer();
						}

						if (vgl_kID == such_kID && vgl_nachname.contains(such_nachname) && vgl_name.contains(such_name)
								&& vgl_geburtsdatum.contains(such_geburtsdatum) && vgl_wohnung == such_wohnung
								&& vgl_EMail.contains(such_EMail) && vgl_adresse.contains(such_adresse)
								&& vgl_telefon.contains(such_telefon)) {
							System.out.println("Kunden ID:          " + owner.getKundenID());
							System.out.println("Nachname:           " + owner.getName());
							System.out.println("Name:               " + owner.getVorname());
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
}