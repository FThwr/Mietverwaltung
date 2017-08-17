package mietverwaltung.action;

import java.util.InputMismatchException;
import java.util.Scanner;

import mietverwaltung.Adresse;
import mietverwaltung.Datum;
import mietverwaltung.Mieter;
import mietverwaltung.Wohnung;
import mietverwaltung.menu.MenuManager;

public class MieterErstellenAction extends MenuManager implements Action {

    @Override
    public void action() {

        System.out.println("________________________________________ Mieter erstellen ________________________________________");

        boolean erstellVorgang = true;

        int mieterID = -100;
        String name = "-";
        String vorname = "-";
        Datum geburtsdatum = null;
        int wohnung = -100;
        String eMail = "-";
        Adresse adresse = null;
        String telefon = "-";
        String status = "Mieter";
        String[] kategorie = { "Mieter ID", "Name", "Vorname", "Geburtsdatum", "Wohnung", "E-Mail", "Adresse", "Telefonnummer" };

        while (erstellVorgang == true) {

            System.out.println("Mieter ID:      " + mieterID);
            System.out.println("Name:           " + name);
            System.out.println("Vorname:        " + vorname);
            System.out.println("Geburtsdatum:   " + geburtsdatum);
            System.out.println("Wohnung:        " + wohnung);
            System.out.println("E-Mail:         " + eMail);
            System.out.println("Adresse:        " + adresse);
            System.out.println("Telefon:        " + telefon);
            System.out.println("");

            Scanner t = new Scanner(System.in);
            System.out.println("...............................Wählen Sie die zu erstellende Eigenschaft aus...............................!  " + "\n Drücke '1' für Mieter ID  " + "\n Drücke '2' für Name  " + "\n Drücke '3' für Vorname  " + "\n Drücke '4' für Geburtsdatum  " + "\n Drücke '5' für Wohnung  " + "\n Drücke '6' für E-Mail  " + "\n Drücke '7' für Adresse  "
                    + "\n Drücke '8' für Telefonnummer  " + "\n Drücke '9' für bestätigen  " + "\n Drücke '0' für abbruch der Suche!\n");
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
                            neueID = mieterID;
                        } else {
                            int nichtVorhanden = 0;
                            for (Mieter owner : MenuManager.ownerList) {
                                if (neueID == owner.getKundenID()) {
                                    nichtVorhanden = 1;
                                }
                            }
                            if (nichtVorhanden == 1) {
                                System.out.println("\n------------------------------- Fehler! ------------------------------- \nKunden ID bereits vergeben!\n");
                            } else {
                                mieterID = neueID;
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
                    String[] auswahl = { "Tag", "Monat", "Jahr" };
                    int zähler = 1;
                    int tag = einlesen_Zahl(auswahl, zähler);
                    zähler = 2;
                    int monat = einlesen_Zahl(auswahl, zähler);
                    zähler = 3;
                    int jahr = einlesen_Zahl(auswahl, zähler);

                    if (tag == 0 || tag == -100 || monat == -100 || jahr == -100 || monat == 0 || jahr == 0) {
                    } else {
                        geburtsdatum = new Datum(tag, monat, jahr);
                    }
                }
                if (änderung == 5) {
                    try {
                        int neueWohnung = einlesen_Zahl(kategorie, änderung);
                        if (neueWohnung == 0) {
                            neueWohnung = wohnung;
                        } else {
                            int nichtVorhanden = 0;
                            for (Wohnung flat : MenuManager.flatList) {
                                for (Mieter owner : MenuManager.ownerList) {
                                    // nur wenn die Wohnung von keinem anderen Mieter
                                    // belegt ist und die Wohnung existiert
                                    if (owner.getWohnungsnummer() != neueWohnung && neueWohnung == flat.getWohnungsID() && flat.getStatus().equals("frei")) {
                                        nichtVorhanden = 1;
                                    }
                                    // wenn ein Mieter bereits in der Wohnung existiert
                                    if (owner.getWohnungsnummer() == neueWohnung) {
                                        nichtVorhanden = 2;
                                    }
                                }
                            }
                            if (nichtVorhanden == 1) {
                                wohnung = neueWohnung;
                            }
                            if (nichtVorhanden == 2) {
                                System.out.println("------------------------------- Fehler! ------------------------------- \nWohnung bereits von einem anderen Mieter belegt!\n");
                            }
                            if (nichtVorhanden != 2 && nichtVorhanden != 1) {
                                System.out.println("------------------------------- Fehler! ------------------------------- \nWohnung existiert nicht!\n");
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
                    }
                }
                if (änderung == 6) {
                    String neueEMail = einlesen_Wort(kategorie, änderung);
                    if (neueEMail.equals("" + 0)) {
                        neueEMail = eMail;
                    } else {
                        eMail = neueEMail;
                    }
                }
                if (änderung == 7) {
                    String[] auswahl = { "Straße", "Hausnummer", "Platz", "Stadt" };

                    int zähler = 1;
                    String straße = einlesen_Wort(auswahl, zähler);
                    zähler = 2;
                    int hausnummer = einlesen_Zahl(auswahl, zähler);
                    zähler = 3;
                    int platz = einlesen_Zahl(auswahl, zähler);
                    zähler = 4;
                    String stadt = einlesen_Wort(auswahl, zähler);

                    if (straße.equals("" + 0) || hausnummer == 0 || platz == 0 || stadt.equals("" + 0) || hausnummer == -100 || platz == -100) {
                    } else {
                        adresse = new Adresse(straße, hausnummer, platz, stadt);
                    }
                }
                if (änderung == 8) {
                    String neueTelefonnummer = einlesen_Wort(kategorie, änderung);
                    if (neueTelefonnummer.equals("" + 0)) {
                        neueTelefonnummer = telefon;
                    } else {
                        telefon = neueTelefonnummer;
                    }
                }
                if (änderung == 9) {
                    System.out.println("Mieter wurde erfolgreich angelegt!");
                    erstellVorgang = false;
                    MenuManager.ownerList.add(new Mieter(mieterID, name, vorname, geburtsdatum, wohnung, eMail, adresse, telefon, status));
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