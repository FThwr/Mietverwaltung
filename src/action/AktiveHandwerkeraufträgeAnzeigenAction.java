package action;

import java.io.Serializable;

import menu.MenuManager;
import objekte.Handwerkerauftrag;

public class AktiveHandwerkerauftr�geAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ aktive Handwerkerauftrag anzeigen ________________________________________");

        /*
         * Jedes Element der ArrayList 'repairList' wird ausgelesen z.B. die
         * Auftragsnummer, das Eingangsdatum des Auftrags, etc. Die ArrayList
         * beeinhaltet alle zurzeit aktiven Handwerkerauftr�ge.
         * Es wird eine �bersicht �ber alle aktiven Handwerkerauftr�ge ausgegeben.
         */
        for (Handwerkerauftrag repair : MenuManager.repairList) {

            System.out.println("Auftrags ID: " + repair.getAuftragsID());
            System.out.println("Wohnungs ID: " + repair.getWohnungsID());
            System.out.println("Mitarbeiter ID: " + repair.getMitarbeiterID());
            System.out.println("M�ngelbeschreibung: " + repair.getM�ngelbeschreibung());
            System.out.println("Status: " + repair.getStatus());
            System.out.println("Eingangsdatum: " + repair.getEingangsdatum());
            System.out.println("Fertigstellungsdatum: " + repair.getFertigstellungsDatum());
            System.out.println("");
        }

    }

}
