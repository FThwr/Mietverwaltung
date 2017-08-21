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
		System.out.println("\nW�hlen Sie den Interessenten (ID) aus, den Sie bearbeiten m�chten!\n");

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
			
			// diese Variablen dienen sp�ter f�r eine tabellarische Ausgabe auf der Konsole
			String l�ngenAnpassung_interessentenID = "";
			String l�ngenAnpassung_Name = "";
			String l�ngenAnpassung_Vorname = "";
			String l�ngenAnpassung_EMail = "";
			String l�ngenAnpassung_Telefonnummer = "";
			String l�ngenAnpassung_Rolle = "";
			
			// allgemeine Variablen 
			// alte = aktuelle Werte
			// neue = neue/ver�nderten Werte
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

					// Initialisierung der tabellarischen Variablen + Ausf�llung mit Leerzeichen (Umwandlung in die Tabelle)
					l�ngenAnpassung_interessentenID = "" + aktuelleInteressentenID;
					l�ngenAnpassung_interessentenID = l�nge_anpassen(l�ngenAnpassung_interessentenID);

					l�ngenAnpassung_Name = aktuellerName;
					l�ngenAnpassung_Name = l�nge_anpassen(l�ngenAnpassung_Name);

					l�ngenAnpassung_Vorname = aktuellerVorname;
					l�ngenAnpassung_Vorname = l�nge_anpassen(l�ngenAnpassung_Vorname);

					GD_Leerzeichen = l�nge_anpassen_Datum(aktuellesGeburtsdatum);

					l�ngenAnpassung_EMail = aktuelleEMail;
					l�ngenAnpassung_EMail = l�nge_anpassen(l�ngenAnpassung_EMail);

					ADR_Leerzeichen = l�nge_anpassen_Adresse(aktuelleAdresse);

					l�ngenAnpassung_Telefonnummer = aktuelleTelefon;
					l�ngenAnpassung_Telefonnummer = l�nge_anpassen(l�ngenAnpassung_Telefonnummer);

					l�ngenAnpassung_Rolle = aktuelleRolle;
					l�ngenAnpassung_Rolle = l�nge_anpassen(l�ngenAnpassung_Rolle);
				}
			}

			if (interessentenEingabe_erfolgreich == true) {
				while (bearbeitungsVorgang == true) {

					System.out.println("Interessenten ID: " + l�ngenAnpassung_interessentenID + "neue Interessenten ID: " + neueInteressentenID);
					System.out.println("Name:             " + l�ngenAnpassung_Name            + "neuer Name:            " + neuerName);
					System.out.println("Vorname:          " + l�ngenAnpassung_Vorname         + "neuer Vorname:         " + neuerVorname);
					System.out.println("Geburtsdatum:     " + GD_Leerzeichen                  + "neues Geburtsdatum:    " + neuesGeburtsdatum);
					System.out.println("E-Mail:           " + l�ngenAnpassung_EMail           + "neue E-Mail:           " + neueEMail);
					System.out.println("Adresse:          " + ADR_Leerzeichen                 + "neue Adresse:          " + neueAdresse);
					System.out.println("Telefonnummer:    " + l�ngenAnpassung_Telefonnummer   + "neue Telefonnummer:    " + neueTelefon);
					System.out.println("Rolle:            " + l�ngenAnpassung_Rolle           + "neue Rolle:            " + neueRolle);
					System.out.println("");

					Scanner t = new Scanner(System.in);
					System.out.println(
							"............................... W�hlen Sie die zu bearbeitende Eigenschaft aus! ..............................."
									+ "\n Dr�cke '1' f�r Interessenten-ID  "
									+ "\n Dr�cke '2' f�r Name  " 
									+ "\n Dr�cke '3' f�r Vorname  "
									+ "\n Dr�cke '4' f�r Geburtsdatum  " 
									+ "\n Dr�cke '5' f�r E-Mail  "
									+ "\n Dr�cke '6' f�r Adresse  " 
									+ "\n Dr�cke '7' f�r Telefon  "
									+ "\n Dr�cke '8' f�r Rolle  " 
									+ "\n Dr�cke '9' f�r best�tigen  "
									+ "\n Dr�cke '0' f�r abbruch der Suche!\n");

					try {
						int �nderung = t.nextInt();

						if (�nderung == 0) {
							bearbeitungsVorgang = false;
						}
						if (�nderung == 1) {
							int eingabe = einlesen_Zahl(kategorie, �nderung);
							if (eingabe == 0) {
								neueInteressentenID = aktuelleInteressentenID;
							} else {
								neueInteressentenID = eingabe;
							}
						}
						if (�nderung == 2) {
							String eingabe = einlesen_Wort(kategorie, �nderung);
							if (eingabe.equals("" + 0)) {
								neuerName = aktuellerName;
							} else {
								neuerName = eingabe;
							}
						}
						if (�nderung == 3) {		
							String eingabe = einlesen_Wort(kategorie, �nderung);
							if (eingabe.equals("" + 0)) {
								neuerVorname = aktuellerVorname;
							} else {
								neuerVorname = eingabe;
							}
						}
						if (�nderung == 4) {		
							String[] auswahl = { "Tag", "Monat", "Jahr" };
							int z�hler = 1;
							int tag = einlesen_Zahl(auswahl, z�hler);
							z�hler = 2;
							int monat = einlesen_Zahl(auswahl, z�hler);
							z�hler = 3;
							int jahr = einlesen_Zahl(auswahl, z�hler);

							if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
								neuesGeburtsdatum = aktuellesGeburtsdatum;
							} 
							else {
								neuesGeburtsdatum = new Datum(tag, monat, jahr);
							}
						}
						if (�nderung == 5) {
							String eingabe = einlesen_Wort(kategorie, �nderung);
							if (eingabe.equals("" + 0)) {
								neueEMail = aktuelleEMail;
							} else {
								neueEMail = eingabe;
							}
						}
						if (�nderung == 6) {
							String [] auswahl = {"Stra�e", "Hausnummer", "Platz", "Stadt"};
							int z�hler = 1;
							String stra�e = einlesen_Wort(auswahl, z�hler);
							z�hler = 2;
							int hausnummer = einlesen_Zahl(auswahl, z�hler);
							z�hler = 3;
							int platz = einlesen_Zahl(auswahl, z�hler);
							z�hler = 4;
							String stadt = einlesen_Wort(auswahl, z�hler);

							if (stra�e.equals("" + 0) || hausnummer == 0 || hausnummer == -100 || platz == 0 || platz == -100 || stadt.equals("" + 0)) {
								neueAdresse = aktuelleAdresse;
							} 
							else {
								neueAdresse = new Adresse(stra�e, hausnummer, platz, stadt);
							}
						}
						if (�nderung == 7) {
							String eingabe = einlesen_Wort(kategorie, �nderung);
							if (eingabe.equals("" + 0)) {
								neueTelefon = aktuelleTelefon;
							} else {
								neueTelefon = eingabe;
							}
						}
						if (�nderung == 8) {
							String [] auswahl = {"Interessent", "Mieter", "Delete"};
							
							Scanner a = new Scanner(System.in);
							System.out.println("Geben Sie die Zahl vom gew�nschten Status aus: " + "1" + auswahl[0] + "2" + auswahl[1] + "3" + auswahl[2]);
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
						if (�nderung == 9) {
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