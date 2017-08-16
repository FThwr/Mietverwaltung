package mietverwaltung;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class MitarbeiterBearbeitenAction extends MenueManager implements Action {

	@Override
	public void action() {
		
		System.out.println("________________________________________ Mitarbeiter bearbeiten ________________________________________");

		Scanner s = new Scanner(System.in);
		System.out.println("\nW�hlen Sie den Mitarbeiter (ID) aus, den Sie bearbeiten m�chten!\n");

		for (Mitarbeiter worker : workerList) {
			System.out.println(worker.getName() + "; " + worker.getVorname() + "  ID: " + worker.getMitarbeiterID() );
		}

		try {
			int zu_bearbeitenden_mitarbeiter = s.nextInt();

			boolean bearbeitungsVorgang = true;
			boolean mitarbeiterEingabe_erfolgreich = false;
			String [] kategorie = {"Mitarbeiter ID", "Name", "Vorname", "Passwort"};

			String l�ngenAnpassung_mitarbeiterID = "";
			String l�ngenAnpassung_Name = "";
			String l�ngenAnpassung_Vorname = "";
			String l�ngenAnpassnung_benutzername = "";
			String l�ngenAnpassung_passwort = "";

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

					// Variablen zur versch�nerten Ausgabe
					l�ngenAnpassung_mitarbeiterID = "" + aktuelleMitarbeiterID;
					l�ngenAnpassung_mitarbeiterID = l�nge_anpassen(l�ngenAnpassung_mitarbeiterID);

					l�ngenAnpassung_Name = aktuellerName;
					l�ngenAnpassung_Name = l�nge_anpassen(l�ngenAnpassung_Name);

					l�ngenAnpassung_Vorname = aktuellerName;
					l�ngenAnpassung_Vorname = l�nge_anpassen(l�ngenAnpassung_Vorname);

					l�ngenAnpassnung_benutzername = aktuellerrBenutzername;
					l�ngenAnpassnung_benutzername = l�nge_anpassen(l�ngenAnpassnung_benutzername);

					l�ngenAnpassung_passwort = aktuellesPasswort;
					l�ngenAnpassung_passwort = l�nge_anpassen(l�ngenAnpassung_passwort);
				}
			}

			if (mitarbeiterEingabe_erfolgreich == true) {
				while (bearbeitungsVorgang == true) {

					System.out.println("Mitarbeiter ID: " + l�ngenAnpassung_mitarbeiterID  + "neue Mitarbeiter ID: " + neueMitarbeiterID);
					System.out.println("Name:           " + l�ngenAnpassung_Name           + "neuer Name:          " + neuerName);
					System.out.println("Vorname:        " + l�ngenAnpassung_Vorname        + "neuer Vorame:        " + neuerVorname);
					System.out.println("Benutzername:   " + l�ngenAnpassnung_benutzername  + "neuer Benutzername:  " + neuerBenutzername);
					System.out.println("Passwort:       " + l�ngenAnpassung_passwort       + "neues Passwort:      " + neuesPasswort);
					System.out.println("");

					Scanner t = new Scanner(System.in);
					System.out.println(
							"............................... W�hlen Sie die zu bearbeitende Eigenschaft aus! ..............................."
									+ "\n Dr�cke '1'  f�r Mitarbeiter ID  "
									+ "\n Dr�cke '2'  f�r Name  " 
									+ "\n Dr�cke '3'  f�r Vorname  "
									+ "\n Dr�cke '4'  f�r Passwort  "
									+ "\n Dr�cke '5'  f�r best�tigen  "
									+ "\n Dr�cke '0'  f�r abbruch der Suche!\n");

					try {
						int �nderung = t.nextInt();

						if (�nderung == 0) {
							bearbeitungsVorgang = false;
						}
						if (�nderung == 1) {
							int eingabe = einlesen_Zahl(kategorie, �nderung);
							if (eingabe == 0) {
								neueMitarbeiterID = aktuelleMitarbeiterID;
							} else {
								neueMitarbeiterID = eingabe;
							}
						}
						if (�nderung == 2) {
							String neu = einlesen_Wort(kategorie, �nderung);
							if (neu.equals("" + 0)) {
								neu = aktuellerName;
							} else {
								neuerName = neu;
							}
						}
						if (�nderung == 3) {
							
							String neu = einlesen_Wort(kategorie, �nderung);
							if (neu.equals("" + 0)) {
								neu = aktuellerVorname;
							} else {
								neuerVorname = neu;
							}
						}
						if (�nderung == 4) {
							
							String neu = einlesen_Wort(kategorie, �nderung);
							if (neu.equals("" + 0)) {
								neu = aktuellesPasswort;
							} else {
								neuesPasswort = neu;
							}
						}
						
						if (�nderung == 5) {
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

	private int einlesen_Zahl(String [] auswahl, int z�hler) {
		System.out.println("Geben Sie ein: " + auswahl[z�hler-1]);
		Scanner s = new Scanner(System.in);
		int wort = s.nextInt();
		return wort;
	}
	
	private String einlesen_Wort(String [] auswahl, int z�hler) {
		System.out.println("Geben Sie ein: " + auswahl[z�hler-1]);
		Scanner s = new Scanner(System.in);
		String wort = s.next();
		return wort;
	}

	private String l�nge_anpassen_Datum(Datum a_GD) {

		String leerzeichen = "";

		String jahr = "" + a_GD.getJahr();
		int l_J = jahr.length();

		String monat = "" + a_GD.getMonat();
		int l_M = monat.length();

		String tag = "" + a_GD.getTag();
		int l_T = tag.length();

		int abzug = l_J + l_M + l_T + 2; // +2 f�r die Punkte zwischen den
											// Komponenten
		if (abzug < 50) {
			while (abzug < 50) {
				leerzeichen = leerzeichen + " ";
				abzug += 1;
			}
		}
		return leerzeichen;
	}

	private String l�nge_anpassen(String wort) {

		int abzug = wort.length();
		if (wort.length() < 50) {
			while (wort.length() < 50) {
				wort = wort + " ";
			}
		}
		return wort;
	}

	private String l�nge_anpassen_Adresse(Adresse a_A) {

		String leerzeichen = "";

		String hausnummer = "" + a_A.getHausnummer();
		int l_HN = hausnummer.length();

		String platz = "" + a_A.getPlz();
		int l_P = platz.length();

		String stadt = a_A.getStadt();
		int l_ST = stadt.length();

		String stra�e = a_A.getStrasse();
		int l_SR = stra�e.length();

		int abzug = l_HN + l_P + l_SR + l_ST + 3; // +3 f�r die Leerzeichen
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
