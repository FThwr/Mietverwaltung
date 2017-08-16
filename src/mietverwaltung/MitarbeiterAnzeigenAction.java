package mietverwaltung;

public class MitarbeiterAnzeigenAction extends MenueManager implements Action {

	@Override
	public void action() {
		
		System.out.println("________________________________________ Mitarbeiter anzeigen ________________________________________");

		for (Mitarbeiter worker : workerList) {

			System.out.println("Mitarbeiter ID: " + worker.getMitarbeiterID());
			System.out.println("Name:           " + worker.getName());
			System.out.println("Vorname:        " + worker.getVorname());
			System.out.println("Benutzername:   " + worker.getBenutzername());
			System.out.println("Passwort:       " + worker.getPasswort());
			System.out.println("");
		}

	}

}