package mietverwaltung.action;

import java.util.InputMismatchException;
import java.util.Scanner;

import mietverwaltung.Adresse;
import mietverwaltung.Datum;
import mietverwaltung.Handwerkerauftrag;
import mietverwaltung.Wohnung;
import mietverwaltung.menu.MenuManager;

public class HandwerkerauftragBearbeitenAction extends MenuManager implements Action {

    @Override
    public void action() {

        System.out.println("________________________________________ Handwerkerauftrag bearbeiten ________________________________________");

        Scanner s = new Scanner(System.in);
        System.out.println("\nW�hlen Sie den Handwerkerauftrag (ID) aus, die Sie bearbeiten m�chten!\n");

        // Ausgabe aller Interessenten (ID, Name, Vorname) zur einfacheren Auswahl
        for (Handwerkerauftrag repair : MenuManager.currentManager.getRepairList()) {
            System.out.println(repair.getAuftragsID() + "; " + repair.getM�ngelbeschreibung());
        }

        // wenn die Eingabe korrekt (ohne Buchstaben) ist, dann
        // beginnt der Bearbeitungsvorgang
        try {
            String zu_bearbeitenden_handwerkerauftrag = s.next();

            boolean bearbeitungsVorgang = true;
            boolean handwerkerauftragEingabe_erfolgreich = false;
            String[] kategorie = { "Auftrags ID ", "Wohnungs ID", "Mitarbeiter ID", "M�ngelbeschreibung", "Status", "Eingangsdatum", "Fertigstellungsdatum" };

            // diese Variablen dienen sp�ter f�r eine tabellarische Ausgabe auf der Konsole
            String l�ngenAnpassung_auftragsID = "";
            String l�ngenAnpassung_wohnungsID = "";
            String l�ngenAnpassung_mitarbeiterID = "";
            String l�ngenAnpassung_m�ngelbeschreibung = "";
            String l�ngenAnpassung_status = "";

            // allgemeine Variablen
            // alte = aktuelle Werte
            // neue = neue/ver�nderten Werte
            String aktuelleAuftragsID = "";
            String neueAuftragsID = "";

            int aktuelleWohnungsID = 0;
            int neueWohnungsID = 0;

            int aktuelleMitarbeiterID = 0;
            int neueMitarbeiterID = 0;

            String aktuelleM�ngelbeschreibung = "";
            String neueM�ngelbeschreibung = "";

            String aktuellerStatus = "";
            String neuerStatus = "";

            Datum aktuellesEingangsdatum = null;
            Datum neuesEingangsdatum = null;

            Datum aktuellesFertigstellungsdatum = null;
            Datum neuesFertigstellungsdatum = null;

            String ED_Leerzeichen = "";
            String FD_Leerzeichen = "";

            // wenn die Eingabe der Interessenten-ID einer existierenden ID entspricht wird fortgefahren
            for (Handwerkerauftrag repair : MenuManager.currentManager.getRepairList()) {
                if (zu_bearbeitenden_handwerkerauftrag.equals(repair.getAuftragsID())) {

                    handwerkerauftragEingabe_erfolgreich = true;

                    aktuelleAuftragsID = repair.getAuftragsID();
                    neueAuftragsID = aktuelleAuftragsID;

                    aktuelleWohnungsID = repair.getWohnungsID();
                    neueWohnungsID = aktuelleWohnungsID;

                    aktuelleMitarbeiterID = repair.getMitarbeiterID();
                    neueMitarbeiterID = aktuelleMitarbeiterID;

                    aktuelleM�ngelbeschreibung = repair.getM�ngelbeschreibung();
                    neueM�ngelbeschreibung = aktuelleM�ngelbeschreibung;

                    aktuellerStatus = repair.getStatus();
                    neuerStatus = aktuellerStatus;

                    aktuellesEingangsdatum = repair.getEingangsdatum();
                    neuesEingangsdatum = aktuellesEingangsdatum;

                    aktuellesFertigstellungsdatum = repair.getFertigstellungsDatum();
                    neuesFertigstellungsdatum = aktuellesFertigstellungsdatum;

                    // Initialisierung der tabellarischen Variablen + Ausf�llung mit Leerzeichen (Umwandlung in die Tabelle)
                    l�ngenAnpassung_auftragsID = aktuelleAuftragsID;
                    l�ngenAnpassung_auftragsID = l�nge_anpassen(l�ngenAnpassung_auftragsID);

                    l�ngenAnpassung_wohnungsID = "" + aktuelleWohnungsID;
                    l�ngenAnpassung_wohnungsID = l�nge_anpassen(l�ngenAnpassung_wohnungsID);

                    l�ngenAnpassung_mitarbeiterID = "" + aktuelleMitarbeiterID;
                    l�ngenAnpassung_mitarbeiterID = l�nge_anpassen(l�ngenAnpassung_mitarbeiterID);

                    l�ngenAnpassung_m�ngelbeschreibung = aktuelleM�ngelbeschreibung;
                    l�ngenAnpassung_m�ngelbeschreibung = l�nge_anpassen(l�ngenAnpassung_m�ngelbeschreibung);

                    l�ngenAnpassung_status = aktuellerStatus;
                    l�ngenAnpassung_status = l�nge_anpassen(l�ngenAnpassung_status);

                    ED_Leerzeichen = l�nge_anpassen_Datum(aktuellesEingangsdatum);

                    FD_Leerzeichen = l�nge_anpassen_Datum(aktuellesFertigstellungsdatum);

                }
            }

            if (handwerkerauftragEingabe_erfolgreich == true) {
                while (bearbeitungsVorgang == true) {

                    System.out.println("Auftrags ID:          " + l�ngenAnpassung_auftragsID + "neue Auftrags ID:           " + neueAuftragsID);
                    System.out.println("Wohnungs ID:          " + l�ngenAnpassung_wohnungsID + "neue Wohnungs ID:           " + neueWohnungsID);
                    System.out.println("Mitarbeiter ID:       " + l�ngenAnpassung_mitarbeiterID + "neue Mitarbeiter ID:        " + neueMitarbeiterID);
                    System.out.println("M�ngelbeschreibung:   " + l�ngenAnpassung_m�ngelbeschreibung + "neue M�ngelbeschreibung:    " + neueM�ngelbeschreibung);
                    System.out.println("Status:               " + l�ngenAnpassung_status + "neuer Status:               " + neuerStatus);
                    System.out.println("Eingangsdatum:        " + aktuellesEingangsdatum + ED_Leerzeichen + "neues Eingangsdatum:        " + neuesEingangsdatum);
                    System.out.println("Fertigstellungsdatum: " + aktuellesFertigstellungsdatum + FD_Leerzeichen + "neues Fertigstellungsdatum: " + neuesFertigstellungsdatum);
                    System.out.println("");

                    Scanner t = new Scanner(System.in);
                    System.out.println("............................... W�hlen Sie die zu bearbeitende Eigenschaft aus! ..............................." + "\n Dr�cke '1' f�r Auftrags-ID  " + "\n Dr�cke '2' f�r Wohnungs-ID  " + "\n Dr�cke '3' f�r Mitarbeiter-ID  " + "\n Dr�cke '4' f�r M�ngelbeschreibung  " + "\n Dr�cke '5' f�r Status  " + "\n Dr�cke '6' f�r Eingangsdatum  "
                            + "\n Dr�cke '7' f�r Fertigstellungsdatum  " + "\n Dr�cke '8' f�r best�tigen  " + "\n Dr�cke '0' f�r abbruch der Suche!\n");

                    try {
                        int �nderung = t.nextInt();

                        if (�nderung == 0) {
                            bearbeitungsVorgang = false;
                        }
                        if (�nderung == 1) {
                            String eingabe = einlesen_Wort(kategorie, �nderung);
                            if (eingabe.equals(0)) {
                                neueAuftragsID = aktuelleAuftragsID;
                            } else {
                                neueAuftragsID = eingabe;
                            }
                        }
                        if (�nderung == 2) {
                            int eingabe = einlesen_Zahl(kategorie, �nderung);
                            if (eingabe == 0) {
                                neueWohnungsID = aktuelleWohnungsID;
                            } else {
                                neueWohnungsID = eingabe;
                            }
                        }
                        if (�nderung == 3) {
                            int eingabe = einlesen_Zahl(kategorie, �nderung);
                            if (eingabe == 0) {
                                neueMitarbeiterID = aktuelleMitarbeiterID;
                            } else {
                                neueMitarbeiterID = eingabe;
                            }
                        }
                        if (�nderung == 4) {
                            String eingabe = einlesen_Wort(kategorie, �nderung);
                            if (eingabe.equals("" + 0)) {
                                neueM�ngelbeschreibung = aktuelleM�ngelbeschreibung;
                            } else {
                                neueM�ngelbeschreibung = eingabe;
                            }
                        }
                        if (�nderung == 5) {
                            String[] auswahl = { "in Arbeit", "fertig" };
                            Scanner a = new Scanner(System.in);
                            System.out.println("Geben Sie die Zahl vom gew�nschten Status aus: " + "1" + auswahl[0] + "2" + auswahl[1] + "0" + " um abzubrechen");
                            int eingabe = a.nextInt();

                            if (eingabe == 1) {
                                neuerStatus = "in Arbeit";
                            }
                            if (eingabe == 2) {
                                neuerStatus = "fertig";
                            }

                            if (eingabe == 0) {
                                neuerStatus = aktuellerStatus;
                            } else {
                                System.out.println("------------------ Fehler -----------------\nEingabem�glichkeit nicht vorhanden!\n");
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
                                neuesEingangsdatum = aktuellesEingangsdatum;
                            } else {
                                neuesEingangsdatum = new Datum(tag, monat, jahr);
                            }
                        }
                        if (�nderung == 7) {
                            String[] auswahl = { "Tag", "Monat", "Jahr" };
                            int z�hler = 1;
                            int tag = einlesen_Zahl(auswahl, z�hler);
                            z�hler = 2;
                            int monat = einlesen_Zahl(auswahl, z�hler);
                            z�hler = 3;
                            int jahr = einlesen_Zahl(auswahl, z�hler);

                            if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
                                neuesFertigstellungsdatum = aktuellesFertigstellungsdatum;
                            } else {
                                neuesFertigstellungsdatum = new Datum(tag, monat, jahr);
                            }
                        }
                        if (�nderung == 8) {
                            bearbeitungsVorgang = false;

                            //							if (neuerStatus.equals("in Arbeit")) {

                            for (Wohnung flat : MenuManager.currentManager.getFlatList()) {
                                if (neueWohnungsID == flat.getWohnungsID()) {
                                    flat.setHandwerkerauftrag(new Handwerkerauftrag(neueAuftragsID));

                                }
                            }

                            for (Handwerkerauftrag repair : MenuManager.currentManager.getRepairList()) {
                                if (zu_bearbeitenden_handwerkerauftrag.equals(repair.getAuftragsID())) {
                                    repair.setAuftragsID(neueAuftragsID);
                                    repair.setWohnungsID(neueWohnungsID);
                                    repair.setMitarbeiterID(neueMitarbeiterID);
                                    repair.setM�ngelbeschreibung(neueM�ngelbeschreibung);
                                    repair.setStatus(neuerStatus);
                                    repair.setEingangsdatum(neuesEingangsdatum);
                                    repair.setFertigstellungsDatum(neuesFertigstellungsdatum);
                                }
                            }
                            //							}
                            if (neuerStatus.equals("fertig")) {
                                //TODO: schlie�en und speichern
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
                    }
                }
            } else {
                System.out.println("------------------------------- Fehler! ------------------------------- \nIhre Eingabe war nicht erfolgreich, weil die ID nicht existiert!\n");
            }
        } catch (InputMismatchException e) {
            System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
        }
    }

    private int einlesen_Zahl(final String[] auswahl, final int z�hler) {
        System.out.println("Geben Sie ein: " + auswahl[z�hler - 1]);
        Scanner s = new Scanner(System.in);
        int wort = s.nextInt();
        return wort;
    }

    private String einlesen_Wort(final String[] auswahl, final int z�hler) {
        System.out.println("Geben Sie ein: " + auswahl[z�hler - 1]);
        try (Scanner s = new Scanner(System.in)) {
            String wort = s.next();
            return wort;
        } catch (Exception e) {
            return "";
        }
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

    private String l�nge_anpassen(String wort) {

        int abzug = wort.length();
        if (wort.length() < 50) {
            while (wort.length() < 50) {
                wort = wort + " ";
            }
        }
        return wort;
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
}
