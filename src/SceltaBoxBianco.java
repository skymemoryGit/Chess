import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;


public class SceltaBoxBianco extends JFrame  {
	
	
	//costruttore
	public SceltaBoxBianco(){
		ApplicationContext.diz.put("sboxbianco", this);
		this.setBounds(0,0,150,400);
		this.setLayout(new GridLayout(4,1));
		
		JButton regina= new JButton();
		JButton alfiere= new JButton();
		JButton torre= new JButton();
		JButton cavallo= new JButton();
		
		regina.setText("Regina Bianco");
		alfiere.setText("Alfiere Bianco");
		torre.setText("Torre Bianco");
		cavallo.setText("Cavallo Bianco");
		
		regina.setActionCommand("r");
		alfiere.setActionCommand("a");
		torre.setActionCommand("t");
		cavallo.setActionCommand("c");
		
		EventiSceltaBoxBianco evs = new EventiSceltaBoxBianco();
		regina.addActionListener(evs);
		alfiere.addActionListener(evs);
		torre.addActionListener(evs);
		cavallo.addActionListener(evs);
		
		
		
		this.add(regina);
		this.add(alfiere);
		this.add(torre);
		this.add(cavallo);
		
		
		this.setVisible(true);
		
	}
	
}
