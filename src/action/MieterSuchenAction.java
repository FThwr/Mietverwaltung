package action;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

import menu.MenuManager;
import objekte.Mieter;

public class MieterSuchenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ Mieter suchen ________________________________________");

        boolean suchVorgang = true;

        // Variablen zum R�cksetzen, falls 0 eingegeben wurde
        int mieterID = -100;
        String name = "-";
        String vorname = "-";
        int wohnung = -100;
        String EMail = "-";
        String stra�e = "";
        int plz = -100;
        String telefon = "-";

        // Variablen zur Speicherung des Suchwertes
        int such_mieterID = mieterID;
        String such_name = name;
        String such_vorname = vorname;
        int such_wohnung = wohnung;
        String such_EMail = EMail;
        String such_adresse_stra�e = stra�e;
        int such_adresse_plz = plz;
        String such_telefon = telefon;

        String[] kategorie = { "Mieter ID", "Name", "Vorname", "Wohnung", "E-Mail", "Adresse", "Telefonnummer" };

        /*
         * Mit der Variable wird �berpr�ft, welche Attribut-Abfragen der Nutzer
         * benutzt hatte. Es wird immer ein Buchstabe gespeichert, wodruch die
         * Variable wei�, dass er in der Abfrage was ausgew�hlt hatte. Sp�ter
         * wird anhand dieses Kriteriums die Suche erm�glicht.
         */
        String check = "";
        String[] savecheck = new String[8];

        /*
         * Solange der Suchvorgang nicht beendet ist, wird immer eine �bersicht
         * �ber die zu suchenden Werte ausgegeben, sofern das Attribut
         * ausgew�hlt wurde. Wenn das Attribut nicht ausgew�hlt wurde, wird ein
         * '-' angezeigt. Es wird pro Durchlauf immer 1 Attribut ausgew�hlt,
         * welches man draufhin ver�ndern kann.
         */
        while (suchVorgang == true) {

            Scanner s = new Scanner(System.in);
            System.out.println("............................... W�hlen Sie die zu suchende Eigenschaft aus! ...............................");
            System.out.println("........... Aktuelle Suche nach: ...........");
            if (such_mieterID != -100) {
                System.out.println("1. Kunden ID:                 " + such_mieterID);
            } else {
                System.out.println("1. Kunden ID:                 " + "-");
            }
            System.out.println("2. Name:                  " + such_name);
            System.out.println("3. Vorname:                      " + such_vorname);
            if (such_wohnung != -100) {
                System.out.println("4. Wohnung:                   " + such_wohnung);
            } else {
                System.out.println("4. Wohnung:                   " + "-");
            }
            System.out.println("5. E-Mail:                    " + such_EMail);
            System.out.println("6. Adresse Stra�e:            " + such_adresse_stra�e);

            System.out.println("   Adresse Hausnummer:        " + "-");

            if (plz != -100) {
                System.out.println("6. Adresse Platz:             " + such_adresse_plz);
            } else {
                System.out.println("6. Adresse Platz: " + "-");
            }
            System.out.println("7. Telefonnummer:             " + such_telefon);
            System.out.println("8. Suche abschlie�en");
            System.out.println("0. Abbruch");
            System.out.println("");

            /*
             * Die try-catch Klammer existiert f�r nicht erw�nschte Eingaben wie
             * Zeichen, wo Zahlen erwartet werden.
             */
            try {
                int eingabe = s.nextInt();

                // Abbruch
                if (eingabe == 0) {
                    System.out.println("-------------------------------Suchvorgang wurde abgebrochen!-------------------------------\n");
                    suchVorgang = false;
                }

                // Mieter-ID
                if (eingabe == 1) {
                    int einlese = einlesen_Zahl(kategorie, eingabe);
                    if (einlese == 999) {
                        savecheck[eingabe - 1] = "";
                        such_mieterID = mieterID;
                    }

                    else if (einlese == 0) {
                    }

                    else {

                        such_mieterID = einlese;
                        savecheck[eingabe - 1] = "a";
                    }
                }

                // Name
                if (eingabe == 2) {
                    String einlese = einlesen_Wort(kategorie, eingabe);
                    if (einlese.equals("" + 999)) {
                        savecheck[eingabe - 1] = "";
                        such_name = name;
                    }

                    else if (einlese.equals("" + 0)) {
                    }

                    else {

                        such_name = einlese;
                        savecheck[eingabe - 1] = "b";
                    }
                }

                // Vorname
                if (eingabe == 3) {
                    String einlese = einlesen_Wort(kategorie, eingabe);
                    if (einlese.equals("" + 999)) {
                        savecheck[eingabe - 1] = "";
                        such_vorname = vorname;
                    }

                    else if (einlese.equals("" + 0)) {
                    }

                    else {

                        such_vorname = einlese;
                        savecheck[eingabe - 1] = "c";
                    }
                }

                // Wohnungsnummer
                if (eingabe == 4) {

                    int einlese = einlesen_Zahl(kategorie, eingabe);
                    if (einlese == 999) {
                        savecheck[eingabe - 1] = "";
                        such_wohnung = wohnung;
                    }

                    else if (einlese == 0) {
                    } else {

                        such_wohnung = einlese;
                        savecheck[eingabe - 1] = "d";
                    }
                }

                // E-Mail
                if (eingabe == 5) {
                    String einlese = einlesen_Wort(kategorie, eingabe);
                    if (einlese.equals("" + 999)) {
                        savecheck[eingabe - 1] = "";
                        such_EMail = EMail;
                    }

                    else if (einlese.equals("" + 999)) {
                    } else {

                        such_EMail = einlese;
                        savecheck[eingabe - 1] = "e";
                    }
                }

                // Adresse
                if (eingabe == 6) {
                    System.out.println("Spezialisierung der zu suchenden Adresse: ");
                    System.out.println("Dr�cke '1' f�r Stra�e: ");
                    System.out.println("Dr�cke '2' f�r Plz: ");
                    System.out.println("Dr�cke '3' zum Best�tigen");
                    System.out.println("Dr�cke '0' f�r Abbruch: ");

                    String[] auswahl = { "Stra�e", "Plz" };
                    boolean adresseingabe = true;

                    String buchstabe_einf�gen_stra�e = "";
                    String buchstabe_einf�gen_plz = "";

                    while (adresseingabe == true) {

                        Scanner q = new Scanner(System.in);
                        int z�hler = q.nextInt();

                        // Stra�e
                        if (z�hler == 1) {
                            String einlese = einlesen_Wort(auswahl, z�hler);
                            if (einlese.equals("" + 999)) {
                                savecheck[eingabe - 1] = "";
                                such_adresse_stra�e = stra�e;
                            }

                            else if (einlese.equals("" + 0)) {
                            } else {

                                such_adresse_stra�e = einlese;
                                buchstabe_einf�gen_stra�e = buchstabe_einf�gen_stra�e + "y";
                            }
                        }

                        // Plz
                        if (z�hler == 2) {
                            int einlese = einlesen_Zahl(auswahl, z�hler);
                            if (einlese == 999) {
                                savecheck[eingabe] = "";
                                such_adresse_plz = plz;
                            }

                            else if (einlese == 0) {
                            } else {

                                such_adresse_plz = einlese;
                                buchstabe_einf�gen_plz = buchstabe_einf�gen_plz + "z";
                            }
                        }

                        if (z�hler == 3) {
                            adresseingabe = false;
                            savecheck[eingabe - 1] = buchstabe_einf�gen_stra�e;
                            savecheck[eingabe] = buchstabe_einf�gen_plz;
                        }

                        // Abbruch
                        if (z�hler == 0) {
                            adresseingabe = false;
                        }
                        if (z�hler > 3) {
                            System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit existiert nicht!");
                        }
                    }
                }

                // Telefonnummer
                if (eingabe == 7) {
                    String einlese = einlesen_Wort(kategorie, eingabe);
                    if (einlese.equals("" + 999)) {
                        savecheck[eingabe] = "";
                        such_telefon = telefon;
                    }

                    else if (einlese.equals("" + 0)) {
                    } else {

                        such_telefon = einlese;
                        savecheck[eingabe] = "f";
                    }
                }

                // Suche abschlie�en
                if (eingabe == 8) {
                    suchVorgang = false;

                    // Vergleichsvariablen zu den Suchvariablen
                    int vgl_mieterID = -100;
                    String vgl_name = "-";
                    String vgl_vorname = "-";

                    int vgl_wohnung = -100;
                    String vgl_EMail = "-";

                    String vgl_adresse_stra�e = "-";
                    int vgl_adresse_plz = -100;

                    String vgl_telefon = "-";

                    for (int i = 0; i < savecheck.length; i++) {
                        if (savecheck[i] != null) {
                            check = check + savecheck[i];
                        }
                    }

                    /*
                     * Wenn 'check' ein Buchstaben enth�lt war der Nutzer bei
                     * einer bestimmten Attributver�nderung. Wenn ein Buchstabe
                     * nicht enthalten ist, so ist der Suchwert und der
                     * Vergleichswert gleich. Wenn nun ein Buchstabe enthalten
                     * ist wird in jedem Handwerkerauftrag nach der zu suchenden
                     * Eigenschaft gesucht und wenn diese gefunden wurde, wird
                     * das dazugeh�rige Objekt ausgegeben. Bei mehreren
                     * Buchstaben m�ssen alle eingegebene Suchattribute in einem
                     * Handwerkerauftrag vorhanden sein, damit eine Ausgabe
                     * erm�glicht werden kann.
                     */
                    for (Mieter owner : MenuManager.ownerList) {

                        if (check.contains("a")) {
                            vgl_mieterID = owner.getKundenID();
                        }
                        if (check.contains("b")) {
                            vgl_name = owner.getName();
                        }
                        if (check.contains("c")) {
                            vgl_vorname = owner.getVorname();
                        }
                        if (check.contains("d")) {
                            vgl_wohnung = owner.getWohnungsnummer();
                        }
                        if (check.contains("e")) {
                            vgl_EMail = owner.getEmail();
                        }
                        if (check.contains("y")) {
                            vgl_adresse_stra�e = owner.getAdresse().getStrasse();
                        }
                        if (check.contains("z")) {
                            vgl_adresse_plz = owner.getAdresse().getPlz();
                        }
                        if (check.contains("f")) {
                            vgl_telefon = owner.getTelefonnummer();
                        }

                        if (vgl_mieterID == such_mieterID && vgl_name.contains(such_name) && vgl_vorname.contains(such_vorname) && vgl_wohnung == such_wohnung && vgl_EMail.contains(such_EMail) && vgl_adresse_stra�e.contains(such_adresse_stra�e) && vgl_adresse_plz == such_adresse_plz && vgl_telefon.contains(such_telefon)) {
                            System.out.println("Mieter ID:          " + owner.getKundenID());
                            System.out.println("Name:               " + owner.getName());
                            System.out.println("Vorname:            " + owner.getVorname());
                            System.out.println("Geburtsdatum:       " + owner.getGeburtsdatum());
                            System.out.println("Wohnung:            " + owner.getWohnungsnummer());
                            System.out.println("E-Mail:             " + owner.getEmail());
                            System.out.println("Adresse:            " + owner.getAdresse());
                            System.out.println("Telefonnummer:      " + owner.getTelefonnummer());
                            System.out.println("");
                        }
                    }
                }

                // Eingabe > 8
                if (eingabe > 8) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit existiert nicht!");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
            }
        }
    }

    private int einlesen_Zahl(final String[] auswahl, final int z�hler) {
        Scanner s = new Scanner(System.in);
        int zahl = -100;
        try {

            do {
                System.out.println("Geben Sie ein: " + auswahl[z�hler - 1]);
                zahl = s.nextInt();
                if (zahl < 0) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nNur positive Zahlen erlaubt!");
                }
            } while (zahl < 0);
        } catch (InputMismatchException e) {
            System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
        }
        return zahl;
    }

    private String einlesen_Wort(final String[] auswahl, final int z�hler) {
        System.out.println("Geben Sie ein: " + auswahl[z�hler - 1]);
        Scanner s = new Scanner(System.in);
        String wort = s.nextLine();
        return wort;
    }
}