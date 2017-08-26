package action;

import java.io.Serializable;

import menu.MenuManager;

public class EhemaligeMieterAnzeigenAction extends MenuManager implements Action, Serializable {
    @Override
    public void action() {
        
        System.out.println(
                "________________________________________ ehemalige Mieter anzeigen ________________________________________\n");

        /*
         *  Es wird eine Übersicht über alle ehemaligen Mieter ausgegeben.
         */
        for (objekte.Mieter ehemaligerMieter : MenuManager.getEhemaligeMieter()) {

            if (ehemaligerMieter.getKundenID() != -100) {
                System.out.println("Mieter ID:      " + ehemaligerMieter.getKundenID());
                }
                else {
                    System.out.println("Mieter ID:      " + "-");
                }
                System.out.println("Name:           " + ehemaligerMieter.getName());
                System.out.println("Vorname:        " + ehemaligerMieter.getVorname());
                if (ehemaligerMieter.getGeburtsdatum() != null) {
                System.out.println("Geburtsdatum:   " + ehemaligerMieter.getGeburtsdatum());
                }
                else {
                    System.out.println("Geburtsdatum:   " + "--.--.----");
                }
                if (ehemaligerMieter.getWohnungsnummer() != -100) {
                System.out.println("Wohnung:        " + ehemaligerMieter.getWohnungsnummer());
                }
                else {
                    System.out.println("Wohnung:        " + "-");
                }
                System.out.println("E-Mail:         " + ehemaligerMieter.getEmail());
                System.out.println("Adresse:        " + ehemaligerMieter.getAdresse());
                System.out.println("Telefon:        " + ehemaligerMieter.getTelefonnummer());
                System.out.println("");
            }

    }
}