/*Andrés Díaz de León Valdés  A01620020
Angela Rodriguez Maldonado  A01636960
Programación orientada a Objetos Proyecto medio parcial
PanelFigura.java
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class PanelFigura extends JPanel {

	private Figura[] figuritas;
	

	private int size;
	private Figura figurita;
	public PanelFigura() {
		super();
		this.setPreferredSize(new Dimension(800,700));
		this.setBackground(Color.WHITE);
		this.figuritas=new Figura[30];
		this.size=0;
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i=0;i<this.size;i++) {
			System.out.println("oa");
			figuritas[i].pinta(g);
		}
	}
	

	public void agregarFigura(Graphics g) {
	//	this.figuritas[size].pinta(g);
	}

	public void setSize(int size) {
		this.size=size;
	}
	

	public void setFigurita(Figura figurita) {
		this.figurita = figurita;
		
		this.figuritas[this.size++]=figurita;
		this.repaint();
		
		
		
	}
	public void setFiguritas(Figura[] figuritas) {
		
		this.repaint();
		this.figuritas=figuritas;
		
	}


	public void setX2(int x2) {
		if(this.figuritas[(size-1)]!=null) {
			System.out.println("set");
			this.figuritas[(size-1)].setX2(x2); 
		}
		
	}

	public void setY2(int y2) {
		if(this.figuritas[(size-1)]!=null) {
			this.figuritas[(size-1)].setY2(y2); 
		}
	}

	public String toString() {
		String st="";
		for(Figura tmp: this.figuritas) {
			if(tmp!=null)st+=tmp+"\n";			
		}
		return st+"null";
	}
	
}
