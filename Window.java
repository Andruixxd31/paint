import java.awt.*;
import javax.swing.*;

public class Window extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Window() {
        super("Paint");
        Canvas canvas = new Canvas();
        this.add(canvas);
        this.add(new Controls(canvas), BorderLayout.SOUTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack(); 
    }
    public static void main(String[] args) {
        Window window = new Window();
    }
}