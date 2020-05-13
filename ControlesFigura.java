import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
public class ControlesFigura extends JPanel implements ActionListener{
	private JRadioButton rbElipse,
							rbRectangulo,
							rbLinea,
							rbTexto;
	private JCheckBox relleno;
	private JTextField tfTexto;
	private JPanel pColor;
	private JButton dibujar;
	private JSlider slider;
	private JComboBox fuentes;
	private PanelFigura pf;
	public ControlesFigura(PanelFigura pf) {
		super();
		this.setPreferredSize(new Dimension(220,700));
		
		this.pf=pf;
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
		
		this.dibujar=new JButton("Dibujar");
		this.dibujar.addActionListener(this);
		this.add(this.dibujar);
		
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
		this.fuentes=new JComboBox(fonts);
		this.fuentes.setSelectedIndex(14);
		this.add(this.fuentes);
		
		
	}
	
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
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
	
}
