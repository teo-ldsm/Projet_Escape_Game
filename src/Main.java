public class Main {
    public static void main(String[] args) {
        Fenetre fenetre = new Fenetre();

        Scene bureauSombre = new Scene("src/resources/Salle sombre.png", "Un homme dans la rue vous " +
                "a proposé de monter dans sa camionnette blanche pour vous donner des bonbons. Il vous a kidnappé et " +
                "drogué, vous vous trouvez dans une cave sombre. Vous devez trouver un moyen d'allumer la lumière " +
                "pour vous échapper.");
        Scene salleFlippante = new Scene("src/resources/Salle flippante.png", "Vous êtes dans une salle flippante, " + "vous devez trouver un moyen de sortir.");

        fenetre.scenes.add(bureauSombre);
        
        Objet interrupteur = new Objet(212, 250, 90, 220, "Interrupteur", "Un interrupteur qui pourrait allumer la lumière.", true, Hitboxes.CARRE);
        bureauSombre.objets.add(interrupteur);
        bureauSombre.afficher();
        
        while (fenetre.currentScene == bureauSombre) {
            if (interrupteur.used==true){
                fenetre.scenes.add(salleFlippante);
                salleFlippante.afficher();
                }
            
        }

//        Objet interrupteur = new Objet();
    }
}