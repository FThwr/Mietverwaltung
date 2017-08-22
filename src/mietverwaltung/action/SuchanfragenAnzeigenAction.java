package mietverwaltung.action;

import java.io.Serializable;

import mietverwaltung.Suchanfrage;
import mietverwaltung.menu.MenuManager;

public class SuchanfragenAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        for (Suchanfrage search : this.searchList) {
            System.out.println("Mitarbeiter-ID:  " + search.getMitarbeiterID());
            System.out.println("Kunden-ID:       " + search.getKundenID());
            System.out.println("Zimmeranzahl:    " + search.getZimmeranzahl());
            System.out.println("Fl‰che:          " + search.getFl‰che());
            System.out.println("Kosten:          " + search.getKosten());
            System.out.println("Etage:           " + search.getEtage());
            System.out.println("Balkon:          " + search.getBalkon());
            System.out.println("Fuﬂbodenheizung: " + search.getFuﬂbodenheizung());
            System.out.println("Aussicht:        " + search.getAussicht());
            System.out.println("");
        }

    }

}