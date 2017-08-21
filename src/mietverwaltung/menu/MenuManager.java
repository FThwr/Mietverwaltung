package mietverwaltung.menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import mietverwaltung.Handwerkerauftrag;
import mietverwaltung.Interessent;
import mietverwaltung.Mieter;
import mietverwaltung.Mietvertrag;
import mietverwaltung.Mitarbeiter;
import mietverwaltung.Wohnung;
import mietverwaltung.action.HandwerkerauftragAnzeigenAction;
import mietverwaltung.action.HandwerkerauftragBearbeitenAction;
import mietverwaltung.action.HandwerkerauftragErstellenAction;
import mietverwaltung.action.HandwerkerauftragSuchenAction;
import mietverwaltung.action.InteressentAnzeigenAction;
import mietverwaltung.action.InteressentBearbeitenAction;
import mietverwaltung.action.InteressentErstellenAction;
import mietverwaltung.action.InteressentSuchenAction;
import mietverwaltung.action.MieterAnzeigenAction;
import mietverwaltung.action.MieterBearbeitenAction;
import mietverwaltung.action.MieterErstellenAction;
import mietverwaltung.action.MieterSuchenAction;
import mietverwaltung.action.MietvertragAnzeigenAction;
import mietverwaltung.action.MietvertragBearbeitenAction;
import mietverwaltung.action.MietvertragErstellenAction;
import mietverwaltung.action.MietvertragSuchenAction;
import mietverwaltung.action.MitarbeiterAnzeigenAction;
import mietverwaltung.action.MitarbeiterBearbeitenAction;
import mietverwaltung.action.MitarbeiterErstellenAction;
import mietverwaltung.action.WohnungAnzeigenAction;
import mietverwaltung.action.WohnungBearbeitenAction;
import mietverwaltung.action.WohnungErstellenAction;
import mietverwaltung.action.WohnungSuchenAction;

public class MenuManager extends Panel implements Serializable {

    private static final long serialVersionUID = 5699492648153643863L;

    protected static ArrayList<MenuEntry> menuList = new ArrayList<>();

