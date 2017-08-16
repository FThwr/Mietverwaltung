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
		String m�ngelbeschreibung = "";
		String status = "";
		Datum eingangsdatum = null;
		Datum fertigstellungsDatum = null;
		
		String [] kategorie = {"Auftrags ID ", "Wohnungs ID", "Mitarbeiter ID", "M�ngelbeschreibung", "Status", "Eingangsdatum", "Fertigstellungsdatum"};


		while (erstellVorgang == true) {

			System.out.println("Auftrags ID:          " + auftragsID);
			System.out.println("Wohnungs ID:          " + wohnungsID);
			System.out.println("Mitarbeiter ID:       " + mitarbeiterID);
			System.out.println("M�ngelbeschreibung:   " + m�ngelbeschreibung);
			System.out.println("Status:               " + status);
			System.out.println("Eingangsdatum:        " + eingangsdatum);
			System.out.println("Fertigstellungsdatum: " + fertigstellungsDatum);
			System.out.println("");

			Scanner t = new Scanner(System.in);
			System.out.println(
					"...............................W�hlen Sie die zu erstellende Eigenschaft aus...............................!  "
							+ "\n Dr�cke '1' f�r Auftrags ID  " 
							+ "\n Dr�cke '2' f�r Wohnungs ID  " 
							+ "\n Dr�cke '3' f�r Mitarbeiter ID  "
							+ "\n Dr�cke '4' f�r M�ngelbeschreibung  " 
							+ "\n Dr�cke '5' f�r Status  " 
							+ "\n Dr�cke '6' f�r Eingangsdatum  " 
							+ "\n Dr�cke '7' f�r Fertigstellungdatum  "
							+ "\n Dr�cke '8' f�r best�tigen  "
							+ "\n Dr�cke '0' f�r abbruch der Suche!\n");
			try {
				int �nderung = t.nextInt();

				if (�nderung == 0) {
					System.out.println("-------------------------------Erstellvorgang wurde abgebrochen!-------------------------------\n");
					erstellVorgang = false;
				}
				if (�nderung == 1) {
					
						String neueAID = einlesen_Wort(kategorie, �nderung);
						if (neueAID.equals("" + 0)) {
							neueAID = auftragsID;
						} else {
							//wenn vorhanden = 1 ist, dann existiert ein Interessent mit dieser ID bereits
							int vorhanden = 0;
							//f�r jedes Element in der Interessentenliste wird geguckt, 
							//ob die eingegebende ID mit einer bereits existierenden �bereinstimmt
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
				if (�nderung == 2) {
					int neueWID = einlesen_Zahl(kategorie, �nderung);
					if (neueWID == 0) {
						neueWID = wohnungsID;
					} else {
						//wenn vorhanden = 1 ist, dann existiert ein Interessent mit dieser ID bereits
						int vorhanden = 0;
						//f�r jedes Element in der Interessentenliste wird geguckt, 
						//ob die eingegebende ID mit einer bereits existierenden �bereinstimmt
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
				if (�nderung == 3) {
					int neueMID = einlesen_Zahl(kategorie, �nderung);
					if (neueMID == 0) {
						neueMID = mitarbeiterID;
					} else {
						//wenn vorhanden = 1 ist, dann existiert ein Interessent mit dieser ID bereits
						int vorhanden = 0;
						//f�r jedes Element in der Interessentenliste wird geguckt, 
						//ob die eingegebende ID mit einer bereits existierenden �bereinstimmt
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
				if (�nderung == 4) {
					String neueM�ngel = einlesen_Wort(kategorie, �nderung);
					if (neueM�ngel.equals("" + 0)) {
						neueM�ngel = m�ngelbeschreibung;
					} else {
						int vorhanden = 0;
						m�ngelbeschreibung = neueM�ngel;		
					}
				}
				if (�nderung == 5) {
					String [] auswahl = {"in Arbeit", "fertig"};
					
					Scanner a = new Scanner(System.in);
					System.out.println("Geben Sie die Zahl vom gew�nschten Status aus: " + "1" + auswahl[0] + "2" + auswahl[1] );
					int eingabe = a.nextInt();
					
					if (eingabe == 1) {
						status = "in Arbeit";
					} 
					if (eingabe == 2) {
						status = "fertig";
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
					} 
					else {
						eingangsdatum = new Datum(tag, monat, jahr);
					}
				}
				if (�nderung == 7) {
//					String[] auswahl = { "Tag", "Monat", "Jahr" };
//					int z�hler = 1;
//					int tag = einlesen_Zahl(auswahl, z�hler);
//					z�hler = 2;
//					int monat = einlesen_Zahl(auswahl, z�hler);
//					z�hler = 3;
//					int jahr = einlesen_Zahl(auswahl, z�hler);
//
//					if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
//					} 
//					else {
						fertigstellungsDatum = new Datum(0, 0, 0);
//					}
				}
				if (�nderung == 8) {
					System.out.println("Handwerkerauftrag wurde erfolgreich angelegt!");
					erstellVorgang = false;
					repairList.add(
							new Handwerkerauftrag(auftragsID, wohnungsID, mitarbeiterID, m�ngelbeschreibung, status, eingangsdatum, fertigstellungsDatum));
				}
			} catch (InputMismatchException e) {
				System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
			}
		}
	}
	
	private int einlesen_Zahl(String [] auswahl, int z�hler) {
		System.out.println("Erstellen: " + auswahl[z�hler-1]);
		Scanner s = new Scanner(System.in);
		int zahl = -100;
		//wenn die Eingabe korrekt ist (ohne Buchstaben), dann
		//wird die Eingabe �bernommen, sonst wird eine Fehlermeldung ausgegeben
		try {
		zahl = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
		}
		return zahl;
	}
	private String einlesen_Wort(String [] auswahl, int z�hler) {
		System.out.println("Erstellen: " + auswahl[z�hler-1]);
		Scanner s = new Scanner(System.in);
		String wort = s.next();
		return wort;
	}
}