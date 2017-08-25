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

import hilfsklassen.Panel;
import mietverwaltung.Handwerkerauftrag;
import mietverwaltung.Interessent;
import mietverwaltung.Mieter;
import mietverwaltung.Mietvertrag;
import objekte.Mitarbeiter;
import objekte.Wohnung;

public class MenuManager extends Panel implements Serializable {

    private static final long serialVersionUID = -1283828418695494828L;

    protected static MenuManager currentManager;

    static {
        //1. Menueebene
        MenuManager.menuList.add(new MenuEntry("", new String[] { "Mieter", "Wohnung", "Handwerkerauftrag", "Mietvertrag", "Interessenten", "Suche" }));

        //  Sollte es auch einen Menueeintrag "loeschen" geben??? @AG
        //2. Menueebene
        MenuManager.menuList.add(new MenuEntry("Mieter", new String[] { "Mieter anzeigen", "neuen Mieter erstellen", "Mieter bearbeiten", "Mieter suchen" }));
        MenuManager.menuList.add(new MenuEntry("Wohnung", new String[] { "Wohnung anzeigen", "neue Wohnung erstellen", "Wohnung bearbeiten", "Handwerkerauftr�ge" }));
        MenuManager.menuList.add(new MenuEntry("Handwerkerauftrag", new String[] { "Handwerkerauftrag anzeigen", "neuen Handwerkerauftrag erstellen", "Handwerkerauftrag bearbeiten" }));
        MenuManager.menuList.add(new MenuEntry("Mietvertrag", new String[] { "Mietvertrag anzeigen", "neuen Mietvertrag erstellen", "Mietvertrag bearbeiten" }));
        MenuManager.menuList.add(new MenuEntry("Interessenten", new String[] { "Interessent anzeigen", "neuen Interessenten erstellen", "Interessent bearbeiten", "Suchauftrag" }));
        MenuManager.menuList.add(new MenuEntry("Suche", new String[] {}));

        //3. Menueebene
        //   MenuManager.menuList.add(new MenueEntry("Mieter anzeigen", new MieterAktion()));
        //   MenuManager.menuList.add(new MenueEntry("neuen Mieter erstellen", new MieterAktion()));
        //   MenuManager.menuList.add(new MenueEntry("Mieter bearbeiten", new MieterAktion()));
        //   MenuManager.menuList.add(new MenueEntry("Mieter suchen", new MieterAktion()));

        //Aktionen m�ssten noch erstellt werden @AG
        //   MenuManager.menuList.add(new MenueEntry("Wohnung anzeigen", action));
        //   MenuManager.menuList.add(new MenueEntry("neue Wohnung erstellen", action));
        //   MenuManager.menuList.add(new MenueEntry("Wohnung bearbeiten", action));
        //   MenuManager.menuList.add(new MenueEntry("Handwerkerauftr�ge", action));
        //
        //   MenuManager.menuList.add(new MenueEntry("Handwerkerauftrag anzeigen", action));
        //   MenuManager.menuList.add(new MenueEntry("neuen Handwerkerauftrag erstellen", action));
        //   MenuManager.menuList.add(new MenueEntry("Handwerkerauftrag bearbeiten", action));
        //
        //   MenuManager.menuList.add(new MenueEntry("Mietvertrag anzeigen", action));
        //   MenuManager.menuList.add(new MenueEntry("neuen Mietvertrag erstellen", action));
        //   MenuManager.menuList.add(new MenueEntry("Mietvertrag bearbeiten", action));
        //
        //   MenuManager.menuList.add(new MenueEntry("Interessent anzeigen", action));
        //   MenuManager.menuList.add(new MenueEntry("neuen Interessenten erstellen", action));
        //   MenuManager.menuListm.add(new MenueEntry("Interessent bearbeiten", action));
        //   MenuManager.menuList.add(new MenueEntry("Suchauftrag", action));
    }

    private static ArrayList<MenuEntry> menuList = new ArrayList<>();

    private static final String dateiPfad = "..\\menumanager.dat";

    public static ArrayList<Interessent> getEhemaligeInteressenten() {
        return MenuManager.ehemaligeInteressenten;
    }

