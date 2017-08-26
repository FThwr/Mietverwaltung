package action;

import java.io.Serializable;

import menu.MenuManager;
import objekte.Interessent;

public class AktuelleInteressentenAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ aktuelle Interessent anzeigen ________________________________________");

        /*
         * Für jedes Element in der Interessentenliste werden die dazugehörigen
         * Daten ausgegeben.
         * Es wird eine Übersicht über alle aktuellen Interessenten ausgegeben.
         */

        for (Interessent interest : MenuManager.getInterestList()) {

            System.out.println("Interessenten ID: " + interest.getKundenID());
            System.out.println("Name:             " + interest.getName());
            System.out.println("Vorname:          " + interest.getVorname());
            System.out.println("Geburtsdatum:     " + interest.getGeburtsdatum());
            System.out.println("E-Mail:           " + interest.getEmail());
            System.out.println("Adresse:          " + interest.getAdresse());
            System.out.println("Telefon:          " + interest.getTelefonnummer());
            System.out.println("");
        }

    }

}
