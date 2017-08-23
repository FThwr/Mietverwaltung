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

public class MietvertragErstellenAction extends MenueManager implements Action, Serializable {

	static int such_wohnung;
	static int such_mieterID;
	static int such_mitarbeiterID;
	static boolean window = false;

	@Override
	public void action() throws IOException {

		System.out.println(
				"________________________________________ Mietvertrag erstellen ________________________________________");

		/*
		 * Variable zum �ffnen des richtigen JFrames und zur Auswahl des zu
		 * bearbeitenden Attributs.
		 */
		int �nderung = 0;

		boolean erstellVorgang = true;

		String mietvertragID = "-";
		int wohnungsID = -100;
		int kundenID = -100;
		int mitarbeiterID = -100;
		Datum mietbeginn = null;
		Datum mietende = null;
		String status = "aktiv";

		/*
		 * Solange der Erstellvorgang nicht beendet ist, wird immer eine
		 * �bersicht �ber den erstellten Wert ausgegeben. Es wird pro Durchlauf
		 * immer 1 Attribut ausgew�hlt, welches man draufhin ver�ndern kann.
		 */
		while (erstellVorgang == true) {

			String[] kategorie = { "Mietvertrags-ID", "Wohnungs-ID", "Kunden-ID", "Mitarbeiter-ID", "Mietbeginn",
					"Mietende" };

			System.out.println(
					"W�hlen Sie einen zu bearbeitenenden Wert!\nFolgender Mietvertrag wird aktuell erstellt: ");
			System.out.println("1. Mietvertrag-ID:                        " + mietvertragID);
			System.out.println("2. Wohnungs-ID:                           " + wohnungsID);
			System.out.println("3. Kunden-ID:                             " + kundenID);
			System.out.println("4. Mitarbeiter-ID:                        " + mitarbeiterID);
			System.out.println("5. Mietbeginn:                            " + mietbeginn);
			System.out.println("6. Mietende:                              " + mietende);
			System.out.println("   Status:                                " + status);
			System.out.println("7. Erstellen abschlie�en");
			System.out.println("0. Abbruch");

			Scanner s = new Scanner(System.in);

			/*
			 * Die try-catch Klammer existiert f�r nicht erw�nschte Eingaben wie
			 * Zeichen, wo Zahlen erwartet werden.
			 */
			try {
				�nderung = s.nextInt();

				// Abbruch
				if (�nderung == 0) {
					System.out.println(
							"-------------------------------Erstellvorgang wurde abgebrochen!-------------------------------\n");
					erstellVorgang = false;
				}

				// Mietvertrag-ID
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
						for (Mietvertrag contract : contractList) {
							if (eingabe.equals(contract.getMietvertragID())) {
								vorhanden = 1;
							}
						}

						/*
						 * F�r jedes Element in der Handwerkerliste der
						 * abgeschlossenen Auftr�ge wird geguckt, ob die
						 * eingegebende ID mit einer bereits existierenden
						 * �bereinstimmt.
						 */
						for (Mietvertrag abgeschlossenerMietvertrag : beendeteMietvertr�ge) {
							if (eingabe.equals(abgeschlossenerMietvertrag.getMietvertragID())) {
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
							mietvertragID = eingabe;
						}
					}
				}

				// Wohnungsnummer
				if (�nderung == 2) {
					auswahl_AuftragsID_Wohnung_MitarbeiterID(�nderung);
					wohnungsID = such_wohnung;
				}

				// Mieter-ID
				if (�nderung == 3) {
					auswahl_AuftragsID_Wohnung_MitarbeiterID(�nderung);
					kundenID = such_mieterID;
				}

				// Mitarbeiter-ID
				if (�nderung == 4) {
					auswahl_AuftragsID_Wohnung_MitarbeiterID(�nderung);
					mitarbeiterID = such_mitarbeiterID;
				}

				// Mietbeginn
				if (�nderung == 5) {

					mietbeginn = Datum_Eingabe(mietbeginn);
				}

				// Mietende
				if (�nderung == 6) {

					mietende = Datum_Eingabe(mietende);
				}

				// Erstellen abschlie�en
				if (�nderung == 7) {
					erstellVorgang = false;
					
					

					contractList.add(new Mietvertrag(mietvertragID, wohnungsID, kundenID, mitarbeiterID, mietbeginn,
							mietende, status));
					
					for (Wohnung flat : flatList) {
						int belegt = 0;
						for (Mietvertrag contract : contractList) {
							if (contract.getWohnungsID() == flat.getWohnungsID() && flat.getWohnungsID() != -100
									&& contract.getWohnungsID()!= -100) {
								belegt = 1;
							}
						}
						if (belegt == 1) {
							flat.setStatus("vermietet");
						} else {
							flat.setStatus("frei");
						}
					}

				}
				
				// Eingabe > 11
				if (�nderung > 11) {
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
	private void auswahl_AuftragsID_Wohnung_MitarbeiterID(int �nderung) {
		window = false;
		such_mitarbeiterID = -100;
		such_mieterID = -100;
		such_wohnung = -100;
		JFrame meinRahmen = new JFrame();

		meinRahmen.setSize(250, 250);
		JPanel meinPanel = new JPanel();
		meinRahmen.setLocationRelativeTo(null);

		JComboBox combo2 = new JComboBox();

		if (�nderung == 2) {
			meinRahmen.setTitle("Wohnungsnummer");
			JLabel frage = new JLabel("Welche Wohnung m�chten Sie ausw�hlen?");
			meinPanel.add(frage);
			for (Wohnung flat : flatList) {
				if (flat.getStatus().equals("frei"))
				combo2.addItem(flat.getWohnungsID());
			}
		}

		if (�nderung == 3) {
			meinRahmen.setTitle("Mieter-ID");
			JLabel frage = new JLabel("Welchen Mieter (ID) m�chten Sie ausw�hlen?");
			meinPanel.add(frage);
			for (Mieter owner : ownerList) {
				combo2.addItem(owner.getKundenID());
			}
		}

		if (�nderung == 4) {
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
					such_mieterID = (int) combo2.getSelectedItem();
				}
				if (�nderung == 4) {
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

	private int einlesen_Zahl(String[] auswahl, int z�hler) {
		System.out.println("Erstellen: " + auswahl[z�hler - 1]);
		Scanner s = new Scanner(System.in);
		int zahl = -100;
		// wenn die Eingabe korrekt ist (ohne Buchstaben), dann
		// wird die Eingabe �bernommen, sonst wird eine Fehlermeldung ausgegeben
		try {
			zahl = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.println(
					"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
		}
		return zahl;
	}

	private String einlesen_Wort(String[] auswahl, int z�hler) {
		System.out.println("Erstellen: " + auswahl[z�hler - 1]);
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
