package action;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hilfsklassen.Datum;
import menu.MenuManager;
import objekte.Handwerkerauftrag;
import objekte.Wohnung;

public class HandwerkerauftragBearbeitenAction extends MenuManager implements Action, Serializable {

	static String bearbeitungsAuswahl_handwerkerauftragID;
	static int neue_wohnung;
	static int neue_mitarbeiterID;
	static boolean window = false;

	@Override
	public void action() {

		System.out.println(
				"________________________________________ Handwerkerauftrag bearbeiten ________________________________________\n");

		/*
		 * Variable zum �ffnen des richtigen JFrames und zur Auswahl des zu
		 * bearbeitenden Attributs.
		 */
		int �nderung = -99;

		// Ausgabe aller Auftrag-IDs zur einfacheren Auswahl
		JComboBox_optimierte_Auswahl(�nderung);

		// Variable enth�lt die ID des zu bearbeitenden Handwerkerauftrags
		String zu_bearbeitenden_handwerkerauftrag = HandwerkerauftragBearbeitenAction.bearbeitungsAuswahl_handwerkerauftragID;

		boolean bearbeitungsVorgang = true;

		/*
		 * Array beeinhaltet alle Attribute, die ver�ndert werden k�nnen und
		 * dient zur Ausgabe durch Zugriff auf deren Index
		 */
		String[] kategorie = { "Auftrags ID ", "Wohnungs ID", "Mitarbeiter ID", "M�ngelbeschreibung", "Status",
				"Eingangsdatum", "Fertigstellungsdatum" };

		/*
		 * diese Variablen dienen sp�ter f�r eine tabellarische Ausgabe auf der
		 * Konsole
		 */
		String l�ngenAnpassung_auftragsID = "";
		String l�ngenAnpassung_wohnungsID = "";
		String l�ngenAnpassung_mitarbeiterID = "";
		String l�ngenAnpassung_m�ngelbeschreibung = "";
		String l�ngenAnpassung_status = "";

		/*
		 * allgemeine Variablen alte = aktuelle Werte, neue = neue/ver�nderte
		 * Werte
		 */

		String aktuelleAuftragsID = "-";
		String neueAuftragsID = "-";

		int aktuelleWohnungsID = -100;
		int neueWohnungsID = -100;

		int aktuelleMitarbeiterID = -100;
		int neueMitarbeiterID = -100;

		String aktuelleM�ngelbeschreibung = "-";
		String neueM�ngelbeschreibung = "-";

		String aktuellerStatus = "-";
		String neuerStatus = "-";

		Datum aktuellesEingangsdatum = null;
		Datum neuesEingangsdatum = null;

		Datum aktuellesFertigstellungsdatum = null;
		Datum neuesFertigstellungsdatum = null;

		/*
		 * Variablen enthalten die Leerzeichen, die nach den Objekten (Daten)
		 * eingesetzt werden. Die L�ngen der einzelnen Komponenten der Objekte
		 * werden verwendet
		 */

		String ED_Leerzeichen = "";
		String FD_Leerzeichen = "";

<<<<<<< HEAD
        /*
         * F�r jedes Element in der Handwerkerauftragsliste wird zuerst das Objekt in der
         * ArrayList gesucht, welche der eben ausgew�hlten Auftrags-ID
         * entspricht. Es werden neue Variablen angelegt, welche die einzelnen
         * Werte des Objekts beeinhalten.
         */
        for (Handwerkerauftrag repair : MenuManager.getRepairList()) {
            if (zu_bearbeitenden_handwerkerauftrag.equals(repair.getAuftragsID())) {
=======
		/*
		 * F�r jedes Element in der Handwerkerauftragsliste wird zuerst das
		 * Objekt in der ArrayList gesucht, welche der eben ausgew�hlten
		 * Auftrags-ID entspricht. Es werden neue Variablen angelegt, welche die
		 * einzelnen Werte des Objekts beeinhalten.
		 */
		for (Handwerkerauftrag repair : MenuManager.repairList) {
			if (zu_bearbeitenden_handwerkerauftrag.equals(repair.getAuftragsID())) {
>>>>>>> branch 'master' of https://github.com/FThwr/Mietverwaltung

				aktuelleAuftragsID = repair.getAuftragsID();
				neueAuftragsID = aktuelleAuftragsID;

				aktuelleWohnungsID = repair.getWohnungsID();
				neueWohnungsID = aktuelleWohnungsID;

				aktuelleMitarbeiterID = repair.getMitarbeiterID();
				neueMitarbeiterID = aktuelleMitarbeiterID;

				aktuelleM�ngelbeschreibung = repair.getM�ngelbeschreibung();
				neueM�ngelbeschreibung = aktuelleM�ngelbeschreibung;

				aktuellerStatus = repair.getStatus();
				neuerStatus = aktuellerStatus;

				aktuellesEingangsdatum = repair.getEingangsdatum();
				neuesEingangsdatum = aktuellesEingangsdatum;

				aktuellesFertigstellungsdatum = repair.getFertigstellungsDatum();
				neuesFertigstellungsdatum = aktuellesFertigstellungsdatum;

				/*
				 * Initialisierung der tabellarischen Variablen + Ausf�llung mit
				 * Leerzeichen (Umwandlung in die Tabelle)
				 */
				l�ngenAnpassung_auftragsID = aktuelleAuftragsID;
				l�ngenAnpassung_auftragsID = l�nge_anpassen(l�ngenAnpassung_auftragsID);

				l�ngenAnpassung_wohnungsID = "" + aktuelleWohnungsID;
				l�ngenAnpassung_wohnungsID = l�nge_anpassen(l�ngenAnpassung_wohnungsID);

				l�ngenAnpassung_mitarbeiterID = "" + aktuelleMitarbeiterID;
				l�ngenAnpassung_mitarbeiterID = l�nge_anpassen(l�ngenAnpassung_mitarbeiterID);

				l�ngenAnpassung_m�ngelbeschreibung = aktuelleM�ngelbeschreibung;
				l�ngenAnpassung_m�ngelbeschreibung = l�nge_anpassen(l�ngenAnpassung_m�ngelbeschreibung);

				l�ngenAnpassung_status = aktuellerStatus;
				l�ngenAnpassung_status = l�nge_anpassen(l�ngenAnpassung_status);

				if (aktuellesEingangsdatum != null) {
					ED_Leerzeichen = l�nge_anpassen_Datum(aktuellesEingangsdatum);
				}

				if (aktuellesFertigstellungsdatum != null) {
					FD_Leerzeichen = l�nge_anpassen_Datum(aktuellesFertigstellungsdatum);
				}
			}
		}

		/*
		 * Solange der Bearbeitungsvorgang nicht beendet ist, wird immer eine
		 * �bersicht �ber den alten Wert und den neuen Wert des jeweiligen
		 * Attributs ausgegeben. Es wird pro Durchlauf immer 1 Attribut
		 * ausgew�hlt, welches man draufhin ver�ndern kann.
		 */
		while (bearbeitungsVorgang == true) {

			System.out.println(
					"............................... W�hlen Sie die zu bearbeitende Eigenschaft aus! ...............................\n");
			System.out.println("1. Auftrags ID:          " + l�ngenAnpassung_auftragsID + "neue Auftrags ID:           "
					+ neueAuftragsID);
			System.out.println("2. Wohnungs ID:          " + l�ngenAnpassung_wohnungsID + "neue Wohnungs ID:           "
					+ neueWohnungsID);
			System.out.println("3. Mitarbeiter ID:       " + l�ngenAnpassung_mitarbeiterID
					+ "neue Mitarbeiter ID:        " + neueMitarbeiterID);
			System.out.println("4. M�ngelbeschreibung:   " + l�ngenAnpassung_m�ngelbeschreibung
					+ "neue M�ngelbeschreibung:    " + neueM�ngelbeschreibung);
			System.out.println("5. Status:               " + l�ngenAnpassung_status + "neuer Status:               "
					+ neuerStatus);
			System.out.println("6. Eingangsdatum:        " + aktuellesEingangsdatum + ED_Leerzeichen
					+ "neues Eingangsdatum:        " + neuesEingangsdatum);
			System.out.println("7. Fertigstellungsdatum: " + aktuellesFertigstellungsdatum + FD_Leerzeichen
					+ "neues Fertigstellungsdatum: " + neuesFertigstellungsdatum);
			System.out.println("8. Bearbeitung abschlie�en");
			System.out.println("0. Abbruch des Bearbeitungsvorgangs");
			System.out.println("");

			Scanner t = new Scanner(System.in);

			/*
			 * Die try-catch Klammer existiert f�r nicht erw�nschte Eingaben wie
			 * Zeichen, wo Zahlen erwartet werden.
			 */
			try {

				// Variable zur Auswahl des zu bearbeitenden Attributs
				�nderung = t.nextInt();

				// Abbruch
				if (�nderung == 0) {
					System.out.println(
							"-------------------------------Bearbeitungsvorgang wurde abgebrochen!-------------------------------\n");
					bearbeitungsVorgang = false;
				}

				// Auftrags-ID
				if (�nderung == 1) {

					String eingabe = einlesen_Wort(kategorie, �nderung);
					if (eingabe.equals("" + 0)) {
					} else {

<<<<<<< HEAD
                        int vorhanden = 0;
                        /*
                         * F�r jedes Element in der Handwerkerliste der aktiven
                         * Auftr�ge wird geguckt, ob die eingegebende ID mit
                         * einer bereits existierenden �bereinstimmt.
                         */
                        for (Handwerkerauftrag repair : MenuManager.getRepairList()) {
                            if (eingabe.equals(repair.getAuftragsID())) {
                                vorhanden = 1;
                            }
                        }
=======
						int vorhanden = 0;
						/*
						 * F�r jedes Element in der Handwerkerliste der aktiven
						 * Auftr�ge wird geguckt, ob die eingegebende ID mit
						 * einer bereits existierenden �bereinstimmt.
						 */
						for (Handwerkerauftrag repair : MenuManager.repairList) {
							if (eingabe.equals(repair.getAuftragsID())) {
								vorhanden = 1;
							}
						}
>>>>>>> branch 'master' of https://github.com/FThwr/Mietverwaltung

<<<<<<< HEAD
                        /*
                         * F�r jedes Element in der Handwerkerliste der
                         * abgeschlossenen Auftr�ge wird geguckt, ob die
                         * eingegebende ID mit einer bereits existierenden
                         * �bereinstimmt.
                         */
                        for (Handwerkerauftrag auftrag : MenuManager.getAbgeschlosseneHandwerkerauftr�ge()) {
                            if (eingabe.equals(auftrag.getAuftragsID())) {
                                vorhanden = 1;
                            }
                        }
=======
						/*
						 * F�r jedes Element in der Handwerkerliste der
						 * abgeschlossenen Auftr�ge wird geguckt, ob die
						 * eingegebende ID mit einer bereits existierenden
						 * �bereinstimmt.
						 */
						for (Handwerkerauftrag auftrag : MenuManager.abgeschlosseneHandwerkerauftr�ge) {
							if (eingabe.equals(auftrag.getAuftragsID())) {
								vorhanden = 1;
							}
						}
>>>>>>> branch 'master' of https://github.com/FThwr/Mietverwaltung

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
				if (�nderung == 2) {

					JComboBox_optimierte_Auswahl(�nderung);
					neueWohnungsID = HandwerkerauftragBearbeitenAction.neue_wohnung;
				}

				// Mitarbeiter-ID
				if (�nderung == 3) {

					JComboBox_optimierte_Auswahl(�nderung);
					neueMitarbeiterID = HandwerkerauftragBearbeitenAction.neue_mitarbeiterID;
				}

				// M�ngelbeschreibung
				if (�nderung == 4) {
					String eingabe = einlesen_Wort(kategorie, �nderung);
					if (eingabe.equals("" + 0)) {
					} else {
						neueM�ngelbeschreibung = eingabe;
					}
				}

				// Status
				if (�nderung == 5) {

					System.out.println(
							"Geben Sie die Zahl vom gew�nschten Status aus: '1' = in Bearbeitung, '2' = beendet, '0' = Abbruch!");
					int eingabe = einlesen_Zahl(kategorie, �nderung);

					if (eingabe == 1) {
						neuerStatus = "in Bearbeitung";
					}
					if (eingabe == 2) {
						neuerStatus = "beendet";
					}

					if (eingabe == 0) {
					}

					// Jede andere Eingabe f�hrt zu einer Fehlermeldung.
					if (eingabe > 2) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit nicht vorhanden!\n");
					}
				}

				// Eingangsdatum
				if (�nderung == 6) {

					neuesEingangsdatum = Datum_Eingabe(aktuellesEingangsdatum);
				}

				// Fertigstellungsdatum
				if (�nderung == 7) {

					neuesFertigstellungsdatum = Datum_Eingabe(aktuellesFertigstellungsdatum);
				}

				// Bearbeitung abschlie�en
				if (�nderung == 8) {
					bearbeitungsVorgang = false;

					if (neuerStatus.equals("in Bearbeitung")) {

						/*
						 * Wenn der Status des Handwerkerauftrags 'in
						 * Bearbeitung' ist, dann wird f�r jede Wohnung in der
						 * ArrayList mit den Wohnungen �berpr�ft, welche Wohnung
						 * den Handwerkerautrag (die Auftrags-ID) erh�lt.
						 */

						for (Wohnung flat : MenuManager.getFlatList()) {
							if (neueWohnungsID == flat.getWohnungsID()) {
								flat.getHandwerkerauftrag().setAuftragsID(neueAuftragsID);

							}
						}

						/*
						 * Au�erdem werden nach dem Herausfinden, welcher
						 * Handwerkerautrag so eben bearbeitet wurde, die
						 * einzelnen ver�nderten Attribute nun ge�ndert.
						 */
						for (Handwerkerauftrag repair : MenuManager.getRepairList()) {
							if (zu_bearbeitenden_handwerkerauftrag.equals(repair.getAuftragsID())) {
								repair.setAuftragsID(neueAuftragsID);
								repair.setWohnungsID(neueWohnungsID);
								repair.setMitarbeiterID(neueMitarbeiterID);
								repair.setM�ngelbeschreibung(neueM�ngelbeschreibung);
								repair.setStatus(neuerStatus);
								repair.setEingangsdatum(neuesEingangsdatum);
								repair.setFertigstellungsDatum(neuesFertigstellungsdatum);
							}
						}
					}

					if (neuerStatus.equals("beendet")) {

<<<<<<< HEAD
                        /*
                         *  Da der Auftrag abgeschlossen ist, wird er der Liste
                         * der abgeschlossenen Auftr�ge hinzugef�gt.
                         */
                        MenuManager.getAbgeschlosseneHandwerkerauftr�ge().add(new Handwerkerauftrag(neueAuftragsID, neueWohnungsID, +neueMitarbeiterID, neueM�ngelbeschreibung, neuerStatus, neuesEingangsdatum, aktuellesFertigstellungsdatum));
                        /*
                         * Auderdem wird der Handwerkerautrag aus der Liste der
                         * aktiven Auftr�ge entfernt
                         */
                        Iterator<Handwerkerauftrag> iter = MenuManager.getRepairList().iterator();
=======
						/*
						 * Da der Auftrag abgeschlossen ist, wird er der Liste
						 * der abgeschlossenen Auftr�ge hinzugef�gt.
						 */
						MenuManager.abgeschlosseneHandwerkerauftr�ge.add(new Handwerkerauftrag(neueAuftragsID,
								neueWohnungsID, +neueMitarbeiterID, neueM�ngelbeschreibung, neuerStatus,
								neuesEingangsdatum, aktuellesFertigstellungsdatum));
						/*
						 * Auderdem wird der Handwerkerautrag aus der Liste der
						 * aktiven Auftr�ge entfernt
						 */
						Iterator<Handwerkerauftrag> iter = MenuManager.repairList.iterator();

						while (iter.hasNext()) {
							Handwerkerauftrag str = iter.next();

							if (str.getAuftragsID().equals(zu_bearbeitenden_handwerkerauftrag)) {
								iter.remove();
>>>>>>> branch 'master' of https://github.com/FThwr/Mietverwaltung

							}
						}
						/*
						 * Der Handwerkerauftrag wir aus ihm zugeordneten
						 * Wohnung entfernt
						 */
						for (Wohnung flat : MenuManager.getFlatList()) {
							if (aktuelleWohnungsID == flat.getWohnungsID()) {
								flat.getHandwerkerauftrag().setAuftragsID("");
							}
						}
					}
				}
				// Eingabe > 8
				if (�nderung > 8) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit nicht vorhanden!\n");
				}
			} catch (InputMismatchException e) {
				System.out.println(
						"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
			}
		}
	}

	/**
	 * Methode zur Auswahl eines bereits existierend Attributs durch Vorschlag
	 * jedes einzelnen Elements in einer ArrayList
	 *
	 * @param �nderung
	 *            = Z�hler des Attributs -> Bestimmung, welcher Fall eintritt
	 *            (ob eine Wohnung, etc. bearbeitet wird)
	 */

	private void JComboBox_optimierte_Auswahl(final int �nderung) {
		HandwerkerauftragBearbeitenAction.window = false;
		HandwerkerauftragBearbeitenAction.neue_wohnung = -100;
		HandwerkerauftragBearbeitenAction.neue_mitarbeiterID = -100;
		JFrame meinRahmen = new JFrame();

		meinRahmen.setSize(250, 250);
		JPanel meinPanel = new JPanel();
		meinRahmen.setLocationRelativeTo(null);

		JComboBox combo2 = new JComboBox();

		if (�nderung == -99) {
			meinRahmen.setTitle("Handwerkerauftrag ID");
			JLabel frage = new JLabel("Welchen Handwerkerauftrag m�chten Sie bearbeiten?");
			meinPanel.add(frage);
			for (Handwerkerauftrag repair : MenuManager.repairList) {
				combo2.addItem(repair.getAuftragsID());
			}
		}

		if (�nderung == 2) {
			meinRahmen.setTitle("Wohnungsnummer");
			JLabel frage = new JLabel("Welche Wohnung m�chten Sie ausw�hlen?");
			meinPanel.add(frage);
			for (Wohnung flat : MenuManager.flatList) {
				if (flat.getHandwerkerauftrag().getAuftragsID().equals("")) {
					combo2.addItem(flat.getWohnungsID());
				}
			}
		}

<<<<<<< HEAD
        if (�nderung == -99) {
            meinRahmen.setTitle("Handwerkerauftrag ID");
            JLabel frage = new JLabel("Welchen Handwerkerauftrag m�chten Sie bearbeiten?");
            meinPanel.add(frage);
            for (Handwerkerauftrag repair : MenuManager.getRepairList()) {
                combo2.addItem(repair.getAuftragsID());
            }
        }
=======
		if (�nderung == 3) {
			meinRahmen.setTitle("Mitarbeiter-ID");
			JLabel frage = new JLabel("Welchen Mitarbeiter (ID) m�chten Sie ausw�hlen?");
			meinPanel.add(frage);
			for (Handwerkerauftrag repair : MenuManager.repairList) {
				combo2.addItem(repair.getAuftragsID());
			}
		}
>>>>>>> branch 'master' of https://github.com/FThwr/Mietverwaltung

<<<<<<< HEAD
        if (�nderung == 2) {
            meinRahmen.setTitle("Wohnungsnummer");
            JLabel frage = new JLabel("Welche Wohnung m�chten Sie ausw�hlen?");
            meinPanel.add(frage);
            for (Wohnung flat : MenuManager.getFlatList()) {
                if (flat.getHandwerkerauftrag().getAuftragsID().equals("")) {
                    combo2.addItem(flat.getWohnungsID());
                }
            }
        }
=======
		meinRahmen.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				HandwerkerauftragBearbeitenAction.window = true;
			}
		});
>>>>>>> branch 'master' of https://github.com/FThwr/Mietverwaltung

<<<<<<< HEAD
        if (�nderung == 3) {
            meinRahmen.setTitle("Mitarbeiter-ID");
            JLabel frage = new JLabel("Welchen Mitarbeiter (ID) m�chten Sie ausw�hlen?");
            meinPanel.add(frage);
            for (Handwerkerauftrag repair : MenuManager.getRepairList()) {
                combo2.addItem(repair.getAuftragsID());
            }
        }
=======
		ActionListener cbActionListener = new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				if (�nderung == -99) {
					HandwerkerauftragBearbeitenAction.bearbeitungsAuswahl_handwerkerauftragID = (String) combo2
							.getSelectedItem();
				}
				if (�nderung == 2) {
					HandwerkerauftragBearbeitenAction.neue_wohnung = (int) combo2.getSelectedItem();
				}
				if (�nderung == 3) {
					HandwerkerauftragBearbeitenAction.neue_mitarbeiterID = (int) combo2.getSelectedItem();
				}
>>>>>>> branch 'master' of https://github.com/FThwr/Mietverwaltung

			}

		};
		meinPanel.add(combo2);
		meinRahmen.add(meinPanel, BorderLayout.SOUTH);
		meinRahmen.pack();
		meinRahmen.setVisible(true);
		while (HandwerkerauftragBearbeitenAction.window == false) {
			combo2.addActionListener(cbActionListener);
		}

	}

	/**
	 * Methode zum Anpassen der L�nge des Attributes (au�er Datum) bei der
	 * Ausgabe auf der Konsole.
	 * 
	 * @param wort
	 *            = mitgegebenes Attribut
	 * @return das Attribut mit den anschlie�enden Leerzeichen
	 */
	private String l�nge_anpassen(String wort) {

		if (wort.length() < 50) {
			while (wort.length() < 50) {
				wort = wort + " ";
			}
		}
		return wort;
	}

