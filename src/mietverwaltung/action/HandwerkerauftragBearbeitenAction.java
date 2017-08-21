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
        System.out.println("\nWählen Sie den Handwerkerauftrag (ID) aus, die Sie bearbeiten möchten!\n");

        // Ausgabe aller Interessenten (ID, Name, Vorname) zur einfacheren Auswahl
        for (Handwerkerauftrag repair : MenuManager.currentManager.getRepairList()) {
            System.out.println(repair.getAuftragsID() + "; " + repair.getMängelbeschreibung());
        }

        // wenn die Eingabe korrekt (ohne Buchstaben) ist, dann
        // beginnt der Bearbeitungsvorgang
        try {
            String zu_bearbeitenden_handwerkerauftrag = s.next();

            boolean bearbeitungsVorgang = true;
            boolean handwerkerauftragEingabe_erfolgreich = false;
            String[] kategorie = { "Auftrags ID ", "Wohnungs ID", "Mitarbeiter ID", "Mängelbeschreibung", "Status", "Eingangsdatum", "Fertigstellungsdatum" };

            // diese Variablen dienen später für eine tabellarische Ausgabe auf der Konsole
            String längenAnpassung_auftragsID = "";
            String längenAnpassung_wohnungsID = "";
            String längenAnpassung_mitarbeiterID = "";
            String längenAnpassung_mängelbeschreibung = "";
            String längenAnpassung_status = "";

            // allgemeine Variablen
            // alte = aktuelle Werte
            // neue = neue/veränderten Werte
            String aktuelleAuftragsID = "";
            String neueAuftragsID = "";

            int aktuelleWohnungsID = 0;
            int neueWohnungsID = 0;

            int aktuelleMitarbeiterID = 0;
            int neueMitarbeiterID = 0;

            String aktuelleMängelbeschreibung = "";
            String neueMängelbeschreibung = "";

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

                    aktuelleMängelbeschreibung = repair.getMängelbeschreibung();
                    neueMängelbeschreibung = aktuelleMängelbeschreibung;

                    aktuellerStatus = repair.getStatus();
                    neuerStatus = aktuellerStatus;

                    aktuellesEingangsdatum = repair.getEingangsdatum();
                    neuesEingangsdatum = aktuellesEingangsdatum;

                    aktuellesFertigstellungsdatum = repair.getFertigstellungsDatum();
                    neuesFertigstellungsdatum = aktuellesFertigstellungsdatum;

                    // Initialisierung der tabellarischen Variablen + Ausfüllung mit Leerzeichen (Umwandlung in die Tabelle)
                    längenAnpassung_auftragsID = aktuelleAuftragsID;
                    längenAnpassung_auftragsID = länge_anpassen(längenAnpassung_auftragsID);

                    längenAnpassung_wohnungsID = "" + aktuelleWohnungsID;
                    längenAnpassung_wohnungsID = länge_anpassen(längenAnpassung_wohnungsID);

                    längenAnpassung_mitarbeiterID = "" + aktuelleMitarbeiterID;
                    längenAnpassung_mitarbeiterID = länge_anpassen(längenAnpassung_mitarbeiterID);

                    längenAnpassung_mängelbeschreibung = aktuelleMängelbeschreibung;
                    längenAnpassung_mängelbeschreibung = länge_anpassen(längenAnpassung_mängelbeschreibung);

                    längenAnpassung_status = aktuellerStatus;
                    längenAnpassung_status = länge_anpassen(längenAnpassung_status);

                    ED_Leerzeichen = länge_anpassen_Datum(aktuellesEingangsdatum);

                    FD_Leerzeichen = länge_anpassen_Datum(aktuellesFertigstellungsdatum);

                }
            }

            if (handwerkerauftragEingabe_erfolgreich == true) {
                while (bearbeitungsVorgang == true) {

                    System.out.println("Auftrags ID:          " + längenAnpassung_auftragsID + "neue Auftrags ID:           " + neueAuftragsID);
                    System.out.println("Wohnungs ID:          " + längenAnpassung_wohnungsID + "neue Wohnungs ID:           " + neueWohnungsID);
                    System.out.println("Mitarbeiter ID:       " + längenAnpassung_mitarbeiterID + "neue Mitarbeiter ID:        " + neueMitarbeiterID);
                    System.out.println("Mängelbeschreibung:   " + längenAnpassung_mängelbeschreibung + "neue Mängelbeschreibung:    " + neueMängelbeschreibung);
                    System.out.println("Status:               " + längenAnpassung_status + "neuer Status:               " + neuerStatus);
                    System.out.println("Eingangsdatum:        " + aktuellesEingangsdatum + ED_Leerzeichen + "neues Eingangsdatum:        " + neuesEingangsdatum);
                    System.out.println("Fertigstellungsdatum: " + aktuellesFertigstellungsdatum + FD_Leerzeichen + "neues Fertigstellungsdatum: " + neuesFertigstellungsdatum);
                    System.out.println("");

                    Scanner t = new Scanner(System.in);
                    System.out.println("............................... Wählen Sie die zu bearbeitende Eigenschaft aus! ..............................." + "\n Drücke '1' für Auftrags-ID  " + "\n Drücke '2' für Wohnungs-ID  " + "\n Drücke '3' für Mitarbeiter-ID  " + "\n Drücke '4' für Mängelbeschreibung  " + "\n Drücke '5' für Status  " + "\n Drücke '6' für Eingangsdatum  "
                            + "\n Drücke '7' für Fertigstellungsdatum  " + "\n Drücke '8' für bestätigen  " + "\n Drücke '0' für abbruch der Suche!\n");

                    try {
                        int änderung = t.nextInt();

                        if (änderung == 0) {
                            bearbeitungsVorgang = false;
                        }
                        if (änderung == 1) {
                            String eingabe = einlesen_Wort(kategorie, änderung);
                            if (eingabe.equals(0)) {
                                neueAuftragsID = aktuelleAuftragsID;
                            } else {
                                neueAuftragsID = eingabe;
                            }
                        }
                        if (änderung == 2) {
                            int eingabe = einlesen_Zahl(kategorie, änderung);
                            if (eingabe == 0) {
                                neueWohnungsID = aktuelleWohnungsID;
                            } else {
                                neueWohnungsID = eingabe;
                            }
                        }
                        if (änderung == 3) {
                            int eingabe = einlesen_Zahl(kategorie, änderung);
                            if (eingabe == 0) {
                                neueMitarbeiterID = aktuelleMitarbeiterID;
                            } else {
                                neueMitarbeiterID = eingabe;
                            }
                        }
                        if (änderung == 4) {
                            String eingabe = einlesen_Wort(kategorie, änderung);
                            if (eingabe.equals("" + 0)) {
                                neueMängelbeschreibung = aktuelleMängelbeschreibung;
                            } else {
                                neueMängelbeschreibung = eingabe;
                            }
                        }
                        if (änderung == 5) {
                            String[] auswahl = { "in Arbeit", "fertig" };
                            Scanner a = new Scanner(System.in);
                            System.out.println("Geben Sie die Zahl vom gewünschten Status aus: " + "1" + auswahl[0] + "2" + auswahl[1] + "0" + " um abzubrechen");
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
                                System.out.println("------------------ Fehler -----------------\nEingabemöglichkeit nicht vorhanden!\n");
                            }
                        }

                        if (änderung == 6) {
                            String[] auswahl = { "Tag", "Monat", "Jahr" };
                            int zähler = 1;
                            int tag = einlesen_Zahl(auswahl, zähler);
                            zähler = 2;
                            int monat = einlesen_Zahl(auswahl, zähler);
                            zähler = 3;
                            int jahr = einlesen_Zahl(auswahl, zähler);

                            if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
                                neuesEingangsdatum = aktuellesEingangsdatum;
                            } else {
                                neuesEingangsdatum = new Datum(tag, monat, jahr);
                            }
                        }
                        if (änderung == 7) {
                            String[] auswahl = { "Tag", "Monat", "Jahr" };
                            int zähler = 1;
                            int tag = einlesen_Zahl(auswahl, zähler);
                            zähler = 2;
                            int monat = einlesen_Zahl(auswahl, zähler);
                            zähler = 3;
                            int jahr = einlesen_Zahl(auswahl, zähler);

                            if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
                                neuesFertigstellungsdatum = aktuellesFertigstellungsdatum;
                            } else {
                                neuesFertigstellungsdatum = new Datum(tag, monat, jahr);
                            }
                        }
                        if (änderung == 8) {
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
                                    repair.setMängelbeschreibung(neueMängelbeschreibung);
                                    repair.setStatus(neuerStatus);
                                    repair.setEingangsdatum(neuesEingangsdatum);
                                    repair.setFertigstellungsDatum(neuesFertigstellungsdatum);
                                }
                            }
                            //							}
                            if (neuerStatus.equals("fertig")) {
                                //TODO: schließen und speichern
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

    private int einlesen_Zahl(final String[] auswahl, final int zähler) {
        System.out.println("Geben Sie ein: " + auswahl[zähler - 1]);
        Scanner s = new Scanner(System.in);
        int wort = s.nextInt();
        return wort;
    }

    private String einlesen_Wort(final String[] auswahl, final int zähler) {
        System.out.println("Geben Sie ein: " + auswahl[zähler - 1]);
        try (Scanner s = new Scanner(System.in)) {
            String wort = s.next();
            return wort;
        } catch (Exception e) {
            return "";
        }
    }

    private String länge_anpassen_Datum(final Datum a_GD) {

        String leerzeichen = "";

        String jahr = "" + a_GD.getJahr();
        int l_J = jahr.length();

        String monat = "" + a_GD.getMonat();
        int l_M = monat.length();

        String tag = "" + a_GD.getTag();
        int l_T = tag.length();

        int abzug = l_J + l_M + l_T + 2; // +2 für die Punkte zwischen den
                                         // Komponenten
        if (abzug < 50) {
            while (abzug < 50) {
                leerzeichen = leerzeichen + " ";
                abzug += 1;
            }
        }
        return leerzeichen;
    }

    private String länge_anpassen(String wort) {

        int abzug = wort.length();
        if (wort.length() < 50) {
            while (wort.length() < 50) {
                wort = wort + " ";
            }
        }
        return wort;
    }

    private String länge_anpassen_Adresse(final Adresse a_A) {

        String leerzeichen = "";

        String hausnummer = "" + a_A.getHausnummer();
        int l_HN = hausnummer.length();

        String platz = "" + a_A.getPlz();
        int l_P = platz.length();

        String stadt = a_A.getStadt();
        int l_ST = stadt.length();

        String straße = a_A.getStrasse();
        int l_SR = straße.length();

        int abzug = l_HN + l_P + l_SR + l_ST + 3; // +3 für die Leerzeichen
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
