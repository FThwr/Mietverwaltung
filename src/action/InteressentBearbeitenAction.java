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

import hilfsklassen.Adresse;
import hilfsklassen.Datum;
import menu.MenuManager;
import objekte.Interessent;
import objekte.Mieter;

public class InteressentBearbeitenAction extends MenuManager implements Action, Serializable {

    static int bearbeitungsAuswahl_interessentenID;
    static int such_wohnung;
    static int such_mitarbeiterID;
    static boolean window = false;

    @Override
    public void action() {

        System.out.println("________________________________________ Interessent bearbeiten ________________________________________\n");

        InteressentBearbeitenAction.bearbeitungsAuswahl_interessentenID = -100;
        /*
         * Variable zum �ffnen des richtigen JFrames und zur Auswahl des zu
         * bearbeitenden Attributs.
         */
        int �nderung = -99;

        // Ausgabe aller Interessenten-IDs zur einfacheren Auswahl
        JComboBox_optimierte_Auswahl(�nderung);

        // Variable enth�lt die ID des zu bearbeitenden Interessenten
        int zu_bearbeitenden_interessent = InteressentBearbeitenAction.bearbeitungsAuswahl_interessentenID;

        boolean bearbeitungsVorgang = true;
        /*
        * Array beeinhaltet alle Attribute, die ver�ndert werden k�nnen und
        * dient zur Ausgabe durch Zugriff auf deren Index
        */
        String[] kategorie = { "Interessenten ID", "Name", "Vorname", "Geburtsdatum", "E-Mail", "Adresse", "Telefonnummer", "Rolle" };

        /*
         * diese Variablen dienen sp�ter f�r eine tabellarische Ausgabe auf der
         * Konsole
         */
        String l�ngenAnpassung_interessentenID = "";
        String l�ngenAnpassung_Name = "";
        String l�ngenAnpassung_Vorname = "";
        String l�ngenAnpassung_EMail = "";
        String l�ngenAnpassung_Telefonnummer = "";
        String l�ngenAnpassung_Rolle = "";

        /*
         * allgemeine Variablen alte = aktuelle Werte neue = neue/ver�nderten
         * Werte
         */
        int aktuelleInteressentenID = -100;
        int neueInteressentenID = -100;

        String aktuellerName = "-";
        String neuerName = "-";

        String aktuellerVorname = "-";
        String neuerVorname = "-";

        Datum aktuellesGeburtsdatum = null;
        Datum neuesGeburtsdatum = null;

        String aktuelleEMail = "-";
        String neueEMail = "-";

        Adresse aktuelleAdresse = null;
        Adresse neueAdresse = null;

        String aktuelleTelefon = "-";
        String neueTelefon = "-";

        String aktuelleRolle = "-";
        String neueRolle = "-";

        /*
         * Variablen enthalten die Leerzeichen, die nach den Objekten (Daten)
         * eingesetzt werden. Die L�ngen der einzelnen Komponenten der Objekte
         * werden verwendet
         */
        String GD_Leerzeichen = "";
        String ADR_Leerzeichen = "";

        /*
         * F�r jedes Element in der Interessentenliste wird �berpr�ft, welches
         * Element mit der eingegebenen Interessenten-ID �bereinstimmt und diese
         * wird daraufhin zum Bearbeiten freigegeben.
         */
        for (Interessent interest : MenuManager.getInterestList()) {
            if (zu_bearbeitenden_interessent == interest.getKundenID()) {

                aktuelleInteressentenID = interest.getKundenID();
                neueInteressentenID = aktuelleInteressentenID;

                aktuellerName = interest.getName();
                neuerName = aktuellerName;

                aktuellerVorname = interest.getVorname();
                neuerVorname = aktuellerVorname;

                aktuellesGeburtsdatum = interest.getGeburtsdatum();
                neuesGeburtsdatum = aktuellesGeburtsdatum;

                aktuelleEMail = interest.getEmail();
                neueEMail = aktuelleEMail;

                aktuelleAdresse = interest.getAdresse();
                neueAdresse = aktuelleAdresse;

                aktuelleTelefon = interest.getTelefonnummer();
                neueTelefon = aktuelleTelefon;

                aktuelleRolle = interest.getRolle();
                neueRolle = aktuelleRolle;

                /*
                 * Initialisierung der tabellarischen Variablen + Ausf�llung mit
                 * Leerzeichen (Umwandlung in die Tabelle)
                 */
                l�ngenAnpassung_interessentenID = "" + aktuelleInteressentenID;
                l�ngenAnpassung_interessentenID = l�nge_anpassen(l�ngenAnpassung_interessentenID);

                l�ngenAnpassung_Name = aktuellerName;
                l�ngenAnpassung_Name = l�nge_anpassen(l�ngenAnpassung_Name);

                l�ngenAnpassung_Vorname = aktuellerVorname;
                l�ngenAnpassung_Vorname = l�nge_anpassen(l�ngenAnpassung_Vorname);

                if (aktuellesGeburtsdatum != null) {
                    GD_Leerzeichen = l�nge_anpassen_Datum(aktuellesGeburtsdatum);
                }
                l�ngenAnpassung_EMail = aktuelleEMail;
                l�ngenAnpassung_EMail = l�nge_anpassen(l�ngenAnpassung_EMail);

                if (aktuelleAdresse != null) {
                    ADR_Leerzeichen = l�nge_anpassen_Adresse(aktuelleAdresse);
                }
                l�ngenAnpassung_Telefonnummer = aktuelleTelefon;
                l�ngenAnpassung_Telefonnummer = l�nge_anpassen(l�ngenAnpassung_Telefonnummer);

                l�ngenAnpassung_Rolle = aktuelleRolle;
                l�ngenAnpassung_Rolle = l�nge_anpassen(l�ngenAnpassung_Rolle);
            }
        }

        /*
         * Solange der Bearbeitungsvorgang nicht beendet ist, wird immer eine
         * �bersicht �ber den alten Wert und den neuen Wert des jeweiligen
         * Attributs ausgegeben. Es wird pro Durchlauf immer 1 Attribut
         * ausgew�hlt, welches man draufhin ver�ndern kann.
         */
        while (bearbeitungsVorgang == true) {

            System.out.println("1. Interessenten ID:             " + l�ngenAnpassung_interessentenID + "neue Interessenten ID: " + neueInteressentenID);
            System.out.println("2. Name:                         " + l�ngenAnpassung_Name + "neuer Name:            " + neuerName);
            System.out.println("3. Vorname:                      " + l�ngenAnpassung_Vorname + "neuer Vorname:         " + neuerVorname);
            System.out.println("4. Geburtsdatum:                 " + aktuellesGeburtsdatum + GD_Leerzeichen + "neues Geburtsdatum:    " + neuesGeburtsdatum);
            System.out.println("5. E-Mail:                       " + l�ngenAnpassung_EMail + "neue E-Mail:           " + neueEMail);
            System.out.println("6. Adresse:                      " + aktuelleAdresse + ADR_Leerzeichen + "neue Adresse:          " + neueAdresse);
            System.out.println("7. Telefonnummer:                " + l�ngenAnpassung_Telefonnummer + "neue Telefonnummer:    " + neueTelefon);
            System.out.println("8. Rolle:                        " + l�ngenAnpassung_Rolle + "neue Rolle:            " + neueRolle);
            System.out.println("9. Bearbeitung abschlie�en");
            System.out.println("0. Abbruch");
            System.out.println("");

            Scanner t = new Scanner(System.in);

            /*
             * Die try-catch Klammer existiert f�r nicht erw�nschte Eingaben wie
             * Zeichen, wo Zahlen erwartet werden.
             */
            try {

                // Variable zur Auswahl des zu bearbeitenden Attributs
                �nderung = t.nextInt();

                // Abbruch
                if (�nderung == 0) {
                    System.out.println("-------------------------------Bearbeitungsvorgang wurde abgebrochen!-------------------------------\n");
                    bearbeitungsVorgang = false;
                }

                // Interessenten-ID
                if (�nderung == 1) {

                    int eingabe = einlesen_Zahl(kategorie, �nderung);
                    if (eingabe == 0) {
                    } else {

                        int vorhanden = 0;
                        /*
                         * F�r jedes Element in der Interessentenliste wird
                         * geguckt, ob die eingegebende ID mit einer bereits
                         * existierenden �bereinstimmt.
                         */
                        for (Interessent interest : MenuManager.getInterestList()) {
                            if (eingabe == interest.getKundenID()) {
                                vorhanden = 1;
                            }
                        }

                        /*
                         * F�r jedes Element in der Liste der ehemaligen
                         * Interessenten wird geguckt, ob die eingegebende ID
                         * mit einer bereits existierenden �bereinstimmt.
                         */
                        for (Interessent ehemaligerInteressent : MenuManager.ehemaligeInteressenten) {
                            if (eingabe == ehemaligerInteressent.getKundenID()) {
                                vorhanden = 1;
                            }
                        }

                        /*
                         * Wenn vorhanden = 1 ist, dann existiert ein
                         * Interessent mit dieser ID bereits
                         */
                        if (vorhanden == 1) {
                            System.out.println("\n------------------------------- Fehler! ------------------------------- \nKunden ID bereits vergeben!\n");
                        } else {
                            neueInteressentenID = eingabe;
                        }
                    }
                }

                // Name
                if (�nderung == 2) {
                    String eingabe = einlesen_Wort(kategorie, �nderung);
                    if (eingabe.equals("" + 0)) {
                    } else {
                        neuerName = eingabe;
                    }
                }

                // Vorname
                if (�nderung == 3) {
                    String eingabe = einlesen_Wort(kategorie, �nderung);
                    if (eingabe.equals("" + 0)) {
                    } else {
                        neuerVorname = eingabe;
                    }
                }

                // Geburtsdatum
                if (�nderung == 4) {

                    neuesGeburtsdatum = Datum_Eingabe(aktuellesGeburtsdatum);

                }

                // E-Mail
                if (�nderung == 5) {
                    String eingabe = einlesen_Wort(kategorie, �nderung);
                    if (eingabe.equals("" + 0)) {
                    } else {
                        neueEMail = eingabe;
                    }
                }

                // Adresse
                if (�nderung == 6) {
                    String[] auswahl = { "Stra�e", "Hausnummer", "Platz", "Stadt" };
                    int z�hler = 1;
                    String stra�e = einlesen_Wort(auswahl, z�hler);
                    z�hler = 2;
                    int hausnummer = einlesen_Zahl(auswahl, z�hler);
                    z�hler = 3;
                    int platz = einlesen_Zahl(auswahl, z�hler);
                    z�hler = 4;
                    String stadt = einlesen_Wort(auswahl, z�hler);

                    /*
                     * Wenn einer der Werte versucht wird zu �berspringen/
                     * auszulassen, dann bleibt es beim unver�nderten Datum.
                     */
                    if (stra�e.equals("" + 0) || hausnummer == 0 || hausnummer == -100 || platz == 0 || platz == -100 || stadt.equals("" + 0)) {
                    } else {
                        neueAdresse = new Adresse(stra�e, hausnummer, platz, stadt);
                    }
                }

                // Telefonnummer
                if (�nderung == 7) {
                    String eingabe = einlesen_Wort(kategorie, �nderung);
                    if (eingabe.equals("" + 0)) {
                    } else {
                        neueTelefon = eingabe;
                    }
                }

                // Rolle
                if (�nderung == 8) {

                    Scanner a = new Scanner(System.in);
                    System.out.println("Geben Sie die Zahl vom gew�nschten Status aus: '1' = Interessent, '2' = Mieter, '3' = Delete");

                    try {
                        int eingabe = a.nextInt();

                        if (eingabe == 0) {
                        }
                        if (eingabe == 1) {

                            neueRolle = "Interessent";
                        }
                        if (eingabe == 2) {
                            neueRolle = "Mieter";
                        }
                        if (eingabe == 3) {
                            neueRolle = "Delete";
                        }
                        if (eingabe > 3) {
                            System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit existiert nicht!\n");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
                    }

                }

                // Bearbeitung abschlie�en
                if (�nderung == 9) {
                    bearbeitungsVorgang = false;

                    /*
                     * Wenn die neue Rolle des Interessenten wieder die des
                     * Interessenten ist, dann werden f�r ihn die neuen Daten
                     * eingetragen und die alten �berschrieben.
                     */
                    if (neueRolle.equals("Interessent")) {

                        for (Interessent interest : MenuManager.getInterestList()) {
                            if (zu_bearbeitenden_interessent == interest.getKundenID()) {
                                interest.setKundenID(neueInteressentenID);
                                interest.setName(neuerName);
                                interest.setVorname(neuerVorname);
                                interest.setGeburtsdatum(neuesGeburtsdatum);
                                interest.setEmail(neueEMail);
                                interest.setAdresse(neueAdresse);
                                interest.setTelefonnummer(neueTelefon);
                            }
                        }
                    }

                    /*
                     * Wenn die neue Rolle des Interessenten die des 'Mieters'
                     * ist, dann wird in der Interessentenliste nach dem so eben
                     * bearbeitenenden Interessenten gesucht und dieser zur
                     * Liste der Mieter hinzugef�gt und die Liste gespeichert.
                     * Au�erdem wird er aus der Liste der Interessenten
                     * gel�scht. Das alles funktioniert nur bei midnestens 2
                     * Elementen in der Liste.
                     */
                    if (neueRolle.equals("Mieter")) {
                        for (Interessent interest : MenuManager.getInterestList()) {
                            if (zu_bearbeitenden_interessent == interest.getKundenID()) {
                                MenuManager.currentManager.add(new Mieter(neueInteressentenID, neuerName, neuerVorname, neuesGeburtsdatum, -100, neueEMail, neueAdresse, neueTelefon, neueRolle));

                                // L�schen
                                Iterator<Interessent> iter = MenuManager.getInterestList().iterator();

                                while (iter.hasNext()) {
                                    Interessent str = iter.next();

                                    if (str.getKundenID() == aktuelleInteressentenID) {
                                        iter.remove();
                                    }
                                }
                            }
                        }
                    }

                    /*
                     * Wenn die neue Rolle des Interessenten auf 'Delete'
                     * gesetzt wird, dann wird in der Interessentenliste nach
                     * dem so eben bearbeitenenden Interessenten gesucht und
                     * dieser aus der Liste der Interessenten gel�scht.
                     */
                    if (neueRolle.equals("Delete")) {

                        Iterator<Interessent> iter = MenuManager.getInterestList().iterator();

                        while (iter.hasNext()) {
                            Interessent str = iter.next();

                            if (str.getKundenID() == aktuelleInteressentenID) {
                                iter.remove();
                            }
                        }

                    }
                }
                // Eingabe > 9
                if (�nderung > 9) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit existiert nicht!\n");
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

        System.out.println("Eingabe des Eingangsdatum: W�hlen Sie bei einem Wert '0' und das Datum bleibt unver�ndert!");
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
        InteressentBearbeitenAction.window = false;

        JFrame meinRahmen = new JFrame();

        meinRahmen.setSize(250, 250);
        JPanel meinPanel = new JPanel();
        meinRahmen.setLocationRelativeTo(null);

        JComboBox combo2 = new JComboBox();

        if (�nderung == -99) {
            meinRahmen.setTitle("Interessenten ID");
            JLabel frage = new JLabel("Welchen Interessenten m�chten Sie bearbeiten?");
            meinPanel.add(frage);
            for (Interessent interest : MenuManager.getInterestList()) {
                combo2.addItem(interest.getKundenID());
            }
        }

        meinRahmen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                InteressentBearbeitenAction.window = true;
            }
        });

        ActionListener cbActionListener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (�nderung == -99) {
                    InteressentBearbeitenAction.bearbeitungsAuswahl_interessentenID = (int) combo2.getSelectedItem();
                }
            }
        };
        meinPanel.add(combo2);
        meinRahmen.add(meinPanel, BorderLayout.SOUTH);
        meinRahmen.pack();
        meinRahmen.setVisible(true);
        while (InteressentBearbeitenAction.window == false) {
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
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nNur positive Zahlen erlaubt!\n");
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

    /**
     * Methode zum Anpassen der L�nge des Datums bei der Ausgabe auf der Konsole.
     */

    private String l�nge_anpassen_Datum(final Datum a_GD) {

        String leerzeichen = "";

        String jahr = "" + a_GD.getJahr();
        int l_J = jahr.length();

        String monat = "" + a_GD.getMonat();
        int l_M = monat.length();

        String tag = "" + a_GD.getTag();
        int l_T = tag.length();

        int abzug = l_J + l_M + l_T + 2; // +2 f�r die Punkte zwischen den
                                         // Komponenten
        if (abzug < 50) {
            while (abzug < 50) {
                leerzeichen = leerzeichen + " ";
                abzug += 1;
            }
        }
        return leerzeichen;
    }

    /**
     * Methode zum Anpassen der L�nge des Attributes (au�er Datum) bei der Ausgabe auf der Konsole.
     *
     * @param wort
     *            = mitgegebenes Attribut
     * @return das Attribut mit den anschlie�enden Leerzeichen
     */

    private String l�nge_anpassen(String wort) {

        int abzug = wort.length();
        if (wort.length() < 50) {
            while (wort.length() < 50) {
                wort = wort + " ";
            }
        }
        return wort;
    }

    /**
     * Methode zum Anpassen der L�nge der Adresse bei der Ausgabe auf der Konsole.
     */

    private String l�nge_anpassen_Adresse(final Adresse a_A) {

        String leerzeichen = "";

        String hausnummer = "" + a_A.getHausnummer();
        int l_HN = hausnummer.length();

        String platz = "" + a_A.getPlz();
        int l_P = platz.length();

        String stadt = a_A.getStadt();
        int l_ST = stadt.length();

        String stra�e = a_A.getStrasse();
        int l_SR = stra�e.length();

        int abzug = l_HN + l_P + l_SR + l_ST + 3; // +3 f�r die Leerzeichen
                                                  // zwischen den Komponenten
        if (abzug < 50) {
            while (abzug < 50) {
                leerzeichen = leerzeichen + " ";
                abzug += 1;
            }
        }
        return leerzeichen;
    }
}