package menu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import action.AbgeschlosseneHandwerkeraufträgeAnzeigenAction;
import action.AbgeschlosseneMietverträgeAnzeigenAction;
import action.AktiveHandwerkeraufträgeAnzeigenAction;
import action.AktuelleInteressentenAnzeigenAction;
import action.AktuelleMieterAnzeigenAction;
import action.AktuelleMietverträgeAnzeigenAction;
import action.AktuelleMitarbeiterAnzeigenAction;
import action.EhemaligeInteressentenAnzeigenAction;
import action.EhemaligeMieterAnzeigenAction;
import action.EhemaligeMitarbeiterAnzeigenAction;
import action.HandwerkerauftragBearbeitenAction;
import action.HandwerkerauftragErstellenAction;
import action.HandwerkerauftragSuchenAction;
import action.InteressentBearbeitenAction;
import action.InteressentErstellenAction;
import action.InteressentSuchenAction;
import action.MieterBearbeitenAction;
import action.MieterSuchenAction;
import action.MietvertragBearbeitenAction;
import action.MietvertragErstellenAction;
import action.MietvertragSuchenAction;
import action.MitarbeiterBearbeitenAction;
import action.MitarbeiterErstellenAction;
import action.SuchanfrageWohnungSuchenAction;
import action.SuchanfragenAnzeigenAction;
import action.WohnungAnzeigenAction;
import action.WohnungBearbeitenAction;
import action.WohnungErstellenAction;
import action.WohnungSuchenAktion;
import hilfsklassen.Panel;
import objekte.Handwerkerauftrag;
import objekte.Interessent;
import objekte.Mieter;
import objekte.Mietvertrag;
import objekte.Mitarbeiter;
import objekte.Suchanfrage;
import objekte.Wohnung;

public class MenuManager extends Panel implements Serializable {

    private static final long serialVersionUID = -1283828418695494828L;

    private static MenuManager currentManager;

