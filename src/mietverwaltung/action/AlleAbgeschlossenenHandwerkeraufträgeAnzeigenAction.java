package mietverwaltung.action;

import java.io.Serializable;

import action.Action;
import menu.MenuManager;
import mietverwaltung.Handwerkerauftrag;

public class AlleAbgeschlossenenHandwerkerauftr�geAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ abgeschlossene Handwerkerauftr�ge anzeigen ________________________________________");

        /*
         * Jedes Element der ArrayList 'abgeschlosseneHandwerkerauftr�ge' wird
         * ausgelesen z.B. die Auftragsnummer, das Eingangsdatum des Auftrags,
         * etc. Die ArrayList beeinhaltet alle abgeschlossenen
         * Handwerkerauftr�ge.
         */
        for (Handwerkerauftrag fertigerAuftrag : MenuManager.getAbgeschlosseneHandwerkerauftr�ge()) {

            System.out.println("Auftrags ID: " + fertigerAuftrag.getAuftragsID());
            System.out.println("Wohnungs ID: " + fertigerAuftrag.getWohnungsID());
            System.out.println("Mitarbeiter ID: " + fertigerAuftrag.getMitarbeiterID());
            System.out.println("M�ngelbeschreibung: " + fertigerAuftrag.getM�ngelbeschreibung());
            System.out.println("Status: " + fertigerAuftrag.getStatus());
            System.out.println("Eingangsdatum: " + fertigerAuftrag.getEingangsdatum());
            System.out.println("Fertigstellungsdatum: " + fertigerAuftrag.getFertigstellungsDatum());
            System.out.println("");
        }

    }

}
