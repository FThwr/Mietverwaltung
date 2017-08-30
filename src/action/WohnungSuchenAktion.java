package action;

import java.util.InputMismatchException;
import java.util.Scanner;

import menu.MenuManager;
import objekte.Wohnung;

public class WohnungSuchenAktion extends MenuManager implements Action {
    @Override
    public void action() {

        System.out.println("________________________________________ Wohnung suchen ________________________________________\n");

        boolean suchVorgang = true;

        // Variablen zum Rücksetzen, falls 0 eingegeben wurde
        int wohnungsnummer = -100;
        int zimmeranzahl = -100;
        int etage = -100;
        boolean balkon = false;
        boolean fußbodenheizung = false;
        String aussicht = "-";
        String straße = "-";
        int platz = -100;
        String status = "-";
        int monat = -100;
        int jahr = -100;
        int renovierungsanzahl = -100;
        String handwerkerAuftragID = "-";
        String name = "-";

        // Variablen zur Speicherung des Suchwertes
        int such_wohnungsnummer = wohnungsnummer;
        int such_zimmeranzahl = zimmeranzahl;
        int such_etage = etage;
        boolean such_balkon = balkon;
        boolean such_fußbodenheizung = fußbodenheizung;
        String such_aussicht = aussicht;
        String such_straße = straße;
        int such_platz = platz;
        String such_status = status;
        int such_monat = monat;
        int such_jahr = jahr;
        int such_renovierungsanzahl = renovierungsanzahl;
        String such_handwerkerAuftragID = handwerkerAuftragID;
        String such_name = name;

        String check = "";
        String[] savecheck = new String[14];

        /*
         * Array beeinhaltet alle Attribute, die verändert werden können und
         * dient zur Ausgabe durch Zugriff auf deren Index
         */
        String[] suche = { "Wohnungsnummer", "Zimmeranzahl", "Etage", "Balkon", "Fußbodenheizung", "Aussicht", "Adresse", "Status", "letztes Renovierungsdatum", "Renoveringsanzahl", "Handwerkerauftrag", "zugeordneter Mitarbeiter" };

        /*
         * Mit der Variable wird überprüft, welche Attribut-Abfragen der Nutzer
         * benutzt hatte. Es wird immer ein Buchstabe gespeichert, wodruch die
         * Variable weiß, dass er in der Abfrage was ausgewählt hatte. Später
         * wird anhand dieses Kriteriums die Suche ermöglicht.
         */
        while (suchVorgang == true) {

            Scanner s = new Scanner(System.in);
            System.out.println("............................... Wählen Sie die zu suchende Eigenschaft aus! ...............................");
            System.out.println("........... Aktuelle Suche nach: ...........");
            if (such_wohnungsnummer != -100) {
                System.out.println("1.  Wohnungsnummer:               " + such_wohnungsnummer);
            } else {
                System.out.println("1.  Wohnungsnummer:               " + "-");
            }
            if (such_zimmeranzahl != -100) {
                System.out.println("2.  Zimmeranzahl:                 " + such_zimmeranzahl);
            } else {
                System.out.println("2.  Zimmeranzahl:                 " + "-");
            }
            if (such_etage != -100) {
                System.out.println("3.  Etage:                        " + such_etage);
            } else {
                System.out.println("3.  Etage:                        " + "-");
            }
            System.out.println("4.  Balkon:                       " + such_balkon);

            System.out.println("5.  Fußbodenheizung:              " + such_fußbodenheizung);

            System.out.println("6.  Aussicht:                     " + such_aussicht);

            System.out.println("7.  Adresse:                      ");

            System.out.println("    Straße:                       " + such_straße);
            if (such_platz != -100) {
                System.out.println("    Plz:                          " + such_platz);

            } else {
                System.out.println("    Plz:                          " + "-");
            }
            System.out.println("8. Status:                        " + such_status);
            System.out.print("9. letztes Renovierungsdatum:     ");
            System.out.print("--.");
            if (such_monat != -100) {
                System.out.print(such_monat);
            } else {
                System.out.print("--.");
            }
            if (such_jahr != -100) {
                System.out.println(such_jahr);
            } else {
                System.out.println("----");
            }
            if (such_renovierungsanzahl != -100) {
                System.out.println("10. Renovierungsanzahl:           " + such_renovierungsanzahl);
            } else {
                System.out.println("10. Renovierungsanzahl:           " + "-");
            }
            System.out.println("11. Handwerkerauftrag:            " + such_handwerkerAuftragID);

            System.out.println("12. zugeordneter Miatrbeiter:     " + such_name);

            System.out.println("13. Suche abschließen");
            System.out.println("999. um die zu suchende Eigenschaft zurückzusetzen");
            System.out.println("0.  Abbruch");
            System.out.println("");
            /*
             * Die try-catch Klammer existiert für nicht erwünschte Eingaben wie
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

                // Wohnungsnummer
                if (eingabe == 1) {
                    int einlese = einlesen_Zahl(suche, eingabe);
                    /*
                    * 999 = rückgängig machen des Attributes + löschen des
                    * Buchstabens
                    */
                    if (einlese == 999) {
                        savecheck[eingabe - 1] = "";
                        such_wohnungsnummer = wohnungsnummer;
                    }
                    // 0 = keine Veränderung, nur Abbruch der Abfrage
                    else if (einlese == 0) {
                    }
                    // Eingabe weder 0 noch 999
                    else {
                        // Die Eingabe wird übernommen
                        such_wohnungsnummer = einlese;
                        savecheck[eingabe - 1] = "a";
                    }
                }

                // Zimmeranzahl
                if (eingabe == 2) {

                    int einlese = einlesen_Zahl(suche, eingabe);
                    /*
                    * 999 = rückgängig machen des Attributes + löschen des
                    * Buchstabens
                    */
                    if (einlese == 999) {
                        savecheck[eingabe - 1] = "";
                        such_zimmeranzahl = zimmeranzahl;
                    }
                    // 0 = keine Veränderung, nur Abbruch der Abfrage
                    else if (einlese == 0) {
                    }
                    // Eingabe weder 0 noch 999
                    else {
                        // Die Eingabe wird übernommen
                        such_zimmeranzahl = einlese;
                        savecheck[eingabe - 1] = "b";
                    }
                }

                // Etage
                if (eingabe == 3) {
                    int einlese = einlesen_Zahl(suche, eingabe);
                    /*
                    * 999 = rückgängig machen des Attributes + löschen des
                    * Buchstabens
                    */
                    if (einlese == 999) {
                        savecheck[eingabe - 1] = "";
                        such_etage = etage;
                    }
                    // 0 = keine Veränderung, nur Abbruch der Abfrage
                    else if (einlese == 0) {
                    }
                    // Eingabe weder 0 noch 999
                    else {
                        // Die Eingabe wird übernommen
                        such_etage = einlese;
                        savecheck[eingabe - 1] = "e";
                    }
                }

                // Balkon
                if (eingabe == 4) {

                    Scanner t = new Scanner(System.in);
                    System.out.println("Balkon vorhanden: '1' Ja, '2' Nein, '0' Abbruch!\n");
                    int einlese = t.nextInt();

                    if (einlese == 1) {
                        such_balkon = true;
                        savecheck[eingabe - 1] = "f";
                    }
                    if (einlese == 2) {
                        such_balkon = false;
                        savecheck[eingabe - 1] = "f";
                    }
                    // 0 = keine Veränderung, nur Abbruch der Abfrage
                    if (einlese == 0) {
                    }

                    /*
                    * 999 = rückgängig machen des Attributes + löschen des
                    * Buchstabens
                    */
                    if (einlese == 999) {
                        such_balkon = balkon;
                        savecheck[eingabe - 1] = "";
                    }
                    if (einlese > 2 && einlese < 999) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit existiert nicht!\n");
                    }
                }

