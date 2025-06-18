import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

class Souris extends MouseAdapter {
    public Fenetre fenetre;
    private final boolean debug;
    public static Point pointHautGauche;
    public static Point pointBasDroit;

    private final ArrayList<Integer[]> debugList = new ArrayList<>();

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

        int xImage = (fenetre.imageLabel.getWidth() - largeurImageAffichee) / 2 + 7;        // Remplacer pour faire correspondre les coordonées du 0, 0 (souvent 7)
        int yImage = (fenetre.imageLabel.getHeight() - hauteurImageAffichee) / 2 + 30;      // aux coin suppérieur gauche de l'image (souvent 30)

        // Vérifier si le clic est dans les limites de l'image
        if (xClic >= xImage && xClic <= xImage + largeurImageAffichee &&
            yClic >= yImage && yClic <= yImage + hauteurImageAffichee) {

            // Convertir les coordonnées du clic en coordonnées normalisées
            int xNormalise = (xClic - xImage) * 1000 / largeurImageAffichee;
            int yNormalise = (yClic - yImage) * 1000 / hauteurImageAffichee;

            if (debug) {
                fenetre.bandeau.setText("Clic aux coordonnées normalisées (" + xNormalise + "; " + yNormalise + ")");
                debugList.add(new Integer[]{xNormalise, yNormalise});

                if (debugList.size() == 1) {
                    System.out.println("En attente du second clic...");
                } else if (debugList.size() == 2) {
                    int width = debugList.get(1)[0] - debugList.get(0)[0];
                    int height = debugList.get(1)[1] - debugList.get(0)[1];
                    int middleX = debugList.get(0)[0] + width / 2;
                    int middleY = debugList.get(0)[1] + height / 2;

                    System.out.println("Centre : (" + middleX + "; " + middleY + ")\nLargeur : " + width + "\nHauteur : " + height + "\n");
                    debugList.clear();
                }
            }

            // Notification du clic à la scène courante
            fenetre.currentScene.click(xNormalise, yNormalise);
        }
    }
}