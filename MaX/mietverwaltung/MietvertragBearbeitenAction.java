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
		System.out.println("\nW�hlen Sie den Mietvertrag (ID) aus, den Sie bearbeiten m�chten!\n");

		for (Mietvertrag contract : contractList) {
			System.out.println(contract.getMietvertragID());
		}

		try {
			String zu_bearbeitenden_mietvertrag = s.next();

			boolean bearbeitungsVorgang = true;
			boolean mietvertragEingabe_erfolgreich = false;
			String[] kategorie = { "Mietvertrag-ID", "Wohnungs-ID", "Kunden-ID", "Mitarbeiter-ID", "Mietbeginn",
					"Mietende" };

			String l�ngenAnpassung_mietvertragID = "";
			String l�ngenAnpassung_wohnungsID = "";
			String l�ngenAnpassung_kundenID = "";
			String l�ngenAnpassnung_mitarbeiterID = "";

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

					// Variablen zur versch�nerten Ausgabe
					l�ngenAnpassung_mietvertragID = aktuelleMietvertragsID;
					l�ngenAnpassung_mietvertragID = l�nge_anpassen(l�ngenAnpassung_mietvertragID);

					l�ngenAnpassung_wohnungsID = "" + aktuelleKundenID;
					l�ngenAnpassung_wohnungsID = l�nge_anpassen(l�ngenAnpassung_wohnungsID);

					l�ngenAnpassung_kundenID = "" + aktuelleKundenID;
					l�ngenAnpassung_kundenID = l�nge_anpassen(l�ngenAnpassung_kundenID);

					l�ngenAnpassnung_mitarbeiterID = "" + aktuelleMitarbeiterID;
					l�ngenAnpassnung_mitarbeiterID = l�nge_anpassen(l�ngenAnpassnung_mitarbeiterID);

					MB_Leerzeichen = l�nge_anpassen_Datum(aktuellerMietbeginn);
					ME_Leerzeichen = l�nge_anpassen_Datum(aktuellesMietende);
				}
			}

			if (mietvertragEingabe_erfolgreich == true) {
				while (bearbeitungsVorgang == true) {
					System.out.println(
							"............................... W�hlen Sie die zu bearbeitende Eigenschaft aus! ...............................");
					System.out.println("1. Mietvertrag-ID:       " + l�ngenAnpassung_mietvertragID
							+ "neue Mietvertrag-ID:       " + neueMietvertragsID);
					System.out.println("2. Wohnungs-ID:          " + l�ngenAnpassung_wohnungsID
							+ "neue Wohnungs-ID:          " + neueWohnungsID);
					System.out.println("3. Kunden-ID:            " + l�ngenAnpassung_kundenID
							+ "neue Kunden-ID:            " + neueKundenID);
					System.out.println("4. Mitarbeiter-ID:       " + l�ngenAnpassnung_mitarbeiterID
							+ "neue Mitarbeiter-ID:       " + neueMitarbeiterID);
					System.out.println("5. Mietbeginn:           " + MB_Leerzeichen + aktuellerMietbeginn
							+ "neuer Mietbeginn:          " + neuerMietbeginn);
					System.out.println("6. Mietende:             " + ME_Leerzeichen + aktuellesMietende
							+ "neues Mietende:            " + neuesMietende);
					System.out.println("7. Best�tigen");
					System.out.println("0. Abbruch");
					System.out.println("");

					Scanner t = new Scanner(System.in);

					try {
						int �nderung = t.nextInt();

						if (�nderung == 0) {
							bearbeitungsVorgang = false;
						}
						if (�nderung == 1) {
							String eingabe = einlesen_Wort(kategorie, �nderung);
							if (eingabe.equals("" + 0)) {
								neueMietvertragsID = aktuelleMietvertragsID;
							} else {
								neueMietvertragsID = eingabe;
							}
						}
						if (�nderung == 2) {
							int eingabe = einlesen_Zahl(kategorie, �nderung);
							if (eingabe == 0) {
								eingabe = aktuelleWohnungsID;
							} else {
								neueWohnungsID = eingabe;
							}
						}
						if (�nderung == 3) {

							int eingabe = einlesen_Zahl(kategorie, �nderung);
							if (eingabe == 0) {
								eingabe = aktuelleKundenID;
							} else {
								neueKundenID = eingabe;
							}
						}
						if (�nderung == 4) {

							int eingabe = einlesen_Zahl(kategorie, �nderung);
							if (eingabe == 0) {
								eingabe = aktuelleMitarbeiterID;
							} else {
								neueMitarbeiterID = eingabe;
							}
						}
						if (�nderung == 5) {
							String[] auswahl = { "Tag", "Monat", "Jahr" };
							int z�hler = 1;
							int tag = einlesen_Zahl(auswahl, z�hler);
							z�hler = 2;
							int monat = einlesen_Zahl(auswahl, z�hler);
							z�hler = 3;
							int jahr = einlesen_Zahl(auswahl, z�hler);

							if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
								neuerMietbeginn = aktuellerMietbeginn;
							} else {
								neuerMietbeginn = new Datum(tag, monat, jahr);
							}
						}
						if (�nderung == 6) {
							String[] auswahl = { "Tag", "Monat", "Jahr" };
							int z�hler = 1;
							int tag = einlesen_Zahl(auswahl, z�hler);
							z�hler = 2;
							int monat = einlesen_Zahl(auswahl, z�hler);
							z�hler = 3;
							int jahr = einlesen_Zahl(auswahl, z�hler);

							if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
								neuesMietende = aktuellesMietende;
							} else {
								neuesMietende = new Datum(tag, monat, jahr);
							}
						}
						if (�nderung == 7) {
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

	private int einlesen_Zahl(String[] auswahl, int z�hler) {
		System.out.println("Geben Sie ein: " + auswahl[z�hler - 1]);
		Scanner s = new Scanner(System.in);
		int wort = s.nextInt();
		return wort;
	}

	private String einlesen_Wort(String[] auswahl, int z�hler) {
		System.out.println("Geben Sie ein: " + auswahl[z�hler - 1]);
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