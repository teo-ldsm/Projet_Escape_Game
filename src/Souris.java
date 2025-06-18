import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Souris extends MouseAdapter {
    public Fenetre fenetre;

    private final boolean debug;
    private final boolean mesure;

    public static int offsetX = 0;
    public static int offsetY = 0;

    private final ArrayList<Integer[]> debugList = new ArrayList<>();

    public Souris(Fenetre f) {
        fenetre = f;
        debug = false;
        mesure = false;
    }

    public Souris(Fenetre f, boolean debug, boolean mesure) {
        fenetre = f;
        this.debug = debug;
        this.mesure = mesure;
    }

    /**
     * @param x Coordonnées x ddu point
     * @param y Coordonnées y du point
     * @return


     * Renvoie les coordonnées normalisées du clic. Renvoie -1 si le clic n'est pas dans les limites de l'image.
     */
    public int[] normaliserCoordonees(int x, int y) {

        int largeurImageAffichee = fenetre.imageLabel.getIcon().getIconWidth();
        int hauteurImageAffichee = fenetre.imageLabel.getIcon().getIconHeight();

        int xImage = (fenetre.imageLabel.getWidth() - largeurImageAffichee) / 2 + offsetX;
        int yImage = (fenetre.imageLabel.getHeight() - hauteurImageAffichee) / 2 + offsetY;

        // Convertir les coordonnées du clic en coordonnées normalisées
        int xNormalise = (x - xImage) * 1000 / largeurImageAffichee;
        int yNormalise = (y - yImage) * 1000 / hauteurImageAffichee;

        if (x >= xImage && x <= xImage + largeurImageAffichee && y >= yImage && y <= yImage + hauteurImageAffichee) {
            return new int[]{xNormalise, yNormalise};
        } else {
            return new int[]{-1, -1};
        }
    }

    public void mouseClicked(MouseEvent m) {
        int xClic = m.getX();
        int yClic = m.getY();

//        System.out.println( "xBrut = " + xClic + " yBrut = " + yClic);

        // Position et taille de l'image affichée
//        int largeurImageAffichee = fenetre.imageLabel.getIcon().getIconWidth();
//        int hauteurImageAffichee = fenetre.imageLabel.getIcon().getIconHeight();
//
//        int xImage = (fenetre.imageLabel.getWidth() - largeurImageAffichee) / 2 + offsetX;        // Remplacer pour faire correspondre les coordonées du 0, 0 (souvent 7)
//        int yImage = (fenetre.imageLabel.getHeight() - hauteurImageAffichee) / 2 + offsetY;      // aux coin suppérieur gauche de l'image (souvent 30)

        // Vérifier si le clic est dans les limites de l'image
        int[] coordonneesNormalisees = normaliserCoordonees(xClic, yClic);
        if (coordonneesNormalisees[0] != -1 && coordonneesNormalisees[1] != -1) {

            int xNormalise = coordonneesNormalisees[0];
            int yNormalise = coordonneesNormalisees[1];

            if (debug) {
                fenetre.bandeau.setText("Clic aux coordonnées normalisées (" + xNormalise + "; " + yNormalise + ")");
                debugList.add(new Integer[]{xNormalise, yNormalise});

                if (mesure) {
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
            }

            // Notification du clic à la scène courante
            fenetre.currentScene.click(xNormalise, yNormalise);
        }
    }
}