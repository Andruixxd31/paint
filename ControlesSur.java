/*Andrés Díaz de León Valdés  A01620020
Angela Rodriguez Maldonado  A01636960
Programación orientada a Objetos Proyecto medio parcial
ControlesSur.java
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlesSur extends JPanel{

	private JButton btGuardar;
	private JButton btAbrir;
	private PanelFigura pf;
	public ControlesSur(PanelFigura pf) {
		super();
		this.setPreferredSize(new Dimension(400,100));
		this.btGuardar=new JButton("Guardar");
		this.btAbrir=new JButton("Abrir");
		this.pf=pf;
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		this.btGuardar.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					PrintWriter pw= new PrintWriter(new FileWriter("figuras.txt"));
					pw.println(pf);
					pw.close();
				} catch (IOException e1) {
				}
			}
		});
		this.add(btGuardar);

		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		this.btAbrir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedReader bf=new BufferedReader(new FileReader("figuras.txt"));
					String dato= bf.readLine();
					Figura[] figuritas=new Figura[30];
				
					int size=0;
					while(dato!=null) {
						
						StringTokenizer st = new StringTokenizer(dato,",");
						String fig = st.nextToken();
						while(st.hasMoreTokens()) {
							
							if(fig.equals("Elipse")) {
								figuritas[size++]=new Elipse(
									Integer.parseInt(st.nextToken()),
									Integer.parseInt(st.nextToken()), 
									Integer.parseInt(st.nextToken()),
									Integer.parseInt(st.nextToken()), 
									new Color(
										Integer.parseInt(st.nextToken()),
										Integer.parseInt(st.nextToken()),
										Integer.parseInt(st.nextToken())
									),
									Boolean.parseBoolean(st.nextToken())
								);
							}
							else if(fig.equals("Rectangulo")) {
								figuritas[size++]=new Rectangulo(
									Integer.parseInt(st.nextToken()),
									Integer.parseInt(st.nextToken()), 
									Integer.parseInt(st.nextToken()),
									Integer.parseInt(st.nextToken()),
									new Color(
										Integer.parseInt(st.nextToken()),
										Integer.parseInt(st.nextToken()),
										Integer.parseInt(st.nextToken())
									),
									Boolean.parseBoolean(st.nextToken())
								);
							}
							else if(fig.equals("Linea")) {
								figuritas[size++]=new Linea(
									Integer.parseInt(st.nextToken()),
									Integer.parseInt(st.nextToken()),
									Integer.parseInt(st.nextToken()),
									Integer.parseInt(st.nextToken()), 
									new Color(
										Integer.parseInt(st.nextToken()),
										Integer.parseInt(st.nextToken()),
										Integer.parseInt(st.nextToken())
									)
								);
							}
							else if(fig.equals("Texto")) {
								int x1=Integer.parseInt(st.nextToken());
								int y1=Integer.parseInt(st.nextToken());
								String texto=st.nextToken();
								String nombreFont=st.nextToken();
								int sizeF=Integer.parseInt(st.nextToken());
								Color color=new Color(
									Integer.parseInt(st.nextToken()),
									Integer.parseInt(st.nextToken()),
									Integer.parseInt(st.nextToken())
								);
								figuritas[size++]=new Texto(x1, y1, 0, 0, color, nombreFont, sizeF, texto);
							}else {
								st.nextToken();
							}
						}
						dato = bf.readLine();
					}
					pf.setFiguritas(figuritas);
					pf.setSize(size);
					bf.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			}
		});
		this.add(btAbrir);
	}
	
}