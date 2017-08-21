package mietverwaltung;

import java.io.Serializable;

public class InteressentAnzeigenAction extends MenueManager implements Action , Serializable{

	@Override
	public void action() {
		
		System.out.println("________________________________________ Interessent anzeigen ________________________________________");

		for (Interessent interest : interestList) {

			System.out.println("Interessenten ID: " + interest.getKundenID());
			System.out.println("Name:             " + interest.getName());
			System.out.println("Vorname:          " + interest.getVorname());
			System.out.println("Geburtsdatum:     " + interest.getGeburtsdatum());
			System.out.println("E-Mail:           " + interest.getEmail());
			System.out.println("Adresse:          " + interest.getAdresse());
			System.out.println("Telefon:          " + interest.getTelefonnummer());
			System.out.println("");
		}

	}

}

