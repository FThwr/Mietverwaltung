package mietverwaltung;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Action {

	/*
	 * Jede Klasse die auf 'Action' endet implementiert diese Klasse. Sie führt
	 * jeweils die durch den Klassennamen beschriebene Funktion aus.
	 */
	void action() throws FileNotFoundException, IOException, ClassNotFoundException;
}
