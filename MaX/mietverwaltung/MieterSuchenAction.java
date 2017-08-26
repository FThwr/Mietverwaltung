package mietverwaltung;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MieterSuchenAction extends MenueManager implements Action , Serializable{

	@Override
	public void action() {

		System.out.println(
				"________________________________________ Mieter suchen ________________________________________");

		boolean suchVorgang = true;

		// Variablen zum Rücksetzen, falls 0 eingegeben wurde
		int mieterID = -100;
		String name = "-";
		String vorname = "-";
		int wohnung = -100;
		String EMail = "-";
		String straße = "";
		int plz = -100;
		String telefon = "-";
		
		
		// Variablen zur Speicherung des Suchwertes
		int such_mieterID = mieterID;
		String such_name = name;
		String such_vorname = vorname;
		int such_wohnung = wohnung;
		String such_EMail = EMail;
		String such_adresse_straße = straße;
		int such_adresse_plz = plz;
		String such_telefon = telefon;

		String[] kategorie = { "Mieter ID", "Name", "Vorname", "Wohnung", "E-Mail", "Adresse", "Telefonnummer" };

		/*
		 * Mit der Variable wird überprüft, welche Attribut-Abfragen der Nutzer
		 * benutzt hatte. Es wird immer ein Buchstabe gespeichert, wodruch die
		 * Variable weiß, dass er in der Abfrage was ausgewählt hatte. Später
		 * wird anhand dieses Kriteriums die Suche ermöglicht.
		 */
		String check = "";
		String[] savecheck = new String[8];

		/*
		 * Solange der Suchvorgang nicht beendet ist, wird immer eine Übersicht
		 * über die zu suchenden Werte ausgegeben, sofern das Attribut
		 * ausgewählt wurde. Wenn das Attribut nicht ausgewählt wurde, wird ein
		 * '-' angezeigt. Es wird pro Durchlauf immer 1 Attribut ausgewählt,
		 * welches man draufhin verändern kann.
		 */
		while (suchVorgang == true) {

			Scanner s = new Scanner(System.in);
			System.out.println(
					"............................... Wählen Sie die zu suchende Eigenschaft aus! ...............................");
			System.out.println("........... Aktuelle Suche nach: ...........");
			if (such_mieterID != -100) {
				System.out.println("1. Kunden ID:                 " + such_mieterID);
			} else {
				System.out.println("1. Kunden ID:                 " + "-");
			}
				System.out.println("2. Name:                      " + such_name);
				System.out.println("3. Vorname:                   " + such_vorname);
			if (such_wohnung != -100) {
				System.out.println("4. Wohnung:                   " + such_wohnung);
			} else {
				System.out.println("4. Wohnung:                   " + "-");
			}
				System.out.println("5. E-Mail:                    " + such_EMail);
				System.out.println("6. Adresse Straße:            " + such_adresse_straße);
			
				System.out.println("   Adresse Hausnummer:        " + "-");
			
			if (plz != -100) {
				System.out.println("6. Adresse Platz:             " + such_adresse_plz);
			}
			else {
				System.out.println("6. Adresse Platz:             " + "-");
			}
				System.out.println("7. Telefonnummer:             " + such_telefon);
				System.out.println("8. Suche abschließen");
				System.out.println("999. um die zu suchende Eigenschaft zurückzusetzen");
				System.out.println("0. Abbruch");
			System.out.println("");
			
			/*
			 * Die try-catch Klammer existiert für nicht erwünschte Eingaben wie
			 * Zeichen, wo Zahlen erwartet werden.
			 */
			try {
				int eingabe = s.nextInt();

				// Abbruch
				if (eingabe == 0) {
					System.out.println(
							"-------------------------------Suchvorgang wurde abgebrochen!-------------------------------\n");
					suchVorgang = false;
				}
				
				// Mieter-ID
				if (eingabe == 1) {
					
						int einlese = einlesen_Zahl(kategorie, eingabe);
						
						/*
						 * 999 = rückgängig machen des Attributes + löschen des
						 * Buchstabens
						 */
						if (einlese == 999) {
							savecheck[eingabe - 1] = "";
							such_mieterID = mieterID;
						} 
						
						// 0 = keine Veränderung, nur Abbruch der Abfrage
						else if (einlese == 0) {
						}
						
						// Eingabe weder 0 noch 999
						else {
							
							// Die Eingabe wird übernommen
							such_mieterID = einlese;
							savecheck[eingabe - 1] = "a";
						}
				}
				
				// Name
				if (eingabe == 2) {
					String einlese = einlesen_Wort(kategorie, eingabe);
					
					/*
					 * 999 = rückgängig machen des Attributes + löschen des
					 * Buchstabens
					 */
					if (einlese.equals("" + 999)) {
						savecheck[eingabe - 1] = "";
						such_name = name;
					} 
					
					
					// 0 = keine Veränderung, nur Abbruch der Abfrage
					else if (einlese.equals("" + 0)) {			
					}
					
					// Eingabe weder 0 noch 999
					else {
						
						// Die Eingabe wird übernommen
						such_name = einlese;
						savecheck[eingabe - 1] = "b";
					}
				}
				
				// Vorname
				if (eingabe == 3) {
					String einlese = einlesen_Wort(kategorie, eingabe);
					
					/*
					 * 999 = rückgängig machen des Attributes + löschen des
					 * Buchstabens
					 */
					if (einlese.equals("" + 999)) {
						savecheck[eingabe - 1] = "";
						such_vorname = vorname;
					} 
					
					// 0 = keine Veränderung, nur Abbruch der Abfrage
					else if (einlese.equals("" + 0)) {
					}
					
					// Eingabe weder 0 noch 999
					else {
						
						// Die Eingabe wird übernommen
						such_vorname = einlese;
						savecheck[eingabe - 1] = "c";
					}
				}
				
				// Wohnungsnummer
				if (eingabe == 4) {

						int einlese = einlesen_Zahl(kategorie, eingabe);
						
						/*
						 * 999 = rückgängig machen des Attributes + löschen des
						 * Buchstabens
						 */
						if (einlese == 999) {
							savecheck[eingabe - 1] = "";
							such_wohnung = wohnung;
						} 
						
						// 0 = keine Veränderung, nur Abbruch der Abfrage
						else if (einlese == 0) {
						}
						
						// Eingabe weder 0 noch 999
						else {
							
							// Die Eingabe wird übernommen
							such_wohnung = einlese;
							savecheck[eingabe - 1] = "d";
						}
				}
				
				// E-Mail
				if (eingabe == 5) {
					String einlese = einlesen_Wort(kategorie, eingabe);
					
					/*
					 * 999 = rückgängig machen des Attributes + löschen des
					 * Buchstabens
					 */
					if (einlese.equals("" + 999)) {
						savecheck[eingabe - 1] = "";
						such_EMail = EMail;
					}
					
					// 0 = keine Veränderung, nur Abbruch der Abfrage
					else if (einlese.equals("" + 0)) {
					}
					
					// Eingabe weder 0 noch 999
					else {
						
						// Die Eingabe wird übernommen
						such_EMail = einlese;
						savecheck[eingabe - 1] = "e";
					}
				}
				
				// Adresse
				if (eingabe == 6) {
					System.out.println("Spezialisierung der zu suchenden Adresse: ");
					System.out.println("Drücke '1'   für Straße: ");
					System.out.println("Drücke '2'   für Plz: ");
					System.out.println("Drücke '3'   zum Bestätigen");
					System.out.println("Drücke '0'   für Abbruch: ");

					String[] auswahl = { "Straße", "Plz"};
					boolean adresseingabe = true;
					
					String buchstabe_einfügen_straße = "";
					String buchstabe_einfügen_plz = "";

					while (adresseingabe == true) {

						Scanner q = new Scanner(System.in);
						int zähler = q.nextInt();

						
						// Straße
						if (zähler == 1) {
							String einlese = einlesen_Wort(auswahl, zähler);
							
							/*
							 * 999 = rückgängig machen des Attributes + löschen des
							 * Buchstabens
							 */
							if (einlese.equals("" + 999)) {
								savecheck[eingabe - 1] = "";
								such_adresse_straße = straße;
							} 
							
							// 0 = keine Veränderung, nur Abbruch der Abfrage
							else if (einlese.equals("" + 0)) {
							}
							
							// Eingabe weder 0 noch 999
							else {
								
								// Die Eingabe wird übernommen
								such_adresse_straße = einlese;
								buchstabe_einfügen_straße = buchstabe_einfügen_straße + "y";
							}
						}

						// Plz
						if (zähler == 2) {
							int einlese = einlesen_Zahl(auswahl, zähler);
							
							/*
							 * 999 = rückgängig machen des Attributes + löschen des
							 * Buchstabens
							 */
							if (einlese == 999) {
								savecheck[eingabe] = "";
								such_adresse_plz = plz;
							}
							
							// 0 = keine Veränderung, nur Abbruch der Abfrage
							else if (einlese == 0) {
							}
							
							// Eingabe weder 0 noch 999
							else {
								
								// Die Eingabe wird übernommen
								such_adresse_plz = einlese;
								buchstabe_einfügen_plz = buchstabe_einfügen_plz + "z";
							}
						}
						
						if (zähler == 3) {
							adresseingabe = false;
							savecheck[eingabe - 1] = buchstabe_einfügen_straße;
							savecheck[eingabe] = buchstabe_einfügen_plz;
						}
						
						// Abbruch
						if (zähler == 0) {
							adresseingabe = false;
						}
						if (zähler > 3) {
							System.out.println(
									"\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit existiert nicht!");
						}
					}
				}
				
				// Telefonnummer
				if (eingabe == 7) {
					String einlese = einlesen_Wort(kategorie, eingabe);
					
					/*
					 * 999 = rückgängig machen des Attributes + löschen des
					 * Buchstabens
					 */
					if (einlese.equals("" + 999)) {
						savecheck[eingabe] = "";
						such_telefon = telefon;
					} 
					
					// 0 = keine Veränderung, nur Abbruch der Abfrage
					else if (einlese.equals("" + 0)) {
					}
					
					// Eingabe weder 0 noch 999
					else {
						
						// Die Eingabe wird übernommen
						such_telefon = einlese;
						savecheck[eingabe] = "f";
					}
				}

				// Suche abschließen
				if (eingabe == 8) {
					suchVorgang = false;

					
					// Vergleichsvariablen zu den Suchvariablen
					int vgl_mieterID = -100;
					String vgl_name = "-";
					String vgl_vorname = "-";

					int vgl_wohnung = -100;
					String vgl_EMail = "-";

					String vgl_adresse_straße = "-";
					int vgl_adresse_plz = -100;

					String vgl_telefon = "-";

					
					for (int i = 0; i < savecheck.length; i++) {
						if (savecheck[i] != null)
							check = check + savecheck[i];
					}
					
					/*
					 * Wenn 'check' ein Buchstaben enthält war der Nutzer bei
					 * einer bestimmten Attributveränderung. Wenn ein Buchstabe
					 * nicht enthalten ist, so ist der Suchwert und der
					 * Vergleichswert gleich. Wenn nun ein Buchstabe enthalten
					 * ist wird in jedem Handwerkerauftrag nach der zu suchenden
					 * Eigenschaft gesucht und wenn diese gefunden wurde, wird
					 * das dazugehörige Objekt ausgegeben. Bei mehreren
					 * Buchstaben müssen alle eingegebene Suchattribute in einem
					 * Handwerkerauftrag vorhanden sein, damit eine Ausgabe
					 * ermöglicht werden kann.
					 */
					for (Mieter owner : ownerList) {

						if (check.contains("a")) {
							vgl_mieterID = owner.getKundenID();
						}
						if (check.contains("b")) {
							vgl_name = owner.getName();
						}
						if (check.contains("c")) {
							vgl_vorname = owner.getVorname();
						}
						if (check.contains("d")) {
							vgl_wohnung = owner.getWohnungsnummer();
						}
						if (check.contains("e")) {
							vgl_EMail = owner.getEmail();
						}
						if (check.contains("y")) {
							vgl_adresse_straße = owner.getAdresse().getStrasse();
						}	
						if (check.contains("z")) {
							vgl_adresse_plz = owner.getAdresse().getPlz();
						}
						if (check.contains("f")) {
							vgl_telefon = owner.getTelefonnummer();
						}

						if (vgl_mieterID == such_mieterID && vgl_name.contains(such_name) && vgl_vorname.contains(such_vorname)
								&& vgl_wohnung == such_wohnung && vgl_EMail.contains(such_EMail)
								&& vgl_adresse_straße.contains(such_adresse_straße)
								&& vgl_adresse_plz == such_adresse_plz && vgl_telefon.contains(such_telefon)) {
							if (owner.getKundenID() != -100) {
							System.out.println("Mieter ID:          " + owner.getKundenID());
							} 
							else {
								System.out.println("Mieter ID:          " + "-");
							}
							System.out.println("Name:               " + owner.getName());
							System.out.println("Vorname:            " + owner.getVorname());
							if (owner.getGeburtsdatum() != null) {
							System.out.println("Geburtsdatum:       " + owner.getGeburtsdatum());
							}
							else {
								System.out.println("Geburtsdatum:       " + "--.--.----");
							}
							if (owner.getWohnungsnummer() != -100) {
							System.out.println("Wohnung:            " + owner.getWohnungsnummer());
							}
							else {
								System.out.println("Wohnung:            " + "-");
							}
							System.out.println("E-Mail:             " + owner.getEmail());
							System.out.println("Adresse:            " + owner.getAdresse());
							System.out.println("Telefonnummer:      " + owner.getTelefonnummer());
							System.out.println("");
						}
					}
				}
				
				// Eingabe > 8
				if (eingabe > 8) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit existiert nicht!");
				}
			} catch (InputMismatchException e) {
				System.out.println(
						"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
			}
		}
	}

	/**
	 * Methode zum Einlesen einer Zahl vom Nutzer
	 * 
	 * @param auswahl
	 *            = welches "Änderungsfeld" der Nutzer betreten hat (Name des
	 *            Index des Arrays)
	 * @param zähler
	 *            = welches "Änderungsfeld" der Nutzer betreten hat (Nummer des
	 *            Index des Arrays)
	 * @return die eingelesene Zahl
	 */
	private int einlesen_Zahl(String[] auswahl, int zähler) {
		Scanner s = new Scanner(System.in);
		int zahl = -100;
		try {

			do {
				System.out.println("Geben Sie ein: " + auswahl[zähler - 1]);
				zahl = s.nextInt();
				if (zahl < 0) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nNur positive Zahlen erlaubt!\n");
				}
			} while (zahl < 0);
		} catch (InputMismatchException e) {
			System.out.println(
					"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
		}
		return zahl;
	}

	/**
	 * Methode zum Einlesen eines Wortes oder Satzes vom Nutzer
	 * 
	 * @param auswahl
	 *            = welches "Änderungsfeld" der Nutzer betreten hat (Name des
	 *            Index des Arrays)
	 * @param zähler
	 *            = welches "Änderungsfeld" der Nutzer betreten hat (Nummer des
	 *            Index des Arrays)
	 * @return das eingelesene Wort
	 */
	private String einlesen_Wort(String[] auswahl, int zähler) {
		System.out.println("Erstellen: " + auswahl[zähler - 1]);
		Scanner s = new Scanner(System.in);
		String wort = s.nextLine();
		return wort;
	}
}