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

import hilfsklassen.Datum;
import menu.MenuManager;
import objekte.Handwerkerauftrag;

public class HandwerkerauftragErstellenAction extends MenuManager implements Action {

    static int such_wohnung;
    static int such_mitarbeiterID;
    static boolean window = false;

    @Override
    public void action() {

        System.out.println("________________________________________ Handwerkerauftrag erstellen ________________________________________\n");

        /*
         * Variable zum Öffnen des richtigen JFrames und zur Auswahl des zu
         * bearbeitenden Attributs.
         */
        int änderung = 0;

        boolean erstellVorgang = true;

        String auftragsID = "-";
        int wohnungsID = -100;
        int mitarbeiterID = -100;
        String mängelbeschreibung = "-";

        Datum eingangsdatum = null;

        // Fertigstellungsdatum so gewählt, da Datum ungewiss beim Erstellen
        Datum fertigstellungsDatum = new Datum(0, 0, 0);

        // Jeder neue Handwerkerauftrag ist in Bearbeitung
        String status = "in Bearbeitung";

        String[] kategorie = { "Auftrags ID ", "Wohnungs ID", "Mitarbeiter ID", "Mängelbeschreibung", "Status", "Eingangsdatum" };

        /*
         * Solange der Erstellvorgang nicht beendet ist, wird immer eine
         * Übersicht über den erstellten Wert ausgegeben. Es wird pro Durchlauf
         * immer 1 Attribut ausgewählt, welches man draufhin verändern kann.
         */
        while (erstellVorgang == true) {

            System.out.println("...............................Wählen Sie die zu erstellende Eigenschaft aus...............................!  ");
            System.out.println("1. Auftrags ID:          " + auftragsID);
            if (wohnungsID != -100) {
                System.out.println("2. Wohnungs ID:          " + wohnungsID);
            } else {
                System.out.println("2. Wohnungs ID:          " + "-");
            }
            if (mitarbeiterID != -100) {
                System.out.println("3. Mitarbeiter ID:       " + mitarbeiterID);
            } else {
                System.out.println("3. Mitarbeiter ID:       " + "-");
            }
            System.out.println("4. Mängelbeschreibung:   " + mängelbeschreibung);
            System.out.println("   Status:               " + status);
            if (eingangsdatum != null) {
                System.out.println("5. Eingangsdatum:        " + eingangsdatum);
            } else {
                System.out.println("5. Eingangsdatum:        " + "-");
            }
            System.out.println("   Fertigstellungsdatum: " + fertigstellungsDatum);
            System.out.println("6. Erstellen abschließen");
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
                    System.out.println("-------------------------------Erstellvorgang wurde abgebrochen!-------------------------------\n");
                    erstellVorgang = false;
                }

                // Auftrags-ID
                if (änderung == 1) {

                    String eingabe = einlesen_Wort(kategorie, änderung);
                    if (eingabe.equals("" + 0)) {
                    } else {

                        int vorhanden = 0;
                        /*
                         * Für jedes Element in der Handwerkerliste der aktiven
                         * Aufträge wird geguckt, ob die eingegebende ID mit
                         * einer bereits existierenden übereinstimmt.
                         */
                        for (Handwerkerauftrag repair : MenuManager.getRepairList()) {
                            if (eingabe.equals(repair.getAuftragsID())) {
                                vorhanden = 1;
                            }
                        }

                        /*
                         * Für jedes Element in der Handwerkerliste der
                         * abgeschlossenen Aufträge wird geguckt, ob die
                         * eingegebende ID mit einer bereits existierenden
                         * übereinstimmt.
                         */
                        for (Handwerkerauftrag auftrag : MenuManager.getAbgeschlosseneHandwerkeraufträge()) {
                            if (eingabe.equals(auftrag.getAuftragsID())) {
                                vorhanden = 1;
                            }
                        }

                        /*
                         * Wenn die Variable 'vorhanden' = 1, dann existierte
                         * ein Handwerkerauftrag mit dieser ID bereits. Sonst
                         * wird die eingegebene ID die ID des Auftrags.
                         */
                        if (vorhanden == 1) {
                            System.out.println("\n------------------------------- Fehler! ------------------------------- \nAuftrags ID bereits vergeben!\n");
                        } else {
                            auftragsID = eingabe;
                        }
                    }
                }

                // Wohnung
                if (änderung == 2) {

                    JComboBox_optimierte_Auswahl(änderung);
                    wohnungsID = HandwerkerauftragErstellenAction.such_wohnung;
                }

                // Mitarbeiter
                if (änderung == 3) {

                    JComboBox_optimierte_Auswahl(änderung);
                    mitarbeiterID = HandwerkerauftragErstellenAction.such_mitarbeiterID;
                }

                // Mängelbeschreibung
                if (änderung == 4) {
                    String eingabe = einlesen_Wort(kategorie, änderung);
                    if (eingabe.equals("" + 0)) {
                    } else {
                        mängelbeschreibung = eingabe;
                    }
                }

                // Eingangsdatum
                if (änderung == 5) {

                    eingangsdatum = Datum_Eingabe(eingangsdatum);
                }

                // Bearbeitung abschließen
                if (änderung == 6) {
                    System.out.println("Handwerkerauftrag wurde erfolgreich angelegt!");
                    erstellVorgang = false;

                    /*
                    * Es wird der Handwerkerauftrag in der WOhnungsübersicht
                    * hinzugefügt
                    */

                    for (objekte.Wohnung flat : MenuManager.getFlatList()) {
                        if (wohnungsID == flat.getWohnungsID()) {
                            flat.getHandwerkerauftrag().setAuftragsID(auftragsID);
                        }
                    }

                    /*
                     * Der Erstellvorgang ist beendet und der Liste der aktiven
                     * Handwerkeraufträgen wird ein neuer Auftrag hinzugefügt.
                     */
                    MenuManager.getRepairList().add(new Handwerkerauftrag(auftragsID, wohnungsID, mitarbeiterID, mängelbeschreibung, status, eingangsdatum, fertigstellungsDatum));

                }
                //Eingabe > 7
                else {
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

        System.out.println("Eingabe des Eingangdatums: Wählen Sie bei einem Wert '0' und das Datum bleibt unverändert!\n");
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
        HandwerkerauftragErstellenAction.window = false;
        HandwerkerauftragErstellenAction.such_mitarbeiterID = -100;
        HandwerkerauftragErstellenAction.such_wohnung = -100;
        JFrame meinRahmen = new JFrame();

        meinRahmen.setSize(250, 250);
        JPanel meinPanel = new JPanel();
        meinRahmen.setLocationRelativeTo(null);

        JComboBox combo2 = new JComboBox();

        if (änderung == 2) {
            meinRahmen.setTitle("Wohnungsnummer");
            JLabel frage = new JLabel("Welche Wohnung möchten Sie auswählen?");
            meinPanel.add(frage);
            for (objekte.Wohnung flat : MenuManager.getFlatList()) {
                int auftrag_vorhanden = 0;
                for (Handwerkerauftrag repair : MenuManager.getRepairList()) {
                    if (repair.getWohnungsID() == flat.getWohnungsID()) {
                        auftrag_vorhanden = 1;
                    }
                }
                if (auftrag_vorhanden != 1) {
                    combo2.addItem(flat.getWohnungsID());
                }
            }
        }

        if (änderung == 3) {
            meinRahmen.setTitle("Mitarbeiter-ID");
            JLabel frage = new JLabel("Welchen Mitarbeiter (ID) möchten Sie auswählen?");
            meinPanel.add(frage);
            for (objekte.Mitarbeiter worker : MenuManager.getWorkerList()) {
                combo2.addItem(worker.getMitarbeiterID());
            }
        }

        meinRahmen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                HandwerkerauftragErstellenAction.window = true;
            }
        });

        ActionListener cbActionListener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (änderung == 2) {
                    HandwerkerauftragErstellenAction.such_wohnung = (int) combo2.getSelectedItem();
                }
                if (änderung == 3) {
                    HandwerkerauftragErstellenAction.such_mitarbeiterID = (int) combo2.getSelectedItem();
                }

            }
        };
        meinPanel.add(combo2);
        meinRahmen.add(meinPanel, BorderLayout.SOUTH);
        meinRahmen.pack();
        meinRahmen.setVisible(true);
        while (HandwerkerauftragErstellenAction.window == false) {
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
}
