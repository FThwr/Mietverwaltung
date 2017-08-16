package mietverwaltung;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class MieterBearbeitenAction extends MenueManager implements Action {

	@Override
	public void action() {
		
		System.out.println("________________________________________ Mieter bearbeiten ________________________________________");

		Scanner s = new Scanner(System.in);
		System.out.println("\nW�hlen Sie den Mieter (ID) aus, den Sie bearbeiten m�chten!\n");

		for (Mieter owner : ownerList) {
			System.out.println(owner.getName() + "; " + owner.getVorname() + "  ID: " + owner.getKundenID());
		}

		try {
			int zu_bearbeitenden_mieter = s.nextInt();

			boolean bearbeitungsVorgang = true;
			boolean mieterEingabe_erfolgreich = false;
			String [] kategorie = {"Mieter ID", "Name", "Vorname", "Geburtsdatum", "Wohnung", "E-Mail", "Adresse", "Telefonnummer", "Rolle"};

			String l�ngenAnpassung_mieterID = "";
			String l�ngenAnpassung_Name = "";
			String l�ngenAnpassung_Vorname = "";
			String l�ngenAnpassnung_Wohnung = "";
			String l�ngenAnpassung_EMail = "";
			String l�ngenAnpassung_Telefonnummer = "";
			String l�ngenAnpassung_Rolle = "";

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

					// Variablen zur versch�nerten Ausgabe
					l�ngenAnpassung_mieterID = "" + aktuelleMieterID;
					l�ngenAnpassung_mieterID = l�nge_anpassen(l�ngenAnpassung_mieterID);

					l�ngenAnpassung_Name = aktuellerName;
					l�ngenAnpassung_Name = l�nge_anpassen(l�ngenAnpassung_Name);

					l�ngenAnpassung_Vorname = aktuellerName;
					l�ngenAnpassung_Vorname = l�nge_anpassen(l�ngenAnpassung_Vorname);

					GD_Leerzeichen = l�nge_anpassen_Datum(aktuellesGeburtsdatum);

					l�ngenAnpassnung_Wohnung = "" + owner.getWohnungsnummer();
					l�ngenAnpassnung_Wohnung = l�nge_anpassen(l�ngenAnpassnung_Wohnung);

					l�ngenAnpassung_EMail = aktuelleEMail;
					l�ngenAnpassung_EMail = l�nge_anpassen(l�ngenAnpassung_EMail);

					ADR_Leerzeichen = l�nge_anpassen_Adresse(aktuelleAdresse);

					l�ngenAnpassung_Telefonnummer = aktuelleTelefonnummer;
					l�ngenAnpassung_Telefonnummer = l�nge_anpassen(l�ngenAnpassung_Telefonnummer);

					l�ngenAnpassung_Rolle = aktuelleRolle;
					l�ngenAnpassung_Rolle = l�nge_anpassen(l�ngenAnpassung_Rolle);
				}
			}

			if (mieterEingabe_erfolgreich == true) {
				while (bearbeitungsVorgang == true) {

					System.out.println("Mieter ID:       " + l�ngenAnpassung_mieterID      + "neue Mieter ID:       " + neueMieterID);
					System.out.println("Name:            " + l�ngenAnpassung_Name          + "neuer Name:           " + neuerName);
					System.out.println("Vorname:         " + l�ngenAnpassung_Vorname       + "neuer Vorame:         " + neuerVorname);
					System.out.println("Geburtsdatum:    " + GD_Leerzeichen                + "neues Geburtsdatum:   " + neuesGeburtsdatum);
					System.out.println("Wohnung:         " + l�ngenAnpassnung_Wohnung      + "neue Wohnung:         " + neueWohnung);
					System.out.println("E-Mail:          " + l�ngenAnpassung_EMail         + "neue E-Mail:          " + neueEMail);
					System.out.println("Adresse:         " + ADR_Leerzeichen               + "neue Adresse:         " + neueAdresse);
					System.out.println("Telefonnummer:   " + l�ngenAnpassung_Telefonnummer + "neue Telefonnummer:   " + neueTelefonnummer);
					System.out.println("Rolle:           " + l�ngenAnpassung_Rolle         + "neue Rolle:           " + neueRolle);
					System.out.println("");

					Scanner t = new Scanner(System.in);
					System.out.println(
							"............................... W�hlen Sie die zu bearbeitende Eigenschaft aus! ..............................."
									+ "\n Dr�cke '1'  f�r Mieter ID  "
									+ "\n Dr�cke '2'  f�r Name  " 
									+ "\n Dr�cke '3'  f�r Vorname  "
									+ "\n Dr�cke '4'  f�r Geburtsdatum  "
									+ "\n Dr�cke '5'  f�r Wohnung  " 
									+ "\n Dr�cke '6'  f�r E-Mail  "
									+ "\n Dr�cke '7'  f�r Adresse  " 
									+ "\n Dr�cke '8'  f�r Telefon  "
									+ "\n Dr�cke '9'  f�r Rolle  " 
									+ "\n Dr�cke '10' f�r best�tigen  "
									+ "\n Dr�cke '0'  f�r abbruch der Suche!\n");

					try {
						int �nderung = t.nextInt();

						if (�nderung == 0) {
							bearbeitungsVorgang = false;
						}
						if (�nderung == 1) {
							int eingabe = einlesen_Zahl(kategorie, �nderung);
							if (eingabe == 0) {
								neueMieterID = aktuelleMieterID;
							} else {
								neueMieterID = eingabe;
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
							
							try {
								int neu = einlesen_Zahl(kategorie, �nderung);

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
												"\nTrotzdem den Mieter mit zu dieser Wohnung eintragen? \n Dr�cke '1' f�r JA \n Dr�cke '2' f�r NEIN");
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
						if (�nderung == 6) {
							String neu = einlesen_Wort(kategorie, �nderung);
							if (neu.equals("" + 0)) {
								neu = aktuelleEMail;
							} else {
								neueEMail = neu;
							}
						}
						if (�nderung == 7) {
							String [] auswahl = {"Stra�e", "Hausnummer", "Platz", "Stadt"};
							int z�hler = 1;
							String stra�e = einlesen_Wort(auswahl, z�hler);
							z�hler = 2;
							int hausnummer = einlesen_Zahl(auswahl, z�hler);
							z�hler = 3;
							int platz = einlesen_Zahl(auswahl, z�hler);
							z�hler = 4;
							String stadt = einlesen_Wort(auswahl, z�hler);

							if (stra�e.equals("" + 0)) {
							} 
							else {
								neueAdresse = new Adresse(stra�e, hausnummer, platz, stadt);
							}
						}
						if (�nderung == 8) {
							String neu = einlesen_Wort(kategorie, �nderung);
							if (neu.equals("" + 0)) {
								neu = aktuelleTelefonnummer;
							} else {
								neueTelefonnummer = neu;
							}
						}
						if (�nderung == 9) {
							String [] auswahl = {"Mieter", "Delete"};
							
							Scanner a = new Scanner(System.in);
							System.out.println("Geben Sie die Zahl vom gew�nschten Status aus: " + "1" + auswahl[0] + "2" + auswahl[1]);
							int eingabe = a.nextInt();
							
							if (eingabe == 0) {
								neueRolle = aktuelleRolle;
							} 
							if (eingabe == 1) {
								neueRolle = "Delete";
							}
						}
						if (�nderung == 10) {
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