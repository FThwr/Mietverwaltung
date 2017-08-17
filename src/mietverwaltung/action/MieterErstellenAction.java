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
            System.out.println("...............................W�hlen Sie die zu erstellende Eigenschaft aus...............................!  " + "\n Dr�cke '1' f�r Mieter ID  " + "\n Dr�cke '2' f�r Name  " + "\n Dr�cke '3' f�r Vorname  " + "\n Dr�cke '4' f�r Geburtsdatum  " + "\n Dr�cke '5' f�r Wohnung  " + "\n Dr�cke '6' f�r E-Mail  " + "\n Dr�cke '7' f�r Adresse  "
                    + "\n Dr�cke '8' f�r Telefonnummer  " + "\n Dr�cke '9' f�r best�tigen  " + "\n Dr�cke '0' f�r abbruch der Suche!\n");
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
                    String[] auswahl = { "Tag", "Monat", "Jahr" };
                    int z�hler = 1;
                    int tag = einlesen_Zahl(auswahl, z�hler);
                    z�hler = 2;
                    int monat = einlesen_Zahl(auswahl, z�hler);
                    z�hler = 3;
                    int jahr = einlesen_Zahl(auswahl, z�hler);

                    if (tag == 0 || tag == -100 || monat == -100 || jahr == -100 || monat == 0 || jahr == 0) {
                    } else {
                        geburtsdatum = new Datum(tag, monat, jahr);
                    }
                }
                if (�nderung == 5) {
                    try {
                        int neueWohnung = einlesen_Zahl(kategorie, �nderung);
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
                if (�nderung == 6) {
                    String neueEMail = einlesen_Wort(kategorie, �nderung);
                    if (neueEMail.equals("" + 0)) {
                        neueEMail = eMail;
                    } else {
                        eMail = neueEMail;
                    }
                }
                if (�nderung == 7) {
                    String[] auswahl = { "Stra�e", "Hausnummer", "Platz", "Stadt" };

                    int z�hler = 1;
                    String stra�e = einlesen_Wort(auswahl, z�hler);
                    z�hler = 2;
                    int hausnummer = einlesen_Zahl(auswahl, z�hler);
                    z�hler = 3;
                    int platz = einlesen_Zahl(auswahl, z�hler);
                    z�hler = 4;
                    String stadt = einlesen_Wort(auswahl, z�hler);

                    if (stra�e.equals("" + 0) || hausnummer == 0 || platz == 0 || stadt.equals("" + 0) || hausnummer == -100 || platz == -100) {
                    } else {
                        adresse = new Adresse(stra�e, hausnummer, platz, stadt);
                    }
                }
                if (�nderung == 8) {
                    String neueTelefonnummer = einlesen_Wort(kategorie, �nderung);
                    if (neueTelefonnummer.equals("" + 0)) {
                        neueTelefonnummer = telefon;
                    } else {
                        telefon = neueTelefonnummer;
                    }
                }
                if (�nderung == 9) {
                    System.out.println("Mieter wurde erfolgreich angelegt!");
                    erstellVorgang = false;
                    MenuManager.ownerList.add(new Mieter(mieterID, name, vorname, geburtsdatum, wohnung, eMail, adresse, telefon, status));
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