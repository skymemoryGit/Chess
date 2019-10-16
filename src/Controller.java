import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;


public class Controller {
	
	Campo c;
	
	public void cambiastato(){
		c= (Campo) ApplicationContext.diz.get("campo");
		for(int riga=0;riga!=8;riga++){
			for(int colonna=0;colonna!=8;colonna++){
				Pezzo p = 	c.getMatrice()[colonna][riga];
				p.setIcona(riga,colonna);   // anche quì ovverride!
				}
		}
		
	}
	
	
	
	
	
	
	
	

}
