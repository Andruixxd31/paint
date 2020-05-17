/*Andrés Díaz de León Valdés  A01620020
Angela Rodriguez Maldonado  A01636960
Programación orientada a Objetos Proyecto medio parcial
Rectangulo.java
 */
import java.awt.Color;
import java.awt.Graphics;

public class Rectangulo extends Figura {

	public Rectangulo(int x1, int y1, int x2, int y2, Color color,boolean relleno) {
		super(x1, y1, x2, y2, color);
		this.relleno=relleno;
	}

	public void pinta(Graphics g) {
		g.setColor(this.color);
		if( (this.x2-this.x1)>0&&(this.y2-this.y1)>0) {
			if(relleno) {
				g.fillRect(this.x1, this.y1, (this.x2-this.x1), (this.y2-this.y1));
			}else {
				g.drawRect(this.x1, this.y1, (this.x2-this.x1), (this.y2-this.y1));
			}
		}
		
	}
	public String toString() {
		return ("Rectangulo,"+this.x1+","+this.y1+","+this.x2+","+this.y2+","+this.color.getRed()+","+this.color.getGreen()+","+this.color.getBlue()+","+this.relleno);
	}
}
