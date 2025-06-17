import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Souris extends MouseAdapter {
    Fenetre fenetre;
    private final boolean debug;
    public static Point pointHautGauche;
    public static Point pointBasDroit;

    public Souris(Fenetre f) {
        fenetre = f;
        debug = false;
    }

    public Souris(Fenetre f, boolean debug) {
        fenetre = f;
        this.debug = debug;
    }

    public void mouseClicked(MouseEvent m) {
        int xClic = m.getX();
        int yClic = m.getY();

        // Position et taille de l'image affichée
        int largeurImageAffichee = fenetre.imageLabel.getIcon().getIconWidth();
        int hauteurImageAffichee = fenetre.imageLabel.getIcon().getIconHeight();

        int xImage = (fenetre.imageLabel.getWidth() - largeurImageAffichee) / 2 + 7;        // Remplacer pour faire correspondre les coordonées du 0, 0
        int yImage = (fenetre.imageLabel.getHeight() - hauteurImageAffichee) / 2 + 30;      // aux coin suppérieur gauche de l'image

        // Vérifier si le clic est dans les limites de l'image
        if (xClic >= xImage && xClic <= xImage + largeurImageAffichee &&
            yClic >= yImage && yClic <= yImage + hauteurImageAffichee) {

            // Convertir les coordonnées du clic en coordonnées normalisées
            int xNormalise = (xClic - xImage) * 1000 / largeurImageAffichee;
            int yNormalise = (yClic - yImage) * 1000 / hauteurImageAffichee;

            if (debug) {
                fenetre.bandeau.setText("Clic aux coordonnées normalisées (" + xNormalise + "; " + yNormalise + ")");
            }

            // Notification du clic à la scène courante
            fenetre.currentScene.click(xNormalise, yNormalise);
        }
    }
}