package mietverwaltung;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class SuchanfragenAnzeigenAction extends MenueManager implements Action , Serializable{

	@Override
	public void action() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		for (Suchanfrage search : searchList) {
			if (search.getMitarbeiterID() != -100) {
			System.out.println("Mitarbeiter-ID:  " + search.getMitarbeiterID());
			}
			else {
				System.out.println("Mitarbeiter-ID:  " + "-");
			}
			if (search.getKundenID() != -100) {
			System.out.println("Kunden-ID:       " + search.getKundenID());
			}
			else {
				System.out.println("Kunden-ID:       " + "-");
			}
			if (search.getZimmeranzahl() != -100) {
			System.out.println("Zimmeranzahl:    " + search.getRelaZimmeranzahl() + search.getZimmeranzahl());
			}
			else {
				System.out.println("Zimmeranzahl:    " + "-");
			}
			if (search.getFläche() != -100) {
			System.out.println("Fläche:          " + search.getRelaFläche() + search.getFläche());
			}
			else {
				System.out.println("Fläche:          " + "-");
			}
			if (search.getKosten() != -100) {
			System.out.println("Kosten:          " + search.getRelaKosten() + search.getKosten());
			}
			else {
				System.out.println("Kosten:          " + "-");
			}
			if (search.getEtage() != -100) {
			System.out.println("Etage:           " + search.getRelaEtage() + search.getEtage());
			}
			else {
				System.out.println("Etage:           " + "-");
			}
			System.out.println("Balkon:          " + search.getBalkon());
			System.out.println("Fußbodenheizung: " + search.getFußbodenheizung());
			System.out.println("Aussicht:        " + search.getAussicht());
			System.out.println("");
		}
		
	}

}
