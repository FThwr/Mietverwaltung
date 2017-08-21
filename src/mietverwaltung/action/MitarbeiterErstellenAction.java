package mietverwaltung.action;

import java.util.InputMismatchException;
import java.util.Scanner;

import mietverwaltung.Mitarbeiter;
import mietverwaltung.menu.MenuManager;

public class MitarbeiterErstellenAction extends MenuManager implements Action {

    @Override
    public void action() {

        System.out.println("________________________________________ Mitarbeiter erstellen ________________________________________");

        boolean erstellVorgang = true;

        int mitarbeiterID = -100;
        String name = "";
        String vorname = "";
        String benutzername = "";
        String passwort = "";
        String[] kategorie = { "Mitarbeiter ID", "Name", "Vorname", "Passwort" };

        while (erstellVorgang == true) {

            System.out.println("Mitarbeiter ID: " + mitarbeiterID);
            System.out.println("Name:           " + name);
            System.out.println("Vorname:        " + vorname);
            System.out.println("Passwort:       " + passwort);
            System.out.println("");

            Scanner t = new Scanner(System.in);
            System.out.println("...............................Wählen Sie die zu erstellende Eigenschaft aus...............................!  " + "\n Drücke '1' für Mitarbeiter ID  " + "\n Drücke '2' für Name  " + "\n Drücke '3' für Vorname  " + "\n Drücke '4' für Passwort  " + "\n Drücke '5' für bestätigen  " + "\n Drücke '0' für abbruch der Suche!\n");
            try {
                int änderung = t.nextInt();

                if (änderung == 0) {
                    System.out.println("-------------------------------Erstellvorgang wurde abgebrochen!-------------------------------\n");
                    erstellVorgang = false;
                }
                if (änderung == 1) {
                    try {
                        int neueID = einlesen_Zahl(kategorie, änderung);
                        if (neueID == 0) {
                            neueID = mitarbeiterID;
                        } else {
                            int nichtVorhanden = 0;
                            for (Mitarbeiter worker : MenuManager.currentManager.getWorkerList()) {
                                if (neueID == worker.getMitarbeiterID()) {
                                    nichtVorhanden = 1;
                                }
                            }
                            if (nichtVorhanden == 1) {
                                System.out.println("\n------------------------------- Fehler! ------------------------------- \nMitarbeiter ID bereits vergeben!\n");
                            } else {
                                mitarbeiterID = neueID;
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
                    }
                }
                if (änderung == 2) {
                    String neuerName = einlesen_Wort(kategorie, änderung);
                    if (neuerName.equals("" + 0)) {
                        neuerName = name;
                    } else {
                        name = neuerName;
                    }
                }
                if (änderung == 3) {
                    String neuerVorname = einlesen_Wort(kategorie, änderung);

                    if (neuerVorname.equals("" + 0)) {
                        neuerVorname = vorname;
                    } else {
                        vorname = neuerVorname;
                    }
                }
                if (änderung == 4) {
                    String neuesPasswort = einlesen_Wort(kategorie, änderung);

                    if (neuesPasswort.equals("" + 0)) {
                        neuesPasswort = passwort;
                    } else {
                        passwort = neuesPasswort;
                    }
                }
                if (änderung == 5) {
                    System.out.println("Mitarbeiter wurde erfolgreich angelegt!");
                    erstellVorgang = false;
                    benutzername = vorname.trim().substring(0, 1) + "." + name;
                    MenuManager.currentManager.getWorkerList().add(new Mitarbeiter(mitarbeiterID, name, vorname, benutzername, passwort));
                }
            } catch (InputMismatchException e) {
                System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
            }
        }
    }

    private int einlesen_Zahl(final String[] auswahl, final int zähler) {
        System.out.println("Erstellen: " + auswahl[zähler - 1]);
        Scanner s = new Scanner(System.in);
        int zahl = -100;
        try {
            zahl = s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
        }
        return zahl;
    }

    private String einlesen_Wort(final String[] auswahl, final int zähler) {
        System.out.println("Erstellen: " + auswahl[zähler - 1]);
        Scanner s = new Scanner(System.in);
        String wort = s.next();
        return wort;
    }
}