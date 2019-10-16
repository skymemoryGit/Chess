import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class reN extends Pezzo{
	private ArrayList<Point>ls=new ArrayList<Point>();
	
	// costruttore : è un re nero
	public reN(){
		super.id="reN";  // prende id dalla classe madre
		super.idgruppo="N";
	}
	
	
	public String dimmichisei(){
		return "reNero";
	}
	
	public  void calcoloMossePossibili(int x, int y) {
		this.ls.clear(); 

		// il re ha 8 mosse in totale 
		if( x-1>=0 && y-1>=0){
			primopunto(x, y);
		}
		
		if(x-1>=0){
			secondopunto(x,y);
		}
		
		if(x-1>=0 && y+1<=7){
			terzopunto(x, y);
		}
		
		if(y+1<=7){
			quartopunto(x, y);
		}
		
		if(y+1>=0 && y-1>=0){
			quintopunto(x, y);
		}
		
		if( x+1<=7 && y-1>=0){
			sestopunto(x, y);
		}
		
		
		if( x+1<=7 ){
			settimopunto(x, y);
		}
		
		if( x+1<=7 && y+1<=7 ){
			ottavopunto(x, y);
		}
	//	System.out.print("\n"+ls+"  RE mossedisponibili "+ls.size());
	}
	
	public void primopunto(int x,int y){
			
				if(! super.c.getMatrice()[x-1][y-1].getidgruppo().equals("N") ){ // può andare in questa cella solo se non c'è un suo pezzo alleato
					Point p =new Point(x-1,y-1);
					System.out.print("\nEcco la lista dei bianchi quando re aggiunge il primopunto"+c.getTutteMosseBiancheLs());
					if(! c.getTutteMosseBiancheLs().contains(p)){  //se questo punto non fa parte delle celle ,in cui l'avversario puo andare
						ls.add(p);
					}
				}
	}
	
	public void secondopunto(int x,int y){
		
				if(! super.c.getMatrice()[x-1][y].getidgruppo().equals("N")){ // può andare in questa cella solo se non c'è un suo pezzo alleato
					Point p =new Point(x-1,y);
					if(! c.getTutteMosseBiancheLs().contains(p)){ // restituisce la lista delle celle in cui i neri possono andare
						ls.add(p);
					}
				}
	}
	
	public void terzopunto(int x,int y){
		
		if(! super.c.getMatrice()[x-1][y+1].getidgruppo().equals("N")){ // può andare in questa cella solo se non c'è un suo pezzo alleato
			Point p =new Point(x-1,y+1);
			if(! c.getTutteMosseBiancheLs().contains(p)){ // restituisce la lista delle celle in cui i neri possono andare
				ls.add(p);
			}
		}
	}
	
	public void quartopunto(int x,int y){
		
		if(! super.c.getMatrice()[x][y+1].getidgruppo().equals("N")){ // può andare in questa cella solo se non c'è un suo pezzo alleato
			Point p =new Point(x,y+1);
			if(! c.getTutteMosseBiancheLs().contains(p)){ // restituisce la lista delle celle in cui i neri possono andare
				ls.add(p);
			};
		}
	}
	


	public void quintopunto(int x,int y){
		
		if(! super.c.getMatrice()[x][y-1].getidgruppo().equals("N")){ // può andare in questa cella solo se non c'è un suo pezzo alleato
			Point p =new Point(x,y-1);
			if(! c.getTutteMosseBiancheLs().contains(p)){  // restituisce la lista delle celle in cui i neri possono andare
				ls.add(p);
			}
		}
	}
	
	public void sestopunto(int x,int y){
		
		if(! super.c.getMatrice()[x+1][y-1].getidgruppo().equals("N")){ // può andare in questa cella solo se non c'è un suo pezzo alleato
			Point p =new Point(x+1,y-1);
			if(! c.getTutteMosseBiancheLs().contains(p)){  // restituisce la lista delle celle in cui i neri possono andare
				ls.add(p);
			}
		}
	}
	
	public void settimopunto(int x,int y){
		
		if(! super.c.getMatrice()[x+1][y].getidgruppo().equals("N")){ // può andare in questa cella solo se non c'è un suo pezzo alleato
			Point p =new Point(x+1,y);
			if(! c.getTutteMosseBiancheLs().contains(p)){  // restituisce la lista delle celle in cui i neri possono andare
				ls.add(p);
			}
		}
	}
	
	public void ottavopunto(int x,int y){
		
		if(! super.c.getMatrice()[x+1][y+1].getidgruppo().equals("N")){ // può andare in questa cella solo se non c'è un suo pezzo alleato
			Point p =new Point(x+1,y+1);
			if(! c.getTutteMosseBiancheLs().contains(p)){  // restituisce la lista delle celle in cui i neri possono andare
				ls.add(p);
			}
		}
	}
	public boolean checkMossavalida(int xp , int yp,int xd,int yd){
		ls.clear();  // svuota cache
		calcoloMossePossibili(xp, yp); // calcolo tutte le posizioni possibili
		Point arrivo=new Point(xd,yd);  // il punto destinatazione
		
		for(Point p : this.ls){     //CONFRONTA OGNI PUNTO E SE IL PUNTO DI ARRIVO SI TROVA NELLA LISTA DELLE MOSSE POSSIBIli, ALLORA LA MOSSA è VALIDA.
			if(p.equals(arrivo)){
				return true;
			}
		}
		
		return false;
		
		
	}
	
	
	public void setIcona(int riga,int colonna){
		JButton b=(JButton) ApplicationContext.diz.get((riga+colonna*8)+"");
		if((riga+colonna)%2==0){   // pari chiaro
		b.setIcon(new ImageIcon("Ren_sfc0000.jpg"));
		}
		else { // scuro
			b.setIcon(new ImageIcon("reN_sfscuro0000.jpg"));
		}
	}
	public void viewMosse(int x,int y){  // questo metodo mostra tutte le celle delle mosse possibili su graphic 
		System.out.print("\n disegno le mosse");
	
		this.ls.clear();  // pulisco la lista
		calcoloMossePossibili(x, y);	//riempio la lista
		System.out.print(this.ls);
		
		//disegno il contorno per la posizione di partenza
		JButton b=(JButton) ApplicationContext.diz.get((y+x*8)+"");
		b.setBorder(BorderFactory.createLineBorder(Color.magenta));
		
		for(Point punto : this.ls ){
			disegnaContorno(punto.x, punto.y);  // richiamo il metodo che disegna un contorno a ciascuna cella
		}
	
			
	}
	
	public void disegnaContorno(int x , int y){  // disegna un contorno
		JButton b=(JButton) ApplicationContext.diz.get((y+x*8)+"");
		b.setBorder(BorderFactory.createLineBorder(Color.yellow));
	
		
	}
	public ArrayList<Point> getPrivatels(){
		return this.ls;
	}
	
	
}


