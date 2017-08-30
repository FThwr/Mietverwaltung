package action;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hilfsklassen.Datum;
import menu.MenuManager;
import objekte.Mieter;
import objekte.Mietvertrag;
import objekte.Mitarbeiter;
import objekte.Wohnung;

public class MietvertragBearbeitenAction extends MenuManager implements Action, Serializable {

    static boolean window = false;
    static String bearbeitungsAuswahl_MietvertragID;
    static int neue_mieterID;
    static int neue_wohnungsnummer;
    static int neue_mitarbeiterID;

    @Override
    public void action() {

        System.out.println("________________________________________ Mietvertrag bearbeiten ________________________________________\n");

        /*
         * Variable zum Öffnen des richtigen JFrames und zur Auswahl des zu
         * bearbeitenden Attributs.
         */
        int änderung = -99;

        // Ausgabe aller Mietvertrag-IDs zur einfacheren Auswahl
        JComboBox_optimierte_Auswahl(änderung);

        // Variable enthält die ID des zu bearbeitenden Mietvertrags
        String zu_bearbeitenden_mietvertrag = MietvertragBearbeitenAction.bearbeitungsAuswahl_MietvertragID;

        boolean bearbeitungsVorgang = true;

        /*
         * Array beeinhaltet alle Attribute, die verändert werden können und
         * dient zur Ausgabe durch Zugriff auf deren Index
         */
        String[] kategorie = { "Mietvertrag-ID", "Wohnungs-ID", "Kunden-ID", "Mitarbeiter-ID", "Mietbeginn", "Status" };

        /*
         * diese Variablen dienen später für eine tabellarische Ausgabe auf der
         * Konsole
         */
        String längenAnpassung_mietvertragID = "";
        String längenAnpassung_wohnungsID = "";
        String längenAnpassung_kundenID = "";
        String längenAnpassnung_mitarbeiterID = "";
        String längenAnpassung_status = "";

        /*
         * allgemeine Variablen alte = aktuelle Werte, neue = neue/veränderte
         * Werte
         */
        int aktuelleMietvertragsID = -100;
        int neueMietvertragsID = -100;

        int aktuelleWohnungsID = -100;
        int neueWohnungsID = -100;

        int aktuelleKundenID = -100;
        int neueKundenID = -100;

        int aktuelleMitarbeiterID = -100;
        int neueMitarbeiterID = -100;

        Datum aktuellerMietbeginn = null;
        Datum neuerMietbeginn = null;

        Datum aktuellesMietende = null;
        Datum neuesMietende = null;

        String aktuellerStatus = "";
        String neuerStatus = "";

        /*
         * Variablen enthalten die Leerzeichen, die nach den Objekten (Daten)
         * eingesetzt werden. Die Längen der einzelnen Komponenten der Objekte
         * werden verwendet. MB = Mietbeginn , ME = Mietende.
         */
        String MB_Leerzeichen = "";
        String ME_Leerzeichen = "";

        /*
         * Für jedes Element in der Mietvertragsliste wird zeurst das Objekt in der
         * ArrayList gesucht, welche der eben ausgewählten Vertrags-ID
         * entspricht. Es werden neue Variablen angelegt, welche die einzelnen
         * Werte des Objekts beeinhalten.
         */
        for (Mietvertrag contract : MenuManager.contractList) {
            if (zu_bearbeitenden_mietvertrag.equals(contract.getMietvertragsID())) {

                aktuelleMietvertragsID = contract.getMietvertragsID();
                neueMietvertragsID = aktuelleMietvertragsID;

                aktuelleWohnungsID = contract.getWohnungsID();
                neueWohnungsID = aktuelleWohnungsID;

                aktuelleKundenID = contract.getKundenID();
                neueKundenID = aktuelleKundenID;

                aktuelleMitarbeiterID = contract.getMitarbeiterID();
                neueMitarbeiterID = aktuelleMitarbeiterID;

                aktuellerMietbeginn = contract.getMietBeginn();
                neuerMietbeginn = aktuellerMietbeginn;

                aktuellesMietende = contract.getMietEnde();
                neuesMietende = aktuellesMietende;

                aktuellerStatus = contract.getStatus();
                neuerStatus = aktuellerStatus;

                /*
                 * Initialisierung der tabellarischen Variablen + Ausfüllung mit
                 * Leerzeichen (Umwandlung in die Tabelle)
                 */
                längenAnpassung_mietvertragID = länge_anpassen(aktuelleMietvertragsID);
                längenAnpassung_wohnungsID = länge_anpassen(aktuelleWohnungsID);
                längenAnpassung_kundenID = länge_anpassen(aktuelleKundenID);
                längenAnpassnung_mitarbeiterID = länge_anpassen(aktuelleMitarbeiterID);
                längenAnpassung_status = länge_anpassen(aktuellerStatus);

                if (aktuellerMietbeginn != null) {
                    MB_Leerzeichen = länge_anpassen_Datum(aktuellerMietbeginn);
                }

                if (aktuellesMietende != null) {
                    ME_Leerzeichen = länge_anpassen_Datum(aktuellesMietende);
                }
            }
        }

        /*
         * Solange der Bearbeitungsvorgang nicht beendet ist, wird immer eine
         * Übersicht über den alten Wert und den neuen Wert des jeweiligen
         * Attributs ausgegeben. Es wird pro Durchlauf immer 1 Attribut
         * ausgewählt, welches man draufhin verändern kann.
         */
        while (bearbeitungsVorgang == true) {
            System.out.println("............................... Wählen Sie die zu bearbeitende Eigenschaft aus! ...............................");
            System.out.println("1. Mietvertrag-ID:       " + längenAnpassung_mietvertragID + "neue Mietvertrag-ID:       " + neueMietvertragsID);
            System.out.println("2. Wohnungs-ID:          " + längenAnpassung_wohnungsID + "neue Wohnungs-ID:          " + neueWohnungsID);
            System.out.println("3. Kunden-ID:            " + längenAnpassung_kundenID + "neue Kunden-ID:            " + neueKundenID);
            System.out.println("4. Mitarbeiter-ID:       " + längenAnpassnung_mitarbeiterID + "neue Mitarbeiter-ID:       " + neueMitarbeiterID);
            System.out.println("5. Mietbeginn:           " + aktuellerMietbeginn + MB_Leerzeichen + "neuer Mietbeginn:          " + neuerMietbeginn);
            System.out.println("6. Mietende:             " + aktuellesMietende + ME_Leerzeichen + "neues Mietende:            " + neuesMietende);
            System.out.println("7. Status:               " + längenAnpassung_status + "neuer Status:              " + neuerStatus);
            System.out.println("8. Bestätigen");
            System.out.println("0. Abbruch");
            System.out.println("");

            Scanner t = new Scanner(System.in);

            /*
             * Die try-catch Klammer existiert für nicht erwünschte Eingaben wie
             * Zeichen, wo Zahlen erwartet werden.
             */
            try {
                änderung = t.nextInt();

                // Abbruch
                if (änderung == 0) {
                    System.out.println("\n-------------------------------Bearbeitungsvorgang wurde abgebrochen!-------------------------------\n");
                    bearbeitungsVorgang = false;
                }

                // Mietvertrag-ID
                if (änderung == 1) {
                    String eingabe = einlesen_Wort(kategorie, änderung);
                    if (eingabe.equals("" + 0)) {
                        break;
                    }

                    int vorhanden = 0;
                    /*
                    * Für jedes Element in der Handwerkerliste der aktiven
                    * Aufträge wird geguckt, ob die eingegebende ID mit
                    * einer bereits existierenden übereinstimmt.
                    */
                    for (Mietvertrag contract : MenuManager.contractList) {
                        if (eingabe.equals(contract.getMietvertragsID())) {
                            vorhanden = 1;
                        }
                    }

                    /*
                    * Für jedes Element in der Handwerkerliste der
                    * abgeschlossenen Aufträge wird geguckt, ob die
                    * eingegebende ID mit einer bereits existierenden
                    * übereinstimmt.
                    */
                    for (Mietvertrag abgeschlossenerMietvertrag : MenuManager.beendeteMietverträge) {
                        if (eingabe.equals(abgeschlossenerMietvertrag.getMietvertragsID())) {
                            vorhanden = 1;
                        }
                    }

                    /*
                    * Wenn die Variable 'vorhanden' = 1, dann existierte
                    * ein Handwerkerauftrag mit dieser ID bereits. Sonst
                    * wird die eingegebene ID die ID des Auftrags.
                    */
                    if (vorhanden == 1) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nMietvertrags-ID bereits vergeben!\n");
                        break;
                    }

                    try {
                        neueMietvertragsID = Integer.parseInt(eingabe);
                    } catch (NumberFormatException e) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nKeine Nummer!");
                    }
                }

                // Wohnungsnummer
                if (änderung == 2) {
                    JComboBox_optimierte_Auswahl(änderung);
                    neueWohnungsID = MietvertragBearbeitenAction.neue_wohnungsnummer;
                }

                // Mieter-ID
                if (änderung == 3) {
                    JComboBox_optimierte_Auswahl(änderung);
                    neueKundenID = MietvertragBearbeitenAction.neue_mieterID;
                }

                // Mitarbeiter-ID
                if (änderung == 4) {
                    JComboBox_optimierte_Auswahl(änderung);
                    neueMitarbeiterID = MietvertragBearbeitenAction.neue_mitarbeiterID;
                }

                // Mietbeginn
                if (änderung == 5) {
                    neuerMietbeginn = Datum_Eingabe(neuerMietbeginn);
                }

                // Mietende
                if (änderung == 6) {
                    neuesMietende = Datum_Eingabe(neuesMietende);
                }

                // Status
                if (änderung == 7) {
                    System.out.println("Geben Sie die Zahl vom gewünschten Status aus: '1' = aktiv, '2' = ausgelaufen, '0' = Abbruch!");
                    int eingabe = einlesen_Zahl(kategorie, änderung);

                    if (eingabe == 1) {
                        neuerStatus = "aktiv";
                    }
                    if (eingabe == 2) {
                        neuerStatus = "ausgelaufen";
                    }
                    if (eingabe == 0) {
                    }

                    // Jede andere Eingabe führt zu einer Fehlermeldung.
                    if (eingabe > 2) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit nicht vorhanden!\n");
                    }
                }

