package mietverwaltung.menu;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import mietverwaltung.Handwerkerauftrag;
import mietverwaltung.Interessent;
import mietverwaltung.Mieter;
import mietverwaltung.Mietvertrag;
import mietverwaltung.Mitarbeiter;
import mietverwaltung.Wohnung;

public class MenuManager extends Panel {

    protected static ArrayList<MenuEntry> menuList = new ArrayList<>();
    protected static ArrayList<Mitarbeiter> workerList = new ArrayList<>();
    protected static ArrayList<Wohnung> flatList = new ArrayList<>();
    protected static ArrayList<Mieter> ownerList = new ArrayList<>();
    protected static ArrayList<Interessent> interestList = new ArrayList<>();
    protected static ArrayList<Handwerkerauftrag> repairList = new ArrayList<>();
    protected static ArrayList<Mietvertrag> contractList = new ArrayList<>();

    public void add(final MenuEntry menueEintrag) {
        MenuManager.menuList.add(menueEintrag);
    }

    public void add(final Mietvertrag mietvertrag) {
        MenuManager.contractList.add(mietvertrag);
    }

    public void add(final Handwerkerauftrag handwerkerauftrag) {
        MenuManager.repairList.add(handwerkerauftrag);
    }

    public void add(final Mieter mieter) {
        MenuManager.ownerList.add(mieter);
    }

    public void add(final Interessent interessent) {
        MenuManager.interestList.add(interessent);
    }

    public void add(final Mitarbeiter mitarbeiter) {
        MenuManager.workerList.add(mitarbeiter);
    }

    public void add(final Wohnung wohnung) {
        MenuManager.flatList.add(wohnung);
    }

    public void start() {
        //		String anmeldung = " ";
        //		boolean passwortÜbereinstimmung = false;
        //
        //		while (passwortÜbereinstimmung == false) {
        //			anmeldung = anmelden();
        //			boolean passwort = passwortExistens(anmeldung);
        //
        //			if (passwort == false) {
        //				System.out.println("Anmeldung nicht erfolgreich!\n");
        //			} else {
        //				passwortÜbereinstimmung = true;
        //			}
        //		}
        //		personHerausfinden(anmeldung);

        System.out.println("\nBei Eingabe von \"0\" kehren Sie zum vorherigen Menü zurück. \nBei \"-1\" wird das Programm beendet.");
        MenuEntry meAktuell = ersterEintrag();
        try {
            meAktuell = aufruf(meAktuell);

        } catch (NullPointerException ex) {
            System.out.println("keine Aktion hinterlegt, weil kein Menüeintrag erstellt wurde");
            actionAusfuehren(meAktuell);
            meAktuell = aufruf(meAktuell);
        }
    }

    private void personHerausfinden(final String anmeldung) {
        for (Mitarbeiter ma : MenuManager.workerList) {
            if (anmeldung.equals(ma.getPasswort())) {
                System.out.println("\nWillkommen bei der Mietverwaltung " + ma.getName() + "\n");
            }
        }
    }

    private String anmelden() {
        System.out.println("Anmeldungsvorgang");
        String anmeldung = JOptionPane.showInputDialog(null, "Bitte Passwort eingeben!");
        return anmeldung;
    }

    public boolean passwortExistens(final String anmeldung) {
        for (Mitarbeiter ma : MenuManager.workerList) {
            if (anmeldung.equals(ma.getPasswort())) {
                return true;
            }
        }
        return false;
    }

    public MenuEntry aufruf(MenuEntry meAktuell) {
        Scanner scanner = new Scanner(System.in);
        do {
            if (meAktuell.getName().equals("")) {
                System.out.println("________________________________________ Hauptmenü ________________________________________");
            } else {
                System.out.println("________________________________________ Obermenü: " + meAktuell.getName() + " ________________________________________");
            }
            System.out.println("                               Wählen Sie einen Menüpunkt aus:                                ");
            zaehleMenuePunkteAuf(meAktuell);

            int eingabe = eingabeEinlesen(scanner);
            System.out.println("");
            if (eingabe <= meAktuell.getLocation().length && eingabe > 0) {
                meAktuell = zeigeAufUntermenue(meAktuell, eingabe);
            } else if (eingabe == 0) {
                meAktuell = zeigeAufObermenue(meAktuell);
            } else if (eingabe == -1) {
                System.out.println("Programm wurde beendet.");
                System.exit(0);
            } else {
                System.out.println("------------------------------- Fehler, der ausgewählte Menüpunkt existiert nicht. -------------------------------");
            }
        } while (meAktuell.getLocation() != null);
        meAktuell = actionAusfuehren(meAktuell);
        meAktuell = aufruf(meAktuell);
        return meAktuell;
    }

    public MenuEntry actionAusfuehren(MenuEntry meAktuell) {
        if (meAktuell.getLocation() == null) {
            if (meAktuell.getAction() != null) {
                meAktuell.getAction().action();
            }
        }
        meAktuell = zeigeAufObermenue(meAktuell);
        return meAktuell;
    }

    public int eingabeEinlesen(final Scanner scanner) {
        int number = scanner.nextInt();
        return number;
    }

    public void zaehleMenuePunkteAuf(final MenuEntry me) {
        for (int i = 0; i < me.getLocation().length; i++) {
            String untermenueName = (me.getLocation())[i];
            System.out.println((i + 1) + ". " + untermenueName);

        }
        System.out.println("");
    }

    public MenuEntry zeigeAufObermenue(final MenuEntry meAktuell) {
        try {
            String nameObermenue = meAktuell.getName();
            for (MenuEntry meSuche : MenuManager.menuList) {
                String[] array = meSuche.getLocation();
                for (int i = 0; i < array.length; i++) {
                    if (nameObermenue.equals(array[i])) {
                        return meSuche;
                    }
                }
            }
            return null;
        } catch (NullPointerException ex) {
            return meAktuell;
        }
    }

    public MenuEntry zeigeAufUntermenue(final MenuEntry me, final int nummer) {
        String nameUntermenue = ((me.getLocation())[nummer - 1]);
        for (MenuEntry meSuche : MenuManager.menuList) {
            if ((meSuche.getName()).equals(nameUntermenue)) {
                return meSuche;
            }
        }
        return null;
    }

    public MenuEntry ersterEintrag() {
        for (MenuEntry me : MenuManager.menuList) {
            if (me.getName() == "") {
                return me;
            }
        }
        return null;
    }
}
