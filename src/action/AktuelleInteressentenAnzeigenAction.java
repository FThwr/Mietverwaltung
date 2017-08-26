package action;

import java.io.Serializable;

import menu.MenuManager;
import objekte.Interessent;

public class AktuelleInteressentenAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ aktuelle Interessent anzeigen ________________________________________\n");

        /*
         * F�r jedes Element in der Interessentenliste werden die dazugeh�rigen
         * Daten ausgegeben.
         * Es wird eine �bersicht �ber alle aktuellen Interessenten ausgegeben.
         */

        for (Interessent interest : MenuManager.getInterestList()) {

            if (interest.getKundenID() != -100) {
                System.out.println("Interessenten ID: " + interest.getKundenID());
            } else {
                System.out.println("Interessenten ID: " + "-");
            }
            System.out.println("Name:             " + interest.getName());

            System.out.println("Vorname:          " + interest.getVorname());
            if (interest.getGeburtsdatum() != null) {
                System.out.println("Geburtsdatum:     " + interest.getGeburtsdatum());
            } else {
                System.out.println("Geburtsdatum:     " + "--.--.----");
            }
            System.out.println("E-Mail:           " + interest.getEmail());

            System.out.println("Adresse:          " + interest.getAdresse());

            System.out.println("Telefon:          " + interest.getTelefonnummer());

            System.out.println("");
        }

    }

}
