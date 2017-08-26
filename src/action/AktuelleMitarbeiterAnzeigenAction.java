package action;

import java.io.Serializable;

import menu.MenuManager;
import objekte.Mitarbeiter;

public class AktuelleMitarbeiterAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ aktuelle Mitarbeiter anzeigen ________________________________________\n");

        /*
         * Es wird eine �bersicht �ber alle aktiven Mietvertr�ge ausgegeben.
         */
        
        for (Mitarbeiter worker : MenuManager.getWorkerList()) {

            if (worker.getMitarbeiterID() != -100) {
            System.out.println("Mitarbeiter ID: " + worker.getMitarbeiterID());
            }
            else {
                System.out.println("Mitarbeiter ID: " + "-");
            }
            System.out.println("Name:           " + worker.getName());
            System.out.println("Vorname:        " + worker.getVorname());
            System.out.println("Benutzername:   " + worker.getBenutzername());
            System.out.println("Passwort:       " + worker.getPasswort());
            System.out.println("");
        }

    }

}