package action;


import javax.swing.JDialog;
import javax.swing.JOptionPane;

import menue.MenueManager;
import objekte.Mieter;
import objekte.Wohnung;

public class WohnungBearbeitenAction extends MenueManager implements Action {

	@Override
	public void action() {

		JOptionPane jop = new JOptionPane();
		jop.setWantsInput(true);
		jop.setMessage("Welche Wohnung wollen Sie bearbeiten?");
		// in der Klammer den Namen des Fensters eingeben
		JDialog dialog = jop.createDialog("Wohnungsbearbeitung");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);

		String zu_bearbeitende_wohnung = jop.getInputValue() == JOptionPane.UNINITIALIZED_VALUE ? null
				: (String) jop.getInputValue();

		for (Wohnung flat : flatList) {
			if (zu_bearbeitende_wohnung.equals("" + flat.getWohnungsID())) {
				boolean bearbeitungsVorgang = true;

				String aktueller_Mieternachname = flat.getOwner().getName();
				String neue_Mieternachname = aktueller_Mieternachname;
				String a_MINN = aktueller_Mieternachname;
				a_MINN = l‰nge_anpassen(a_MINN);

				String aktueller_Mietername = flat.getOwner().getName();
				String neue_Mietername = aktueller_Mietername;
				String a_MIN = aktueller_Mietername;
				a_MIN = l‰nge_anpassen(a_MIN);

				int aktuelleID = flat.getWohnungsID();
				int neueID = aktuelleID;
				String aID = "" + aktuelleID;
				aID = l‰nge_anpassen(aID);

				int aktuelle_zimmeranzahl = flat.getZimmeranzahl();
				int neue_zimmeranzahl = aktuelle_zimmeranzahl;
				String a_ZA = "" + aktuelle_zimmeranzahl;
				a_ZA = l‰nge_anpassen(a_ZA);

				double aktuelle_fl‰che = flat.getFl‰che();
				double neue_fl‰che = aktuelle_fl‰che;
				String a_FL = "" + aktuelle_fl‰che;
				a_FL = l‰nge_anpassen(a_FL);

				double aktuelle_kosten = flat.getKosten();
				double neue_kosten = aktuelle_kosten;
				String a_KT = "" + aktuelle_kosten;
				a_KT = l‰nge_anpassen(a_KT);

				int aktuelle_etage = flat.getEtage();
				int neue_etage = aktuelle_etage;
				String a_EG = "" + aktuelle_etage;
				a_EG = l‰nge_anpassen(a_EG);

				boolean aktuelle_balkon = flat.getBalkon();
				boolean neue_balkon = aktuelle_balkon;
				String a_BK = "" + aktuelle_balkon;
				a_BK = l‰nge_anpassen(a_BK);

				boolean aktuelle_fuﬂbodenheizung = flat.getFuﬂbodenheizung();
				boolean neue_fuﬂbodenheizung = aktuelle_fuﬂbodenheizung;
				String a_FBH = "" + aktuelle_fuﬂbodenheizung;
				a_FBH = l‰nge_anpassen(a_FBH);

				String aktuelle_aussicht = flat.getAussicht();
				String neue_aussicht = aktuelle_aussicht;
				String a_AS = aktuelle_aussicht;
				a_AS = l‰nge_anpassen(a_AS);

				// String adresse = "";
				String aktuelle_status = flat.getStatus();
				String neue_status = aktuelle_status;
				String a_ST = aktuelle_status;
				a_ST = l‰nge_anpassen(a_ST);

				String aktuelle_letztesRenovierungsdatum = flat.getLetztesRenovierungsdatum();
				String neue_letzesRenovierungsdatum = aktuelle_letztesRenovierungsdatum;
				String a_LRDT = aktuelle_letztesRenovierungsdatum;
				a_LRDT = l‰nge_anpassen(a_LRDT);

				int aktuelle_renovierungsanzahl = flat.getRenovierungsanzahl();
				int neue_renovierungsanzahl = aktuelle_renovierungsanzahl;
				String a_RA = "" + aktuelle_renovierungsanzahl;
				a_RA = l‰nge_anpassen(a_RA);

				String aktuelle_letzeRenovierung_Details = flat.getLetzeRenovierung_Details();
				String neue_letzteRenovierung_Details = aktuelle_letzeRenovierung_Details;
				String a_LRI = aktuelle_letzeRenovierung_Details;
				a_LRI = l‰nge_anpassen(a_LRI);

				String aktuelle_zugeordneterMitarbeiter = flat.getZugeordneterMitarbeiter().getName();
				String neue_zugeordneterMitarbeiter = aktuelle_zugeordneterMitarbeiter;
				String a_ZM = aktuelle_zugeordneterMitarbeiter;
				a_ZM = l‰nge_anpassen(a_ZM);

				while (bearbeitungsVorgang == true) {

					String[] buttons = { "ID", "ZA", "Fl", "KT", "EG", "BK", "FBH", "AS", "ST", "LRDT", "RA", "LRI",
							"ZM", "MINN", "MIN", "‰ndern", "abbruch" };

					int ok = JOptionPane.showOptionDialog(null, "W‰hlen Sie ein zu bearbeitenden Wert! "

							+ "\n\naktuelle ID:                " + aID + "aktuelle ID:                " + neueID
							+ "\n\naktuelle ZA:               " + a_ZA + "aktuelle ZA:               "
							+ neue_zimmeranzahl + "\n\naktuelle FL:                " + a_FL
							+ "aktuelle FL:                " + neue_fl‰che + "\n\naktuelle KT:                " + a_KT
							+ "aktuelle KT:                " + neue_kosten + "\n\naktuelle EG:                " + a_EG
							+ "aktuelle EG:                " + neue_etage + "\n\naktuelle BK:                " + a_BK
							+ "aktuelle BK:                " + neue_balkon + "\n\naktuelle FBH:              " + a_FBH
							+ "aktuelle FBH:              " + neue_fuﬂbodenheizung + "\n\naktuelle AS:                 "
							+ a_AS + "aktuelle AS:                 " + neue_aussicht
							+ "\n\naktuelle ST:                 " + a_ST + "aktuelle ST:                 " + neue_status
							+ "\n\naktuelle LRDT:            " + a_LRDT + "aktuelle LRDT:            "
							+ neue_letzesRenovierungsdatum + "\n\naktuelle RA:                " + a_RA
							+ "aktuelle RA:                " + neue_renovierungsanzahl
							+ "\n\naktuelle LRI:                " + a_LRI + "aktuelle LRI:                "
							+ neue_letzteRenovierung_Details + "\n\naktuelle ZM:                " + a_ZM
							+ "aktuelle ZM:                " + neue_zugeordneterMitarbeiter
							+ "\n\naktueller MINN:                " + a_MINN + "neuer MINN:                 "
							+ neue_Mieternachname + "\n\naktueller MIN:                " + a_MIN
							+ "neuer MIN:                 " + neue_Mietername, "Wohnungserstellung",
							JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons);

					if (ok == 0) {
						neueID = int_eingabe(buttons, ok);
						for (Wohnung wohnung : flatList) {
							if (wohnung.getWohnungsID() == neueID) {

								String[] knopf = { "Ok" };

								JOptionPane.showOptionDialog(null,
										"Die Wohnung mit der Nummer: " + "'" + neueID + "'" + " existiert bereits!",
										"Wohnungserstellung", JOptionPane.WARNING_MESSAGE, 0, null, knopf, knopf);
								neueID = -100;
								break;
							}
						}
					}
					if (ok == 1) {
						neue_zimmeranzahl = int_eingabe(buttons, ok);
					}
					if (ok == 2) {
						neue_fl‰che = double_eingabe(buttons, ok);
					}
					if (ok == 3) {
						neue_kosten = double_eingabe(buttons, ok);
					}
					if (ok == 4) {
						neue_etage = int_eingabe(buttons, ok);
					}
					if (ok == 5) {
						neue_balkon = boolean_eingabe(buttons, ok);
					}
					if (ok == 6) {
						neue_fuﬂbodenheizung = boolean_eingabe(buttons, ok);
					}
					if (ok == 7) {
						neue_aussicht = String_eingabe(buttons, ok);
					}
					if (ok == 8) {
						neue_status = String_eingabe(buttons, ok);
					}
					if (ok == 9) {
						neue_letzesRenovierungsdatum = String_eingabe(buttons, ok);
					}
					if (ok == 10) {
						neue_renovierungsanzahl = int_eingabe(buttons, ok);
					}
					if (ok == 11) {
						neue_letzteRenovierung_Details = String_eingabe(buttons, ok);
					}
					if (ok == 12) {
						neue_zugeordneterMitarbeiter = mitarbeiter_eingabe(buttons, ok);
					}
					if (ok == 13) {
						neue_Mieternachname = String_eingabe(buttons, ok);
					}
					if (ok == 14) {
						neue_Mietername = String_eingabe(buttons, ok);
					}
					if (ok == 15) {
						bearbeitungsVorgang = false;
						
						//wenn beim bearbeiten eine Wohnung ausgew‰hlt wird, die jemanden gehˆrt, du aber jemand anderen ausw‰hlst, der diese Wohnung ¸bernehmen mˆchte, 
						// dann setzte eine '0' in dem Mieterprofil an der Stelle seiner WOhnung, da er jetzt keine mehr besitzt
						for (Mieter owner : ownerList) {
							if (owner.getWohnungsnummer() == neueID) {
								owner.setWohnungsnummer(0);
							}
							
							if (flat.getWohnungsID() == aktuelleID) {
								flat.getOwner().setVorname("");
								flat.getOwner().setName("");
							}

							// wenn der Vor- und Nachname in der Mieterliste mit den ver‰nderten Namen ¸bereinstimmen, also sie somit existieren, dann 
							// ver‰ndere im Bezug zur WOhnung den Besitzer 
							// ver‰ndere in der Mieterliste den Namen und die Wohnung
							if (neue_Mietername.equals(owner.getName())
									&& neue_Mieternachname.equals(owner.getName())) {
								flat.getOwner().setVorname(neue_Mieternachname);
								flat.getOwner().setName(neue_Mietername);
								owner.setVorname(neue_Mieternachname);
								owner.setName(neue_Mietername);
								owner.setWohnungsnummer(neueID);
							} 							

							flat.setWohnungsID(neueID);
							flat.setZimmeranzahl(neue_zimmeranzahl);
							flat.setFl‰che(neue_fl‰che);
							flat.setKosten(neue_kosten);
							flat.setEtage(neue_etage);
							flat.setBalkon(neue_balkon);
							flat.setFuﬂbodenheizung(neue_fuﬂbodenheizung);
							flat.setAussicht(neue_aussicht);
							flat.setStatus(neue_status);
							flat.setLetztesRenovierungsdatum(neue_letzesRenovierungsdatum);
							flat.setRenovierungsanzahl(neue_renovierungsanzahl);
							flat.setLetzeRenovierung_Details(neue_letzteRenovierung_Details);
							flat.getZugeordneterMitarbeiter().setName(neue_zugeordneterMitarbeiter);
						}
					}
					if (ok == 16) {
						bearbeitungsVorgang = false;
					} else {
						System.out.println("");
					}

				}
			}

		}
	}

	private String l‰nge_anpassen(String wort) {

		int abzug = wort.length();
		if (wort.length() < 90) {
			while (wort.length() < (90 - abzug)) {
				wort = wort + " ";

			}
		}
		return wort;

	}

	public String mitarbeiter_eingabe(String[] buttons, int ok) {

		JOptionPane jop = new JOptionPane();
		jop.setWantsInput(true);
		jop.setMessage("Eingabe vom Feld: " + buttons[ok]);
		// in der Klammer den Namen des Fensters eingeben
		JDialog dialog = jop.createDialog("Wohnungserstellung");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);

		String eingabe = jop.getInputValue() == JOptionPane.UNINITIALIZED_VALUE ? null : (String) jop.getInputValue();
		String bearbeitungsknopf = eingabe;
		return bearbeitungsknopf;

	}

	public int int_eingabe(String[] buttons, int ok) {
		JOptionPane jop = new JOptionPane();
		jop.setWantsInput(true);
		jop.setMessage("Eingabe vom Feld: " + buttons[ok]);
		// in der Klammer den Namen des Fensters eingeben
		JDialog dialog = jop.createDialog("Wohnungserstellung");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);

		String eingabe = jop.getInputValue() == JOptionPane.UNINITIALIZED_VALUE ? null : (String) jop.getInputValue();
		int bearbeitungsknopf = Integer.parseInt(eingabe);
		return bearbeitungsknopf;
	}

	public String String_eingabe(String[] buttons, int ok) {
		JOptionPane jop = new JOptionPane();
		jop.setWantsInput(true);
		jop.setMessage("Eingabe vom Feld: " + buttons[ok]);
		// in der Klammer den Namen des Fensters eingeben
		JDialog dialog = jop.createDialog("Wohnungserstellung");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);

		String eingabe = jop.getInputValue() == JOptionPane.UNINITIALIZED_VALUE ? null : (String) jop.getInputValue();
		String bearbeitungsknopf = eingabe;
		return bearbeitungsknopf;
	}

	public boolean boolean_eingabe(String[] buttons, int ok) {
		JOptionPane jop = new JOptionPane();
		jop.setWantsInput(true);
		jop.setMessage("Eingabe vom Feld: " + buttons[ok]);
		// in der Klammer den Namen des Fensters eingeben
		JDialog dialog = jop.createDialog("Wohnungserstellung");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);

		boolean bearbeitungsknopf = false;
		String eingabe = jop.getInputValue() == JOptionPane.UNINITIALIZED_VALUE ? null : (String) jop.getInputValue();
		if (eingabe.equals("vorhanden")) {
			bearbeitungsknopf = true;
		}
		if (eingabe.equals("nicht vorhanden")) {
			bearbeitungsknopf = false;
		}
		return bearbeitungsknopf;
	}

	public double double_eingabe(String[] buttons, int ok) {

		JOptionPane jop = new JOptionPane();
		jop.setWantsInput(true);
		jop.setMessage("Eingabe vom Feld: " + buttons[ok]);
		// in der Klammer den Namen des Fensters eingeben
		JDialog dialog = jop.createDialog("Wohnungserstellung");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);

		String eingabe = jop.getInputValue() == JOptionPane.UNINITIALIZED_VALUE ? null : (String) jop.getInputValue();

		double bearbeitungsknopf = Double.parseDouble(eingabe);
		return bearbeitungsknopf;
	}
}
