import java.util.List;

public class Main {
    public static void main(String[] args) {
        Fenetre fenetre = new Fenetre();
        String codeEntre = "";

        Scene bureauSombre = new Scene("Bureau Sombre", "src/resources/Salle sombre.png", "Un homme dans la rue vous a proposé de monter dans sa camionnette blanche pour vous donner des bonbons. Il vous a kidnappé et drogué, vous vous trouvez dans une cave sombre. Vous devez trouver un moyen d'allumer la lumière pour vous échapper.");
            Objet interrupteur = new Objet(215, 380, 150, 300, "Interrupteur", "Un interrupteur qui pourrait allumer la lumière.", true, Hitboxes.CARRE, false, false);
            bureauSombre.objets.add(interrupteur);

        Scene salleFlippante = new Scene("Salle Flippante", "src/resources/Salle flippante.png", "Vous êtes dans une salle flippante, vous devez trouver un moyen de sortir.");
            Objet lampe = new Objet(370, 420, 60, 85, "Lampe", "C'est une lampe.", false, Hitboxes.CARRE, false, false);
            Objet porte = new Objet(840, 485, 250, 700, "Porte", "C'est une porte qui mène à une autre salle.", true, Hitboxes.CARRE, false, false);
            Objet ordinateur = new Objet(270, 570, 160, 150, "Ordinateur", "C'est un ordinateur qui pourrait contenir des informations.", true, Hitboxes.CARRE, false, false);
            Objet Sac = new Objet(150, 850, 210, 230, "Sac", "C'est un sac qui pourrait contenir des objets utiles.", false, Hitboxes.CARRE, false, true);
            Objet journal = new Objet(261, 422, 30, 70, "Journal", "C'est un journal qui pourrait contenir des informations.", false, Hitboxes.CARRE, false, true);
            Objet boite1 = new Objet(600, 264, 40, 33, "Boîte", "C'est une boîte qui pourrait contenir des objets utiles.", false, Hitboxes.CARRE, false, true);
            Objet boite2 = new Objet(573, 410, 36, 36, "Boîte", "C'est une boîte qui pourrait contenir des objets utiles.", false, Hitboxes.CARRE, false, true);
            Objet boite3 = new Objet(606, 656, 34, 48, "Boîte", "C'est une boîte qui pourrait contenir des objets utiles.", false, Hitboxes.CARRE, false, true);
            Objet mallette = new Objet(310, 200, 70, 80, "Mallette", "C'est une mallette qui pourrait contenir des objets utiles.", false, Hitboxes.CARRE, false, true);
            Objet tiroir = new Objet(400, 650, 90, 60, "Tiroir", "C'est un tiroir qui pourrait contenir des objets utiles.", true, Hitboxes.CARRE, false, false);
            Objet bocalEtrange = new Objet(420, 558, 27, 50, "Bocal étrange", "C'est un bocal contenant une chose étrange.", false, Hitboxes.CARRE, false, false);

            journal.texteRegarder = "L'article parle d'un accident de voiture qui a eu lieu le 17 mars à 4h.";

            salleFlippante.objets.addAll(List.of(lampe, porte, ordinateur, Sac, journal, boite1, boite2, boite3, mallette, tiroir, bocalEtrange));
            salleFlippante.accueil = true;

        Scene sacTelephone = new Scene("Sac Téléphone", "src/resources/sac téléphone.png", "C'est un sac contenant un téléphone, des médicaments, un tournevis et des serviettes. ");
            Objet telephone = new Objet(689, 481, 66, 142, "Téléphone", "C'est un téléphone", false, Hitboxes.CARRE, false, true);
            Objet medicaments = new Objet(303, 344, 82, 117, "Médicaments", "C'est des médicaments", false, Hitboxes.CARRE, false, true);
            Objet tournevis = new Objet(565, 360, 57, 198, "Tournevis", "C'est un tournevis", false, Hitboxes.CARRE, false, true);
            Objet serviettes = new Objet(539, 775, 192, 142, "Serviettes", "C'est des serviettes", false, Hitboxes.CARRE, false, true);

            telephone.texteRegarder = "Le téléphone ne capte pas, mais on peut voir que le téléphone a appelé 9 fois 'mon amour'.";

            sacTelephone.objets.addAll(List.of(telephone, medicaments, tournevis, serviettes));


        Scene photoCarnet = new Scene("Photo Carnet", "src/resources/photocarnet.png", "C'est un carnet contenant des notes. ");

        Scene Mallette = new Scene("Malette", "src/resources/malettecléUSB.png", "C'est une mallette contenant des papiers et une clé USB. ");
            Objet cleUSB = new Objet(369, 620, 93, 63, "Clé USB", "C'est une clé USB qui pourrait contenir des informations.", false, Hitboxes.CARRE, true, false);

            Mallette.objets.addAll(List.of(cleUSB));

        Scene Journal = new Scene("Journal", "src/resources/journal accident.png", "C'est un article de journal qui parle d'un accident de voiture. ");

        Scene dossierMedical = new Scene("Dossier Médical", "src/resources/dossier medical.png", "Le dossier médical contient les informations d'un mort, dont  le poids est de 62kg et la taille de 1m70.");

        Scene carnetTiroir = new Scene("Carnet Tiroir", "src/resources/carnettiroir.png", "C'est un tiroir contenant un carnet. ");
            Objet carnet = new Objet(557, 528, 200, 200, "Carnet", "C'est un carnet qui pourrait contenir des informations.", false, Hitboxes.CARRE, false, true);

            carnetTiroir.objets.addAll(List.of(carnet));

        Scene boitePhoto = new Scene("Boite Photo", "src/resources/boitephoto.png", "C'est une boîte contenant une photo et des outils. ");
            Objet photo = new Objet(706, 361, 162, 149, "Photo", "C'est une photo qui pourrait contenir des informations.", false, Hitboxes.CARRE, false, true);

            boitePhoto.objets.addAll(List.of(photo));

        Scene digicode = new Scene("Digicode", "src/resources/digicode.png", "Pour sortir de la cave, il faut entrer le code :");
            Objet un = new Objet(438, 272, 42, 42, "1", "Le chiffre 1", true, Hitboxes.CARRE, false, false);
            Objet deux = new Objet(535, 272, 42, 42, "2", "Le chiffre 2", true, Hitboxes.CARRE, false, false);
            Objet trois = new Objet(638, 272, 42, 42, "3", "Le chiffre 3", true, Hitboxes.CARRE, false, false);
            Objet quatre = new Objet(435, 378, 42, 42, "4", "Le chiffre 4", true, Hitboxes.CARRE, false, false);
            Objet cinq = new Objet(536, 378, 42, 42, "5", "Le chiffre 5", true, Hitboxes.CARRE, false, false);
            Objet six = new Objet(638, 378, 42, 42, "6", "Le chiffre 6", true, Hitboxes.CARRE, false, false);
            Objet sept = new Objet(436, 482, 42, 42, "7", "Le chiffre 7", true, Hitboxes.CARRE, false, false);
            Objet huit = new Objet(537, 482, 42, 42, "8", "Le chiffre 8", true, Hitboxes.CARRE, false, false);
            Objet neuf = new Objet(638, 482, 42, 42, "9", "Le chiffre 9", true, Hitboxes.CARRE, false, false);
            Objet zero = new Objet(538, 592, 42, 42, "0", "Le chiffre 0", true, Hitboxes.CARRE, false, false);
            Objet valider = new Objet(548, 715, 138, 50, "Valider", "Valider le code", true, Hitboxes.CARRE, false, false);
            digicode.objets.addAll(List.of(un, deux, trois, quatre, cinq, six, sept, huit, neuf, zero, valider));





        // allumer la lumière
        bureauSombre.afficher();
        fenetre.boutonRetour.setVisible(false);
        while (fenetre.currentScene == bureauSombre) {

            if (interrupteur.used) {
                salleFlippante.afficher();
            }
            fenetre.repaint();
        }
        while (true) {
            // chercher dans la salle flippante
            while (fenetre.currentScene == salleFlippante) {
                if (tiroir.used) {
                    carnetTiroir.afficher();
                    tiroir.used = false;
                }
                if (boite1.regardé) {
                    boitePhoto.afficher();
                    boite1.regardé = false;
                }
                if (Sac.regardé) {
                    sacTelephone.afficher();
                    Sac.regardé = false;
                }
                if (mallette.regardé) {
                    Mallette.afficher();
                    mallette.regardé = false;
                }
                if (journal.regardé) {
                    Journal.afficher();
                    journal.regardé = false;
                }
                if (ordinateur.used) {
                    if (cleUSB.collected) {
                        dossierMedical.afficher();
                    } else {
                        fenetre.bandeau.setText("L'ordinateur est verrouillé.");
                    }
                    ordinateur.used = false;
                }
                if (porte.used) {
                    digicode.afficher();
                    porte.used = false;
                }
            }

                // lire le carnet
            while (fenetre.currentScene == carnetTiroir) {
                if (carnet.regardé) {
                    photoCarnet.afficher();
                    fenetre.bandeau.setText(new String[]{"17 mars.\nElle est partie. Elle a dit que c'était fini. Fini. Comme si on pouvait juste effacer des années. Comme si mon amour était une chose qu'on jette. Elle croit quoi, qu'elle va trouver mieux ? Personne ne l'aimera comme moi. Personne.",
                            "21 mars.\nJe la vois partout. Son rire résonne dans mes murs vides. Ses parfums sont encore là, dans l'air, me narguant. Je sais ce qu'elle fait. Elle vit sa vie. La sienne. Sans moi. L'idée qu'elle soit avec quelqu'un d'autre... ça me brûle de l'intérieur. Une flamme noire qui ne s'éteint pas.",
                            "28 mars.\nJ'ai trouvé la solution. Simple. Propre. Si elle ne peut pas être à moi, elle ne sera à personne. Leurs vies sans moi, leurs rires, leurs mensonges. Ça n'arrivera pas. Pas question.",
                            "3 avril.\nC'est une question de temps. Une petite modification. Un détail insignifiant pour le commun des mortels. Mais pour elle... ce sera la fin. Un accident. Personne ne se doutera de rien. J'ai pensé à tout. Les moindres détails. Mon cœur ne bat plus la chamade, il est froid. Comme de la pierre. Une pierre qui pèse lourd.",
                            "5 avril.\nC'est fait. J'ai vu l'annonce aux infos. Un accident. Elle n'a pas survécu. Le sourire sur son visage, le dernier que j'ai vu, m'a hanté un instant. Puis le vide. C'est tout ce qui reste. Juste le vide. C'est mieux comme ça. Vraiment mieux.",
                            "12 mai.\nJe traîne. Les jours, les nuits se ressemblent. Un brouillard épais. Puis je l'ai vue. Dans la rue. J'ai cru que mon cœur allait lâcher. La même démarche. Les mêmes cheveux. Et ce visage... c'est elle. Elle est là. Elle est revenue.",
                            "12 mai. (plus tard dans la nuit)\nNon. Ce n'est pas elle. Pas tout à fait. Mais c'est si proche. Incroyablement proche. Je l'ai suivie un moment. Mon sang pulsait dans mes veines. Une idée. Une folie. Mon cerveau en a une nouvelle. Une nouvelle obsession.",
                            "13 mai.\nLa camionnette. Blanche. Parfaite pour ça. Je l'ai garée au bon endroit. Elle était là, à ce même coin de rue. Un instant. Juste un instant de panique dans ses yeux. Puis l'obscurité. Elle est à moi maintenant. Dans la camionnette. Mon nouveau fardeau. Mon nouveau jouet. Et personne ne le saura. Personne. Elle me rappellera Claire. Et je pourrai recommencer. Ou finir. Je ne sais pas encore.",
                            "13 mai. (après l'avoir récupérée)\nElle est là, en bas, dans le noir. Elle ne sait pas. Elle ne comprend pas. Elle est juste... là. Une ombre. Une toile blanche pour mes pinceaux. Je la regarde, et je vois Claire. Ce n'est pas elle, je sais. Mais c'est une image assez nette pour me tromper, un instant. Elle est attachée. Pour sa sécurité, bien sûr. C'est pour son bien. Elle me remerciera un jour.",
                            "Je suis le seul maître ici. Le seul à connaître les chemins de cette maison, de ma vie. Mais si jamais quelqu'un se retrouvait dans ma cave, il faudrait bien qu'il comprenne. Qu'il comprenne mes obsessions. Pour s'en sortir, il n'y a qu'une seule voie.", "Pour sortir de ma cave, souviens-toi de mes obsessions :\n Le jour où tout a changé, la date du premier vide, avant le grand vide.\n Le nombre de fois où elle a appelé, avant que je ne décroche plus.\n L’heure gravée dans ma mémoire, l'instant précis où j'ai su qu'elle ne reviendrait jamais.\n Le poids que sur ma conscience, le fait que personne d'autre ne l'aura.\n Ces chiffres, mis dans le bon ordre, ouvriront la porte. Le savent-ils ? Se souviendront-ils ?"});
                }
                carnet.regardé = false;
            }
            while (fenetre.currentScene == digicode){
                // Ajout des chiffres au code entré quand on clique sur un bouton chiffre
                if (un.used) {
                    codeEntre += "1";
                    un.used = false;
                }
                if (deux.used) {
                    codeEntre += "2";
                    deux.used = false;
                }
                if (trois.used) {
                    codeEntre += "3";
                    trois.used = false;
                }
                if (quatre.used) {
                    codeEntre += "4";
                    quatre.used = false;
                }
                if (cinq.used) {
                    codeEntre += "5";
                    cinq.used = false;
                }
                if (six.used) {
                    codeEntre += "6";
                    six.used = false;
                }
                if (sept.used) {
                    codeEntre += "7";
                    sept.used = false;
                }
                if (huit.used) {
                    codeEntre += "8";
                    huit.used = false;
                }
                if (neuf.used) {
                    codeEntre += "9";
                    neuf.used = false;
                }
                if (zero.used) {
                    codeEntre += "0";
                    zero.used = false;
                }

                if (valider.used) {
                    if ("29462".equals(codeEntre)) {
                        fenetre.bandeau.setText("Le digicode s'ouvre, vous êtes libre !");
                    } else {
                        fenetre.bandeau.setText("Code incorrect.");
                    }
                    codeEntre = ""; // reset après validation
                    valider.used = false;
                }
            }

            fenetre.repaint();
        }
    }
}