    static {
        MenuManager.menuList.add(new MenuEntry("", new String[] { "Kunde", "Wohnung", "Mitarbeiter", "Handwerkerauftrag", "Mietvertrag", "Suche" }));
        MenuManager.menuList.add(new MenuEntry("Kunde", new String[] { "Mieter", "Interessent" }));
        MenuManager.menuList.add(new MenuEntry("Wohnung", new String[] { "Wohnung anzeigen", "neue Wohnung erstellen", "Wohnung bearbeiten", "Handwerkeraufträge", "Wohnung suchen" }));
        MenuManager.menuList.add(new MenuEntry("Mitarbeiter", new String[] { "Mitarbeiter anzeigen", "neuen Mitarbeiter erstellen", "Mitarbeiter bearbeiten" }));
        MenuManager.menuList.add(new MenuEntry("Mietvertrag", new String[] { "Mietvertrag anzeigen", "Mietvertrag erstellen", "Mietvertrag bearbeiten", "Mietvertrag suchen" }));

        MenuManager.menuList.add(new MenuEntry("Handwerkerauftrag", new String[] { "Handwerkerauftrag anzeigen", "Handwerkerauftrag erstellen", "Handwerkerauftrag bearbeiten", "Handwerkerauftrag suchen" }));

        MenuManager.menuList.add(new MenuEntry("Mieter", new String[] { "Mieter anzeigen", "neuen Mieter erstellen", "Mieter bearbeiten", "Mieter suchen" }));
        MenuManager.menuList.add(new MenuEntry("Interessent", new String[] { "Interessenten anzeigen", "neuen Interessenten erstellen", "Interessent bearbeiten", "Interessenten suchen" }));

        MenuManager.menuList.add(new MenuEntry("Wohnung suchen", new WohnungSuchenAction()));
        MenuManager.menuList.add(new MenuEntry("Wohnung anzeigen", new WohnungAnzeigenAction()));
        MenuManager.menuList.add(new MenuEntry("neue Wohnung erstellen", new WohnungErstellenAction()));
        MenuManager.menuList.add(new MenuEntry("Wohnung bearbeiten", new WohnungBearbeitenAction()));
        MenuManager.menuList.add(new MenuEntry("Mieter anzeigen", new MieterAnzeigenAction()));
        MenuManager.menuList.add(new MenuEntry("Mieter bearbeiten", new MieterBearbeitenAction()));
        MenuManager.menuList.add(new MenuEntry("neuen Mieter erstellen", new MieterErstellenAction()));
        MenuManager.menuList.add(new MenuEntry("Mieter suchen", new MieterSuchenAction()));
        MenuManager.menuList.add(new MenuEntry("Interessenten anzeigen", new InteressentAnzeigenAction()));
        MenuManager.menuList.add(new MenuEntry("Interessent bearbeiten", new InteressentBearbeitenAction()));
        MenuManager.menuList.add(new MenuEntry("neuen Interessenten erstellen", new InteressentErstellenAction()));
        MenuManager.menuList.add(new MenuEntry("Interessenten suchen", new InteressentSuchenAction()));
        MenuManager.menuList.add(new MenuEntry("Mitarbeiter anzeigen", new MitarbeiterAnzeigenAction()));
        MenuManager.menuList.add(new MenuEntry("neuen Mitarbeiter erstellen", new MitarbeiterErstellenAction()));
        MenuManager.menuList.add(new MenuEntry("Mitarbeiter bearbeiten", new MitarbeiterBearbeitenAction()));
        MenuManager.menuList.add(new MenuEntry("Handwerkerauftrag suchen", new HandwerkerauftragSuchenAction()));
        MenuManager.menuList.add(new MenuEntry("Handwerkerauftrag anzeigen", new HandwerkerauftragAnzeigenAction()));
        MenuManager.menuList.add(new MenuEntry("Handwerkerauftrag erstellen", new HandwerkerauftragErstellenAction()));
        MenuManager.menuList.add(new MenuEntry("Handwerkerauftrag bearbeiten", new HandwerkerauftragBearbeitenAction()));
        MenuManager.menuList.add(new MenuEntry("Mietvertrag suchen", new MietvertragSuchenAction()));
        MenuManager.menuList.add(new MenuEntry("Mietvertrag anzeigen", new MietvertragAnzeigenAction()));
        MenuManager.menuList.add(new MenuEntry("Mietvertrag erstellen", new MietvertragErstellenAction()));
        MenuManager.menuList.add(new MenuEntry("Mietvertrag bearbeiten", new MietvertragBearbeitenAction()));
    }

    protected ArrayList<Mitarbeiter> workerList = new ArrayList<>();
    protected ArrayList<Wohnung> flatList = new ArrayList<>();
    protected ArrayList<Mieter> ownerList = new ArrayList<>();
    protected ArrayList<Interessent> interestList = new ArrayList<>();
    protected ArrayList<Handwerkerauftrag> repairList = new ArrayList<>();
    protected ArrayList<Mietvertrag> contractList = new ArrayList<>();

    public void add(final Mietvertrag mietvertrag) {
        this.contractList.add(mietvertrag);
    }

    public void add(final Handwerkerauftrag handwerkerauftrag) {
        this.repairList.add(handwerkerauftrag);
    }

    public void add(final Mieter mieter) {
        this.ownerList.add(mieter);
    }

    public void add(final Interessent interessent) {
        this.interestList.add(interessent);
    }

    public void add(final Mitarbeiter mitarbeiter) {
        this.workerList.add(mitarbeiter);
    }

    public void add(final Wohnung wohnung) {
        this.flatList.add(wohnung);
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
        for (Mitarbeiter ma : this.workerList) {
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
        for (Mitarbeiter ma : this.workerList) {
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
