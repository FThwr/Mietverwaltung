package mietverwaltung;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class MietvertragErstellenAction extends MenueManager implements Action {

	@Override
	public void action() {

		System.out.println(
				"________________________________________ Mietvertrag erstellen ________________________________________");

		boolean erstellVorgang = true;

		String mietvertragID = "";
		int wohnungsID = -100;
		int kundenID = -100;
		int mitarbeiterID = -100;
		Datum mietbeginn = null;
		Datum mietende = null;

		while (erstellVorgang == true) {

			String[] kategorie = { "Mietvertrags-ID", "Wohnungs-ID", "Kunden-ID", "Mitarbeiter-ID", "Mietbeginn", "Mietende" };

			System.out.println(
					"Wählen Sie einen zu bearbeitenenden Wert!\nFolgender Mietvertrag wird aktuell erstellt: ");
			System.out.println("Drücke '1' für Mietvertrag-ID:                        " + mietvertragID);
			System.out.println("Drücke '2' für Wohnungs-ID:                           " + wohnungsID);
			System.out.println("Drücke '3' für Kunden-ID:                             " + kundenID);
			System.out.println("Drücke '4' für Mitarbeiter-ID:                        " + mitarbeiterID);
			System.out.println("Drücke '5' für Mietbeginn:                            " + mietbeginn);
			System.out.println("Drücke '6' für Mietende:                              " + mietende);
			System.out.println("Drücke '7' zum Erstellen");
			System.out.println("Drücke '0' um abzubrechen");

			Scanner s = new Scanner(System.in);
			int ok = s.nextInt();

			if (ok == 0) {
				erstellVorgang = false;
			}
			if (ok == 1) {
				mietvertragID = String_eingabe(kategorie, ok);
				int vorhanden = 0;
				for (Mietvertrag contract : contractList) {
					if (contract.getMietvertragID().equals(mietvertragID)) {
						vorhanden = 1;
					}
				}
				if (vorhanden == 1) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nDer Mietvertrag mit der Nummer: "
									+ "'" + mietvertragID + "'" + " existiert bereits!\n");
					mietvertragID = "";
				}
			}
			if (ok == 2) {
				wohnungsID = int_eingabe(kategorie, ok);
				int vorhanden = 0;
				for (Wohnung flat : flatList) {
					if (flat.getWohnungsID() == wohnungsID) {
						vorhanden = 1;
					}
				}
				if (vorhanden != 1) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nDie Wohnung mit der Nummer: "
									+ "'" + wohnungsID + "'" + " existiert nicht!\n");
					wohnungsID = -100;
				}
			}
			if (ok == 3) {
				kundenID = int_eingabe(kategorie, ok);
				int vorhanden = 0;
				for (Interessent interest : interestList) {
					if (interest.getKundenID() == kundenID) {
						vorhanden = 1;

					}
				}
				if (vorhanden != 1) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nDer Kunde mit der Nummer: "
									+ "'" + kundenID + "'" + " existiert nicht!\n");
					kundenID = -100;
				}
			}
			if (ok == 4) {
				mitarbeiterID = int_eingabe(kategorie, ok);
				int vorhanden = 0;
				for (Mitarbeiter worker : workerList) {
					if (worker.getMitarbeiterID() == mitarbeiterID) {
						vorhanden = 1;
					}
				}
				if (vorhanden != 1) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nDer Mitarbeiter mit der Nummer: "
									+ "'" + mitarbeiterID + "'" + " existiert nicht!\n");
					mitarbeiterID = -100;
				}
			}
			if (ok == 5) {
				String[] auswahl = { "Tag", "Monat", "Jahr" };
				int zähler = 1;
				int tag = einlesen_Zahl(auswahl, zähler);
				zähler = 2;
				int monat = einlesen_Zahl(auswahl, zähler);
				zähler = 3;
				int jahr = einlesen_Zahl(auswahl, zähler);

				if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
				} else {
					mietbeginn = new Datum(tag, monat, jahr);
				}
			}
			if (ok == 6) {
				String[] auswahl = { "Tag", "Monat", "Jahr" };
				int zähler = 1;
				int tag = einlesen_Zahl(auswahl, zähler);
				zähler = 2;
				int monat = einlesen_Zahl(auswahl, zähler);
				zähler = 3;
				int jahr = einlesen_Zahl(auswahl, zähler);

				if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
				} else {
					mietende = new Datum(tag, monat, jahr);
				}
			}

			if (ok == 7) {
				erstellVorgang = false;

				contractList.add(new Mietvertrag(mietvertragID, wohnungsID, kundenID, mitarbeiterID, mietbeginn, mietende));

				for (Interessent interest : interestList) {
					if (interest.getKundenID() == kundenID) {
						ownerList.add(new Mieter(kundenID, interest.getName(), interest.getVorname(),
								interest.getGeburtsdatum(), wohnungsID, interest.getEmail(), interest.getAdresse(),
								interest.getTelefonnummer(), "Mieter"));

						Iterator<Interessent> iter = interestList.iterator();

						while (iter.hasNext()) {
							Interessent str = iter.next();

							if (str.getKundenID() == kundenID) {
								iter.remove();
							}
						}
					}
				}

			}
			if (ok > 11) {
				System.out.println(
						"\n------------------------------- Fehler! ------------------------------- \nKeine Option vorhanden!\n");
			}

		}
	}

	private int einlesen_Zahl(String[] auswahl, int zähler) {
		System.out.println("Erstellen: " + auswahl[zähler - 1]);
		Scanner s = new Scanner(System.in);
		int zahl = -100;
		// wenn die Eingabe korrekt ist (ohne Buchstaben), dann
		// wird die Eingabe übernommen, sonst wird eine Fehlermeldung ausgegeben
		try {
			zahl = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(
					"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
		}
		return zahl;
	}

	private String einlesen_Wort(String[] auswahl, int zähler) {
		System.out.println("Erstellen: " + auswahl[zähler - 1]);
		Scanner s = new Scanner(System.in);
		String wort = s.next();
		return wort;
	}

	public int int_eingabe(String[] buttons, int ok) {

		System.out.println("Erstellen: " + buttons[ok - 1]);
		Scanner s = new Scanner(System.in);
		int zahl = -100;
		try {
			zahl = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(
					"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
		}
		return zahl;
	}

	public String String_eingabe(String[] buttons, int ok) {
		System.out.println("Erstellen: " + buttons[ok - 1]);
		Scanner s = new Scanner(System.in);
		String wort = s.next();
		return wort;
	}

	public boolean boolean_eingabe(String[] buttons, int ok) {

		System.out.println("Erstellen: " + buttons[ok - 1]);
		Scanner s = new Scanner(System.in);
		boolean entscheidung = false;
		try {
			entscheidung = s.nextBoolean();
		} catch (InputMismatchException e) {
			System.out.println(
					"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
		}
		return entscheidung;
	}

	public double double_eingabe(String[] buttons, int ok) {

		System.out.println("Erstellen: " + buttons[ok - 1]);
		Scanner s = new Scanner(System.in);
		double zahl = -100.00;
		try {
			zahl = s.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println(
					"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
		}
		return zahl;
	}
}
