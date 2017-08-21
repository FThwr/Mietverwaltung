package mietverwaltung.action;

import java.util.InputMismatchException;
import java.util.Scanner;

import mietverwaltung.Adresse;
import mietverwaltung.Datum;
import mietverwaltung.Interessent;
import mietverwaltung.menu.MenuManager;

public class InteressentErstellenAction extends MenuManager implements Action {

    @Override
    public void action() {

        System.out.println("________________________________________ Interessent erstellen ________________________________________");

        boolean erstellVorgang = true;

        int interessentenID = -100;
        String name = "-";
        String vorname = "-";
        Datum geburtsdatum = null;
        String EMail = "-";
        Adresse adresse = null;
        String telefonnummer = "-";
        String status = "Interessent";
        String[] kategorie = { "Interessenten ID", "Name", "Vorname", "Geburtsdatum", "E-Mail", "Adresse", "Telefonnummer" };

        while (erstellVorgang == true) {

            System.out.println("Interessenten ID:      " + interessentenID);
            System.out.println("Name:                  " + name);
            System.out.println("Vorname:               " + vorname);
            System.out.println("Geburtsdatum:          " + geburtsdatum);
            System.out.println("E-Mail:                " + EMail);
            System.out.println("Adresse:               " + adresse);
            System.out.println("Telefon:               " + telefonnummer);
            System.out.println("");

            Scanner t = new Scanner(System.in);
            System.out.println("...............................W�hlen Sie die zu erstellende Eigenschaft aus...............................!  " + "\n Dr�cke '1' f�r Interessenten ID  " + "\n Dr�cke '2' f�r Name  " + "\n Dr�cke '3' f�r Vorname  " + "\n Dr�cke '4' f�r Geburtsdatum  " + "\n Dr�cke '5' f�r E-Mail  " + "\n Dr�cke '6' f�r Adresse  " + "\n Dr�cke '7' f�r Telefonnummer  "
                    + "\n Dr�cke '8' f�r best�tigen  " + "\n Dr�cke '0' f�r abbruch der Suche!\n");
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
                            neueID = interessentenID;
                        } else {
                            //wenn vorhanden = 1 ist, dann existiert ein Interessent mit dieser ID bereits
                            int vorhanden = 0;
                            //f�r jedes Element in der Interessentenliste wird geguckt,
                            //ob die eingegebende ID mit einer bereits existierenden �bereinstimmt
                            for (Interessent interest : MenuManager.currentManager.getInterestList()) {
                                if (neueID == interest.getKundenID()) {
                                    vorhanden = 1;
                                }
                            }
                            if (vorhanden == 1) {
                                System.out.println("\n------------------------------- Fehler! ------------------------------- \nKunden ID bereits vergeben!\n");
                            } else {
                                interessentenID = neueID;
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
                    }
                }
                if (�nderung == 2) {
                    String neuerName = einlesen_Wort(kategorie, �nderung);
                    // wenn eine 0 eingegeben wurde, dann wird der alte Wert behalten
                    if (neuerName.equals("" + 0)) {
                        neuerName = name;
                    } else {
                        name = neuerName;
                    }
                }
                if (�nderung == 3) {
                    String neuerVorname = einlesen_Wort(kategorie, �nderung);
                    // wenn eine 0 eingegeben wurde, dann wird der alte Wert behalten
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

                    // wenn eine 0 oder eine falsche Eingabe erfolgt, dann wird die Eingabe nicht angenommen
                    if (tag == 0 || tag == -100 || monat == -100 || jahr == -100 || monat == 0 || jahr == 0) {
                    } else {
                        geburtsdatum = new Datum(tag, monat, jahr);
                    }
                }
                if (�nderung == 5) {
                    String neueEMail = einlesen_Wort(kategorie, �nderung);
                    // wenn eine 0 eingegeben wurde, dann wird der alte Wert behalten
                    if (neueEMail.equals("" + 0)) {
                        neueEMail = EMail;
                    } else {
                        EMail = neueEMail;
                    }
                }
                if (�nderung == 6) {
                    String[] auswahl = { "Stra�e", "Hausnummer", "Platz", "Stadt" };

                    int z�hler = 1;
                    String stra�e = einlesen_Wort(auswahl, z�hler);
                    z�hler = 2;
                    int hausnummer = einlesen_Zahl(auswahl, z�hler);
                    z�hler = 3;
                    int platz = einlesen_Zahl(auswahl, z�hler);
                    z�hler = 4;
                    String stadt = einlesen_Wort(auswahl, z�hler);

                    // wenn eine 0 oder eine falsche Eingabe erfolgt, dann wird die Eingabe nicht angenommen
                    if (stra�e.equals("" + 0) || hausnummer == 0 || platz == 0 || stadt.equals("" + 0) || hausnummer == -100 || platz == -100) {
                    } else {
                        adresse = new Adresse(stra�e, hausnummer, platz, stadt);
                    }
                }
                if (�nderung == 7) {
                    String neueTelefonnummer = einlesen_Wort(kategorie, �nderung);
                    // wenn eine 0 eingegeben wurde, dann wird der alte Wert behalten
                    if (neueTelefonnummer.equals("" + 0)) {
                        neueTelefonnummer = telefonnummer;
                    } else {
                        telefonnummer = neueTelefonnummer;
                    }
                }
                if (�nderung == 8) {
                    System.out.println("Interessent wurde erfolgreich angelegt!");
                    erstellVorgang = false;
                    MenuManager.currentManager.add(new Interessent(interessentenID, name, vorname, geburtsdatum, EMail, adresse, telefonnummer, status));
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
        //wenn die Eingabe korrekt ist (ohne Buchstaben), dann
        //wird die Eingabe �bernommen, sonst wird eine Fehlermeldung ausgegeben
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