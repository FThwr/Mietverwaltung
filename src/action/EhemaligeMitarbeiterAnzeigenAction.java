package action;

import java.io.Serializable;

import menu.MenuManager;
import objekte.Mitarbeiter;

public class EhemaligeMitarbeiterAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ ehemalige Mitarbeiter anzeigen ________________________________________\n");

        /*
         * Es wird eine Übersicht über alle ehemaligen Mitarbeiter ausgegeben.
         */
        
        for (Mitarbeiter ehemaligerMitarbeiter : MenuManager.ehemaligeMitarbeiter) {

            if (ehemaligerMitarbeiter.getMitarbeiterID() != -100) {
                System.out.println("Mitarbeiter ID: " + ehemaligerMitarbeiter.getMitarbeiterID());
                }
                else {
                    System.out.println("Mitarbeiter ID: " + "-");
                }
            System.out.println("Name:           " + ehemaligerMitarbeiter.getName());
            System.out.println("Vorname:        " + ehemaligerMitarbeiter.getVorname());
            System.out.println("Benutzername:   " + ehemaligerMitarbeiter.getBenutzername());
            System.out.println("Passwort:       " + ehemaligerMitarbeiter.getPasswort());
            System.out.println("");
        }

    }

}