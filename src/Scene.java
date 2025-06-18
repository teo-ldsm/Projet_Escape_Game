import java.util.ArrayList;

public class Scene {

    public ArrayList<Objet> objets;
    public String image;
    public String description;
    public final String nom;

    public boolean accueil = false;

    public static Fenetre f;

    public Scene(String nom, String image, String description) {
        this.nom = nom;
        this.objets = new ArrayList<Objet>();
        this.image = image;
        this.description = description;
    }

    public void afficher() {
        f.scenes.add(this);
        for (Scene s : f.scenes) {
            s.masquer();
        }
        f.afficheimage(image);
        f.currentScene = this;
        f.bandeau.setText(description);
        for (Objet o : objets) {
            o.visible = true;
        }
        f.boutonRetour.setVisible(!accueil);
    }

    public void masquer() {
        for (Objet o : objets) {
            o.visible = false;
            o.focused = false;
            f.bandeau.desactiverBoutonPrendre();
            f.bandeau.desactiverBoutonUtiliser();
            f.bandeau.desactiverBoutonRegarder();
        }
    }

    public void click(int x, int y) {
        f.bandeau.desactiverBoutonRegarder();
        f.bandeau.desactiverBoutonPrendre();
        f.bandeau.desactiverBoutonUtiliser();
        for (Objet o : objets) {
            if (o.isClicked(x, y)) {
                o.focused = true;
                f.bandeau.setText(o.description);
                if (o.regardable) {
                    f.bandeau.activerBoutonRegarder();
                }
                if (o.utilisable) {
                    if (o.utilisableAvec != null) {
                        f.bandeau.activerBoutonUtiliser(o.utilisableAvec.nom);
                    } else {
                        f.bandeau.activerBoutonUtiliser();
                    }
                }
                if (o.prenable){
                    f.bandeau.activerBoutonPrendre();
                }
            } else {
                o.focused = false;
            }
        }
    }

}
