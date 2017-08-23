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
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HandwerkerauftragErstellenAction extends MenueManager implements Action, Serializable {

	static int such_wohnung;
	static int such_mitarbeiterID;
	static boolean window = false;

	@Override
	public void action() throws IOException {

		System.out.println(
				"________________________________________ Handwerkerauftrag erstellen ________________________________________");

		/*
		 * Variable zum �ffnen des richtigen JFrames und zur Auswahl des zu
		 * bearbeitenden Attributs.
		 */
		int �nderung = 0;

		boolean erstellVorgang = true;

		String auftragsID = "";
		int wohnungsID = -100;
		int mitarbeiterID = -100;
		String m�ngelbeschreibung = "";
		String status = "";
		Datum eingangsdatum = null;

		// Fertigstellungsdatum so gew�hlt, da Datum ungewiss beim Erstellen
		Datum fertigstellungsDatum = new Datum(0, 0, 0);

		String[] kategorie = { "Auftrags ID ", "Wohnungs ID", "Mitarbeiter ID", "M�ngelbeschreibung", "Status",
				"Eingangsdatum"};

		/*
		 * Solange der Erstellvorgang nicht beendet ist, wird immer eine
		 * �bersicht �ber den erstellten Wert ausgegeben. Es wird pro Durchlauf
		 * immer 1 Attribut ausgew�hlt, welches man draufhin ver�ndern kann.
		 */
		while (erstellVorgang == true) {
			
			System.out.println("...............................W�hlen Sie die zu erstellende Eigenschaft aus...............................!  ");
			System.out.println("1. Auftrags ID:          " + auftragsID);
			System.out.println("2. Wohnungs ID:          " + wohnungsID);
			System.out.println("3. Mitarbeiter ID:       " + mitarbeiterID);
			System.out.println("4. M�ngelbeschreibung:   " + m�ngelbeschreibung);
			System.out.println("5. Status:               " + status);
			System.out.println("6. Eingangsdatum:        " + eingangsdatum);
			System.out.println("   Fertigstellungsdatum: " + fertigstellungsDatum);
			System.out.println("7. Erstellen abschlie�en");
			System.out.println("0. Abbruch");
			System.out.println("");

			Scanner t = new Scanner(System.in);
			

			/*
			 * Die try-catch Klammer existiert f�r nicht erw�nschte Eingaben wie
			 * Zeichen, wo Zahlen erwartet werden.
			 */
			try {
				�nderung = t.nextInt();

				// Abbruch
				if (�nderung == 0) {
					System.out.println(
							"-------------------------------Erstellvorgang wurde abgebrochen!-------------------------------\n");
					erstellVorgang = false;
				}

				// Auftrags-ID
				if (�nderung == 1) {

					String eingabe = einlesen_Wort(kategorie, �nderung);
					if (eingabe.equals("" + 0)) {
					} else {

						int vorhanden = 0;
						/*
						 * F�r jedes Element in der Handwerkerliste der aktiven
						 * Auftr�ge wird geguckt, ob die eingegebende ID mit
						 * einer bereits existierenden �bereinstimmt.
						 */
						for (Handwerkerauftrag repair : repairList) {
							if (eingabe.equals(repair.getAuftragsID())) {
								vorhanden = 1;
							}
						}

						/*
						 * F�r jedes Element in der Handwerkerliste der
						 * abgeschlossenen Auftr�ge wird geguckt, ob die
						 * eingegebende ID mit einer bereits existierenden
						 * �bereinstimmt.
						 */
						for (Handwerkerauftrag auftrag : abgeschlosseneHandwerkerauftr�ge) {
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
							auftragsID = eingabe;
						}
					}
				}

				// Wohnung
				if (�nderung == 2) {

					auswahl_AuftragsID_Wohnung_MitarbeiterID(�nderung);
					wohnungsID = such_wohnung;
				}

				// Mitarbeiter
				if (�nderung == 3) {

					auswahl_AuftragsID_Wohnung_MitarbeiterID(�nderung);
					mitarbeiterID = such_mitarbeiterID;
				}

				// M�ngelbeschreibung
				if (�nderung == 4) {
					String eingabe = einlesen_Wort(kategorie, �nderung);
					if (eingabe.equals("" + 0)) {
					} else {
						m�ngelbeschreibung = eingabe;
					}
				}

				// Status
				if (�nderung == 5) {
					System.out.println(
							"Geben Sie die Zahl vom gew�nschten Status aus: '1' = in Bearbeitung, '2' = beendet, '0' = Abbruch!");
					int eingabe = einlesen_Zahl(kategorie, �nderung);

					if (eingabe == 1) {
						status = "in Bearbeitung";
					}
					if (eingabe == 2) {
						status = "beendet";
					}

					if (eingabe == 0) {
					}

					// Jede andere Eingabe f�hrt zu einer Fehlermeldung.
					else {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit nicht vorhanden!\n");
					}
				}

				// Eingangsdatum
				if (�nderung == 6) {

					eingangsdatum = Datum_Eingabe(eingangsdatum);
				}

				// Bearbeitung abschlie�en
				if (�nderung == 7) {
					System.out.println("Handwerkerauftrag wurde erfolgreich angelegt!");
					erstellVorgang = false;
					
					for (Wohnung flat : flatList) {
						if (wohnungsID == flat.getWohnungsID()) {
							flat.setHandwerkerauftrag(new Handwerkerauftrag(auftragsID));
						}
					}

					/*
					 * Der Erstellvorgang ist beendet und der Liste der aktiven
					 * Handwerkerauftr�gen wird ein neuer Auftrag hinzugef�gt.
					 */
					repairList.add(new Handwerkerauftrag(auftragsID, wohnungsID, mitarbeiterID, m�ngelbeschreibung,
							status, eingangsdatum, fertigstellungsDatum));

				}
				//Eingabe > 7
				else {
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
	 * Methode zur Eingabe des Datums
	 * 
	 * @param aktuellesDatum,
	 *            was der Handwerkerauftrag zu dem Zeitpunkt noch benutzt
	 * @return das neue Datum, welches weiterverwendet werden soll
	 */
	public Datum Datum_Eingabe(Datum aktuellesDatum) {

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
	 * Methode zur Auswahl eines bereits existierend Attributs durch Vorschlag
	 * jedes einzelnen Elements in einer ArrayList
	 * 
	 * @param �nderung
	 *            = Z�hler des Attributs -> Bestimmung, welcher Fall eintritt
	 *            (ob eine Wohnung, etc. bearbeitet wird)
	 */
	private void auswahl_AuftragsID_Wohnung_MitarbeiterID(int �nderung) {
		window = false;
		such_mitarbeiterID = -100;
		such_wohnung = -100;
		JFrame meinRahmen = new JFrame();

		meinRahmen.setSize(250, 250);
		JPanel meinPanel = new JPanel();
		meinRahmen.setLocationRelativeTo(null);

		JComboBox combo2 = new JComboBox();
		combo2.addItem("" + 0);

		if (�nderung == 2) {
			meinRahmen.setTitle("Wohnungsnummer");
			JLabel frage = new JLabel("Welche Wohnung m�chten Sie ausw�hlen?");
			meinPanel.add(frage);
			for (Wohnung flat : flatList) {
				combo2.addItem(flat.getWohnungsID());
			}
		}

		if (�nderung == 3) {
			meinRahmen.setTitle("Mitarbeiter-ID");
			JLabel frage = new JLabel("Welchen Mitarbeiter (ID) m�chten Sie ausw�hlen?");
			meinPanel.add(frage);
			for (Mitarbeiter worker : workerList) {
				combo2.addItem(worker.getMitarbeiterID());
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
				if (�nderung == 2) {
					such_wohnung = (int) combo2.getSelectedItem();
				}
				if (�nderung == 3) {
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

	private int einlesen_Zahl(String[] auswahl, int z�hler) {
		Scanner s = new Scanner(System.in);
		int zahl = -100;
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
			System.out.println(
					"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
		}
		return zahl;
	}

	private String einlesen_Wort(String[] auswahl, int z�hler) {
		System.out.println("Erstellen: " + auswahl[z�hler - 1]);
		Scanner s = new Scanner(System.in);
		String wort = s.nextLine();
		return wort;
	}
}