package action;

import java.io.Serializable;

import menu.MenuManager;
import objekte.Handwerkerauftrag;

public class AbgeschlosseneHandwerkeraufträgeAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ abgeschlossene Handwerkeraufträge anzeigen ________________________________________\n");

        /*
         * Jedes Element der ArrayList 'abgeschlosseneHandwerkeraufträge' wird
         * ausgelesen z.B. die Auftragsnummer, das Eingangsdatum des Auftrags,
         * etc. Die ArrayList beeinhaltet alle abgeschlossenen
         * Handwerkeraufträge.
         * Es wird eine Übersicht über alle abgeschlossene Handwerkeraufträge ausgegeben.
         */
        for (Handwerkerauftrag fertigerAuftrag : MenuManager.getAbgeschlosseneHandwerkeraufträge()) {

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
            System.out.println("Mängelbeschreibung: " + fertigerAuftrag.getMängelbeschreibung());

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
