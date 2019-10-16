import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;


public  class Pezzo {  // Classe generale (MADRE)
	
	protected String id;  // Nome del pezzo
	protected String idgruppo; // ti dice se è bianco o nero
	protected ArrayList<Point>listamosse=new ArrayList<Point>();
	
	Campo c=(Campo) ApplicationContext.diz.get("campo");
	Controller cl= new Controller();
	public String getid() {
		return id;
		}
	public void Tostring(){
		System.out.print(id+" ");
	}

	public Pezzo getpezzo(){
		return this;
	}
	
	public String dimmichisei(){
		return null;
	}

	public boolean checkMossavalida(int xp , int yp,int xd,int yd){  // OVERRIDE 
		return false;
	}
	
	
	
	public void calcoloMossePossibili(int x ,int y){  // override
		
	}
	public String getidgruppo() {
		return this.idgruppo;
	}
	
	public void puliscilista(){  // ovverride
		this.listamosse.clear();
	}
	
	public ArrayList<Point> getListaMosse(){
		System.out.print("eccoti la lista"+this.listamosse);
		return this.listamosse;
		
	}
	
	public void setIcona(int riga,int colonna){  // override
		
		
	}
	
	public void viewMosse(int x,int y){}
	
	public void disegnaContorno(int x , int y){}
	
	public void removeview(){
		
		for(int i=0;i<8;i++){
			for(int k=0;k<8;k++){
				cancellaContorno(i, k);
		
			}
		}
	}
	public void cancellaContorno(int x , int y){
		JButton b=(JButton) ApplicationContext.diz.get((y+x*8)+"");
		b.setBorder(BorderFactory.createLineBorder(new Color(64,32,8)));
	
	}
	
	public ArrayList<Point> getPrivatels(){
		return null;
	}
	


	
}