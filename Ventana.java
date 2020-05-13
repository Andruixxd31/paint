import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Ventana extends JFrame{
	
	public Ventana() {
		super("Paint");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Dispose on close no acaba el programa pero sigue programa que libere el objeto		
		PanelFigura pf = new PanelFigura();
		this.add(pf); //agregamos una instancia de mi panel dibujo en la venta
		this.add(new ControlesFigura(pf),BorderLayout.WEST); //se pasa pd para que controles trabaje con el panel dibujo que creamos
		this.add(new ControlesSur(pf),BorderLayout.SOUTH);
		this.pack();//Ella se ajusta a  los componentes que contiene
		this.setVisible(true);
	}
	
	public static void main(String args[]) {
		//mi ventana sea una ventana
		Ventana ventana = new Ventana();
	}
}