package mietverwaltung.action;

import java.util.InputMismatchException;
import java.util.Scanner;

import mietverwaltung.Adresse;
import mietverwaltung.Datum;
import mietverwaltung.Mieter;
import mietverwaltung.Mitarbeiter;
import mietverwaltung.Wohnung;
import mietverwaltung.menu.MenuManager;

public class WohnungBearbeitenAction extends MenuManager implements Action {

    @Override
    public void action() {

        System.out.println("________________________________________ Wohnung bearbeiten ________________________________________");

        Scanner s = new Scanner(System.in);
        System.out.println("\nW�hlen Sie die Wohnung (Wohnungsnummer) aus, die Sie bearbeiten m�chten!\n");

        try {
            int zu_bearbeitende_wohnung = s.nextInt();

            boolean bearbeitungsVorgang = true;
            boolean wohnungseingabe_erfolgreich = false;

            String[] buttons = { "Wohnungsnummer", "Zimmeranzahl", "Fl�che", "Kosten", "Etage", "Balkon", "Fu�bodenheizung", "Aussicht", "Adresse", "letztes Renovierungsdatum", "Renovierungsanzahl", "letztes Renovierungsdetails", "zugeordneten Mitarbeiter" };

            String aID = "";
            String a_ZA = "";
            String a_FL = "";
            String a_KT = "";
            String a_EG = "";
            String a_BK = "";
            String a_FBH = "";
            String a_AS = "";
            Adresse a_ADR = null;
            String a_ST = "";
            Datum a_LRDT = null;
            String a_RA = "";
            String a_LRI = "";
            Mitarbeiter a_ZM = null;

            int aktuelleID = 0;
            int neueID = 0;

            int aktuelle_zimmeranzahl = 0;
            int neue_zimmeranzahl = 0;

            double aktuelle_fl�che = 0.0;
            double neue_fl�che = 0.0;

            double aktuelle_kosten = 0.0;
            double neue_kosten = 0.0;

            int aktuelle_etage = 0;
            int neue_etage = 0;

            boolean aktuelle_balkon = false;
            boolean neue_balkon = false;

            boolean aktuelle_fu�bodenheizung = false;
            boolean neue_fu�bodenheizung = false;

            String aktuelle_aussicht = "";
            String neue_aussicht = "";

            Adresse aktuelle_adresse = null;
            Adresse neue_adresse = null;

            String aktuelle_status = "";
            String neue_status = "";

            Datum aktuelle_letztesRenovierungsdatum = null;
            Datum neue_letzesRenovierungsdatum = null;

            int aktuelle_renovierungsanzahl = 0;
            int neue_renovierungsanzahl = 0;

            String aktuelle_letzeRenovierung_Details = "";
            String neue_letzeRenovierung_Details = "";

            Mitarbeiter aktuelle_zugeordneterMitarbeiter = null;
            Mitarbeiter neue_zugeordneterMitarbeiter = null;

            String ADR_Leerzeichen = "";
            String LRDT_Leerzeichen = "";
            String ZM_Leerzeichen = "";

            for (Wohnung flat : MenuManager.flatList) {
                if (zu_bearbeitende_wohnung == flat.getWohnungsID()) {

                    wohnungseingabe_erfolgreich = true;

                    aktuelleID = flat.getWohnungsID();
                    neueID = aktuelleID;

                    aktuelle_zimmeranzahl = flat.getZimmeranzahl();
                    neue_zimmeranzahl = aktuelle_zimmeranzahl;

                    aktuelle_fl�che = flat.getFl�che();
                    neue_fl�che = aktuelle_fl�che;

                    aktuelle_kosten = flat.getKosten();
                    neue_kosten = aktuelle_kosten;

                    aktuelle_etage = flat.getEtage();
                    neue_etage = aktuelle_etage;

                    aktuelle_balkon = flat.getBalkon();
                    neue_balkon = aktuelle_balkon;

                    aktuelle_fu�bodenheizung = flat.getFu�bodenheizung();
                    neue_fu�bodenheizung = aktuelle_fu�bodenheizung;

                    aktuelle_aussicht = flat.getAussicht();
                    neue_aussicht = aktuelle_aussicht;

                    aktuelle_adresse = flat.getAdresse();
                    neue_adresse = aktuelle_adresse;

                    aktuelle_status = flat.getStatus();
                    neue_status = aktuelle_status;

                    aktuelle_letztesRenovierungsdatum = flat.getLetztesRenovierungsdatum();
                    neue_letzesRenovierungsdatum = aktuelle_letztesRenovierungsdatum;

                    aktuelle_renovierungsanzahl = flat.getRenovierungsanzahl();
                    neue_renovierungsanzahl = aktuelle_renovierungsanzahl;

                    aktuelle_letzeRenovierung_Details = flat.getLetzeRenovierung_Details();
                    neue_letzeRenovierung_Details = aktuelle_letzeRenovierung_Details;

                    aktuelle_zugeordneterMitarbeiter = flat.getZugeordneterMitarbeiter();
                    neue_zugeordneterMitarbeiter = aktuelle_zugeordneterMitarbeiter;

                    // Variablen zur versch�nerten Ausgabe
                    aID = "" + aktuelleID;
                    aID = l�nge_anpassen(aID);

                    a_ZA = "" + aktuelle_zimmeranzahl;
                    a_ZA = l�nge_anpassen(a_ZA);

                    a_FL = "" + aktuelle_fl�che;
                    a_FL = l�nge_anpassen(a_FL);

                    a_KT = "" + aktuelle_kosten;
                    a_KT = l�nge_anpassen(a_KT);

                    a_EG = "" + aktuelle_etage;
                    a_EG = l�nge_anpassen(a_EG);

                    a_BK = "" + aktuelle_balkon;
                    a_BK = l�nge_anpassen(a_BK);

                    a_FBH = "" + aktuelle_fu�bodenheizung;
                    a_FBH = l�nge_anpassen(a_FBH);

                    a_AS = aktuelle_aussicht;
                    a_AS = l�nge_anpassen(a_AS);

                    a_ADR = aktuelle_adresse;
                    ADR_Leerzeichen = l�nge_anpassen_Adresse(a_ADR);

                    a_ST = aktuelle_status;
                    a_ST = l�nge_anpassen(a_ST);

                    a_LRDT = aktuelle_letztesRenovierungsdatum;
                    LRDT_Leerzeichen = l�nge_anpassen_Datum(a_LRDT);

                    a_RA = "" + aktuelle_renovierungsanzahl;
                    a_RA = l�nge_anpassen(a_RA);

                    a_LRI = aktuelle_letzeRenovierung_Details;
                    a_LRI = l�nge_anpassen(a_LRI);

                    a_ZM = aktuelle_zugeordneterMitarbeiter;
                    ZM_Leerzeichen = l�nge_anpassen_Mitarbeiter(a_ZM);

                }
            }

            if (wohnungseingabe_erfolgreich == true) {
                while (bearbeitungsVorgang == true) {

                    Scanner t = new Scanner(System.in);

                    System.out.println("�nderungs�bersicht:");
                    System.out.println("Dr�cken Sie die Zahl vor der Zeile, um eine �nderung vorzunehmen!");
                    System.out.println("1.  aktuelle Wohnungsnummer:            " + aID + "neue Wohnungsnummer:            " + neueID);
                    System.out.println("2.  aktuelle Zimmeranzahl:              " + a_ZA + "neue Zimmeranzahl:              " + neue_zimmeranzahl);
                    System.out.println("3.  aktuelle Fl�che:                    " + a_FL + "neue Fl�che:                    " + neue_fl�che);
                    System.out.println("4.  aktuelle Kosten:                    " + a_KT + "neue Kosten:                    " + neue_kosten);
                    System.out.println("5.  aktuelle Etage:                     " + a_EG + "neue Etage:                     " + neue_etage);
                    System.out.println("6.  aktuelle Balkon:                    " + a_BK + "neue Balkon:                    " + neue_balkon);
                    System.out.println("7.  aktuelle Fu�bodenheizung:           " + a_FBH + "neue Fu�bodenheizung:           " + neue_fu�bodenheizung);
                    System.out.println("8.  aktuelle Aussicht:                  " + a_AS + "neue Aussicht:                  " + neue_aussicht);
                    System.out.println("9.  aktuelle Adresse:                   " + a_ADR + ADR_Leerzeichen + "neue Adresse:                   " + neue_adresse);
                    System.out.println("10. letztes Renovierungsdatum:          " + a_LRDT + LRDT_Leerzeichen + "ge�ndertes Renovierungsdatum:   " + neue_letzesRenovierungsdatum);
                    System.out.println("11. aktuelle Renovierungsanzahl:        " + a_RA + "neue Renovierungsanzahl:        " + neue_renovierungsanzahl);
                    System.out.println("12. letzte Renvierungsdetails:          " + a_LRI + "ge�nderte Renovierungsdetails:  " + neue_letzeRenovierung_Details);
                    System.out.println("13. aktuelle zugeordneten Mitarbeiter:  " + a_ZM + ZM_Leerzeichen + "neue zugeordneten Mitarbeiter:  " + neue_zugeordneterMitarbeiter);
                    System.out.println("14. Best�tigen");
                    System.out.println("0.  Abbruch");
                    System.out.println("");

                    try {
                        int ok = t.nextInt();

                        if (ok == 0) {
                            bearbeitungsVorgang = false;
                        }

                        if (ok == 1) {
                            int neu = int_eingabe(buttons, ok);
                            int nichtVorhanden = 0;
                            for (Wohnung wohnung : MenuManager.flatList) {
                                if (wohnung.getWohnungsID() != neu) {
                                    nichtVorhanden = 1;
                                }
                                if (neu == 0) {
                                    nichtVorhanden = 2;
                                }
                            }
                            if (nichtVorhanden == 1) {
                                System.out.println("Die Wohnung mit der Nummer: " + "'" + neu + "'" + " existiert nicht!\n");
                                neu = neueID;
                            }
                            if (nichtVorhanden == 2) {
                                neu = neueID;
                            } else {
                                neueID = neu;
                            }
                        }
                        if (ok == 2) {

                            int neu = int_eingabe(buttons, ok);
                            if (neu == 0) {
                                neu = neue_zimmeranzahl;
                            } else {
                                neue_zimmeranzahl = neu;
                            }
                        }
                        if (ok == 3) {
                            double neu = double_eingabe(buttons, ok);
                            if (neu == 0) {
                                neu = neue_fl�che;
                            } else {
                                neue_fl�che = neu;
                            }
                        }
                        if (ok == 4) {

                            double neu = double_eingabe(buttons, ok);
                            if (neu == 0) {
                                neu = neue_kosten;
                            } else {
                                neue_kosten = neu;
                            }
                        }
                        if (ok == 5) {
                            int neu = int_eingabe(buttons, ok);
                            if (neu == 0) {
                                neu = neue_etage;
                            } else {
                                neue_etage = neu;
                            }
                        }
                        if (ok == 6) {
                            boolean neu = boolean_eingabe(buttons, ok);
                            if (neu != true || neu != false) {
                                neu = neue_balkon;
                            } else {
                                neue_balkon = neu;
                            }

                        }
                        if (ok == 7) {
                            boolean neu = boolean_eingabe(buttons, ok);
                            if (neu != true || neu != false) {
                                neu = neue_fu�bodenheizung;
                            } else {
                                neue_fu�bodenheizung = neu;
                            }
                        }
                        if (ok == 8) {
                            String neu = String_eingabe(buttons, ok);
                            if (neu.equals("" + 0)) {
                                neu = neue_aussicht;
                            } else {
                                neue_aussicht = neu;
                            }
                        }
                        if (ok == 9) {
                            String[] auswahl = { "Stra�e", "Hausnummer", "Platz", "Stadt" };
                            int z�hler = 1;
                            String stra�e = String_eingabe(auswahl, z�hler);
                            z�hler = 2;
                            int hausnummer = int_eingabe(auswahl, z�hler);
                            z�hler = 3;
                            int platz = int_eingabe(auswahl, z�hler);
                            z�hler = 4;
                            String stadt = String_eingabe(auswahl, z�hler);

                            if (stra�e.equals("" + 0) || hausnummer == 0 || hausnummer == -100 || platz == 0 || platz == -100 || stadt.equals("" + 0)) {
                            } else {
                                neue_adresse = new Adresse(stra�e, hausnummer, platz, stadt);
                            }

                        }
                        if (ok == 10) {

                            String[] auswahl = { "Tag", "Monat", "Jahr" };
                            int z�hler = 1;
                            int tag = int_eingabe(auswahl, z�hler);
                            z�hler = 2;
                            int monat = int_eingabe(auswahl, z�hler);
                            z�hler = 3;
                            int jahr = int_eingabe(auswahl, z�hler);

                            if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
                            } else {
                                neue_letzesRenovierungsdatum = new Datum(tag, monat, jahr);
                            }
                        }
                        if (ok == 11) {
                            int neu = int_eingabe(buttons, ok);
                            if (neu == 0) {
                                neu = neue_renovierungsanzahl;
                            } else {
                                neue_renovierungsanzahl = neu;
                            }
                        }
                        if (ok == 12) {
                            String neu = String_eingabe(buttons, ok);
                            if (neu.equals("" + 0)) {
                                neu = neue_letzeRenovierung_Details;
                            } else {
                                neue_letzeRenovierung_Details = neu;
                            }
                        }
                        if (ok == 13) {
                            String[] auswahl = { "ID" };
                            int z�hler = 1;
                            int ID = int_eingabe(auswahl, z�hler);
                            String name = "";
                            String vorname = "";

                            for (Mitarbeiter worker : MenuManager.workerList) {
                                if (worker.getMitarbeiterID() == ID) {
                                    name = worker.getName();
                                    vorname = worker.getVorname();
                                } else {
                                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nMitarbeiter mti der ID " + ID + " existiert nicht!\n");
                                }
                            }

                            if (ID == 0 || ID == -100) {
                            } else {
                                neue_zugeordneterMitarbeiter = new Mitarbeiter(ID, name, vorname);
                            }
                        }
                        if (ok == 14) {
                            bearbeitungsVorgang = false;

                            for (Wohnung flat : MenuManager.flatList) {
                                // wenn beim bearbeiten eine Wohnung ausgew�hlt
                                // wird, die jemanden geh�rt,
                                // dann wohnt der Mieter in der WOhnung mit der
                                // eben angepassten Wohnungsnummer
                                for (Mieter owner : MenuManager.ownerList) {
                                    if (owner.getWohnungsnummer() == aktuelleID && neueID != aktuelleID) {
                                        owner.setWohnungsnummer(neueID);
                                    }

                                    flat.setWohnungsID(neueID);
                                    flat.setZimmeranzahl(neue_zimmeranzahl);
                                    flat.setFl�che(neue_fl�che);
                                    flat.setKosten(neue_kosten);
                                    flat.setEtage(neue_etage);
                                    flat.setBalkon(neue_balkon);
                                    flat.setFu�bodenheizung(neue_fu�bodenheizung);
                                    flat.setAdresse(neue_adresse);
                                    flat.setAussicht(neue_aussicht);
                                    flat.setLetztesRenovierungsdatum(neue_letzesRenovierungsdatum);
                                    flat.setRenovierungsanzahl(neue_renovierungsanzahl);
                                    flat.setLetzeRenovierung_Details(neue_letzeRenovierung_Details);
                                    flat.setZugeordneterMitarbeiter(neue_zugeordneterMitarbeiter);
                                }
                            }
                        }
                        if (ok > 14) {
                            System.out.println("\n------------------------------- Fehler! ------------------------------- \nKeine Option vorhanden!\n");
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
                    }
                }
            }
        }

        catch (InputMismatchException e) {
            System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
        }
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

    private String l�nge_anpassen_Datum(final Datum a_GD) {

        String leerzeichen = "";

        String jahr = "" + a_GD.getJahr();
        int l_J = jahr.length();

        String monat = "" + a_GD.getMonat();
        int l_M = monat.length();

        String tag = "" + a_GD.getTag();
        int l_T = tag.length();

        int abzug = l_J + l_M + l_T + 2; // +2 f�r die Punkte zwischen den
                                         // Komponenten
        if (abzug < 50) {
            while (abzug < 50) {
                leerzeichen = leerzeichen + " ";
                abzug += 1;
            }
        }
        return leerzeichen;
    }

    private String l�nge_anpassen_Adresse(final Adresse a_A) {

        String leerzeichen = "";

        String hausnummer = "" + a_A.getHausnummer();
        int l_HN = hausnummer.length();

        String platz = "" + a_A.getPlz();
        int l_P = platz.length();

        String stadt = a_A.getStadt();
        int l_ST = stadt.length();

        String stra�e = a_A.getStrasse();
        int l_SR = stra�e.length();

        int abzug = l_HN + l_P + l_SR + l_ST + 3; // +3 f�r die Leerzeichen
                                                  // zwischen den Komponenten
        if (abzug < 50) {
            while (abzug < 50) {
                leerzeichen = leerzeichen + " ";
                abzug += 1;
            }
        }
        return leerzeichen;
    }

    private String l�nge_anpassen_Mitarbeiter(final Mitarbeiter a_ZM) {

        String leerzeichen = "";

        String ID = "" + a_ZM.getMitarbeiterID();
        int l_ID = ID.length();

        String name = "" + a_ZM.getName();
        int l_N = name.length();

        String vorname = a_ZM.getVorname();
        int l_VN = vorname.length();

        int abzug = l_ID + l_N + l_VN + 2; // +2 f�r die Leerzeichen
                                           // zwischen den Komponenten
        if (abzug < 50) {
            while (abzug < 50) {
                leerzeichen = leerzeichen + " ";
                abzug += 1;
            }
        }
        return leerzeichen;
    }

    public int int_eingabe(final String[] buttons, final int ok) {

        System.out.println("Erstellen: " + buttons[ok - 1]);
        Scanner s = new Scanner(System.in);
        int zahl = -100;
        try {
            zahl = s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
        }
        return zahl;
    }

    public String String_eingabe(final String[] buttons, final int ok) {
        System.out.println("Erstellen: " + buttons[ok - 1]);
        Scanner s = new Scanner(System.in);
        String wort = s.next();
        return wort;
    }

    public boolean boolean_eingabe(final String[] buttons, final int ok) {

        System.out.println("Erstellen: " + buttons[ok - 1]);
        Scanner s = new Scanner(System.in);
        boolean entscheidung = false;
        try {
            entscheidung = s.nextBoolean();
        } catch (InputMismatchException e) {
            System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
        }
        return entscheidung;
    }

    public double double_eingabe(final String[] buttons, final int ok) {

        System.out.println("Erstellen: " + buttons[ok - 1]);
        Scanner s = new Scanner(System.in);
        double zahl = -100.00;
        try {
            zahl = s.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
        }
        return zahl;
    }
}
