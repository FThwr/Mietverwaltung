package action;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hilfsklassen.Adresse;
import hilfsklassen.Datum;
import menu.MenuManager;
import objekte.Mieter;
import objekte.Mitarbeiter;
import objekte.Wohnung;

public class WohnungBearbeitenAction extends MenuManager implements Action {

    static boolean window = false;
    static int bearbeitungsAuswahl_WohnungsID;
    static int JFrame_wohnungsnummer_auswahl;
    static int JFrame_mitarbeiterID_auswahl;

    @Override
    public void action() {

        System.out.println("________________________________________ Wohnung bearbeiten ________________________________________\n");

        /*
         * Variable zum Öffnen des richtigen JFrames und zur Auswahl des zu
         * bearbeitenden Attributs.
         */
        int änderung = -99;

        // Ausgabe aller Wohnungsnummern  zur einfacheren Auswahl
        JComboBox_optimierte_Auswahl(änderung);

        // Variable enthält die ID der zu bearbeitenden Wohnung
        int zu_bearbeitende_wohnung = WohnungBearbeitenAction.bearbeitungsAuswahl_WohnungsID;

        boolean bearbeitungsVorgang = true;

        /*
         * Array beeinhaltet alle Attribute, die verändert werden können und
         * dient zur Ausgabe durch Zugriff auf deren Index
         */
        String[] buttons = { "Wohnungsnummer", "Zimmeranzahl", "Fläche", "Kosten", "Etage", "Balkon", "Fußbodenheizung", "Aussicht", "Adresse", "letztes Renovierungsdatum", "Renovierungsanzahl", "letztes Renovierungsdetails", "zugeordneten Mitarbeiter" };

        /*
         * diese Variablen dienen später für eine tabellarische Ausgabe auf der
         * Konsole
         */
        String längenAnpassung_ID = "";
        String längenAnpassung_ZA = "";
        String längenAnpassung_FL = "";
        String längenAnpassung_KT = "";
        String längenAnpassung_EG = "";
        String längenAnpassung_BK = "";
        String längenAnpassung_FBH = "";
        String längenAnpassung_AS = "";
        String längenAnpassung_ST = "";
        String längenAnpassung_RA = "";
        String längenAnpassung_LRI = "";

        /*
         * allgemeine Variablen alte = aktuelle Werte, neue = neue/veränderte
         * Werte
         */
        int aktuelleID = -100;
        int neueID = -100;

        int aktuelle_zimmeranzahl = -100;
        int neue_zimmeranzahl = -100;

        double aktuelle_fläche = -100;
        double neue_fläche = -100;

        double aktuelle_kosten = -100;
        double neue_kosten = -100;

        int aktuelle_etage = -100;
        int neue_etage = -100;

        boolean aktuelle_balkon = false;
        boolean neue_balkon = false;

        boolean aktuelle_fußbodenheizung = false;
        boolean neue_fußbodenheizung = false;

        String aktuelle_aussicht = "-";
        String neue_aussicht = "-";

        Adresse aktuelle_adresse = null;
        Adresse neue_adresse = null;

        String aktuelle_status = "-";
        String neue_status = "-";

        Datum aktuelle_letztesRenovierungsdatum = null;
        Datum neue_letzesRenovierungsdatum = null;

        int aktuelle_renovierungsanzahl = -100;
        int neue_renovierungsanzahl = -100;

        String aktuelle_letzeRenovierung_Details = "-";
        String neue_letzeRenovierung_Details = "-";

        Mitarbeiter aktuelle_zugeordneterMitarbeiter = null;
        Mitarbeiter neue_zugeordneterMitarbeiter = null;

        /*
         * Variablen enthalten die Leerzeichen, die nach den Objekten (Daten)
         * eingesetzt werden. Die Längen der einzelnen Komponenten der Objekte
         * werden verwendet. ADR = Adresse , LRDT = Letztes Renovierungsdatum,
         * ZM = zugeordneter Mitarbeiter.
         */
        String ADR_Leerzeichen = "";
        String LRDT_Leerzeichen = "";
        String ZM_Leerzeichen = "";

        /*
         * Für jedes Element in der Wohnungsliste wird zeurst das Objekt in der
         * ArrayList gesucht, welche der eben ausgewählten Wohnungs-ID
         * entspricht. Es werden neue Variablen angelegt, welche die einzelnen
         * Werte des Objekts beeinhalten..
         */
        for (Wohnung flat : MenuManager.flatList) {
            if (zu_bearbeitende_wohnung == flat.getWohnungsID()) {

                aktuelleID = flat.getWohnungsID();
                neueID = aktuelleID;

                aktuelle_zimmeranzahl = flat.getZimmeranzahl();
                neue_zimmeranzahl = aktuelle_zimmeranzahl;

                aktuelle_fläche = flat.getFläche();
                neue_fläche = aktuelle_fläche;

                aktuelle_kosten = flat.getKosten();
                neue_kosten = aktuelle_kosten;

                aktuelle_etage = flat.getEtage();
                neue_etage = aktuelle_etage;

                aktuelle_balkon = flat.getBalkon();
                neue_balkon = aktuelle_balkon;

                aktuelle_fußbodenheizung = flat.getFußbodenheizung();
                neue_fußbodenheizung = aktuelle_fußbodenheizung;

                aktuelle_aussicht = flat.getAussicht();
                neue_aussicht = aktuelle_aussicht;

                aktuelle_adresse = flat.getAdresse();
                neue_adresse = aktuelle_adresse;

                aktuelle_status = flat.getStatus();
                neue_status = aktuelle_status;

                aktuelle_letztesRenovierungsdatum = flat.getLetztesRenovierungsdatum();
                neue_letzesRenovierungsdatum = aktuelle_letztesRenovierungsdatum;

                aktuelle_renovierungsanzahl = flat.getRenovierungsanzahl();
                neue_renovierungsanzahl = aktuelle_renovierungsanzahl;

                aktuelle_letzeRenovierung_Details = flat.getLetzeRenovierung_Details();
                neue_letzeRenovierung_Details = aktuelle_letzeRenovierung_Details;

                aktuelle_zugeordneterMitarbeiter = flat.getZugeordneterMitarbeiter();
                neue_zugeordneterMitarbeiter = aktuelle_zugeordneterMitarbeiter;

                /*
                 * Initialisierung der tabellarischen Variablen + Ausfüllung mit
                 * Leerzeichen (Umwandlung in die Tabelle)
                 */
                längenAnpassung_ID = "" + aktuelleID;
                längenAnpassung_ID = länge_anpassen(längenAnpassung_ID);

                längenAnpassung_ZA = "" + aktuelle_zimmeranzahl;
                längenAnpassung_ZA = länge_anpassen(längenAnpassung_ZA);

                längenAnpassung_FL = "" + aktuelle_fläche;
                längenAnpassung_FL = länge_anpassen(längenAnpassung_FL);

                längenAnpassung_KT = "" + aktuelle_kosten;
                längenAnpassung_KT = länge_anpassen(längenAnpassung_KT);

                längenAnpassung_EG = "" + aktuelle_etage;
                längenAnpassung_EG = länge_anpassen(längenAnpassung_EG);

                längenAnpassung_BK = "" + aktuelle_balkon;
                längenAnpassung_BK = länge_anpassen(längenAnpassung_BK);

                längenAnpassung_FBH = "" + aktuelle_fußbodenheizung;
                längenAnpassung_FBH = länge_anpassen(längenAnpassung_FBH);

                längenAnpassung_AS = aktuelle_aussicht;
                längenAnpassung_AS = länge_anpassen(längenAnpassung_AS);

                längenAnpassung_ST = aktuelle_status;
                längenAnpassung_ST = länge_anpassen(längenAnpassung_ST);

                längenAnpassung_RA = "" + aktuelle_renovierungsanzahl;
                längenAnpassung_RA = länge_anpassen(längenAnpassung_RA);

                längenAnpassung_LRI = aktuelle_letzeRenovierung_Details;
                längenAnpassung_LRI = länge_anpassen(längenAnpassung_LRI);

                if (aktuelle_adresse != null) {
                    ADR_Leerzeichen = länge_anpassen_Adresse(aktuelle_adresse);
                }
                if (aktuelle_letztesRenovierungsdatum != null) {
                    LRDT_Leerzeichen = länge_anpassen_Datum(aktuelle_letztesRenovierungsdatum);
                }
                if (aktuelle_zugeordneterMitarbeiter != null) {
                    ZM_Leerzeichen = länge_anpassen_Mitarbeiter(aktuelle_zugeordneterMitarbeiter);
                }

                ADR_Leerzeichen = länge_anpassen_Adresse(aktuelle_adresse);
                LRDT_Leerzeichen = länge_anpassen_Datum(aktuelle_letztesRenovierungsdatum);
                ZM_Leerzeichen = länge_anpassen_Mitarbeiter(aktuelle_zugeordneterMitarbeiter);

            }
        }

        /*
         * Solange der Bearbeitungsvorgang nicht beendet ist, wird immer eine
         * Übersicht über den alten Wert und den neuen Wert des jeweiligen
         * Attributs ausgegeben. Es wird pro Durchlauf immer 1 Attribut
         * ausgewählt, welches man draufhin verändern kann.
         */
        while (bearbeitungsVorgang == true) {

            Scanner t = new Scanner(System.in);

            System.out.println("Änderungsübersicht:");
            System.out.println("Drücken Sie die Zahl vor der Zeile, um eine Änderung vorzunehmen!");
            System.out.println("1.  aktuelle Wohnungsnummer:            " + längenAnpassung_ID + "neue Wohnungsnummer:            " + neueID);
            System.out.println("2.  aktuelle Zimmeranzahl:              " + längenAnpassung_ZA + "neue Zimmeranzahl:              " + neue_zimmeranzahl);
            System.out.println("3.  aktuelle Fläche:                    " + längenAnpassung_FL + "neue Fläche:                    " + neue_fläche);
            System.out.println("4.  aktuelle Kosten:                    " + längenAnpassung_KT + "neue Kosten:                    " + neue_kosten);
            System.out.println("5.  aktuelle Etage:                     " + längenAnpassung_EG + "neue Etage:                     " + neue_etage);
            System.out.println("6.  aktuelle Balkon:                    " + längenAnpassung_BK + "neue Balkon:                    " + neue_balkon);
            System.out.println("7.  aktuelle Fußbodenheizung:           " + längenAnpassung_FBH + "neue Fußbodenheizung:           " + neue_fußbodenheizung);
            System.out.println("8.  aktuelle Aussicht:                  " + längenAnpassung_AS + "neue Aussicht:                  " + neue_aussicht);
            System.out.println("9.  aktuelle Adresse:                   " + aktuelle_adresse + ADR_Leerzeichen + "neue Adresse:                   " + neue_adresse);
            System.out.println("10. aktueller Status:                   " + längenAnpassung_ST + "neuer Status:                   " + neue_status);
            System.out.println("11. letztes Renovierungsdatum:          " + aktuelle_letztesRenovierungsdatum + LRDT_Leerzeichen + "geändertes Renovierungsdatum:   " + neue_letzesRenovierungsdatum);
            System.out.println("12. aktuelle Renovierungsanzahl:        " + längenAnpassung_RA + "neue Renovierungsanzahl:        " + neue_renovierungsanzahl);
            System.out.println("13. letzte Renvierungsdetails:          " + längenAnpassung_LRI + "geänderte Renovierungsdetails:  " + neue_letzeRenovierung_Details);
            System.out.println("14. aktuelle zugeordneten Mitarbeiter:  " + aktuelle_zugeordneterMitarbeiter + ZM_Leerzeichen + "neue zugeordneten Mitarbeiter:  " + neue_zugeordneterMitarbeiter);
            System.out.println("15. Bestätigen");
            System.out.println("0.  Abbruch");
            System.out.println("");

            /*
             * Die try-catch Klammer existiert für nicht erwünschte Eingaben wie
             * Zeichen, wo Zahlen erwartet werden.
             */
            try {
                änderung = t.nextInt();

                // Abbruch
                if (änderung == 0) {
                    System.out.println("-------------------------------Bearbeitungsvorgang wurde abgebrochen!-------------------------------\n");
                    bearbeitungsVorgang = false;
                }

                // Wohnungsnummer
                if (änderung == 1) {
                    JComboBox_optimierte_Auswahl(änderung);
                    neueID = WohnungBearbeitenAction.JFrame_wohnungsnummer_auswahl;
                }

                // Zimmeranzahl
                if (änderung == 2) {

                    int eingabe = einlesen_Zahl(buttons, änderung);
                    if (eingabe == 0) {
                    } else {
                        neue_zimmeranzahl = eingabe;
                    }
                }

                // Fläche
                if (änderung == 3) {
                    double eingabe = double_eingabe(buttons, änderung);
                    if (eingabe == 0) {
                    } else {
                        neue_fläche = eingabe;
                    }
                }

                // Kosten
                if (änderung == 4) {

                    double eingabe = double_eingabe(buttons, änderung);
                    if (eingabe == 0) {
                    } else {
                        neue_kosten = eingabe;
                    }
                }

                // Etage
                if (änderung == 5) {
                    int eingabe = einlesen_Zahl(buttons, änderung);
                    if (eingabe == 0) {
                    } else {
                        neue_etage = eingabe;
                    }
                }

                // Balkon
                if (änderung == 6) {

                    System.out.println("Balkonauswahl: Geben Sie die Zahl ein: '1' = JA, '2' = NEIN, '0' = Abbruch!");
                    int eingabe = einlesen_Zahl(buttons, änderung);

                    if (eingabe == 1) {
                        neue_balkon = true;
                    }
                    if (eingabe == 2) {
                        neue_balkon = false;
                    }

                    if (eingabe == 0) {
                    }

                    // Jede andere Eingabe führt zu einer Fehlermeldung.
                    if (eingabe > 2) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit nicht vorhanden!\n");
                    }
                }

                // Fußbodenheizung
                if (änderung == 7) {
                    System.out.println("Fußbodenheizungsauswahl: Geben Sie die Zahl ein: '1' = JA, '2' = NEIN, '0' = Abbruch!");
                    int eingabe = einlesen_Zahl(buttons, änderung);

                    if (eingabe == 1) {
                        neue_fußbodenheizung = true;
                    }
                    if (eingabe == 2) {
                        neue_fußbodenheizung = false;
                    }

                    if (eingabe == 0) {
                    }

                    // Jede andere Eingabe führt zu einer Fehlermeldung.
                    if (eingabe > 2) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit nicht vorhanden!\n");
                    }
                }

                // Aussicht
                if (änderung == 8) {
                    Scanner q = new Scanner(System.in);
                    System.out.println("Wäheln Sie ihre Wunschaussicht: '1' Park, '2' Spree, '3' Schienen, '4' Straße");

                    try {
                        int eingabe = q.nextInt();
                        if (eingabe == 0) {
                        } else {

                            if (eingabe == 1) {
                                neue_aussicht = "Park";
                            }
                            if (eingabe == 2) {
                                neue_aussicht = "Spree";
                            }
                            if (eingabe == 3) {
                                neue_aussicht = "Schienen";
                            }
                            if (eingabe == 4) {
                                neue_aussicht = "Straße";
                            }
                            if (eingabe > 4) {
                                System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit nicht vorhanden!\n");
                            }

                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
                    }
                }

                // Adresse
                if (änderung == 9) {
                    String[] auswahl = { "Straße", "Hausnummer", "Platz", "Stadt" };
                    int zähler = 1;
                    String straße = einlesen_Wort(auswahl, zähler);
                    zähler = 2;
                    int hausnummer = einlesen_Zahl(auswahl, zähler);
                    zähler = 3;
                    int platz = einlesen_Zahl(auswahl, zähler);
                    zähler = 4;
                    String stadt = einlesen_Wort(auswahl, zähler);

                    if (straße.equals("" + 0) || hausnummer == 0 || hausnummer == -100 || platz == 0 || platz == -100 || stadt.equals("" + 0)) {
                    } else {
                        neue_adresse = new Adresse(straße, hausnummer, platz, stadt);
                    }

                }

                // Status
                if (änderung == 10) {
                    Scanner q = new Scanner(System.in);
                    System.out.println("Wäheln Sie den Status der Wohnung aus: '1' frei, '2' vermietet, '3' in Renovierung, '0' abbruch");

                    try {
                        int eingabe = q.nextInt();
                        if (eingabe == 0) {
                        }
                        if (eingabe == 1) {
                            neue_status = "frei";
                        }
                        if (eingabe == 2) {
                            neue_status = "vermietet";
                        }
                        if (eingabe == 3) {
                            neue_status = "in Renovierung";
                        }
                        if (eingabe > 3) {
                            System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit nicht vorhanden!\n");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
                    }

                }

                // letztes Renovierungsdatum
                if (änderung == 11) {
                    neue_letzesRenovierungsdatum = Datum_Eingabe(aktuelle_letztesRenovierungsdatum);
                }

                // Renovierungsanzahl
                if (änderung == 12) {
                    int eingabe = einlesen_Zahl(buttons, änderung);
                    if (eingabe == 0) {
                    } else {
                        neue_renovierungsanzahl = eingabe;
                    }
                }

                // letztes Renoveriungsdetail
                if (änderung == 13) {
                    String eingabe = einlesen_Wort(buttons, änderung);
                    if (eingabe.equals("" + 0)) {
                    } else {
                        neue_letzeRenovierung_Details = eingabe;
                    }
                }

                // zugeordneter Mitarbeiter
                if (änderung == 14) {
                    JComboBox_optimierte_Auswahl(änderung);
                    int mitarbeiterID = WohnungBearbeitenAction.JFrame_mitarbeiterID_auswahl;
                    String name = "";
                    String vorname = "";

                    for (Mitarbeiter worker : MenuManager.workerList) {
                        if (worker.getMitarbeiterID() == mitarbeiterID) {
                            name = worker.getName();
                            vorname = worker.getVorname();
                        }
                    }
                    neue_zugeordneterMitarbeiter = new Mitarbeiter(mitarbeiterID, name, vorname);
                }

                // Bearbeitung abschließen
                if (änderung == 15) {
                    bearbeitungsVorgang = false;

                    for (Wohnung flat : MenuManager.flatList) {

                        /*
                         * wenn beim bearbeiten eine Wohnung ausgewählt wird,
                         * die jemanden gehört, dann wohnt der Mieter in der
                         * Wohnung mit der eben angepassten Wohnungsnummer
                         */
                        for (Mieter owner : MenuManager.ownerList) {
                            if (owner.getWohnungsnummer() == aktuelleID && neueID != aktuelleID) {
                                owner.setWohnungsnummer(neueID);
                            }
                        }

                        /*
                         * Es werden nach dem Herausfinden, welcher Mietvertrag
                         * so eben bearbeitet wurde, die einzelnen veränderten
                         * Attribute nun geändert.
                         */
                        if (zu_bearbeitende_wohnung == flat.getWohnungsID()) {
                            flat.setWohnungsID(neueID);
                            flat.setZimmeranzahl(neue_zimmeranzahl);
                            flat.setFläche(neue_fläche);
                            flat.setKosten(neue_kosten);
                            flat.setEtage(neue_etage);
                            flat.setBalkon(neue_balkon);
                            flat.setFußbodenheizung(neue_fußbodenheizung);
                            flat.setAdresse(neue_adresse);
                            flat.setAussicht(neue_aussicht);
                            flat.setLetztesRenovierungsdatum(neue_letzesRenovierungsdatum);
                            flat.setRenovierungsanzahl(neue_renovierungsanzahl);
                            flat.setLetzeRenovierung_Details(neue_letzeRenovierung_Details);
                            flat.setZugeordneterMitarbeiter(neue_zugeordneterMitarbeiter);

                        }
                    }
                }

                // Eingabe > 15
                if (änderung > 15) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit nicht vorhanden!\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
            }
        }
    }

