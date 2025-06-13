public class Main {
    public static void main(String[] args) {
        Fenetre fenetre = new Fenetre();
        fenetre.afficheimage("src/resources/Salle sombre.png");
        fenetre.bandeau.setText("Un homme dans la rue vous a proposé de monter dans sa camionnette blanche pour vous donner des bonbons. Il vous a kidnappé et drogué, vous vous trouvez dans une cave sombre. Vous devez trouver un moyen d'allumer la lumière pour vous échapper.");
        new Fenetre();
    }
}