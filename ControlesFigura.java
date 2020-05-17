/*Andrés Díaz de León Valdés  A01620020
Angela Rodriguez Maldonado  A01636960
Programación orientada a Objetos Proyecto medio parcial
ControlesFigura.java
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.GraphicsEnvironment;
public class ControlesFigura extends JPanel implements MouseListener,MouseMotionListener{
	private JRadioButton rbElipse,
							rbRectangulo,
							rbLinea,
							rbTexto;
	private JCheckBox relleno;
	private JTextField tfTexto;
	private JPanel pColor;
	private JSlider slider;
	private JComboBox fuentes;
	private PanelFigura pf;
	private Figura figurita;
	private Color color;
	private int tamañoFont;
	public ControlesFigura(PanelFigura pf) {
		super();
		this.setPreferredSize(new Dimension(220,700));
		this.tamañoFont=16;
		this.color=Color.RED;
		this.pf=pf;
		this.pf.addMouseListener(this);
		this.pf.addMouseMotionListener(this);
		
		this.rbElipse=new JRadioButton("Elipse",true);
		this.rbRectangulo=new JRadioButton("Rectangulo");
		this.rbLinea=new JRadioButton("Linea");
		this.rbTexto=new JRadioButton("Texto");
		ButtonGroup bg= new ButtonGroup();
		bg.add(this.rbElipse);
		bg.add(this.rbRectangulo);
		bg.add(this.rbLinea);
		bg.add(this.rbTexto);
		this.add(this.rbElipse);
		this.add(this.rbRectangulo);
		this.add(this.rbLinea);
		this.add(this.rbTexto);
		
		
		this.relleno=new JCheckBox("         Relleno            ",false);
		this.add(this.relleno);
		this.add(new JLabel("         TEXTO          "));
		this.tfTexto=new JTextField(10);
		this.add(tfTexto);
		
		this.add(new JLabel("        COLOR        "));
		this.pColor= new JPanel();
		
		this.pColor.setBackground(Color.RED);
		this.pColor.setVisible(true);
		this.add(this.pColor);
		this.pColor.setPreferredSize(new Dimension(60,60));
		
		this.pColor.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
					public void mouseClicked(MouseEvent e) {
									Color tmpColor = pColor.getBackground();
									color= JColorChooser.showDialog(ControlesFigura.this, "Selecciona un color",pColor.getBackground());
									if(color == null){
										color = tmpColor;
									}
									pColor.setBackground(color);
								}
		});
		
		
		this.slider= new JSlider(JSlider.VERTICAL, 8, 24, 16);
		this.slider.setMajorTickSpacing(8);
		this.slider.setMinorTickSpacing(4);
		this.slider.setPaintLabels(true);
		this.slider.setPaintTicks(true);
		this.slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				tamañoFont=slider.getValue();
				
			}

		});
		
		this.add(this.slider);
		String fonts[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		this.fuentes=new JComboBox(fonts);
		this.fuentes.setSelectedIndex(14);
		this.add(this.fuentes);
		
		
	}
	
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	

	@Override
	public void mousePressed(MouseEvent e) {
		
		if(this.rbElipse.isSelected()) {
			this.figurita= new Elipse(e.getX(), e.getY(), e.getX(), e.getY(), this.color,false);
			
			
		}else if(this.rbRectangulo.isSelected()) {
			
			this.figurita=new Rectangulo(e.getX(), e.getY(), e.getX(), e.getY(), this.color,false);
		
		}else if(this.rbLinea.isSelected()) {
			this.figurita=new Linea(e.getX(), e.getY(), e.getX(), e.getY(), this.color);
			
		}else if(this.rbTexto.isSelected()) {
			this.figurita=new Texto(e.getX(), e.getY(), e.getX(), e.getY(), this.color,(""+this.fuentes.getSelectedItem()),this.tamañoFont, this.tfTexto.getText());
		}
		if(this.relleno.isSelected()) {
			this.figurita.setRelleno(true);
		}else {
			this.figurita.setRelleno(false);
		}
		this.pf.setFigurita(this.figurita);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		this.pf.setX2(e.getX());
		this.pf.setY2(e.getY());
		this.pf.repaint();
		
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	public void mouseClicked(MouseEvent e) {
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	public Figura getFigurita() {
		return this.figurita;
	}
		
}
