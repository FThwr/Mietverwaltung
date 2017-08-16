package mietverwaltung;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HandwerkerauftragErstellenAction extends MenueManager implements Action {

	@Override
	public void action() {
		
		System.out.println("________________________________________ Handwerkerauftrag erstellen ________________________________________");


		boolean erstellVorgang = true;

		String auftragsID = "";
		int wohnungsID = -100;
		int mitarbeiterID = -100;
		String mängelbeschreibung = "";
		String status = "";
		Datum eingangsdatum = null;
		Datum fertigstellungsDatum = null;
		
		String [] kategorie = {"Auftrags ID ", "Wohnungs ID", "Mitarbeiter ID", "Mängelbeschreibung", "Status", "Eingangsdatum", "Fertigstellungsdatum"};


		while (erstellVorgang == true) {

			System.out.println("Auftrags ID:          " + auftragsID);
			System.out.println("Wohnungs ID:          " + wohnungsID);
			System.out.println("Mitarbeiter ID:       " + mitarbeiterID);
			System.out.println("Mängelbeschreibung:   " + mängelbeschreibung);
			System.out.println("Status:               " + status);
			System.out.println("Eingangsdatum:        " + eingangsdatum);
			System.out.println("Fertigstellungsdatum: " + fertigstellungsDatum);
			System.out.println("");

			Scanner t = new Scanner(System.in);
			System.out.println(
					"...............................Wählen Sie die zu erstellende Eigenschaft aus...............................!  "
							+ "\n Drücke '1' für Auftrags ID  " 
							+ "\n Drücke '2' für Wohnungs ID  " 
							+ "\n Drücke '3' für Mitarbeiter ID  "
							+ "\n Drücke '4' für Mängelbeschreibung  " 
							+ "\n Drücke '5' für Status  " 
							+ "\n Drücke '6' für Eingangsdatum  " 
							+ "\n Drücke '7' für Fertigstellungdatum  "
							+ "\n Drücke '8' für bestätigen  "
							+ "\n Drücke '0' für abbruch der Suche!\n");
			try {
				int änderung = t.nextInt();

				if (änderung == 0) {
					System.out.println("-------------------------------Erstellvorgang wurde abgebrochen!-------------------------------\n");
					erstellVorgang = false;
				}
				if (änderung == 1) {
					
						String neueAID = einlesen_Wort(kategorie, änderung);
						if (neueAID.equals("" + 0)) {
							neueAID = auftragsID;
						} else {
							//wenn vorhanden = 1 ist, dann existiert ein Interessent mit dieser ID bereits
							int vorhanden = 0;
							//für jedes Element in der Interessentenliste wird geguckt, 
							//ob die eingegebende ID mit einer bereits existierenden übereinstimmt
							for (Handwerkerauftrag repair : repairList) {
								if (neueAID.equals(repair.getAuftragsID())) {
									vorhanden = 1;
								}
							}
							if (vorhanden == 1) {
								System.out.println("\n------------------------------- Fehler! ------------------------------- \nAuftrags ID bereits vergeben!\n");
							} else {
								auftragsID = neueAID;
							}
						}
				}
				if (änderung == 2) {
					int neueWID = einlesen_Zahl(kategorie, änderung);
					if (neueWID == 0) {
						neueWID = wohnungsID;
					} else {
						//wenn vorhanden = 1 ist, dann existiert ein Interessent mit dieser ID bereits
						int vorhanden = 0;
						//für jedes Element in der Interessentenliste wird geguckt, 
						//ob die eingegebende ID mit einer bereits existierenden übereinstimmt
						for (Wohnung flat : flatList) {
							if (neueWID == flat.getWohnungsID()) {
								vorhanden = 1;
							}
						}
						if (vorhanden != 1) {
							System.out.println("\n------------------------------- Fehler! ------------------------------- \n Wohnung existiert nicht!\n");
						} else {
							wohnungsID = neueWID;
						}
					}
				}
				if (änderung == 3) {
					int neueMID = einlesen_Zahl(kategorie, änderung);
					if (neueMID == 0) {
						neueMID = mitarbeiterID;
					} else {
						//wenn vorhanden = 1 ist, dann existiert ein Interessent mit dieser ID bereits
						int vorhanden = 0;
						//für jedes Element in der Interessentenliste wird geguckt, 
						//ob die eingegebende ID mit einer bereits existierenden übereinstimmt
						for (Mitarbeiter worker : workerList) {
							if (neueMID == worker.getMitarbeiterID()) {
								vorhanden = 1;
							}
						}
						if (vorhanden != 1) {
							System.out.println("\n------------------------------- Fehler! ------------------------------- \n Mitarbeiter existiert nicht!\n");
						} else {
							mitarbeiterID = neueMID;
						}
					}
				}
				if (änderung == 4) {
					String neueMängel = einlesen_Wort(kategorie, änderung);
					if (neueMängel.equals("" + 0)) {
						neueMängel = mängelbeschreibung;
					} else {
						int vorhanden = 0;
						mängelbeschreibung = neueMängel;		
					}
				}
				if (änderung == 5) {
					String [] auswahl = {"in Arbeit", "fertig"};
					
					Scanner a = new Scanner(System.in);
					System.out.println("Geben Sie die Zahl vom gewünschten Status aus: " + "1" + auswahl[0] + "2" + auswahl[1] );
					int eingabe = a.nextInt();
					
					if (eingabe == 1) {
						status = "in Arbeit";
					} 
					if (eingabe == 2) {
						status = "fertig";
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
					} 
					else {
						eingangsdatum = new Datum(tag, monat, jahr);
					}
				}
				if (änderung == 7) {
//					String[] auswahl = { "Tag", "Monat", "Jahr" };
//					int zähler = 1;
//					int tag = einlesen_Zahl(auswahl, zähler);
//					zähler = 2;
//					int monat = einlesen_Zahl(auswahl, zähler);
//					zähler = 3;
//					int jahr = einlesen_Zahl(auswahl, zähler);
//
//					if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
//					} 
//					else {
						fertigstellungsDatum = new Datum(0, 0, 0);
//					}
				}
				if (änderung == 8) {
					System.out.println("Handwerkerauftrag wurde erfolgreich angelegt!");
					erstellVorgang = false;
					repairList.add(
							new Handwerkerauftrag(auftragsID, wohnungsID, mitarbeiterID, mängelbeschreibung, status, eingangsdatum, fertigstellungsDatum));
				}
			} catch (InputMismatchException e) {
				System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
			}
		}
	}
	
	private int einlesen_Zahl(String [] auswahl, int zähler) {
		System.out.println("Erstellen: " + auswahl[zähler-1]);
		Scanner s = new Scanner(System.in);
		int zahl = -100;
		//wenn die Eingabe korrekt ist (ohne Buchstaben), dann
		//wird die Eingabe übernommen, sonst wird eine Fehlermeldung ausgegeben
		try {
		zahl = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
		}
		return zahl;
	}
	private String einlesen_Wort(String [] auswahl, int zähler) {
		System.out.println("Erstellen: " + auswahl[zähler-1]);
		Scanner s = new Scanner(System.in);
		String wort = s.next();
		return wort;
	}
}