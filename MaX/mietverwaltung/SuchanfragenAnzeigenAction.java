package mietverwaltung;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class SuchanfragenAnzeigenAction extends MenueManager implements Action , Serializable{

	@Override
	public void action() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		for (Suchanfrage search : searchList) {
			System.out.println("Mitarbeiter-ID:  " + search.getMitarbeiterID());
			System.out.println("Kunden-ID:       " + search.getKundenID());
			System.out.println("Zimmeranzahl:    " + search.getZimmeranzahl());
			System.out.println("Fläche:          " + search.getFläche());
			System.out.println("Kosten:          " + search.getKosten());
			System.out.println("Etage:           " + search.getEtage());
			System.out.println("Balkon:          " + search.getBalkon());
			System.out.println("Fußbodenheizung: " + search.getFußbodenheizung());
			System.out.println("Aussicht:        " + search.getAussicht());
			System.out.println("");
		}
		
	}

}
