import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.CountDownLatch;

public class CalibrateurSouris extends JPanel {

    private JLabel cross1; // Croix en haut à gauche
    private JLabel cross2; // Croix en bas à droite

    private final JLabel text;
    private final JButton button;

    private final Fenetre f;

    private Point pointHautGauche; // Coordonnées du premier clic
    private Point pointBasDroit;   // Coordonnées du deuxième clic
    private final CountDownLatch calibrationLatch; // Synchronisation

    public CalibrateurSouris(Fenetre f, CountDownLatch latch) {
        this.calibrationLatch = latch; // Injecter le CountDownLatch
        this.f = f;

        setLayout(null);

        text = new JLabel("Une calibration de la souris est nécéssaire. Cliquez sur les croix rouges pour calibrer");
        text.setBounds(100, 100, 500, 20);

        button = new JButton("Démarrer le calibrage");
        button.setBounds(100, 130, 200, 20);
        button.addActionListener(e -> startCalibration());

        add(text);
        add(button);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (cross1 != null && cross1.isVisible() && cross1.getBounds().contains(e.getPoint())) {
                    pointHautGauche = e.getPoint();
                    cross1.setVisible(false);
                    cross2.setVisible(true);
                } else if (cross2 != null && cross2.isVisible() && cross2.getBounds().contains(e.getPoint())) {
                    pointBasDroit = e.getPoint();
                    cross2.setVisible(false);
                    calibrationTerminee();
                }
            }
        });

        setVisible(true);
    }

    public void startCalibration() {
//        cross1 = creerCroix((f.imageLabel.getWidth() - f.imageLabel.getIcon().getIconWidth())/2 + 20,
//                (f.imageLabel.getHeight() - f.imageLabel.getIcon().getIconHeight())/2 + 20);
//        cross2 = creerCroix(cross1.getX() + f.imageLabel.getIcon().getIconWidth() - 20,
//                cross1.getY() + f.imageLabel.getIcon().getIconHeight() - 20);

        cross1 = creerCroix(20, 20);
        cross2 = creerCroix(getWidth() - 20, getHeight() - 20);

        cross2.setVisible(false);

        // Supprime le bouton et le texte
        remove(text);
        remove(button);

        // Ajoute les croix
        add(cross1);
        add(cross2);

        // Réactualise l'interface après le changement
        revalidate();
        repaint(); // Important pour redessiner correctement
    }

    private JLabel creerCroix(int x, int y) {
        JLabel croix = new JLabel("+");
        croix.setFont(new Font("Arial", Font.BOLD, 24));
        croix.setForeground(Color.RED);
        croix.setBounds(x, y, 20, 20);
        return croix;
    }

    private void calibrationTerminee() {
        System.out.println("Calibration terminée!");
        System.out.println("Point haut gauche : " + pointHautGauche);
        System.out.println("Point bas droit : " + pointBasDroit);

        Souris.pointHautGauche = pointHautGauche;
        Souris.pointBasDroit = pointBasDroit;

        calibrationLatch.countDown(); // Notifiez que la calibration est terminée
    }
}