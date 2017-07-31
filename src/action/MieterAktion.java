package action;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class MieterAktion extends MenueManager implements Action {
	
	@Override
	public void action() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Nummer eingeben");
		String wohnung_String = s.next();
//		String wohnung_String = JOptionPane.showInputDialog(null, "Welche Wohnung wollen Sie sich anzeigen lassen?");
		
		for(Wohnung flat : flatList) {
			System.out.println("Hallo");
//			int wohnung_int = Integer.parseInt(wohnung_String);
			
			if(wohnung_String.equals("" + flat.getWohnungsID())) {
				System.out.println("Wohnung Nr: " + flat.getWohnungsID());
			}
//			if(flat.getWohnungsID()== wohnung_int) {
//				System.out.println("Wohnung Nr: " + flat.getWohnungsID());
//			}
		}
		

	}

}
