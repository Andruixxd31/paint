import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener {

    /**
     *
     */
    private static final long serialVersionUID = -7998564893114671669L;

    public Canvas() {
        super();
        this.setPreferredSize(new Dimension(800,600));
        this.setBackground(new Color(46,46,46));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }


    public void changeBackground(Color color){
        this.setBackground(color);
    }

    public void addText(Color color, String text){
        String newText = text;
        Graphics g;
        // this.paintText(g, text);
    }

    public void painText(String text){
        // g.drawString(text, (int)this.getWidth()/2, (int)this.getHeight()/2);
    }

    public void clearCanvas(){
        this.setBackground(new Color(46,46,46));
        this.removeAll();
        this.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

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
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
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