    private static ArrayList<MenuEntry> menuList = new ArrayList<>();
    static {
        //1. MenuEbene
        MenuManager.menuList.add(new MenuEntry("", new String[] { "Kunde", "Wohnung", "Mitarbeiter", "Handwerkerauftrag", "Mietvertrag", "Suchanfrage" }));
        MenuManager.menuList.add(new MenuEntry("Kunde", new String[] { "Interessent", "Mieter" }));

        MenuManager.menuList.add(new MenuEntry("Mieter", new String[] { "ehemalige Mieter anzeigen", "aktuelle Mieter anzeigen", "Mieter bearbeiten", "Mieter suchen" }));
        MenuManager.menuList.add(new MenuEntry("Interessent", new String[] { "ehemalige Interessenten anzeigen", "aktuelle Interessenten anzeigen", "neuen Interessenten erstellen", "Interessent bearbeiten", "Interessenten suchen" }));
        MenuManager.menuList.add(new MenuEntry("Wohnung", new String[] { "Wohnung anzeigen", "neue Wohnung erstellen", "Wohnung bearbeiten", "Wohnung suchen" }));
        MenuManager.menuList.add(new MenuEntry("Mitarbeiter", new String[] { "ehemalige Mitarbeiter anzeigen", "aktuelle Mitarbeiter anzeigen", "neuen Mitarbeiter erstellen", "Mitarbeiter bearbeiten" }));
        MenuManager.menuList.add(new MenuEntry("Mietvertrag", new String[] { "abgeschlossene MietvertrÃ¤ge anzeigen", "aktive Mietverträge anzeigen", "Mietvertrag erstellen", "Mietvertrag bearbeiten", "Mietvertrag suchen" }));
        MenuManager.menuList.add(new MenuEntry("Handwerkerauftrag", new String[] { "fertige HandwerkerauftrÃ¤ge anzeigen", "aktive HandwerkerauftrÃ¤ge anzeigen", "Handwerkerauftrag erstellen", "Handwerkerauftrag bearbeiten", "Handwerkerauftrag suchen" }));
        MenuManager.menuList.add(new MenuEntry("Suchanfrage", new String[] { "Suchanfrage erstellen", "Suchanfragen anzeigen" }));

        MenuManager.menuList.add(new MenuEntry("aktuelle Mieter anzeigen", new AktuelleMieterAnzeigenAction()));
        MenuManager.menuList.add(new MenuEntry("ehemalige Mieter anzeigen", new EhemaligeMieterAnzeigenAction()));

        MenuManager.menuList.add(new MenuEntry("Mieter bearbeiten", new MieterBearbeitenAction()));
        MenuManager.menuList.add(new MenuEntry("Mieter suchen", new MieterSuchenAction()));

        MenuManager.menuList.add(new MenuEntry("aktuelle Interessenten anzeigen", new AktuelleInteressentenAnzeigenAction()));
        MenuManager.menuList.add(new MenuEntry("ehemalige Interessenten anzeigen", new EhemaligeInteressentenAnzeigenAction()));

        MenuManager.menuList.add(new MenuEntry("Interessent bearbeiten", new InteressentBearbeitenAction()));
        MenuManager.menuList.add(new MenuEntry("neuen Interessenten erstellen", new InteressentErstellenAction()));
        MenuManager.menuList.add(new MenuEntry("Interessenten suchen", new InteressentSuchenAction()));

        MenuManager.menuList.add(new MenuEntry("Wohnung anzeigen", new WohnungAnzeigenAction()));
        MenuManager.menuList.add(new MenuEntry("neue Wohnung erstellen", new WohnungErstellenAction()));
        MenuManager.menuList.add(new MenuEntry("Wohnung bearbeiten", new WohnungBearbeitenAction()));
        MenuManager.menuList.add(new MenuEntry("Wohnung suchen", new WohnungSuchenAktion()));

        MenuManager.menuList.add(new MenuEntry("ehemalige Mitarbeiter anzeigen", new EhemaligeMitarbeiterAnzeigenAction()));
        MenuManager.menuList.add(new MenuEntry("aktuelle Mitarbeiter anzeigen", new AktuelleMitarbeiterAnzeigenAction()));
        MenuManager.menuList.add(new MenuEntry("neuen Mitarbeiter erstellen", new MitarbeiterErstellenAction()));
        MenuManager.menuList.add(new MenuEntry("Mitarbeiter bearbeiten", new MitarbeiterBearbeitenAction()));

        MenuManager.menuList.add(new MenuEntry("Mietvertrag suchen", new MietvertragSuchenAction()));
        MenuManager.menuList.add(new MenuEntry("abgeschlossene Mietverträge anzeigen", new AbgeschlosseneMietverträgeAnzeigenAction()));
        MenuManager.menuList.add(new MenuEntry("aktive Mietverträge anzeigen", new AktuelleMietverträgeAnzeigenAction()));
        MenuManager.menuList.add(new MenuEntry("Mietvertrag erstellen", new MietvertragErstellenAction()));
        MenuManager.menuList.add(new MenuEntry("Mietvertrag bearbeiten", new MietvertragBearbeitenAction()));

        MenuManager.menuList.add(new MenuEntry("Handwerkerauftrag suchen", new HandwerkerauftragSuchenAction()));
        MenuManager.menuList.add(new MenuEntry("fertige Handwerkeraufträge anzeigen", new AbgeschlosseneHandwerkeraufträgeAnzeigenAction()));
        MenuManager.menuList.add(new MenuEntry("aktive Handwerkeraufträge anzeigen", new AktiveHandwerkeraufträgeAnzeigenAction()));
        MenuManager.menuList.add(new MenuEntry("Handwerkerauftrag erstellen", new HandwerkerauftragErstellenAction()));
        MenuManager.menuList.add(new MenuEntry("Handwerkerauftrag bearbeiten", new HandwerkerauftragBearbeitenAction()));

        MenuManager.menuList.add(new MenuEntry("Suchanfrage erstellen", new SuchanfrageWohnungSuchenAction()));
        MenuManager.menuList.add(new MenuEntry("Suchanfragen anzeigen", new SuchanfragenAnzeigenAction()));

    }

    protected ArrayList<Mieter> ownerList = new ArrayList<>();
    protected ArrayList<Mitarbeiter> workerList = new ArrayList<>();
    protected ArrayList<Wohnung> flatList = new ArrayList<>();
    protected ArrayList<Handwerkerauftrag> repairList = new ArrayList<>();
    protected ArrayList<Interessent> InterestList = new ArrayList<>();
    protected ArrayList<Mietvertrag> contractList = new ArrayList<>();
    protected ArrayList<Suchanfrage> searchList = new ArrayList<>();

    protected ArrayList<Mieter> ehemaligeMieter = new ArrayList<>();
    protected ArrayList<Mietvertrag> beendeteMietverträge = new ArrayList<>();
    protected ArrayList<Handwerkerauftrag> abgeschlosseneHandwerkeraufträge = new ArrayList<>();
    protected ArrayList<Mitarbeiter> ehemaligeMitarbeiter = new ArrayList<>();
    protected ArrayList<Interessent> ehemaligeInteressenten = new ArrayList<>();

    private static final String dateiPfad = "..\\menumanager.dat";

    public static ArrayList<Interessent> getEhemaligeInteressenten() {
        return MenuManager.currentManager.ehemaligeInteressenten;
    }

    public static void setOwnerList(final ArrayList<Mieter> ownerList) {
        MenuManager.currentManager.ownerList = ownerList;
    }

