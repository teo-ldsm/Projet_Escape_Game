import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Souris extends MouseAdapter {
    Fenetre fenetre;
    private final boolean debug;

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

        int xImage = (fenetre.imageLabel.getWidth() - fenetre.imageLabel.getIcon().getIconWidth())/2;
        int yImage = (fenetre.imageLabel.getHeight() - fenetre.imageLabel.getIcon().getIconHeight())/2;

        x -= xImage;
        y -= yImage;

        x = x * 1000 / fenetre.imageLabel.getIcon().getIconWidth();
        y = y * 1000 / fenetre.imageLabel.getIcon().getIconHeight();
        
        if (debug) fenetre.bandeau.setText("Clic aux coordonées (" + x + "; " + y + ")");
        fenetre.currentScene.click(x, y);
    }
}