package action;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

import menu.MenuManager;
import objekte.Handwerkerauftrag;

public class HandwerkerauftragSuchenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ Handwerkerauftrag suchen ________________________________________");

        boolean suchVorgang = true;

        // Variablen zum R�cksetzen, falls 0 eingegeben wurde
        String auftragsID = "-";
        int wohnungsID = -100;
        int mitarbeiterID = -100;
        String m�ngelbeschreibung = "-";
        String status = "-";
        int eingangsMonat = -100;
        int eingangsJahr = -100;
        int fertigMonat = -100;
        int fertigJahr = -100;

        // Variablen zur Speicherung des Suchwertes
        String such_auftragsID = auftragsID;
        int such_wohnungsID = wohnungsID;
        int such_mitarbeiterID = mitarbeiterID;
        String such_m�ngelbeschreibung = m�ngelbeschreibung;
        String such_status = status;
        int such_eingangsMonat = eingangsMonat;
        int such_eingangsJahr = eingangsJahr;
        int such_fertigMonat = fertigMonat;
        int such_fertigJahr = fertigJahr;

        /*
         * Array beeinhaltet alle Attribute, die ver�ndert werden k�nnen und
         * dient zur Ausgabe durch Zugriff auf deren Index
         */
        String[] kategorie = { "Auftrags ID ", "Wohnungs ID", "Mitarbeiter ID", "M�ngelbeschreibung", "Status", "Eingangsdatum", "Fertigstellungsdatum" };

        /*
         * Mit der Variable wird �berpr�ft, welche Attribut-Abfragen der Nutzer
         * benutzt hatte. Es wird immer ein Buchstabe gespeichert, wodruch die
         * Variable wei�, dass er in der Abfrage was ausgew�hlt hatte. Sp�ter
         * wird anhand dieses Kriteriums die Suche erm�glicht.
         */
        String check = "";
        String[] savecheck = new String[9];

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
            System.out.println("1. Auftrags ID:          " + such_auftragsID);
            if (such_wohnungsID != -100) {
                System.out.println("2. Wohnungs ID:          " + such_wohnungsID);
            } else {
                System.out.println("2. Wohnungs ID:          " + "-");
            }
            if (such_mitarbeiterID != -100) {
                System.out.println("3. Mitarbeiter ID:       " + such_mitarbeiterID);
            } else {
                System.out.println("3. Mitarbeiter ID:       " + "-");
            }
            System.out.println("4. M�ngelbeschreibung:   " + such_m�ngelbeschreibung);
            System.out.println("5. Status:               " + such_status);
            System.out.print("6. Eingangsdatum:        ");

            System.out.print("--.");

            if (such_eingangsMonat != -100) {
                System.out.print(such_eingangsMonat);
            } else {
                System.out.print("--.");
            }
            if (such_eingangsJahr != -100) {
                System.out.println(such_eingangsJahr);
            } else {
                System.out.println("----");
            }

            System.out.print("7. Fertigstellungsdatum: ");
            System.out.print("--.");

            if (such_fertigMonat != -100) {
                System.out.print(such_fertigMonat);
            } else {
                System.out.print("--.");
            }
            if (such_fertigJahr != -100) {
                System.out.println(such_fertigJahr);
            } else {
                System.out.println("----");
            }
            System.out.println("8. Suchen abschlie�en");
            System.out.println("0. Abbruch");
            System.out.println("");

            /*
             * Die try-catch Klammer existiert f�r nicht erw�nschte Eingaben wie
             * Zeichen, wo Zahlen erwartet werden.
             */
            try {

                /*
                 * Variable zur Auswahl des zu bearbeitenden Attributs.
                 */
                int eingabe = s.nextInt();

                // Abbruch
                if (eingabe == 0) {
                    System.out.println("-------------------------------Suchvorgang wurde abgebrochen!-------------------------------\n");
                    suchVorgang = false;
                }

                // Auftrags-ID
                if (eingabe == 1) {

                    String einlese = einlesen_Wort(kategorie, eingabe);

                    /*
                    * 999 = r�ckg�ngig machen des Attributes + l�schen des
                    * Buchstabens
                    */
                    if (einlese.equals("" + 999)) {
                        savecheck[eingabe - 1] = "";
                        such_auftragsID = auftragsID;
                    }

                    // 0 = keine Ver�nderung, nur Abbruch der Abfrage
                    else if (einlese.equals("" + 0)) {
                    }

                    // Eingabe weder 0 noch 999
                    else {

                        // Die Eingabe wird �bernommen
                        such_auftragsID = einlese;
                        /*
                         * Der Nutzer hat das Attribut Auftrags-ID betreten.
                         * Somit erh�lt 'check' ein 'a' um sich zu merken, dass
                         * es die Abfrage betreten hatte.
                         */

                        savecheck[eingabe - 1] = "a";
                    }
                }

                // Wohnung
                if (eingabe == 2) {

                    int einlese = einlesen_Zahl(kategorie, eingabe);

                    /*
                    * 999 = r�ckg�ngig machen des Attributes + l�schen des
                    * Buchstabens
                    */
                    if (einlese == 999) {
                        savecheck[eingabe - 1] = "";
                        such_wohnungsID = wohnungsID;
                    }

                    // 0 = keine Ver�nderung, nur Abbruch der Abfrage
                    else if (einlese == 0) {
                    }

                    // Eingabe weder 0 noch 999
                    else {

                        // Die Eingabe wird �bernommen
                        such_wohnungsID = einlese;
                        /*
                         * Der Nutzer hat das Attribut Wohnung betreten. Somit
                         * erh�lt 'check' ein 'b' um sich zu merken, dass es die
                         * Abfrage betreten hatte.
                         */
                        savecheck[eingabe - 1] = "b";
                    }

                } // Mitarbeiter
                if (eingabe == 3) {
                    int einlese = einlesen_Zahl(kategorie, eingabe);
                    if (einlese == 999) {
                        savecheck[eingabe - 1] = "";
                        such_mitarbeiterID = mitarbeiterID;
                    }

                    else if (einlese == 0) {
                    } else {

                        such_mitarbeiterID = einlese;
                        /*
                         * Der Nutzer hat das Attribut Mitarbeiter betreten.
                         * Somit erh�lt 'check' ein 'c' um sich zu merken, dass
                         * es die Abfrage betreten hatte.
                         */
                        savecheck[eingabe - 1] = "c";
                    }
                }

                // M�ngelbeschreibung
                if (eingabe == 4) {

                    String einlese = einlesen_Wort(kategorie, eingabe);
                    if (einlese.equals("" + 999)) {
                        such_m�ngelbeschreibung = m�ngelbeschreibung;
                        savecheck[eingabe - 1] = "";
                    }
                    if (einlese.equals("" + 0)) {
                    }

                    else {

                        such_m�ngelbeschreibung = einlese;
                        /*
                         * Der Nutzer hat das Attribut M�ngelbeschreibung
                         * betreten. Somit erh�lt 'check' ein 'd' um sich zu
                         * merken, dass es die Abfrage betreten hatte.
                         */
                        savecheck[eingabe - 1] = "d";
                    }
                }

                // Status
                if (eingabe == 5) {
                    System.out.println("Geben Sie die Zahl vom gew�nschten Status aus: '1' = in Bearbeitung, '2' = beendet, '0' = Abbruch!");
                    int auswahl = einlesen_Zahl(kategorie, eingabe);

                    if (auswahl == 1) {
                        such_status = "in Bearbeitung";
                        /*
                         * Der Nutzer hat das Attribut Status betreten. Somit
                         * erh�lt 'check' ein 'e' um sich zu merken, dass es die
                         * Abfrage betreten hatte.
                         */
                        check = check + "e";
                    }
                    if (auswahl == 2) {
                        savecheck[eingabe - 1] = "e";
                        such_status = "beendet";
                        /*
                         * Der Nutzer hat das Attribut Status betreten. Somit
                         * erh�lt 'check' ein 'e' um sich zu merken, dass es die
                         * Abfrage betreten hatte.
                         */
                        savecheck[eingabe - 1] = "e";
                    }

                    if (auswahl == 0) {
                        such_status = status;
                    }

                    // Jede andere Eingabe f�hrt zu einer Fehlermeldung.
                    if (auswahl > 2) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit existiert nicht!");
                    }

                }

                // Eingangsdatum
                if (eingabe == 6) {

                    String[] auswahl = { "Monat", "Jahr" };
                    boolean datumseingabe = true;

                    /*
                     * Variable um zu merken, welche Attributsver�nderungen der
                     * Nutzer betreten hat. Hinzugef�gt zum 'check' werden die
                     * Buchstaben jedoch erst, wenn die Suche abgeschlossen ist,
                     * weil sonst Buchstaben enthalten w�ren f�r
                     * Attribut�nderungen, die garnicht existieren.
                     */
                    String buchstabe_einf�gen_monat = "";
                    String buchstabe_einf�gen_jahr = "";

                    while (datumseingabe == true) {

                        System.out.println("Spezialisierung des zu suchenden Eingangsdatums: Ihre Auswahl: Monat = " + such_eingangsMonat + ", Jahr = " + such_eingangsJahr);
                        System.out.println("Dr�cke '1' f�r Monat: ");
                        System.out.println("Dr�cke '2' f�r Jahr: ");
                        System.out.println("Dr�cke '3' f�r Best�tigen: ");
                        System.out.println("Dr�cke '0' f�r Abbruch: ");

                        Scanner q = new Scanner(System.in);
                        int z�hler = q.nextInt();

                        // Monat
                        if (z�hler == 1) {

                            int einlese = einlesen_Zahl(auswahl, z�hler);
                            if (einlese == 999) {
                                savecheck[eingabe - 1] = "";
                                such_eingangsMonat = eingangsMonat;
                            } else if (einlese == 0) {
                            } else {
                                such_eingangsMonat = einlese;
                                /*
                                 * Der Nutzer hat das Attribut Eingangsmonat
                                 * betreten. Somit erh�lt 'safecheck' ein 's' um
                                 * sich zu merken, dass es die Abfrage betreten
                                 * hatte.
                                 */
                                buchstabe_einf�gen_monat = buchstabe_einf�gen_monat + "s";
                            }
                        }

                        // Jahr
                        if (z�hler == 2) {

                            int einlese = einlesen_Zahl(auswahl, z�hler);
                            if (einlese == 999) {
                                savecheck[eingabe] = "";
                                such_eingangsJahr = eingangsJahr;
                            }

                            else if (einlese == 0) {
                            }

                            else {
                                such_eingangsJahr = einlese;
                                /*
                                 * Der Nutzer hat das Attribut Eingangsjahr
                                 * betreten. Somit erh�lt 'safecheck' ein 't' um
                                 * sich zu merken, dass es die Abfrage betreten
                                 * hatte.
                                 */
                                buchstabe_einf�gen_jahr = buchstabe_einf�gen_jahr + "t";
                            }
                        }

                        // 'Eingangsdatum' Sucheingabe abschlie�en
                        if (z�hler == 3) {
                            datumseingabe = false;
                            savecheck[eingabe - 1] = buchstabe_einf�gen_monat;
                            savecheck[eingabe] = buchstabe_einf�gen_jahr;
                        }

                        // 'Eingangsdatum' Sucheingabe abbrechen
                        if (z�hler == 0) {
                            datumseingabe = false;
                        }
                        if (z�hler > 3) {
                            System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit existiert nicht!");
                        }
                    }
                }

                // Fertigstellungsdatum
                if (eingabe == 7) {

                    String[] auswahl = { "Monat", "Jahr" };
                    boolean datumseingabe = true;

                    /*
                     * Variable um zu merken, welche Attributsver�nderungen der
                     * Nutzer betreten hat. Hinzugef�gt zum 'check' werden die
                     * Buchstaben jedoch erst, wenn die Suche abgeschlossen ist,
                     * weil sonst Buchstaben enthalten w�ren f�r
                     * Attribut�nderungen, die garnicht existieren.
                     */

                    String buchstabe_einf�gen_monat = "";
                    String buchstabe_einf�gen_jahr = "";

                    while (datumseingabe == true) {

                        System.out.println("Spezialisierung des zu suchenden Fertigstellungsdatums: Ihre Auswahl: Monat = " + such_fertigMonat + ", Jahr = " + such_fertigJahr);
                        System.out.println("Dr�cke '1' f�r Monat: ");
                        System.out.println("Dr�cke '2' f�r Jahr: ");
                        System.out.println("Dr�cke '3' f�r Best�tigen: ");
                        System.out.println("Dr�cke '4' f�r Abbruch: ");

                        Scanner q = new Scanner(System.in);
                        int z�hler = q.nextInt();

                        // Monat
                        if (z�hler == 1) {

                            int einlese = einlesen_Zahl(auswahl, z�hler);
                            if (einlese == 999) {
                                savecheck[eingabe] = "";
                                such_fertigMonat = fertigMonat;
                            }

                            else if (einlese == 0) {
                            }

                            else {
                                such_fertigMonat = einlese;
                                /*
                                 * Der Nutzer hat das Attribut
                                 * Fertigstellungsmonat betreten. Somit erh�lt
                                 * 'safecheck' ein 'y' um sich zu merken, dass
                                 * es die Abfrage betreten hatte.
                                 */
                                buchstabe_einf�gen_monat = buchstabe_einf�gen_monat + "y";
                            }
                        }

                        // Jahr
                        if (z�hler == 2) {

                            int einlese = einlesen_Zahl(auswahl, z�hler);
                            if (einlese == 999) {
                                savecheck[eingabe + 1] = "";
                                such_fertigJahr = fertigJahr;

                            } else if (einlese == 0) {
                            }

                            else {
                                such_fertigJahr = einlese;
                                /*
                                 * Der Nutzer hat das Attribut
                                 * Fertigstellungsjahr betreten. Somit erh�lt
                                 * 'safecheck' ein 'z' um sich zu merken, dass
                                 * es die Abfrage betreten hatte.
                                 */
                                buchstabe_einf�gen_jahr = buchstabe_einf�gen_jahr + "z";
                            }
                        }

                        // 'Eingangsdatum' Sucheingabe abschlie�en
                        if (z�hler == 3) {
                            datumseingabe = false;
                            savecheck[eingabe] = buchstabe_einf�gen_monat;
                            savecheck[eingabe + 1] = buchstabe_einf�gen_jahr;
                        }

                        // 'Eingangsdatum' Sucheingabe abbrechen
                        if (z�hler == 4) {
                            datumseingabe = false;
                        }
                        if (z�hler > 4) {
                            System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit existiert nicht!");
                        }
                    }
                }

                // Suchvorgang abschlie�en
                if (eingabe == 8) {
                    suchVorgang = false;

                    // Vergleichsvariablen zu den Suchvariablen
                    String vgl_auftragsID = "-";
                    int vgl_wohnungsID = -100;
                    int vgl_mitarbeiterID = -100;
                    String vgl_m�ngelbeschreibung = "-";
                    String vgl_status = "-";
                    int vgl_eingangsMonat = -100;
                    int vgl_eingangsJahr = -100;
                    int vgl_fertigMonat = -100;
                    int vgl_fertigJahr = -100;

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
                    for (Handwerkerauftrag repair : MenuManager.getRepairList()) {

                        if (check.contains("a")) {
                            vgl_auftragsID = repair.getAuftragsID();
                        }
                        if (check.contains("b")) {
                            vgl_wohnungsID = repair.getWohnungsID();
                        }
                        if (check.contains("c")) {
                            vgl_mitarbeiterID = repair.getMitarbeiterID();
                        }
                        if (check.contains("d")) {
                            vgl_m�ngelbeschreibung = repair.getM�ngelbeschreibung();
                        }
                        if (check.contains("e")) {
                            vgl_status = repair.getStatus();
                        }
                        if (check.contains("s")) {
                            vgl_eingangsMonat = repair.getEingangsdatum().getMonat();
                        }
                        if (check.contains("t")) {
                            vgl_eingangsJahr = repair.getEingangsdatum().getJahr();
                        }
                        if (check.contains("y")) {
                            vgl_fertigMonat = repair.getFertigstellungsDatum().getMonat();
                        }
                        if (check.contains("z")) {
                            vgl_fertigJahr = repair.getFertigstellungsDatum().getJahr();
                        }

                        /*
                         * Wenn alle Suchwerte mit den Vergleichswerten
                         * �bereinstimmen wird der Handwerkerauftrag ausgegeben.
                         */
                        if (vgl_auftragsID.equals(such_auftragsID) && vgl_wohnungsID == such_wohnungsID && vgl_mitarbeiterID == such_mitarbeiterID && vgl_m�ngelbeschreibung.contains(such_m�ngelbeschreibung) && vgl_status.contains(such_status) && vgl_eingangsMonat == such_eingangsMonat && vgl_eingangsJahr == such_eingangsJahr && vgl_fertigMonat == such_fertigMonat
                                && vgl_fertigJahr == such_fertigJahr) {
                            System.out.println("Auftrags ID:          " + repair.getAuftragsID());
                            System.out.println("Wohnungs ID:          " + repair.getWohnungsID());
                            System.out.println("Mitarbeiter ID:       " + repair.getMitarbeiterID());
                            System.out.println("M�ngelbeschreibung:   " + repair.getM�ngelbeschreibung());
                            System.out.println("Status:               " + repair.getStatus());
                            System.out.println("Eingangsdatum:        " + repair.getEingangsdatum());
                            System.out.println("Fertigstellungsdatum: " + repair.getFertigstellungsDatum());
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

    /**
     * Methode zum Einlesen einer Zahl vom Nutzer
     *
     * @param auswahl
     *            = welches "�nderungsfeld" der Nutzer betreten hat (Name des Index des Arrays)
     * @param z�hler
     *            = welches "�nderungsfeld" der Nutzer betreten hat (Nummer des Index des Arrays)
     * @return die eingelesene Zahl
     */
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

    /**
     * Methode zum Einlesen eines Wortes oder Satzes vom Nutzer
     *
     * @param auswahl
     *            = welches "�nderungsfeld" der Nutzer betreten hat (Name des Index des Arrays)
     * @param z�hler
     *            = welches "�nderungsfeld" der Nutzer betreten hat (Nummer des Index des Arrays)
     * @return das eingelesene Wort
     */
    private String einlesen_Wort(final String[] auswahl, final int z�hler) {
        System.out.println("Erstellen: " + auswahl[z�hler - 1]);
        Scanner s = new Scanner(System.in);
        String wort = s.nextLine();
        return wort;
    }
}