    public static ArrayList<Handwerkerauftrag> getAbgeschlosseneHandwerkeraufträge() {
        return MenuManager.currentManager.abgeschlosseneHandwerkeraufträge;
    }

    public static void setAbgeschlosseneHandwerkerauftrÃ¤ge(final ArrayList<Handwerkerauftrag> abgeschlosseneHandwerkeraufträge) {
        MenuManager.currentManager.abgeschlosseneHandwerkeraufträge = abgeschlosseneHandwerkeraufträge;
    }

    public static ArrayList<Mietvertrag> getBeendeteMietverträge() {
        return MenuManager.currentManager.beendeteMietverträge;
    }

    public static void setBeendeteMietverträge(final ArrayList<Mietvertrag> beendeteMietverträge) {
        MenuManager.currentManager.beendeteMietverträge = beendeteMietverträge;
    }

    public MenuManager() {
        MenuManager.currentManager = this;
    }

    public static MenuManager getCurrentManager() {
        return MenuManager.currentManager;
    }

    public static void setCurrentManager(final MenuManager currentManager) {
        MenuManager.currentManager = currentManager;
    }

    public static ArrayList<MenuEntry> getMenuList() {
        return MenuManager.menuList;
    }

    public static void setMenuList(final ArrayList<MenuEntry> menuList) {
        MenuManager.menuList = menuList;
    }

    public static ArrayList<Mitarbeiter> getWorkerList() {
        return MenuManager.currentManager.workerList;
    }

    public static void setWorkerList(final ArrayList<Mitarbeiter> workerList) {
        MenuManager.currentManager.workerList = workerList;
    }

    public static ArrayList<Wohnung> getFlatList() {
        return MenuManager.currentManager.flatList;
    }

    public static void setFlatList(final ArrayList<Wohnung> flatList) {
        MenuManager.currentManager.flatList = flatList;
    }

    public static ArrayList<Interessent> getInterestList() {
        return MenuManager.currentManager.InterestList;
    }

    public static void setInterestList(final ArrayList<Interessent> interestList) {
        MenuManager.currentManager.InterestList = interestList;
    }

    public static ArrayList<Mietvertrag> getContractList() {
        return MenuManager.currentManager.contractList;
    }

    public static void setContractList(final ArrayList<Mietvertrag> contractList) {
        MenuManager.currentManager.contractList = contractList;
    }

    public static ArrayList<Mieter> getOwnerList() {
        return MenuManager.currentManager.ownerList;
    }

    public static void setEhemaligeInteressenten(final ArrayList<Interessent> ehemaligeInteressenten) {
        MenuManager.currentManager.ehemaligeInteressenten = ehemaligeInteressenten;
    }

    public static ArrayList<Mitarbeiter> getEhemaligeMitarbeiter() {
        return MenuManager.currentManager.ehemaligeMitarbeiter;
    }

    public static void setEhemaligeMitarbeiter(final ArrayList<Mitarbeiter> ehemaligeMitabrbeiter) {
        MenuManager.currentManager.ehemaligeMitarbeiter = ehemaligeMitabrbeiter;
    }

    public static void add(final Mitarbeiter mitarbeiter) {
        MenuManager.currentManager.workerList.add(mitarbeiter);
    }

    public static void add(final Mietvertrag mietvertrag) {
        MenuManager.currentManager.contractList.add(mietvertrag);
    }

    public static void add(final Wohnung wohnung) {
        MenuManager.currentManager.flatList.add(wohnung);
    }

    public static void add(final Interessent interessent) {
        MenuManager.currentManager.InterestList.add(interessent);
    }

    public static void add(final Mieter mieter) {
        MenuManager.currentManager.ownerList.add(mieter);
    }

    public static void add(final Suchanfrage suchanfrage) {
        MenuManager.currentManager.searchList.add(suchanfrage);
    }

    public static void add(final Handwerkerauftrag handwerkerauftrag) {
        MenuManager.currentManager.repairList.add(handwerkerauftrag);
    }

    public static void addEhemaligeMieter(final Mieter ehemaligeMieter) {
        MenuManager.currentManager.ehemaligeMieter.add(ehemaligeMieter);
    }

    public static void addBeendeteMietverträge(final Mietvertrag beendeterMietvertrag) {
        MenuManager.currentManager.beendeteMietverträge.add(beendeterMietvertrag);
    }

    public static void addEhemaligeMitarbeiter(final Mitarbeiter ehemaligeMitarbeiter) {
        MenuManager.currentManager.ehemaligeMitarbeiter.add(ehemaligeMitarbeiter);
    }

    public static void addAbgeschlosseneHandwerkeraufträge(final Handwerkerauftrag abgeschlossenerHandwerkerauftrag) {
        MenuManager.currentManager.abgeschlosseneHandwerkeraufträge.add(abgeschlossenerHandwerkerauftrag);
    }

