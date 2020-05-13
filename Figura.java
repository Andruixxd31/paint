import java.awt.Color;
import java.awt.Graphics;

public abstract class Figura {
	protected Color color;
	protected int x1,
				y1,
				x2,
				y2;
	protected boolean relleno;
	
	public Figura(int x1,int y1,int x2,int y2,Color color) {
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		this.color=color;
	}
	public abstract void pinta(Graphics g);
	
	public Color getColor() {
		return this.color;
	}
	public int getX1() {
		return this.x1;
	}
	public int getY1() {
		return this.x1;
	}
	public int getX2() {
		return this.x1;
	}
	public int getY2() {
		return this.x1;
	}
	public boolean relleno() {
		return this.relleno;
				
	}
	public void setRelleno(boolean relleno) {
		this.relleno=relleno;
	}
	
}
