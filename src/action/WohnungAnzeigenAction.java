package action;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import menue.MenueManager;
import objekte.Mieter;
import objekte.Wohnung;

public class WohnungAnzeigenAction extends MenueManager implements Action, ActionListener {

	// Damit Objekte der Klasse BeispielListener
	// zum ActionListener werden kann, muss das Interface
	// ActionListener implementiert werden

	JButton button;

	JLabel label;
	JPanel panel;
	JFrame frame;
	
@Override
public void action() {
	

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
		
		 //Zeilenumbrüche erfolgen nur nach ganzen Wörtern
		 textfeld.setWrapStyleWord(true);

		// Leeres JLabel-Objekt wird erzeugt
		label = new JLabel();

		// Drei Buttons werden erstellt
		button = new JButton("Enter");
		

		// Buttons werden dem Listener zugeordnet
		button.addActionListener(this);

		

		

		// JLabel wird dem Panel hinzugefügt
		panel.add(label);
		this.add(panel);
		

		JScrollPane scroller = new JScrollPane(textfeld);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		JPanel inputpanel = new JPanel();
		inputpanel.setLayout(new FlowLayout());
		

		
		panel.add(scroller);
		// Buttons werden dem JPanel hinzugefügt
		inputpanel.add(button);
		panel.add(inputpanel);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		int status = 0;
		for (Wohnung flat : flatList) {
			for (Mieter owner : ownerList) {
				if (owner.getWohnungsnummer() == flat.getWohnungsID()) {
					status = 1;
				}
				else {status = 0;
				
				}
			}
			if (status == 1) {
				flat.setStatus("vermietet");
			}
			else {
				flat.setStatus("frei");
			}
			
			
			
			 text = text 
			 + "\n" + tab + "Wohnungsnummer: " + flat.getWohnungsID()
			 + "\n" + tab + "Zimmeranzahl: " + flat.getZimmeranzahl()
			 + "\n" + tab + "Fläche: " + flat.getFläche()
			 + "\n" + tab + "Kosten: " + flat.getKosten()
			 + "\n" + tab + "Etage: " + flat.getEtage()
			 + "\n" + tab + "Balkon: " + flat.getBalkon()
			 + "\n" + tab + "Fußbodenheizung: " + flat.getFußbodenheizung()
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

	public void actionPerformed(ActionEvent ae) {
		// Die Quelle wird mit getSource() abgefragt und mit den
		// Buttons abgeglichen. Wenn die Quelle des ActionEvents einer
		// der Buttons ist, wird der Text des JLabels entsprechend geändert
		if (ae.getSource() == this.button) {
			frame.setVisible(false);;
		}
	}
}
	
	
	
//	
//	
// @Override
// public void action() {
//
// JFrame meinJFrame = new JFrame();
// meinJFrame.setTitle("JTextArea Beispiel");
// meinJFrame.setSize(768, 480);
// JPanel panel = new JPanel();
//
// //5-zeiliges und 20-spaltiges Textfeld wird erzeugt
// JTextArea textfeld = new JTextArea(1, 20);
//
// String text = "";
// String tab = " ";
// textfeld.setText(text);
//
// //Zeilenumbruch wird eingeschaltet
// textfeld.setLineWrap(true);
//
// //Zeilenumbrüche erfolgen nur nach ganzen Wörtern
// textfeld.setWrapStyleWord(true);
//
// //Ein JScrollPane, der das Textfeld beinhaltet, wird erzeugt
// JScrollPane scrollpane = new JScrollPane(textfeld);
// scrollpane.setPreferredSize(new Dimension(720, 430));
//
// //Scrollpane wird unserem Panel hinzugefügt
// panel.add(scrollpane);
//
// JPanel inputpanel = new JPanel();
// inputpanel.setLayout(new FlowLayout());
// JButton button = new JButton("Enter");
// inputpanel.add(button);
//
// meinJFrame.add(panel);
// meinJFrame.setVisible(true);
//
//
//
// for (Wohnung flat : flatList) {
//
//
// System.out.println("Wohnungsnummer: " + flat.getWohnungsID());
// System.out.println("Zimmeranzahl: " + flat.getZimmeranzahl());
// System.out.println("Fläche: " + flat.getFläche());
// System.out.println("Kosten: " + flat.getKosten());
// System.out.println("Etage: " + flat.getEtage());
// System.out.println("Balkon: " + flat.getBalkon());
// System.out.println("Fußbodenheizung: " + flat.getFußbodenheizung());
// System.out.println("Aussicht: " + flat.getAussicht());
// // System.out.println("Adresse: " + flat.getAdresse());
// System.out.println("Status: " + flat.getStatus());
// System.out.println("letztes Renovierungsdatum: " +
// flat.getLetztesRenovierungsdatum());
// System.out.println("Renovierungsanzahl: " + flat.getRenovierungsanzahl());
// System.out.println("letze Renovierungdetails: " +
// flat.getLetzeRenovierung_Details());
// System.out.println("zugeordneter Mitarbeiter: " +
// flat.getZugeordneterMitarbeiter().getName());
// System.out.println("");
//
//
// text = text + tab + "Wohnungsnummer: " + flat.getWohnungsID()
// + "\n" + tab + "Zimmeranzahl: " + flat.getZimmeranzahl()
// + "\n" + tab + "Fläche: " + flat.getFläche()
// + "\n" + tab + "Kosten: " + flat.getKosten()
// + "\n" + tab + "Etage: " + flat.getEtage()
// + "\n" + tab + "Balkon: " + flat.getBalkon()
// + "\n" + tab + "Fußbodenheizung: " + flat.getFußbodenheizung()
// + "\n" + tab + "Aussicht: " + flat.getAussicht()
// // + System.out.println("Adresse: " + flat.getAdresse());
// + "\n" + tab + "Status: " + flat.getStatus()
// + "\n" + tab + "letztes Renovierungsdatum: " +
// flat.getLetztesRenovierungsdatum()
// + "\n" + tab + "Renovierungsanzahl: " + flat.getRenovierungsanzahl()
// + "\n" + tab + "letze Renovierungdetails: " +
// flat.getLetzeRenovierung_Details()
// + "\n" + tab + "zugeordneter Mitarbeiter: " +
// flat.getZugeordneterMitarbeiter().getName()
// + "\n"
// + "\n";
// textfeld.setText(text);
// }}
//}