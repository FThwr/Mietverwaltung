package action;

import java.io.Serializable;

import menu.MenuManager;
import objekte.Mitarbeiter;

public class EhemaligeMitarbeiterAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ ehemalige Mitarbeiter anzeigen ________________________________________");

        for (Mitarbeiter ehemaligerMitarbeiter : MenuManager.ehemaligeMitarbeiter) {

            System.out.println("Mitarbeiter ID: " + ehemaligerMitarbeiter.getMitarbeiterID());
            System.out.println("Name:           " + ehemaligerMitarbeiter.getName());
            System.out.println("Vorname:        " + ehemaligerMitarbeiter.getVorname());
            System.out.println("Benutzername:   " + ehemaligerMitarbeiter.getBenutzername());
            System.out.println("Passwort:       " + ehemaligerMitarbeiter.getPasswort());
            System.out.println("");
        }

    }

}