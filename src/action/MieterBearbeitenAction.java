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
				"\nW�hlen Sie den Mieter (ID) aus, den Sie bearbeiten m�chten!\n");

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

					// Variablen zur versch�nerten Ausgabe
					a_kID = "" + owner.getKundenID();
					a_kID = l�nge_anpassen(a_kID);

					a_NN = aktuellerNachname;
					a_NN = l�nge_anpassen(a_NN);

					a_N = aktuellerName;
					a_N = l�nge_anpassen(a_N);

					a_GD = owner.getGeburtsdatum();
					a_GD = l�nge_anpassen(a_GD);

					a_W = "" + owner.getWohnungsnummer();
					a_W = l�nge_anpassen(a_W);

					a_EM = aktuelleEMail;
					a_EM = l�nge_anpassen(a_EM);

					a_A = aktuelleAdresse;
					a_A = l�nge_anpassen(a_A);

					a_T = aktuelleTelefon;
					a_T = l�nge_anpassen(a_T);

					a_R = aktuelleRolle;
					a_R = l�nge_anpassen(a_R);
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
						"............................... W�hlen Sie die zu bearbeitende Eigenschaft aus! ..............................."
								+ "\n Dr�cke '1' f�r Nachname  " + "\n Dr�cke '2' f�r Name  "
								+ "\n Dr�cke '3' f�r Wohnung  " + "\n Dr�cke '4' f�r E-Mail  "
								+ "\n Dr�cke '5' f�r Adresse  " + "\n Dr�cke '6' f�r Telefon  "
								+ "\n Dr�cke '7' f�r Rolle  " + "\n Dr�cke '8' f�r best�tigen  "
								+ "\n Dr�cke '0' f�r abbruch der Suche!\n");

				try {
					int �nderung = t.nextInt();

					if (�nderung == 0) {
						bearbeitungsVorgang = false;
					}
					if (�nderung == 1) {
						Scanner u = new Scanner(System.in);
						String neu = u.next();
						if (neu.equals("" + 0)) {
							neu = aktuellerNachname;
						} else {
							neuerNachname = neu;
						}
					}
					if (�nderung == 2) {
						Scanner u = new Scanner(System.in);
						String neu = u.next();
						if (neu.equals("" + 0)) {
							neu = aktuellerName;
						} else {
							neuerName = neu;
						}
					}
					if (�nderung == 3) {
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
											"\nTrotzdem den Mieter mit zu dieser Wohnung eintragen? \n Dr�cke '1' f�r JA \n Dr�cke '2' f�r NEIN");
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
					if (�nderung == 4) {
						Scanner u = new Scanner(System.in);
						String neu = u.next();
						if (neu.equals("" + 0)) {
							neu = aktuelleEMail;
						} else {
							neueEMail = neu;
						}
					}
					if (�nderung == 5) {
						Scanner u = new Scanner(System.in);
						Adresse neu = u.next();
						if (neu.equals("" + 0)) {
							neu = aktuelleAdresse;
						} else {
							neueAdresse = neu;
						}
					}
					if (�nderung == 6) {
						Scanner u = new Scanner(System.in);
						String neu = u.next();
						if (neu.equals("" + 0)) {
							neu = aktuelleTelefon;
						} else {
							neueTelefon = neu;
						}
					}
					if (�nderung == 7) {
						Scanner u = new Scanner(System.in);
						String neu = u.next();
						if (neu.equals("" + 0)) {
							neu = aktuelleRolle;
						} else {
							neueRolle = neu;
						}
					}
					if (�nderung == 8) {
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

	private Datum l�nge_anpassen(Datum a_GD) {

		int abzug = a_GD.length();
		if (a_GD.length() < 30) {
			while (a_GD.length() < 30) {
				a_GD = a_GD + " ";
			}
		}
		return a_GD;
	}
}
