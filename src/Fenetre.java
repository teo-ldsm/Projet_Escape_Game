import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {

    private final JLabel imageLabel; // Composant pour afficher l'image
    public final Bandeau bandeau;

    public Fenetre() {
        super("Escape game");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pan = new JPanel(new BorderLayout());

        // Composant image au centre
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pan.add(imageLabel, BorderLayout.CENTER);

        // Ajouter le bandeau en bas
        bandeau = new Bandeau();
        pan.add(bandeau, BorderLayout.SOUTH);

        setContentPane(pan);
        setVisible(true);
        addMouseListener(new Souris(this));
    }

    public void click(int x, int y) {}

    public void afficheimage(String image) {
        ImageIcon icon = new ImageIcon(image);
        imageLabel.setIcon(icon); // Affiche l'image dans la fenêtre principale
    }
}