package mietverwaltung;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SuchanfrageWohnungSuchenAction extends MenueManager implements Action, Serializable {

	
	static boolean fenster = false;
	static boolean window = false;
	static int such_kundenID;
	static int such_mitarbeiterID;
	

	@Override
	public void action() {

		System.out.println(
				"________________________________________ Suchanfrage: Wohnung suchen ________________________________________");

		such_kundenID = 0;
		
		boolean suchVorgang = true;

		double such_zimmeranzahl = -100;
		char zimmeranzahl_rela = ' ';

		double such_fläche = -100;
		char fläche_rela = ' ';

		double such_kosten = -100;
		char kosten_rela = ' ';

		double such_etage = -100;
		char etage_rela = ' ';

		boolean such_balkon = false;
		
		boolean such_fußbodenheizung = false;
		
		String such_aussicht = "-";

		String[] kategorie = { "Zimmeranzahl", "Fläche", "Kosten", "Etage", "Balkon", "Fußbodenheizung", "Aussicht" };

		ArrayList<Bedingung> bedingungList = new ArrayList<Bedingung>();
		ArrayList<Wohnung> erg = new ArrayList<Wohnung>();

		char zeichen = '-';

		String auswahl = " ";
		
		int änderung = -99;
		
		auswahl_InteressentenID_MitarbeiterID(änderung);
		
		änderung = -98;
		
		auswahl_InteressentenID_MitarbeiterID(änderung);

		while (suchVorgang == true) {

			Scanner s = new Scanner(System.in);
			System.out.println(
					"............................... Wählen Sie die zu suchende Eigenschaft aus! ...............................");
			System.out.println("........... Aktuelle Suche nach: ...........");
			System.out.println("   Mitarbeiter-ID:  " + such_mitarbeiterID);
			System.out.println("   Kunden-ID:       " + such_kundenID);
			System.out.println("1. Zimmeranzahl:    " + zimmeranzahl_rela + such_zimmeranzahl);
			System.out.println("2. Fläche:          " + fläche_rela + such_fläche);
			System.out.println("3. Kosten:          " + kosten_rela + such_kosten);
			System.out.println("4. Etage:           " + etage_rela + such_etage);
			System.out.println("5. Balkon:          " + such_balkon);
			System.out.println("6. Fußbodenheizung: " + such_fußbodenheizung);
			System.out.println("7. Aussicht:        " + such_aussicht);
			System.out.println("8. Bestätigen ");
			System.out.println("0. Abbruch ");
			System.out.println("");

			try {
				int eingabe = s.nextInt();

				// Eingabe zum Abbruch der Suche
				if (eingabe == 0) {
					suchVorgang = false;
				}

				// Eingabe um die Zimmeranzahl der Suchanfrage festzulegen
				if (eingabe == 1) {
					int rela = 0;

					auswahl = einlesen_Wort(kategorie, eingabe);
					if (auswahl.equals("" + 0)) {
					} else {

						zeichen = auslesen_Zeichen(auswahl);
						zimmeranzahl_rela = zeichen;
						
						auswahl = auswahl.substring(auswahl.indexOf('=') + 1, auswahl.length());
						auswahl = auswahl.substring(auswahl.indexOf('<') + 1, auswahl.length());
						auswahl = auswahl.substring(auswahl.indexOf('>') + 1, auswahl.length());

						such_zimmeranzahl = Integer.parseInt(auswahl);

						if (zeichen == '<') {
							rela = 0;
						}
						if (zeichen == '=') {
							rela = 1;
						}
						if (zeichen == '>') {
							rela = 2;
						}
						if (zeichen == ' ') {
							rela = 3;
						}

						löschen(eingabe, bedingungList);
						bedingungList.add(new Bedingung(eingabe, rela, such_zimmeranzahl));
					}
				}

				if (eingabe == 2) {

					int rela = 0;

					auswahl = einlesen_Wort(kategorie, eingabe);
					if (auswahl.equals("" + 0)) {
					} else {

						zeichen = auslesen_Zeichen(auswahl);
						fläche_rela = zeichen;
						
						
						auswahl = auswahl.substring(auswahl.indexOf('=') + 1, auswahl.length());
						auswahl = auswahl.substring(auswahl.indexOf('<') + 1, auswahl.length());
						auswahl = auswahl.substring(auswahl.indexOf('>') + 1, auswahl.length());

						such_fläche = Integer.parseInt(auswahl);

						if (zeichen == '<') {
							rela = 0;
						}
						if (zeichen == '=') {
							rela = 1;
						}
						if (zeichen == '>') {
							rela = 2;
						}
						if (zeichen == ' ') {
							rela = 3;
						}

						löschen(eingabe, bedingungList);
						bedingungList.add(new Bedingung(eingabe, rela, such_fläche));
					}
				}

				if (eingabe == 3) {

					int rela = 0;

					auswahl = einlesen_Wort(kategorie, eingabe);
					if (auswahl.equals("" + 0)) {
					} else {

						zeichen = auslesen_Zeichen(auswahl);
						kosten_rela = zeichen;
						
						
						auswahl = auswahl.substring(auswahl.indexOf('=') + 1, auswahl.length());
						auswahl = auswahl.substring(auswahl.indexOf('<') + 1, auswahl.length());
						auswahl = auswahl.substring(auswahl.indexOf('>') + 1, auswahl.length());

						such_kosten = Integer.parseInt(auswahl);

						if (zeichen == '<') {
							rela = 0;
						}
						if (zeichen == '=') {
							rela = 1;
						}
						if (zeichen == '>') {
							rela = 2;
						}
						if (zeichen == ' ') {
							rela = 3;
						}

						löschen(eingabe, bedingungList);
						bedingungList.add(new Bedingung(eingabe, rela, such_kosten));
					}
				}

				if (eingabe == 4) {

					int rela = 0;

					auswahl = einlesen_Wort(kategorie, eingabe);
					if (auswahl.equals("" + 0)) {
					} else {

						zeichen = auslesen_Zeichen(auswahl);
						etage_rela = zeichen;
						
						
						auswahl = auswahl.substring(auswahl.indexOf('=') + 1, auswahl.length());
						auswahl = auswahl.substring(auswahl.indexOf('<') + 1, auswahl.length());
						auswahl = auswahl.substring(auswahl.indexOf('>') + 1, auswahl.length());

						such_etage = Integer.parseInt(auswahl);

						if (zeichen == '<') {
							rela = 0;
						}
						if (zeichen == '=') {
							rela = 1;
						}
						if (zeichen == '>') {
							rela = 2;
						}
						if (zeichen == ' ') {
							rela = 3;
						}

						löschen(eingabe, bedingungList);
						bedingungList.add(new Bedingung(eingabe, rela, such_etage));
					}
				}

				if (eingabe == 5) {

					int rela = 1;
					int wahl = 0;
					Scanner q = new Scanner(System.in);
					System.out.println("Wäheln Sie, ob ein Balkon vorhanden sein soll: '1' nein, '2' ja");

					try {
						String ausWahl = q.next();
						if (ausWahl.equals("" + 0)) {
						} else {
							

							wahl = Integer.parseInt(ausWahl);

							if (wahl == 1) {
								such_balkon = false;
							}
							if (wahl == 2) {
								such_balkon = true;
							}

							löschen(eingabe, bedingungList);
							bedingungList.add(new Bedingung(eingabe, rela, wahl));

						}
					} catch (InputMismatchException e) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
					}
				}

				if (eingabe == 6) {

					int rela = 1;
					int wahl = 0;
					Scanner q = new Scanner(System.in);
					System.out.println("Wäheln Sie, ob eine Fußbodenheizung vorhanden sein soll: '1' nein, '2' ja");

					try {
						String ausWahl = q.next();
						if (ausWahl.equals("" + 0)) {
						} else {


							wahl = Integer.parseInt(ausWahl);

							if (wahl == 1) {
								such_fußbodenheizung = false;
							}
							if (wahl == 2) {
								such_fußbodenheizung = true;
							}

							löschen(eingabe, bedingungList);
							bedingungList.add(new Bedingung(eingabe, rela, wahl));

						}
					} catch (InputMismatchException e) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
					}
				}

				if (eingabe == 7) {

					int rela = 1;
					int wahl = 0;
					Scanner q = new Scanner(System.in);
					System.out.println("Wäheln Sie ihre Wunschaussicht: '1' Park, '2' Spree, '3' Schienen, '4' Straße");

					try {
						String ausWahl = q.next();
						if (ausWahl.equals("" + 0)) {
						} else {
							
							


							wahl = Integer.parseInt(ausWahl);

							if (wahl == 1) {
								such_aussicht = "Park";
							}
							if (wahl == 2) {
								such_aussicht = "Spree";
							}
							if (wahl == 3) {
								such_aussicht = "Schienen";
							}
							if (wahl == 4) {
								such_aussicht = "Straße";
							}

							löschen(eingabe, bedingungList);
							bedingungList.add(new Bedingung(eingabe, rela, wahl));

						}
					} catch (InputMismatchException e) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
					}
				}

				if (eingabe == 8) {
					suchVorgang = false;

					erg = xxx(flatList, bedingungList);
					
					searchList.add(new Suchanfrage (such_mitarbeiterID , such_kundenID, zimmeranzahl_rela, such_zimmeranzahl, fläche_rela, such_fläche, kosten_rela, such_kosten, etage_rela, such_etage, such_balkon, such_fußbodenheizung, such_aussicht));

					for (Wohnung flat : erg) {

						System.out.println("Wohnungsnummer:                  " + flat.getWohnungsID());
						System.out.println("Zimmeranzahl:                    " + flat.getZimmeranzahl());
						System.out.println("Fläche:                          " + flat.getFläche());
						System.out.println("Kosten:                          " + flat.getKosten());
						System.out.println("Etage:                           " + flat.getEtage());
						System.out.println("Balkon:                          " + flat.getBalkon());
						System.out.println("Fußbodenheizung:                 " + flat.getFußbodenheizung());
						System.out.println("Aussicht:                        " + flat.getAussicht());
						System.out.println("Adresse:                         " + flat.getAdresse());
						System.out.println("Status:                          " + flat.getStatus());
						System.out.println("letztes Renovierungsdatum:       " + flat.getLetztesRenovierungsdatum());
						System.out.println("Renovierungsanzahl:              " + flat.getRenovierungsanzahl());
						System.out.println("letze Renovierungdetails:        " + flat.getLetzeRenovierung_Details());
						System.out.println(
								"Handwerkerauftrag:               " + flat.getHandwerkerauftrag().getAuftragsID());
						System.out.println(
								"zugeordneter Mitarbeiter:        " + flat.getZugeordneterMitarbeiter().getName());
						System.out.println("");

					}

				}
				if (eingabe > 8) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit nicht vorhanden!\n");
				}
			}

			catch (InputMismatchException e) {
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
	private void auswahl_InteressentenID_MitarbeiterID(int änderung) {
		window = false;
		such_mitarbeiterID = 0;

		JFrame meinRahmen = new JFrame();

		meinRahmen.setSize(250, 250);
		JPanel meinPanel = new JPanel();
		meinRahmen.setLocationRelativeTo(null);

		JComboBox combo2 = new JComboBox();

		if (änderung == -99) {
			meinRahmen.setTitle("Interessenten ID");
			JLabel frage = new JLabel("Für welchen Interessenten wird ein Suchauftrag ausgeführt?");
			meinPanel.add(frage);
			for (Interessent interest : interestList) {
				combo2.addItem(interest.getKundenID());
			}
		}

		if (änderung == -98) {
			meinRahmen.setTitle("Mitarbeiter ID");
			JLabel frage = new JLabel("Von welchem Mitarbeiter wird ein Suchauftrag ausgeführt?");
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
				if (änderung == -99) {
					such_kundenID = (int) combo2.getSelectedItem();
				}
				if (änderung == -98) {
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

	private void löschen(int aktuellesKriterium, ArrayList<Bedingung> listeVonBedingungen) {
		Iterator<Bedingung> iter = listeVonBedingungen.iterator();

		while (iter.hasNext()) {
			Bedingung str = iter.next();

			if (str.getKrit() == aktuellesKriterium) {
				iter.remove();
			}
		}

	}

	private ArrayList<Wohnung> xxx(ArrayList<Wohnung> alleWohnungen, ArrayList<Bedingung> anfrage) {
		/**
		 * kriterium .. zimmeranzahl, miete, etage, etc Relation .. <, <=, =,
		 * >=, >, (ohne zeichen bedeutet '=') 0 1 2 3 4 5 wert .. irgendeine
		 * zahl
		 * 
		 * bedingung: (krit, rela, wunschwert)
		 * 
		 * anfrage: ((krit1, rela1, wunschwert1), (krit2, rela2, wunschwert2),
		 * ...)
		 * 
		 * ListOfWohnung
		 **/

		ArrayList<Wohnung> erg = alleWohnungen;
		for (Bedingung b : anfrage) {

			erg = filter(erg, b);
		}

		return erg;
	}

	private ArrayList<Wohnung> filter(ArrayList<Wohnung> wohnungen, Bedingung b) {
		ArrayList<Wohnung> erg = new ArrayList<Wohnung>();

		for (Wohnung flat : wohnungen) {
			double aktWert = 0;
			boolean bedingungErfüllt = false;

			switch (b.getKrit()) {
			case 1 /* Zimmeranzahl */:
				aktWert = flat.getZimmeranzahl();
				break;
			case 2 /* Fläche */:
				aktWert = flat.getFläche();
				break;
			case 3 /* Kosten */:
				aktWert = flat.getKosten();
				break;
			case 4 /* Etage */:
				aktWert = flat.getEtage();
				break;
			case 5 /* Balkon */:
				if (flat.getBalkon() == false) {
					aktWert = 1;
				} else {
					aktWert = 2;
				}
				break;
			case 6 /* Fußbodenheizung */:
				if (flat.getFußbodenheizung() == false) {
					aktWert = 1;
				} else {
					aktWert = 2;
				}
				break;
			case 7 /* Aussicht */:
				if (flat.getAussicht().equals("Park")) {
					aktWert = 1;
				}
				if (flat.getAussicht().equals("Spree")) {
					aktWert = 2;
				}
				if (flat.getAussicht().equals("Schienen")) {
					aktWert = 3;
				}
				if (flat.getAussicht().equals("Straße")) {
					aktWert = 4;
				}
				break;
			default:
				throw new RuntimeException("unbekanntes Kriterium abgefragt, Krit=" + b.getKrit());
			}

			switch (b.getRela()) {
			case 1 /* '=' */:
			case 3 /* ohne relation entspr '=' */:
				bedingungErfüllt = aktWert == b.getWunschwert();
				break;
			case 0 /* '<' */:
				bedingungErfüllt = aktWert < b.getWunschwert();
				break;
			case 2 /* '>' */:
				bedingungErfüllt = aktWert > b.getWunschwert();
				break;
			default:
				throw new RuntimeException("unbekannte Relation eingegeben, Rela=" + b.getRela());
			}

			if (bedingungErfüllt)
				erg.add(flat);

		}

		return erg;
	}

	private String einlesen_Wort(String[] auswahl, int zähler) {

		Scanner s = new Scanner(System.in);

		boolean korrekteEingabe = false;
		String suchWert = "";

		while (korrekteEingabe == false) {
			System.out.println("Geben Sie ein: " + auswahl[zähler - 1]);

			suchWert = s.next();
			char t = suchWert.charAt(0);

			try {

				if (suchWert.equals("" + 0)) {
					korrekteEingabe = true;
					break;
				}

				if (Integer.valueOf(suchWert) instanceof Integer) {
					System.out.println("Typ wurde falsch eingegeben! Geben Sie ein: '<' '>' '=' und eine Zahl! ");
				}
			} catch (NumberFormatException e) {
				if (suchWert.length() < 2) {
					System.out.println("Typ wurde falsch eingegeben! Geben Sie ein: '<' '>' '=' und eine Zahl! ");
				} else {
					int fehlerErkennung = 0;

					for (int i = 1; i < suchWert.length(); i++) {
						char u = suchWert.charAt(i);
						int uToInt = Character.getNumericValue(u);

						if (t == '<' || t == '>' || t == '=') {
							if (uToInt == -1 || uToInt >= 9) {
								fehlerErkennung = 1;

							}
						} else {
							fehlerErkennung = 1;
						}
					}
					if (fehlerErkennung == 1) {
						System.out.println("Typ wurde falsch eingegeben! Geben Sie ein: '<' '>' '=' und eine Zahl! ");
					} else {
						korrekteEingabe = true;
					}
				}
			}
		}

		return suchWert;

	}

	private char auslesen_Zeichen(String zeichen) {

		char t = zeichen.charAt(0);
		return t;
	}
}
