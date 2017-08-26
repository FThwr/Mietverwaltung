package action;

import java.io.Serializable;

import menu.MenuManager;
import objekte.Handwerkerauftrag;

public class AbgeschlosseneHandwerkerauftr�geAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ abgeschlossene Handwerkerauftr�ge anzeigen ________________________________________\n");

        /*
         * Jedes Element der ArrayList 'abgeschlosseneHandwerkerauftr�ge' wird
         * ausgelesen z.B. die Auftragsnummer, das Eingangsdatum des Auftrags,
         * etc. Die ArrayList beeinhaltet alle abgeschlossenen
         * Handwerkerauftr�ge.
         * Es wird eine �bersicht �ber alle abgeschlossene Handwerkerauftr�ge ausgegeben.
         */
        for (Handwerkerauftrag fertigerAuftrag : MenuManager.getAbgeschlosseneHandwerkerauftr�ge()) {

            System.out.println("Auftrags ID: " + fertigerAuftrag.getAuftragsID());
            if (fertigerAuftrag.getWohnungsID() != -100) {
                System.out.println("Wohnungs ID: " + fertigerAuftrag.getWohnungsID());
            } else {
                System.out.println("Wohnungs ID: " + "-");
            }
            if (fertigerAuftrag.getMitarbeiterID() != -100) {
                System.out.println("Mitarbeiter ID: " + fertigerAuftrag.getMitarbeiterID());
            } else {
                System.out.println("Mitarbeiter ID: " + "-");
            }
            System.out.println("M�ngelbeschreibung: " + fertigerAuftrag.getM�ngelbeschreibung());

            System.out.println("Status: " + fertigerAuftrag.getStatus());
            if (fertigerAuftrag.getEingangsdatum() != null) {
                System.out.println("Eingangsdatum: " + fertigerAuftrag.getEingangsdatum());
            } else {
                System.out.println("Eingangsdatum: " + "--.--.----");
            }
            if (fertigerAuftrag.getFertigstellungsDatum() != null) {
                System.out.println("Fertigstellungsdatum: " + fertigerAuftrag.getFertigstellungsDatum());
            } else {
                System.out.println("Fertigstellungsdatum: " + "--.--.----");
            }
            System.out.println("");
        }

    }

}
