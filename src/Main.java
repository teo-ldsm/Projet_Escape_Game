public class Main {
    public static void main(String[] args) {
        Fenetre fenetre = new Fenetre();

        Scene bureauSombre = new Scene("src/resources/Salle sombre.png", "Un homme dans la rue vous " +"a proposé de monter dans sa camionnette blanche pour vous donner des bonbons. Il vous a kidnappé et " +"drogué, vous vous trouvez dans une cave sombre. Vous devez trouver un moyen d'allumer la lumière " +"pour vous échapper.");
            Objet interrupteur = new Objet(212, 250, 90, 220, "Interrupteur", "Un interrupteur qui pourrait allumer la lumière.", true, Hitboxes.CARRE);
            bureauSombre.objets.add(interrupteur);
            fenetre.scenes.add(bureauSombre);

        Scene salleFlippante = new Scene("src/resources/Salle flippante.png", "Vous êtes dans une salle flippante, " + "vous devez trouver un moyen de sortir.");
            Objet lampe = new Objet(100, 100, 50, 50, "Lampe", "C'est une lampe.", true, Hitboxes.CARRE);
            Objet porte = new Objet(200, 100, 50, 50, "Porte", "C'est une porte qui mène à une autre salle.", true, Hitboxes.CARRE);
            Objet ordinateur = new Objet(300, 100, 50, 50, "Ordinateur", "C'est un ordinateur qui pourrait contenir des informations.", true, Hitboxes.CARRE);
            Objet Sac = new Objet(400, 100, 50, 50, "Sac", "C'est un sac qui pourrait contenir des objets utiles.", true, Hitboxes.CARRE);
            Objet journal = new Objet(500, 100, 50, 50, "Journal", "C'est un journal qui pourrait contenir des informations.", true, Hitboxes.CARRE);
            Objet boite1 = new Objet(600, 100, 50, 50, "Boîte", "C'est une boîte qui pourrait contenir des objets utiles.", true, Hitboxes.CARRE);
            Objet boite2 = new Objet(700, 100, 50, 50, "Boîte", "C'est une boîte qui pourrait contenir des objets utiles.", true, Hitboxes.CARRE);
            Objet boite3 = new Objet(800, 100, 50, 50, "Boîte", "C'est une boîte qui pourrait contenir des objets utiles.", true, Hitboxes.CARRE);
            Objet mallette = new Objet(900, 100, 50, 50, "Mallette", "C'est une mallette qui pourrait contenir des objets utiles.", true, Hitboxes.CARRE);
            Objet tiroir = new Objet(1000, 100, 50, 50, "Tiroir", "C'est un tiroir qui pourrait contenir des objets utiles.", true, Hitboxes.CARRE);
            Objet bocaletrange = new Objet(1100, 100, 50, 50, "Bocal étrange", "C'est un bocal contenant une chose étrange.", true, Hitboxes.CARRE);
            salleFlippante.objets.add(lampe);
            salleFlippante.objets.add(porte);
            salleFlippante.objets.add(ordinateur);
            salleFlippante.objets.add(Sac);
            salleFlippante.objets.add(journal);
            salleFlippante.objets.add(boite1);
            salleFlippante.objets.add(boite2);
            salleFlippante.objets.add(boite3);
            salleFlippante.objets.add(mallette);
            salleFlippante.objets.add(tiroir);
            salleFlippante.objets.add(bocaletrange);
            fenetre.scenes.add(salleFlippante);

        Scene sactelephone = new Scene("src/resources/sac téléphone.png", "C'est un sac contenant un téléphone, des médicaments, un tournevis et des serviettes. ");
            Objet telephone = new Objet(100, 100, 50, 50, "Téléphone", "C'est un téléphone", true, Hitboxes.CARRE);
            Objet medicaments = new Objet(200, 100, 50, 50, "Médicaments", "C'est des médicaments", true, Hitboxes.CARRE);
            Objet tournevis = new Objet(300, 100, 50, 50, "Tournevis", "C'est un tournevis", true, Hitboxes.CARRE);
            Objet serviettes = new Objet(400, 100, 50, 50, "Serviettes", "C'est des serviettes", true, Hitboxes.CARRE);
            sactelephone.objets.add(telephone);
            sactelephone.objets.add(medicaments);
            sactelephone.objets.add(tournevis);
            sactelephone.objets.add(serviettes);
            fenetre.scenes.add(sactelephone);


        Scene photocarnet = new Scene("src/resources/photocarnet.png", "C'est un carnet contenant des notes. ");
            fenetre.scenes.add(photocarnet);

        Scene Mallette = new Scene("src/resources/mallette clé USB.png", "C'est une mallette contenant des papiers et une clé USB. ");
            Objet cleUSB = new Objet(100, 100, 50, 50, "Clé USB", "C'est une clé USB qui pourrait contenir des informations.", true, Hitboxes.CARRE);
            Objet papiers = new Objet(200, 100, 50, 50, "Papiers", "C'est des papiers qui pourraient contenir des informations.", true, Hitboxes.CARRE);
            Mallette.objets.add(cleUSB);
            Mallette.objets.add(papiers);
            fenetre.scenes.add(Mallette);

        Scene Journal = new Scene("src/resources/journal accident.png", "C'est un article de journal qui parle d'un accident de voiture. ");
            fenetre.scenes.add(Journal);

        Scene dossier_medical = new Scene("src/resources/dossier medical.png", "C'est un dossier médical qui contient les informations d'un mort. ");
            fenetre.scenes.add(dossier_medical);

        Scene carnettiroir = new Scene("src/resources/carnettiroir.png", "C'est un tiroir contenant un carnet. ");
            Objet carnet = new Objet(100, 100, 50, 50, "Carnet", "C'est un carnet qui pourrait contenir des informations.", true, Hitboxes.CARRE);
            carnettiroir.objets.add(carnet);
            fenetre.scenes.add(carnettiroir);

        Scene boitephoto = new Scene("src/resources/boitephoto.png", "C'est une boîte contenant une photo et des outils. ");
            Objet photo = new Objet(100, 100, 50, 50, "Photo", "C'est une photo qui pourrait contenir des informations.", true, Hitboxes.CARRE);
            Objet outils = new Objet(200, 100, 50, 50, "Outils", "C'est des outils qui pourraient être utiles.", true, Hitboxes.CARRE);
            boitephoto.objets.add(photo);
            boitephoto.objets.add(outils);
            fenetre.scenes.add(boitephoto);



       
        
        
        bureauSombre.afficher();
        while (fenetre.currentScene == bureauSombre) {
            if (interrupteur.used==true){
                salleFlippante.afficher();
                }
            fenetre.repaint();
        }
        // allumer la lumière

    }
}