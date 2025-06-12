public class Objet {

    public int x;
    public int y;
    public int height;
    public int width;

    public String nom;
    public String description;
    public boolean utilisable;

    public Hitboxes hitbox;
    public boolean visible = false;


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

//    public boolean isClicked(int mouseX, int mouseY) {
//
//    }
}
