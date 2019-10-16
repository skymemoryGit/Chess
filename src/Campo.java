import java.awt.Color;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;





public class Campo {
	private Pezzo mat[][];
	private int xRestituzione;  // X del pedone quando arriva infondo. Questo paramentro viene poi mandato alla scelta box per Update!(diventerà un'regina/alfiere/t/c)
	private int yrestitutzione;  // y del pedone quando arriva infondo. anche questo viene spedito
	
	private ArrayList<Point>lsTutteMosseB=new ArrayList<Point>();  // in questa lista ci sono tutte le posizioni delle mosse di tutti i pezzi bianchi  (scopo: serve per determinare Scatto Re nero)
	private ArrayList<Point>lsTutteMosseN=new ArrayList<Point>();  // in questa lista ci sono tutte le posizioni delle mosse di tutti i pezzi neri  (scopo: serve per determinare Scatto Re bianco)
	
	//paramentri per Arrocco bianco
	private boolean MaimossoReB=true;
	private boolean MaimossoTorreBSx=true;
	
	//parametri per Arrocco Nero
	private boolean MaimossoTorreNSx=true;		
	private boolean MaimossoReN=true;
	private boolean MaimossoTorreNDx=true;
	
	//costruttore: matrice 8x8
	public Campo(){
		this.mat=new Pezzo[8][8];
		ApplicationContext.diz.put("campo",this);
	}
	
	//inizializzazione campo: 
	public void inizializzacampo(){
		
		//inizializzo le celle vuote
		for(int i=0;i!=8;i++){
			for(int k=0;k!=8;k++){
				Pezzo vuoto = new vuoto();
				mat[i][k]= vuoto;
			}
		}
		
		// posiziono tutti i pezzi da gioco
		Pezzo torre1N = new torreN();
		mat[0][0]=torre1N;
		
		Pezzo cavallo1N = new cavalloN();
		mat[0][1]=cavallo1N;
		
		Pezzo alfiere1N = new alfiereN();
		mat[0][2]=alfiere1N ;
		
		Pezzo reginaN = new reginaN();
		mat[0][3]=reginaN;		
		
		Pezzo reN = new reN();
		mat[0][4]=reN;		
		
		Pezzo alfiere2N = new alfiereN();
		mat[0][5]=alfiere2N ;
		
		Pezzo cavallo2N = new cavalloN();
		mat[0][6]=cavallo2N;
		
		Pezzo torre2N = new torreN();
		mat[0][7]=torre2N;
		
		//pedone
		for(int x=0;x!=8;x++){
			Pezzo pedina = new pedoneN();
			mat[1][x]=pedina;  // seconda riga
			}
		
		//BIANCO
		//pedone bianche
		for(int colonna=0;colonna!=8;colonna++){
			Pezzo pedoneB = new pedoneB();
			mat[6][colonna]=pedoneB;  // seconda riga
			}
		
		Pezzo torre1B = new torreB();
		mat[7][0]=torre1B;
		
		Pezzo cavallo1B = new cavalloB();
		mat[7][1]=cavallo1B;
		
		Pezzo alfiere1B = new alfiereB();
		mat[7][2]=alfiere1B ;
		
		Pezzo reginaB = new reginaB();
		mat[7][3]=reginaB;		
		
		Pezzo reB = new reB();
		mat[7][4]=reB;		
		
		Pezzo alfiere2B = new alfiereB(); 
		mat[7][5]=alfiere2B ; 
		
		Pezzo cavallo2B = new cavalloB();
		mat[7][6]=cavallo2B;
		
		Pezzo torre2B = new torreB();
		mat[7][7]=torre2B;
		
	
	}
	

	public void StampaMatrice(){
		for(int i=0;i!=8;i++){
			for(int k=0;k!=8;k++){
				mat[i][k].Tostring();;
				
			}
			System.out.print("\n");
			
		}
	}
	

	public Pezzo[][] getMatrice(){
		return this.mat;
	}
	
