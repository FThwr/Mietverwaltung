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
         * Variable zum �ffnen des richtigen JFrames und zur Auswahl des zu
         * bearbeitenden Attributs.
         */
        int �nderung = 0;

        boolean erstellVorgang = true;

        String auftragsID = "-";
        int wohnungsID = -100;
        int mitarbeiterID = -100;
        String m�ngelbeschreibung = "-";

        Datum eingangsdatum = null;

        // Fertigstellungsdatum so gew�hlt, da Datum ungewiss beim Erstellen
        Datum fertigstellungsDatum = new Datum(0, 0, 0);

        // Jeder neue Handwerkerauftrag ist in Bearbeitung
        String status = "in Bearbeitung";

        String[] kategorie = { "Auftrags ID ", "Wohnungs ID", "Mitarbeiter ID", "M�ngelbeschreibung", "Status", "Eingangsdatum" };

        /*
         * Solange der Erstellvorgang nicht beendet ist, wird immer eine
         * �bersicht �ber den erstellten Wert ausgegeben. Es wird pro Durchlauf
         * immer 1 Attribut ausgew�hlt, welches man draufhin ver�ndern kann.
         */
        while (erstellVorgang == true) {

            System.out.println("...............................W�hlen Sie die zu erstellende Eigenschaft aus...............................!  ");
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
            System.out.println("4. M�ngelbeschreibung:   " + m�ngelbeschreibung);
            System.out.println("   Status:               " + status);
            if (eingangsdatum != null) {
                System.out.println("5. Eingangsdatum:        " + eingangsdatum);
            } else {
                System.out.println("5. Eingangsdatum:        " + "-");
            }
            System.out.println("   Fertigstellungsdatum: " + fertigstellungsDatum);
            System.out.println("6. Erstellen abschlie�en");
            System.out.println("0. Abbruch");
            System.out.println("");

            Scanner t = new Scanner(System.in);

            /*
             * Die try-catch Klammer existiert f�r nicht erw�nschte Eingaben wie
             * Zeichen, wo Zahlen erwartet werden.
             */
            try {
                �nderung = t.nextInt();

                // Abbruch
                if (�nderung == 0) {
                    System.out.println("-------------------------------Erstellvorgang wurde abgebrochen!-------------------------------\n");
                    erstellVorgang = false;
                }

                // Auftrags-ID
                if (�nderung == 1) {

                    String eingabe = einlesen_Wort(kategorie, �nderung);
                    if (eingabe.equals("" + 0)) {
                    } else {

                        int vorhanden = 0;
                        /*
                         * F�r jedes Element in der Handwerkerliste der aktiven
                         * Auftr�ge wird geguckt, ob die eingegebende ID mit
                         * einer bereits existierenden �bereinstimmt.
                         */
                        for (Handwerkerauftrag repair : MenuManager.getRepairList()) {
                            if (eingabe.equals(repair.getAuftragsID())) {
                                vorhanden = 1;
                            }
                        }

                        /*
                         * F�r jedes Element in der Handwerkerliste der
                         * abgeschlossenen Auftr�ge wird geguckt, ob die
                         * eingegebende ID mit einer bereits existierenden
                         * �bereinstimmt.
                         */
                        for (Handwerkerauftrag auftrag : MenuManager.getAbgeschlosseneHandwerkerauftr�ge()) {
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
                if (�nderung == 2) {

                    JComboBox_optimierte_Auswahl(�nderung);
                    wohnungsID = HandwerkerauftragErstellenAction.such_wohnung;
                }

                // Mitarbeiter
                if (�nderung == 3) {

                    JComboBox_optimierte_Auswahl(�nderung);
                    mitarbeiterID = HandwerkerauftragErstellenAction.such_mitarbeiterID;
                }

                // M�ngelbeschreibung
                if (�nderung == 4) {
                    String eingabe = einlesen_Wort(kategorie, �nderung);
                    if (eingabe.equals("" + 0)) {
                    } else {
                        m�ngelbeschreibung = eingabe;
                    }
                }

                // Eingangsdatum
                if (�nderung == 5) {

                    eingangsdatum = Datum_Eingabe(eingangsdatum);
                }

                // Bearbeitung abschlie�en
                if (�nderung == 6) {
                    System.out.println("Handwerkerauftrag wurde erfolgreich angelegt!");
                    erstellVorgang = false;

                    /*
                    * Es wird der Handwerkerauftrag in der WOhnungs�bersicht
                    * hinzugef�gt
                    */

                    for (objekte.Wohnung flat : MenuManager.getFlatList()) {
                        if (wohnungsID == flat.getWohnungsID()) {
                            flat.getHandwerkerauftrag().setAuftragsID(auftragsID);
                        }
                    }

                    /*
                     * Der Erstellvorgang ist beendet und der Liste der aktiven
                     * Handwerkerauftr�gen wird ein neuer Auftrag hinzugef�gt.
                     */
                    MenuManager.getRepairList().add(new Handwerkerauftrag(auftragsID, wohnungsID, mitarbeiterID, m�ngelbeschreibung, status, eingangsdatum, fertigstellungsDatum));

                }
                //Eingabe > 7
                else {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit nicht vorhanden!\n");
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

        System.out.println("Eingabe des Eingangdatums: W�hlen Sie bei einem Wert '0' und das Datum bleibt unver�ndert!\n");
        String[] auswahl = { "Jahr", "Monat", "Tag" };

        Datum neuesDatum = null;
        boolean datumsEingabeErfolgreich = false;

        int z�hler = 1;
        int jahr = einlesen_Zahl(auswahl, z�hler);

        z�hler = 2;
        int monat = 0;
        do {
            monat = einlesen_Zahl(auswahl, z�hler);
            if (monat > 12) {
                System.out.println("\n------------------------------- Fehler! ------------------------------- \nMonat darf nicht h�her als 12 sein!\n");
            }
        } while (monat > 12);

        z�hler = 3;
        int tag = 0;
        do {
            tag = einlesen_Zahl(auswahl, z�hler);
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
         * Wenn einer der Werte versucht wird zu �berspringen/ auszulassen, dann
         * bleibt es beim unver�nderten Datum.
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
     * @param �nderung
     *            = Z�hler des Attributs -> Bestimmung, welcher Fall eintritt (ob eine Wohnung, etc. bearbeitet wird)
     */
    private void JComboBox_optimierte_Auswahl(final int �nderung) {
        HandwerkerauftragErstellenAction.window = false;
        HandwerkerauftragErstellenAction.such_mitarbeiterID = -100;
        HandwerkerauftragErstellenAction.such_wohnung = -100;
        JFrame meinRahmen = new JFrame();

        meinRahmen.setSize(250, 250);
        JPanel meinPanel = new JPanel();
        meinRahmen.setLocationRelativeTo(null);

        JComboBox combo2 = new JComboBox();

        if (�nderung == 2) {
            meinRahmen.setTitle("Wohnungsnummer");
            JLabel frage = new JLabel("Welche Wohnung m�chten Sie ausw�hlen?");
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

        if (�nderung == 3) {
            meinRahmen.setTitle("Mitarbeiter-ID");
            JLabel frage = new JLabel("Welchen Mitarbeiter (ID) m�chten Sie ausw�hlen?");
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
                if (�nderung == 2) {
                    HandwerkerauftragErstellenAction.such_wohnung = (int) combo2.getSelectedItem();
                }
                if (�nderung == 3) {
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
