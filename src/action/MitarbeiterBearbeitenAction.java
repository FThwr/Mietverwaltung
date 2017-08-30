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

import menu.MenuManager;
import objekte.Mitarbeiter;
import objekte.Wohnung;

public class MitarbeiterBearbeitenAction extends MenuManager implements Action, Serializable {

    static boolean window = false;
    static int bearbeitungsAuswahl_MitarbeiterID;

    @Override
    public void action() {

        System.out.println("________________________________________ Mitarbeiter bearbeiten ________________________________________");

        /*
         * Variable zum Öffnen des richtigen JFrames und zur Auswahl des zu
         * bearbeitenden Attributs.
         */
        int änderung = -99;

        // Ausgabe aller Mitarbeiter-IDs zur einfacheren Auswahl
        JComboBox_optimierte_Auswahl(änderung);

        // Variable enthält die ID des zu bearbeitenden Mitarbeiters
        int zu_bearbeitenden_mitarbeiter = MitarbeiterBearbeitenAction.bearbeitungsAuswahl_MitarbeiterID;

        boolean bearbeitungsVorgang = true;

        /*
         * Array beeinhaltet alle Attribute, die verändert werden können und
         * dient zur Ausgabe durch Zugriff auf deren Index
         */
        String[] kategorie = { "Mitarbeiter ID", "Name", "Vorname", "Passwort" };

        /*
         * diese Variablen dienen später für eine tabellarische Ausgabe auf der
         * Konsole
         */
        String längenAnpassung_mitarbeiterID = "";
        String längenAnpassung_Name = "";
        String längenAnpassung_Vorname = "";
        String längenAnpassnung_benutzername = "";
        String längenAnpassung_passwort = "";

        /*
         * allgemeine Variablen alte = aktuelle Werte, neue = neue/veränderte
         * Werte
         */
        int aktuelleMitarbeiterID = -100;
        int neueMitarbeiterID = -100;

        String aktuellerName = "-";
        String neuerName = "-";

        String aktuellerVorname = "-";
        String neuerVorname = "-";

        String aktuellerBenutzername = "-";
        String neuerBenutzername = "-";

        String aktuellesPasswort = "-";
        String neuesPasswort = "-";

        /*
         * Für jedes Element in der Mitarbeiterliste wird zeurst das Objekt in der ArrayList
         * gesucht, welche der eben ausgewählten Mitarbeiter-ID entspricht. Es
         * werden neue Variablen angelegt, welche die einzelnen Werte des
         * Objekts beeinhalten.
         */
        for (Mitarbeiter worker : MenuManager.getWorkerList()) {
            if (zu_bearbeitenden_mitarbeiter == worker.getMitarbeiterID()) {

                aktuelleMitarbeiterID = worker.getMitarbeiterID();
                neueMitarbeiterID = aktuelleMitarbeiterID;

                aktuellerName = worker.getName();
                neuerName = aktuellerName;

                aktuellerVorname = worker.getVorname();
                neuerVorname = aktuellerVorname;

                aktuellerBenutzername = worker.getBenutzername();
                neuerBenutzername = neuerVorname.trim().substring(0, 1) + "." + neuerName;

                aktuellesPasswort = worker.getPasswort();
                neuesPasswort = aktuellesPasswort;

                /*
                 * Initialisierung der tabellarischen Variablen + Ausfüllung mit
                 * Leerzeichen (Umwandlung in die Tabelle)
                 */
                längenAnpassung_mitarbeiterID = "" + aktuelleMitarbeiterID;
                längenAnpassung_mitarbeiterID = länge_anpassen(längenAnpassung_mitarbeiterID);

                längenAnpassung_Name = aktuellerName;
                längenAnpassung_Name = länge_anpassen(längenAnpassung_Name);

                längenAnpassung_Vorname = aktuellerName;
                längenAnpassung_Vorname = länge_anpassen(längenAnpassung_Vorname);

                längenAnpassnung_benutzername = aktuellerBenutzername;
                längenAnpassnung_benutzername = länge_anpassen(längenAnpassnung_benutzername);

                längenAnpassung_passwort = aktuellesPasswort;
                längenAnpassung_passwort = länge_anpassen(längenAnpassung_passwort);
            }
        }

        /*
         * Solange der Bearbeitungsvorgang nicht beendet ist, wird immer eine
         * Übersicht über den alten Wert und den neuen Wert des jeweiligen
         * Attributs ausgegeben. Es wird pro Durchlauf immer 1 Attribut
         * ausgewählt, welches man draufhin verändern kann.
         */
        while (bearbeitungsVorgang == true) {

            System.out.println("1. Mitarbeiter ID: " + längenAnpassung_mitarbeiterID + "neue Mitarbeiter ID: " + neueMitarbeiterID);
            System.out.println("2. Name:           " + längenAnpassung_Name + "neuer Name:          " + neuerName);
            System.out.println("3. Vorname:        " + längenAnpassung_Vorname + "neuer Vorame:        " + neuerVorname);
            System.out.println("   Benutzername:   " + längenAnpassnung_benutzername + "neuer benutzername:  " + neuerBenutzername);
            System.out.println("4. Passwort:       " + längenAnpassung_passwort + "neues Passwort:      " + neuesPasswort);
            System.out.println("5. Mitarbeiter löschen");
            System.out.println("6. Bearbeitung abschließen");
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
                    System.out.println("-------------------------------Bearbeitungsvorgang wurde abgebrochen!-------------------------------\n");
                    bearbeitungsVorgang = false;
                }

                // Mitarbeiter-ID
                if (änderung == 1) {
                    int eingabe = einlesen_Zahl(kategorie, änderung);
                    if (eingabe == 0) {
                    } else {
                        int Vorhanden = 0;

                        /*
                         * In der Liste aller aktiven Mitarbeiter wird
                         * überprüft, ob es einen Mitarbeiter mit der
                         * gewünschten ID bereits gibt.
                         */
                        for (Mitarbeiter worker : MenuManager.getWorkerList()) {
                            if (eingabe == worker.getMitarbeiterID()) {
                                Vorhanden = 1;
                            }
                        }

                        /*
                         * In der Liste aller ehemaligen Mitarbeiter wird
                         * überprüft, ob es einen Mitarbeiter mit der
                         * gewünschten ID bereits gibt.
                         */
                        for (Mitarbeiter ehemaligerMitarbeiter : MenuManager.getEhemaligeMitarbeiter()) {
                            if (eingabe == ehemaligerMitarbeiter.getMitarbeiterID()) {
                                Vorhanden = 1;
                            }
                        }

                        // ID bereits vorhanden
                        if (Vorhanden == 1) {
                            System.out.println("\n------------------------------- Fehler! ------------------------------- \nMitarbeiter ID bereits vergeben!\n");
                        }

                        // ID nicht vorhanden
                        else {
                            neueMitarbeiterID = eingabe;
                        }
                    }
                }

                // Name
                if (änderung == 2) {
                    String eingabe = einlesen_Wort(kategorie, änderung);
                    if (eingabe.equals("" + 0)) {
                    } else {
                        neuerName = eingabe;
                    }
                }

                // Vorname
                if (änderung == 3) {
                    String eingabe = einlesen_Wort(kategorie, änderung);
                    if (eingabe.equals("" + 0)) {
                    } else {
                        neuerVorname = eingabe;
                    }
                }

                // Passwort
                if (änderung == 4) {
                    String eingabe = einlesen_Wort(kategorie, änderung);
                    if (eingabe.equals("" + 0)) {
                    } else {
                        neuesPasswort = eingabe;
                    }
                }

                // Löschen
                if (änderung == 5) {

                    bearbeitungsVorgang = false;

                    /*
                     * Da der Mitarbeiter gelöscht wird, wird er der Liste der
                     * ehemaligen Mitarbeiter hinzugefügt.
                     */
                    MenuManager.add(new Mitarbeiter(aktuelleMitarbeiterID, aktuellerName, aktuellerVorname, aktuellerBenutzername, aktuellesPasswort));

                    /*
                     * Gleichzeitig wird auch der Name des Mitarbeiters in der
                     * ihm zugewiesenen Wohnung auf leer gesetzt.
                     */
                    for (Wohnung flat : MenuManager.getFlatList()) {
                        if (aktuellerName.equals(flat.getZugeordneterMitarbeiter().getName())) {
                            flat.getZugeordneterMitarbeiter().setName("-");
                            ;
                        }
                    }

                    Iterator<Mitarbeiter> iter = MenuManager.getWorkerList().iterator();

                    while (iter.hasNext()) {
                        Mitarbeiter str = iter.next();

                        if (str.getMitarbeiterID() == zu_bearbeitenden_mitarbeiter) {
                            iter.remove();
                        }
                    }
                }

                // Bearbeitung abschließen
                if (änderung == 6) {
                    bearbeitungsVorgang = false;

                    /*
                     * Es werden nach dem Herausfinden, welcher Mietvertrag so
                     * eben bearbeitet wurde, die einzelnen veränderten
                     * Attribute nun geändert.
                     */
                    for (Mitarbeiter worker : MenuManager.getWorkerList()) {
                        if (zu_bearbeitenden_mitarbeiter == worker.getMitarbeiterID()) {
                            worker.setMitarbeiterID(neueMitarbeiterID);
                            worker.setName(neuerName);
                            worker.setVorname(neuerVorname);
                            worker.setBenutzername(neuerBenutzername);
                            worker.setPasswort(neuesPasswort);
                        }
                    }

                    /*
                     * Gleichzeitig wird auch der Name des Mitarbeiters in der
                     * ihm zugewiesenen Wohnung geändert.
                     */
                    for (Wohnung flat : MenuManager.getFlatList()) {
                        if (aktuellerName.equals(flat.getZugeordneterMitarbeiter().getName())) {
                            flat.getZugeordneterMitarbeiter().setName(neuerName);

                        }
                    }
                }

                // Eingabe > 6
                if (änderung > 6) {
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
        MitarbeiterBearbeitenAction.window = false;
        MitarbeiterBearbeitenAction.bearbeitungsAuswahl_MitarbeiterID = -100;

        JFrame meinRahmen = new JFrame();
        meinRahmen.setSize(250, 250);
        JPanel meinPanel = new JPanel();
        meinRahmen.setLocationRelativeTo(null);

        JComboBox combo2 = new JComboBox();

        if (änderung == -99) {
            meinRahmen.setTitle("Mitarbeiter ID");
            JLabel frage = new JLabel("Welcher Mitarbeiter wird bearbeitet?");
            meinPanel.add(frage);
            for (Mitarbeiter worker : MenuManager.getWorkerList()) {
                combo2.addItem(worker.getMitarbeiterID());
            }
        }

        meinRahmen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                MitarbeiterBearbeitenAction.window = true;
            }
        });

        ActionListener cbActionListener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (änderung == -99) {
                    MitarbeiterBearbeitenAction.bearbeitungsAuswahl_MitarbeiterID = (int) combo2.getSelectedItem();
                }
            }
        };
        meinPanel.add(combo2);
        meinRahmen.add(meinPanel, BorderLayout.SOUTH);
        meinRahmen.pack();
        meinRahmen.setVisible(true);
        while (MitarbeiterBearbeitenAction.window == false) {
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
     * Methode zum Anpassen der Länge des Attributes (außer Datum) bei der Ausgabe auf der Konsole.
     *
     * @param wort
     *            = mitgegebenes Attribut
     * @return das Attribut mit den anschließenden Leerzeichen
     */
    private String länge_anpassen(String wort) {

        if (wort.length() < 50) {
            while (wort.length() < 50) {
                wort = wort + " ";
            }
        }
        return wort;
    }
}
