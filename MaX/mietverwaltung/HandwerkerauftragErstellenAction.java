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
		 * Variable zum Öffnen des richtigen JFrames und zur Auswahl des zu
		 * bearbeitenden Attributs.
		 */
		int änderung = 0;

		boolean erstellVorgang = true;

		String auftragsID = "";
		int wohnungsID = -100;
		int mitarbeiterID = -100;
		String mängelbeschreibung = "";
		String status = "";
		Datum eingangsdatum = null;

		// Fertigstellungsdatum so gewählt, da Datum ungewiss beim Erstellen
		Datum fertigstellungsDatum = new Datum(0, 0, 0);

		String[] kategorie = { "Auftrags ID ", "Wohnungs ID", "Mitarbeiter ID", "Mängelbeschreibung", "Status",
				"Eingangsdatum"};

		/*
		 * Solange der Erstellvorgang nicht beendet ist, wird immer eine
		 * Übersicht über den erstellten Wert ausgegeben. Es wird pro Durchlauf
		 * immer 1 Attribut ausgewählt, welches man draufhin verändern kann.
		 */
		while (erstellVorgang == true) {
			
			System.out.println("...............................Wählen Sie die zu erstellende Eigenschaft aus...............................!  ");
			System.out.println("1. Auftrags ID:          " + auftragsID);
			System.out.println("2. Wohnungs ID:          " + wohnungsID);
			System.out.println("3. Mitarbeiter ID:       " + mitarbeiterID);
			System.out.println("4. Mängelbeschreibung:   " + mängelbeschreibung);
			System.out.println("5. Status:               " + status);
			System.out.println("6. Eingangsdatum:        " + eingangsdatum);
			System.out.println("   Fertigstellungsdatum: " + fertigstellungsDatum);
			System.out.println("7. Erstellen abschließen");
			System.out.println("0. Abbruch");
			System.out.println("");

			Scanner t = new Scanner(System.in);
			

			/*
			 * Die try-catch Klammer existiert für nicht erwünschte Eingaben wie
			 * Zeichen, wo Zahlen erwartet werden.
			 */
			try {
				änderung = t.nextInt();

				// Abbruch
				if (änderung == 0) {
					System.out.println(
							"-------------------------------Erstellvorgang wurde abgebrochen!-------------------------------\n");
					erstellVorgang = false;
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
							auftragsID = eingabe;
						}
					}
				}

				// Wohnung
				if (änderung == 2) {

					auswahl_AuftragsID_Wohnung_MitarbeiterID(änderung);
					wohnungsID = such_wohnung;
				}

				// Mitarbeiter
				if (änderung == 3) {

					auswahl_AuftragsID_Wohnung_MitarbeiterID(änderung);
					mitarbeiterID = such_mitarbeiterID;
				}

				// Mängelbeschreibung
				if (änderung == 4) {
					String eingabe = einlesen_Wort(kategorie, änderung);
					if (eingabe.equals("" + 0)) {
					} else {
						mängelbeschreibung = eingabe;
					}
				}

				// Status
				if (änderung == 5) {
					System.out.println(
							"Geben Sie die Zahl vom gewünschten Status aus: '1' = in Bearbeitung, '2' = beendet, '0' = Abbruch!");
					int eingabe = einlesen_Zahl(kategorie, änderung);

					if (eingabe == 1) {
						status = "in Bearbeitung";
					}
					if (eingabe == 2) {
						status = "beendet";
					}

					if (eingabe == 0) {
					}

					// Jede andere Eingabe führt zu einer Fehlermeldung.
					else {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit nicht vorhanden!\n");
					}
				}

				// Eingangsdatum
				if (änderung == 6) {

					eingangsdatum = Datum_Eingabe(eingangsdatum);
				}

				// Bearbeitung abschließen
				if (änderung == 7) {
					System.out.println("Handwerkerauftrag wurde erfolgreich angelegt!");
					erstellVorgang = false;
					
					for (Wohnung flat : flatList) {
						if (wohnungsID == flat.getWohnungsID()) {
							flat.setHandwerkerauftrag(new Handwerkerauftrag(auftragsID));
						}
					}

					/*
					 * Der Erstellvorgang ist beendet und der Liste der aktiven
					 * Handwerkeraufträgen wird ein neuer Auftrag hinzugefügt.
					 */
					repairList.add(new Handwerkerauftrag(auftragsID, wohnungsID, mitarbeiterID, mängelbeschreibung,
							status, eingangsdatum, fertigstellungsDatum));

				}
				//Eingabe > 7
				else {
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
		such_mitarbeiterID = -100;
		such_wohnung = -100;
		JFrame meinRahmen = new JFrame();

		meinRahmen.setSize(250, 250);
		JPanel meinPanel = new JPanel();
		meinRahmen.setLocationRelativeTo(null);

		JComboBox combo2 = new JComboBox();
		combo2.addItem("" + 0);

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
		System.out.println("Erstellen: " + auswahl[zähler - 1]);
		Scanner s = new Scanner(System.in);
		String wort = s.nextLine();
		return wort;
	}
}