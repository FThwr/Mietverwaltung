package action;

import java.io.Serializable;

import menu.MenuManager;
import objekte.Mieter;

public class AktuelleMieterAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        /*
         * Jedes Element der ArrayList 'ownerList' wird ausgelesen. Die
         * ArrayList beeinhaltet alle aktuellen Mieter.
         *  Es wird eine Übersicht über alle aktuellen Mieter ausgegeben.
         */
        for (Mieter owner : MenuManager.getOwnerList()) {

            System.out.println("Mieter ID:      " + owner.getKundenID());
            System.out.println("Name:           " + owner.getName());
            System.out.println("Vorname:        " + owner.getVorname());
            System.out.println("Geburtsdatum:   " + owner.getGeburtsdatum());
            System.out.println("Wohnung:        " + owner.getWohnungsnummer());
            System.out.println("E-Mail:         " + owner.getEmail());
            System.out.println("Adresse:        " + owner.getAdresse());
            System.out.println("Telefon:        " + owner.getTelefonnummer());
            System.out.println("");
        }

    }

}