	public void spostapezzo(Pezzo p ,int xp,int yp,int xd,int yd ){  
		mat[xp][yp]=new vuoto();
		mat[xd][yd]=p;
		
		if(p.getid().equals("pedoneB") && xd==0){// dopo aver spostato il pezzo, controlla se il pedone è arrivato in fondo 
			SceltaBoxBianco sb = new SceltaBoxBianco();  // esce fuori il frame per la scelta
			setPointspecifico(xd, yd);  // prendo questo punto e  preparo la sua spedizione alla classe EventiSceltabox
		}
		
		if(p.getid().equals("pedoneN") && xd==7){// dopo aver spostato il pezzo, controlla se il pedone è arrivato in fondo 
			SceltaBoxNero sn = new SceltaBoxNero();  // esce fuori il frame per la scelta
			setPointspecifico(xd, yd);  // prendo questo punto e  preparo la sua spedizione alla classe EventiSceltabox
		}
		
		if(p.getid().equals("reB")){  // se è stato mosso il re
			this.MaimossoReB=false;
		}
		
		if(xp==7 && yp==0){  // se è stato mossa la torre
			this.MaimossoTorreBSx=false;
		}
		if(xp==0 && yp==0){
			this.MaimossoTorreNSx=false;
		}
		if(xp==0 && yp==4){
			this.MaimossoReN=false;
		}
		if(xp==0 && yp == 7){
			this.MaimossoTorreNDx=false;
		}
	}
	
	public void setPointspecifico(int x ,int y){ // set
		this.xRestituzione=x;
		this.yrestitutzione=y;
	}
	public Point returnPointSpecifico(){ // restituisce un punto specifico 
		Point p = new Point(this.xRestituzione,this.yrestitutzione);
		return p;
	}
	

	
	public void Creapezzo(int x,int y,String id){ // questo metodo crea un pezzo a scelta in una cella specifica
		if(id.equals("alfiereB")){
			this.mat[x][y]= new alfiereB();
		}
		if(id.equals("alfiereN")){
			this.mat[x][y]= new alfiereN();
		}
		if(id.equals("cavalloN")){
			this.mat[x][y]= new cavalloN();
		}
		if(id.equals("cavalloB")){
			this.mat[x][y]= new cavalloB();
		}
		if(id.equals("pedoneB")){
			this.mat[x][y]= new pedoneB();
		}
		if(id.equals("pedoneN")){
			this.mat[x][y]= new pedoneN();
		}
		if(id.equals("reginaB")){
			this.mat[x][y]= new reginaB();
		}
		if(id.equals("reginaN")){
			this.mat[x][y]= new reginaN();
		}
		if(id.equals("reN")){
			this.mat[x][y]= new reN();
		}
		if(id.equals("reB")){
			this.mat[x][y]= new reB();
		}
		if(id.equals("torreB")){
			this.mat[x][y]= new torreB();
		}
		if(id.equals("torreN")){
			this.mat[x][y]= new torreN();
		}
		if(id.equals("vuoto")){
			this.mat[x][y]= new vuoto();
		}
	}
	
