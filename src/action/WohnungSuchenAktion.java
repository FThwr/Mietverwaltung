package action;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import menu.MenuManager;
import objekte.Wohnung;

public class WohnungSuchenAktion extends MenuManager implements Action {

	JButton button;

	JLabel label;
	JPanel panel;
	JFrame frame;
	
	
	
	@Override
	public void action() {
		String check = "";
panel = new JPanel();
		
		frame = new JFrame();
		frame.setTitle("JTextArea Beispiel");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(true);
		JTextArea textfeld = new JTextArea(30, 50);
		
		 String text = "";
		 String tab = " ";
		 textfeld.setText(text);
		
		 //Zeilenumbruch wird eingeschaltet
		 textfeld.setLineWrap(true);
		
		 //Zeilenumbr¸che erfolgen nur nach ganzen Wˆrtern
		 textfeld.setWrapStyleWord(true);

		// Leeres JLabel-Objekt wird erzeugt
		label = new JLabel();

		// Drei Buttons werden erstellt
		button = new JButton("Enter");
		

		// Buttons werden dem Listener zugeordnet
		button.addActionListener(this);

		

		

		// JLabel wird dem Panel hinzugef¸gt
		panel.add(label);
		this.add(panel);
		

		JScrollPane scroller = new JScrollPane(textfeld);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		JPanel inputpanel = new JPanel();
		inputpanel.setLayout(new FlowLayout());
		

		
		panel.add(scroller);
		// Buttons werden dem JPanel hinzugef¸gt
		inputpanel.add(button);
		panel.add(inputpanel);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(false);
		
			

		boolean suchVorgang = true;

//		int ID = 0;
//		String such_ID = "" + ID;
		
		
		int zimmeranzahl = 0;
		String such_ZA = "" + zimmeranzahl;
		

//		double fl‰che = 0.00;
//		String such_FL = "" + fl‰che;
//
//		double kosten = 0.00;
//		String such_KT = "" + kosten;
//
//		int etage = 0;
//		String such_EG = "" + etage;
//
//		boolean balkon = false;
//		String such_BK = "" + balkon;
//
//		boolean fuﬂbodenheizung = false;
//		String such_FBH = "" + fuﬂbodenheizung;
//
//		String aussicht = "";
//		String such_AS = aussicht;
//
//		// String adresse = "";
//		
//		String status = "";
//		String such_ST = status;
//
//		String letztesRenovierungsdatum = "";
//		String such_LRDT = letztesRenovierungsdatum;
//
//		int renovierungsanzahl = 0;
//		String such_RA = "" + renovierungsanzahl;
//
//		String letzeRenovierung_Details = "";
//		String such_LRI = letzeRenovierung_Details;
//
//		
		String zugeordneterMitarbeiter = "";
		String such_ZM = zugeordneterMitarbeiter;
		
		
		
//		String [] suche = {such_ID, such_ZA, such_FL, such_KT, such_EG, such_BK, such_FBH, such_AS,
//				such_ST, such_LRDT, such_RA, such_LRI, such_ZM};

		while (suchVorgang == true) {

			String[] buttons = { "ID", "ZA", "Fl", "KT", "EG", "BK", "FBH", "AS", "ST", "LRDT", "RA", "LRI", "ZM",
					"suchen", "abbruch" };

			int ok = JOptionPane.showOptionDialog(null,
					"W‰hlen Sie ein zu suchenden Wert! " + "\n\nID:                " 
//			+ such_ID + "\n\nZA:               "
//							+ such_ZA + "\n\nFL:                " + such_FL + "\n\nKT:                " + such_KT
//							+ "\n\nEG:                " + such_EG + "\n\nBK:                " + such_BK
//							+ "\n\nFBH:              " + such_FBH + "\n\nAS:                 " + such_AS
//							+ "\n\nST:                 " + such_ST + "\n\nLRDT:            " + such_LRDT
//							+ "\n\nRA:                " + such_RA + "\n\nLRI:                "
//							+ such_LRI + "\n\nZM:                " + such_ZM,
					,"Wohnungserstellung", JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons);

//			if (ok == 0) {
//				such_ID = String_eingabe(such_ID, buttons, ok);
//			}
			if (ok == 1) {
				such_ZA = String_eingabe(such_ZA, buttons, ok);
				check = check + "a";
			}
//			if (ok == 2) {
//				such_FL = String_eingabe(such_FL, buttons, ok);
//			}
//			if (ok == 3) {
//				such_KT = String_eingabe(such_KT, buttons, ok);
//			}
//			if (ok == 4) {
//				such_EG = String_eingabe(such_EG, buttons, ok);
//			}
//			if (ok == 5) {
//				such_BK = String_eingabe(such_BK, buttons, ok);
//			}
//			if (ok == 6) {
//				such_FBH = String_eingabe(such_FBH, buttons, ok);
//			}
//			if (ok == 7) {
//				such_AS = String_eingabe(such_AS, buttons, ok);
//			}
//			if (ok == 8) {
//				such_ST = String_eingabe(such_ST, buttons, ok);
//			}
//			if (ok == 9) {
//				such_LRDT = String_eingabe(such_LRDT, buttons, ok);
//			}
//			if (ok == 10) {
//				such_RA = String_eingabe(such_RA, buttons, ok);
//			}
//			if (ok == 11) {
//				such_LRI = String_eingabe(such_LRI, buttons, ok);
//			}
			if (ok == 12) {
				such_ZM = String_eingabe(such_ZM, buttons, ok);
				// charakter einbauen, der f¸r jeden buchstaben einn button erh‰lt und sp‰ter auf "consits" ¸berp¸ftr wird 
				check = check + "b";
			}
			if (ok == 13) {
				suchVorgang = false;
				
				frame.setVisible(true);
				String vgl_ZA = "";
				String vgl_ZM = "";
				
				for (Wohnung flat : flatList) {
					vgl_ZA = "0"; vgl_ZM = "0";
					if (check.contains("a")) {
					vgl_ZA = "" + flat.getZimmeranzahl();}
					if (check.contains("b")) {
					vgl_ZM = "" + flat.getZugeordneterMitarbeiter().getName();}
					
					
					// wenn ich auf dne knopf ZM - > buchstabe in wort 
					// wenn (wort beeinhalett buchstaben) dann mache vgl_ = flat.getZA
					// wenn (wort nicht beeinhaltet buchstaben) vgl_ = such_ 
					
						if (vgl_ZM.equals(such_ZM) && vgl_ZA.equals(such_ZA) 
								// && vgl_
								) {
							text = text + tab + "Wohnungsnummer: " + flat.getWohnungsID()
							 + "\n" + tab + "Zimmeranzahl: " + flat.getZimmeranzahl()
							 + "\n" + tab + "Fl‰che: " + flat.getFl‰che()
							 + "\n" + tab + "Kosten: " + flat.getKosten()
							 + "\n" + tab + "Etage: " + flat.getEtage()
							 + "\n" + tab + "Balkon: " + flat.getBalkon()
							 + "\n" + tab + "Fuﬂbodenheizung: " + flat.getFuﬂbodenheizung()
							 + "\n" + tab + "Aussicht: " + flat.getAussicht()
							 // + System.out.println("Adresse: " + flat.getAdresse());
							 + "\n" + tab + "Status: " + flat.getStatus()
							 + "\n" + tab + "letztes Renovierungsdatum: " +
							 flat.getLetztesRenovierungsdatum()
							 + "\n" + tab + "Renovierungsanzahl: " + flat.getRenovierungsanzahl()
							 + "\n" + tab + "letze Renovierungdetails: " +
							 flat.getLetzeRenovierung_Details()
							 + "\n" + tab + "zugeordneter Mitarbeiter: " +
							 flat.getZugeordneterMitarbeiter().getName()
							 + "\n"
							 + "\n";
							 textfeld.setText(text);
					}
				}
			}
			if (ok == 14) {
				suchVorgang = false;
			}
		}
			}
	
	public void actionPerformed(ActionEvent ae) {
		// Die Quelle wird mit getSource() abgefragt und mit den
		// Buttons abgeglichen. Wenn die Quelle des ActionEvents einer
		// der Buttons ist, wird der Text des JLabels entsprechend ge‰ndert
		if (ae.getSource() == this.button) {
			frame.setVisible(false);;
		}
	}
	
	public String String_eingabe(String bearbeitungsknopf,  String[] buttons, int ok) {
		JOptionPane jop = new JOptionPane();
		jop.setWantsInput(true);
		jop.setMessage("Eingabe vom Feld: " + buttons[ok]);
		// in der Klammer den Namen des Fensters eingeben
		JDialog dialog = jop.createDialog("Wohnungserstellung");
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);

		String eingabe = jop.getInputValue() == JOptionPane.UNINITIALIZED_VALUE ? null : (String) jop.getInputValue();
		bearbeitungsknopf = eingabe;
		return bearbeitungsknopf;
	}
}
