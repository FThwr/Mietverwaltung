package action;

import java.io.Serializable;

import menu.MenuManager;
import objekte.Mieter;

public class AktuelleMieterAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ aktuelle Mieter anzeigen ________________________________________\n");

        /*
         * Jedes Element der ArrayList 'ownerList' wird ausgelesen. Die
         * ArrayList beeinhaltet alle aktuellen Mieter.
         *  Es wird eine Übersicht über alle aktuellen Mieter ausgegeben.
         */
        for (Mieter owner : MenuManager.getOwnerList()) {

            if (owner.getKundenID() != -100) {
                System.out.println("Mieter ID:      " + owner.getKundenID());
            } else {
                System.out.println("Mieter ID:      " + "-");
            }
            System.out.println("Name:           " + owner.getName());

            System.out.println("Vorname:        " + owner.getVorname());
            if (owner.getGeburtsdatum() != null) {
            System.out.println("Geburtsdatum:   " + owner.getGeburtsdatum());
            }
            else {
            System.out.println("Geburtsdatum:   " + "--.--.----");
            }
            if (owner.getWohnungsnummer() != -100) {
            System.out.println("Wohnung:        " + owner.getWohnungsnummer());
            }
            else {
                System.out.println("Wohnung:        " + "-");
            }
            System.out.println("E-Mail:         " + owner.getEmail());

            System.out.println("Adresse:        " + owner.getAdresse());

            System.out.println("Telefon:        " + owner.getTelefonnummer());

            System.out.println("");
        }

    }

}
