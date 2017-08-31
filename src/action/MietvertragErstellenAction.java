package action;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.InputMismatchException;
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

public class MietvertragErstellenAction extends MenuManager implements Action, Serializable {

    static int wohnungsnummer_auswahl;
    static int mieterID_auswahl;
    static int mitarbeiterID_auswahl;
    static boolean window = false;

    @Override
    public void action() {

        System.out.println("________________________________________ Mietvertrag erstellen ________________________________________\n");

        /*
         * Variable zum Öffnen des richtigen JFrames und zur Auswahl des zu
         * bearbeitenden Attributs.
         */
        int änderung = -99;

        boolean erstellVorgang = true;

        int mietvertragID = 100;
        int wohnungsID = -100;
        int kundenID = -100;
        int mitarbeiterID = -100;
        Datum mietbeginn = null;
        Datum mietende = null;

        // Jeder neu erstellte Mietvertrag ist aktiv
        String status = "aktiv";

        /*
         * Solange der Erstellvorgang nicht beendet ist, wird immer eine
         * Übersicht über den erstellten Wert ausgegeben. Es wird pro Durchlauf
         * immer 1 Attribut ausgewählt, welches man draufhin verändern kann.
         */
        while (erstellVorgang == true) {

            /*
             * Array beeinhaltet alle Attribute, die verändert werden können und
             * dient zur Ausgabe durch Zugriff auf deren Index
             */
            String[] kategorie = { "Mietvertrags-ID", "Wohnungs-ID", "Kunden-ID", "Mitarbeiter-ID", "Mietbeginn", "Mietende" };

            System.out.println("Wählen Sie einen zu bearbeitenenden Wert!\nFolgender Mietvertrag wird aktuell erstellt: ");
            System.out.println("1. Mietvertrag-ID:                        " + mietvertragID);
            if (wohnungsID != -100) {
                System.out.println("2. Wohnungs-ID:                           " + wohnungsID);
            } else {
                System.out.println("2. Wohnungs-ID:                           " + "-");
            }
            if (kundenID != -100) {
                System.out.println("3. Kunden-ID:                             " + kundenID);
            } else {
                System.out.println("3. Kunden-ID:                             " + "-");
            }
            if (mitarbeiterID != -100) {
                System.out.println("4. Mitarbeiter-ID:                        " + mitarbeiterID);
            } else {
                System.out.println("4. Mitarbeiter-ID:                        " + "-");
            }
            if (mietbeginn != null) {
                System.out.println("5. Mietbeginn:                            " + mietbeginn);
            } else {
                System.out.println("5. Mietbeginn:                            " + "--.--.----");
            }
            if (mietende != null) {
                System.out.println("6. Mietende:                              " + mietende);
            } else {
                System.out.println("6. Mietende:                              " + "--.--.----");
            }
            System.out.println("   Status:                                " + status);
            System.out.println("7. Erstellen abschließen");
            System.out.println("0. Abbruch");

            Scanner s = new Scanner(System.in);

            /*
             * Die try-catch Klammer existiert für nicht erwünschte Eingaben wie
             * Zeichen, wo Zahlen erwartet werden.
             */
            try {

                änderung = s.nextInt();

                // Abbruch
                if (änderung == 0) {
                    System.out.println("\n-------------------------------Erstellvorgang wurde abgebrochen!-------------------------------\n");
                    erstellVorgang = false;
                }

                // Mietvertrag-ID
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
                        for (Mietvertrag contract : MenuManager.getContractList()) {
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
                        for (Mietvertrag abgeschlossenerMietvertrag : MenuManager.getBeendeteMietverträge()) {
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
                            mietvertragID = Integer.parseInt(eingabe);
                        } catch (NumberFormatException e) {
                            System.out.println("\n------------------------------- Fehler! ------------------------------- \nKeine Nummer!");
                        }
                    }
                }

                // Wohnungsnummer
                if (änderung == 2) {
                    JComboBox_optimierte_Auswahl(änderung);
                    wohnungsID = MietvertragErstellenAction.wohnungsnummer_auswahl;
                }

                // Mieter-ID
                if (änderung == 3) {
                    JComboBox_optimierte_Auswahl(änderung);
                    kundenID = MietvertragErstellenAction.mieterID_auswahl;
                }

                // Mitarbeiter-ID
                if (änderung == 4) {
                    JComboBox_optimierte_Auswahl(änderung);
                    mitarbeiterID = MietvertragErstellenAction.mitarbeiterID_auswahl;
                }

                // Mietbeginn
                if (änderung == 5) {

                    mietbeginn = Datum_Eingabe(mietbeginn);
                }

                // Mietende
                if (änderung == 6) {

                    mietende = Datum_Eingabe(mietende);
                }

                // Erstellen abschließen
                if (änderung == 7) {
                    erstellVorgang = false;
                    System.out.println("Mietvertrag wurde erfolgreich angelegt!");

                    MenuManager.add(new Mietvertrag(mietvertragID, wohnungsID, kundenID, mitarbeiterID, mietbeginn, mietende, status));

                    /*
                     * Es wird überprüft, ob eine Wohnung besetzt ist und
                     * daraufhin der Status auf 'vermietet' gesetzt, wenn das
                     * der Fall ist und sonst auf 'frei'
                     */
                    for (Wohnung flat : MenuManager.getFlatList()) {
                        int belegt = 0;
                        for (Mietvertrag contract : MenuManager.getContractList()) {
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

                    for (Mieter owner : MenuManager.getOwnerList()) {
                        if (kundenID == owner.getKundenID()) {
                            owner.setWohnungsnummer(wohnungsID);
                        }
                    }

                }

                // Eingabe > 7
                if (änderung > 7) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit nicht vorhanden!\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
            }
        }
    }

    /**
     * Methode zur Auswahl eines bereits existierend Attributs durch Vorschlag jedes einzelnen Elements in einer ArrayList
     *
     * @param änderung
     *            = Zähler des Attributs -> Bestimmung, welcher Fall eintritt (ob eine Wohnung, etc. bearbeitet wird)
     */
    private void JComboBox_optimierte_Auswahl(final int änderung) {
        MietvertragErstellenAction.window = false;
        MietvertragErstellenAction.mitarbeiterID_auswahl = -100;
        MietvertragErstellenAction.mieterID_auswahl = -100;
        MietvertragErstellenAction.wohnungsnummer_auswahl = -100;
        JFrame meinRahmen = new JFrame();

        meinRahmen.setSize(250, 250);
        JPanel meinPanel = new JPanel();
        meinRahmen.setLocationRelativeTo(null);

        JComboBox combo2 = new JComboBox();

        if (änderung == 2) {
            meinRahmen.setTitle("Wohnungsnummer");
            JLabel frage = new JLabel("Welche Wohnung möchten Sie auswählen?");
            meinPanel.add(frage);
            for (Wohnung flat : MenuManager.getFlatList()) {
                if (flat.getStatus().equals("frei")) {
                    combo2.addItem(flat.getWohnungsID());
                }
            }
        }

        if (änderung == 3) {
            meinRahmen.setTitle("Mieter-ID");
            JLabel frage = new JLabel("Welchen Mieter (ID) möchten Sie auswählen?");
            meinPanel.add(frage);
            int hinzufügen = 0;
            for (Mieter owner : MenuManager.getOwnerList()) {
                if (owner.getWohnungsnummer() == -100) {
                    combo2.addItem(owner.getKundenID());
                }
            }
        }

        if (änderung == 4) {
            meinRahmen.setTitle("Mitarbeiter-ID");
            JLabel frage = new JLabel("Welchen Mitarbeiter (ID) möchten Sie auswählen?");
            meinPanel.add(frage);
            for (Mitarbeiter worker : MenuManager.getWorkerList()) {
                combo2.addItem(worker.getMitarbeiterID());
            }
        }

        meinRahmen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                MietvertragErstellenAction.window = true;
            }
        });

        ActionListener cbActionListener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (änderung == 2) {
                    MietvertragErstellenAction.wohnungsnummer_auswahl = (int) combo2.getSelectedItem();
                }
                if (änderung == 3) {
                    MietvertragErstellenAction.mieterID_auswahl = (int) combo2.getSelectedItem();
                }
                if (änderung == 4) {
                    MietvertragErstellenAction.mitarbeiterID_auswahl = (int) combo2.getSelectedItem();
                }

            }
        };
        meinPanel.add(combo2);
        meinRahmen.add(meinPanel, BorderLayout.SOUTH);
        meinRahmen.pack();
        meinRahmen.setVisible(true);
        while (MietvertragErstellenAction.window == false) {
            combo2.addActionListener(cbActionListener);
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