                // Bearbeitung abschließen
                if (änderung == 8) {
                    bearbeitungsVorgang = false;

                    if (neuerStatus.equals("aktiv")) {
                        /*
                         * Es werden nach dem Herausfinden, welcher Mietvertrag
                         * so eben bearbeitet wurde, die einzelnen veränderten
                         * Attribute nun geändert.
                         */
                        for (Mietvertrag contract : MenuManager.contractList) {
                            if (zu_bearbeitenden_mietvertrag.equals(contract.getMietvertragsID())) {
                                contract.setMietvertragsID(neueMietvertragsID);
                                contract.setWohnungsID(neueWohnungsID);
                                contract.setKundenID(neueKundenID);
                                contract.setMitarbeiterID(neueMitarbeiterID);
                                contract.setMietBeginn(neuerMietbeginn);
                                contract.setMietEnde(neuesMietende);
                                contract.setStatus(neuerStatus);
                            }
                        }
                    }
                    if (neuerStatus.equals("ausgelaufen")) {

                        /*
                         * Da der Vertrag ausgelaufen ist, wird er der Liste der
                         * beendeten Verträge hinzugefügt.
                         */
                        MenuManager.beendeteMietverträge.add(new Mietvertrag(neueMietvertragsID, neueWohnungsID, neueKundenID, neueMitarbeiterID, neuerMietbeginn, neuesMietende, neuerStatus));

                        /*
                         * Auderdem wird der Handwerkerautrag aus der Liste der
                         * aktiven Aufträge entfernt
                         */
                        Iterator<Mietvertrag> iter = MenuManager.contractList.iterator();

                        while (iter.hasNext()) {
                            Mietvertrag str = iter.next();

                            if ("" + str.getMietvertragsID() == zu_bearbeitenden_mietvertrag) {
                                iter.remove();

                            }
                        }
                    }

                    /*
                    * Es wird überprüft, ob eine Wohnung besetzt ist und
                    * daraufhin der Status auf 'vermietet' gesetzt, wenn das
                    * der Fall ist und sonst auf 'frei'
                    */
                    for (Wohnung flat : MenuManager.flatList) {
                        int belegt = 0;
                        for (Mietvertrag contract : MenuManager.contractList) {
                            if (contract.getWohnungsID() == flat.getWohnungsID() && flat.getWohnungsID() != -100 && contract.getWohnungsID() != -100) {
                                belegt = 1;
                            }
                        }
                        if (belegt == 1) {
                            flat.setStatus("vermietet");
                        } else {
                            flat.setStatus("frei");
                        }
                    }

                    /*
                    * Es wird überprüft wer alles einen Mietvertrag besitzt.
                    * Wenn jemand einen Mietvertrag besitzt, dann wird dem
                    * Mieter die Wohnungsnummer im Mieterprofil hinzugefügt.
                    * Wenn er keinen bestizt, dann bekommt er einen Strich in
                    * sienem Profil an der Stelle der Wohnungsnummer.
                    */
                    for (Mieter owner : MenuManager.ownerList) {
                        if (owner.getWohnungsnummer() == aktuelleWohnungsID) {

                            owner.setWohnungsnummer(-100);
                        }
                    }

                }