	public void Salvare() { // questo metodo memorizza tutte  le posizioni dei pezzi, creando un file memoria.txt sul disco
		String StringaUnica="";
		for(int i=0;i<8;i++){
			for(int k=0;k<8;k++){
				StringaUnica=StringaUnica+this.getMatrice()[i][k].getid()+";";  // aggiungo alla stringa che contiene le posizioni in ordine
		
			}
		}
		
		//scrittura disco
		File file = new File("memoria.txt");  // creo il file memoria.txt
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(StringaUnica);
			fw.flush();
			fw.close();
			JOptionPane.showMessageDialog(null, "Il gioco è stato salvato.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void caricare() throws IOException{ // questo metodo carica la partita salvata  //FUNZIONA OH YES!!!
		ArrayList<String>ls =new ArrayList<String>();// in questa lista ci sono tutti i pezzi in ordine secondo il file Memoria.txt
		
		try {
			BufferedReader br = new BufferedReader(new FileReader ("memoria.txt"));  // carico il file memoria.txt
			String s =br.readLine();  // prendo tutto ii testo(è una riga sola)
			
			//split : separo ciascun elemento
			String campi[]=s.split(";");
			for(int i =0;i<campi.length;i++){
				ls.add(campi[i]);
			}
			
			//Caricare tutte le posizione dei pezzi secondo il file memoria
			
			int indice=0; 
			for(int i=0;i<8;i++){
				for(int k=0;k<8;k++){
					Creapezzo(i, k, ls.get(indice));
					indice++;
			
				}
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void IniTest(){
		for(int i=0;i!=8;i++){
			for(int k=0;k!=8;k++){
				Pezzo vuoto = new vuoto();
				this.mat[i][k]= vuoto;
			}
		}
		//Creapezzo(1, 0, "reginaB");
		Creapezzo(7, 1, "torreB");
		Creapezzo(0, 1, "reginaB");
		Creapezzo(6, 3, "reB");
		Creapezzo(5, 0, "reN");
	}
	
	//CONTROLLI PER LO SCACCO DA PARTE DEI BIANCHI
	public void checkTuttePosizioniB(){
		System.out.print("\nRichiamato il metodo checkTuttePosB");
		
		
		this.lsTutteMosseB.clear();
		
		for(int i=0;i!=8;i++){
			for(int k=0;k!=8;k++){
				if(this.mat[i][k].getidgruppo().equals("B")){  //solo i pezzi bianchi
						
						this.mat[i][k].calcoloMossePossibili(i, k); // per ogni pezzo calcola le celle in cui può andare
						
						for(Point p : this.mat[i][k].getPrivatels()){  // aggiungo tutte le  celle dalla lista private(restituita) alla lista lsTutteMosse
							
							if(! lsTutteMosseB.contains(p)){  // se non c'è ,aggiungi!
									this.lsTutteMosseB.add(p);
							}
						}
						
				}
			}
		}
	//	System.out.print("\nEcco la lista delle celle in cui i bianchi possono andare: \n" );
		//System.out.print(this.lsTutteMosseB);

		//decommentare sotto per vedere tutti le mosse dei bianchi sullo schermo
//		for(Point punto : this.lsTutteMosseB ){
//			disegnaContorno(punto.x, punto.y);  
//		}
		
	}
	
	//CONTROLLI PER LO SCATTO DA PARTE DEI NERI
	public void checkTuttePosizioniN(){
		System.out.print("\nRichiamato il metodo checkTuttePosN");
		
		
		this.lsTutteMosseN.clear();
		
		for(int i=0;i!=8;i++){
			for(int k=0;k!=8;k++){
				if(this.mat[i][k].getidgruppo().equals("N")){  //solo i pezzi neri
						
						this.mat[i][k].calcoloMossePossibili(i, k); // per ogni pezzo calcola le celle in cui può andare
						
						for(Point p : this.mat[i][k].getPrivatels()){  // aggiungo tutte le  celle dalla lista private(restituita) alla lista lsTutteMosse
							
							if(! lsTutteMosseN.contains(p)){  // se non c'è ,aggiungi!
									this.lsTutteMosseN.add(p);
							}
						}
						
				}
			}
		}
//		System.out.print("\nEcco la lista delle celle in cui i neri possono andare: \n" );
//		System.out.print(this.lsTutteMosseN);
		
//		for(Point punto : this.lsTutteMosseN ){
//			disegnaContorno(punto.x, punto.y);  
//		}
		
	}
	
//	public void disegnaContorno(int x , int y){  // disegna un contorno
//		JButton b=(JButton) ApplicationContext.diz.get((y+x*8)+"");
//		b.setBorder(BorderFactory.createLineBorder(Color.green));
//	}
	
	public ArrayList<Point> getTutteMosseBiancheLs(){ // restituisce la lista delle celle in cui i neri possono andare
		
		return this.lsTutteMosseB;
	}
	
	public ArrayList<Point> getTutteMosseNereLs(){  // restituisce la lista delle celle in cui i neri possono andare
		
		return this.lsTutteMosseN;
	}
	public void puliscilistaBianca(){
		this.lsTutteMosseB.clear();
	
	}
	public void puliscilistaNera(){
	this.lsTutteMosseN.clear();
	
	}
	
	public boolean PezzoEliminabile(int x,int y,String idsquadra){  // ti dice se il pezzo che si trova in xy è eliminaile
		
		
		//System.out.print("\n"+this.mat[x][y].id);
		Point p=new Point(x,y);
		
		if(idsquadra.equals("B")){  // se è un pezzo bianco
			this.lsTutteMosseN.clear();
			checkTuttePosizioniN();  // calcolo tutte le mosse dei neri
			for(Point punto: this.lsTutteMosseN){
				if(punto.equals(p)){  // se quel punto è eliminabile
					System.out.print("quel pezzo è eliminabile");
					return true;
				}
			}
			
		}
		
		if(idsquadra.equals("N")){  // se è un pezzo nero
			this.lsTutteMosseB.clear();
			checkTuttePosizioniB(); // calcolo tutte le mosse dei bianchi
			for(Point punto: this.lsTutteMosseB){
				if(punto.equals(p)){  // se quel punto è eliminabile
					System.out.print("quel pezzo è eliminabile");
					return true;
				}
			}
			
		}
		return false;
	}
	
	public boolean  checkArroccoBiancoSx(){
		System.out.print("\nRE "+this.MaimossoReB +"TorreSx "+this.MaimossoTorreBSx);
		
		boolean ris1=this.mat[7][1].getid().equals("vuoto");  //controlla se è vuoto
		boolean ris2=this.mat[7][2].getid().equals("vuoto");  //controlla se è vuoto
		boolean ris3=this.mat[7][3].getid().equals("vuoto");  //controlla se è vuoto
		
		if(this.MaimossoReB==true && this.MaimossoTorreBSx==true && ris1 && ris2 && ris3 ){  // se il re non è mai stato spostato e la torre pure e tra loro non ci sono pedoni,allora è possibile fare ARROCCO
			JButton b=(JButton) ApplicationContext.diz.get((2+7*8)+"");
			b.setBorder(BorderFactory.createLineBorder(Color.green));
			return true;
		}
		return false;
	}
	
	public void eseguiArroccoBiancoSx(){
		mat[7][0]=new vuoto();
		mat[7][4]= new vuoto();
		Creapezzo(7, 2, "reB");
		Creapezzo(7,3, "torreB");
	}
	
	public boolean  checkArroccoNeroSx(){
		System.out.print("\nRE "+this.MaimossoReB +"TorreSx "+this.MaimossoTorreBSx);
		
		boolean ris1=this.mat[0][1].getid().equals("vuoto");  //controlla se è vuoto
		boolean ris2=this.mat[0][2].getid().equals("vuoto");  //controlla se è vuoto
		boolean ris3=this.mat[0][3].getid().equals("vuoto");  //controlla se è vuoto
		
		if(this.MaimossoTorreNSx==true && this.MaimossoReN==true && ris1 && ris2 && ris3 ){  // se il re non è mai stato spostato e la torre pure e tra loro non ci sono pedoni,allora è possibile fare ARROCCO
			JButton b=(JButton) ApplicationContext.diz.get((2+7*8)+"");
			return true;
		}
		return false;
	}
	
	public void eseguiArroccoNeroSx(){
		mat[0][0]=new vuoto();
		mat[0][4]= new vuoto();
		Creapezzo(0, 2, "reN");
		Creapezzo(0,3, "torreN");
	}
	
	public boolean  checkArroccoNeroDx(){
		
		boolean ris1=this.mat[0][6].getid().equals("vuoto");  //controlla se è vuoto
		boolean ris2=this.mat[0][5].getid().equals("vuoto");  //controlla se è vuoto

		
		if(this.MaimossoTorreNDx==true && this.MaimossoReN==true && ris1 && ris2 ){  // se il re non è mai stato spostato e la torre pure e tra loro non ci sono pedoni,allora è possibile fare ARROCCO
			JButton b=(JButton) ApplicationContext.diz.get((2+7*8)+"");
			return true;
		}
		return false;
	}
	
	public void eseguiArroccoNeroDx(){
		mat[0][7]=new vuoto();
		mat[0][4]= new vuoto();
		Creapezzo(0, 6, "reN");
		Creapezzo(0,5, "torreN");
	}
}


