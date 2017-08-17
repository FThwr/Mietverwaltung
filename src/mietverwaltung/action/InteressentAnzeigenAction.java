package mietverwaltung.action;

import mietverwaltung.Interessent;
import mietverwaltung.menu.MenuManager;

public class InteressentAnzeigenAction extends MenuManager implements Action {

    @Override
    public void action() {

        System.out.println("________________________________________ Interessent anzeigen ________________________________________");

        for (Interessent interest : MenuManager.interestList) {

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
