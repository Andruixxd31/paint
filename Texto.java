/*Andrés Díaz de León Valdés  A01620020
Angela Rodriguez Maldonado  A01636960
Programación orientada a Objetos Proyecto medio parcial
Texto.java
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Texto extends Figura {

	private String nombreFont;
	private String texto;
	private int sizeFont;
	public Texto(int x1, int y1, int x2, int y2, Color color) {
		super(x1, y1, x2, y2, color);
		
	}
	public Texto(int x1, int y1, int x2, int y2, Color color,String nombreFont,int sizeFont,String texto) {
		super(x1, y1, x2, y2, color);
		this.texto=texto;
		this.nombreFont=nombreFont;
		this.sizeFont=sizeFont;
	}

	public void pinta(Graphics g) {
		Font font=new Font(this.nombreFont, Font.PLAIN, this.sizeFont); 
		g.setFont(font);
		
		g.setColor(this.color);
		g.drawString(this.texto, this.x1, this.y1);
	}
	
	public String getTexto() {
		return this.texto;
	}
	public String toString() {
		return ("Texto,"+this.x1+","+this.y1+","+this.texto+","+this.nombreFont+","+this.sizeFont+","+this.color.getRed()+","+this.color.getGreen()+","+this.color.getBlue());
	}
}
