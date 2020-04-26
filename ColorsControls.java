import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColorsControls extends JPanel implements MouseListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Canvas canvas;
    
    private JPanel redP, blueP, yellowP, greenP, orangeP, pinkP, whiteP, grayP, blackP;
    private JPanel colorsArray[] = {
        redP, blueP, yellowP, greenP, orangeP, pinkP, whiteP, grayP, blackP
    }; 

    private boolean buttonsArray[] = new boolean[5]; 

    //* --------------  Constructor --------------
    public ColorsControls(Canvas canvas) {
        super();
        this.setPreferredSize(new Dimension(145, 145));
        this.canvas = canvas;

        for(int i = 0; i < this.colorsArray.length; i++){ //Giving the same characteristics to all color panels
            this.colorsArray[i] = new JPanel();
            this.colorsArray[0].setBackground(Color.RED);
            this.colorsArray[i].setPreferredSize(new Dimension(40, 40));
            this.colorsArray[i].addMouseListener(this);
            this.add(colorsArray[i]);
        }

        this.colorsArray[0].setBackground(Color.RED);
        this.colorsArray[1].setBackground(Color.BLUE);
        this.colorsArray[2].setBackground(Color.YELLOW);
        this.colorsArray[3].setBackground(Color.GREEN);
        this.colorsArray[4].setBackground(Color.ORANGE);
        this.colorsArray[5].setBackground(Color.PINK);
        this.colorsArray[6].setBackground(Color.WHITE);
        this.colorsArray[7].setBackground(Color.GRAY);
        this.colorsArray[8].setBackground(Color.BLACK);
    }

    //* --------------  Methods --------------


    //*change state of buttons
    //*The next functions are fro activating the feature of the button selected
    public void setIsDrawSelected(){ 
        for(int i = 0; i < this.buttonsArray.length; i++){ 
            if(i == 0) this.buttonsArray[i] = true;
            else this.buttonsArray[i] = false; //deactivating the other buttons so only the selected will be used
        }
    }

    public void setIsReplaceSelected(){
        for(int i = 0; i < this.buttonsArray.length; i++){
            if(i == 1) this.buttonsArray[i] = true;
            else this.buttonsArray[i] = false; 
        }
    }

    public void setIsFigureSelected(){
        for(int i = 0; i < this.buttonsArray.length; i++){
            if(i == 2) this.buttonsArray[i] = true;
            else this.buttonsArray[i] = false;
        }
    }

    public void setIsTextSelected(){
        for(int i = 0; i < this.buttonsArray.length; i++){
            if(i == 3) this.buttonsArray[i] = true;
            else this.buttonsArray[i] = false;
        }
    }

    public void setIsClearSelected(){
        for(int i = 0; i < this.buttonsArray.length; i++){
            if(i == 4) this.buttonsArray[i] = true;
            else this.buttonsArray[i] = false;
        }
    }

    //* -------------- Listeners Methods --------------
    @Override
    public void mouseClicked(MouseEvent evt) {
        for(int i = 0; i < this.colorsArray.length; i++) { 
            if(evt.getSource() == this.colorsArray[i]){
                if(this.buttonsArray[0]) { //drawing
                    System.out.println("but 0");
                }
                else if (this.buttonsArray[1]) { //replacing background color
                    this.canvas.changeBackground(this.colorsArray[i].getBackground());
                }
                else if (this.buttonsArray[2]) { //painting a figure
                    System.out.println("but 2");
                }
                else if (this.buttonsArray[3]) { //inputing text
                    System.out.println("but 3");
                }
            }
        }
        if (this.buttonsArray[4]) { //clearing the canvas
            this.canvas.clearCanvas();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}