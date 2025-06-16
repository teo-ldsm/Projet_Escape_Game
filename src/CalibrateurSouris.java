import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalibrateurSouris extends JPanel {

    private JLabel cross1; // Croix en haut à gauche
    private JLabel cross2; // Croix en bas à droite
    private Point pointHautGauche; // Coordonnées du premier clic
    private Point pointBasDroit;   // Coordonnées du deuxième clic
    public volatile boolean calibrationTerminee = false;

    public CalibrateurSouris() {
        // Plein écran
        setLayout(null); // Gestion manuelle du positionnement des composants

        // Ajouter un écouteur pour gérer les clics
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (cross1.isVisible() && cross1.getBounds().contains(e.getPoint())) {
                    pointHautGauche = e.getPoint();
                    cross1.setVisible(false); // Masquer la première croix
                    cross2.setVisible(true); // Afficher la croix en bas à droite
                } else if (cross2.isVisible() && cross2.getBounds().contains(e.getPoint())) {
                    pointBasDroit = e.getPoint();
                    cross2.setVisible(false); // Masquer la deuxième croix
                    calibrationTerminee();
                }
            }
        });

        setVisible(true);
    }

    public void startCalibration() {
        // Initialisation des croix
        cross1 = creerCroix(20, 20); // Haut gauche
        cross2 = creerCroix(getWidth() - 50, getHeight() - 50); // Bas droit (sera masquée au début)
        cross2.setVisible(false);

        add(cross1);
        add(cross2);
    }

    /**
     * Crée une croix à une position donnée.
     *
     * @param x Coordonnée X de la croix.
     * @param y Coordonnée Y de la croix.
     * @return Un JLabel représentant la croix.
     */
    private JLabel creerCroix(int x, int y) {
        JLabel croix = new JLabel("+");
        croix.setFont(new Font("Arial", Font.BOLD, 24));
        croix.setForeground(Color.RED);
        croix.setBounds(x, y, 20, 20);
        System.out.println("Coordonées croix : " + croix.getX() + " ; " + croix.getY() + " ;");
        return croix;
    }

    private void calibrationTerminee() {
        System.out.println("Calibration terminée!\n"
                + "Point haut gauche : " + pointHautGauche + "\n"
                + "Point bas droit : " + pointBasDroit);
        Souris.pointHautGauche = pointHautGauche;
        Souris.pointBasDroit = pointBasDroit;
        calibrationTerminee = true;
    }

}