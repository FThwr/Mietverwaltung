package mietverwaltung.action;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Action {

    void action() throws FileNotFoundException, IOException, ClassNotFoundException;
}