    /**
     * Methode zur Eingabe des Datums
     *
     * @param aktuellesDatum,
     *            was der Handwerkerauftrag zu dem Zeitpunkt noch benutzt
     * @return das neue Datum, welches weiterverwendet werden soll
     */
    public Datum Datum_Eingabe(final Datum aktuellesDatum) {

        System.out.println("Eingabe des Eingangdatums: Wählen Sie bei einem Wert '0' und das Datum bleibt unverändert!");
        String[] auswahl = { "Jahr", "Monat", "Tag" };

        Datum neuesDatum = null;
        boolean datumsEingabeErfolgreich = false;

        int zähler = 1;
        int jahr = einlesen_Zahl(auswahl, zähler);

        zähler = 2;
        int monat = 0;
        do {
            monat = einlesen_Zahl(auswahl, zähler);
            if (monat > 12) {
                System.out.println("\n------------------------------- Fehler! ------------------------------- \nMonat darf nicht höher als 12 sein!\n");
            }
        } while (monat > 12);

        zähler = 3;
        int tag = 0;
        do {
            tag = einlesen_Zahl(auswahl, zähler);
            if (monat == 1 || monat == 3 || monat == 5 || monat == 7 || monat == 8 || monat == 10 || monat == 12) {
                if (tag > 31) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 31 Tage!\n");
                } else {
                    datumsEingabeErfolgreich = true;
                }
            }

            if (monat == 4 || monat == 6 || monat == 9 || monat == 11) {
                if (tag > 30) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 30 Tage!\n");
                } else {
                    datumsEingabeErfolgreich = true;
                }
            }

