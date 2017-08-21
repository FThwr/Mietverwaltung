package mietverwaltung.action;

import mietverwaltung.Handwerkerauftrag;
import mietverwaltung.menu.MenuManager;

public class HandwerkerauftragAnzeigenAction extends MenuManager implements Action {

    @Override
    public void action() {

        System.out.println("________________________________________ Handwerkerauftrag anzeigen ________________________________________");

        for (Handwerkerauftrag repair : MenuManager.currentManager.getRepairList()) {

            System.out.println("Auftrags ID: " + repair.getAuftragsID());
            System.out.println("Wohnungs ID: " + repair.getWohnungsID());
            System.out.println("Mitarbeiter ID: " + repair.getMitarbeiterID());
            System.out.println("Mängelbeschreibung: " + repair.getMängelbeschreibung());
            System.out.println("Status: " + repair.getStatus());
            System.out.println("Eingangsdatum: " + repair.getEingangsdatum());
            System.out.println("Fertigstellungsdatum: " + repair.getFertigstellungsDatum());
            System.out.println("");
        }

    }

}
