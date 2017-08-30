package action;

import java.io.Serializable;

import menu.MenuManager;
import objekte.Handwerkerauftrag;

public class AktiveHandwerkerauftr�geAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ aktive Handwerkerauftrag anzeigen ________________________________________\n");

        /*
         * Jedes Element der ArrayList 'repairList' wird ausgelesen z.B. die
         * Auftragsnummer, das Eingangsdatum des Auftrags, etc. Die ArrayList
         * beeinhaltet alle zurzeit aktiven Handwerkerauftr�ge.
         * Es wird eine �bersicht �ber alle aktiven Handwerkerauftr�ge ausgegeben.
         */
        for (Handwerkerauftrag repair : MenuManager.getRepairList()) {

            if (repair.getWohnungsID() != -100) {
                System.out.println("Auftrags ID: " + repair.getAuftragsID());
                System.out.println("Wohnungs ID: " + repair.getWohnungsID());
            } else {
                System.out.println("Wohnungs ID: " + "-");
            }
            if (repair.getMitarbeiterID() != -100) {
                System.out.println("Mitarbeiter ID: " + repair.getMitarbeiterID());
            } else {
                System.out.println("Mitarbeiter ID: " + "-");
            }
            System.out.println("M�ngelbeschreibung: " + repair.getM�ngelbeschreibung());

            System.out.println("Status: " + repair.getStatus());
            if (repair.getEingangsdatum() != null) {
                System.out.println("Eingangsdatum: " + repair.getEingangsdatum());
            } else {
                System.out.println("Eingangsdatum: " + "--.--.----");
            }
            if (repair.getFertigstellungsDatum() != null) {
                System.out.println("Fertigstellungsdatum: " + repair.getFertigstellungsDatum());
            } else {
                System.out.println("Fertigstellungsdatum: " + "--.--.----");
            }
            System.out.println("");
        }

    }

}
