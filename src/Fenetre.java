import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {


    public Fenetre() {

        JFrame f = new JFrame("Escape game");

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);

        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pan = new JPanel(new BorderLayout());

        // Ajouter le bandeau en bas
        Bandeau bandeau = new Bandeau();
        pan.add(bandeau, BorderLayout.SOUTH);

        f.setContentPane(pan);
        f.setVisible(true);



    }

}
