package mietverwaltung;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class InteressentBearbeitenAction extends MenueManager implements Action , Serializable{

	@Override
	public void action() {
		
		System.out.println("________________________________________ Interessent bearbeiten ________________________________________");

		Scanner s = new Scanner(System.in);
		System.out.println("\nWählen Sie den Interessenten (ID) aus, den Sie bearbeiten möchten!\n");

		// Ausgabe aller Interessenten (ID, Name, Vorname) zur einfacheren Auswahl
		for (Interessent interest : interestList) {
			System.out.println(interest.getName() + "; " + interest.getVorname() + "  ID: " + interest.getKundenID());
		}

		// wenn die Eingabe korrekt (ohne Buchstaben) ist, dann 
		// beginnt der Bearbeitungsvorgang
		try {
			int zu_bearbeitenden_interessent = s.nextInt();

			boolean bearbeitungsVorgang = true;
			boolean interessentenEingabe_erfolgreich = false;
			String [] kategorie = {"Interessenten ID", "Name", "Vorname", "Geburtsdatum", "E-Mail", "Adresse", "Telefonnummer", "Rolle"};
			
			// diese Variablen dienen später für eine tabellarische Ausgabe auf der Konsole
			String längenAnpassung_interessentenID = "";
			String längenAnpassung_Name = "";
			String längenAnpassung_Vorname = "";
			String längenAnpassung_EMail = "";
			String längenAnpassung_Telefonnummer = "";
			String längenAnpassung_Rolle = "";
			
			// allgemeine Variablen 
			// alte = aktuelle Werte
			// neue = neue/veränderten Werte
			int aktuelleInteressentenID = 0;
			int neueInteressentenID = 0;

			String aktuellerName = "";
			String neuerName = "";

			String aktuellerVorname = "";
			String neuerVorname = "";

			Datum aktuellesGeburtsdatum = null;
			Datum neuesGeburtsdatum = null;

			String aktuelleEMail = "";
			String neueEMail = "";

			Adresse aktuelleAdresse = null;
			Adresse neueAdresse = null;

			String aktuelleTelefon = "";
			String neueTelefon = "";
			
			String aktuelleRolle = "";
			String neueRolle = "";

			String GD_Leerzeichen = "";
			String ADR_Leerzeichen = "";

			// wenn die Eingabe der Interessenten-ID einer existierenden ID entspricht wird fortgefahren
			for (Interessent interest : interestList) {
				if (zu_bearbeitenden_interessent == interest.getKundenID()) {

					interessentenEingabe_erfolgreich = true;

					aktuelleInteressentenID = interest.getKundenID();
					neueInteressentenID = aktuelleInteressentenID;

					aktuellerName = interest.getName();
					neuerName = aktuellerName;

					aktuellerVorname = interest.getVorname();
					neuerVorname = aktuellerVorname;

					aktuellesGeburtsdatum = interest.getGeburtsdatum();
					neuesGeburtsdatum = aktuellesGeburtsdatum;

					aktuelleEMail = interest.getEmail();
					neueEMail = aktuelleEMail;

					aktuelleAdresse = interest.getAdresse();
					neueAdresse = aktuelleAdresse;

					aktuelleTelefon = interest.getTelefonnummer();
					neueTelefon = aktuelleTelefon;

					aktuelleRolle = interest.getRolle();
					neueRolle = aktuelleRolle;

					// Initialisierung der tabellarischen Variablen + Ausfüllung mit Leerzeichen (Umwandlung in die Tabelle)
					längenAnpassung_interessentenID = "" + aktuelleInteressentenID;
					längenAnpassung_interessentenID = länge_anpassen(längenAnpassung_interessentenID);

					längenAnpassung_Name = aktuellerName;
					längenAnpassung_Name = länge_anpassen(längenAnpassung_Name);

					längenAnpassung_Vorname = aktuellerVorname;
					längenAnpassung_Vorname = länge_anpassen(längenAnpassung_Vorname);

					GD_Leerzeichen = länge_anpassen_Datum(aktuellesGeburtsdatum);

					längenAnpassung_EMail = aktuelleEMail;
					längenAnpassung_EMail = länge_anpassen(längenAnpassung_EMail);

					ADR_Leerzeichen = länge_anpassen_Adresse(aktuelleAdresse);

					längenAnpassung_Telefonnummer = aktuelleTelefon;
					längenAnpassung_Telefonnummer = länge_anpassen(längenAnpassung_Telefonnummer);

					längenAnpassung_Rolle = aktuelleRolle;
					längenAnpassung_Rolle = länge_anpassen(längenAnpassung_Rolle);
				}
			}

			if (interessentenEingabe_erfolgreich == true) {
				while (bearbeitungsVorgang == true) {

					System.out.println("Interessenten ID: " + längenAnpassung_interessentenID + "neue Interessenten ID: " + neueInteressentenID);
					System.out.println("Name:             " + längenAnpassung_Name            + "neuer Name:            " + neuerName);
					System.out.println("Vorname:          " + längenAnpassung_Vorname         + "neuer Vorname:         " + neuerVorname);
					System.out.println("Geburtsdatum:     " + GD_Leerzeichen                  + "neues Geburtsdatum:    " + neuesGeburtsdatum);
					System.out.println("E-Mail:           " + längenAnpassung_EMail           + "neue E-Mail:           " + neueEMail);
					System.out.println("Adresse:          " + ADR_Leerzeichen                 + "neue Adresse:          " + neueAdresse);
					System.out.println("Telefonnummer:    " + längenAnpassung_Telefonnummer   + "neue Telefonnummer:    " + neueTelefon);
					System.out.println("Rolle:            " + längenAnpassung_Rolle           + "neue Rolle:            " + neueRolle);
					System.out.println("");

					Scanner t = new Scanner(System.in);
					System.out.println(
							"............................... Wählen Sie die zu bearbeitende Eigenschaft aus! ..............................."
									+ "\n Drücke '1' für Interessenten-ID  "
									+ "\n Drücke '2' für Name  " 
									+ "\n Drücke '3' für Vorname  "
									+ "\n Drücke '4' für Geburtsdatum  " 
									+ "\n Drücke '5' für E-Mail  "
									+ "\n Drücke '6' für Adresse  " 
									+ "\n Drücke '7' für Telefon  "
									+ "\n Drücke '8' für Rolle  " 
									+ "\n Drücke '9' für bestätigen  "
									+ "\n Drücke '0' für abbruch der Suche!\n");

					try {
						int änderung = t.nextInt();

						if (änderung == 0) {
							bearbeitungsVorgang = false;
						}
						if (änderung == 1) {
							int eingabe = einlesen_Zahl(kategorie, änderung);
							if (eingabe == 0) {
								neueInteressentenID = aktuelleInteressentenID;
							} else {
								neueInteressentenID = eingabe;
							}
						}
						if (änderung == 2) {
							String eingabe = einlesen_Wort(kategorie, änderung);
							if (eingabe.equals("" + 0)) {
								neuerName = aktuellerName;
							} else {
								neuerName = eingabe;
							}
						}
						if (änderung == 3) {		
							String eingabe = einlesen_Wort(kategorie, änderung);
							if (eingabe.equals("" + 0)) {
								neuerVorname = aktuellerVorname;
							} else {
								neuerVorname = eingabe;
							}
						}
						if (änderung == 4) {		
							String[] auswahl = { "Tag", "Monat", "Jahr" };
							int zähler = 1;
							int tag = einlesen_Zahl(auswahl, zähler);
							zähler = 2;
							int monat = einlesen_Zahl(auswahl, zähler);
							zähler = 3;
							int jahr = einlesen_Zahl(auswahl, zähler);

							if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
								neuesGeburtsdatum = aktuellesGeburtsdatum;
							} 
							else {
								neuesGeburtsdatum = new Datum(tag, monat, jahr);
							}
						}
						if (änderung == 5) {
							String eingabe = einlesen_Wort(kategorie, änderung);
							if (eingabe.equals("" + 0)) {
								neueEMail = aktuelleEMail;
							} else {
								neueEMail = eingabe;
							}
						}
						if (änderung == 6) {
							String [] auswahl = {"Straße", "Hausnummer", "Platz", "Stadt"};
							int zähler = 1;
							String straße = einlesen_Wort(auswahl, zähler);
							zähler = 2;
							int hausnummer = einlesen_Zahl(auswahl, zähler);
							zähler = 3;
							int platz = einlesen_Zahl(auswahl, zähler);
							zähler = 4;
							String stadt = einlesen_Wort(auswahl, zähler);

							if (straße.equals("" + 0) || hausnummer == 0 || hausnummer == -100 || platz == 0 || platz == -100 || stadt.equals("" + 0)) {
								neueAdresse = aktuelleAdresse;
							} 
							else {
								neueAdresse = new Adresse(straße, hausnummer, platz, stadt);
							}
						}
						if (änderung == 7) {
							String eingabe = einlesen_Wort(kategorie, änderung);
							if (eingabe.equals("" + 0)) {
								neueTelefon = aktuelleTelefon;
							} else {
								neueTelefon = eingabe;
							}
						}
						if (änderung == 8) {
							String [] auswahl = {"Interessent", "Mieter", "Delete"};
							
							Scanner a = new Scanner(System.in);
							System.out.println("Geben Sie die Zahl vom gewünschten Status aus: " + "1" + auswahl[0] + "2" + auswahl[1] + "3" + auswahl[2]);
							int eingabe = a.nextInt();
							
							if (eingabe == 0 || eingabe == 1) {
								neueRolle = aktuelleRolle;
							} 
							if (eingabe == 2) {
								neueRolle = "Mieter";
							}
							if (eingabe == 3) {
								neueRolle = "Delete";
							}

						}
						if (änderung == 9) {
							bearbeitungsVorgang = false;

							if (neueRolle.equals("Interessent")) {

								for (Interessent interest : interestList) {
									if (zu_bearbeitenden_interessent == interest.getKundenID()) {
										interest.setKundenID(neueInteressentenID);
										interest.setName(neuerName);
										interest.setVorname(neuerVorname);
										interest.setGeburtsdatum(neuesGeburtsdatum);
										interest.setEmail(neueEMail);
										interest.setAdresse(neueAdresse);							
										interest.setTelefonnummer(neueTelefon);
									}
								}
							}
							if (neueRolle.equals("Mieter")) {
								for (Interessent interest : interestList) {
									if (zu_bearbeitenden_interessent == interest.getKundenID()) {
										ownerList.add(new Mieter(neueInteressentenID, neuerName, neuerVorname, neuesGeburtsdatum, -100, neueEMail, neueAdresse, neueTelefon, neueRolle));
									}
								}						
							}
							if (neueRolle.equals("Delete")) {

								Iterator<Interessent> iter = interestList.iterator();

								while (iter.hasNext()) {
									Interessent str = iter.next();

									if (str.getKundenID() == neueInteressentenID) {
										iter.remove();
									}
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