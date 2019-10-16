import java.awt.Color;
import java.awt.Point;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class cavalloB extends Pezzo {
	private ArrayList<Point>ls=new ArrayList<Point>();
	
	// costruttore : è una cella vuota
	public cavalloB(){
		super.id="cavalloB";  // prende id dalla classe madre
		super.idgruppo="B";
	}
	
	
	public String dimmichisei(){
		return "cavalloBianco";
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
	

	public  void calcoloMossePossibili(int x, int y) {
		this.ls.clear(); 
		//il cavallo in totale ha 8 mosse se rispettano i vincoli, li aggiungo alla lista altrimenti no.
		if( x-2>=0 && y-1>=0){
			check1mossa(x, y);
		}
		
		if(x-2>=0 && y+1<=7){
			check2mossa(x, y);
		}
		
		if(x-1>=0 && y+2<=7){
			check3mossa(x, y);
		}
		
		if(x+1<=7 && y+2<=7){
			check4mossa(x, y);
		}
		if(x+2<=7 && y+1<=7){
			check5mossa(x, y);
		}
		if(x+2<=7 && y-1>=0 && x!=5 && y!=5){  // ! what bug?
			check6mossa(x, y);
		}
		if((x==5 && y==5) || (x==5 &&  y==7)){
			check6mossa(x, y);
		}
		
		if(x+1<=7 && y-2>=0){
			check7mossa(x, y);
		}
		if(x-1>=0 && y-2>=0){
			check8mossa(x, y);
		}
		
		//System.out.print("\n"+ls+" mossedisponibili "+ls.size());
		
	}
	
	public void check1mossa(int x,int y){

		//1 mossa
		if(! super.c.getMatrice()[x-2][y-1].getidgruppo().equals("B")){ // può andare in questo cella solo se non c'è un suo pezzo alleato
			Point p =new Point(x-2,y-1);
			ls.add(p);
		}
	}
	
	public void check2mossa(int x,int y){

		//2 mossa
				if(! super.c.getMatrice()[x-2][y+1].getidgruppo().equals("B") ){ // può andare in questo cella solo se non c'è un suo pezzo alleato
					Point p =new Point(x-2,y+1);
					ls.add(p);
				}
	}
	
	public void check3mossa(int x,int y){

		//3 mossa
		if(! super.c.getMatrice()[x-1][y+2].getidgruppo().equals("B") && x-1>=0 && y+2<=7){ // può andare in questo cella solo se non c'è un suo pezzo alleato
			Point p =new Point(x-1,y+2);
			ls.add(p);
			}
	}
	public void check4mossa(int x,int y){

		//4 mossa
				if(! super.c.getMatrice()[x+1][y+2].getidgruppo().equals("B") ){ // può andare in questa cella solo se non c'è un suo pezzo alleato
					Point p =new Point(x+1,y+2);
					ls.add(p);
					}
	}
	
	
	public void check5mossa(int x,int y){

		//5 mossa
				if(! super.c.getMatrice()[x+2][y+1].getidgruppo().equals("B") ){ // può andare in questa cella solo se non c'è un suo pezzo alleato
					Point p =new Point(x+2,y+1);
					ls.add(p);
					}
	}
	public void check6mossa(int x,int y){

		//6 mossa
				if(! super.c.getMatrice()[x+2][y-1].getidgruppo().equals("B") ){ // può andare in questa cella solo se non c'è un suo pezzo alleato
					Point p =new Point(x+2,y-1);
					ls.add(p);
					}
	}
	public void check7mossa(int x,int y){

		//7 mossa
				if(! super.c.getMatrice()[x+1][y-2].getidgruppo().equals("B") ){ // può andare in questa cella solo se non c'è un suo pezzo alleato
					Point p =new Point(x+1,y-2);
					ls.add(p);
					}
	}
	public void check8mossa(int x,int y){


		//8 mossa
				if(! super.c.getMatrice()[x-1][y-2].getidgruppo().equals("B") ){ // può andare in questo cella solo se non c'è un suo pezzo alleato
					Point p =new Point(x-1,y-2);
					ls.add(p);
					}
	}
	
	public void setIcona(int riga,int colonna){
		JButton b=(JButton) ApplicationContext.diz.get((riga+colonna*8)+"");
		if((riga+colonna)%2==0){   // pari chiaro
		b.setIcon(new ImageIcon("CavalloB_sfC0000.jpg"));
		}
		else { // scuro
			b.setIcon(new ImageIcon("CavalloB_sf0000.jpg"));
		}
	}
	
	public void viewMosse(int x,int y){  // questo metodo mostra tutte le celle delle mosse possibili
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
		b.setBorder(BorderFactory.createLineBorder(Color.blue));
	}
	
	public ArrayList<Point> getPrivatels(){
		return this.ls;
	}
}





