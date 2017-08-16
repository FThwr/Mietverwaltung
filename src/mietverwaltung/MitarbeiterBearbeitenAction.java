package mietverwaltung;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class MitarbeiterBearbeitenAction extends MenueManager implements Action {

	@Override
	public void action() {
		
		System.out.println("________________________________________ Mitarbeiter bearbeiten ________________________________________");

		Scanner s = new Scanner(System.in);
		System.out.println("\nWählen Sie den Mitarbeiter (ID) aus, den Sie bearbeiten möchten!\n");

		for (Mitarbeiter worker : workerList) {
			System.out.println(worker.getName() + "; " + worker.getVorname() + "  ID: " + worker.getMitarbeiterID() );
		}

		try {
			int zu_bearbeitenden_mitarbeiter = s.nextInt();

			boolean bearbeitungsVorgang = true;
			boolean mitarbeiterEingabe_erfolgreich = false;
			String [] kategorie = {"Mitarbeiter ID", "Name", "Vorname", "Passwort"};

			String längenAnpassung_mitarbeiterID = "";
			String längenAnpassung_Name = "";
			String längenAnpassung_Vorname = "";
			String längenAnpassnung_benutzername = "";
			String längenAnpassung_passwort = "";

			int aktuelleMitarbeiterID = -100;
			int neueMitarbeiterID = -100;

			String aktuellerName = "";
			String neuerName = "";		

			String aktuellerVorname = "";
			String neuerVorname = "";

			String aktuellerrBenutzername = "";
			String neuerBenutzername = "";
			
			String aktuellesPasswort = "";
			String neuesPasswort = "";
			
			for (Mitarbeiter worker : workerList) {
				if (zu_bearbeitenden_mitarbeiter == worker.getMitarbeiterID()) {

					mitarbeiterEingabe_erfolgreich = true;

					aktuelleMitarbeiterID = worker.getMitarbeiterID();
					neueMitarbeiterID = aktuelleMitarbeiterID;

					aktuellerName = worker.getName();
					neuerName = aktuellerName;

					aktuellerVorname = worker.getVorname();
					neuerVorname = aktuellerVorname;

					aktuellerrBenutzername = worker.getBenutzername();
					neuerBenutzername = aktuellerrBenutzername;
					
					aktuellesPasswort = worker.getPasswort();
					neuesPasswort = aktuellesPasswort;

					// Variablen zur verschönerten Ausgabe
					längenAnpassung_mitarbeiterID = "" + aktuelleMitarbeiterID;
					längenAnpassung_mitarbeiterID = länge_anpassen(längenAnpassung_mitarbeiterID);

					längenAnpassung_Name = aktuellerName;
					längenAnpassung_Name = länge_anpassen(längenAnpassung_Name);

					längenAnpassung_Vorname = aktuellerName;
					längenAnpassung_Vorname = länge_anpassen(längenAnpassung_Vorname);

					längenAnpassnung_benutzername = aktuellerrBenutzername;
					längenAnpassnung_benutzername = länge_anpassen(längenAnpassnung_benutzername);

					längenAnpassung_passwort = aktuellesPasswort;
					längenAnpassung_passwort = länge_anpassen(längenAnpassung_passwort);
				}
			}

			if (mitarbeiterEingabe_erfolgreich == true) {
				while (bearbeitungsVorgang == true) {

					System.out.println("Mitarbeiter ID: " + längenAnpassung_mitarbeiterID  + "neue Mitarbeiter ID: " + neueMitarbeiterID);
					System.out.println("Name:           " + längenAnpassung_Name           + "neuer Name:          " + neuerName);
					System.out.println("Vorname:        " + längenAnpassung_Vorname        + "neuer Vorame:        " + neuerVorname);
					System.out.println("Benutzername:   " + längenAnpassnung_benutzername  + "neuer Benutzername:  " + neuerBenutzername);
					System.out.println("Passwort:       " + längenAnpassung_passwort       + "neues Passwort:      " + neuesPasswort);
					System.out.println("");

					Scanner t = new Scanner(System.in);
					System.out.println(
							"............................... Wählen Sie die zu bearbeitende Eigenschaft aus! ..............................."
									+ "\n Drücke '1'  für Mitarbeiter ID  "
									+ "\n Drücke '2'  für Name  " 
									+ "\n Drücke '3'  für Vorname  "
									+ "\n Drücke '4'  für Passwort  "
									+ "\n Drücke '5'  für bestätigen  "
									+ "\n Drücke '0'  für abbruch der Suche!\n");

					try {
						int änderung = t.nextInt();

						if (änderung == 0) {
							bearbeitungsVorgang = false;
						}
						if (änderung == 1) {
							int eingabe = einlesen_Zahl(kategorie, änderung);
							if (eingabe == 0) {
								neueMitarbeiterID = aktuelleMitarbeiterID;
							} else {
								neueMitarbeiterID = eingabe;
							}
						}
						if (änderung == 2) {
							String neu = einlesen_Wort(kategorie, änderung);
							if (neu.equals("" + 0)) {
								neu = aktuellerName;
							} else {
								neuerName = neu;
							}
						}
						if (änderung == 3) {
							
							String neu = einlesen_Wort(kategorie, änderung);
							if (neu.equals("" + 0)) {
								neu = aktuellerVorname;
							} else {
								neuerVorname = neu;
							}
						}
						if (änderung == 4) {
							
							String neu = einlesen_Wort(kategorie, änderung);
							if (neu.equals("" + 0)) {
								neu = aktuellesPasswort;
							} else {
								neuesPasswort = neu;
							}
						}
						
						if (änderung == 5) {
							bearbeitungsVorgang = false;

								for (Mitarbeiter worker : workerList) {
									if (zu_bearbeitenden_mitarbeiter == worker.getMitarbeiterID()) {
										neuerBenutzername = neuerVorname.trim().substring(0, 1) + "." + neuerName;
										worker.setMitarbeiterID(neueMitarbeiterID);
										worker.setName(neuerName);
										worker.setVorname(neuerVorname);
										worker.setBenutzername(neuerBenutzername);
										worker.setPasswort(neuesPasswort);
									}
								}
								for (Wohnung flat : flatList) {
									if (aktuellerName.equals(flat.getZugeordneterMitarbeiter().getName())) {
										flat.getZugeordneterMitarbeiter().setName(neuerName);;
									}
								}
						}
						
					} catch (InputMismatchException e) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
					}
				}
			} 
			else {
				System.out.println("------------------------------- Fehler! ------------------------------- \nIhre Eingabe war nicht erfolgreich, weil die ID nicht existiert!\n");
			}
		} catch (InputMismatchException e) {
			System.out.println(
					"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
		}
	}

	private int einlesen_Zahl(String [] auswahl, int zähler) {
		System.out.println("Geben Sie ein: " + auswahl[zähler-1]);
		Scanner s = new Scanner(System.in);
		int wort = s.nextInt();
		return wort;
	}
	
	private String einlesen_Wort(String [] auswahl, int zähler) {
		System.out.println("Geben Sie ein: " + auswahl[zähler-1]);
		Scanner s = new Scanner(System.in);
		String wort = s.next();
		return wort;
	}

	private String länge_anpassen_Datum(Datum a_GD) {

		String leerzeichen = "";

		String jahr = "" + a_GD.getJahr();
		int l_J = jahr.length();

		String monat = "" + a_GD.getMonat();
		int l_M = monat.length();

		String tag = "" + a_GD.getTag();
		int l_T = tag.length();

		int abzug = l_J + l_M + l_T + 2; // +2 für die Punkte zwischen den
											// Komponenten
		if (abzug < 50) {
			while (abzug < 50) {
				leerzeichen = leerzeichen + " ";
				abzug += 1;
			}
		}
		return leerzeichen;
	}

	private String länge_anpassen(String wort) {

		int abzug = wort.length();
		if (wort.length() < 50) {
			while (wort.length() < 50) {
				wort = wort + " ";
			}
		}
		return wort;
	}

	private String länge_anpassen_Adresse(Adresse a_A) {

		String leerzeichen = "";

		String hausnummer = "" + a_A.getHausnummer();
		int l_HN = hausnummer.length();

		String platz = "" + a_A.getPlz();
		int l_P = platz.length();

		String stadt = a_A.getStadt();
		int l_ST = stadt.length();

		String straße = a_A.getStrasse();
		int l_SR = straße.length();

		int abzug = l_HN + l_P + l_SR + l_ST + 3; // +3 für die Leerzeichen
													// zwischen den Komponenten
		if (abzug < 50) {
			while (abzug < 50) {
				leerzeichen = leerzeichen + " ";
				abzug += 1;
			}
		}
		return leerzeichen;
	}
}
