package mietverwaltung.action;

import java.util.InputMismatchException;
import java.util.Scanner;

import mietverwaltung.Adresse;
import mietverwaltung.Datum;
import mietverwaltung.Handwerkerauftrag;
import mietverwaltung.Mitarbeiter;
import mietverwaltung.Wohnung;
import mietverwaltung.menu.MenuManager;

public class WohnungErstellenAction extends MenuManager implements Action {

    @Override
    public void action() {

        System.out.println("________________________________________ Wohnung erstellen ________________________________________");

        boolean erstellVorgang = true;

        int wohnungsnummer = -100;
        int zimmeranzahl = -100;
        double fl�che = -100;
        double kosten = -100;
        int etage = -100;
        boolean balkon = false;
        boolean fu�bodenheizung = false;
        String aussicht = "-";
        Adresse adresse = null;
        String status = "frei";
        Datum letztesRenovierungsdatum = null;
        int renovierungsanzahl = -100;
        String letzeRenovierung_Details = "-";
        Handwerkerauftrag handwerkerauftrag = null;
        Mitarbeiter zugeordneterMitarbeiter = null;

        while (erstellVorgang == true) {

            String[] kategorie = { "Wohnungsnummer", "Zimmeranzahl", "Fl�che", "Kosten", "Etage", "Balkon", "Fu�bodenheizung", "Aussicht", "Adresse", "zugeordneten Mitarbeiter" };

            System.out.println("W�hlen Sie einen zu bearbeitenenden Wert!\nFolgende Wohnung wird aktuell erstellt: ");
            System.out.println("Dr�cke '1' f�r Wohnungsnummer:                           " + wohnungsnummer);
            System.out.println("Dr�cke '2' f�r Zimmeranzahl:                             " + zimmeranzahl);
            System.out.println("Dr�cke '3' f�r Fl�che:                                   " + fl�che);
            System.out.println("Dr�cke '4' f�r Kosten:                                   " + kosten);
            System.out.println("Dr�cke '5' f�r Etage:                                    " + etage);
            System.out.println("Dr�cke '6' f�r Balkon:                                   " + balkon);
            System.out.println("Dr�cke '7' f�r Fu�bodenheizung:                          " + fu�bodenheizung);
            System.out.println("Dr�cke '8' f�r Aussicht:                                 " + aussicht);
            System.out.println("Dr�cke '9' f�r Adresse:                                  " + adresse);
            System.out.println("Dr�cke '10' f�r zugeordneten Mitarbeiter:                " + zugeordneterMitarbeiter);
            System.out.println("Dr�cke '11' zum Erstellen");
            System.out.println("Dr�cke '0' um abzubrechen");

            Scanner s = new Scanner(System.in);
            int ok = s.nextInt();

            if (ok == 0) {
                erstellVorgang = false;
            }
            if (ok == 1) {
                wohnungsnummer = int_eingabe(kategorie, ok);
                int vorhanden = 0;
                for (Wohnung flat : MenuManager.currentManager.getFlatList()) {
                    if (flat.getWohnungsID() == wohnungsnummer) {
                        vorhanden = 1;
                    }
                }
                if (vorhanden == 1) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nDie Wohnung mit der Nummer: " + "'" + wohnungsnummer + "'" + " existiert bereits!\n");
                    wohnungsnummer = -100;
                }
            }
            if (ok == 2) {
                // eventuelle Fehleranzeige f�r nicht vorhandene Zimmeranzahl
                zimmeranzahl = int_eingabe(kategorie, ok);
            }
            if (ok == 3) {
                // eventuelle Fehleranzeige f�r nicht vorhandene Fl�che

                fl�che = double_eingabe(kategorie, ok);
            }
            if (ok == 4) {
                // eventuelle Fehleranzeige f�r nicht vorhandene Kosten

                kosten = double_eingabe(kategorie, ok);
            }
            if (ok == 5) {
                etage = int_eingabe(kategorie, ok);
                if (etage > 4) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nDie Etage existiert nicht!");
                    etage = -100;
                }
            }
            if (ok == 6) {
                balkon = boolean_eingabe(kategorie, ok);
            }
            if (ok == 7) {
                fu�bodenheizung = boolean_eingabe(kategorie, ok);
            }
            if (ok == 8) {
                // eventuelle Fehleranzeige f�r nicht vorhandene Aussicht

                aussicht = String_eingabe(kategorie, ok);
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

                if (stra�e.equals("" + 0) || hausnummer == 0 || platz == 0 || stadt.equals("" + 0) || hausnummer == -100 || platz == -100) {
                } else {
                    adresse = new Adresse(stra�e, hausnummer, platz, stadt);
                }
            }
            if (ok == 10) {
                String[] auswahl = { "Mitarbeiter ID" };
                int z�hler = 1;
                int ID = int_eingabe(auswahl, z�hler);
                String name = "";
                String vorname = "";
                int vorhanden = 0;

                for (Mitarbeiter worker : MenuManager.currentManager.getWorkerList()) {
                    if (worker.getMitarbeiterID() == ID) {
                        name = worker.getName();
                        vorname = worker.getVorname();
                        vorhanden = 1;
                    }
                }

                if (vorhanden == 0) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nMitarbeiter mti der ID " + ID + " existiert nicht!\n");
                }
                if (ID == 0 || ID == -100) {
                }
                if (vorhanden == 1) {
                    zugeordneterMitarbeiter = new Mitarbeiter(ID, name, vorname);
                }
            }
            if (ok == 11) {
                erstellVorgang = false;

                MenuManager.currentManager.add(new Wohnung(wohnungsnummer, zimmeranzahl, fl�che, kosten, etage, balkon, fu�bodenheizung, aussicht, adresse, status, letztesRenovierungsdatum, renovierungsanzahl, letzeRenovierung_Details, handwerkerauftrag, zugeordneterMitarbeiter));
            }
            if (ok > 11) {
                System.out.println("\n------------------------------- Fehler! ------------------------------- \nKeine Option vorhanden!\n");
            }

        }
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