    public void start() throws FileNotFoundException, ClassNotFoundException, IOException {
        String anmeldung = " ";
        boolean passwortÜbereinstimmung = false;

        while (passwortÜbereinstimmung == false) {
            anmeldung = anmelden();
            boolean passwort = passwortExistens(anmeldung);

            if (passwort == false) {
                System.out.println("Anmeldung nicht erfolgreich!\n");
            } else {
                passwortÜbereinstimmung = true;
            }
        }
        personHerausfinden(anmeldung);

        System.out.println("\nBei Eingabe von \"0\" kehren Sie zum vorherigen Menü zurück. \nBei \"-1\" wird das Programm gespeichert und beendet.");
        MenuEntry meAktuell = ersterEintrag();
        try {
            meAktuell = aufruf(meAktuell);

        } catch (NullPointerException | ClassNotFoundException | IOException ex) {
            System.out.println("keine Aktion hinterlegt, weil kein Menüeintrag erstellt wurde");
            actionAusfuehren(meAktuell);
            meAktuell = aufruf(meAktuell);
        }
    }

    private void personHerausfinden(final String anmeldung) {
        for (Mitarbeiter worker : MenuManager.currentManager.workerList) {
            if (anmeldung.equals(worker.getPasswort())) {
                System.out.println("\nWillkommen bei der Mietverwaltung: " + worker.getName() + ", " + worker.getVorname() + "\n");
            }
        }
    }

    private String anmelden() {
        System.out.println("Anmeldungsvorgang");
        String anmeldung = JOptionPane.showInputDialog(null, "Bitte Passwort eingeben!");
        if (anmeldung == null) {
            System.out.println("\nProgramm wird beendet!\n");
            System.exit(0);
        }
        return anmeldung;
    }

    public boolean passwortExistens(final String anmeldung) {
        for (Mitarbeiter ma : MenuManager.currentManager.workerList) {
            if (anmeldung.equals(ma.getPasswort())) {
                return true;
            }
        }
        return false;
    }

    public MenuEntry aufruf(MenuEntry meAktuell) throws FileNotFoundException, ClassNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(meAktuell.getName());
            zaehleMenuePunkteAuf(meAktuell);

            System.out.print("Wählen Sie einen Menüpunkt aus: ");
            int eingabe = eingabeEinlesen(scanner);
            System.out.println("");
            if (eingabe <= meAktuell.getLocation().length && eingabe > 0) {
                meAktuell = zeigeAufUntermenue(meAktuell, eingabe);
            } else if (eingabe == 0) {
                meAktuell = zeigeAufObermenue(meAktuell);
            } else if (eingabe == -1) {
                System.out.println("speichere...");
                MenuManager.speichern();
                System.out.println("Programm wurde beendet.");
                System.exit(0);
            } else {
                System.out.println("Fehler, der ausgewählte Menüpunkt existiert nicht.");
            }
        } while (meAktuell.getLocation() != null);
        meAktuell = actionAusfuehren(meAktuell);
        meAktuell = aufruf(meAktuell);
        return meAktuell;
    }

    public MenuEntry actionAusfuehren(MenuEntry meAktuell) throws FileNotFoundException, ClassNotFoundException, IOException {
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

    public static ArrayList<Mieter> getEhemaligeMieter() {
        return MenuManager.currentManager.ehemaligeMieter;
    }

    public static void setEhemaligeMieter(final ArrayList<Mieter> ehemaligeMieter) {
        MenuManager.currentManager.ehemaligeMieter = ehemaligeMieter;
    }

    public static ArrayList<Handwerkerauftrag> getRepairList() {
        return MenuManager.currentManager.repairList;
    }

    public static void setRepairList(final ArrayList<Handwerkerauftrag> repairList) {
        MenuManager.currentManager.repairList = repairList;
    }

    public static ArrayList<Suchanfrage> getSearchList() {
        return MenuManager.currentManager.searchList;
    }

    public static void setSearchList(final ArrayList<Suchanfrage> searchList) {
        MenuManager.currentManager.searchList = searchList;
    }

    public static void speichern() {
        File file = new File(MenuManager.dateiPfad);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(MenuManager.currentManager);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static MenuManager laden() throws FileNotFoundException, IOException {
        File file = new File(MenuManager.dateiPfad);
        try (FileInputStream fos = new FileInputStream(file)) {
            ObjectInputStream in = new ObjectInputStream(fos);
            MenuManager.currentManager = (MenuManager) in.readObject();
            return MenuManager.currentManager;
        } catch (ClassNotFoundException e) {
            System.err.println("Klasse nicht gefunden! " + e);
        }
        return null;
    }
}
