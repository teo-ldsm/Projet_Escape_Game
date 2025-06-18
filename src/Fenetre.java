import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Fenetre extends JFrame {

    public final JLabel imageLabel; // Composant pour afficher l'image
    public final Bandeau bandeau;

    public final JButton boutonRetour;

    public final ButtonListener blistener;
    public final Souris souris;

    public ArrayList<Scene> scenes;
    public volatile Scene currentScene;

    public Fenetre() {
        super("Escape game");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setSize(1360, 768);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pan = new JPanel(new BorderLayout());

        blistener = new ButtonListener(this);

        // Ajouter le bandeau en bas
        bandeau = new Bandeau(this);
        pan.add(bandeau, BorderLayout.SOUTH);

        blistener.b = bandeau;

        // Initialise CountDownLatch pour attendre la calibration
//        CountDownLatch calibrationLatch = new CountDownLatch(1);
//
//        CalibrateurSouris cs = new CalibrateurSouris(this, calibrationLatch);
//        pan.add(cs, BorderLayout.CENTER);

        setContentPane(pan);
        setVisible(true);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        souris = new Souris(this, true, false);
        imageLabel.addMouseListener(souris);

//        cs.startCalibration();
//        try {
//            // Attente que la calibration soit terminée
//            calibrationLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        pan.remove(cs);

        pan.add(imageLabel, BorderLayout.CENTER);

        boutonRetour = new JButton("<-");
        boutonRetour.setFont(new Font("Arial", Font.BOLD, 20));
        boutonRetour.setFocusPainted(false);
        boutonRetour.setForeground(Color.WHITE);
        boutonRetour.setBackground(Color.BLACK);
        boutonRetour.setVisible(false);
        boutonRetour.setActionCommand("retour");
        boutonRetour.addActionListener(blistener);

        JPanel overlay = new JPanel(null);
        overlay.setOpaque(false);

        boutonRetour.setBounds(15, 15, 60, 40);
        overlay.add(boutonRetour);

        setGlassPane(overlay);
        overlay.setVisible(true);

        Objet.f = this;
        Scene.f = this;

        scenes = new ArrayList<>();
    }

    public void afficheimage(String image) {
        ImageIcon icon = new ImageIcon(image);

        // Récupérer les dimensions disponibles pour afficher l'image
        int largeurDisponible = getContentPane().getWidth();
        int hauteurDisponible = getContentPane().getHeight() - bandeau.getHeight();

        Image img = icon.getImage();
        int largeurImage = icon.getIconWidth();
        int hauteurImage = icon.getIconHeight();

        double ratioLargeur = (double) largeurDisponible / largeurImage;
        double ratioHauteur = (double) hauteurDisponible / hauteurImage;
        double ratio = Math.min(ratioLargeur, ratioHauteur);

        int nouvelleLargeur = (int) (largeurImage * ratio);
        int nouvelleHauteur = (int) (hauteurImage * ratio);
        Image imgRedimensionnee = img.getScaledInstance(nouvelleLargeur, nouvelleHauteur, Image.SCALE_SMOOTH);

        imageLabel.setIcon(new ImageIcon(imgRedimensionnee));
    }

    public void afficheScene(String nom) throws Error{  // sers à rien
        for (Scene s : scenes) {
            if (s.nom.equals(nom)) {
                s.afficher();
                return;
            }
        }
        throw new Error("Scene inconnue");
    }

    public void afficheAccueil() throws Error{  // Ne marche pas tout le temps
        for (Scene s : scenes) {
            if (s.accueil) {
                s.afficher();
                return;
            }
        }
        throw new Error("Aucune scène d'accueil définie");
    }

}