package mietverwaltung;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HandwerkerauftragSuchenAction extends MenueManager implements Action {

	@Override
	public void action() {

		System.out.println(
				"________________________________________ Handwerkerauftrag suchen ________________________________________");

		boolean suchVorgang = true;

		String auftragsID = "-";
		String such_auftragsID = auftragsID;

		int wohnungsID = -100;
		int such_wohnungsID = wohnungsID;
		
		int mitarbeiterID = -100;
		int such_mitarbeiterID = mitarbeiterID;
		
		String m�ngelbeschreibung = "-";
		String such_m�ngelbeschreibung = m�ngelbeschreibung;
		
		String status = "-";
		String such_status = status;

		int eingangsTag = -100;
		int such_eingangsTag = eingangsTag;
		
		int eingangsMonat = -100;
		int such_eingangsMonat = eingangsMonat;
		
		int eingangsJahr = -100;
		int such_eingangsJahr = eingangsJahr;
		
		int fertigTag = -100;
		int such_fertigTag = fertigTag;
		
		int fertigMonat = -100;
		int such_fertigMonat = fertigMonat;
		
		int fertigJahr = -100;
		int such_fertigJahr = fertigJahr;

		String [] kategorie = {"Auftrags ID ", "Wohnungs ID", "Mitarbeiter ID", "M�ngelbeschreibung", "Status", "Eingangsdatum", "Fertigstellungsdatum"};

		String check = "";

		while (suchVorgang == true) {

			Scanner s = new Scanner(System.in);
			System.out.println(
					"............................... W�hlen Sie die zu suchende Eigenschaft aus! ..............................."
							+ "\n Dr�cke '1' f�r Auftrags-ID  "
							+ "\n Dr�cke '2' f�r Wohnungs-ID  " 
							+ "\n Dr�cke '3' f�r Mitarbeiter-ID  "
							+ "\n Dr�cke '4' f�r M�ngelbeschreibung  " 
							+ "\n Dr�cke '5' f�r Status  "
							+ "\n Dr�cke '6' f�r Eingangsdatum  " 
							+ "\n Dr�cke '7' f�r Fertigstellungsdatum  "
							+ "\n Dr�cke '8' f�r best�tigen  "
							+ "\n Dr�cke '0' f�r abbruch der Suche!\n");

			System.out.println("........... Aktuelle Suche nach: ...........");
			System.out.println("Auftrags ID:          " + such_auftragsID);
			if (such_wohnungsID != -100) {
				System.out.println("Wohnungs ID:          " + such_wohnungsID);
			} else {
				System.out.println("Wohnungs ID:          " + "-");
			}
			if (such_mitarbeiterID != -100) {
				System.out.println("Mitarbeiter ID:       " + such_mitarbeiterID);
			} else {
				System.out.println("Mitarbeiter ID:       " + "-");
			}
			System.out.println("M�ngelbeschreibung:   " + such_m�ngelbeschreibung);
			System.out.println("Status:               " + such_status);
			System.out.print("Eingangsdatum:        ");
			
			if (such_eingangsTag != -100) {
				System.out.print(such_eingangsTag);
			}
			else {
				System.out.print("--.");
			}
			if (such_eingangsMonat != -100) {
				System.out.print(such_eingangsMonat);
			}
			else {
				System.out.print("--.");
			}
			if (such_eingangsJahr != -100) {
				System.out.println(such_eingangsJahr);
			}
			else {
				System.out.println("----");
			}
			
			System.out.print("Fertigstellungsdatum: ");
			if (such_fertigTag != -100) {
				System.out.println(such_fertigTag);
			}
			else {
				System.out.print("--.");
			}
			if (such_fertigMonat != -100) {
				System.out.print(such_fertigMonat);
			}
			else {
				System.out.print("--.");
			}
			if (such_fertigJahr != -100) {
				System.out.println(such_fertigJahr);
			}
			else {
				System.out.println("----");
			}
			System.out.println("");
			try {
				int eingabe = s.nextInt();

				if (eingabe == 0) {
					suchVorgang = false;
				}
				if (eingabe == 1) {
					try {
						such_auftragsID = einlesen_Wort(kategorie, eingabe);
						if (such_auftragsID.equals(0)) {
							such_auftragsID = auftragsID;
						} else {
							check = check + "a";
						}
					} catch (InputMismatchException e) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
					}
				}
				if (eingabe == 2) {
					try {
						such_wohnungsID = einlesen_Zahl(kategorie, eingabe);
						if (such_wohnungsID == 0) {
							such_wohnungsID = wohnungsID;
						} else {
							check = check + "b";
						}
					} catch (InputMismatchException e) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
					}
				}
				if (eingabe == 3) {
					try {
						such_mitarbeiterID = einlesen_Zahl(kategorie, eingabe);
						if (such_mitarbeiterID == 0) {
							such_mitarbeiterID = mitarbeiterID;
						} else {
							check = check + "c";
						}
					} catch (InputMismatchException e) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
					}
				}
				if (eingabe == 4) {

					such_m�ngelbeschreibung = einlesen_Wort(kategorie, eingabe);
					if (such_m�ngelbeschreibung.equals("" + 0)) {
						such_m�ngelbeschreibung = m�ngelbeschreibung;
					} else {
						check = check + "d";
					}
				}
				if (eingabe == 5) {
					such_status = einlesen_Wort(kategorie, eingabe);
					if (such_status.equals("" + 0)) {
						such_status = status;
					} else {
						check = check + "e";
					}
				}
				if (eingabe == 6) {
					System.out.println("Spezialisierung des zu suchenden Eingabedatums: ");
					System.out.println("Dr�cke '1' f�r Tag: ");
					System.out.println("Dr�cke '2' f�r Monat: ");
					System.out.println("Dr�cke '3' f�r Jahr: ");
					System.out.println("Dr�cke '4' f�r Best�tigen: ");
					System.out.println("Dr�cke '5' f�r Abbruch: ");
					
					String[] auswahl = { "Tag", "Monat", "Jahr"};
					boolean datumseingabe = true;
					String saveCheck = check;

					while (datumseingabe == true) {
						
						Scanner q = new Scanner(System.in);
						int z�hler = q.nextInt();

						if (z�hler == 1) {
							such_eingangsTag = einlesen_Zahl(auswahl, z�hler);
							if (such_eingangsTag == 0) {
								such_eingangsTag = eingangsTag;
							} else {
								saveCheck = saveCheck + "x";
							}
						}

						if (z�hler == 2) {
							such_eingangsMonat = einlesen_Zahl(auswahl, z�hler);
							if (such_eingangsMonat == 0) {
								such_eingangsMonat = eingangsMonat;
							} else {
								saveCheck = saveCheck + "y";
							}
						}
						if (z�hler == 3) {
							such_eingangsJahr = einlesen_Zahl(auswahl, z�hler);
							if (such_eingangsJahr == 0) {
								such_eingangsJahr = eingangsJahr;
							} else {
								saveCheck = saveCheck + "z";
							}
						}
						if (z�hler == 4) {
							datumseingabe = false;
							check = check + saveCheck;
						}
						if (z�hler == 5) {
							datumseingabe = false;
						}
					}
				}
				if (eingabe == 7) {
					System.out.println("Spezialisierung des zu suchenden Fertigstellungsdatums: ");
					System.out.println("Dr�cke '1' f�r Tag: ");
					System.out.println("Dr�cke '2' f�r Monat: ");
					System.out.println("Dr�cke '3' f�r Jahr: ");
					System.out.println("Dr�cke '4' f�r Best�tigen: ");
					System.out.println("Dr�cke '5' f�r Abbruch: ");
					
					String[] auswahl = { "Tag", "Monat", "Jahr"};
					boolean datumseingabe = true;
					String saveCheck = check;

					while (datumseingabe == true) {

						Scanner q = new Scanner(System.in);
						int z�hler = q.nextInt();

						if (z�hler == 1) {
							such_fertigTag = einlesen_Zahl(auswahl, z�hler);
							if (such_fertigTag == 0) {
								such_fertigTag = fertigTag;
							} else {
								saveCheck = saveCheck + "k";
							}
						}

						if (z�hler == 2) {
							such_fertigMonat = einlesen_Zahl(auswahl, z�hler);
							if (such_fertigMonat == 0) {
								such_fertigMonat = fertigMonat;
							} else {
								saveCheck = saveCheck + "l";
							}
						}
						if (z�hler == 3) {
							such_fertigJahr = einlesen_Zahl(auswahl, z�hler);
							if (such_fertigJahr == 0) {
								such_fertigJahr = fertigJahr;
							} else {
								saveCheck = saveCheck + "m";
							}
						}
						if (z�hler == 4) {
							datumseingabe = false;
							check = check + saveCheck;
						}
						if (z�hler == 5) {
							datumseingabe = false;
						}
					}
				}

				if (eingabe == 8) {
					suchVorgang = false;

					String vgl_auftragsID = "-";
					int vgl_wohnungsID = -100;
					int vgl_mitarbeiterID = -100;
					String vgl_m�ngelbeschreibung = "-";
					String vgl_status = "-";

					int vgl_eingangsTag = -100;
					int vgl_eingangsMonat = -100;
					int vgl_eingangsJahr = -100;
					
					int vgl_fertigTag = -100;
					int vgl_fertigMonat = -100;
					int vgl_fertigJahr = -100;

					for (Handwerkerauftrag repair : repairList) {

						if (check.contains("a")) {
							vgl_auftragsID = repair.getAuftragsID();
						}
						if (check.contains("b")) {
							vgl_wohnungsID = repair.getWohnungsID();
						}
						if (check.contains("c")) {
							vgl_mitarbeiterID = repair.getMitarbeiterID();
						}
						if (check.contains("d")) {
							vgl_m�ngelbeschreibung = repair.getM�ngelbeschreibung();
						}
						if (check.contains("e")) {
							vgl_status = repair.getStatus();
						}
						if (check.contains("x")) {
							vgl_eingangsTag = repair.getEingangsdatum().getTag();
						}
						if (check.contains("y")) {
							vgl_eingangsMonat = repair.getEingangsdatum().getMonat();
						}
						if (check.contains("z")) {	
							vgl_eingangsJahr = repair.getEingangsdatum().getJahr();
						}
						if (check.contains("k")) {
							vgl_fertigTag = repair.getFertigstellungsDatum().getTag();
						}
						if (check.contains("l")) {
							vgl_fertigMonat = repair.getFertigstellungsDatum().getMonat();
						}
						if (check.contains("m")) {
							vgl_fertigJahr = repair.getFertigstellungsDatum().getJahr();
						}

						if (vgl_auftragsID.equals(such_auftragsID)
								&& vgl_wohnungsID == such_wohnungsID
								&& vgl_mitarbeiterID == such_mitarbeiterID
								&& vgl_m�ngelbeschreibung.contains(such_m�ngelbeschreibung) 
								&& vgl_status.contains(such_status)
								&& vgl_eingangsTag == such_eingangsTag && vgl_eingangsMonat == such_eingangsMonat && vgl_eingangsJahr == such_eingangsJahr
								&& vgl_fertigTag == such_fertigTag && vgl_fertigMonat == such_fertigMonat && vgl_fertigJahr == such_fertigJahr) {
							System.out.println("Auftrags ID:          " + repair.getAuftragsID());
							System.out.println("Wohnungs ID:          " + repair.getWohnungsID());
							System.out.println("Mitarbeiter ID:       " + repair.getMitarbeiterID());
							System.out.println("M�ngelbeschreibung:   " + repair.getM�ngelbeschreibung());
							System.out.println("Status:               " + repair.getStatus());
							System.out.println("Eingangsdatum:        " + repair.getEingangsdatum());
							System.out.println("Fertigstellungsdatum: " + repair.getFertigstellungsDatum());
							System.out.println("");
						}
					}
				}
			} catch (InputMismatchException e) {
				System.out.println(
						"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
			}
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
}
