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
import objekte.Mieter;
import objekte.Wohnung;

public class MieterBearbeitenAction extends MenuManager implements Action, Serializable {

    static int bearbeitungsAuswahl_mieterID;
    static int neue_wohnung;
    static boolean window = false;

    @Override
    public void action() {

        System.out.println("________________________________________ Mieter bearbeiten ________________________________________");

        /*
         * Variable zum Öffnen des richtigen JFrames und zur Auswahl des zu
         * bearbeitenden Attributs.
         */
        int änderung = -99;

        // Ausgabe aller Mieter-IDs zur einfacheren Auswahl
        auswahl_AuftragsID_Wohnung_MitarbeiterID(änderung);

        // Variable enthält die ID des zu bearbeitenden Mieters
        int zu_bearbeitenden_mieter = MieterBearbeitenAction.bearbeitungsAuswahl_mieterID;

        boolean bearbeitungsVorgang = true;
        String[] kategorie = { "Mieter ID", "Name", "Vorname", "Geburtsdatum", "Wohnung", "E-Mail", "Adresse", "Telefonnummer", "Rolle" };

        /*
         * Diese Variablen dienen später für eine tabellarische Ausgabe auf der
         * Konsole
         */
        String längenAnpassung_mieterID = "";
        String längenAnpassung_Name = "";
        String längenAnpassung_Vorname = "";
        String längenAnpassnung_Wohnung = "";
        String längenAnpassung_EMail = "";
        String längenAnpassung_Telefonnummer = "";
        String längenAnpassung_Rolle = "";

        /*
         * Allgemeine Variablen alte = aktuelle Werte, neue = neue/veränderte
         * Werte
         */
        int aktuelleMieterID = 0;
        int neueMieterID = 0;

        String aktuellerName = "";
        String neuerName = "";

        String aktuellerVorname = "";
        String neuerVorname = "";

        Datum aktuellesGeburtsdatum = null;
        Datum neuesGeburtsdatum = null;

        int aktuelleWohnung = -100;
        int neueWohnung = -100;

        String aktuelleEMail = "";
        String neueEMail = "";

        Adresse aktuelleAdresse = null;
        Adresse neueAdresse = null;

        String aktuelleTelefonnummer = "";
        String neueTelefonnummer = "";

        String aktuelleRolle = "";
        String neueRolle = "";

        /*
         * Variablen auch zur tabellarischen Ausgabe und enthalten die
         * Leerzeichen, die nach den Objekten (Daten) eingesetzt werden. Die
         * Längen der einzelnen Komponenten der Objekte werden verwendet.
         */
        String GD_Leerzeichen = "";
        String ADR_Leerzeichen = "";

        /*
         * Für jedes Element in der ArrayList 'ownerList', welche alle Mieter
         * beeinhaltet, wir zeurst das Objekt in der ArrayList gesucht, welche
         * der eben ausgewählten Mieter-ID entspricht. Es werden neue Variablen
         * angelegt, welche die einzelnen Werte des Objekts beeinhalten.
         */
        for (Mieter owner : MenuManager.getOwnerList()) {
            if (zu_bearbeitenden_mieter == owner.getKundenID()) {

                aktuelleMieterID = owner.getKundenID();
                neueMieterID = aktuelleMieterID;

                aktuellerName = owner.getName();
                neuerName = aktuellerName;

                aktuellerVorname = owner.getVorname();
                neuerVorname = aktuellerVorname;

                aktuellesGeburtsdatum = owner.getGeburtsdatum();
                neuesGeburtsdatum = aktuellesGeburtsdatum;

                aktuelleWohnung = owner.getWohnungsnummer();
                neueWohnung = aktuelleWohnung;

                aktuelleEMail = owner.getEmail();
                neueEMail = aktuelleEMail;

                aktuelleAdresse = owner.getAdresse();
                neueAdresse = aktuelleAdresse;

                aktuelleTelefonnummer = owner.getTelefonnummer();
                neueTelefonnummer = aktuelleTelefonnummer;

                aktuelleRolle = owner.getRolle();
                neueRolle = aktuelleRolle;

                /*
                 * Initialisierung der tabellarischen Variablen + Ausfüllung mit
                 * Leerzeichen (Umwandlung in die Tabelle)
                 */
                längenAnpassung_mieterID = "" + aktuelleMieterID;
                längenAnpassung_mieterID = länge_anpassen(längenAnpassung_mieterID);

                längenAnpassung_Name = aktuellerName;
                längenAnpassung_Name = länge_anpassen(längenAnpassung_Name);

                längenAnpassung_Vorname = aktuellerName;
                längenAnpassung_Vorname = länge_anpassen(längenAnpassung_Vorname);

                GD_Leerzeichen = länge_anpassen_Datum(aktuellesGeburtsdatum);

                längenAnpassnung_Wohnung = "" + owner.getWohnungsnummer();
                längenAnpassnung_Wohnung = länge_anpassen(längenAnpassnung_Wohnung);

                längenAnpassung_EMail = aktuelleEMail;
                längenAnpassung_EMail = länge_anpassen(längenAnpassung_EMail);

                ADR_Leerzeichen = länge_anpassen_Adresse(aktuelleAdresse);

                längenAnpassung_Telefonnummer = aktuelleTelefonnummer;
                längenAnpassung_Telefonnummer = länge_anpassen(längenAnpassung_Telefonnummer);

                längenAnpassung_Rolle = aktuelleRolle;
                längenAnpassung_Rolle = länge_anpassen(längenAnpassung_Rolle);
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
            System.out.println("1.  Mieter ID:       " + längenAnpassung_mieterID + "neue Mieter ID:       " + neueMieterID);
            System.out.println("2.  Name:            " + längenAnpassung_Name + "neuer Name:           " + neuerName);
            System.out.println("3.  Vorname:         " + längenAnpassung_Vorname + "neuer Vorame:         " + neuerVorname);
            System.out.println("4.  Geburtsdatum:    " + GD_Leerzeichen + "neues Geburtsdatum:   " + neuesGeburtsdatum);
            System.out.println("5.  Wohnung:         " + längenAnpassnung_Wohnung + "neue Wohnung:         " + neueWohnung);
            System.out.println("6.  E-Mail:          " + längenAnpassung_EMail + "neue E-Mail:          " + neueEMail);
            System.out.println("7.  Adresse:         " + ADR_Leerzeichen + "neue Adresse:         " + neueAdresse);
            System.out.println("8.  Telefonnummer:   " + längenAnpassung_Telefonnummer + "neue Telefonnummer:   " + neueTelefonnummer);
            System.out.println("9.  Rolle:           " + längenAnpassung_Rolle + "neue Rolle:           " + neueRolle);
            System.out.println("10. Bearbeitung abschließen");
            System.out.println("0.  Abbruch");
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

                // Mieter-ID
                if (änderung == 1) {

                    int eingabe = einlesen_Zahl(kategorie, änderung);
                    if (eingabe == 0) {
                    } else {

                        int vorhanden = 0;
                        /*
                         * Für jedes Element in der Handwerkerliste der aktiven
                         * Aufträge wird geguckt, ob die eingegebende ID mit
                         * einer bereits existierenden übereinstimmt.
                         */
                        for (Mieter owner : MenuManager.ownerList) {
                            if (eingabe == owner.getKundenID()) {
                                vorhanden = 1;
                            }
                        }

                        /*
                         * Für jedes Element in der Handwerkerliste der
                         * abgeschlossenen Aufträge wird geguckt, ob die
                         * eingegebende ID mit einer bereits existierenden
                         * übereinstimmt.
                         */
                        for (Mieter ehermaligerMieter : MenuManager.ehemaligeMieter) {
                            if (eingabe == ehermaligerMieter.getKundenID()) {
                                vorhanden = 1;
                            }
                        }

                        /*
                         * Wenn die Variable 'vorhanden' = 1, dann existierte
                         * ein Handwerkerauftrag mit dieser ID bereits. Sonst
                         * wird die eingegebene ID die ID des Auftrags.
                         */
                        if (vorhanden == 1) {
                            System.out.println("\n------------------------------- Fehler! ------------------------------- \n Mieter-ID bereits vergeben!\n");
                        } else {
                            neueMieterID = eingabe;
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

                // Geburtsdatum
                if (änderung == 4) {

                    neuesGeburtsdatum = Datum_Eingabe(aktuellesGeburtsdatum);
                }

                // Wohnung
                if (änderung == 5) {

                    int eingabe = einlesen_Zahl(kategorie, änderung);

                    if (eingabe == 0) {
                    } else {
                        int nichtVorhanden = 0;
                        for (Mieter owner : MenuManager.ownerList) {
                            for (Wohnung flat : MenuManager.getFlatList()) {

                                /*
                                 * nur wenn die Wohnung von keinem anderen
                                 * Mieter belegt ist und die Wohnung existiert
                                 */
                                if (owner.getWohnungsnummer() != eingabe && eingabe == flat.getWohnungsID()) {
                                    nichtVorhanden = 1;

                                }
                                if (owner.getWohnungsnummer() == eingabe && flat.getStatus().equals("vermietet")) {
                                    nichtVorhanden = 2;

                                }
                            }
                        }
                        if (nichtVorhanden == 1) {
                            neueWohnung = eingabe;
                        }
                        if (nichtVorhanden == 2) {
                            System.out.println("------------------------------- Fehler! ------------------------------- \nWohnung bereits von einem anderen Mieter belegt!");
                            if (nichtVorhanden != 2 && nichtVorhanden != 1) {
                                System.out.println("------------------------------- Fehler! ------------------------------- \nWohnung existiert nicht! ");
                            }
                        }
                    }
                }

                // E-Mail
                if (änderung == 6) {
                    String eingabe = einlesen_Wort(kategorie, änderung);
                    if (eingabe.equals("" + 0)) {
                    } else {
                        neueEMail = eingabe;
                    }
                }

                // Adresse
                if (änderung == 7) {
                    String[] auswahl = { "Straße", "Hausnummer", "Platz", "Stadt" };
                    int zähler = 1;
                    String straße = einlesen_Wort(auswahl, zähler);
                    zähler = 2;
                    int hausnummer = einlesen_Zahl(auswahl, zähler);
                    zähler = 3;
                    int platz = einlesen_Zahl(auswahl, zähler);
                    zähler = 4;
                    String stadt = einlesen_Wort(auswahl, zähler);

                    if (straße.equals("" + 0) || hausnummer == 0 || platz == 0 || stadt.equals("" + 0) || hausnummer == -100 || platz == -100) {
                    } else {
                        neueAdresse = new Adresse(straße, hausnummer, platz, stadt);
                    }
                }

                // Telefonnummer
                if (änderung == 8) {
                    String eingabe = einlesen_Wort(kategorie, änderung);
                    if (eingabe.equals("" + 0)) {
                    } else {
                        neueTelefonnummer = eingabe;
                    }
                }

                // Rolle
                if (änderung == 9) {
                    String[] auswahl = { "Mieter", "Delete" };

                    Scanner a = new Scanner(System.in);
                    System.out.println("Geben Sie die Zahl vom gewünschten Status aus: " + "1" + auswahl[0] + "2" + auswahl[1]);

                    try {
                        int eingabe = a.nextInt();

                        if (eingabe == 0) {
                        }

                        if (eingabe == 1) {
                            neueRolle = "Mieter";
                        }
                        if (eingabe == 2) {
                            neueRolle = "Delete";
                        }
                        if (eingabe > 2) {
                            System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit nicht vorhanden!\n");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
                    }
                }

                // Bearbeiten abschließen
                if (änderung == 10) {
                    bearbeitungsVorgang = false;

                    if (neueRolle.equals("Mieter")) {

                        for (Mieter owner : MenuManager.ownerList) {
                            if (zu_bearbeitenden_mieter == owner.getKundenID()) {
                                owner.setKundenID(neueMieterID);
                                owner.setName(neuerName);
                                owner.setVorname(neuerVorname);
                                owner.setGeburtsdatum(neuesGeburtsdatum);
                                owner.setWohnungsnummer(neueWohnung);
                                owner.setEmail(neueEMail);
                                owner.setAdresse(neueAdresse);
                                owner.setTelefonnummer(neueTelefonnummer);
                            }
                        }
                    }

                    if (neueRolle.equals("Delete")) {

                        MenuManager.ehemaligeMieter.add(new Mieter(neueMieterID, neuerName, neuerVorname, neuesGeburtsdatum, neueWohnung, neueEMail, neueAdresse, neueTelefonnummer, "Mieter"));

                        Iterator<Mieter> iter = MenuManager.ownerList.iterator();

                        while (iter.hasNext()) {
                            Mieter str = iter.next();

                            if (str.getKundenID() == aktuelleMieterID) {
                                iter.remove();
                            }
                        }
                    }
                }
                // Eingabe > 10
                if (änderung > 10) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabemöglichkeit existiert nicht!");

                }
            } catch (InputMismatchException e) {
                System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
            }
        }

        {
            System.out.println("------------------------------- Fehler! ------------------------------- \nIhre Eingabe war nicht erfolgreich, weil die ID nicht existiert!\n");
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
                System.out.println("\n------------------------------- Fehler! ------------------------------- \nMonat darf nicht höher als 12 sein!");
            }
        } while (monat > 12);

        zähler = 3;
        int tag = 0;
        do {
            tag = einlesen_Zahl(auswahl, zähler);
            if (monat == 1 || monat == 3 || monat == 5 || monat == 7 || monat == 8 || monat == 10 || monat == 12) {
                if (tag > 31) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 31 Tage!");
                } else {
                    datumsEingabeErfolgreich = true;
                }
            }

            if (monat == 4 || monat == 6 || monat == 9 || monat == 11) {
                if (tag > 30) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 30 Tage!");
                } else {
                    datumsEingabeErfolgreich = true;
                }
            }

            if (monat == 2) {
                if (tag > 29) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 29 Tage!");
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
    private void auswahl_AuftragsID_Wohnung_MitarbeiterID(final int änderung) {
        MieterBearbeitenAction.window = false;
        MieterBearbeitenAction.bearbeitungsAuswahl_mieterID = 0;
        MieterBearbeitenAction.neue_wohnung = 0;
        JFrame meinRahmen = new JFrame();

        meinRahmen.setSize(250, 250);
        JPanel meinPanel = new JPanel();
        meinRahmen.setLocationRelativeTo(null);

        JComboBox combo2 = new JComboBox();

        if (änderung == -99) {
            meinRahmen.setTitle("Mieter ID");
            JLabel frage = new JLabel("Welchen Mieter möchten Sie bearbeiten?");
            meinPanel.add(frage);
            for (Mieter owner : MenuManager.ownerList) {
                combo2.addItem(owner.getKundenID());
            }
        }

        if (änderung == 1) {
            meinRahmen.setTitle("Mieter ID");
            JLabel frage = new JLabel("Welchen Mieter möchten Sie auswählen?");
            meinPanel.add(frage);
            for (Mieter owner : MenuManager.ownerList) {
                combo2.addItem(owner.getKundenID());
            }
        }

        meinRahmen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                MieterBearbeitenAction.window = true;
            }
        });

        ActionListener cbActionListener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (änderung == -99) {
                    MieterBearbeitenAction.bearbeitungsAuswahl_mieterID = (int) combo2.getSelectedItem();
                }
                if (änderung == 2) {
                    MieterBearbeitenAction.neue_wohnung = (int) combo2.getSelectedItem();
                }
            }
        };
        meinPanel.add(combo2);
        meinRahmen.add(meinPanel, BorderLayout.SOUTH);
        meinRahmen.pack();
        meinRahmen.setVisible(true);
        while (MieterBearbeitenAction.window == false) {
            combo2.addActionListener(cbActionListener);
        }

    }

    private int einlesen_Zahl(final String[] auswahl, final int zähler) {
        System.out.println("Geben Sie ein: " + auswahl[zähler - 1]);
        Scanner s = new Scanner(System.in);
        int wort = s.nextInt();
        return wort;
    }

    private String einlesen_Wort(final String[] auswahl, final int zähler) {
        System.out.println("Geben Sie ein: " + auswahl[zähler - 1]);
        Scanner s = new Scanner(System.in);
        String wort = s.next();
        return wort;
    }

    private String länge_anpassen_Datum(final Datum a_GD) {

        String leerzeichen = "";

        String jahr = "" + a_GD.getJahr();
        int l_J = jahr.length();

        String monat = "" + a_GD.getMonat();
        int l_M = monat.length();

        String tag = "" + a_GD.getTag();
        int l_T = tag.length();

        int abzug = l_J + l_M + l_T + 2; // +2 für die Punkte zwischen den
                                         // Komponenten
        if (abzug < 50) {
            while (abzug < 50) {
                leerzeichen = leerzeichen + " ";
                abzug += 1;
            }
        }
        return leerzeichen;
    }

    private String länge_anpassen(String wort) {

        int abzug = wort.length();
        if (wort.length() < 50) {
            while (wort.length() < 50) {
                wort = wort + " ";
            }
        }
        return wort;
    }

    private String länge_anpassen_Adresse(final Adresse a_A) {

        String leerzeichen = "";

        String hausnummer = "" + a_A.getHausnummer();
        int l_HN = hausnummer.length();

        String platz = "" + a_A.getPlz();
        int l_P = platz.length();

        String stadt = a_A.getStadt();
        int l_ST = stadt.length();

        String straße = a_A.getStrasse();
        int l_SR = straße.length();

        int abzug = l_HN + l_P + l_SR + l_ST + 3; // +3 für die Leerzeichen
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