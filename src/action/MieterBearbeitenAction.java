package action;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import hilfsklassen.Adresse;
import hilfsklassen.Datum;
import menue.MenueManager;
import objekte.Mieter;
import objekte.Wohnung;

public class MieterBearbeitenAction extends MenueManager implements Action {

	@Override
	public void action() {

		Scanner s = new Scanner(System.in);
		System.out.println(
				"\nWählen Sie den Mieter (ID) aus, den Sie bearbeiten möchten!\n");

		for (Mieter owner : ownerList) {
			System.out.println(owner.getName() + "; " + owner.getVorname() + "  ID: " + owner.getKundenID());
		}

		try {
			int zu_bearbeitenden_mieter = s.nextInt();

			boolean bearbeitungsVorgang = true;

			String a_kID = "";
			String a_NN = "";
			String a_N = "";
			Datum a_GD;
			String a_W = "";
			String a_EM = "";
			String a_A = "";
			String a_T = "";
			String a_R = "";

			int aktuelleKID = 0;
			int neueKID = 0;

			String aktuellerNachname = "";
			String neuerNachname = "";

			String aktuelleRolle = "";
			String neueRolle = "";

			String aktuellerName = "";
			String neuerName = "";

			Datum aktuelleGD;
			Datum neueGD;

			int aktuelleWohnung = -100;
			int neueWohnung = -100;

			String aktuelleEMail = "";
			String neueEMail = "";

			Adresse aktuelleAdresse;
			Adresse neueAdresse;

			String aktuelleTelefon = "";
			String neueTelefon = "";

			for (Mieter owner : ownerList) {
				if (zu_bearbeitenden_mieter == owner.getKundenID()) {

					aktuelleKID = owner.getKundenID();
					neueKID = aktuelleKID;

					aktuellerNachname = owner.getName();
					neuerNachname = aktuellerNachname;

					aktuellerName = owner.getVorname();
					neuerName = aktuellerName;

					aktuelleGD = owner.getGeburtsdatum();
					neueGD = aktuelleGD;

					aktuelleWohnung = owner.getWohnungsnummer();
					neueWohnung = aktuelleWohnung;

					aktuelleEMail = owner.getEmail();
					neueEMail = aktuelleEMail;

					aktuelleAdresse = owner.getAdresse();
					neueAdresse = aktuelleAdresse;

					aktuelleTelefon = owner.getTelefonnummer();
					neueTelefon = aktuelleTelefon;

					aktuelleRolle = owner.getRolle();
					neueRolle = aktuelleRolle;

					// Variablen zur verschönerten Ausgabe
					a_kID = "" + owner.getKundenID();
					a_kID = länge_anpassen(a_kID);

					a_NN = aktuellerNachname;
					a_NN = länge_anpassen(a_NN);

					a_N = aktuellerName;
					a_N = länge_anpassen(a_N);

					a_GD = owner.getGeburtsdatum();
					a_GD = länge_anpassen(a_GD);

					a_W = "" + owner.getWohnungsnummer();
					a_W = länge_anpassen(a_W);

					a_EM = aktuelleEMail;
					a_EM = länge_anpassen(a_EM);

					a_A = aktuelleAdresse;
					a_A = länge_anpassen(a_A);

					a_T = aktuelleTelefon;
					a_T = länge_anpassen(a_T);

					a_R = aktuelleRolle;
					a_R = länge_anpassen(a_R);
				}
			}

			while (bearbeitungsVorgang == true) {

				System.out.println("Kunden ID:       " + a_kID + "Kunden ID:            " + a_kID);
				System.out.println("Nachname:        " + a_NN + "neuer Nachname:       " + neuerNachname);
				System.out.println("Name:            " + a_N + "neuer Name:           " + neuerName);
				System.out.println("Geburtsdatum:    " + a_GD + "Geburtsdatum:         " + a_GD);
				System.out.println("Wohnung:         " + a_W + "Wohnung:              " + neueWohnung);
				System.out.println("E-Mail:          " + a_EM + "neue E-Mail:          " + neueEMail);
				System.out.println("Adresse:         " + a_A + "neue Adresse:         " + neueAdresse);
				System.out.println("Telefonnummer:   " + a_T + "neue Telefonnummer:   " + neueTelefon);
				System.out.println("Rolle:           " + a_R + "neue Rolle:           " + neueRolle);
				System.out.println("");

				Scanner t = new Scanner(System.in);
				System.out.println(
						"............................... Wählen Sie die zu bearbeitende Eigenschaft aus! ..............................."
								+ "\n Drücke '1' für Nachname  " + "\n Drücke '2' für Name  "
								+ "\n Drücke '3' für Wohnung  " + "\n Drücke '4' für E-Mail  "
								+ "\n Drücke '5' für Adresse  " + "\n Drücke '6' für Telefon  "
								+ "\n Drücke '7' für Rolle  " + "\n Drücke '8' für bestätigen  "
								+ "\n Drücke '0' für abbruch der Suche!\n");

				try {
					int änderung = t.nextInt();

					if (änderung == 0) {
						bearbeitungsVorgang = false;
					}
					if (änderung == 1) {
						Scanner u = new Scanner(System.in);
						String neu = u.next();
						if (neu.equals("" + 0)) {
							neu = aktuellerNachname;
						} else {
							neuerNachname = neu;
						}
					}
					if (änderung == 2) {
						Scanner u = new Scanner(System.in);
						String neu = u.next();
						if (neu.equals("" + 0)) {
							neu = aktuellerName;
						} else {
							neuerName = neu;
						}
					}
					if (änderung == 3) {
						Scanner u = new Scanner(System.in);
						try {
							int neu = u.nextInt();

							if (neu == 0) {
								neu = aktuelleWohnung;
							} else {
								int nichtVorhanden = 0;
								for (Mieter mt : ownerList) {
									for (Wohnung flat : flatList) {

										// nur wenn die Wohnung von keinem
										// anderen
										// Mieter
										// belegt
										// ist und die Wohnung existiert
										if (mt.getWohnungsnummer() != neu && neu == flat.getWohnungsID()) {
											nichtVorhanden = 1;

										}
										if (mt.getWohnungsnummer() == neu && flat.getStatus().equals("vermietet")) {
											nichtVorhanden = 2;

										}
									}
								}
								if (nichtVorhanden == 1) {
									neueWohnung = neu;
								}
								if (nichtVorhanden == 2) {
									System.out.println(
											"------------------------------- Wohnung bereits von einem anderen Mieter belegt! -------------------------------");
									Scanner v = new Scanner(System.in);
									System.out.println(
											"\nTrotzdem den Mieter mit zu dieser Wohnung eintragen? \n Drücke '1' für JA \n Drücke '2' für NEIN");
									int entscheidung = v.nextInt();
									if (entscheidung == 1) {
										neueWohnung = neu;
									} else {
									}

								}
								if (nichtVorhanden != 2 && nichtVorhanden != 1) {
									System.out.println(
											"------------------------------- Fehler! Wohnung existiert nicht! -------------------------------");
								}
							}

						} catch (InputMismatchException e) {
							System.out.println(
									"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
						}
					}
					if (änderung == 4) {
						Scanner u = new Scanner(System.in);
						String neu = u.next();
						if (neu.equals("" + 0)) {
							neu = aktuelleEMail;
						} else {
							neueEMail = neu;
						}
					}
					if (änderung == 5) {
						Scanner u = new Scanner(System.in);
						Adresse neu = u.next();
						if (neu.equals("" + 0)) {
							neu = aktuelleAdresse;
						} else {
							neueAdresse = neu;
						}
					}
					if (änderung == 6) {
						Scanner u = new Scanner(System.in);
						String neu = u.next();
						if (neu.equals("" + 0)) {
							neu = aktuelleTelefon;
						} else {
							neueTelefon = neu;
						}
					}
					if (änderung == 7) {
						Scanner u = new Scanner(System.in);
						String neu = u.next();
						if (neu.equals("" + 0)) {
							neu = aktuelleRolle;
						} else {
							neueRolle = neu;
						}
					}
					if (änderung == 8) {
						bearbeitungsVorgang = false;
						
//						int nichtVorhanden = 0;
//						for (Mieter mt : ownerList) {
//							for (Wohnung flat : flatList) {
//
//								// setze wenn die bearbeitung beendet wurde den status der wohnung auf vermietet
//								if (mt.getWohnungsnummer() != neueWohnung && neueWohnung == flat.getWohnungsID() && flat.getStatus().equals("frei")) {
//								flat.setStatus("vermietet");
//								}
//
//							}
//						}

						if (neueRolle.equals("Mieter")) {

							for (Mieter owner : ownerList) {
								if (zu_bearbeitenden_mieter == owner.getKundenID()) {
									owner.setName(neuerNachname);
									owner.setVorname(neuerName);
									owner.setEmail(neueEMail);
									owner.setAdresse(neueAdresse);
									owner.setTelefonnummer(neueTelefon);
									owner.setWohnungsnummer(neueWohnung);
								}
							}
						} 
						
						else {

							Iterator<Mieter> iter = ownerList.iterator();

							while (iter.hasNext()) {
								Mieter str = iter.next();

								if (str.getKundenID() == neueKID) {
									iter.remove();
								}
							}
						}
					}
				} catch (InputMismatchException e) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
				}
			}
		} catch (InputMismatchException e) {
			System.out.println(
					"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
		}
	}

	private Datum länge_anpassen(Datum a_GD) {

		int abzug = a_GD.length();
		if (a_GD.length() < 30) {
			while (a_GD.length() < 30) {
				a_GD = a_GD + " ";
			}
		}
		return a_GD;
	}
}
