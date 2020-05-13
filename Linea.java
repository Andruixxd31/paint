import java.awt.Color;
import java.awt.Graphics;

public class Linea extends Figura {

	public Linea(int x1, int y1, int x2, int y2, Color color) {
		super(x1, y1, x2, y2, color);
		
	}

	public void pinta(Graphics g) {
		g.setColor(this.color);
		g.drawLine(this.x1, this.y1, this.x2, this.y2);
	}
	public String toString() {
		return ("Linea,"+this.x1+","+this.y1+","+this.x2+","+this.y2+","+this.color.getRed()+","+this.color.getGreen()+","+this.color.getBlue());
	}
}
