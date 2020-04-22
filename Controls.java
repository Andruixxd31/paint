import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Controls extends JPanel implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = -4072651522539715930L;

    //* -------------- Atributes  --------------
    private Canvas canvas;
    private Color colo;
    private JButton btClear, btDraw, btFigure, btReplace, btText;
    private JTextField tfText;
    private String text;
    private ColorsControls cc;
    

    //* -------------- Constructors --------------
    public Controls(Canvas canvas) {
        super();
        cc = new ColorsControls(canvas);
        this.setPreferredSize(new Dimension(800, 150));
        this.setBackground(Color.GRAY);
        this.canvas = canvas;

        this.btDraw = new JButton("Draw");
        this.btReplace = new JButton("Replace");
        this.btFigure = new JButton("Figure");
        this.btText = new JButton("Text");
        this.btClear = new JButton("Clear");

        this.tfText = new JTextField(10);

        // *adding listeners
        this.btDraw.addActionListener(this);
        this.btReplace.addActionListener(this);
        this.btFigure.addActionListener(this);
        this.btText.addActionListener(this);
        this.btClear.addActionListener(this);

        // *adding elements to the interface
        this.add(cc);
        this.add(btDraw);
        this.add(btReplace);
        this.add(btFigure);
        this.add(btText);
        this.add(tfText);
        this.add(btClear);
        
    }

    //* -------------- Getters and setters  --------------

    //* -------------- Listeners Methods --------------
    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == this.btClear){
            this.canvas.clearCanvas();
        }

        if(evt.getSource() == this.btReplace){
            this.cc.setIsReplaceSelected();
        }
    }
}