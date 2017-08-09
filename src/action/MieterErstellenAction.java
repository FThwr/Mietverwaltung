package action;

import java.util.InputMismatchException;
import java.util.Scanner;

import hilfsklassen.Adresse;
import hilfsklassen.Datum;
import menue.MenueManager;
import objekte.Mieter;
import objekte.Wohnung;

public class MieterErstellenAction extends MenueManager implements Action {

	@Override
	public void action() {

		boolean erstellVorgang = true;

		int kID = -100;
		String nachname = "-";
		String name = "-";
		Datum geburtsdatum;
		int wohnung = -100;
		String EMail = "";
		Adresse adresse;
		String telefon = "";
		String status = "Mieter";

		while (erstellVorgang == true) {

			System.out.println("Kunden ID:      " + kID);
			System.out.println("Nachname:       " + nachname);
			System.out.println("Name:           " + name);
			System.out.println("Geburtsdatum:   " + geburtsdatum);
			System.out.println("Wohnung:        " + wohnung);
			System.out.println("E-Mail:         " + EMail);
			System.out.println("Adresse:        " + adresse);
			System.out.println("Telefon:        " + telefon);
			System.out.println("");

			Scanner t = new Scanner(System.in);
			System.out.println(
					"...............................W�hlen Sie die zu erstellende Eigenschaft aus...............................!  "
							+ "\n Dr�cke '1' f�r Kunden ID  " + "\n Dr�cke '2' f�r Nachname  "
							+ "\n Dr�cke '3' f�r Name  " + "\n Dr�cke '4' f�r Geburtsdatum  "
							+ "\n Dr�cke '5' f�r Wohnung  " + "\n Dr�cke '6' f�r E-Mail  "
							+ "\n Dr�cke '7' f�r Adresse  " + "\n Dr�cke '8' f�r best�tigen  "
							+ "\n Dr�cke '0' f�r abbruch der Suche!\n");
			try {
				int �nderung = t.nextInt();

				if (�nderung == 0) {
					System.out.println(
							"-------------------------------Erstellvorgang wurde abgebrochen!-------------------------------");
					erstellVorgang = false;
				}
				if (�nderung == 1) {
					Scanner u = new Scanner(System.in);
					System.out.println("Erstellen: Kunden ID eingeben!");
					try {
						int neu = u.nextInt();
						if (neu == 0) {
							neu = kID;
						} else {
							int nichtVorhanden = 0;
							for (Mieter owner : ownerList) {
								if (neu == owner.getKundenID()) {
									nichtVorhanden = 1;
								}
							}
							if (nichtVorhanden == 1) {
								System.out.println(
										"\n------------------------------- Kunden ID bereits vergeben! -------------------------------");
							} else {
								kID = neu;
							}
						}
					} catch (InputMismatchException e) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
					}
				}
				if (�nderung == 2) {
					Scanner u = new Scanner(System.in);
					System.out.println("Erstellen: Nachname eingeben!");
					String neu = u.next();
					if (neu.equals("" + 0)) {
						neu = nachname;
					} else {
						nachname = neu;
					}
				}
				if (�nderung == 3) {
					Scanner u = new Scanner(System.in);
					System.out.println("Erstellen: Name eingeben!");
					String neu = u.next();
					if (neu.equals("" + 0)) {
						neu = name;
					} else {
						name = neu;
					}
				}
				if (�nderung == 4) {
					Scanner u = new Scanner(System.in);
					System.out.println("Erstellen: Geburtsdatum eingeben!");
					String neu = u.next();
					if (neu.equals("" + 0)) {
						neu = geburtsdatum;
					} else {
						geburtsdatum = neu;
					}
				}
				if (�nderung == 5) {
					Scanner u = new Scanner(System.in);
					System.out.println("Erstellen: Wohnung eingeben!");
					try {
						int neu = u.nextInt();
						if (neu == 0) {
							neu = wohnung;
						} else {
							int nichtVorhanden = 0;
							for (Wohnung flat : flatList) {
								for (Mieter owner : ownerList) {
									// nur wenn die Wohnung von keinem anderen
									// Mieter
									// belegt
									// ist und die Wohnung existiert
									if (owner.getWohnungsnummer() != neu && neu == flat.getWohnungsID()) {
										nichtVorhanden = 1;

									}
									if (owner.getWohnungsnummer() == neu) {
										// mieter bereits in wohnung
										nichtVorhanden = 2;

									}

								}
							}
							if (nichtVorhanden == 1) {
								wohnung = neu;
							}
							if (nichtVorhanden == 2) {
								System.out.println(
										"------------------------------- Fehler! Wohnung bereits von einem anderen Mieter belegt! -------------------------------");
							}
							if (nichtVorhanden != 2 && nichtVorhanden != 1) {
								System.out.println(
										"------------------------------- Fehler! Wohnung existiert nicht! -------------------------------");
							}
						}
					} catch (InputMismatchException e) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
					}
				}
				if (�nderung == 6) {
					Scanner u = new Scanner(System.in);
					System.out.println(
							"------------------------------- Erstellen: E-Mail eingeben! -------------------------------");
					String neu = u.next();
					if (neu.equals("" + 0)) {
						neu = EMail;
					} else {
						EMail = neu;
					}
				}
				if (�nderung == 7) {
					Scanner u = new Scanner(System.in);
					System.out.println("Erstellen: Adresse eingeben!");
					String neu = u.next();
					if (neu.equals("" + 0)) {
						neu = adresse;
					} else {
						adresse = neu;
					}
				}
				if (�nderung == 8) {
					System.out.println("Mieter wurde erfolgreich angelegt!");
					erstellVorgang = false;
					ownerList.add(
							new Mieter(kID, nachname, name, geburtsdatum, wohnung, EMail, adresse, telefon, status));
				}
			} catch (InputMismatchException e) {
				System.out.println(
						"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
			}
		}
	}
}