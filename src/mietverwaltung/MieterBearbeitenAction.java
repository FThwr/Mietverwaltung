package mietverwaltung;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class MieterBearbeitenAction extends MenueManager implements Action {

	@Override
	public void action() {
		
		System.out.println("________________________________________ Mieter bearbeiten ________________________________________");

		Scanner s = new Scanner(System.in);
		System.out.println("\nWählen Sie den Mieter (ID) aus, den Sie bearbeiten möchten!\n");

		for (Mieter owner : ownerList) {
			System.out.println(owner.getName() + "; " + owner.getVorname() + "  ID: " + owner.getKundenID());
		}

		try {
			int zu_bearbeitenden_mieter = s.nextInt();

			boolean bearbeitungsVorgang = true;
			boolean mieterEingabe_erfolgreich = false;
			String [] kategorie = {"Mieter ID", "Name", "Vorname", "Geburtsdatum", "Wohnung", "E-Mail", "Adresse", "Telefonnummer", "Rolle"};

			String längenAnpassung_mieterID = "";
			String längenAnpassung_Name = "";
			String längenAnpassung_Vorname = "";
			String längenAnpassnung_Wohnung = "";
			String längenAnpassung_EMail = "";
			String längenAnpassung_Telefonnummer = "";
			String längenAnpassung_Rolle = "";

			int aktuelleMieterID = 0;
			int neueMieterID = 0;

			String aktuellerName = "";
			String neuerName = "";		

			String aktuellerVorname = "";
			String neuerVorname = "";

			Datum aktuellesGeburtsdatum = null;
			Datum neuesGeburtsdatum = null;

			int aktuelleWohnung = -100;
			int neueWohnung = -100;

			String aktuelleEMail = "";
			String neueEMail = "";

			Adresse aktuelleAdresse = null;
			Adresse neueAdresse = null;

			String aktuelleTelefonnummer = "";
			String neueTelefonnummer = "";
			
			String aktuelleRolle = "";
			String neueRolle = "";

			String GD_Leerzeichen = "";
			String ADR_Leerzeichen = "";

			for (Mieter owner : ownerList) {
				if (zu_bearbeitenden_mieter == owner.getKundenID()) {

					mieterEingabe_erfolgreich = true;

					aktuelleMieterID = owner.getKundenID();
					neueMieterID = aktuelleMieterID;

					aktuellerName = owner.getName();
					neuerName = aktuellerName;

					aktuellerVorname = owner.getVorname();
					neuerVorname = aktuellerVorname;

					aktuellesGeburtsdatum = owner.getGeburtsdatum();
					neuesGeburtsdatum = aktuellesGeburtsdatum;

					aktuelleWohnung = owner.getWohnungsnummer();
					neueWohnung = aktuelleWohnung;

					aktuelleEMail = owner.getEmail();
					neueEMail = aktuelleEMail;

					aktuelleAdresse = owner.getAdresse();
					neueAdresse = aktuelleAdresse;

					aktuelleTelefonnummer = owner.getTelefonnummer();
					neueTelefonnummer = aktuelleTelefonnummer;

					aktuelleRolle = owner.getRolle();
					neueRolle = aktuelleRolle;

					// Variablen zur verschönerten Ausgabe
					längenAnpassung_mieterID = "" + aktuelleMieterID;
					längenAnpassung_mieterID = länge_anpassen(längenAnpassung_mieterID);

					längenAnpassung_Name = aktuellerName;
					längenAnpassung_Name = länge_anpassen(längenAnpassung_Name);

					längenAnpassung_Vorname = aktuellerName;
					längenAnpassung_Vorname = länge_anpassen(längenAnpassung_Vorname);

					GD_Leerzeichen = länge_anpassen_Datum(aktuellesGeburtsdatum);

					längenAnpassnung_Wohnung = "" + owner.getWohnungsnummer();
					längenAnpassnung_Wohnung = länge_anpassen(längenAnpassnung_Wohnung);

					längenAnpassung_EMail = aktuelleEMail;
					längenAnpassung_EMail = länge_anpassen(längenAnpassung_EMail);

					ADR_Leerzeichen = länge_anpassen_Adresse(aktuelleAdresse);

					längenAnpassung_Telefonnummer = aktuelleTelefonnummer;
					längenAnpassung_Telefonnummer = länge_anpassen(längenAnpassung_Telefonnummer);

					längenAnpassung_Rolle = aktuelleRolle;
					längenAnpassung_Rolle = länge_anpassen(längenAnpassung_Rolle);
				}
			}

			if (mieterEingabe_erfolgreich == true) {
				while (bearbeitungsVorgang == true) {

					System.out.println("Mieter ID:       " + längenAnpassung_mieterID      + "neue Mieter ID:       " + neueMieterID);
					System.out.println("Name:            " + längenAnpassung_Name          + "neuer Name:           " + neuerName);
					System.out.println("Vorname:         " + längenAnpassung_Vorname       + "neuer Vorame:         " + neuerVorname);
					System.out.println("Geburtsdatum:    " + GD_Leerzeichen                + "neues Geburtsdatum:   " + neuesGeburtsdatum);
					System.out.println("Wohnung:         " + längenAnpassnung_Wohnung      + "neue Wohnung:         " + neueWohnung);
					System.out.println("E-Mail:          " + längenAnpassung_EMail         + "neue E-Mail:          " + neueEMail);
					System.out.println("Adresse:         " + ADR_Leerzeichen               + "neue Adresse:         " + neueAdresse);
					System.out.println("Telefonnummer:   " + längenAnpassung_Telefonnummer + "neue Telefonnummer:   " + neueTelefonnummer);
					System.out.println("Rolle:           " + längenAnpassung_Rolle         + "neue Rolle:           " + neueRolle);
					System.out.println("");

					Scanner t = new Scanner(System.in);
					System.out.println(
							"............................... Wählen Sie die zu bearbeitende Eigenschaft aus! ..............................."
									+ "\n Drücke '1'  für Mieter ID  "
									+ "\n Drücke '2'  für Name  " 
									+ "\n Drücke '3'  für Vorname  "
									+ "\n Drücke '4'  für Geburtsdatum  "
									+ "\n Drücke '5'  für Wohnung  " 
									+ "\n Drücke '6'  für E-Mail  "
									+ "\n Drücke '7'  für Adresse  " 
									+ "\n Drücke '8'  für Telefon  "
									+ "\n Drücke '9'  für Rolle  " 
									+ "\n Drücke '10' für bestätigen  "
									+ "\n Drücke '0'  für abbruch der Suche!\n");

					try {
						int änderung = t.nextInt();

						if (änderung == 0) {
							bearbeitungsVorgang = false;
						}
						if (änderung == 1) {
							int eingabe = einlesen_Zahl(kategorie, änderung);
							if (eingabe == 0) {
								neueMieterID = aktuelleMieterID;
							} else {
								neueMieterID = eingabe;
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
							
							try {
								int neu = einlesen_Zahl(kategorie, änderung);

								if (neu == 0) {
									neu = aktuelleWohnung;
								} else {
									int nichtVorhanden = 0;
									for (Mieter mt : ownerList) {
										for (Wohnung flat : flatList) {

											// nur wenn die Wohnung von keinem
											// anderen
											// Mieter
											// belegt
											// ist und die Wohnung existiert
											if (mt.getWohnungsnummer() != neu && neu == flat.getWohnungsID()) {
												nichtVorhanden = 1;

											}
											if (mt.getWohnungsnummer() == neu && flat.getStatus().equals("vermietet")) {
												nichtVorhanden = 2;

											}
										}
									}
									if (nichtVorhanden == 1) {
										neueWohnung = neu;
									}
									if (nichtVorhanden == 2) {
										System.out.println(
												"------------------------------- Wohnung bereits von einem anderen Mieter belegt! -------------------------------");
										Scanner v = new Scanner(System.in);
										System.out.println(
												"\nTrotzdem den Mieter mit zu dieser Wohnung eintragen? \n Drücke '1' für JA \n Drücke '2' für NEIN");
										int entscheidung = v.nextInt();
										if (entscheidung == 1) {
											neueWohnung = neu;
										} else {
										}

									}
									if (nichtVorhanden != 2 && nichtVorhanden != 1) {
										System.out.println(
												"------------------------------- Fehler! ------------------------------- \nWohnung existiert nicht! ");
									}
								}

							} catch (InputMismatchException e) {
								System.out.println(
										"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
							}
						}
						if (änderung == 6) {
							String neu = einlesen_Wort(kategorie, änderung);
							if (neu.equals("" + 0)) {
								neu = aktuelleEMail;
							} else {
								neueEMail = neu;
							}
						}
						if (änderung == 7) {
							String [] auswahl = {"Straße", "Hausnummer", "Platz", "Stadt"};
							int zähler = 1;
							String straße = einlesen_Wort(auswahl, zähler);
							zähler = 2;
							int hausnummer = einlesen_Zahl(auswahl, zähler);
							zähler = 3;
							int platz = einlesen_Zahl(auswahl, zähler);
							zähler = 4;
							String stadt = einlesen_Wort(auswahl, zähler);

							if (straße.equals("" + 0)) {
							} 
							else {
								neueAdresse = new Adresse(straße, hausnummer, platz, stadt);
							}
						}
						if (änderung == 8) {
							String neu = einlesen_Wort(kategorie, änderung);
							if (neu.equals("" + 0)) {
								neu = aktuelleTelefonnummer;
							} else {
								neueTelefonnummer = neu;
							}
						}
						if (änderung == 9) {
							String [] auswahl = {"Mieter", "Delete"};
							
							Scanner a = new Scanner(System.in);
							System.out.println("Geben Sie die Zahl vom gewünschten Status aus: " + "1" + auswahl[0] + "2" + auswahl[1]);
							int eingabe = a.nextInt();
							
							if (eingabe == 0) {
								neueRolle = aktuelleRolle;
							} 
							if (eingabe == 1) {
								neueRolle = "Delete";
							}
						}
						if (änderung == 10) {
							bearbeitungsVorgang = false;

							if (neueRolle.equals("Mieter")) {

								for (Mieter owner : ownerList) {
									if (zu_bearbeitenden_mieter == owner.getKundenID()) {
										owner.setKundenID(neueMieterID);
										owner.setName(neuerName);
										owner.setVorname(neuerVorname);
										owner.setGeburtsdatum(neuesGeburtsdatum);
										owner.setWohnungsnummer(neueWohnung);
										owner.setEmail(neueEMail);
										owner.setAdresse(neueAdresse);							
										owner.setTelefonnummer(neueTelefonnummer);
										owner.setWohnungsnummer(neueWohnung);
									}
								}
							}

							if (neueRolle.equals("Delete")) {

								Iterator<Mieter> iter = ownerList.iterator();

								while (iter.hasNext()) {
									Mieter str = iter.next();

									if (str.getKundenID() == neueMieterID) {
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