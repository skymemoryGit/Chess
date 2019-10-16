import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class pedoneB extends Pezzo {
	private ArrayList<Point>ls=new ArrayList<Point>();
	
	// costruttore : è una cella vuota
	public pedoneB(){
		super.id="pedoneB";  // prende id dalla classe madre
		super.idgruppo="B";
	}
	
	
	public String dimmichisei(){
		return "pedoneBianco";
	}
	
	

	public void calcoloMossePossibili(int x ,int y){  // mosse possibli del pedone
		this.ls.clear(); 
		
	
		
		if(x==6){ //ps: Qui ho fatto copia-incolla da quello sotto :P e ho aggiunto solo controllo della  2 cella davanti se è  vuota o no
					if(y-1<0){// caso speciale: angolo sx
							if(!super.c.getMatrice()[x-1][y+1].getid().equals("vuoto")&& super.c.getMatrice()[x-1][y+1].getidgruppo().equals("N")) {  // puo mangiare in diagonale dx
								Point p =new Point(x-1,y+1);																								//ovviamente solo le pedine nemiche nere				
								ls.add(p);	
								super.listamosse.add(p);
								}
							if(super.c.getMatrice()[x-1][y].getid().equals("vuoto")){ // controlla che la  cella davanti sia vuota
								Point p =new Point(x-1,y);
								ls.add(p);
								super.listamosse.add(p);
							}
							if(super.c.getMatrice()[x-2][y].getid().equals("vuoto")){ // controlla che la  2 cella davanti sia vuota
								Point p =new Point(x-2,y);
								ls.add(p);
								super.listamosse.add(p);
							}
							
					}	
					
					
					if(y+1>7){// caso speciale: angolo dx
							if(super.c.getMatrice()[x-1][y].getid().equals("vuoto")){ // controlla che la  cella davanti sia vuota
								Point p =new Point(x-1,y);
								ls.add(p);
								super.listamosse.add(p);
							}
							if(!super.c.getMatrice()[x-1][y-1].getid().equals("vuoto") && super.c.getMatrice()[x-1][y-1].getidgruppo().equals("N")){  // puo mangiare in diagonale sx
								Point p =new Point(x-1,y-1);
								ls.add(p);
								super.listamosse.add(p);
							}
							if(super.c.getMatrice()[x-2][y].getid().equals("vuoto")){ // controlla che la   2 cella davanti sia vuota
								Point p =new Point(x-2,y);
								ls.add(p);
								super.listamosse.add(p);
							}
					}
					
					
					if(y+1<=7 && y-1>=0){ 
							if(super.c.getMatrice()[x-1][y].getid().equals("vuoto")){ // controlla che la  cella davanti sia vuota
								Point p =new Point(x-1,y);
								ls.add(p);
								super.listamosse.add(p);
							}
							if(!super.c.getMatrice()[x-1][y-1].getid().equals("vuoto") && super.c.getMatrice()[x-1][y-1].getidgruppo().equals("N")){  // puo mangiare in diagonale sx
								Point p =new Point(x-1,y-1);
								ls.add(p);
								super.listamosse.add(p);
							}
							if(!super.c.getMatrice()[x-1][y+1].getid().equals("vuoto")&& super.c.getMatrice()[x-1][y+1].getidgruppo().equals("N")) {  // puo mangiare in diagonale dx
								Point p =new Point(x-1,y+1);																								//ovviamente solo le pedine nemiche nere				
								ls.add(p);
								super.listamosse.add(p);
								}
							if(super.c.getMatrice()[x-2][y].getid().equals("vuoto")){ // controlla che la  2 cella davanti sia vuota
								Point p =new Point(x-2,y);
								ls.add(p);
								super.listamosse.add(p);
							}
					}
		}
		
		
		if(x==0){ // ultima riga
			System.out.print("Pedone infondo!! LvUp! ");
			
		}
		
	
		
		
		if(x!=6 && x!=0){ //tutti altri casi escluso ultima riga e la riga di partenza
			if(y-1<0){// caso speciale: angolo sx
					if(!super.c.getMatrice()[x-1][y+1].getid().equals("vuoto")&& super.c.getMatrice()[x-1][y+1].getidgruppo().equals("N")) {  // puo mangiare in diagonale dx
						Point p =new Point(x-1,y+1);																								//ovviamente solo le pedine nemiche nere				
						ls.add(p);	
						super.listamosse.add(p);
						}
					if(super.c.getMatrice()[x-1][y].getid().equals("vuoto")){ // controlla che la  cella davanti sia vuota
						Point p =new Point(x-1,y);
						ls.add(p);
						super.listamosse.add(p);
					}
			}	
			
			
			if(y+1>7){// caso speciale: angolo dx
					if(super.c.getMatrice()[x-1][y].getid().equals("vuoto")){ // controlla che la  cella davanti sia vuota
						Point p =new Point(x-1,y);
						ls.add(p);
						super.listamosse.add(p);
					}
					if(!super.c.getMatrice()[x-1][y-1].getid().equals("vuoto") && super.c.getMatrice()[x-1][y-1].getidgruppo().equals("N")){  // puo mangiare in diagonale sx
						Point p =new Point(x-1,y-1);
						ls.add(p);
						super.listamosse.add(p);
					}
			}
			
			
			if(y+1<=7 && y-1>=0){ 
					
					if(super.c.getMatrice()[x-1][y].getid().equals("vuoto")){ // controlla che la  cella davanti sia vuota
						Point p =new Point(x-1,y);
						ls.add(p);
						super.listamosse.add(p);
					}
					if(!super.c.getMatrice()[x-1][y-1].getid().equals("vuoto") && super.c.getMatrice()[x-1][y-1].getidgruppo().equals("N")){  // puo mangiare in diagonale sx
						Point p =new Point(x-1,y-1);
						ls.add(p);
						super.listamosse.add(p);
					}
					if(!super.c.getMatrice()[x-1][y+1].getid().equals("vuoto")&& super.c.getMatrice()[x-1][y+1].getidgruppo().equals("N")) {  // puo mangiare in diagonale dx
						Point p =new Point(x-1,y+1);																								//ovviamente solo le pedine nemiche nere				
						ls.add(p);	
						super.listamosse.add(p);
						}
					//controllo arriva infondo
					
			}
	}
		
		
		
		//System.out.print("\n questa è la lista privata"+ls+" Numero mosse Disponibili:"+ls.size());
	}
	
	
	
	public ArrayList<Point> getlistmosse(){
		return this.ls;
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
		b.setIcon(new ImageIcon("pedoneB_sullo_sfondochiaro.jpg"));
		}
		else { // scuro
			b.setIcon(new ImageIcon("pedoneB_sullo_sfondoscuro.jpg"));
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


