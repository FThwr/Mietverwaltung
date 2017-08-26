package action;

import java.io.Serializable;

import menu.MenuManager;
import objekte.Mitarbeiter;

public class AktuelleMitarbeiterAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ aktuelle Mitarbeiter anzeigen ________________________________________");

        for (Mitarbeiter worker : MenuManager.getWorkerList()) {

            System.out.println("Mitarbeiter ID: " + worker.getMitarbeiterID());
            System.out.println("Name:           " + worker.getName());
            System.out.println("Vorname:        " + worker.getVorname());
            System.out.println("Benutzername:   " + worker.getBenutzername());
            System.out.println("Passwort:       " + worker.getPasswort());
            System.out.println("");
        }

    }

}