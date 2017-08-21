package mietverwaltung.action;

import java.util.InputMismatchException;
import java.util.Scanner;

import mietverwaltung.Mietvertrag;
import mietverwaltung.menu.MenuManager;

public class MietvertragSuchenAction extends MenuManager implements Action {

    @Override
    public void action() {

        System.out.println("________________________________________ Mietvertrag suchen ________________________________________");

        boolean suchVorgang = true;

        String mietvertragID = "-";
        String such_mietvertragID = mietvertragID;

        int wohnungsID = -100;
        int such_wohnungsID = wohnungsID;

        int kundenID = -100;
        int such_kundenID = kundenID;

        int mitarbeiterID = -100;
        int such_mitarbeiterID = mitarbeiterID;

        int such_beginnTag = -100;

        int beginnMonat = -100;
        int such_beginnMonat = beginnMonat;

        int beginnJahr = -100;
        int such_beginnJahr = beginnJahr;

        int such_endeTag = -100;

        int endeMonat = -100;
        int such_endeMonat = endeMonat;

        int endeJahr = 100;
        int such_endeJahr = endeJahr;

        String[] kategorie = { "Mietvertrag-ID", "Wohnungs-ID", "Kunden-ID", "Mitarbeiter-ID", "Mietbeginn", "Mietende" };

        String check = "";

        while (suchVorgang == true) {

            Scanner s = new Scanner(System.in);
            System.out.println("............................... Wählen Sie die zu suchende Eigenschaft aus! ...............................");

            System.out.println("........... Aktuelle Suche nach: ...........");

            System.out.println("1. Mievertrag-ID:                 " + such_mietvertragID);
            if (such_wohnungsID != -100) {
                System.out.println("2. Wohnungs-ID:                  " + such_wohnungsID);
            } else {
                System.out.println("2. Wohnungs-ID:                 " + "-");
            }
            if (such_kundenID != -100) {
                System.out.println("3. Kunden-ID:                      " + such_kundenID);
            } else {
                System.out.println("3. Kunden-ID");
            }
            if (such_mitarbeiterID != -100) {
                System.out.println("4. Mitarbeiter-ID:                   " + such_mitarbeiterID);
            } else {
                System.out.println("4. Mitarbeiter-ID:                   " + "-");
            }
            System.out.print("5. Mietbeginn:        ");

            if (such_beginnTag != -100) {
                System.out.print(such_beginnTag);
            } else {
                System.out.print("--.");
            }
            if (such_beginnMonat != -100) {
                System.out.print(such_beginnMonat);
            } else {
                System.out.print("--.");
            }
            if (such_beginnJahr != -100) {
                System.out.println(such_beginnJahr);
            } else {
                System.out.println("----");
            }

            System.out.print("6. Mietende: ");
            if (such_endeTag != -100) {
                System.out.println(such_endeTag);
            } else {
                System.out.print("--.");
            }
            if (such_endeMonat != -100) {
                System.out.print(such_endeMonat);
            } else {
                System.out.print("--.");
            }
            if (such_endeJahr != -100) {
                System.out.println(such_endeJahr);
            } else {
                System.out.println("----");
            }
            System.out.println("");

            try {
                int eingabe = s.nextInt();

                if (eingabe == 0) {
                    suchVorgang = false;
                }
                if (eingabe == 1) {
                    try {
                        such_mietvertragID = einlesen_Wort(kategorie, eingabe);
                        if (such_mietvertragID.equals("" + 0)) {
                            such_mietvertragID = mietvertragID;
                        } else {
                            check = check + "a";
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
                    }
                }
                if (eingabe == 2) {
                    such_wohnungsID = einlesen_Zahl(kategorie, eingabe);
                    if (such_wohnungsID == 0) {
                        such_wohnungsID = wohnungsID;
                    } else {
                        check = check + "b";
                    }
                }
                if (eingabe == 3) {
                    such_kundenID = einlesen_Zahl(kategorie, eingabe);
                    if (such_kundenID == 0) {
                        such_kundenID = kundenID;
                    } else {
                        check = check + "c";
                    }
                }
                if (eingabe == 4) {

                    try {
                        such_mitarbeiterID = einlesen_Zahl(kategorie, eingabe);
                        if (such_mitarbeiterID == 0) {
                            such_mitarbeiterID = mitarbeiterID;
                        } else {
                            check = check + "d";
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
                    }
                }
                if (eingabe == 5) {
                    System.out.println("Spezialisierung des zu suchenden Mietbeginns: ");
                    System.out.println("Drücke '1' für Monat: ");
                    System.out.println("Drücke '2' für Jahr: ");
                    System.out.println("Drücke '3' für Bestätigen: ");
                    System.out.println("Drücke '4' für Abbruch: ");

                    String[] auswahl = { "Monat", "Jahr" };
                    boolean datumseingabe = true;
                    String saveCheck = check;

                    while (datumseingabe == true) {

                        Scanner q = new Scanner(System.in);
                        int zähler = q.nextInt();

                        if (zähler == 1) {
                            such_beginnMonat = einlesen_Zahl(auswahl, zähler);
                            if (such_beginnMonat == 0) {
                                such_beginnMonat = beginnMonat;
                            } else {
                                saveCheck = saveCheck + "e";
                            }
                        }
                        if (zähler == 2) {
                            such_beginnJahr = einlesen_Zahl(auswahl, zähler);
                            if (such_beginnJahr == 0) {
                                such_beginnJahr = beginnJahr;
                            } else {
                                saveCheck = saveCheck + "f";
                            }
                        }
                        if (zähler == 3) {
                            datumseingabe = false;
                            check = check + saveCheck;
                        }
                        if (zähler == 4) {
                            datumseingabe = false;
                        }
                    }
                }
                if (eingabe == 6) {
                    System.out.println("Spezialisierung des zu suchenden Mietendes: ");
                    System.out.println("Drücke '1' für Monat: ");
                    System.out.println("Drücke '2' für Jahr: ");
                    System.out.println("Drücke '3' für Bestätigen: ");
                    System.out.println("Drücke '4' für Abbruch: ");

                    String[] auswahl = { "Monat", "Jahr" };
                    boolean datumseingabe = true;
                    String saveCheck = check;

                    while (datumseingabe == true) {

                        Scanner q = new Scanner(System.in);
                        int zähler = q.nextInt();

                        if (zähler == 1) {
                            such_beginnMonat = einlesen_Zahl(auswahl, zähler);
                            if (such_endeMonat == 0) {
                                such_endeMonat = endeMonat;
                            } else {
                                saveCheck = saveCheck + "g";
                            }
                        }
                        if (zähler == 2) {
                            such_endeJahr = einlesen_Zahl(auswahl, zähler);
                            if (such_endeJahr == 0) {
                                such_endeJahr = endeJahr;
                            } else {
                                saveCheck = saveCheck + "h";
                            }
                        }
                        if (zähler == 3) {
                            datumseingabe = false;
                            check = check + saveCheck;
                        }
                        if (zähler == 4) {
                            datumseingabe = false;
                        }
                    }
                }
                if (eingabe == 7) {
                    suchVorgang = false;

                    String vgl_mietvertragID = "-";
                    int vgl_wohnungsID = -100;
                    int vgl_kundenID = -100;
                    int vgl_mitarbeiterID = -100;
                    int vgl_beginnMonat = -100;
                    int vgl_beginnJahr = -100;
                    int vgl_endeMonat = -100;
                    int vgl_endeJahr = -100;

                    for (Mietvertrag contract : MenuManager.currentManager.getContractList()) {

                        if (check.contains("a")) {
                            vgl_mietvertragID = contract.getMietvertragID();
                        }
                        if (check.contains("b")) {
                            vgl_wohnungsID = contract.getWohnungsID();
                        }
                        if (check.contains("c")) {
                            vgl_kundenID = contract.getKundenID();
                        }
                        if (check.contains("d")) {
                            vgl_mitarbeiterID = contract.getMitarbeiterID();
                        }
                        if (check.contains("e")) {
                            vgl_beginnMonat = contract.getMietbeginn().getMonat();
                        }
                        if (check.contains("f")) {
                            vgl_beginnJahr = contract.getMietbeginn().getJahr();
                        }
                        if (check.contains("g")) {
                            vgl_endeMonat = contract.getMietende().getMonat();
                        }
                        if (check.contains("h")) {
                            vgl_endeJahr = contract.getMietende().getJahr();
                        }

                        if (vgl_mietvertragID.equals(such_mietvertragID) && vgl_wohnungsID == such_wohnungsID && vgl_kundenID == such_kundenID && vgl_mitarbeiterID == such_mitarbeiterID && vgl_beginnMonat == such_beginnMonat && vgl_beginnJahr == such_beginnJahr && vgl_endeMonat == such_endeMonat && vgl_endeJahr == such_endeJahr) {
                            System.out.println("Mietvertrag-ID:       " + contract.getMietvertragID());
                            System.out.println("Wohnungs-ID:          " + contract.getWohnungsID());
                            System.out.println("Kunden-ID:            " + contract.getKundenID());
                            System.out.println("Mitarbeiter-ID:       " + contract.getMitarbeiterID());
                            System.out.println("Mietbeginn:           " + contract.getMietbeginn());
                            System.out.println("Mietende:             " + contract.getMietende());
                            System.out.println("");
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
            }
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
}
