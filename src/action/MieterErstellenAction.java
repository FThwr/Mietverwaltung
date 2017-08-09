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
					"...............................Wählen Sie die zu erstellende Eigenschaft aus...............................!  "
							+ "\n Drücke '1' für Kunden ID  " + "\n Drücke '2' für Nachname  "
							+ "\n Drücke '3' für Name  " + "\n Drücke '4' für Geburtsdatum  "
							+ "\n Drücke '5' für Wohnung  " + "\n Drücke '6' für E-Mail  "
							+ "\n Drücke '7' für Adresse  " + "\n Drücke '8' für bestätigen  "
							+ "\n Drücke '0' für abbruch der Suche!\n");
			try {
				int änderung = t.nextInt();

				if (änderung == 0) {
					System.out.println(
							"-------------------------------Erstellvorgang wurde abgebrochen!-------------------------------");
					erstellVorgang = false;
				}
				if (änderung == 1) {
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
				if (änderung == 2) {
					Scanner u = new Scanner(System.in);
					System.out.println("Erstellen: Nachname eingeben!");
					String neu = u.next();
					if (neu.equals("" + 0)) {
						neu = nachname;
					} else {
						nachname = neu;
					}
				}
				if (änderung == 3) {
					Scanner u = new Scanner(System.in);
					System.out.println("Erstellen: Name eingeben!");
					String neu = u.next();
					if (neu.equals("" + 0)) {
						neu = name;
					} else {
						name = neu;
					}
				}
				if (änderung == 4) {
					Scanner u = new Scanner(System.in);
					System.out.println("Erstellen: Geburtsdatum eingeben!");
					String neu = u.next();
					if (neu.equals("" + 0)) {
						neu = geburtsdatum;
					} else {
						geburtsdatum = neu;
					}
				}
				if (änderung == 5) {
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
				if (änderung == 6) {
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
				if (änderung == 7) {
					Scanner u = new Scanner(System.in);
					System.out.println("Erstellen: Adresse eingeben!");
					String neu = u.next();
					if (neu.equals("" + 0)) {
						neu = adresse;
					} else {
						adresse = neu;
					}
				}
				if (änderung == 8) {
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