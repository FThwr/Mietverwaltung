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

import hilfsklassen.Adresse;
import hilfsklassen.Datum;
import menu.MenuManager;
import objekte.Handwerkerauftrag;
import objekte.Mitarbeiter;
import objekte.Wohnung;

public class WohnungErstellenAction extends MenuManager implements Action, Serializable {

    static int JFrame_mitarbeiterID_auswahl;
    static boolean window = false;

    @Override
    public void action() {

        System.out.println("________________________________________ Wohnung erstellen ________________________________________");

        /*
         * Variable zum �ffnen des richtigen JFrames und zur Auswahl des zu
         * bearbeitenden Attributs.
         */
        int �nderung = -99;

        boolean erstellVorgang = true;

        int wohnungsnummer = -100;
        int zimmeranzahl = -100;
        double fl�che = -100;
        double kosten = -100;
        int etage = -100;
        boolean balkon = false;
        boolean fu�bodenheizung = false;
        String aussicht = "-";
        Adresse adresse = null;
        String status = "frei";
        Datum letztesRenovierungsdatum = null;
        int renovierungsanzahl = -100;
        String letzeRenovierung_Details = "-";
        Handwerkerauftrag handwerkerauftrag = null;
        Mitarbeiter zugeordneterMitarbeiter = null;

        /*
         * Solange der Erstellvorgang nicht beendet ist, wird immer eine
         * �bersicht �ber den erstellten Wert ausgegeben. Es wird pro Durchlauf
         * immer 1 Attribut ausgew�hlt, welches man draufhin ver�ndern kann.
         */
        while (erstellVorgang == true) {

            /*
             * Array beeinhaltet alle Attribute, die ver�ndert werden k�nnen und
             * dient zur Ausgabe durch Zugriff auf deren Index
             */
            String[] kategorie = { "Wohnungsnummer", "Zimmeranzahl", "Fl�che", "Kosten", "Etage", "Balkon", "Fu�bodenheizung", "Aussicht", "Adresse", "zugeordneten Mitarbeiter" };

            System.out.println("\nW�hlen Sie einen zu bearbeitenenden Wert!\nFolgende Wohnung wird aktuell erstellt: \n");
            System.out.println("Dr�cke '1' f�r Wohnungsnummer:                           " + wohnungsnummer);
            System.out.println("Dr�cke '2' f�r Zimmeranzahl:                             " + zimmeranzahl);
            System.out.println("Dr�cke '3' f�r Fl�che:                                   " + fl�che);
            System.out.println("Dr�cke '4' f�r Kosten:                                   " + kosten);
            System.out.println("Dr�cke '5' f�r Etage:                                    " + etage);
            System.out.println("Dr�cke '6' f�r Balkon:                                   " + balkon);
            System.out.println("Dr�cke '7' f�r Fu�bodenheizung:                          " + fu�bodenheizung);
            System.out.println("Dr�cke '8' f�r Aussicht:                                 " + aussicht);
            System.out.println("Dr�cke '9' f�r Adresse:                                  " + adresse);
            System.out.println("Dr�cke '10' f�r zugeordneten Mitarbeiter:                " + zugeordneterMitarbeiter);
            System.out.println("Dr�cke '11' zum Erstellen");
            System.out.println("Dr�cke '0' um abzubrechen");

            Scanner s = new Scanner(System.in);

            /*
             * Die try-catch Klammer existiert f�r nicht erw�nschte Eingaben wie
             * Zeichen, wo Zahlen erwartet werden.
             */
            try {
                �nderung = s.nextInt();

                // Abbruch
                if (�nderung == 0) {
                    System.out.println("-------------------------------Erstellvorgang wurde abgebrochen!-------------------------------\n");
                    erstellVorgang = false;
                }

                // Wohnngsnnummer
                if (�nderung == 1) {
                    int eingabe = einlesen_Zahl(kategorie, �nderung);
                    if (eingabe == 0) {
                    } else {

                        int vorhanden = 0;
                        /*
                         * F�r jedes Element in der Wohnungsliste wird geguckt, ob die eingegebende ID mit
                         * einer bereits existierenden �bereinstimmt.
                         */
                        for (Wohnung flat : MenuManager.flatList) {
                            if (eingabe == flat.getWohnungsID()) {
                                vorhanden = 1;
                            }
                        }

                        /*
                         * Wenn die Variable 'vorhanden' = 1, dann existiert
                         * eine Wohnung mit dieser ID bereits. Sonst
                         * wird die eingegebene ID die ID der Wohnung.
                         */
                        if (vorhanden == 1) {
                            System.out.println("\n------------------------------- Fehler! ------------------------------- \n Wohnungs-ID bereits vergeben!\n");
                        } else {
                            wohnungsnummer = eingabe;
                        }
                    }
                }

                // Zimmeranzahl
                if (�nderung == 2) {
                    int eingabe = einlesen_Zahl(kategorie, �nderung);
                    if (eingabe == 0) {
                    } else {
                        zimmeranzahl = eingabe;
                    }
                }

                // Fl�che
                if (�nderung == 3) {
                    double eingabe = double_eingabe(kategorie, �nderung);
                    if (eingabe == 0) {
                    } else {
                        fl�che = eingabe;
                    }
                }

                // Kosten
                if (�nderung == 4) {
                    double eingabe = double_eingabe(kategorie, �nderung);
                    if (eingabe == 0) {
                    } else {
                        kosten = eingabe;
                    }
                }

                // Etage
                if (�nderung == 5) {
                    int eingabe = einlesen_Zahl(kategorie, �nderung);
                    if (eingabe == 0) {
                    } else {
                        etage = eingabe;
                    }
                }

                // Balkon
                if (�nderung == 6) {
                    System.out.println("Balkonauswahl: Geben Sie die Zahl ein: '1' = JA, '2' = NEIN, '0' = Abbruch!");
                    int eingabe = einlesen_Zahl(kategorie, �nderung);

                    if (eingabe == 1) {
                        balkon = true;
                    }
                    if (eingabe == 2) {
                        balkon = false;
                    }

                    if (eingabe == 0) {
                    }

                    // Jede andere Eingabe f�hrt zu einer Fehlermeldung.
                    if (eingabe > 2) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit nicht vorhanden!\n");
                    }
                }

                // Fu�bodenheizung
                if (�nderung == 7) {
                    System.out.println("Fu�bodenheizungsauswahl: Geben Sie die Zahl ein: '1' = JA, '2' = NEIN, '0' = Abbruch!");
                    int eingabe = einlesen_Zahl(kategorie, �nderung);

                    if (eingabe == 1) {
                        fu�bodenheizung = true;
                    }
                    if (eingabe == 2) {
                        fu�bodenheizung = false;
                    }

                    if (eingabe == 0) {
                    }

                    // Jede andere Eingabe f�hrt zu einer Fehlermeldung.
                    if (eingabe > 2) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit nicht vorhanden!\n");
                    }
                }

                // Aussicht
                if (�nderung == 8) {
                    Scanner q = new Scanner(System.in);
                    System.out.println("W�heln Sie ihre Wunschaussicht: '1' Park, '2' Spree, '3' Schienen, '4' Stra�e");

                    try {
                        int eingabe = q.nextInt();
                        if (eingabe == 0) {
                        } else {

                            if (eingabe == 1) {
                                aussicht = "Park";
                            }
                            if (eingabe == 2) {
                                aussicht = "Spree";
                            }
                            if (eingabe == 3) {
                                aussicht = "Schienen";
                            }
                            if (eingabe == 4) {
                                aussicht = "Stra�e";
                            }
                            if (eingabe > 4) {
                                System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit nicht vorhanden!\n");
                            }

                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
                    }
                }
                // Adresse
                if (�nderung == 9) {

                    String[] auswahl = { "Stra�e", "Hausnummer", "Platz", "Stadt" };

                    int z�hler = 1;
                    String stra�e = einlesen_Wort(auswahl, z�hler);

                    z�hler = 2;
                    int hausnummer = einlesen_Zahl(auswahl, z�hler);

                    z�hler = 3;
                    int platz = einlesen_Zahl(auswahl, z�hler);

                    z�hler = 4;
                    String stadt = einlesen_Wort(auswahl, z�hler);

                    if (stra�e.equals("" + 0) || hausnummer == 0 || platz == 0 || stadt.equals("" + 0) || hausnummer == -100 || platz == -100) {
                    } else {
                        adresse = new Adresse(stra�e, hausnummer, platz, stadt);
                    }
                }

                // zugeordneter Mitarbeiter
                if (�nderung == 10) {
                    auswahl_VertragsID_Wohnung_MitarbeiterID(�nderung);
                    int mitarbeiterID = WohnungErstellenAction.JFrame_mitarbeiterID_auswahl;
                    String name = "";
                    String vorname = "";

                    for (Mitarbeiter worker : MenuManager.workerList) {
                        if (worker.getMitarbeiterID() == mitarbeiterID) {
                            name = worker.getName();
                            vorname = worker.getVorname();
                        }
                    }

                    zugeordneterMitarbeiter = new Mitarbeiter(mitarbeiterID, name, vorname);
                }

                // Erstellen abschlie�en
                if (�nderung == 11) {
                    erstellVorgang = false;

                    MenuManager.currentManager.add(new Wohnung(wohnungsnummer, zimmeranzahl, fl�che, kosten, etage, balkon, fu�bodenheizung, aussicht, adresse, status, letztesRenovierungsdatum, renovierungsanzahl, letzeRenovierung_Details, handwerkerauftrag, zugeordneterMitarbeiter));
                }

                // Eingabe > 11
                if (�nderung > 11) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit nicht vorhanden!\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
            }
        }
    }

    /**
     * Methode zur Auswahl eines bereits existierend Attributs durch Vorschlag jedes einzelnen Elements in einer ArrayList
     *
     * @param �nderung
     *            = Z�hler des Attributs -> Bestimmung, welcher Fall eintritt (ob eine Wohnung, etc. bearbeitet wird)
     */
    private void auswahl_VertragsID_Wohnung_MitarbeiterID(final int �nderung) {
        WohnungErstellenAction.window = false;
        WohnungErstellenAction.JFrame_mitarbeiterID_auswahl = -100;
        JFrame meinRahmen = new JFrame();

        meinRahmen.setSize(250, 250);
        JPanel meinPanel = new JPanel();
        meinRahmen.setLocationRelativeTo(null);

        JComboBox combo2 = new JComboBox();

        if (�nderung == 10) {
            meinRahmen.setTitle("Mitarbeiter-ID");
            JLabel frage = new JLabel("Welchen Mitarbeiter (ID) m�chten Sie ausw�hlen?");
            meinPanel.add(frage);
            for (Mitarbeiter worker : MenuManager.workerList) {
                combo2.addItem(worker.getMitarbeiterID());
            }
        }

        meinRahmen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                WohnungErstellenAction.window = true;
            }
        });

        ActionListener cbActionListener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (�nderung == 10) {
                    WohnungErstellenAction.JFrame_mitarbeiterID_auswahl = (int) combo2.getSelectedItem();
                }

            }
        };
        meinPanel.add(combo2);
        meinRahmen.add(meinPanel, BorderLayout.SOUTH);
        meinRahmen.pack();
        meinRahmen.setVisible(true);
        while (WohnungErstellenAction.window == false) {
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
}