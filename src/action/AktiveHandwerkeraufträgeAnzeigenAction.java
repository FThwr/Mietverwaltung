package action;

import java.io.Serializable;

import menu.MenuManager;
import objekte.Handwerkerauftrag;

public class AktiveHandwerkeraufträgeAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ aktive Handwerkerauftrag anzeigen ________________________________________");

        /*
         * Jedes Element der ArrayList 'repairList' wird ausgelesen z.B. die
         * Auftragsnummer, das Eingangsdatum des Auftrags, etc. Die ArrayList
         * beeinhaltet alle zurzeit aktiven Handwerkeraufträge.
         * Es wird eine Übersicht über alle aktiven Handwerkeraufträge ausgegeben.
         */
        for (Handwerkerauftrag repair : MenuManager.repairList) {

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
