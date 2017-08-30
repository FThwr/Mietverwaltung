package action;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

import menu.MenuManager;
import objekte.Mietvertrag;

public class MietvertragSuchenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ Mietvertrag suchen ________________________________________");

        boolean suchVorgang = true;

        // Variablen zum Rücksetzen, falls 0 eingegeben wurde

        int mietvertragID = -100;
        int wohnungsID = -100;
        int kundenID = -100;
        int mitarbeiterID = -100;
        int beginnMonat = -100;
        int beginnJahr = -100;
        int endeMonat = -100;
        int endeJahr = 100;
        String status = "-";

        // Variablen zur Speicherung des Suchwertes
        int such_mietvertragID = mietvertragID;
        int such_wohnungsID = wohnungsID;
        int such_kundenID = kundenID;
        int such_mitarbeiterID = mitarbeiterID;
        int such_beginnMonat = beginnMonat;
        int such_beginnJahr = beginnJahr;
        int such_endeMonat = endeMonat;
        int such_endeJahr = endeJahr;
        String such_status = status;

        /*
         * Array beeinhaltet alle Attribute, die verändert werden können und
         * dient zur Ausgabe durch Zugriff auf deren Index
         */
        String[] kategorie = { "Mietvertrag-ID", "Wohnungs-ID", "Kunden-ID", "Mitarbeiter-ID", "Mietbeginn", "Mietende", "Status" };

        /*
         * Mit den Variablen wird überprüft, welche Attribut-Abfragen der Nutzer
         * benutzt hatte. Es wird immer ein Buchstabe gespeichert, wodruch die
         * Variable weiß, dass er in der Abfrage was ausgewählt hatte. Später
         * wird anhand dieses Kriteriums die Suche ermöglicht.
         */
        String check = "";
        String[] savecheck = new String[9];

        /*
         * Solange der Suchvorgang nicht beendet ist, wird immer eine Übersicht
         * über die zu suchenden Werte ausgegeben, sofern das Attribut
         * ausgewählt wurde. Wenn das Attribut nicht ausgewählt wurde, wird ein
         * '-' angezeigt. Es wird pro Durchlauf immer 1 Attribut ausgewählt,
         * welches man draufhin verändern kann.
         */
        while (suchVorgang == true) {

            Scanner s = new Scanner(System.in);
            System.out.println("............................... Wählen Sie die zu suchende Eigenschaft aus! ...............................");

            System.out.println("........... Aktuelle Suche nach: ...........");

            System.out.println("1. Mievertrag-ID:                 " + such_mietvertragID);
            if (such_wohnungsID != -100) {
                System.out.println("2. Wohnungs-ID:                  " + such_wohnungsID);
            } else {
                System.out.println("2. Wohnungs-ID:                 " + "-");
            }
            if (such_kundenID != -100) {
                System.out.println("3. Kunden-ID:                      " + such_kundenID);
            } else {
                System.out.println("3. Kunden-ID:                        " + "-");
            }
            if (such_mitarbeiterID != -100) {
                System.out.println("4. Mitarbeiter-ID:                   " + such_mitarbeiterID);
            } else {
                System.out.println("4. Mitarbeiter-ID:                   " + "-");
            }
            System.out.print("5. Mietbeginn:                       ");
            System.out.print("--.");

            if (such_beginnMonat != -100) {
                System.out.print(such_beginnMonat);
            } else {
                System.out.print("--.");
            }
            if (such_beginnJahr != -100) {
                System.out.println(such_beginnJahr);
            } else {
                System.out.println("----");
            }

            System.out.print("6. Mietende:                         ");
            System.out.print("--.");

            if (such_endeMonat != -100) {
                System.out.print(such_endeMonat);
            } else {
                System.out.print("--.");
            }
            if (such_endeJahr != -100) {
                System.out.println(such_endeJahr);
            } else {
                System.out.println("----");
            }
            System.out.println("7. Status                        " + such_status);
            System.out.println("8. Suche bestätigen");
            System.out.println("999. um die zu suchende Eigenschaft zurückzusetzen");
            System.out.println("0. generell Abbruch");
            System.out.println("");
            /*
             * Die try-catch Klammer existiert für nicht erwünschte Eingaben wie
             * Zeichen, wo Zahlen erwartet werden.
             */
            try {
                int eingabe = s.nextInt();

                // Abbruch
                if (eingabe == 0) {
                    System.out.println("-------------------------------Suchvorgang wurde abgebrochen!-------------------------------\n");
                    suchVorgang = false;
                }

                // Mietvertrags-ID
                if (eingabe == 1) {
                    String einlese = einlesen_Wort(kategorie, eingabe);

                    /*
                    * 999 = rückgängig machen des Attributes + löschen des
                    * Buchstabens
                    */
                    if (einlese.equals("" + 999)) {
                        savecheck[eingabe - 1] = "";
                        such_mietvertragID = mietvertragID;
                    }

                    // 0 = keine Veränderung, nur Abbruch der Abfrage
                    else if (einlese.equals("" + 0)) {
                    }

                    // Eingabe weder 0 noch 999
                    else {
                        // Die Eingabe wird übernommen
                        try {
                            such_mietvertragID = Integer.parseInt(einlese);
                        } catch (NumberFormatException e) {
                            System.out.println("\n------------------------------- Fehler! ------------------------------- \nKeine Nummer!");
                        }
                        savecheck[eingabe - 1] = "a";
                    }
                }

                // Wohnungsnummer
                if (eingabe == 2) {
                    int einlese = einlesen_Zahl(kategorie, eingabe);

                    /*
                    * 999 = rückgängig machen des Attributes + löschen des
                    * Buchstabens
                    */
                    if (einlese == 999) {
                        savecheck[eingabe - 1] = "";
                        such_wohnungsID = wohnungsID;
                    }

                    // 0 = keine Veränderung, nur Abbruch der Abfrage
                    else if (einlese == 0) {
                    }

                    // Eingabe weder 0 noch 999
                    else {

                        // Die Eingabe wird übernommen
                        such_wohnungsID = einlese;
                        savecheck[eingabe - 1] = "b";
                    }
                }

                // Mieter-ID
                if (eingabe == 3) {
                    int einlese = einlesen_Zahl(kategorie, eingabe);

                    /*
                    * 999 = rückgängig machen des Attributes + löschen des
                    * Buchstabens
                    */
                    if (einlese == 999) {
                        savecheck[eingabe - 1] = "";
                        such_kundenID = kundenID;
                    }

                    // 0 = keine Veränderung, nur Abbruch der Abfrage
                    else if (einlese == 0) {
                    }

                    // Eingabe weder 0 noch 999
                    else {

                        // Die Eingabe wird übernommen
                        such_kundenID = einlese;
                        savecheck[eingabe - 1] = "c";
                    }
                }

                // Mitarbeiter-ID
                if (eingabe == 4) {
                    int einlese = einlesen_Zahl(kategorie, eingabe);

                    /*
                    * 999 = rückgängig machen des Attributes + löschen des
                    * Buchstabens
                    */
                    if (einlese == 999) {
                        savecheck[eingabe - 1] = "";
                        such_mitarbeiterID = mitarbeiterID;
                    }

                    // 0 = keine Veränderung, nur Abbruch der Abfrage
                    else if (einlese == 0) {
                    }

                    // Eingabe weder 0 noch 999
                    else {

                        // Die Eingabe wird übernommen
                        such_mitarbeiterID = einlese;
                        savecheck[eingabe - 1] = "d";
                    }
                }

                // Mietbeginn
                if (eingabe == 5) {
                    System.out.println("Spezialisierung des zu suchenden Mietbeginns: --." + such_beginnMonat + "." + such_beginnJahr);
                    System.out.println("Drücke '1'  für Monat: ");
                    System.out.println("Drücke '2'  für Jahr:  ");
                    System.out.println("Drücke '3'  für Bestätigen: ");
                    System.out.println("Drücke '0'  für Abbruch: ");

                    String[] auswahl = { "Monat", "Jahr" };
                    boolean datumseingabe = true;

                    String buchstabe_einfügen_monat = "";
                    String buchstabe_einfügen_jahr = "";

                    while (datumseingabe == true) {

                        Scanner q = new Scanner(System.in);
                        int zähler = q.nextInt();

                        // Monat
                        if (zähler == 1) {
                            int einlese = einlesen_Zahl(auswahl, zähler);

                            /*
                            * 999 = rückgängig machen des Attributes + löschen des
                            * Buchstabens
                            */
                            if (einlese == 999) {
                                savecheck[eingabe - 1] = "";
                                such_beginnMonat = beginnMonat;
                            }

                            // 0 = keine Veränderung, nur Abbruch der Abfrage
                            else if (einlese == 0) {
                            }

                            // Eingabe weder 0 noch 999
                            else {

                                // Die Eingabe wird übernommen
                                such_beginnMonat = einlese;
                                buchstabe_einfügen_monat = buchstabe_einfügen_monat + "e";
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
                                savecheck[eingabe] = "";
                                such_beginnJahr = beginnJahr;
                            }

                            // 0 = keine Veränderung, nur Abbruch der Abfrage
                            else if (einlese == 0) {
                            }

                            // Eingabe weder 0 noch 999
                            else {

                                // Die Eingabe wird übernommen
                                such_beginnJahr = einlese;
                                /*
                                 * Der Nutzer hat das Attribut Mietbeginn-Jahr betreten. Somit
                                 * erhält 'savecheck' ein 'f' um sich zu merken, dass es die
                                 * Abfrage betreten hatte.
                                 */
                                buchstabe_einfügen_jahr = buchstabe_einfügen_jahr + "f";
                            }

                            // Datum bestätigen
                            if (zähler == 3) {
                                datumseingabe = false;
                                savecheck[eingabe - 1] = buchstabe_einfügen_monat;
                                savecheck[eingabe] = buchstabe_einfügen_jahr;
                            }
                        }
                        // Eingabe abbrechen
                        if (zähler == 0) {
                            datumseingabe = false;
                        }

                        // Eingabe > 3
                        if (zähler > 3) {
                            System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit existiert nicht!\n");
                        }
                    }
                }

                // Mietende
                if (eingabe == 6) {
                    System.out.println("Spezialisierung des zu suchenden Mietendes: --." + such_endeMonat + "." + such_endeJahr);
                    System.out.println("Drücke '1' für Monat: ");
                    System.out.println("Drücke '2' für Jahr:  ");
                    System.out.println("Drücke '3' für Bestätigen: ");
                    System.out.println("Drücke '0' für Abbruch: ");

                    String[] auswahl = { "Monat", "Jahr" };
                    boolean datumseingabe = true;

                    String buchstabe_einfügen_monat = "";
                    String buchstabe_einfügen_jahr = "";

                    while (datumseingabe == true) {

                        Scanner q = new Scanner(System.in);
                        int zähler = q.nextInt();

                        // Monat
                        if (zähler == 1) {
                            int einlese = einlesen_Zahl(auswahl, zähler);

                            /*
                            * 999 = rückgängig machen des Attributes + löschen des
                            * Buchstabens
                            */
                            if (einlese == 999) {
                                savecheck[eingabe] = "";
                                such_endeMonat = endeMonat;
                            }

                            // 0 = keine Veränderung, nur Abbruch der Abfrage
                            else if (einlese == 0) {
                            }

                            // Eingabe weder 0 noch 999
                            else {

                                // Die Eingabe wird übernommen
                                such_endeMonat = einlese;
                                buchstabe_einfügen_monat = buchstabe_einfügen_monat + "g";
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
                                such_endeJahr = endeJahr;
                            }

                            // 0 = keine Veränderung, nur Abbruch der Abfrage
                            else if (einlese == 0) {
                            }

                            // Eingabe weder 0 noch 999
                            else {

                                // Die Eingabe wird übernommen
                                such_endeJahr = einlese;
                                /*
                                 * Der Nutzer hat das Attribut Mietende-Jahr betreten. Somit
                                 * erhält 'savecheck' ein 'h' um sich zu merken, dass es die
                                 * Abfrage betreten hatte.
                                 */
                                buchstabe_einfügen_jahr = buchstabe_einfügen_jahr + "h";
                            }
                        }

                        // Datum bestätigen
                        if (zähler == 3) {
                            datumseingabe = false;
                            savecheck[eingabe] = buchstabe_einfügen_monat;
                            savecheck[eingabe + 1] = buchstabe_einfügen_jahr;
                        }

                        // Eingabe abbrechen
                        if (zähler == 0) {
                            datumseingabe = false;
                        }

                        // Eingabe > 3
                        if (zähler > 3) {
                            System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit existiert nicht!\n");
                        }
                    }
                }

                // Status
                if (eingabe == 7) {
                    String einlese = einlesen_Wort(kategorie, eingabe);

                    /*
                    * 999 = rückgängig machen des Attributes + löschen des
                    * Buchstabens
                    */
                    if (einlese.equals("" + 999)) {
                        savecheck[eingabe + 1] = "";
                        such_status = status;
                    }
                    // 0 = keine Veränderung, nur Abbruch der Abfrage
                    else if (einlese.equals("" + 0)) {
                    }

                    // Eingabe weder 0 noch 999
                    else {

                        // Die Eingabe wird übernommen
                        such_status = einlese;
                        savecheck[eingabe + 1] = "i";
                    }
                }
                // Suche bestätigen
                if (eingabe == 8) {
                    suchVorgang = false;

                    // Vergleichsvariablen zu den Suchvariablen
                    int vgl_mietvertragID = -100;
                    int vgl_wohnungsID = -100;
                    int vgl_kundenID = -100;
                    int vgl_mitarbeiterID = -100;
                    int vgl_beginnMonat = -100;
                    int vgl_beginnJahr = -100;
                    int vgl_endeMonat = -100;
                    int vgl_endeJahr = -100;
                    String vgl_status = "-";

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
                    for (Mietvertrag contract : MenuManager.getContractList()) {

                        if (check.contains("a")) {
                            vgl_mietvertragID = contract.getMietvertragsID();
                        }
                        if (check.contains("b")) {
                            vgl_wohnungsID = contract.getWohnungsID();
                        }
                        if (check.contains("c")) {
                            vgl_kundenID = contract.getKundenID();
                        }
                        if (check.contains("d")) {
                            vgl_mitarbeiterID = contract.getMitarbeiterID();
                        }
                        if (check.contains("e")) {
                            vgl_beginnMonat = contract.getMietBeginn().getMonat();
                        }
                        if (check.contains("f")) {
                            vgl_beginnJahr = contract.getMietBeginn().getJahr();
                        }
                        if (check.contains("g")) {
                            vgl_endeMonat = contract.getMietEnde().getMonat();
                        }
                        if (check.contains("h")) {
                            vgl_endeJahr = contract.getMietEnde().getJahr();
                        }
                        if (check.contains("i")) {
                            vgl_status = contract.getStatus();
                        }

                        /*
                         * Wenn alle Suchwerte mit den Vergleichswerten
                         * übereinstimmen wird der Mietvertrag ausgegeben.
                         */
                        if (vgl_mietvertragID == (such_mietvertragID) && vgl_wohnungsID == such_wohnungsID && vgl_kundenID == such_kundenID && vgl_mitarbeiterID == such_mitarbeiterID && vgl_beginnMonat == such_beginnMonat && vgl_beginnJahr == such_beginnJahr && vgl_endeMonat == such_endeMonat && vgl_endeJahr == such_endeJahr && vgl_status.equals(such_status)) {

                            System.out.println("Mietvertrag-ID:       " + contract.getMietvertragsID());
                            if (contract.getWohnungsID() != -100) {
                                System.out.println("Wohnungs-ID:          " + contract.getWohnungsID());
                            } else {
                                System.out.println("Wohnungs-ID:          " + "-");
                            }
                            if (contract.getKundenID() != -100) {
                                System.out.println("Kunden-ID:            " + contract.getKundenID());
                            } else {
                                System.out.println("Kunden-ID:            " + "-");
                            }
                            if (contract.getMitarbeiterID() != -100) {
                                System.out.println("Mitarbeiter-ID:       " + contract.getMitarbeiterID());
                            } else {
                                System.out.println("Mitarbeiter-ID:       " + "-");
                            }
                            if (contract.getMietBeginn() != null) {
                                System.out.println("Mietbeginn:           " + contract.getMietBeginn());
                            } else {
                                System.out.println("Mietbeginn:           " + "--.--.----");
                            }
                            if (contract.getMietEnde() != null) {
                                System.out.println("Mietende:             " + contract.getMietEnde());
                            } else {
                                System.out.println("Mietende:             " + "--.--.----");
                            }
                            System.out.println("Status:               " + contract.getStatus());
                            System.out.println("");
                        }
                    }
                }
                // Eingabe > 8
                if (eingabe > 8) {
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
        while (zahl == -100) {
            try {

                do {
                    System.out.println("Geben Sie ein: " + auswahl[zähler - 1]);
                    zahl = s.nextInt();
                    if (zahl < 0) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nNur positive Zahlen erlaubt!");
                    }
                } while (zahl < 0);
            } catch (InputMismatchException e) {

                String eingabeString = s.nextLine();
                if (eingabeString.equals("Januar")) {
                	zahl = 1;
                } else if (eingabeString.equals("Februar")) {
                	zahl = 2;
                } else if (eingabeString.equals("März")) {
                	zahl = 3;
                } else if (eingabeString.equals("April")) {
                	zahl = 4;
                } else if (eingabeString.equals("Mai")) {
                	zahl = 5;
                } else if (eingabeString.equals("Juni")) {
                	zahl = 6;
                } else if (eingabeString.equals("Juli")) {
                	zahl = 7;
                } else if (eingabeString.equals("August")) {
                	zahl = 8;
                } else if (eingabeString.equals("September")) {
                	zahl = 9;
                } else if (eingabeString.equals("Oktober")) {
                	zahl = 10;
                } else if (eingabeString.equals("November")) {
                	zahl = 11;
                } else if (eingabeString.equals("Dezember")) {
                	zahl = 12;
                } else {
                	System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
                }
                
            }
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
