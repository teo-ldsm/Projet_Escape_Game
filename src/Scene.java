import java.util.ArrayList;

public class Scene {

    public ArrayList<Objet> objets;
    public String image;
    public String description;

    public static Fenetre f;

    public Scene(String image, String description) {
        this.objets = new ArrayList<Objet>();
        this.image = image;
        this.description = description;
    }

    public void afficher() {
        f.currentScene = this;
        f.scenes.add(this);
        for (Scene s : f.scenes) {
            s.masquer();
        }
        f.afficheimage(image);
        f.bandeau.setText(description);
        for (Objet o : objets) {
            o.visible = true;
        }
    }

    public void masquer() {
        for (Objet o : objets) {
            o.visible = false;
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
