import java.applet.AppletContext;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.html.ImageView;


public class Graphic extends JFrame {
	
	// inizilizzazione
	public  Graphic() {
		this.setTitle("Scacchi Beta ");
		this.setBounds(250,0,720,720);
	
		this.setLayout(new BorderLayout());
		
		
		JPanel pannelloP = new JPanel();
		pannelloP.setBounds(getBounds());
		pannelloP.setLayout(new GridLayout(8,8));
		
		//Jbutton
			Eventi ev=new Eventi();
			for(int i=0;i!=64;i++){
			JButton b = new JButton();
			b.addActionListener(ev);
			b.setActionCommand(i+"");
		    b.setBorder(BorderFactory.createLineBorder(new Color(64,32,8)));
		    b.setBackground(Color.black);
			ApplicationContext.diz.put(i+"", b);
			pannelloP.add(b);
			}
			
		//top bar
			EventiTopbarra evb  = new EventiTopbarra();
			JMenuBar TopMenuBar = new JMenuBar(); // barra principale
			
			JMenu game = new JMenu("Game");  // voce game
		    
			JMenuItem exit = new JMenuItem("Exit");
		    exit.setToolTipText("Exit application");
		    exit.setActionCommand("Exit");
		    exit.addActionListener(evb);
		    
		    
		    JMenuItem newGame = new JMenuItem("New Game");
		    newGame.setActionCommand("new");
		    newGame.addActionListener(evb);
		    
		    JMenuItem save = new JMenuItem("Save");
		    save.setActionCommand("save");
		    save.addActionListener(evb);
		    
		    JMenuItem load = new JMenuItem("Load");
		    load.setActionCommand("load");
		    load.addActionListener(evb);
		   
		    
		    game.add(newGame);
		    game.add(save);
		    game.add(load);
		    game.add(exit);  
		    
		    TopMenuBar.add(game);
		
		this.add(TopMenuBar,BorderLayout.PAGE_START);
		this.add(pannelloP);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}
	
	
	public class EventiTopbarra implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ev) {
			//esci
			if(ev.getActionCommand().equals("Exit")){
				
				//salvataggio sicuro
				Campo c = (Campo) ApplicationContext.diz.get("campo");
				c.Salvare();
				System.exit(0);
			}
			//nuova partita
			if(ev.getActionCommand().equals("new")){
				if(JOptionPane.showConfirmDialog(null, "Vuoi Avviare una nuova Partita?")==0){ // scelta s/n
					Campo c = (Campo) ApplicationContext.diz.get("campo");
					Eventi e=  (Eventi) ApplicationContext.diz.get("eventi");
					
					e.setParamentriDefaul();
					Controller cl = new Controller();
					c.inizializzacampo();
					
					cl.cambiastato();
				}
				
			}
		
			//save
			if(ev.getActionCommand().equals("save")){
				Campo c = (Campo) ApplicationContext.diz.get("campo");
				c.Salvare();
			}
			
			if(ev.getActionCommand().equals("load")){
				if(JOptionPane.showConfirmDialog(null, "Vuoi carica l'ultima partita?")==0){ // scelta s/n
					Campo c = (Campo) ApplicationContext.diz.get("campo");
					Controller cl = new Controller();
					try {
						c.caricare();
						cl.cambiastato();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Il file non è stato trovato");
						e.printStackTrace();
					}
				}
			}
			
			
			
		}

	}
}
