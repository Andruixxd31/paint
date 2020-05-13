import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class PanelFigura extends JPanel implements MouseListener, MouseMotionListener{

	private Figura[] figuritas;
	private Color color;
	private boolean relleno;
	

	private int x1,
				y1,
				x2,
				y2;
	private String texto;
	private String nombreFont;
	private String tipoF;
	private int size;
	private int sizeFont;
	private Figura figurita;
	public PanelFigura() {
		super();
		this.setPreferredSize(new Dimension(800,700));
		this.setBackground(Color.WHITE);
		this.figuritas=new Figura[30];
		this.color=Color.red;
		this.relleno= false;
		this.size=0;
		this.tipoF="Elipse";
		this.nombreFont="Arial";
		this.sizeFont=16;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.CrearFiguras(g);
		for(int i=0;i<this.size;i++) {
			figuritas[i].pinta(g);
		}
	}
	
	
	public void CrearFiguras(Graphics g) {
		
		if(this.tipoF=="Elipse") {
			this.figurita=new Elipse(this.x1, this.y1, this.x2, this.y2, this.color,this.relleno);
			
			this.figurita.pinta(g);
		}else if(this.tipoF=="Rectangulo") {
			this.figurita=new Rectangulo(this.x1, this.y1, this.x2, this.y2, this.color,this.relleno);

			figurita.pinta(g);
		}if(this.tipoF=="Linea") {
			this.figurita=new Linea(this.x1, this.y1, this.x2, this.y2, this.color);
			figurita.pinta(g);
		}if(this.tipoF=="Texto") {
			this.figurita=new Texto(this.x1, this.y1, this.x2, this.y2, this.color, this.nombreFont,this.sizeFont, this.texto);
			figurita.pinta(g);
		}
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		this.x1=e.getX();
		this.y1=e.getY();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		this.x2=e.getX();
		this.y2=e.getY();
		this.repaint();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		figuritas[this.size++]=this.figurita;
		//for(Figura tmp: this.figuritas)System.out.println(tmp);
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public Figura getFigurita() {
		return figurita;
	}

	public void setFigurita(Figura figurita) {
		this.figurita = figurita;
	}

	public void mouseMoved(MouseEvent e) {
		
	}

	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setRelleno(boolean relleno) {
		this.relleno = relleno;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setnombreFont(String font) {
		this.nombreFont = font;
	}

	public String getTipoF() {
		return tipoF;
	}

	public void setTipoF(String tipoF) {
		this.tipoF = tipoF;
	}

	public int getSizeFont() {
		return sizeFont;
	}

	public void setSizeFont(int sizeFont) {
		this.sizeFont = sizeFont;
		this.repaint();
	}
	public String toString() {
		String st="";
		for(Figura tmp: this.figuritas) {
			if(tmp!=null)st+=tmp+"\n";			
		}
		return st;
	}
	public void setFiguritas(Figura[] figuritas) {
		this.figuritas=figuritas;
		this.removeAll();
		this.repaint();
	}
}
