package mietverwaltung;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class MietvertragBearbeitenAction extends MenueManager implements Action, Serializable {

	@Override
	public void action() {

		System.out.println(
				"________________________________________ Mietvertrag bearbeiten ________________________________________");

		Scanner s = new Scanner(System.in);
		System.out.println("\nWählen Sie den Mietvertrag (ID) aus, den Sie bearbeiten möchten!\n");

		for (Mietvertrag contract : contractList) {
			System.out.println(contract.getMietvertragID());
		}

		try {
			String zu_bearbeitenden_mietvertrag = s.next();

			boolean bearbeitungsVorgang = true;
			boolean mietvertragEingabe_erfolgreich = false;
			String[] kategorie = { "Mietvertrag-ID", "Wohnungs-ID", "Kunden-ID", "Mitarbeiter-ID", "Mietbeginn",
					"Mietende" };

			String längenAnpassung_mietvertragID = "";
			String längenAnpassung_wohnungsID = "";
			String längenAnpassung_kundenID = "";
			String längenAnpassnung_mitarbeiterID = "";

			String aktuelleMietvertragsID = "";
			String neueMietvertragsID = "";

			int aktuelleWohnungsID = -100;
			int neueWohnungsID = -100;

			int aktuelleKundenID = -100;
			int neueKundenID = -100;

			int aktuelleMitarbeiterID = -100;
			int neueMitarbeiterID = -100;

			Datum aktuellerMietbeginn = null;
			Datum neuerMietbeginn = null;

			Datum aktuellesMietende = null;
			Datum neuesMietende = null;

			String MB_Leerzeichen = "";
			String ME_Leerzeichen = "";

			for (Mietvertrag contract : contractList) {
				if (zu_bearbeitenden_mietvertrag.equals(contract.getMietvertragID())) {

					mietvertragEingabe_erfolgreich = true;

					aktuelleMietvertragsID = contract.getMietvertragID();
					neueMietvertragsID = aktuelleMietvertragsID;

					aktuelleWohnungsID = contract.getWohnungsID();
					neueWohnungsID = aktuelleWohnungsID;

					aktuelleKundenID = contract.getKundenID();
					neueKundenID = aktuelleKundenID;

					aktuelleMitarbeiterID = contract.getMitarbeiterID();
					neueMitarbeiterID = aktuelleMitarbeiterID;

					aktuellerMietbeginn = contract.getMietbeginn();
					neuerMietbeginn = aktuellerMietbeginn;

					aktuellesMietende = contract.getMietende();
					neuesMietende = aktuellesMietende;

					// Variablen zur verschönerten Ausgabe
					längenAnpassung_mietvertragID = aktuelleMietvertragsID;
					längenAnpassung_mietvertragID = länge_anpassen(längenAnpassung_mietvertragID);

					längenAnpassung_wohnungsID = "" + aktuelleKundenID;
					längenAnpassung_wohnungsID = länge_anpassen(längenAnpassung_wohnungsID);

					längenAnpassung_kundenID = "" + aktuelleKundenID;
					längenAnpassung_kundenID = länge_anpassen(längenAnpassung_kundenID);

					längenAnpassnung_mitarbeiterID = "" + aktuelleMitarbeiterID;
					längenAnpassnung_mitarbeiterID = länge_anpassen(längenAnpassnung_mitarbeiterID);

					MB_Leerzeichen = länge_anpassen_Datum(aktuellerMietbeginn);
					ME_Leerzeichen = länge_anpassen_Datum(aktuellesMietende);
				}
			}

			if (mietvertragEingabe_erfolgreich == true) {
				while (bearbeitungsVorgang == true) {
					System.out.println(
							"............................... Wählen Sie die zu bearbeitende Eigenschaft aus! ...............................");
					System.out.println("1. Mietvertrag-ID:       " + längenAnpassung_mietvertragID
							+ "neue Mietvertrag-ID:       " + neueMietvertragsID);
					System.out.println("2. Wohnungs-ID:          " + längenAnpassung_wohnungsID
							+ "neue Wohnungs-ID:          " + neueWohnungsID);
					System.out.println("3. Kunden-ID:            " + längenAnpassung_kundenID
							+ "neue Kunden-ID:            " + neueKundenID);
					System.out.println("4. Mitarbeiter-ID:       " + längenAnpassnung_mitarbeiterID
							+ "neue Mitarbeiter-ID:       " + neueMitarbeiterID);
					System.out.println("5. Mietbeginn:           " + MB_Leerzeichen + aktuellerMietbeginn
							+ "neuer Mietbeginn:          " + neuerMietbeginn);
					System.out.println("6. Mietende:             " + ME_Leerzeichen + aktuellesMietende
							+ "neues Mietende:            " + neuesMietende);
					System.out.println("7. Bestätigen");
					System.out.println("0. Abbruch");
					System.out.println("");

					Scanner t = new Scanner(System.in);

					try {
						int änderung = t.nextInt();

						if (änderung == 0) {
							bearbeitungsVorgang = false;
						}
						if (änderung == 1) {
							String eingabe = einlesen_Wort(kategorie, änderung);
							if (eingabe.equals("" + 0)) {
								neueMietvertragsID = aktuelleMietvertragsID;
							} else {
								neueMietvertragsID = eingabe;
							}
						}
						if (änderung == 2) {
							int eingabe = einlesen_Zahl(kategorie, änderung);
							if (eingabe == 0) {
								eingabe = aktuelleWohnungsID;
							} else {
								neueWohnungsID = eingabe;
							}
						}
						if (änderung == 3) {

							int eingabe = einlesen_Zahl(kategorie, änderung);
							if (eingabe == 0) {
								eingabe = aktuelleKundenID;
							} else {
								neueKundenID = eingabe;
							}
						}
						if (änderung == 4) {

							int eingabe = einlesen_Zahl(kategorie, änderung);
							if (eingabe == 0) {
								eingabe = aktuelleMitarbeiterID;
							} else {
								neueMitarbeiterID = eingabe;
							}
						}
						if (änderung == 5) {
							String[] auswahl = { "Tag", "Monat", "Jahr" };
							int zähler = 1;
							int tag = einlesen_Zahl(auswahl, zähler);
							zähler = 2;
							int monat = einlesen_Zahl(auswahl, zähler);
							zähler = 3;
							int jahr = einlesen_Zahl(auswahl, zähler);

							if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
								neuerMietbeginn = aktuellerMietbeginn;
							} else {
								neuerMietbeginn = new Datum(tag, monat, jahr);
							}
						}
						if (änderung == 6) {
							String[] auswahl = { "Tag", "Monat", "Jahr" };
							int zähler = 1;
							int tag = einlesen_Zahl(auswahl, zähler);
							zähler = 2;
							int monat = einlesen_Zahl(auswahl, zähler);
							zähler = 3;
							int jahr = einlesen_Zahl(auswahl, zähler);

							if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
								neuesMietende = aktuellesMietende;
							} else {
								neuesMietende = new Datum(tag, monat, jahr);
							}
						}
						if (änderung == 7) {
							bearbeitungsVorgang = false;

							for (Mietvertrag contract : contractList) {
								if (zu_bearbeitenden_mietvertrag == contract.getMietvertragID()) {
									contract.setMietvertragID(neueMietvertragsID);
									contract.setWohnungsID(neueWohnungsID);
									contract.setKundenID(neueKundenID);
									contract.setMitarbeiterID(neueMitarbeiterID);
									contract.setMietbeginn(neuerMietbeginn);
									contract.setMietende(neuesMietende);
								}
							}
						}
					} catch (InputMismatchException e) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
					}
				}
			} else {
				System.out.println(
						"------------------------------- Fehler! ------------------------------- \nIhre Eingabe war nicht erfolgreich, weil die ID nicht existiert!\n");
			}
		} catch (InputMismatchException e) {
			System.out.println(
					"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
		}
	}

	private int einlesen_Zahl(String[] auswahl, int zähler) {
		System.out.println("Geben Sie ein: " + auswahl[zähler - 1]);
		Scanner s = new Scanner(System.in);
		int wort = s.nextInt();
		return wort;
	}

	private String einlesen_Wort(String[] auswahl, int zähler) {
		System.out.println("Geben Sie ein: " + auswahl[zähler - 1]);
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