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
        int x = m.getX();
        int y = m.getY();

//        int xImage = (fenetre.imageLabel.getWidth() - fenetre.imageLabel.getIcon().getIconWidth())/2;
//        int yImage = (fenetre.imageLabel.getHeight() - fenetre.imageLabel.getIcon().getIconHeight())/2;

        x -= pointHautGauche.x;
        y -= pointHautGauche.y;

        x = x * 1000 / (pointBasDroit.x-pointHautGauche.x);
        y = y * 1000 / (pointBasDroit.y-pointHautGauche.y);
        
        if (debug) fenetre.bandeau.setText("Clic aux coordonées (" + x + "; " + y + ")");
        fenetre.currentScene.click(x, y);
    }
}