import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;



public class main {

	public static void main(String[] args) {
		
	
		

		
		Campo c = new Campo();
		c.inizializzacampo();
		//c.IniTest();

		
		Graphic schermo= new Graphic();
		Controller cl= new Controller();
		cl.cambiastato();
	
		
		
		
		if(JOptionPane.showConfirmDialog(null, "Vuoi Caricare l'ultima partita?")==0){  // richiesta all'utente se si vuole caricare l'ultima partita
			try {
				c.caricare();
				cl.cambiastato();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Warning: The memory file is breaked!!");
				e.printStackTrace();
				
			}
		}
		
	
	
		
		
		
	}

}
