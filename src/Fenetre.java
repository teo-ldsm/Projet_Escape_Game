import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {


    public Fenetre() {

        JFrame f = new JFrame("Escape game");

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel pan = new JPanel();
        f.setContentPane(pan);

        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

}
