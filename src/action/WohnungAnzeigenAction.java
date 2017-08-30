package action;

import java.awt.event.ActionListener;

import menu.MenuManager;
import objekte.Wohnung;

public class WohnungAnzeigenAction extends MenuManager implements Action, ActionListener {

    @Override
    public void action() {

        for (Wohnung flat : MenuManager.getFlatList()) {

            if (flat.getWohnungsID() != -100) {
                System.out.println("Wohnungsnummer:                  " + flat.getWohnungsID());
            } else {
                System.out.println("Wohnungsnummer:                  " + "-");
            }

            if (flat.getZimmeranzahl() != -100) {
                System.out.println("Zimmeranzahl:                    " + flat.getZimmeranzahl());
            } else {
                System.out.println("Zimmeranzahl:                    " + "-");
            }

            if (flat.getFl‰che() != -100) {
                System.out.println("Fl‰che:                          " + flat.getFl‰che());
            } else {
                System.out.println("Fl‰che:                          " + "-");
            }

            if (flat.getKosten() != -100) {
                System.out.println("Kosten:                          " + flat.getKosten());
            } else {
                System.out.println("Kosten:                          " + "-");
            }

            if (flat.getEtage() != -100) {
                System.out.println("Etage:                           " + flat.getEtage());
            } else {
                System.out.println("Etage:                           " + "-");
            }

            System.out.println("Balkon:                          " + flat.getBalkon());
            System.out.println("Fuﬂbodenheizung:                 " + flat.getFuﬂbodenheizung());
            System.out.println("Aussicht:                        " + flat.getAussicht());

            if (flat.getAdresse() != null) {
                System.out.println("Adresse:                         " + flat.getAdresse());
            } else {
                System.out.println("Adresse:                         " + "-");
            }

            System.out.println("Status:                          " + flat.getStatus());

            if (flat.getLetztesRenovierungsdatum() != null) {
                System.out.println("letztes Renovierungsdatum:       " + flat.getLetztesRenovierungsdatum());
            } else {
                System.out.println("letztes Renovierungsdatum:       " + "-");
            }

            if (flat.getRenovierungsanzahl() != -100) {
                System.out.println("Renovierungsanzahl:              " + flat.getRenovierungsanzahl());
            } else {
                System.out.println("Renovierungsanzahl:              " + "-");
            }

            System.out.println("letze Renovierungdetails:        " + flat.getLetzeRenovierung_Details());

            if (flat.getHandwerkerauftrag() != null) {
                System.out.println("Handwerkerauftrag:               " + flat.getHandwerkerauftrag().getAuftragsID());
            } else {
                System.out.println("Handwerkerauftrag:               " + "-");
            }

            if (flat.getZugeordneterMitarbeiter() != null) {
                System.out.println("zugeordneter Mitarbeiter:        " + flat.getZugeordneterMitarbeiter().getName());
            } else {
                System.out.println("zugeordneter Mitarbeiter:        " + "-");
            }
            System.out.println("");
        }
    }
}