<<<<<<< HEAD
    /**
     * Methode zum Anpassen der L�nge des Attributes (au�er Datum) bei der Ausgabe auf der Konsole.
     *
     * @param wort
     *            = mitgegebenes Attribut
     * @return das Attribut mit den anschlie�enden Leerzeichen
     */
    private String l�nge_anpassen(String wort) {
=======
	/**
	 * Methode zum Einlesen eines Wortes oder Satzes vom Nutzer
	 *
	 * @param auswahl
	 *            = welches "�nderungsfeld" der Nutzer betreten hat (Name des
	 *            Index des Arrays)
	 * @param z�hler
	 *            = welches "�nderungsfeld" der Nutzer betreten hat (Nummer des
	 *            Index des Arrays)
	 * @return das eingelesene Wort
	 */
	private String einlesen_Wort(final String[] auswahl, final int z�hler) {
		System.out.println("Erstellen: " + auswahl[z�hler - 1]);
		Scanner s = new Scanner(System.in);
		String wort = s.nextLine();
		return wort;
	}
>>>>>>> branch 'master' of https://github.com/FThwr/Mietverwaltung

	/**
	 * Methode zum Einlesen einer Zahl vom Nutzer
	 *
	 * @param auswahl
	 *            = welches "�nderungsfeld" der Nutzer betreten hat (Name des
	 *            Index des Arrays)
	 * @param z�hler
	 *            = welches "�nderungsfeld" der Nutzer betreten hat (Nummer des
	 *            Index des Arrays)
	 * @return die eingelesene Zahl
	 */
	private int einlesen_Zahl(final String[] auswahl, final int z�hler) {

		Scanner s = new Scanner(System.in);
		int zahl = -100;
		while (zahl == -100) {
			try {

				do {
					System.out.println("Geben Sie ein: " + auswahl[z�hler - 1]);
					zahl = s.nextInt();
					if (zahl < 0) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nNur positive Zahlen erlaubt!");
					}
				} while (zahl < 0);
			} catch (InputMismatchException e) {

				String eingabeString = s.nextLine();
				if (eingabeString.equals("Januar")) {
					zahl = 1;
				} else if (eingabeString.equals("Februar")) {
					zahl = 2;
				} else if (eingabeString.equals("M�rz")) {
					zahl = 3;
				} else if (eingabeString.equals("April")) {
					zahl = 4;
				} else if (eingabeString.equals("Mai")) {
					zahl = 5;
				} else if (eingabeString.equals("Juni")) {
					zahl = 6;
				} else if (eingabeString.equals("Juli")) {
					zahl = 7;
				} else if (eingabeString.equals("August")) {
					zahl = 8;
				} else if (eingabeString.equals("September")) {
					zahl = 9;
				} else if (eingabeString.equals("Oktober")) {
					zahl = 10;
				} else if (eingabeString.equals("November")) {
					zahl = 11;
				} else if (eingabeString.equals("Dezember")) {
					zahl = 12;
				} else {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
				}

			}
		}
		return zahl;
	}

	/**
	 * Methode zur Eingabe des Datums
	 *
	 * @param aktuellesDatum,
	 *            was der Handwerkerauftrag zu dem Zeitpunkt noch benutzt
	 * @return das neue Datum, welches weiterverwendet werden soll
	 */
	public Datum Datum_Eingabe(final Datum aktuellesDatum) {

		System.out
				.println("Eingabe des Eingangdatums: W�hlen Sie bei einem Wert '0' und das Datum bleibt unver�ndert!");
		String[] auswahl = { "Jahr", "Monat", "Tag" };

		Datum neuesDatum = null;
		boolean datumsEingabeErfolgreich = false;

		int z�hler = 1;
		int jahr = einlesen_Zahl(auswahl, z�hler);

		z�hler = 2;
		int monat = 0;
		do {
			monat = einlesen_Zahl(auswahl, z�hler);
			if (monat > 12) {
				System.out.println(
						"\n------------------------------- Fehler! ------------------------------- \nMonat darf nicht h�her als 12 sein!");
			}
		} while (monat > 12);

		z�hler = 3;
		int tag = 0;
		do {
			tag = einlesen_Zahl(auswahl, z�hler);
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
		 * Wenn einer der Werte versucht wird zu �berspringen/ auszulassen, dann
		 * bleibt es beim unver�nderten Datum.
		 */
		if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
			neuesDatum = aktuellesDatum;
		} else {
			neuesDatum = new Datum(tag, monat, jahr);
		}
		return neuesDatum;
	}

	/**
	 * Methode zum Anpassen der L�nge des Datums bei der Ausgabe auf der
	 * Konsole.
	 */
	private String l�nge_anpassen_Datum(final Datum a_GD) {

		String leerzeichen = "";
		int abzug = 0;

		if (a_GD != null) {

			String jahr = "" + a_GD.getJahr();
			int l_J = jahr.length();

			String monat = "" + a_GD.getMonat();
			int l_M = monat.length();

			String tag = "" + a_GD.getTag();
			int l_T = tag.length();

			abzug = l_J + l_M + l_T + 2; // +2 f�r die Punkte zwischen den
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

}