import javax.swing.ImageIcon;
import javax.swing.JButton;


public class vuoto extends Pezzo{
	
	// costruttore : è una cella vuota
	
	public vuoto(){
		super.idgruppo="V";
		super.id= "vuoto";
	}
	
	
	
	public String dimmichisei(){
		return "";
	}
	
	public void setIcona(int riga,int colonna){
		JButton b=(JButton) ApplicationContext.diz.get((riga+colonna*8)+"");
		if((riga+colonna)%2==0){  
		b.setIcon(new ImageIcon("sfondochiaro.jpg"));
	
		}
		else{
			b.setIcon(new ImageIcon("sfondoscuro.jpg"));
			
		}
		
	}
}
