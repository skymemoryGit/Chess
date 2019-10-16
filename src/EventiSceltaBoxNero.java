import java.applet.AppletContext;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;


public class EventiSceltaBoxNero implements ActionListener{
	
	Campo c=(Campo) ApplicationContext.diz.get("campo");	
	Controller cl= new Controller();
	SceltaBoxNero sbox= (SceltaBoxNero) ApplicationContext.diz.get("sboxnero");
	@Override
	public void actionPerformed(ActionEvent evs) {
		
		
		
		Point p = c.returnPointSpecifico(); // ricevo il punto specifico dove è arrivato il pedone dalla classe campo
		
		if(evs.getActionCommand().equals("r")){
			c.getMatrice()[p.x][p.y]= new reginaN();
			sbox.setVisible(false);
			cl.cambiastato();

			
		}
		
		if(evs.getActionCommand().equals("a")){
			c.getMatrice()[p.x][p.y]= new alfiereN();
			sbox.setVisible(false); // non viene più visualizzato dopo la scelta
			cl.cambiastato();
		
		}
		if(evs.getActionCommand().equals("t")){
			c.getMatrice()[p.x][p.y]= new torreN();
			sbox.setVisible(false);
			cl.cambiastato();
			
		}
		if(evs.getActionCommand().equals("c")){
			c.getMatrice()[p.x][p.y]= new cavalloN();
			sbox.setVisible(false);
			cl.cambiastato();
		
		}
		
		
	}
	
	

}
