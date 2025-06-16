public class Main {
    public static void main(String[] args) {
        Fenetre fenetre = new Fenetre();

        Scene bureauSombre = new Scene("src/resources/Salle sombre.png", "Un homme dans la rue vous " +"a proposé de monter dans sa camionnette blanche pour vous donner des bonbons. Il vous a kidnappé et " +"drogué, vous vous trouvez dans une cave sombre. Vous devez trouver un moyen d'allumer la lumière " +"pour vous échapper.");
            Objet interrupteur = new Objet(243, 214, 150, 300, "Interrupteur", "Un interrupteur qui pourrait allumer la lumière.", true, Hitboxes.CARRE, false, false);
            bureauSombre.objets.add(interrupteur);

        Scene salleFlippante = new Scene("src/resources/Salle flippante.png", "Vous êtes dans une salle flippante, " + "vous devez trouver un moyen de sortir.");
            Objet lampe = new Objet(100, 100, 50, 50, "Lampe", "C'est une lampe.", false, Hitboxes.CARRE, false, false);
            Objet porte = new Objet(200, 100, 50, 50, "Porte", "C'est une porte qui mène à une autre salle.", true, Hitboxes.CARRE, false, true);
            Objet ordinateur = new Objet(300, 100, 50, 50, "Ordinateur", "C'est un ordinateur qui pourrait contenir des informations.", true, Hitboxes.CARRE, false, false);
            Objet Sac = new Objet(400, 100, 50, 50, "Sac", "C'est un sac qui pourrait contenir des objets utiles.", false, Hitboxes.CARRE, false, true);
            Objet journal = new Objet(500, 100, 50, 50, "Journal", "C'est un journal qui pourrait contenir des informations.", false, Hitboxes.CARRE, false, true);
            Objet boite1 = new Objet(600, 100, 50, 50, "Boîte", "C'est une boîte qui pourrait contenir des objets utiles.", false, Hitboxes.CARRE, false, true);
            Objet boite2 = new Objet(700, 100, 50, 50, "Boîte", "C'est une boîte qui pourrait contenir des objets utiles.", false, Hitboxes.CARRE, false, false);
            Objet boite3 = new Objet(800, 100, 50, 50, "Boîte", "C'est une boîte qui pourrait contenir des objets utiles.", false, Hitboxes.CARRE, false, false);
            Objet mallette = new Objet(900, 100, 50, 50, "Mallette", "C'est une mallette qui pourrait contenir des objets utiles.", false, Hitboxes.CARRE, false, true);
            Objet tiroir = new Objet(300, 700, 100, 50, "Tiroir", "C'est un tiroir qui pourrait contenir des objets utiles.", true, Hitboxes.CARRE, false, false);
            Objet bocaletrange = new Objet(1100, 100, 50, 50, "Bocal étrange", "C'est un bocal contenant une chose étrange.", false, Hitboxes.CARRE, false, false);
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

        Scene sactelephone = new Scene("src/resources/sac téléphone.png", "C'est un sac contenant un téléphone, des médicaments, un tournevis et des serviettes. ");
            Objet telephone = new Objet(100, 100, 50, 50, "Téléphone", "C'est un téléphone", false, Hitboxes.CARRE, false, true);
            Objet medicaments = new Objet(200, 100, 50, 50, "Médicaments", "C'est des médicaments", false, Hitboxes.CARRE, false, false);
            Objet tournevis = new Objet(300, 100, 50, 50, "Tournevis", "C'est un tournevis", false, Hitboxes.CARRE, false, false);
            Objet serviettes = new Objet(400, 100, 50, 50, "Serviettes", "C'est des serviettes", false, Hitboxes.CARRE, false, false);
            sactelephone.objets.add(telephone);
            sactelephone.objets.add(medicaments);
            sactelephone.objets.add(tournevis);
            sactelephone.objets.add(serviettes);


        Scene photocarnet = new Scene("src/resources/photocarnet.png", "C'est un carnet contenant des notes. ");

        Scene Mallette = new Scene("src/resources/mallette clé USB.png", "C'est une mallette contenant des papiers et une clé USB. ");
            Objet cleUSB = new Objet(100, 100, 50, 50, "Clé USB", "C'est une clé USB qui pourrait contenir des informations.", false, Hitboxes.CARRE, true, false);
            Objet papiers = new Objet(200, 100, 50, 50, "Papiers", "C'est des papiers qui pourraient contenir des informations.", false, Hitboxes.CARRE, false, false);
            Mallette.objets.add(cleUSB);
            Mallette.objets.add(papiers);

        Scene Journal = new Scene("src/resources/journal accident.png", "C'est un article de journal qui parle d'un accident de voiture. ");

        Scene dossier_medical = new Scene("src/resources/dossier medical.png", "C'est un dossier médical qui contient les informations d'un mort. ");

        Scene carnettiroir = new Scene("src/resources/carnettiroir.png", "C'est un tiroir contenant un carnet. ");
            Objet carnet = new Objet(200, 200, 100, 100, "Carnet", "C'est un carnet qui pourrait contenir des informations.", false, Hitboxes.CARRE, false, true);
            carnettiroir.objets.add(carnet);

        Scene boitephoto = new Scene("src/resources/boitephoto.png", "C'est une boîte contenant une photo et des outils. ");
            Objet photo = new Objet(100, 100, 50, 50, "Photo", "C'est une photo qui pourrait contenir des informations.", false, Hitboxes.CARRE, false, true);
            Objet outils = new Objet(200, 100, 50, 50, "Outils", "C'est des outils qui pourraient être utiles.", false, Hitboxes.CARRE, false, false);
            boitephoto.objets.add(photo);
            boitephoto.objets.add(outils);

        Scene digicode = new Scene("src/resources/digicode.png", "C'est un digicode qui pourrait être utilisé pour sortir de la cave. ");





        // allumer la lumière
        bureauSombre.afficher();
        while (fenetre.currentScene == bureauSombre) {

            if (interrupteur.used){
                salleFlippante.afficher();
                }
            fenetre.repaint();
        }
        while (true)
            // chercher dans la salle flippante
            while (fenetre.currentScene == salleFlippante) {
                if (tiroir.used){
                    carnettiroir.afficher();
                }
                if (boite1.regardé){
                    boitephoto.afficher();
                }
                if (Sac.regardé){
                    sactelephone.afficher();
                }
                if (mallette.regardé){
                Mallette.afficher();
                }
                if (journal.regardé){
                    Journal.afficher();
                }
                if (ordinateur.used){
                    if (cleUSB.collected){
                        dossier_medical.afficher();
                    } else {
                        fenetre.bandeau.setText("L'ordinateur est verrouillé.");
                    }
                }


            // lire le carnet
            while (fenetre.currentScene == carnettiroir) {
                if (carnet.regardé) {
                    photocarnet.afficher();
                    fenetre.bandeau.setText(new String[]{"17 mars.\n Elle est partie. Elle a dit que c'était fini. Fini. Comme si on pouvait juste effacer des années. Comme si mon amour était une chose qu'on jette. Elle croit quoi, qu'elle va trouver mieux ? Personne ne l'aimera comme moi. Personne.","21 mars.\n Je la vois partout. Son rire résonne dans mes murs vides. Ses parfums sont encore là, dans l'air, me narguant. Je sais ce qu'elle fait. Elle vit sa vie. La sienne. Sans moi. L'idée qu'elle soit avec quelqu'un d'autre... ça me brûle de l'intérieur. Une flamme noire qui ne s'éteint pas.","28 mars.\n J'ai trouvé la solution. Simple. Propre. Si elle ne peut pas être à moi, elle ne sera à personne. Leurs vies sans moi, leurs rires, leurs mensonges. Ça n'arrivera pas. Pas question.","3 avril.\n C'est une question de temps. Une petite modification. Un détail insignifiant pour le commun des mortels. Mais pour elle... ce sera la fin. Un accident. Personne ne se doutera de rien. J'ai pensé à tout. Les moindres détails. Mon cœur ne bat plus la chamade, il est froid. Comme de la pierre. Une pierre qui pèse lourd.","5 avril.\n C'est fait. J'ai vu l'annonce aux infos. Un accident. Elle n'a pas survécu. Le sourire sur son visage, le dernier que j'ai vu, m'a hanté un instant. Puis le vide. C'est tout ce qui reste. Juste le vide. C'est mieux comme ça. Vraiment mieux.","12 mai.\n Je traîne. Les jours, les nuits se ressemblent. Un brouillard épais. Puis je l'ai vue. Dans la rue. J'ai cru que mon cœur allait lâcher. La même démarche. Les mêmes cheveux. Et ce visage... c'est elle. Elle est là. Elle est revenue.","12 mai. (plus tard dans la nuit)\n Non. Ce n'est pas elle. Pas tout à fait. Mais c'est si proche. Incroyablement proche. Je l'ai suivie un moment. Mon sang pulsait dans mes veines. Une idée. Une folie. Mon cerveau en a une nouvelle. Une nouvelle obsession.","13 mai.\n La camionnette. Blanche. Parfaite pour ça. Je l'ai garée au bon endroit. Elle était là, à ce même coin de rue. Un instant. Juste un instant de panique dans ses yeux. Puis l'obscurité. Elle est à moi maintenant. Dans la camionnette. Mon nouveau fardeau. Mon nouveau jouet. Et personne ne le saura. Personne. Elle me rappellera Claire. Et je pourrai recommencer. Ou finir. Je ne sais pas encore.","13 mai. (après l'avoir récupérée)\n Elle est là, en bas, dans le noir. Elle ne sait pas. Elle ne comprend pas. Elle est juste... là. Une ombre. Une toile blanche pour mes pinceaux. Je la regarde, et je vois Claire. Ce n'est pas elle, je sais. Mais c'est une image assez nette pour me tromper, un instant. Elle est attachée. Pour sa sécurité, bien sûr. C'est pour son bien. Elle me remerciera un jour.","Je suis le seul maître ici. Le seul à connaître les chemins de cette maison, de ma vie. Mais si jamais quelqu'un se retrouvait dans ma cave, il faudrait bien qu'il comprenne. Qu'il comprenne mes obsessions. Pour s'en sortir, il n'y a qu'une seule voie.","Pour sortir de ma cave, souviens-toi de mes obsessions :\n Le jour où tout a changé, la date du premier vide, avant le grand vide.\n Le nombre de fois où elle a appelé, avant que je ne décroche plus.\n L’heure gravée dans ma mémoire, l'instant précis où j'ai su qu'elle ne reviendrait jamais.\n Le poids que sur ma conscience, le fait que personne d'autre ne l'aura.\n Ces chiffres, mis dans le bon ordre, ouvriront la porte. Le savent-ils ? Se souviendront-ils ?"});
                }

            }

            // chercher le téléphone
            while (fenetre.currentScene == sactelephone) {
                if (telephone.regardé) {
                    fenetre.bandeau.setText("Le téléphone ne capte pas, mais on peut voir que le téléphone a appelé 9 fois 'mon amour'.");
                }
            }

            // chercher la clé USB
            while (fenetre.currentScene == Mallette) {
                if (papiers.regardé) {
                    fenetre.bandeau.setText("Les papiers sont des documents administratifs.");
                }
            }

            // chercher le journal
            while (fenetre.currentScene == Journal) {
                if (journal.regardé) {
                    fenetre.bandeau.setText("L'article parle d'un accident de voiture qui a eu lieu le 17 mars à 4h.");
                }
            }

            // chercher le dossier médical
            while (fenetre.currentScene == dossier_medical) {
                fenetre.bandeau.setText("Le dossier médical contient les informations d'un mort, dont  le poids est de 62kg et la taille de 1m70.");
            }
            fenetre.repaint();
        }
    }
}