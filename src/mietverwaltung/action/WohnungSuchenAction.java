package mietverwaltung.action;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import mietverwaltung.Wohnung;
import mietverwaltung.menu.MenuManager;

public class WohnungSuchenAction extends MenuManager implements Action {

	@Override
	public void action() {
		String check = "";

		boolean suchVorgang = true;

		int wohnungsnummer = -100;
		int such_wohnungsnummer = wohnungsnummer;

		int zimmeranzahl = -100;
		int such_zimmeranzahl = zimmeranzahl;

		double fläche = -100;
		double such_fläche = fläche;

		double kosten = -100;
		double such_kosten = kosten;

		int etage = -100;
		int such_etage = etage;

		boolean balkon = false;
		boolean such_balkon = balkon;

		boolean fußbodenheizung = false;
		boolean such_fußbodenheizung = fußbodenheizung;

		String aussicht = "-";
		String such_aussicht = aussicht;

		int platz = -100;
		int such_platz = platz;

		String status = "-";
		String such_status = status;

		int monat = -100;
		int such_monat = monat;

		int jahr = -100;
		int such_jahr = jahr;

		int renovierungsanzahl = -100;
		int such_renovierungsanzahl = renovierungsanzahl;

		String handwerkerAuftragID = "-";
		String such_handwerkerAuftragID = handwerkerAuftragID;

		String name = "-";
		String such_name = name;

		String[] suche = { "Wohnungsnummer", "Zimmeranzahl", "Fläche", "Kosten", "Etage", "Balkon", "Fußbodenheizung",
				"Aussicht", "Adresse", "Status", "letztes Renovierungsdatum", "Renoveringsanzahl",
				 "Handwerkerauftrag", "zugeordneter Mitarbeiter" };

		while (suchVorgang == true) {

			Scanner s = new Scanner(System.in);
			System.out.println("Wählen Sie ein zu suchenden Wert!");
			System.out.println("Drücke '1'  für Wohnungsnummer");
			System.out.println("Drücke '2'  für Zimmeranzahl");
			System.out.println("Drücke '3'  für Fläche");
			System.out.println("Drücke '4'  für Kosten");
			System.out.println("Drücke '5'  für Etage");
			System.out.println("Drücke '6'  für Balkon");
			System.out.println("Drücke '7'  für Fußbodenheizung");
			System.out.println("Drücke '8'  für Aussicht");
			System.out.println("Drücke '9'  für Adresse");
			System.out.println("Drücke '10' für Status");
			System.out.println("Drücke '11' für letztes Renovierungsdatum");
			System.out.println("Drücke '12' für Renovierungsanzahl");
			System.out.println("Drücke '13' für Handwerkerauftrag");
			System.out.println("Drücke '14' für Aussicht");
			System.out.println("Drücke '15' für Suchen");
			System.out.println("Drücke '0'  für Abbruch");

			// try
			int ok = s.nextInt();

			if (ok == 0) {
				suchVorgang = false;
			}
			if (ok == 1) {
				such_wohnungsnummer = einlesen_Zahl(suche, ok);
				if (such_wohnungsnummer == 0) {
					such_wohnungsnummer = wohnungsnummer;
				} else {
					check = check + "a";
				}
			}
			if (ok == 2) {
				such_zimmeranzahl = einlesen_Zahl(suche, ok);
				if (such_zimmeranzahl == 0) {
					such_zimmeranzahl = zimmeranzahl;
				} else {
					check = check + "b";
				}
			}
			if (ok == 3) {
				such_fläche = einlesen_Zahl(suche, ok);
				if (such_fläche == 0) {
					such_fläche = fläche;
				} else {
					check = check + "c";
				}
			}
			if (ok == 4) {
				such_kosten = einlesen_Zahl(suche, ok);

				if (such_kosten == 0) {
					such_kosten = kosten;
				} else {
					check = check + "d";
				}
			}
			if (ok == 5) {
				such_etage = einlesen_Zahl(suche, ok);
				if (such_etage == 0) {
					such_etage = etage;
				} else {
					check = check + "e";
				}
			}
			if (ok == 6) {

				Scanner t = new Scanner(System.in);
				System.out.println("Balkon vorhanden: '1' Ja, '2' Nein, '3' Abbruch!");
				int eingabe = t.nextInt();

				check = check + "f";

				if (eingabe == 1) {
					such_balkon = true;
				}
				if (eingabe == 2) {
					such_balkon = false;
				}
				if (eingabe == 3) {
					such_balkon = balkon;
				} else {
					System.out.println("Keine vorhandene Auswahlmöglichkeit!");
				}
			}
			if (ok == 7) {
				Scanner t = new Scanner(System.in);
				System.out.println("Fußbodenheizung vorhanden: '1' Ja, '2' Nein, '3' Abbruch!");
				int eingabe = t.nextInt();

				check = check + "g";

				if (eingabe == 1) {
					such_fußbodenheizung = true;
				}
				if (eingabe == 2) {
					such_fußbodenheizung = false;
				}
				if (eingabe == 3) {
					such_fußbodenheizung = fußbodenheizung;
				} else {
					System.out.println("Keine vorhandene Auswahlmöglichkeit!");
				}
			}
			if (ok == 8) {
				Scanner t = new Scanner(System.in);
				System.out.println("Aussicht auf: '1' Park, '2' Spree, '3' Schienen, '4' Straße, '5' abbruch!");
				int eingabe = t.nextInt();

				check = check + "h";

				if (eingabe == 1) {
					such_aussicht = "Park";
				}
				if (eingabe == 2) {
					such_aussicht = "Spree";
				}
				if (eingabe == 3) {
					such_aussicht = "Schienen";
				}
				if (eingabe == 4) {
					such_aussicht = "Straße";
				}
				if (eingabe == 5) {
					such_aussicht = aussicht;
				} else {
					System.out.println("Keine vorhandene Auswahlmöglichkeit!");
				}
			}
			if (ok == 9) {
				such_platz = einlesen_Zahl(suche, ok);
				if (such_platz == 0 || such_platz == -100) {
					such_platz = platz;
				} else {
					check = check + "i";
				}
			}
			if (ok == 10) {
				Scanner t = new Scanner(System.in);
				System.out.println("Status der Wohnung: '1' frei, '2' vermietet, '3' in Renovierung, '4' abbruch!");
				int eingabe = t.nextInt();

				check = check + "j";

				if (eingabe == 1) {
					such_status = "frei";
				}
				if (eingabe == 2) {
					such_status = "vermietet";
				}
				if (eingabe == 3) {
					such_status = "in Renovierung";
				}
				if (eingabe == 4) {
					such_status = status;
				} else {
					System.out.println("Keine vorhandene Auswahlmöglichkeit!");
				}
			}
			if (ok == 11) {
				System.out.println("Spezialisierung des zu suchenden Eingabedatums: ");
				System.out.println("Drücke '2' für Monat: ");
				System.out.println("Drücke '3' für Jahr: ");
				System.out.println("Drücke '4' für Bestätigen: ");
				System.out.println("Drücke '5' für Abbruch: ");

				String[] auswahl = { "Monat", "Jahr" };
				boolean datumseingabe = true;
				String saveCheck = check;

				while (datumseingabe == true) {

					Scanner q = new Scanner(System.in);
					int zähler = q.nextInt();

					if (zähler == 2) {
						such_monat = einlesen_Zahl(auswahl, zähler);
						if (such_monat == 0) {
							such_monat = monat;
						} else {
							saveCheck = saveCheck + "k";
						}
					}
					if (zähler == 3) {
						such_jahr = einlesen_Zahl(auswahl, zähler);
						if (such_jahr == 0) {
							such_jahr = jahr;
						} else {
							saveCheck = saveCheck + "l";
						}
					}
					if (zähler == 4) {
						datumseingabe = false;
						check = check + saveCheck;
					}
					if (zähler == 5) {
						datumseingabe = false;
					}
				}
			}
			if (ok == 12) {
				such_renovierungsanzahl = einlesen_Zahl(suche, ok);
				if (such_renovierungsanzahl == 0) {
					such_renovierungsanzahl = renovierungsanzahl;
				} else {
					check = check + "m";
				}
			}
			if (ok == 13) {
				such_handwerkerAuftragID = einlesen_Wort(suche, ok);
				if (such_handwerkerAuftragID.equals("" + 0)) {
					such_handwerkerAuftragID = handwerkerAuftragID;
				} else {
					check = check + "n";
				}
			}
			if (ok == 14) {
				such_name = einlesen_Wort(suche, ok);
				if (such_name.equals("" + 0)) {
					such_name = name;
				} else {
					check = check + "o";
				}
			}
			if (ok == 15) {
				suchVorgang = false;

				// Vergleichsvariablen
				int vgl_wohnungsnummer = -100;
				int vgl_zimmeranzahl = -100;
				double vgl_fläche = -100;
				double vgl_kosten = -100;
				int vgl_etage = -100;
				boolean vgl_balkon = false;
				boolean vgl_fußbodenheizung = false;
				String vgl_aussicht = "-";
				int vgl_platz = -100;
				String vgl_status = "-";
				int vgl_monat = -100;
				int vgl_jahr = -100;
				int vgl_renovierungsanzahl = -100;
				String vgl_handwerkerAuftragID = "-";
				String vgl_name = "-";

				for (Wohnung flat : flatList) {

					if (check.contains("a")) {
						vgl_wohnungsnummer = flat.getWohnungsID();
					}
					if (check.contains("b")) {
						vgl_zimmeranzahl = flat.getZimmeranzahl();
					}
					if (check.contains("c")) {
						vgl_fläche = flat.getFläche();
					}
					if (check.contains("d")) {
						vgl_kosten = flat.getKosten();
					}
					if (check.contains("e")) {
						vgl_etage = flat.getEtage();
					}
					if (check.contains("f")) {
						vgl_balkon = flat.getBalkon();
					}
					if (check.contains("g")) {
						vgl_fußbodenheizung = flat.getFußbodenheizung();
					}
					if (check.contains("h")) {
						vgl_aussicht = flat.getAussicht();
					}
					if (check.contains("i")) {
						vgl_platz = flat.getAdresse().getPlz();
					}
					if (check.contains("j")) {
						vgl_status = flat.getStatus();
					}
					if (check.contains("k")) {
						vgl_monat = flat.getLetztesRenovierungsdatum().getMonat();
					}
					if (check.contains("l")) {
						vgl_jahr = flat.getLetztesRenovierungsdatum().getJahr();
					}
					if (check.contains("m")) {
						vgl_renovierungsanzahl = flat.getRenovierungsanzahl();
					}
					if (check.contains("n")) {
						vgl_handwerkerAuftragID = flat.getHandwerkerauftrag().getAuftragsID();
					}
					if (check.contains("o")) {
						vgl_name = flat.getZugeordneterMitarbeiter().getName();
					}

					if (vgl_wohnungsnummer == such_wohnungsnummer && vgl_zimmeranzahl == such_zimmeranzahl
							&& vgl_fläche == such_fläche && vgl_kosten == such_kosten && vgl_etage == such_etage
							&& vgl_balkon == such_balkon && vgl_fußbodenheizung == such_fußbodenheizung
							&& vgl_aussicht.contains(such_aussicht) && vgl_platz == such_platz
							&& vgl_status.contains(such_status) && vgl_monat == such_monat && vgl_jahr == such_jahr
							&& vgl_renovierungsanzahl == such_renovierungsanzahl
							&& vgl_handwerkerAuftragID.equals(such_handwerkerAuftragID) && vgl_name.contains(such_name)) {

						System.out.println("Wohnungsnummer: " + flat.getWohnungsID());
						System.out.println("Zimmeranzahl: " + flat.getZimmeranzahl());
						System.out.println("Fläche: " + flat.getFläche());
						System.out.println("Kosten: " + flat.getKosten());
						System.out.println("Etage: " + flat.getEtage());
						System.out.println("Balkon: " + flat.getBalkon());
						System.out.println("Fußbodenheizung: " + flat.getFußbodenheizung());
						System.out.println("Aussicht: " + flat.getAussicht());
						System.out.println("Adresse: " + flat.getAdresse());
						System.out.println("Status: " + flat.getStatus());
						System.out.println("letztes Renovierungsdatum: " + flat.getLetztesRenovierungsdatum());
						System.out.println("Renovierungsanzahl: " + flat.getRenovierungsanzahl());
						System.out.println("letze Renovierungdetails: " + flat.getLetzeRenovierung_Details());
						System.out.println("Handwerkerauftrag-ID: " + flat.getHandwerkerauftrag().getAuftragsID());
						System.out.println("zugeordneter Mitarbeiter: " + flat.getZugeordneterMitarbeiter().getName());
					}
				}
			}

		}
	}

	private int einlesen_Zahl(String[] auswahl, int zähler) {
		System.out.println("Geben Sie ein: " + auswahl[zähler - 1]);
		Scanner s = new Scanner(System.in);
		int wort = s.nextInt();
		return wort;
	}

	private String einlesen_Wort(String[] auswahl, int zähler) {
		System.out.println("Geben Sie ein: " + auswahl[zähler - 1]);
		Scanner s = new Scanner(System.in);
		String wort = s.next();
		return wort;
	}
}
