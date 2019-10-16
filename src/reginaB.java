import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class reginaB extends Pezzo {
	private ArrayList<Point>ls=new ArrayList<Point>();
	
	// costruttore : è una cella vuota
	public reginaB(){
		super.id="reginaB";  // prende id dalla classe madre
		super.idgruppo="B";
	}
	
	
	public String dimmichisei(){
		return "regina";
	}
	
	public ArrayList<Point> getlistmosse(){
		return this.ls;
	}
	
	
	public  void calcoloMossePossibili(int x, int y) {
		this.ls.clear(); 
		// La regina può essere considerata la fusione tra torre e alfiere
		
		// Tutte le mosse dell'alfiere
			//direzione destra top
			addPointDiagonaleDestraTop(x, y);
			// direzione sinistra down
			addPointDiagonaleSinistraDown(x, y);
			//direzione destra top
			addPointDiagonaleSinistraTop(x, y);
			// direzione destra down
			addPointDiagonaleDestraDown(x, y);
		
		// Tutte le mosse della torre
			//davanti
			addPointDavanti(x, y);
			//dietro
			addPointDietro(x, y);
			//destra
			addPointDestra(x, y);
			//sinistra
			addPointSinistra(x, y);
		//System.out.print("\n"+ls+" mossedisponibili "+ls.size());
	}
	
	public void addPointDiagonaleDestraTop(int x ,int y){  //x-- y++
		
		
		//escludo la posizione di partenza
		x=x-1;
		y=y+1;
		
		while(x!=-1 && y!=8  ){  // quando uno dei due parametri va fuori dal range
			
						// 3 casi di pedine che può incontrare
						if(super.c.getMatrice()[x][y].getid().equals("vuoto")){  // se è vuoto lo aggiungo alla lista
							Point p = new Point(x,y);
							ls.add(p);
						}
						
						if(super.c.getMatrice()[x][y].getidgruppo().equals("N")){  // se è nero(nemico), aggiungo alla lista(posso mangiarlo) però si ferma e non va inoltre
							Point p = new Point(x,y);
							ls.add(p);
							break;    // break
						}
						
						
						if(super.c.getMatrice()[x][y].getidgruppo().equals("B")){  //  3 caso,ovvero quando incontra una di pedina dello stesso gruppo , in tal caso non fa nulla
							break;  //break
						}
			x--;
			y++;
			
		}
	}
	
	
	public void addPointDiagonaleSinistraDown(int x ,int y){ // x++ y--
		
		
		//escludo la posizione di partenza
		x=x+1;
		y=y-1;
		
		while(y!=-1 && x!=8  ){  // quando uno dei due parametri va fuori dal range
			
						// 3 casi di pedine che può incontrare
						if(super.c.getMatrice()[x][y].getid().equals("vuoto")){  // se è vuoto lo aggiungo alla lista
							Point p = new Point(x,y);
							ls.add(p);
						}
						
						if(super.c.getMatrice()[x][y].getidgruppo().equals("N")){  // se è nero(nemico), aggiungo alla lista(posso mangiarlo) però si ferma e non va inoltre
							Point p = new Point(x,y);
							ls.add(p);
							break;    // break
						}
						
						
						if(super.c.getMatrice()[x][y].getidgruppo().equals("B")){  //  3 caso,ovvero quando incontra una di pedina dello stesso gruppo , in tal caso non fa nulla
							break;  //break
						}
			x++;
			y--;
			
		}
	}
	
	
	public void addPointDiagonaleSinistraTop(int x,int y){  // x-- y--
		
		//escludo la posizione di partenza
				x=x-1;
				y=y-1;
				
				while(y!=-1 && x!=-1  ){  // quando uno dei due parametri va fuori dal range
								// 3 casi di pedine che può incontrare
								if(super.c.getMatrice()[x][y].getid().equals("vuoto")){  // se è vuoto lo aggiungo alla lista
									Point p = new Point(x,y);
									ls.add(p);
								}
								
								if(super.c.getMatrice()[x][y].getidgruppo().equals("N")){  // se è nero(nemico), aggiungo alla lista(posso mangiarlo) però si ferma e non va inoltre
									Point p = new Point(x,y);
									ls.add(p);
									break;    // break
								}
								
								
								if(super.c.getMatrice()[x][y].getidgruppo().equals("B")){  //  3 caso,ovvero quando incontra una di pedina dello stesso gruppo , in tal caso non fa nulla
									break;  //break
								}
					x--;
					y--;
					
				}
	}
	
	public void addPointDiagonaleDestraDown(int x,int y){	//x++ y++

		
		//escludo la posizione di partenza
				x=x+1;
				y=y+1;
				
				while(y!=8 && x!=8  ){  // quando uno dei due parametri va fuori dal range
								// 3 casi di pedine che può incontrare
								if(super.c.getMatrice()[x][y].getid().equals("vuoto")){  // se è vuoto lo aggiungo alla lista
									Point p = new Point(x,y);
									ls.add(p);
								}
								
								if(super.c.getMatrice()[x][y].getidgruppo().equals("N")){  // se è nero(nemico), aggiungo alla lista(posso mangiarlo) però si ferma e non va inoltre
									Point p = new Point(x,y);
									ls.add(p);
									break;    // break
								}
								
								
								if(super.c.getMatrice()[x][y].getidgruppo().equals("B")){  //  3 caso,ovvero quando incontra una di pedina dello stesso gruppo , in tal caso non fa nulla
									break;  //break
								}
					x++;
					y++;
					
				}
	}
	
	
	public void addPointDavanti(int x,int y){ // aggiunge tuttei le celle davanti  alla lista

		x=x-1; //escludo il punto di partenza
		while(x!=-1){  // finchè non va fuori dal range
			
			// 3 casi di pedine che puo incontrare
			if(super.c.getMatrice()[x][y].getid().equals("vuoto")){  // se è vuoto lo aggiungo alla lista
				Point p = new Point(x,y);
				ls.add(p);
			}
			
			if(super.c.getMatrice()[x][y].getidgruppo().equals("N")){  // se è nero(nemico), aggiungo alla lista(posso mangiarlo) però si ferma e non va inoltre
				Point p = new Point(x,y);
				ls.add(p);
				break;    // break
			}
			
			
			if(super.c.getMatrice()[x][y].getidgruppo().equals("B")){  //  3 caso,ovvero quando incontra una di pedina dello stesso gruppo , in tal caso non fa nulla
				break;  //break
			}
			
			x--; // 
			
		}
		
	}
	
	
	public void addPointDietro(int x,int y){ // aggiunge tutte le celle dietro lista
		x=x+1; //escludo il punto di partenza
		while(x!=8){  // finche non va fuori dal range
			
			// 2 casi di pedine che puo incontrare()
			if(super.c.getMatrice()[x][y].getid().equals("vuoto")){  // se è vuoto lo aggiungo alla lista
				Point p = new Point(x,y);
				ls.add(p);
			}
			
			if(super.c.getMatrice()[x][y].getidgruppo().equals("N")){  // se è nero(nemico), aggiungo alla lista(posso mangiarlo), però si ferma e non va inoltre
				Point p = new Point(x,y);
				ls.add(p);
				break;    // break
			}
			
			if(super.c.getMatrice()[x][y].getidgruppo().equals("B")){  //  3 caso,ovvero quando incontra una di pedina dello stesso gruppo , in tal caso non fa nulla
				break;  //break
			}
			
			x++; // 
			
		}
		
	}
	
	
	
	public void addPointDestra(int x,int y){ // aggiunge tutte le celle destra alla lista
		 y=y+1;  // escludo la posizione di partenza
		while(y!=8){  // finchè non va fuori dal range
				
				// 3 casi di pedine che può incontrare
				if(super.c.getMatrice()[x][y].getid().equals("vuoto")){  // se è vuoto lo aggiungo alla lista
					Point p = new Point(x,y);
					ls.add(p);
				}
				
				if(super.c.getMatrice()[x][y].getidgruppo().equals("N")){  // se è nero(nemico), aggiungo alla lista(posso mangiarlo), però si ferma e non va inoltre
					Point p = new Point(x,y);
					ls.add(p);
					break;    // break
				}
				
				if(super.c.getMatrice()[x][y].getidgruppo().equals("B")){  //  3 caso,ovvero quando incontra una di pedina dello stesso gruppo , in tal caso non fa nulla
					break;  //break
				}
				
				y++; // 
			
		}
		
		}
	
	
	
	public void addPointSinistra(int x,int y){ // aggiunge tutte le celle sinistra alla lista
		 y=y-1;  // escludo la posizione di partenza
		while(y!=-1){  // finchè non va fuori dal range
			
			// 3 tipi di casi di pedine che può incontrare
			if(super.c.getMatrice()[x][y].getid().equals("vuoto")){  // se è vuoto lo aggiungo alla lista
				Point p = new Point(x,y);
				ls.add(p);
			}
			
			if(super.c.getMatrice()[x][y].getidgruppo().equals("N")){  // se è nero(nemico), aggiungo alla lista(posso mangiarlo), però si ferma e non va inoltre
				Point p = new Point(x,y);
				ls.add(p);
				break;    // break
			}
			
			if(super.c.getMatrice()[x][y].getidgruppo().equals("B")){  //  3 caso,ovvero quando incontra una di pedina dello stesso gruppo , in tal caso non fa nulla
				break;  //break
			}
			
			y--; // 
			
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
		b.setIcon(new ImageIcon("ReginaB_sc0000.jpg"));
		}
		else { // scuro
			b.setIcon(new ImageIcon("regina_sfscuro0000.jpg"));
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


