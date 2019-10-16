import java.applet.AppletContext;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;


public class EventiSceltaBoxBianco implements ActionListener{
	
	Campo c=(Campo) ApplicationContext.diz.get("campo");	
	Controller cl= new Controller();
	SceltaBoxBianco sbox= (SceltaBoxBianco) ApplicationContext.diz.get("sboxbianco");
	@Override
	public void actionPerformed(ActionEvent evs) {
		
		
		
		Point p = c.returnPointSpecifico(); // ricevo il punto specifico dove è arrivato il pedone dalla classe campo
		
		if(evs.getActionCommand().equals("r")){
			c.getMatrice()[p.x][p.y]= new reginaB();
			sbox.setVisible(false);
			cl.cambiastato();

			
		}
		
		if(evs.getActionCommand().equals("a")){
			c.getMatrice()[p.x][p.y]= new alfiereB();
			sbox.setVisible(false); // non viene più visualizzato dopo la scelta
			cl.cambiastato();
		
		}
		if(evs.getActionCommand().equals("t")){
			c.getMatrice()[p.x][p.y]= new torreB();
			sbox.setVisible(false);
			cl.cambiastato();
			
		}
		if(evs.getActionCommand().equals("c")){
			c.getMatrice()[p.x][p.y]= new cavalloB();
			sbox.setVisible(false);
			cl.cambiastato();
		
		}
		
		
	}
	
	

}
