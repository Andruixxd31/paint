//Andrés Díaz de León A01620020
//Angela Rodriguez A01636960

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ControlesFigura extends JPanel implements MouseListener,MouseMotionListener{

	// ------------------- Atributos -------------------
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

	// ------------------- Constructor -------------------
	public ControlesFigura(PanelFigura pf) {
		super();
		this.setPreferredSize(new Dimension(220,700));
		
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
			
			public void mouseClicked(MouseEvent e) {
				Color colorFigura= JColorChooser.showDialog(ControlesFigura.this, "Selecciona un color",pColor.getBackground());
				if(colorFigura == null){
					colorFigura = Color.BLACK;
				}
				pf.setColor(colorFigura);
				pColor.setBackground(colorFigura);
			}
			public void mousePressed(MouseEvent e) {		
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
		});
		
		
		this.slider= new JSlider(JSlider.VERTICAL, 8, 24, 16);
		this.slider.setMajorTickSpacing(8);
		this.slider.setMinorTickSpacing(4);
		this.slider.setPaintLabels(true);
		this.slider.setPaintTicks(true);
		this.slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				pf.setSizeFont(slider.getValue());
				
			}
		});
		
		this.add(this.slider);
		String fonts[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		this.fuentes= new JComboBox(fonts);
		this.fuentes.setSelectedIndex(14);
		this.add(this.fuentes);
		
		
	}
	
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	

	@Override
	public void mousePressed(MouseEvent e) {
		this.pf.setX1(e.getX());
		this.pf.setY1(e.getY());
		if(this.rbElipse.isSelected()) {
			this.pf.setTipoF("Elipse");
		}else if(this.rbRectangulo.isSelected()) {
			this.pf.setTipoF("Rectangulo");
		}else if(this.rbLinea.isSelected()) {
			this.pf.setTipoF("Linea");
		}else if(this.rbTexto.isSelected()) {
			this.pf.setTipoF("Texto");
			this.pf.setTexto(this.tfTexto.getText());
			this.pf.setnombreFont(""+this.fuentes.getSelectedItem());
		}
		if(this.relleno.isSelected()) {
			this.pf.setRelleno(true);
		}else {
			this.pf.setRelleno(false);
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		this.pf.setX2(e.getX());
		this.pf.setY2(e.getY());
		this.pf.repaint();
		this.pf.setSoltar(true);
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		this.pf.agregarFigura();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
