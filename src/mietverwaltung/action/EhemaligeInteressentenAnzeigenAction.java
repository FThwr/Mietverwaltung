package mietverwaltung.action;

import java.io.Serializable;

import action.Action;
import menu.MenuManager;
import mietverwaltung.Interessent;

public class EhemaligeInteressentenAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ ehemalige Interessent anzeigen ________________________________________");

        /*
         * F�r jedes Element in der Liste der ehemaligen Interessenten werden die dazugeh�rigen
         * Daten ausgegeben.
         */

        for (Interessent ehemaligerInteressent : MenuManager.getEhemaligeInteressenten()) {

            System.out.println("Interessenten ID: " + ehemaligerInteressent.getKundenID());
            System.out.println("Name:             " + ehemaligerInteressent.getName());
            System.out.println("Vorname:          " + ehemaligerInteressent.getVorname());
            System.out.println("Geburtsdatum:     " + ehemaligerInteressent.getGeburtsdatum());
            System.out.println("E-Mail:           " + ehemaligerInteressent.getEmail());
            System.out.println("Adresse:          " + ehemaligerInteressent.getAdresse());
            System.out.println("Telefon:          " + ehemaligerInteressent.getTelefonnummer());
            System.out.println("");
        }

    }

}