    public static void setEhemaligeInteressenten(final ArrayList<Interessent> ehemaligeInteressenten) {
        MenuManager.ehemaligeInteressenten = ehemaligeInteressenten;
    }

    protected static ArrayList<Mitarbeiter> workerList = new ArrayList<>();
    protected static ArrayList<Wohnung> flatList = new ArrayList<>();
    protected static ArrayList<Mietvertrag> beendeteMietvertr�ge = new ArrayList<>();
    protected static ArrayList<Mieter> ehemaligeMieter = new ArrayList<>();
    protected static ArrayList<Interessent> ehemaligeInteressenten = new ArrayList<>();
    protected static ArrayList<Handwerkerauftrag> abgeschlosseneHandwerkerauftr�ge = new ArrayList<>();

    public static ArrayList<Handwerkerauftrag> getAbgeschlosseneHandwerkerauftr�ge() {
        return MenuManager.abgeschlosseneHandwerkerauftr�ge;
    }

    public static void setAbgeschlosseneHandwerkerauftr�ge(final ArrayList<Handwerkerauftrag> abgeschlosseneHandwerkerauftr�ge) {
        MenuManager.abgeschlosseneHandwerkerauftr�ge = abgeschlosseneHandwerkerauftr�ge;
    }

    public static ArrayList<Mietvertrag> getBeendeteMietvertr�ge() {
        return MenuManager.beendeteMietvertr�ge;
    }

    public static void setBeendeteMietvertr�ge(final ArrayList<Mietvertrag> beendeteMietvertr�ge) {
        MenuManager.beendeteMietvertr�ge = beendeteMietvertr�ge;
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
        return MenuManager.workerList;
    }

    public static void setWorkerList(final ArrayList<Mitarbeiter> workerList) {
        MenuManager.workerList = workerList;
    }

    public static ArrayList<Wohnung> getFlatList() {
        return MenuManager.flatList;
    }

    public static void setFlatList(final ArrayList<Wohnung> flatList) {
        MenuManager.flatList = flatList;
    }

    public void add(final Mitarbeiter mitarbeiter) {
        MenuManager.workerList.add(mitarbeiter);
    }

    public void add(final Wohnung wohnung) {
        MenuManager.flatList.add(wohnung);
    }

    public void add(final Mietvertrag mietvertrag) {
        MenuManager.beendeteMietvertr�ge.add(mietvertrag);
    }

    public void start() throws FileNotFoundException, ClassNotFoundException, IOException {
        //		String anmeldung = " ";
        //		boolean passwort�bereinstimmung = false;
        //
        //		while (passwort�bereinstimmung == false) {
        //			anmeldung = anmelden();
        //			boolean passwort = passwortExistens(anmeldung);
        //
        //			if (passwort == false) {
        //				System.out.println("Anmeldung nicht erfolgreich!\n");
        //			} else {
        //				passwort�bereinstimmung = true;
        //			}
        //		}
        //		personHerausfinden(anmeldung);

        System.out.println("\nBei Eingabe von \"0\" kehren Sie zum vorherigen Men� zur�ck. \nBei \"-1\" wird das Programm gespeichert und beendet.");
        MenuEntry meAktuell = ersterEintrag();
        try {
            meAktuell = aufruf(meAktuell);

        } catch (NullPointerException | ClassNotFoundException | IOException ex) {
            System.out.println("keine Aktion hinterlegt, weil kein Men�eintrag erstellt wurde");
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

    public MenuEntry aufruf(MenuEntry meAktuell) throws FileNotFoundException, ClassNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(meAktuell.getName());
            zaehleMenuePunkteAuf(meAktuell);

            System.out.print("W�hlen Sie einen Men�punkt aus: ");
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
                System.out.println("Fehler, der ausgew�hlte Men�punkt existiert nicht.");
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
        return MenuManager.ehemaligeMieter;
    }

    public static void setEhemaligeMieter(final ArrayList<Mieter> ehemaligeMieter) {
        MenuManager.ehemaligeMieter = ehemaligeMieter;
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
