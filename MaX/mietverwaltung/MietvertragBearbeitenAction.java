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

public class MietvertragBearbeitenAction extends MenueManager implements Action, Serializable {

	static boolean close = false;
	static String bearbeitungsAuswahl_MietvertragID;
	static int such_MieterID;
	static int such_WohnungsID;
	static int such_Mitarbeiter;

	@Override
	public void action() throws IOException {

		System.out.println(
				"________________________________________ Mietvertrag bearbeiten ________________________________________");

		/*
		 * Variable zum �ffnen des richtigen JFrames und zur Auswahl des zu
		 * bearbeitenden Attributs.
		 */
		int �nderung = -99;

		// Ausgabe aller Mietvertrag-IDs zur einfacheren Auswahl
		auswahl_Mietvertrag_Wohnung_Kunde_Mitarbeiter(�nderung);

		// Variable enth�lt die ID des zu bearbeitenden Mietvertrags
		String zu_bearbeitenden_mietvertrag = bearbeitungsAuswahl_MietvertragID;

		boolean bearbeitungsVorgang = true;
		String[] kategorie = { "Mietvertrag-ID", "Wohnungs-ID", "Kunden-ID", "Mitarbeiter-ID", "Mietbeginn",
				"Mietende" };
		
		/*
		 * diese Variablen dienen sp�ter f�r eine tabellarische Ausgabe auf der
		 * Konsole
		 */
		String l�ngenAnpassung_mietvertragID = "";
		String l�ngenAnpassung_wohnungsID = "";
		String l�ngenAnpassung_kundenID = "";
		String l�ngenAnpassnung_mitarbeiterID = "";
		String l�ngenAnpassung_status = "";
		
		/*
		 * allgemeine Variablen alte = aktuelle Werte, neue = neue/ver�nderte
		 * Werte
		 */
		String aktuelleMietvertragsID = "";
		String neueMietvertragsID = "";

		int aktuelleWohnungsID = -100;
		int neueWohnungsID = -100;

		int aktuelleKundenID = -100;
		int neueKundenID = -100;

		int aktuelleMitarbeiterID = -100;
		int neueMitarbeiterID = -100;

		Datum aktuellerMietbeginn = null;
		Datum neuerMietbeginn = null;

		Datum aktuellesMietende = null;
		Datum neuesMietende = null;
		
		String aktuellerStatus = "";
		String neuerStatus = "";

		/*
		 * Variablen enthalten die Leerzeichen, die nach den Objekten (Daten)
		 * eingesetzt werden. Die L�ngen der einzelnen Komponenten der Objekte
		 * werden verwendet
		 */
		String MB_Leerzeichen = "";
		String ME_Leerzeichen = "";

		
		/*
		 * F�r jedes Element in der ArrayList 'contractList', welche alle aktiven
		 * Handwerkerauftr�ge beeinhaltet, wir zeurst das Objekt in der
		 * ArrayList gesucht, welche der eben ausgew�hlten Auftrags-ID
		 * entspricht. Es werden neue Variablen angelegt, welche die einzelnen
		 * Werte des Objekts beeinhalten.
		 */
		for (Mietvertrag contract : contractList) {
			if (zu_bearbeitenden_mietvertrag.equals(contract.getMietvertragID())) {

				aktuelleMietvertragsID = contract.getMietvertragID();
				neueMietvertragsID = aktuelleMietvertragsID;

				aktuelleWohnungsID = contract.getWohnungsID();
				neueWohnungsID = aktuelleWohnungsID;

				aktuelleKundenID = contract.getKundenID();
				neueKundenID = aktuelleKundenID;

				aktuelleMitarbeiterID = contract.getMitarbeiterID();
				neueMitarbeiterID = aktuelleMitarbeiterID;

				aktuellerMietbeginn = contract.getMietbeginn();
				neuerMietbeginn = aktuellerMietbeginn;

				aktuellesMietende = contract.getMietende();
				neuesMietende = aktuellesMietende;
				
				aktuellerStatus = contract.getStatus();
				neuerStatus = aktuellerStatus;

				/*
				 * Initialisierung der tabellarischen Variablen + Ausf�llung mit
				 * Leerzeichen (Umwandlung in die Tabelle)
				 */
				l�ngenAnpassung_mietvertragID = aktuelleMietvertragsID;
				l�ngenAnpassung_mietvertragID = l�nge_anpassen(l�ngenAnpassung_mietvertragID);

				l�ngenAnpassung_wohnungsID = "" + aktuelleWohnungsID;
				l�ngenAnpassung_wohnungsID = l�nge_anpassen(l�ngenAnpassung_wohnungsID);

				l�ngenAnpassung_kundenID = "" + aktuelleKundenID;
				l�ngenAnpassung_kundenID = l�nge_anpassen(l�ngenAnpassung_kundenID);

				l�ngenAnpassnung_mitarbeiterID = "" + aktuelleMitarbeiterID;
				l�ngenAnpassnung_mitarbeiterID = l�nge_anpassen(l�ngenAnpassnung_mitarbeiterID);
				
				l�ngenAnpassung_status = aktuellerStatus;
				l�ngenAnpassung_status = l�nge_anpassen(l�ngenAnpassung_status);

				MB_Leerzeichen = l�nge_anpassen_Datum(aktuellerMietbeginn);
				ME_Leerzeichen = l�nge_anpassen_Datum(aktuellesMietende);
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
						"............................... W�hlen Sie die zu bearbeitende Eigenschaft aus! ...............................");
				System.out.println("1. Mietvertrag-ID:       " + l�ngenAnpassung_mietvertragID
						+ "neue Mietvertrag-ID:       " + neueMietvertragsID);
				System.out.println("2. Wohnungs-ID:          " + l�ngenAnpassung_wohnungsID
						+ "neue Wohnungs-ID:          " + neueWohnungsID);
				System.out.println("3. Kunden-ID:            " + l�ngenAnpassung_kundenID
						+ "neue Kunden-ID:            " + neueKundenID);
				System.out.println("4. Mitarbeiter-ID:       " + l�ngenAnpassnung_mitarbeiterID
						+ "neue Mitarbeiter-ID:       " + neueMitarbeiterID);
				System.out.println("5. Mietbeginn:           " + aktuellerMietbeginn + MB_Leerzeichen
						+ "neuer Mietbeginn:          " + neuerMietbeginn);
				System.out.println("6. Mietende:             " + aktuellesMietende + ME_Leerzeichen
						+ "neues Mietende:            " + neuesMietende);
				System.out.println("7. Status:               " + l�ngenAnpassung_status 
						+ "neuer Status:              " + neuerStatus);
				System.out.println("8. Best�tigen");
				System.out.println("0. Abbruch");
				System.out.println("");

				Scanner t = new Scanner(System.in);

				try {
					�nderung = t.nextInt();

					if (�nderung == 0) {
						bearbeitungsVorgang = false;
					}
					if (�nderung == 1) {
						String eingabe = einlesen_Wort(kategorie, �nderung);
						if (eingabe.equals("" + 0)) {
							neueMietvertragsID = aktuelleMietvertragsID;
						} else {
							neueMietvertragsID = eingabe;
						}
					}
					if (�nderung == 2) {
						auswahl_Mietvertrag_Wohnung_Kunde_Mitarbeiter(�nderung);
						neueWohnungsID = such_WohnungsID;

					}
					if (�nderung == 3) {

						auswahl_Mietvertrag_Wohnung_Kunde_Mitarbeiter(�nderung);
						neueKundenID = such_MieterID;
					}
					if (�nderung == 4) {

						auswahl_Mietvertrag_Wohnung_Kunde_Mitarbeiter(�nderung);
						neueMitarbeiterID = such_Mitarbeiter;
					}
					if (�nderung == 5) {
						String[] auswahl = { "Tag", "Monat", "Jahr" };
						int z�hler = 1;
						int tag = einlesen_Zahl(auswahl, z�hler);
						z�hler = 2;
						int monat = einlesen_Zahl(auswahl, z�hler);
						z�hler = 3;
						int jahr = einlesen_Zahl(auswahl, z�hler);

						if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
							neuerMietbeginn = aktuellerMietbeginn;
						} else {
							neuerMietbeginn = new Datum(tag, monat, jahr);
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
							neuesMietende = aktuellesMietende;
						} else {
							neuesMietende = new Datum(tag, monat, jahr);
						}
					}
					if (�nderung == 7) {
						bearbeitungsVorgang = false;

						for (Mietvertrag contract : contractList) {
							if (zu_bearbeitenden_mietvertrag.equals(contract.getMietvertragID())) {
								contract.setMietvertragID(neueMietvertragsID);
								contract.setWohnungsID(neueWohnungsID);
								contract.setKundenID(neueKundenID);
								contract.setMitarbeiterID(neueMitarbeiterID);
								contract.setMietbeginn(neuerMietbeginn);
								contract.setMietende(neuesMietende);
							}
						}

						FileOutputStream fosMietvertrag = new FileOutputStream("mietvertr�ge.ser");
						ObjectOutputStream oosMietvertrag = new ObjectOutputStream(fosMietvertrag);
						oosMietvertrag.writeObject(contractList);
					}
				} catch (InputMismatchException e) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
				}
			
		} else {
			System.out.println(
					"------------------------------- Fehler! ------------------------------- \nIhre Eingabe war nicht erfolgreich, weil die ID nicht existiert!\n");
		}
	}

	private void auswahl_Mietvertrag_Wohnung_Kunde_Mitarbeiter(int �nderung) {
		close = false;

		JFrame meinRahmen = new JFrame();
		meinRahmen.setSize(250, 250);
		JPanel meinPanel = new JPanel();
		meinRahmen.setLocationRelativeTo(null);

		JComboBox combo2 = new JComboBox();
		combo2.addItem("" + 0);

		if (�nderung == -99) {
			meinRahmen.setTitle("Mietvertrag ID");
			JLabel frage = new JLabel("Welcher Mietvertrag wird bearbeitet?");
			meinPanel.add(frage);
			such_MietvertragID = "";
			for (Mietvertrag contract : contractList) {
				combo2.addItem(contract.getMietvertragID());
			}
		}

		if (�nderung == 2) {
			meinRahmen.setTitle("Wohngungs ID");
			JLabel frage = new JLabel("Welche Wohnung soll ausgew�hlt werden?");
			meinPanel.add(frage);
			such_WohnungsID = 0;
			for (Wohnung flat : flatList) {
				combo2.addItem(flat.getWohnungsID());
			}
		}

		if (�nderung == 3) {
			meinRahmen.setTitle("Mieter ID");
			JLabel frage = new JLabel("Welcher Mieter soll ausgew�hlt werden?");
			meinPanel.add(frage);
			such_MieterID = 0;
			for (Mieter owner : ownerList) {
				combo2.addItem(owner.getKundenID());
			}
		}

		if (�nderung == 4) {
			meinRahmen.setTitle("Mitarbeiter ID");
			JLabel frage = new JLabel("Welcher Mitarbeiter soll ausgew�hlt werden?");
			meinPanel.add(frage);
			such_Mitarbeiter = 0;
			for (Mitarbeiter worker : workerList) {
				combo2.addItem(worker.getMitarbeiterID());
			}
		}

		meinRahmen.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				close = true;
			}
		});

		ActionListener cbActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (�nderung == -100) {
					such_MietvertragID = (String) combo2.getSelectedItem();
				}
				if (�nderung == 2) {
					such_WohnungsID = (int) combo2.getSelectedItem();
				}
				if (�nderung == 3) {
					such_MieterID = (int) combo2.getSelectedItem();
				}
				if (�nderung == 4) {
					such_Mitarbeiter = (int) combo2.getSelectedItem();
				}
			}
		};
		meinPanel.add(combo2);
		meinRahmen.add(meinPanel, BorderLayout.SOUTH);
		meinRahmen.pack();
		meinRahmen.setVisible(true);
		while (close == false) {
			combo2.addActionListener(cbActionListener);
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

	private String l�nge_anpassen_Datum(Datum a_GD) {

		int abzug = 0;

		String leerzeichen = "";

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
		abzug = 4;
		if (abzug < 50) {
			while (abzug < 50) {
				leerzeichen = leerzeichen + " ";
				abzug += 1;
			}
		}
		return leerzeichen;
	}

	private String l�nge_anpassen(String wort) {

		int abzug = wort.length();
		if (wort.length() < 50) {
			while (wort.length() < 50) {
				wort = wort + " ";
			}
		}
		return wort;
	}
}