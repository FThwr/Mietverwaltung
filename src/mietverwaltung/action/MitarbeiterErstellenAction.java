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
            System.out.println("...............................W�hlen Sie die zu erstellende Eigenschaft aus...............................!  " + "\n Dr�cke '1' f�r Mitarbeiter ID  " + "\n Dr�cke '2' f�r Name  " + "\n Dr�cke '3' f�r Vorname  " + "\n Dr�cke '4' f�r Passwort  " + "\n Dr�cke '5' f�r best�tigen  " + "\n Dr�cke '0' f�r abbruch der Suche!\n");
            try {
                int �nderung = t.nextInt();

                if (�nderung == 0) {
                    System.out.println("-------------------------------Erstellvorgang wurde abgebrochen!-------------------------------\n");
                    erstellVorgang = false;
                }
                if (�nderung == 1) {
                    try {
                        int neueID = einlesen_Zahl(kategorie, �nderung);
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
                if (�nderung == 2) {
                    String neuerName = einlesen_Wort(kategorie, �nderung);
                    if (neuerName.equals("" + 0)) {
                        neuerName = name;
                    } else {
                        name = neuerName;
                    }
                }
                if (�nderung == 3) {
                    String neuerVorname = einlesen_Wort(kategorie, �nderung);

                    if (neuerVorname.equals("" + 0)) {
                        neuerVorname = vorname;
                    } else {
                        vorname = neuerVorname;
                    }
                }
                if (�nderung == 4) {
                    String neuesPasswort = einlesen_Wort(kategorie, �nderung);

                    if (neuesPasswort.equals("" + 0)) {
                        neuesPasswort = passwort;
                    } else {
                        passwort = neuesPasswort;
                    }
                }
                if (�nderung == 5) {
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

    private int einlesen_Zahl(final String[] auswahl, final int z�hler) {
        System.out.println("Erstellen: " + auswahl[z�hler - 1]);
        Scanner s = new Scanner(System.in);
        int zahl = -100;
        try {
            zahl = s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
        }
        return zahl;
    }

    private String einlesen_Wort(final String[] auswahl, final int z�hler) {
        System.out.println("Erstellen: " + auswahl[z�hler - 1]);
        Scanner s = new Scanner(System.in);
        String wort = s.next();
        return wort;
    }
}