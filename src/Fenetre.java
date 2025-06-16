import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Fenetre extends JFrame {

    public final JLabel imageLabel; // Composant pour afficher l'image
    public final Bandeau bandeau;

    public ArrayList<Scene> scenes;
    public Scene currentScene;

    public Fenetre() throws InterruptedException {
        super("Escape game");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setSize(1360, 768);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pan = new JPanel(new BorderLayout());


        // Ajouter le bandeau en bas
        bandeau = new Bandeau();
        pan.add(bandeau, BorderLayout.SOUTH);

        CalibrateurSouris cs = new CalibrateurSouris();
        pan.add(cs, BorderLayout.CENTER);

        setContentPane(pan);
        setVisible(true);
        addMouseListener(new Souris(this, true));

        cs.startCalibration();
        while (!cs.calibrationTerminee) {}
        System.out.println("oui");

        pan.remove(cs);

        // Composant image au centre
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pan.add(imageLabel, BorderLayout.CENTER);
        Objet.f = this;
        Scene.f = this;

        scenes = new ArrayList<>();
    }

    public void afficheimage(String image) {
        ImageIcon icon = new ImageIcon(image);

        // Récupérer les dimensions disponibles pour afficher l'image
        int largeurDisponible = getContentPane().getWidth();
        int hauteurDisponible = getContentPane().getHeight() - bandeau.getHeight();

        // Redimensionner l'image si nécessaire
        Image img = icon.getImage();
        int largeurImage = icon.getIconWidth();
        int hauteurImage = icon.getIconHeight();

        // Échelle pour ajuster l'image à l'espace disponible
        double ratioLargeur = (double) largeurDisponible / largeurImage;
        double ratioHauteur = (double) hauteurDisponible / hauteurImage;
        double ratio = Math.min(ratioLargeur, ratioHauteur);

        // Redimensionner l'image en maintenant les proportions
        int nouvelleLargeur = (int) (largeurImage * ratio);
        int nouvelleHauteur = (int) (hauteurImage * ratio);
        Image imgRedimensionnee = img.getScaledInstance(nouvelleLargeur, nouvelleHauteur, Image.SCALE_SMOOTH);

        // Mettre l'image redimensionnée dans le JLabel
        imageLabel.setIcon(new ImageIcon(imgRedimensionnee));
    }
}