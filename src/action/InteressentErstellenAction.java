package action;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

import hilfsklassen.Adresse;
import hilfsklassen.Datum;
import menu.MenuManager;
import objekte.Interessent;

public class InteressentErstellenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ Interessent erstellen ________________________________________");

        boolean erstellVorgang = true;

        int interessentenID = -100;
        String name = "-";
        String vorname = "-";
        Datum geburtsdatum = null;
        String EMail = "-";
        Adresse adresse = null;
        String telefonnummer = "-";
        String status = "Interessent";
        String[] kategorie = { "Interessenten ID", "Name", "Vorname", "Geburtsdatum", "E-Mail", "Adresse", "Telefonnummer" };

        /*
         * Solange der Erstellvorgang nicht beendet ist, wird immer eine
         * Übersicht über den erstellten Wert ausgegeben. Es wird pro Durchlauf
         * immer 1 Attribut ausgewählt, welches man draufhin verändern kann.
         */
        while (erstellVorgang == true) {

            System.out.println("...............................Wählen Sie die zu erstellende Eigenschaft aus...............................!");
            System.out.println("1. Interessenten ID:      " + interessentenID);
            System.out.println("2. Name:                  " + name);
            System.out.println("3. Vorname:               " + vorname);
            System.out.println("4. Geburtsdatum:          " + geburtsdatum);
            System.out.println("5. E-Mail:                " + EMail);
            System.out.println("6. Adresse:               " + adresse);
            System.out.println("7. Telefon:               " + telefonnummer);
            System.out.println("8. Erstellen abschließen");
            System.out.println("0. Abbruch");
            System.out.println("");

            Scanner t = new Scanner(System.in);

            /*
             * Die try-catch Klammer existiert für nicht erwünschte Eingaben wie
             * Zeichen, wo Zahlen erwartet werden.
             */
            try {
                /*
                 * Variable zur Auswahl des zu bearbeitenden Attributs
                 */
                int änderung = t.nextInt();

                // Abbruch
                if (änderung == 0) {
                    System.out.println("-------------------------------Erstellvorgang wurde abgebrochen!-------------------------------\n");
                    erstellVorgang = false;
                }

                // Interessenten-ID
                if (änderung == 1) {

                    int neueID = einlesen_Zahl(kategorie, änderung);
                    if (neueID == 0) {
                        neueID = interessentenID;
                    } else {

                        int vorhanden = 0;
                        /*
                         * Für jedes Element in der Interessentenliste wird
                         * geguckt, ob die eingegebende ID mit einer bereits
                         * existierenden übereinstimmt.
                         */
                        for (Interessent interest : MenuManager.getInterestList()) {
                            if (neueID == interest.getKundenID()) {
                                vorhanden = 1;
                            }
                        }

                        /*
                         * Für jedes Element in der Liste der ehemaligen Interessenten wird
                         * geguckt, ob die eingegebende ID mit einer bereits
                         * existierenden übereinstimmt.
                         */
                        for (Interessent ehemaligerInteressent : MenuManager.ehemaligeInteressenten) {
                            if (neueID == ehemaligerInteressent.getKundenID()) {
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
                            interessentenID = neueID;
                        }
                    }
                }

                // Name
                if (änderung == 2) {
                    String neuerName = einlesen_Wort(kategorie, änderung);
                    // wenn eine 0 eingegeben wurde, dann wird der alte Wert
                    // behalten
                    if (neuerName.equals("" + 0)) {
                        neuerName = name;
                    } else {
                        name = neuerName;
                    }
                }

                // Vorname
                if (änderung == 3) {
                    String neuerVorname = einlesen_Wort(kategorie, änderung);
                    // wenn eine 0 eingegeben wurde, dann wird der alte Wert
                    // behalten
                    if (neuerVorname.equals("" + 0)) {
                        neuerVorname = vorname;
                    } else {
                        vorname = neuerVorname;
                    }
                }

                // Geburtsdatum
                if (änderung == 4) {

                    geburtsdatum = Datum_Eingabe(geburtsdatum);

                }

                // E-Mail
                if (änderung == 5) {
                    String neueEMail = einlesen_Wort(kategorie, änderung);
                    // wenn eine 0 eingegeben wurde, dann wird der alte Wert
                    // behalten
                    if (neueEMail.equals("" + 0)) {
                        neueEMail = EMail;
                    } else {
                        EMail = neueEMail;
                    }
                }

                // Adresse
                if (änderung == 6) {
                    String[] auswahl = { "Straße", "Hausnummer", "Platz", "Stadt" };

                    int zähler = 1;
                    String straße = einlesen_Wort(auswahl, zähler);
                    zähler = 2;
                    int hausnummer = einlesen_Zahl(auswahl, zähler);
                    zähler = 3;
                    int platz = einlesen_Zahl(auswahl, zähler);
                    zähler = 4;
                    String stadt = einlesen_Wort(auswahl, zähler);

                    // wenn eine 0 oder eine falsche Eingabe erfolgt, dann wird
                    // die Eingabe nicht angenommen
                    if (straße.equals("" + 0) || hausnummer == 0 || platz == 0 || stadt.equals("" + 0) || hausnummer == -100 || platz == -100) {
                    } else {
                        adresse = new Adresse(straße, hausnummer, platz, stadt);
                    }
                }

                // Telefonnummer
                if (änderung == 7) {
                    String neueTelefonnummer = einlesen_Wort(kategorie, änderung);
                    // wenn eine 0 eingegeben wurde, dann wird der alte Wert
                    // behalten
                    if (neueTelefonnummer.equals("" + 0)) {
                        neueTelefonnummer = telefonnummer;
                    } else {
                        telefonnummer = neueTelefonnummer;
                    }
                }

                // Erstellen abschließen
                if (änderung == 8) {
                    System.out.println("Interessent wurde erfolgreich angelegt!");
                    erstellVorgang = false;

                    // Interessent wird zur Interessentenliste hinzugefügt
                    MenuManager.currentManager.add(new Interessent(interessentenID, name, vorname, geburtsdatum, adresse, EMail, telefonnummer, status));

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

    private String einlesen_Wort(final String[] auswahl, final int zähler) {
        System.out.println("Erstellen: " + auswahl[zähler - 1]);
        Scanner s = new Scanner(System.in);
        String wort = s.nextLine();
        return wort;
    }
}