                // Eingabe > 8
                if (änderung > 8) {
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
        MietvertragBearbeitenAction.window = false;
        MietvertragBearbeitenAction.neue_wohnungsnummer = -100;
        MietvertragBearbeitenAction.neue_mieterID = -100;
        MietvertragBearbeitenAction.neue_mitarbeiterID = -100;

        JFrame meinRahmen = new JFrame();
        meinRahmen.setSize(250, 250);
        JPanel meinPanel = new JPanel();
        meinRahmen.setLocationRelativeTo(null);

        JComboBox combo2 = new JComboBox();

        if (änderung == -99) {
            meinRahmen.setTitle("Mietvertrag ID");
            JLabel frage = new JLabel("Welcher Mietvertrag wird bearbeitet?");
            meinPanel.add(frage);
            for (Mietvertrag contract : MenuManager.contractList) {
                combo2.addItem(contract.getMietvertragsID());
            }
        }

        if (änderung == 2) {
            meinRahmen.setTitle("Wohngungs ID");
            JLabel frage = new JLabel("Welche Wohnung soll ausgewählt werden?");
            meinPanel.add(frage);

            for (Wohnung flat : MenuManager.flatList) {
                if (flat.getStatus().equals("frei")) {
                    combo2.addItem(flat.getWohnungsID());
                }
            }
        }

        if (änderung == 3) {
            meinRahmen.setTitle("Mieter ID");
            JLabel frage = new JLabel("Welcher Mieter soll ausgewählt werden?");
            meinPanel.add(frage);
            for (Mieter owner : MenuManager.ownerList) {
                if (owner.getWohnungsnummer() == -100) {
                    combo2.addItem(owner.getKundenID());
                }
            }
        }

        if (änderung == 4) {
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
                MietvertragBearbeitenAction.window = true;
            }
        });

        ActionListener cbActionListener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (änderung == -99) {
                    MietvertragBearbeitenAction.bearbeitungsAuswahl_MietvertragID = (String) combo2.getSelectedItem();
                }
                if (änderung == 2) {
                    MietvertragBearbeitenAction.neue_wohnungsnummer = (int) combo2.getSelectedItem();
                }
                if (änderung == 3) {
                    MietvertragBearbeitenAction.neue_mieterID = (int) combo2.getSelectedItem();
                }
                if (änderung == 4) {
                    MietvertragBearbeitenAction.neue_mitarbeiterID = (int) combo2.getSelectedItem();
                }
            }
        };
        meinPanel.add(combo2);
        meinRahmen.add(meinPanel, BorderLayout.SOUTH);
        meinRahmen.pack();
        meinRahmen.setVisible(true);
        while (MietvertragBearbeitenAction.window == false) {
            combo2.addActionListener(cbActionListener);
        }

    }

    /**
     * Methode zum Einlesen einer Zahl vom Nutzer
     **
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
        }
        abzug = 4;
        if (abzug < 50) {
            while (abzug < 50) {
                leerzeichen = leerzeichen + " ";
                abzug += 1;
            }
        }
        return leerzeichen;
    }

    /*
     * Methode zum Anpassen der Länge des Attributes (außer Datum) bei der
    * Ausgabe auf der Konsole.*
     *
     * @param wort
     *            = mitgegebenes Attribut
     * @return das Attribut mit den anschließenden Leerzeichen
     */
    private String länge_anpassen(String längenAnpassung_status) {
        if (längenAnpassung_status.length() < 50) {
            while (längenAnpassung_status.length() < 50) {
                längenAnpassung_status = längenAnpassung_status + " ";
            }
        }
        return längenAnpassung_status;
    }

    private String länge_anpassen(final int längenAnpassung_int) {
        String längenAnpassung_status = "" + längenAnpassung_int;
        if (längenAnpassung_status.length() < 50) {
            while (längenAnpassung_status.length() < 50) {
                längenAnpassung_status = längenAnpassung_status + " ";
            }
        }
        return längenAnpassung_status;
    }
}