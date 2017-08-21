package mietverwaltung.action;

import mietverwaltung.Mitarbeiter;
import mietverwaltung.menu.MenuManager;

public class MitarbeiterAnzeigenAction extends MenuManager implements Action {

    @Override
    public void action() {

        System.out.println("________________________________________ Mitarbeiter anzeigen ________________________________________");

        for (Mitarbeiter worker : MenuManager.currentManager.getWorkerList()) {

            System.out.println("Mitarbeiter ID: " + worker.getMitarbeiterID());
            System.out.println("Name:           " + worker.getName());
            System.out.println("Vorname:        " + worker.getVorname());
            System.out.println("Benutzername:   " + worker.getBenutzername());
            System.out.println("Passwort:       " + worker.getPasswort());
            System.out.println("");
        }

    }

}