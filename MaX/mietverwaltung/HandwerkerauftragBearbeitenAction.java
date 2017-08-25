package mietverwaltung;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HandwerkerauftragBearbeitenAction extends MenueManager implements Action, Serializable {

	static String bearbeitungsAuswahl_handwerkerauftragID;
	static int such_wohnung;
	static int such_mitarbeiterID;
	static String neue_handwerkerauftragID;
	static boolean window = false;

	@Override
	public void action() throws IOException {

		System.out.println(
				"________________________________________ Handwerkerauftrag bearbeiten ________________________________________");

		/*
		 * Variable zum Öffnen des richtigen JFrames und zur Auswahl des zu
		 * bearbeitenden Attributs.
		 */
		int änderung = -99;

		// Ausgabe aller Auftrag-IDs zur einfacheren Auswahl
		auswahl_AuftragsID_Wohnung_MitarbeiterID(änderung);

		// Variable enthält die ID des zu bearbeitenden Handwerkerauftrags
		String zu_bearbeitenden_handwerkerauftrag = bearbeitungsAuswahl_handwerkerauftragID;

		boolean bearbeitungsVorgang = true;

		String[] kategorie = { "Auftrags ID ", "Wohnungs ID", "Mitarbeiter ID", "Mängelbeschreibung", "Status",
				"Eingangsdatum", "Fertigstellungsdatum" };

		/*
		 * diese Variablen dienen später für eine tabellarische Ausgabe auf der
		 * Konsole
		 */
		String längenAnpassung_auftragsID = "";
		String längenAnpassung_wohnungsID = "";
		String längenAnpassung_mitarbeiterID = "";
		String längenAnpassung_mängelbeschreibung = "";
		String längenAnpassung_status = "";

		/*
		 * allgemeine Variablen alte = aktuelle Werte, neue = neue/veränderte
		 * Werte
		 */

		String aktuelleAuftragsID = "";
		String neueAuftragsID = "";

		int aktuelleWohnungsID = 0;
		int neueWohnungsID = 0;

		int aktuelleMitarbeiterID = 0;
		int neueMitarbeiterID = 0;

		String aktuelleMängelbeschreibung = "";
		String neueMängelbeschreibung = "";

		String aktuellerStatus = "";
		String neuerStatus = "";

		Datum aktuellesEingangsdatum = null;
		Datum neuesEingangsdatum = null;

		Datum aktuellesFertigstellungsdatum = null;
		Datum neuesFertigstellungsdatum = null;

		/*
		 * Variablen enthalten die Leerzeichen, die nach den Objekten (Daten)
		 * eingesetzt werden. Die Längen der einzelnen Komponenten der Objekte
		 * werden verwendet
		 */

		String ED_Leerzeichen = "";
		String FD_Leerzeichen = "";

		/*
		 * Für jedes Element in der ArrayList 'repairList', welche alle aktiven
		 * Handwerkeraufträge beeinhaltet, wir zeurst das Objekt in der
		 * ArrayList gesucht, welche der eben ausgewählten Auftrags-ID
		 * entspricht. Es werden neue Variablen angelegt, welche die einzelnen
		 * Werte des Objekts beeinhalten.
		 */
		for (Handwerkerauftrag repair : repairList) {
			if (zu_bearbeitenden_handwerkerauftrag.equals(repair.getAuftragsID())) {

				aktuelleAuftragsID = repair.getAuftragsID();
				neueAuftragsID = aktuelleAuftragsID;

				aktuelleWohnungsID = repair.getWohnungsID();
				neueWohnungsID = aktuelleWohnungsID;

				aktuelleMitarbeiterID = repair.getMitarbeiterID();
				neueMitarbeiterID = aktuelleMitarbeiterID;

				aktuelleMängelbeschreibung = repair.getMängelbeschreibung();
				neueMängelbeschreibung = aktuelleMängelbeschreibung;

				aktuellerStatus = repair.getStatus();
				neuerStatus = aktuellerStatus;

				aktuellesEingangsdatum = repair.getEingangsdatum();
				neuesEingangsdatum = aktuellesEingangsdatum;

				aktuellesFertigstellungsdatum = repair.getFertigstellungsDatum();
				neuesFertigstellungsdatum = aktuellesFertigstellungsdatum;

				/*
				 * Initialisierung der tabellarischen Variablen + Ausfüllung mit
				 * Leerzeichen (Umwandlung in die Tabelle)
				 */
				längenAnpassung_auftragsID = aktuelleAuftragsID;
				längenAnpassung_auftragsID = länge_anpassen(längenAnpassung_auftragsID);

				längenAnpassung_wohnungsID = "" + aktuelleWohnungsID;
				längenAnpassung_wohnungsID = länge_anpassen(längenAnpassung_wohnungsID);

				längenAnpassung_mitarbeiterID = "" + aktuelleMitarbeiterID;
				längenAnpassung_mitarbeiterID = länge_anpassen(längenAnpassung_mitarbeiterID);

				längenAnpassung_mängelbeschreibung = aktuelleMängelbeschreibung;
				längenAnpassung_mängelbeschreibung = länge_anpassen(längenAnpassung_mängelbeschreibung);

				längenAnpassung_status = aktuellerStatus;
				längenAnpassung_status = länge_anpassen(längenAnpassung_status);

				if (aktuellesEingangsdatum != null) {
					ED_Leerzeichen = länge_anpassen_Datum(aktuellesEingangsdatum);
				}

				if (aktuellesFertigstellungsdatum != null) {
					FD_Leerzeichen = länge_anpassen_Datum(aktuellesFertigstellungsdatum);
				}

			}
		}

		/*
		 * Solange der Bearbeitungsvorgang nicht beendet ist, wird immer eine
		 * Übersicht über den alten Wert und den neuen Wert des jeweiligen
		 * Attributs ausgegeben. Es wird pro Durchlauf immer 1 Attribut
		 * ausgewählt, welches man draufhin verändern kann.
		 */
		while (bearbeitungsVorgang == true) {

			System.out.println(
					"............................... Wählen Sie die zu bearbeitende Eigenschaft aus! ...............................\n");
			System.out.println("1. Auftrags ID:          " + längenAnpassung_auftragsID + "neue Auftrags ID:           "
					+ neueAuftragsID);
			System.out.println("2. Wohnungs ID:          " + längenAnpassung_wohnungsID + "neue Wohnungs ID:           "
					+ neueWohnungsID);
			System.out.println("3. Mitarbeiter ID:       " + längenAnpassung_mitarbeiterID
					+ "neue Mitarbeiter ID:        " + neueMitarbeiterID);
			System.out.println("4. Mängelbeschreibung:   " + längenAnpassung_mängelbeschreibung
					+ "neue Mängelbeschreibung:    " + neueMängelbeschreibung);
			System.out.println("5. Status:               " + längenAnpassung_status + "neuer Status:               "
					+ neuerStatus);
			System.out.println("6. Eingangsdatum:        " + aktuellesEingangsdatum + ED_Leerzeichen
					+ "neues Eingangsdatum:        " + neuesEingangsdatum);
			System.out.println("7. Fertigstellungsdatum: " + aktuellesFertigstellungsdatum + FD_Leerzeichen
					+ "neues Fertigstellungsdatum: " + neuesFertigstellungsdatum);
			System.out.println("8. Bearbeitung abschließen");
			System.out.println("0. Abbruch des Bearbeitungsvorgangs");
			System.out.println("");

			Scanner t = new Scanner(System.in);

			/*
			 * Die try-catch Klammer existiert für nicht erwünschte Eingaben wie
			 * Zeichen, wo Zahlen erwartet werden.
			 */
			try {

				// Variable zur Auswahl des zu bearbeitenden Attributs
				änderung = t.nextInt();

				// Abbruch
				if (änderung == 0) {
					System.out.println(
							"-------------------------------Bearbeitungsvorgang wurde abgebrochen!-------------------------------\n");
					bearbeitungsVorgang = false;
				}

				// Auftrags-ID
				if (änderung == 1) {

					String eingabe = einlesen_Wort(kategorie, änderung);
					if (eingabe.equals("" + 0)) {
					} else {

						int vorhanden = 0;
						/*
						 * Für jedes Element in der Handwerkerliste der aktiven
						 * Aufträge wird geguckt, ob die eingegebende ID mit
						 * einer bereits existierenden übereinstimmt.
						 */
						for (Handwerkerauftrag repair : repairList) {
							if (eingabe.equals(repair.getAuftragsID())) {
								vorhanden = 1;
							}
						}

						/*
						 * Für jedes Element in der Handwerkerliste der
						 * abgeschlossenen Aufträge wird geguckt, ob die
						 * eingegebende ID mit einer bereits existierenden
						 * übereinstimmt.
						 */
						for (Handwerkerauftrag auftrag : abgeschlosseneHandwerkeraufträge) {
							if (eingabe.equals(auftrag.getAuftragsID())) {
								vorhanden = 1;
							}
						}

						/*
						 * Wenn die Variable 'vorhanden' = 1, dann existierte
						 * ein Handwerkerauftrag mit dieser ID bereits. Sonst
						 * wird die eingegebene ID die ID des Auftrags.
						 */
						if (vorhanden == 1) {
							System.out.println(
									"\n------------------------------- Fehler! ------------------------------- \nAuftrags ID bereits vergeben!\n");
						} else {
							neueAuftragsID = eingabe;
						}
					}

				}

				// Wohnungsnummer
				if (änderung == 2) {

					auswahl_AuftragsID_Wohnung_MitarbeiterID(änderung);
					neueWohnungsID = such_wohnung;
				}

				// Mitarbeiter-ID
				if (änderung == 3) {

					auswahl_AuftragsID_Wohnung_MitarbeiterID(änderung);
					neueMitarbeiterID = such_mitarbeiterID;
				}

				// Mängelbeschreibung
				if (änderung == 4) {
					String eingabe = einlesen_Wort(kategorie, änderung);
					if (eingabe.equals("" + 0)) {
						neueMängelbeschreibung = aktuelleMängelbeschreibung;
					} else {
						neueMängelbeschreibung = eingabe;
					}
				}

				// Status
				if (änderung == 5) {

					System.out.println(
							"Geben Sie die Zahl vom gewünschten Status aus: '1' = in Bearbeitung, '2' = beendet, '0' = Abbruch!");
					int eingabe = einlesen_Zahl(kategorie, änderung);

					if (eingabe == 1) {
						neuerStatus = "in Bearbeitung";
					}
					if (eingabe == 2) {
						neuerStatus = "beendet";
					}

					if (eingabe == 0) {
						neuerStatus = aktuellerStatus;
					}

					// Jede andere Eingabe führt zu einer Fehlermeldung.
					if (eingabe > 2) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit nicht vorhanden!\n");
					}
				}

				// Eingangsdatum
				if (änderung == 6) {

					neuesEingangsdatum = Datum_Eingabe(aktuellesEingangsdatum);
				}

				// Fertigstellungsdatum
				if (änderung == 7) {

					neuesFertigstellungsdatum = Datum_Eingabe(aktuellesFertigstellungsdatum);
				}

				// Bearbeitung abschließen
				if (änderung == 8) {
					bearbeitungsVorgang = false;

					if (neuerStatus.equals("in Bearbeitung")) {

						/*
						 * Wenn der Status des Handwerkerauftrags 'in
						 * Bearbeitung' ist, dann wird für jede Wohnung in der
						 * ArrayList mit den Wohnungen überprüft, welche Wohnung
						 * den Handwerkerautrag (die Auftrags-ID) erhält.
						 */

						for (Wohnung flat : flatList) {
							if (neueWohnungsID == flat.getWohnungsID()) {
								flat.getHandwerkerauftrag().setAuftragsID(neueAuftragsID);

							}
						}

						/*
						 * Außerdem werden nach dem Herausfinden, welcher
						 * Handwerkerautrag so eben bearbeitet wurde, die
						 * einzelnen veränderten Attribute nun geändert.
						 */
						for (Handwerkerauftrag repair : repairList) {
							if (zu_bearbeitenden_handwerkerauftrag.equals(repair.getAuftragsID())) {
								repair.setAuftragsID(neueAuftragsID);
								repair.setWohnungsID(neueWohnungsID);
								repair.setMitarbeiterID(neueMitarbeiterID);
								repair.setMängelbeschreibung(neueMängelbeschreibung);
								repair.setStatus(neuerStatus);
								repair.setEingangsdatum(neuesEingangsdatum);
								repair.setFertigstellungsDatum(neuesFertigstellungsdatum);
							}
						}
					}

					if (neuerStatus.equals("beendet")) {

						/*
						 * Da der Auftrag abgeschlossen ist, wird er der Liste
						 * der abgeschlossenen Aufträge hinzugefügt.
						 */
						abgeschlosseneHandwerkeraufträge.add(new Handwerkerauftrag(neueAuftragsID, neueWohnungsID,
								neueMitarbeiterID, neueMängelbeschreibung, neuerStatus, neuesEingangsdatum,
								aktuellesFertigstellungsdatum));

						/*
						 * Auderdem wird der Handwerkerautrag aus der Liste der
						 * aktiven Aufträge entfernt
						 */
						Iterator<Handwerkerauftrag> iter = repairList.iterator();

						while (iter.hasNext()) {
							Handwerkerauftrag str = iter.next();

							if (str.getAuftragsID().equals(zu_bearbeitenden_handwerkerauftrag)) {
								iter.remove();

							}
						}

						/*
						 * Der Handwerkerauftrag wir aus ihm zugeordneten
						 * Wohnung entfernt
						 */
						for (Wohnung flat : flatList) {
							if (aktuelleWohnungsID == flat.getWohnungsID()) {
								flat.getHandwerkerauftrag().setAuftragsID("");
							}
						}
					}
				}
				// Eingabe > 8
				if (änderung > 8) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit nicht vorhanden!\n");
				}
			} catch (InputMismatchException e) {
				System.out.println(
						"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
			}
		}
	}

	/**
	 * Methode zur Eingabe des Datums
	 * 
	 * @param aktuellesDatum,
	 *            was der Handwerkerauftrag zu dem Zeitpunkt noch benutzt
	 * @return das neue Datum, welches weiterverwendet werden soll
	 */
	public Datum Datum_Eingabe(Datum aktuellesDatum) {

		System.out
				.println("Eingabe des Eingangdatums: Wählen Sie bei einem Wert '0' und das Datum bleibt unverändert!");
		String[] auswahl = { "Jahr", "Monat", "Tag" };

		Datum neuesDatum = null;
		boolean datumsEingabeErfolgreich = false;

		int zähler = 1;
		int jahr = einlesen_Zahl(auswahl, zähler);

		zähler = 2;
		int monat = 0;
		do {
			monat = einlesen_Zahl(auswahl, zähler);
			if (monat > 12) {
				System.out.println(
						"\n------------------------------- Fehler! ------------------------------- \nMonat darf nicht höher als 12 sein!");
			}
		} while (monat > 12);

		zähler = 3;
		int tag = 0;
		do {
			tag = einlesen_Zahl(auswahl, zähler);
			if (monat == 1 || monat == 3 || monat == 5 || monat == 7 || monat == 8 || monat == 10 || monat == 12) {
				if (tag > 31) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 31 Tage!");
				} else {
					datumsEingabeErfolgreich = true;
				}
			}

			if (monat == 4 || monat == 6 || monat == 9 || monat == 11) {
				if (tag > 30) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 30 Tage!");
				} else {
					datumsEingabeErfolgreich = true;
				}
			}

			if (monat == 2) {
				if (tag > 29) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 29 Tage!");
				} else {
					datumsEingabeErfolgreich = true;
				}
			}
		} while (datumsEingabeErfolgreich == false);

		/*
		 * Wenn einer der Werte versucht wird zu überspringen/ auszulassen, dann
		 * bleibt es beim unveränderten Datum.
		 */
		if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
			neuesDatum = aktuellesDatum;
		} else {
			neuesDatum = new Datum(tag, monat, jahr);
		}
		return neuesDatum;
	}

	/**
	 * Methode zur Auswahl eines bereits existierend Attributs durch Vorschlag
	 * jedes einzelnen Elements in einer ArrayList
	 * 
	 * @param änderung
	 *            = Zähler des Attributs -> Bestimmung, welcher Fall eintritt
	 *            (ob eine Wohnung, etc. bearbeitet wird)
	 */
	private void auswahl_AuftragsID_Wohnung_MitarbeiterID(int änderung) {
		window = false;
		bearbeitungsAuswahl_handwerkerauftragID = "";
		neue_handwerkerauftragID = "";
		such_wohnung = -100;
		JFrame meinRahmen = new JFrame();

		meinRahmen.setSize(250, 250);
		JPanel meinPanel = new JPanel();
		meinRahmen.setLocationRelativeTo(null);

		JComboBox combo2 = new JComboBox();
		combo2.addItem("" + 0);

		if (änderung == -99) {
			meinRahmen.setTitle("Handwerkerauftrag ID");
			JLabel frage = new JLabel("Welchen Handwerkerauftrag möchten Sie bearbeiten?");
			meinPanel.add(frage);
			for (Handwerkerauftrag repair : repairList) {
				combo2.addItem(repair.getAuftragsID());
			}
		}

		if (änderung == 1) {
			meinRahmen.setTitle("Handwerkerauftrag ID");
			JLabel frage = new JLabel("Welche Handwerkerauftrag möchten Sie auswählen?");
			meinPanel.add(frage);
			for (Handwerkerauftrag repair : repairList) {
				combo2.addItem(repair.getAuftragsID());
			}
		}

		if (änderung == 2) {
			meinRahmen.setTitle("Wohnungsnummer");
			JLabel frage = new JLabel("Welche Wohnung möchten Sie auswählen?");
			meinPanel.add(frage);
			for (Wohnung flat : flatList) {
				combo2.addItem(flat.getWohnungsID());
			}
		}

		if (änderung == 3) {
			meinRahmen.setTitle("Mitarbeiter-ID");
			JLabel frage = new JLabel("Welchen Mitarbeiter (ID) möchten Sie auswählen?");
			meinPanel.add(frage);
			for (Handwerkerauftrag repair : repairList) {
				combo2.addItem(repair.getAuftragsID());
			}
		}

		meinRahmen.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				window = true;
			}
		});

		ActionListener cbActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (änderung == -99) {
					bearbeitungsAuswahl_handwerkerauftragID = (String) combo2.getSelectedItem();
				}
				if (änderung == 1) {
					neue_handwerkerauftragID = (String) combo2.getSelectedItem();
				}
				if (änderung == 2) {
					such_wohnung = (int) combo2.getSelectedItem();
				}
				if (änderung == 3) {
					such_mitarbeiterID = (int) combo2.getSelectedItem();
				}

			}
		};
		meinPanel.add(combo2);
		meinRahmen.add(meinPanel, BorderLayout.SOUTH);
		meinRahmen.pack();
		meinRahmen.setVisible(true);
		while (window == false) {
			combo2.addActionListener(cbActionListener);
		}

	}

	private int einlesen_Zahl(String[] auswahl, int zähler) {

		Scanner s = new Scanner(System.in);
		int zahl = -100;
		try {

			do {
				System.out.println("Geben Sie ein: " + auswahl[zähler - 1]);
				zahl = s.nextInt();
				if (zahl < 0) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nNur positive Zahlen erlaubt!");
				}
			} while (zahl < 0);
		} catch (InputMismatchException e) {
			System.out.println(
					"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
		}
		return zahl;
	}

	private String einlesen_Wort(String[] auswahl, int zähler) {
		System.out.println("Geben Sie ein: " + auswahl[zähler - 1]);
		Scanner s = new Scanner(System.in);
		String wort = s.nextLine();
		return wort;
	}

	private String länge_anpassen_Datum(Datum a_GD) {

		String leerzeichen = "";
		int abzug = 0;
		
		if (a_GD != null) {

		String jahr = "" + a_GD.getJahr();
		int l_J = jahr.length();

		String monat = "" + a_GD.getMonat();
		int l_M = monat.length();

		String tag = "" + a_GD.getTag();
		int l_T = tag.length();

		abzug = l_J + l_M + l_T + 2; // +2 für die Punkte zwischen den
										// Komponenten
		}
		
		else {
			abzug = 4;
		}
		if (abzug < 50) {
			while (abzug < 50) {
				leerzeichen = leerzeichen + " ";
				abzug += 1;
			}
		}
		
		return leerzeichen;
	}

	private String länge_anpassen(String wort) {

		if (wort.length() < 50) {
			while (wort.length() < 50) {
				wort = wort + " ";
			}
		}
		return wort;
	}

}
