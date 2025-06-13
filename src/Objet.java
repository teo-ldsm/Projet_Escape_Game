
public class Objet {

    private final int x;
    private final int y;
    private final int height;
    private final int width;

    public String nom;
    public String description;
    public boolean utilisable;
    public boolean prenable;

    public Hitboxes hitbox;
    public boolean visible = false;

    public static Fenetre f;


    public Objet(int x, int y, int height, int width, String nom, String description, boolean utilisable, Hitboxes hitbox) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.nom = nom;
        this.description = description;
        this.utilisable = utilisable;
        this.hitbox = hitbox;
    }

    public boolean isClicked(int mouseX, int mouseY) {

        if (!visible) return false;

        if (hitbox == Hitboxes.ROND) {
            double normalizedX = Math.pow(mouseX - x, 2) / Math.pow(width, 2);
            double normalizedY = Math.pow(mouseY - y, 2) / Math.pow(height, 2);
            return normalizedX + normalizedY <= 1.0;
        } else {
            return mouseX >= x - width/2 && mouseX <= x + width/2 && mouseY >= y - height/2 && mouseY <= y + height/2;
        }
    }

    public void regarder() {
        if (visible) {
            f.bandeau.setText(description);
        }
    }

    public void prendre() {
        if (visible && prenable) {
            f.bandeau.setText("Vous avez ramassé " + nom + ". Cela pourra vous servir plus tard");
            visible = false;
        }
    }
    public void utiliser() {
        if (visible && utilisable) {
            f.bandeau.setText("Vous avez utilisé " + nom + ".");
            visible = false;
        }
    }
}