                // Fußbodenheizung
                if (eingabe == 5) {
                    Scanner t = new Scanner(System.in);
                    System.out.println("Fußbodenheizung vorhanden: '1' Ja, '2' Nein, '0' Abbruch!\n");
                    int einlese = t.nextInt();

                    if (einlese == 1) {
                        such_fußbodenheizung = true;
                        savecheck[eingabe - 1] = "g";
                    }
                    if (einlese == 2) {
                        such_fußbodenheizung = false;
                        savecheck[eingabe - 1] = "g";
                    }
                    // 0 = keine Veränderung, nur Abbruch der Abfrage
                    if (einlese == 0) {
                    }

                    /*
                     * 999 = rückgängig machen des Attributes + löschen des
                     * Buchstabens
                     */
                    if (einlese == 999) {
                        such_fußbodenheizung = fußbodenheizung;
                        savecheck[eingabe - 1] = "";
                    }
                    if (einlese > 2 && einlese < 999) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit existiert nicht!\n");
                    }
                }

                // Aussicht
                if (eingabe == 6) {
                    Scanner t = new Scanner(System.in);
                    System.out.println("Aussicht auf: '1' Park, '2' Spree, '3' Schienen, '4' Straße, '0' abbruch!\n");
                    int einlese = t.nextInt();

                    if (einlese == 1) {
                        such_aussicht = "Park";
                        savecheck[eingabe - 1] = "h";
                    }
                    if (einlese == 2) {
                        such_aussicht = "Spree";
                        savecheck[eingabe - 1] = "h";
                    }
                    if (einlese == 3) {
                        such_aussicht = "Schienen";
                        savecheck[eingabe - 1] = "h";
                    }
                    if (einlese == 4) {
                        such_aussicht = "Straße";
                        savecheck[eingabe - 1] = "h";
                    }
                    // 0 = keine Veränderung, nur Abbruch der Abfrage
                    if (einlese == 0) {
                    }

                    /*
                    * 999 = rückgängig machen des Attributes + löschen des
                    * Buchstabens
                                        */
                    if (einlese == 999) {
                        such_aussicht = aussicht;
                        savecheck[eingabe - 1] = "";
                    }
                    if (einlese > 4 && einlese < 999) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit existiert nicht!\n");
                    }
                }

                // Adresse
                if (eingabe == 7) {

                    Scanner t = new Scanner(System.in);
                    System.out.println("Geben Sie eine Straße ein: 0 = abbruch!");
                    String einlese = t.next();

                    /*
                    *999 = rückgängig machen des Attributes + löschen des
                    * Buchstabens
                    */
                    if (einlese.equals("" + 999)) {
                        savecheck[eingabe - 1] = "";
                        such_straße = straße;
                    }

                    // 0 = keine Veränderung, nur Abbruch der Abfrage
                    else if (einlese.equals("" + 0)) {

                    }

                    // Eingabe weder 0 noch 999
                    else {

                        // Die Eingabe wird übernommen
                        such_straße = einlese;
                        savecheck[eingabe - 1] = "i";
                    }

                    Scanner r = new Scanner(System.in);
                    System.out.println("Geben Sie eine PLZ ein: 0 = abbruch!");
                    int auswahl = r.nextInt();

                    /*
                    * 999 = rückgängig machen des Attributes + löschen des
                    * Buchstabens
                    */
                    if (auswahl == 999) {
                        savecheck[eingabe] = "";
                        such_platz = platz;
                    }

                    // 0 = keine Veränderung, nur Abbruch der Abfrage
                    else if (auswahl == 0) {
                    } else {
                        // Die Eingabe wird übernommen
                        such_platz = auswahl;
                        savecheck[eingabe] = "j";
                    }
                }

                // Status
                if (eingabe == 8) {
                    Scanner t = new Scanner(System.in);
                    System.out.println("Status der Wohnung: '1' frei, '2' vermietet, '3' in Renovierung, '0' abbruch!");
                    int einlese = t.nextInt();

                    if (einlese == 1) {
                        such_status = "frei";
                        savecheck[eingabe] = "k";
                    }
                    if (einlese == 2) {
                        such_status = "vermietet";
                        savecheck[eingabe] = "k";
                    }
                    if (einlese == 3) {
                        such_status = "in Renovierung";
                        savecheck[eingabe] = "k";
                    }

                    // 0 = keine Veränderung, nur Abbruch der Abfrage
                    if (einlese == 0) {
                    }
                    /*
                    * 999 = rückgängig machen des Attributes + löschen des
                    * Buchstabens
                    */
                    if (einlese == 999) {
                        savecheck[eingabe] = "";
                        such_status = status;
                    }
                    if (einlese > 3 && einlese < 999) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit existiert nicht!\n");
                    }
                }

                // letztes Renovierungsdatum
                if (eingabe == 9) {
                    String[] auswahl = { "Monat", "Jahr" };
                    boolean datumseingabe = true;

                    /*
                     * Variable um zu merken, welche Attributsveränderungen der
                     * Nutzer betreten hat. Hinzugefügt zum 'check' werden die
                     * Buchstaben jedoch erst, wenn die Suche abgeschlossen ist,
                     * weil sonst Buchstaben enthalten wären für
                     * Attributänderungen, die garnicht existieren.
                     */
                    String buchstabe_einfügen_monat = "";
                    String buchstabe_einfügen_jahr = "";

                    while (datumseingabe == true) {

                        System.out.println("Spezialisierung des zu suchenden Fertigstellungsdatums: Ihre Auswahl: Monat = " + such_monat + ", Jahr = " + such_jahr);
                        System.out.println("Drücke '1' für Monat: ");
                        System.out.println("Drücke '2' für Jahr: ");
                        System.out.println("Drücke '3' für Bestätigen: ");
                        System.out.println("Drücke '0' für Abbruch: ");

                        Scanner q = new Scanner(System.in);
                        int zähler = q.nextInt();

                        // Monat
                        if (zähler == 1) {
                            int einlese = einlesen_Zahl(auswahl, zähler);
                            /*
                             * 999 = rückgängig machen des Attributes + löschen des
                            +                                * Buchstabens
                             */
                            if (einlese == 999) {
                                savecheck[eingabe] = "";
                                such_monat = monat;
                            }

                            // 0 = keine Veränderung, nur Abbruch der Abfrage
                            else if (einlese == 0) {
                            }

                            // Eingabe weder 0 noch 999
                            else {

                                // Die Eingabe wird übernommen
                                such_monat = einlese;
                                buchstabe_einfügen_monat = buchstabe_einfügen_monat + "l";
                            }
                        }

                        // Jahr
                        if (zähler == 2) {
                            int einlese = einlesen_Zahl(auswahl, zähler);

                            /*
                            * 999 = rückgängig machen des Attributes + löschen des
                            * Buchstabens
                            */
                            if (einlese == 999) {
                                savecheck[eingabe + 1] = "";
                                such_jahr = jahr;
                            }

                            // 0 = keine Veränderung, nur Abbruch der Abfrage
                            else if (einlese == 0) {
                            }

                            // Eingabe weder 0 noch 999
                            else {

                                // Die Eingabe wird übernommen
                                such_jahr = einlese;
                                buchstabe_einfügen_jahr = buchstabe_einfügen_jahr + "m";

                            }

                            // 'Eingangsdatum' Sucheingabe abschließen
                            if (zähler == 3) {
                                datumseingabe = false;
                                savecheck[eingabe] = buchstabe_einfügen_monat;
                                savecheck[eingabe + 1] = buchstabe_einfügen_jahr;
                            }

                            // 'Eingangsdatum' Sucheingabe abbrechen
                            if (zähler == 0) {
                                datumseingabe = false;
                            }
                            if (zähler > 3) {
                                System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit existiert nicht!\n");
                            }
                        }
                    }
                }

                // Renovierungsanzahl
                if (eingabe == 10) {
                    int einlese = einlesen_Zahl(suche, eingabe);

                    /*
                    * 999 = rückgängig machen des Attributes + löschen des
                    * Buchstabens
                    */
                    if (einlese == 999) {
                        savecheck[eingabe + 1] = "";
                        such_renovierungsanzahl = renovierungsanzahl;
                    }

                    // 0 = keine Veränderung, nur Abbruch der Abfrage
                    else if (einlese == 0) {
                    }

                    // Eingabe weder 0 noch 999
                    else {

                        // Die Eingabe wird übernommen
                        such_renovierungsanzahl = einlese;
                        savecheck[eingabe + 1] = "n";
                    }
                }

                // Handwerkerauftrags-ID
                if (eingabe == 11) {
                    String einlese = einlesen_Wort(suche, eingabe);

                    /*
                    * 999 = rückgängig machen des Attributes + löschen des
                    * Buchstabens
                    */
                    if (einlese.equals("" + 999)) {
                        savecheck[eingabe + 1] = "";
                        such_handwerkerAuftragID = handwerkerAuftragID;
                    }

                    // 0 = keine Veränderung, nur Abbruch der Abfrage
                    else if (einlese.equals("" + 0)) {
                    }

                    // Eingabe weder 0 noch 999
                    else {

                        // Die Eingabe wird übernommen
                        such_handwerkerAuftragID = einlese;
                        savecheck[eingabe + 1] = "o";
                    }
                }

                // zugeordneter Mitarbeiter
                if (eingabe == 12) {
                    String einlese = einlesen_Wort(suche, eingabe);

                    /*
                    * 999 = rückgängig machen des Attributes + löschen des
                    * Buchstabens
                                       */
                    if (einlese.equals("" + 999)) {
                        savecheck[eingabe + 1] = "";
                        such_name = name;
                    }

                    // 0 = keine Veränderung, nur Abbruch der Abfrage
                    else if (einlese.equals("" + 0)) {
                    }

                    // Eingabe weder 0 noch 999
                    else {

                        // Die Eingabe wird übernommen
                        such_name = einlese;
                        savecheck[eingabe + 1] = "p";
                    }
                }

                // Suche abschließen
                if (eingabe == 13) {
                    suchVorgang = false;

                    // Vergleichsvariablen zu den Suchvariablen
                    int vgl_wohnungsnummer = -100;
                    int vgl_zimmeranzahl = -100;
                    int vgl_etage = -100;
                    boolean vgl_balkon = false;
                    boolean vgl_fußbodenheizung = false;
                    String vgl_aussicht = "-";
                    String vgl_straße = "-";
                    int vgl_platz = -100;
                    String vgl_status = "-";
                    int vgl_monat = -100;
                    int vgl_jahr = -100;
                    int vgl_renovierungsanzahl = -100;
                    String vgl_handwerkerAuftragID = "-";
                    String vgl_name = "-";

                    for (int i = 0; i < savecheck.length; i++) {
                        if (savecheck[i] != null) {
                            check = check + savecheck[i];
                        }
                    }

                    /*
                     * Wenn 'check' ein Buchstaben enthält war der Nutzer bei
                     * einer bestimmten Attributveränderung. Wenn ein Buchstabe
                     * nicht enthalten ist, so ist der Suchwert und der
                     * Vergleichswert gleich. Wenn nun ein Buchstabe enthalten
                     * ist wird in jedem Handwerkerauftrag nach der zu suchenden
                     * Eigenschaft gesucht und wenn diese gefunden wurde, wird
                     * das dazugehörige Objekt ausgegeben. Bei mehreren
                     * Buchstaben müssen alle eingegebene Suchattribute in einem
                     * Handwerkerauftrag vorhanden sein, damit eine Ausgabe
                     * ermöglicht werden kann.
                     */
                    for (Wohnung flat : MenuManager.getFlatList()) {

                        if (check.contains("a")) {
                            vgl_wohnungsnummer = flat.getWohnungsID();
                        }
                        if (check.contains("b")) {
                            vgl_zimmeranzahl = flat.getZimmeranzahl();
                        }
                        if (check.contains("e")) {
                            vgl_etage = flat.getEtage();
                        }
                        if (check.contains("f")) {
                            vgl_balkon = flat.getBalkon();
                        }
                        if (check.contains("g")) {
                            vgl_fußbodenheizung = flat.getFußbodenheizung();
                        }
                        if (check.contains("h")) {
                            vgl_aussicht = flat.getAussicht();
                        }
                        if (check.contains("i")) {
                            vgl_straße = flat.getAdresse().getStrasse();
                        }
                        if (check.contains("j")) {
                            vgl_platz = flat.getAdresse().getPlz();
                        }
                        if (check.contains("k")) {
                            vgl_status = flat.getStatus();
                        }
                        if (check.contains("l")) {
                            vgl_monat = flat.getLetztesRenovierungsdatum().getMonat();
                        }
                        if (check.contains("m")) {
                            vgl_jahr = flat.getLetztesRenovierungsdatum().getJahr();
                        }
                        if (check.contains("n")) {
                            vgl_renovierungsanzahl = flat.getRenovierungsanzahl();
                        }
                        if (check.contains("o")) {
                            vgl_handwerkerAuftragID = flat.getHandwerkerauftrag().getAuftragsID();
                        }
                        if (check.contains("p")) {
                            vgl_name = flat.getZugeordneterMitarbeiter().getName();
                        }

                        if (vgl_wohnungsnummer == such_wohnungsnummer && vgl_zimmeranzahl == such_zimmeranzahl && vgl_etage == such_etage && vgl_balkon == such_balkon && vgl_fußbodenheizung == such_fußbodenheizung && vgl_aussicht.contains(such_aussicht) && vgl_straße.contains(such_straße) && vgl_platz == such_platz && vgl_status.contains(such_status) && vgl_monat == such_monat
                                && vgl_jahr == such_jahr && vgl_renovierungsanzahl == such_renovierungsanzahl && vgl_handwerkerAuftragID.equals(such_handwerkerAuftragID) && vgl_name.contains(such_name)) {

                            if (flat.getWohnungsID() != -100) {
                                System.out.println("Wohnungsnummer: " + flat.getWohnungsID());
                            } else {
                                System.out.println("Wohnungsnummer: " + "-");
                            }
                            if (flat.getZimmeranzahl() != -100) {
                                System.out.println("Zimmeranzahl: " + flat.getZimmeranzahl());
                            } else {
                                System.out.println("Zimmeranzahl: " + "-");
                            }
                            if (flat.getFläche() != -100) {
                                System.out.println("Fläche: " + flat.getFläche());
                            } else {
                                System.out.println("Fläche: " + "-");
                            }
                            if (flat.getKosten() != -100) {
                                System.out.println("Kosten: " + flat.getKosten());
                            } else {
                                System.out.println("Kosten: " + "-");
                            }
                            if (flat.getEtage() != -100) {
                                System.out.println("Etage: " + flat.getEtage());
                            } else {
                                System.out.println("Etage: " + "-");
                            }
                            System.out.println("Balkon: " + flat.getBalkon());
                            System.out.println("Fußbodenheizung: " + flat.getFußbodenheizung());
                            System.out.println("Aussicht: " + flat.getAussicht());
                            if (flat.getAdresse() != null) {
                                System.out.println("Adresse: " + flat.getAdresse());
                            } else {
                                System.out.println("Adresse: " + "-");
                            }
                            System.out.println("Status: " + flat.getStatus());
                            if (flat.getLetztesRenovierungsdatum() != null) {
                                System.out.println("letztes Renovierungsdatum: " + flat.getLetztesRenovierungsdatum());
                            } else {
                                System.out.println("letztes Renovierungsdatum: " + "--.--.----");
                            }
                            if (flat.getRenovierungsanzahl() != -100) {
                                System.out.println("Renovierungsanzahl: " + flat.getRenovierungsanzahl());
                            } else {
                                System.out.println("Renovierungsanzahl: " + "-");
                            }
                            System.out.println("letze Renovierungdetails: " + flat.getLetzeRenovierung_Details());
                            System.out.println("Handwerkerauftrag-ID: " + flat.getHandwerkerauftrag().getAuftragsID());
                            if (flat.getZugeordneterMitarbeiter() != null) {
                                System.out.println("zugeordneter Mitarbeiter: " + flat.getZugeordneterMitarbeiter().getName());
                            } else {
                                System.out.println("zugeordneter Mitarbeiter: " + "-");
                            }
                            System.out.println("");

                        }
                    }
                }
                // Eingabe > 13
                if (eingabe > 13) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit existiert nicht!\n");
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
     *            = welches "Änderungsfeld" der Nutzer betreten hat (Name des Index des Arrays)
     * @param zähler
     *            = welches "Änderungsfeld" der Nutzer betreten hat (Nummer des Index des Arrays)
     * @return die eingelesene Zahl
     */
    private int einlesen_Zahl(final String[] auswahl, final int zähler) {
        Scanner s = new Scanner(System.in);
        int zahl = -100;
        try {

            do {
                System.out.println("Geben Sie ein: " + auswahl[zähler - 1]);
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
     *            = welches "Änderungsfeld" der Nutzer betreten hat (Name des Index des Arrays)
     * @param zähler
     *            = welches "Änderungsfeld" der Nutzer betreten hat (Nummer des Index des Arrays)
     * @return das eingelesene Wort
     */
    private String einlesen_Wort(final String[] auswahl, final int zähler) {
        System.out.println("Erstellen: " + auswahl[zähler - 1]);
        Scanner s = new Scanner(System.in);
        String wort = s.nextLine();
        return wort;
    }
}