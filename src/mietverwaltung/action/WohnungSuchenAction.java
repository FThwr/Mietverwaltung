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

		double fl�che = -100;
		double such_fl�che = fl�che;

		double kosten = -100;
		double such_kosten = kosten;

		int etage = -100;
		int such_etage = etage;

		boolean balkon = false;
		boolean such_balkon = balkon;

		boolean fu�bodenheizung = false;
		boolean such_fu�bodenheizung = fu�bodenheizung;

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

		String[] suche = { "Wohnungsnummer", "Zimmeranzahl", "Fl�che", "Kosten", "Etage", "Balkon", "Fu�bodenheizung",
				"Aussicht", "Adresse", "Status", "letztes Renovierungsdatum", "Renoveringsanzahl",
				 "Handwerkerauftrag", "zugeordneter Mitarbeiter" };

		while (suchVorgang == true) {

			Scanner s = new Scanner(System.in);
			System.out.println("W�hlen Sie ein zu suchenden Wert!");
			System.out.println("Dr�cke '1'  f�r Wohnungsnummer");
			System.out.println("Dr�cke '2'  f�r Zimmeranzahl");
			System.out.println("Dr�cke '3'  f�r Fl�che");
			System.out.println("Dr�cke '4'  f�r Kosten");
			System.out.println("Dr�cke '5'  f�r Etage");
			System.out.println("Dr�cke '6'  f�r Balkon");
			System.out.println("Dr�cke '7'  f�r Fu�bodenheizung");
			System.out.println("Dr�cke '8'  f�r Aussicht");
			System.out.println("Dr�cke '9'  f�r Adresse");
			System.out.println("Dr�cke '10' f�r Status");
			System.out.println("Dr�cke '11' f�r letztes Renovierungsdatum");
			System.out.println("Dr�cke '12' f�r Renovierungsanzahl");
			System.out.println("Dr�cke '13' f�r Handwerkerauftrag");
			System.out.println("Dr�cke '14' f�r Aussicht");
			System.out.println("Dr�cke '15' f�r Suchen");
			System.out.println("Dr�cke '0'  f�r Abbruch");

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
				such_fl�che = einlesen_Zahl(suche, ok);
				if (such_fl�che == 0) {
					such_fl�che = fl�che;
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
					System.out.println("Keine vorhandene Auswahlm�glichkeit!");
				}
			}
			if (ok == 7) {
				Scanner t = new Scanner(System.in);
				System.out.println("Fu�bodenheizung vorhanden: '1' Ja, '2' Nein, '3' Abbruch!");
				int eingabe = t.nextInt();

				check = check + "g";

				if (eingabe == 1) {
					such_fu�bodenheizung = true;
				}
				if (eingabe == 2) {
					such_fu�bodenheizung = false;
				}
				if (eingabe == 3) {
					such_fu�bodenheizung = fu�bodenheizung;
				} else {
					System.out.println("Keine vorhandene Auswahlm�glichkeit!");
				}
			}
			if (ok == 8) {
				Scanner t = new Scanner(System.in);
				System.out.println("Aussicht auf: '1' Park, '2' Spree, '3' Schienen, '4' Stra�e, '5' abbruch!");
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
					such_aussicht = "Stra�e";
				}
				if (eingabe == 5) {
					such_aussicht = aussicht;
				} else {
					System.out.println("Keine vorhandene Auswahlm�glichkeit!");
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
					System.out.println("Keine vorhandene Auswahlm�glichkeit!");
				}
			}
			if (ok == 11) {
				System.out.println("Spezialisierung des zu suchenden Eingabedatums: ");
				System.out.println("Dr�cke '2' f�r Monat: ");
				System.out.println("Dr�cke '3' f�r Jahr: ");
				System.out.println("Dr�cke '4' f�r Best�tigen: ");
				System.out.println("Dr�cke '5' f�r Abbruch: ");

				String[] auswahl = { "Monat", "Jahr" };
				boolean datumseingabe = true;
				String saveCheck = check;

				while (datumseingabe == true) {

					Scanner q = new Scanner(System.in);
					int z�hler = q.nextInt();

					if (z�hler == 2) {
						such_monat = einlesen_Zahl(auswahl, z�hler);
						if (such_monat == 0) {
							such_monat = monat;
						} else {
							saveCheck = saveCheck + "k";
						}
					}
					if (z�hler == 3) {
						such_jahr = einlesen_Zahl(auswahl, z�hler);
						if (such_jahr == 0) {
							such_jahr = jahr;
						} else {
							saveCheck = saveCheck + "l";
						}
					}
					if (z�hler == 4) {
						datumseingabe = false;
						check = check + saveCheck;
					}
					if (z�hler == 5) {
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
				double vgl_fl�che = -100;
				double vgl_kosten = -100;
				int vgl_etage = -100;
				boolean vgl_balkon = false;
				boolean vgl_fu�bodenheizung = false;
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
						vgl_fl�che = flat.getFl�che();
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
						vgl_fu�bodenheizung = flat.getFu�bodenheizung();
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
							&& vgl_fl�che == such_fl�che && vgl_kosten == such_kosten && vgl_etage == such_etage
							&& vgl_balkon == such_balkon && vgl_fu�bodenheizung == such_fu�bodenheizung
							&& vgl_aussicht.contains(such_aussicht) && vgl_platz == such_platz
							&& vgl_status.contains(such_status) && vgl_monat == such_monat && vgl_jahr == such_jahr
							&& vgl_renovierungsanzahl == such_renovierungsanzahl
							&& vgl_handwerkerAuftragID.equals(such_handwerkerAuftragID) && vgl_name.contains(such_name)) {

						System.out.println("Wohnungsnummer: " + flat.getWohnungsID());
						System.out.println("Zimmeranzahl: " + flat.getZimmeranzahl());
						System.out.println("Fl�che: " + flat.getFl�che());
						System.out.println("Kosten: " + flat.getKosten());
						System.out.println("Etage: " + flat.getEtage());
						System.out.println("Balkon: " + flat.getBalkon());
						System.out.println("Fu�bodenheizung: " + flat.getFu�bodenheizung());
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
}
