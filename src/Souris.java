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
        if (debug) fenetre.bandeau.setText("Clic aux coordonées (" + x + "; " + y + ")");
        fenetre.click(x, y);
    }
}