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
		 * Variable zum Öffnen des richtigen JFrames und zur Auswahl des zu
		 * bearbeitenden Attributs.
		 */
		int änderung = 0;

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
		 * Übersicht über den erstellten Wert ausgegeben. Es wird pro Durchlauf
		 * immer 1 Attribut ausgewählt, welches man draufhin verändern kann.
		 */
		while (erstellVorgang == true) {

			String[] kategorie = { "Mietvertrags-ID", "Wohnungs-ID", "Kunden-ID", "Mitarbeiter-ID", "Mietbeginn",
					"Mietende" };

			System.out.println(
					"Wählen Sie einen zu bearbeitenenden Wert!\nFolgender Mietvertrag wird aktuell erstellt: ");
			System.out.println("1. Mietvertrag-ID:                        " + mietvertragID);
			System.out.println("2. Wohnungs-ID:                           " + wohnungsID);
			System.out.println("3. Kunden-ID:                             " + kundenID);
			System.out.println("4. Mitarbeiter-ID:                        " + mitarbeiterID);
			System.out.println("5. Mietbeginn:                            " + mietbeginn);
			System.out.println("6. Mietende:                              " + mietende);
			System.out.println("   Status:                                " + status);
			System.out.println("7. Erstellen abschließen");
			System.out.println("0. Abbruch");

			Scanner s = new Scanner(System.in);

			/*
			 * Die try-catch Klammer existiert für nicht erwünschte Eingaben wie
			 * Zeichen, wo Zahlen erwartet werden.
			 */
			try {
				änderung = s.nextInt();

				// Abbruch
				if (änderung == 0) {
					System.out.println(
							"-------------------------------Erstellvorgang wurde abgebrochen!-------------------------------\n");
					erstellVorgang = false;
				}

				// Mietvertrag-ID
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
						for (Mietvertrag contract : contractList) {
							if (eingabe.equals(contract.getMietvertragID())) {
								vorhanden = 1;
							}
						}

						/*
						 * Für jedes Element in der Handwerkerliste der
						 * abgeschlossenen Aufträge wird geguckt, ob die
						 * eingegebende ID mit einer bereits existierenden
						 * übereinstimmt.
						 */
						for (Mietvertrag abgeschlossenerMietvertrag : beendeteMietverträge) {
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
				if (änderung == 2) {
					auswahl_AuftragsID_Wohnung_MitarbeiterID(änderung);
					wohnungsID = such_wohnung;
				}

				// Mieter-ID
				if (änderung == 3) {
					auswahl_AuftragsID_Wohnung_MitarbeiterID(änderung);
					kundenID = such_mieterID;
				}

				// Mitarbeiter-ID
				if (änderung == 4) {
					auswahl_AuftragsID_Wohnung_MitarbeiterID(änderung);
					mitarbeiterID = such_mitarbeiterID;
				}

				// Mietbeginn
				if (änderung == 5) {

					mietbeginn = Datum_Eingabe(mietbeginn);
				}

				// Mietende
				if (änderung == 6) {

					mietende = Datum_Eingabe(mietende);
				}

				// Erstellen abschließen
				if (änderung == 7) {
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
				if (änderung > 11) {
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
		such_mieterID = -100;
		such_wohnung = -100;
		JFrame meinRahmen = new JFrame();

		meinRahmen.setSize(250, 250);
		JPanel meinPanel = new JPanel();
		meinRahmen.setLocationRelativeTo(null);

		JComboBox combo2 = new JComboBox();

		if (änderung == 2) {
			meinRahmen.setTitle("Wohnungsnummer");
			JLabel frage = new JLabel("Welche Wohnung möchten Sie auswählen?");
			meinPanel.add(frage);
			for (Wohnung flat : flatList) {
				if (flat.getStatus().equals("frei"))
				combo2.addItem(flat.getWohnungsID());
			}
		}

		if (änderung == 3) {
			meinRahmen.setTitle("Mieter-ID");
			JLabel frage = new JLabel("Welchen Mieter (ID) möchten Sie auswählen?");
			meinPanel.add(frage);
			for (Mieter owner : ownerList) {
				combo2.addItem(owner.getKundenID());
			}
		}

		if (änderung == 4) {
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
					such_mieterID = (int) combo2.getSelectedItem();
				}
				if (änderung == 4) {
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
