import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class Eventi implements ActionListener {
	private int selezionatoreClick=1;
	private int xpartenza;
	private int ypartenza;
	private int xtmp;  // variabile temporanea
	private int ytmp;  // variabile temporanea
	private int xarrivo;
	private int yarrivo;
	private boolean turno=true;  //  (il turno bianco è indicato con true ; il turno nero con false), il bianco inizia per primo.

	private boolean Playing=true;   // start game
	private Pezzo pstart;
	
	Campo c=(Campo) ApplicationContext.diz.get("campo");
	Controller cl= new Controller();
	
	@Override
	public void actionPerformed(ActionEvent ev) {
	ApplicationContext.diz.put("eventi",this);
	
	if(Playing==true){  // inizio partita
		
		if(this.selezionatoreClick%2!=0){  //primo click
			//c.checkArrocco();
			this.xpartenza=Integer.parseInt(ev.getActionCommand())/8;
			this.ypartenza=Integer.parseInt(ev.getActionCommand())%8;
				
			this.xtmp=xpartenza;
			this.ytmp=ypartenza;
			
			pstart = c.getMatrice()[this.xtmp][this.ytmp].getpezzo();
			//System.out.print("\nidentificato il pezzo: "+pstart.id+"["+this.xtmp+";"+this.ytmp+"]");
			
			pstart.viewMosse(this.xtmp,this.ytmp);//visualizza le tutte le mosse sullo schermo
			cl.cambiastato();
			
			
			}
		
		if(this.selezionatoreClick%2==0){  //secondo click
			pstart.removeview();  // cancella le mosse sullo schermo
			cl.cambiastato();
		
			
			
			this.xarrivo=Integer.parseInt(ev.getActionCommand())/8;
			this.yarrivo=Integer.parseInt(ev.getActionCommand())%8;
			//System.out.print("\n"+xtmp+";"+ytmp+"\n"+xarrivo+";"+yarrivo);
			
			
			
			if(this.turno==true){ // turno bianco
			System.out.print("\nTurno Bianco");
			
			//studia il pezzo
			
			Pezzo Pezzoselezionato=c.getMatrice()[this.xtmp][this.ytmp].getpezzo(); // prende il pezzo selezionato
			
			if(c.checkArroccoBiancoSx()==true){
				if(JOptionPane.showConfirmDialog(null, "Vuoi eseguire l' arrocco?")==0){
					c.eseguiArroccoBiancoSx();
					this.turno=!turno;  // cambio turno
					cl.cambiastato();
				}
			}
			
			if(c.checkArroccoNeroSx()==true){
				if(JOptionPane.showConfirmDialog(null, "Vuoi eseguire l' arrocco?")==0){
					c.eseguiArroccoNeroSx();
					this.turno=!turno;  // cambio turno
					cl.cambiastato();
				}
			}
			
			if(c.checkArroccoNeroDx()==true){
				if(JOptionPane.showConfirmDialog(null, "Vuoi eseguire l' arrocco?")==0){
					c.eseguiArroccoNeroDx();
					this.turno=!turno;  // cambio turno
					cl.cambiastato();
				}
			}
			
			
			boolean ris=Pezzoselezionato.checkMossavalida(this.xtmp, this.ytmp, this.xarrivo, this.yarrivo);
			
			if( ris==true && Pezzoselezionato.getidgruppo().equals("B")){ //mossa valida
				
					c.spostapezzo(Pezzoselezionato, xtmp, ytmp, xarrivo, yarrivo);
					
					cl.cambiastato();
					
					CheckReNeroPericolo();   // re nero è nemico
					//CheckScaccoMattoReNero();
					
					
					
					
					if(checkReNeroisAlive()==false){
						JOptionPane.showMessageDialog(null,"Game Over! Victory Bianco");
						Playing=false;  // fine partita
						
					}
					
					
					
				
					
					turno=!turno;  // cambio turno
					}
					else {
					//JOptionPane.showMessageDialog(null,"Mossa non valida,Sbarbatello!");
			}
			
			
			
			}
			
			else {// è il turno nero
				System.out.print("Turno Nero");
				//studia il pezzo
				Pezzo Pezzoselezionato=c.getMatrice()[this.xtmp][this.ytmp].getpezzo(); // prende il pezzo selezionato
				boolean ris=Pezzoselezionato.checkMossavalida(this.xtmp, this.ytmp, this.xarrivo, this.yarrivo);
				
				if( ris==true && Pezzoselezionato.getidgruppo().equals("N")){ //mossa valida
						c.spostapezzo(Pezzoselezionato, xtmp, ytmp, xarrivo, yarrivo);
						//JOptionPane.showMessageDialog(null, "\n\n il pezzo selezionato è "+c.PezzoEliminabile(this.xarrivo, this.yarrivo, "N"));
						CheckReBiancoPericolo();  // re bianco è nemico
						cl.cambiastato();
						
						if(checkReBiancoisAlive()==false){
							JOptionPane.showMessageDialog(null,"Game Over! Victory Nero");
							Playing=false;  // fine partita
						}
						
						
						turno=!turno;  // cambio turno
						}
						else {
						//JOptionPane.showMessageDialog(null,"Mossa non valida,Sbarbatello!");
				}
				
			}
		}
		
		this.selezionatoreClick++;
		
	}// parentesi del while(playing)
	
	}//parentesi actionPerformed
	
	
	
	

	
	//Sottoprogrammi
	
	public void setParamentriDefaul(){  // serve per inizializzare una nuova partita
		this.Playing=true;
		selezionatoreClick=1;
		this.turno=true;
	}
	public Point GetPosiozioneReN(){  // trova la posizione in cui c'e re NERO
	
		for(int i=0;i!=8;i++){
			for(int k=0;k!=8;k++){
				if(c.getMatrice()[i][k].id.equals("reN")){
					Point p = new Point(i,k);
					return p;
				}
			}
		}
		return null;
	}

	public Point GetPosiozioneReB(){  // trova la posizione in cui c'e re Bianco
		
		for(int i=0;i!=8;i++){
			for(int k=0;k!=8;k++){
				if(c.getMatrice()[i][k].id.equals("reB")){
					Point p = new Point(i,k);
					return p;
				}
			}
		}
		return null;
	}
	
	public boolean CheckReNeroPericolo(){
		c.puliscilistaBianca();
		c.checkTuttePosizioniB();  // trova tutte le celle in cui i pezzi bianchi possono andare
		for(Point p : c.getTutteMosseBiancheLs()){
			if(p.equals(GetPosiozioneReN())){
				
				viewPericolo(p.x, p.y);
				return true;
				
			}
		}
		return false;
		
		
	}
	
	public boolean CheckReBiancoPericolo(){
		c.puliscilistaNera();
		c.checkTuttePosizioniN();  // trova tutte le celle in cui i pezzi Neri possono andare
		for(Point p : c.getTutteMosseNereLs()){
			if(p.equals(GetPosiozioneReB())){
				
				viewPericolo(p.x, p.y);
				return true;
				
			}
		}
		return false;
		
		
	}
	
	public void viewPericolo(int x,int y){ // questo metodo mostra un contorno rosso quando il re è sotto scatto

		JButton b=(JButton) ApplicationContext.diz.get((y+x*8)+"");
		b.setBorder(BorderFactory.createLineBorder(Color.red));
		cl.cambiastato();
	}
	
	public void CheckScaccoMattoReNero(){  // (Non completata)
		
//		Point PointRe= GetPosiozioneReN();  // le coordinate del re 
//		this.c.getMatrice()[PointRe.x][PointRe.y].calcoloMossePossibili(PointRe.x, PointRe.y);  // calcola le mosse del re
//		
//		boolean ris=this.c.getMatrice()[PointRe.x][PointRe.y].getPrivatels().isEmpty();  //controlla se la sua lista delle mosse è vuota
//		boolean ris2=CheckReNeroPericolo(); // controlla se è sotto "Minaccia"
//		
//		//JOptionPane.showMessageDialog(null,"coordinate"+this.xarrivo+";"+ this.yarrivo+ " id :"+c.getMatrice()[this.xarrivo][this.yarrivo].idgruppo);
//		boolean ris3= c.PezzoEliminabile(this.xarrivo, this.yarrivo, c.getMatrice()[this.xarrivo][this.yarrivo].idgruppo);  // questo metodo ti dice se l'ultimo pezzo mosso è eliminabile dall'avversario o no
//		
//		System.out.print("\nnessuna mossa "+ris+";"+"in pericolo "+ris2+";"+"pezzo minacciatore  eliminabile  "+ris3);
//		if(ris==true && ris2==true && ris3==false){  // quando queste 3 condizioni vengono soddisfate ,allora è SCacco MATTO!!!!!
//			JOptionPane.showMessageDialog(null, "Scacco matto");
//		}
		
		
		
		
	}
	
	public boolean checkReNeroisAlive(){  // controlla se re nero è ancora vivo

		for(int i=0;i!=8;i++){
			for(int k=0;k!=8;k++){
					if(c.getMatrice()[i][k].getid().equals("reN")){
						return true;
					}
				
			}
		}
		return false;
	}
	
	public boolean checkReBiancoisAlive(){  // controlla se re nero è ancora vivo

		for(int i=0;i!=8;i++){
			for(int k=0;k!=8;k++){
					if(c.getMatrice()[i][k].getid().equals("reB")){
						return true;
					}
				
			}
		}
		return false;
	}
	
	
	
}