            if (monat == 2) {
                if (tag > 29) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 29 Tage!\n");
                } else {
                    datumsEingabeErfolgreich = true;
                }
            }
        } while (datumsEingabeErfolgreich == false);

        /*
        * Wenn einer der Werte versucht wird zu überspringen/ auszulassen, dann
         * bleibt es beim unveränderten Datum.
         */
        if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
            neuesDatum = aktuellesDatum;
        } else {
            neuesDatum = new Datum(tag, monat, jahr);
        }
        return neuesDatum;
    }

    /**
     * Methode zur Auswahl eines bereits existierend Attributs durch Vorschlag jedes einzelnen Elements in einer ArrayList
     *
     * @param änderung
     *            = Zähler des Attributs -> Bestimmung, welcher Fall eintritt (ob eine Wohnung, etc. bearbeitet wird)
     */
    private void JComboBox_optimierte_Auswahl(final int änderung) {
        WohnungBearbeitenAction.window = false;
        WohnungBearbeitenAction.JFrame_wohnungsnummer_auswahl = -100;
        WohnungBearbeitenAction.JFrame_mitarbeiterID_auswahl = -100;

        JFrame meinRahmen = new JFrame();
        meinRahmen.setSize(250, 250);
        JPanel meinPanel = new JPanel();
        meinRahmen.setLocationRelativeTo(null);

        JComboBox combo2 = new JComboBox();

        if (änderung == -99) {
            meinRahmen.setTitle("Wohnungs-ID");
            JLabel frage = new JLabel("Welche Wohnung wird bearbeitet?");
            meinPanel.add(frage);
            for (Wohnung flat : MenuManager.flatList) {
                if (flat.getStatus().equals("frei")) {
                    combo2.addItem(flat.getWohnungsID());
                }
            }
        }

        if (änderung == 1) {
            meinRahmen.setTitle("Wohngungs ID");
            JLabel frage = new JLabel("Welche Wohnung soll ausgewählt werden?");
            meinPanel.add(frage);

            for (Wohnung flat : MenuManager.flatList) {
                combo2.addItem(flat.getWohnungsID());
            }
        }

        if (änderung == 14) {
            meinRahmen.setTitle("Mitarbeiter ID");
            JLabel frage = new JLabel("Welcher Mitarbeiter soll ausgewählt werden?");
            meinPanel.add(frage);
            for (Mitarbeiter worker : MenuManager.workerList) {
                combo2.addItem(worker.getMitarbeiterID());
            }
        }

        meinRahmen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                WohnungBearbeitenAction.window = true;
            }
        });

        ActionListener cbActionListener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (änderung == -99) {
                    WohnungBearbeitenAction.bearbeitungsAuswahl_WohnungsID = (int) combo2.getSelectedItem();
                }
                if (änderung == 1) {
                    WohnungBearbeitenAction.JFrame_wohnungsnummer_auswahl = (int) combo2.getSelectedItem();
                }
                if (änderung == 14) {
                    WohnungBearbeitenAction.JFrame_mitarbeiterID_auswahl = (int) combo2.getSelectedItem();
                }
            }
        };
        meinPanel.add(combo2);
        meinRahmen.add(meinPanel, BorderLayout.SOUTH);
        meinRahmen.pack();
        meinRahmen.setVisible(true);
        while (WohnungBearbeitenAction.window == false) {
            combo2.addActionListener(cbActionListener);
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

    /**
     * Methode zum Anpassen der Länge des Datums bei der Ausgabe auf der Konsole.
     */
    private String länge_anpassen_Datum(final Datum a_GD) {

        int abzug = 0;

        String leerzeichen = "";

        if (a_GD != null) {

            String jahr = "" + a_GD.getJahr();
            int l_J = jahr.length();

            String monat = "" + a_GD.getMonat();
            int l_M = monat.length();

            String tag = "" + a_GD.getTag();
            int l_T = tag.length();

            abzug = l_J + l_M + l_T + 2; // +2 für die Punkte zwischen den
                                         // Komponenten
        } else {
            abzug = 4;
        }
        if (abzug < 50) {
            while (abzug < 50) {
                leerzeichen = leerzeichen + " ";
                abzug += 1;
            }
        }
        return leerzeichen;
    }

    /**
     * Methode zum Anpassen der Länge des Attributes (außer Datum) bei der Ausgabe auf der Konsole.
     *
     * @param wort
     *            = mitgegebenes Attribut
     * @return das Attribut mit den anschließenden Leerzeichen
     */
    private String länge_anpassen(String wort) {

        int abzug = wort.length();
        if (wort.length() < 50) {
            while (wort.length() < 50) {
                wort = wort + " ";
            }
        }
        return wort;
    }

    public double double_eingabe(final String[] buttons, final int ok) {

        Scanner s = new Scanner(System.in);
        double zahl = -100.00;
        try {

            do {
                System.out.println("Erstellen: " + buttons[ok - 1]);
                zahl = s.nextDouble();
                if (zahl < 0) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nNur positive Zahlen erlaubt!");
                }
            } while (zahl < 0);
        } catch (InputMismatchException e) {
            System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
        }
        return zahl;
    }

    private String länge_anpassen_Adresse(final Adresse a_A) {

        int abzug = 0;

        String leerzeichen = "";

        if (a_A != null) {

            String hausnummer = "" + a_A.getHausnummer();
            int l_HN = hausnummer.length();

            String platz = "" + a_A.getPlz();
            int l_P = platz.length();

            String stadt = a_A.getStadt();
            int l_ST = stadt.length();

            String straße = a_A.getStrasse();
            int l_SR = straße.length();

            abzug = l_HN + l_P + l_SR + l_ST + 3; // +3 für die Leerzeichen
                                                  // zwischen den Komponenten
        } else {
            abzug = 4;
        }
        if (abzug < 50) {
            while (abzug < 50) {
                leerzeichen = leerzeichen + " ";
                abzug += 1;
            }
        }
        return leerzeichen;
    }

    private String länge_anpassen_Mitarbeiter(final Mitarbeiter a_ZM) {

        int abzug = 0;

        String leerzeichen = "";

        if (a_ZM != null) {

            String ID = "" + a_ZM.getMitarbeiterID();
            int l_ID = ID.length();

            String name = "" + a_ZM.getName();
            int l_N = name.length();

            String vorname = a_ZM.getVorname();
            int l_VN = vorname.length();

            abzug = l_ID + l_N + l_VN + 2; // +2 für die Leerzeichen
                                           // zwischen den Komponenten

        } else {
            abzug = 4;
        }
        if (abzug < 50) {
            while (abzug < 50) {
                leerzeichen = leerzeichen + " ";
                abzug += 1;
            }
        }
        return leerzeichen;
    }
}
