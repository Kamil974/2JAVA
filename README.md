# 2JAVA
# Projet swing java on Netbeans

![menu](https://user-images.githubusercontent.com/66492054/86806288-c9fbdb00-c089-11ea-897b-6a1c5a6b5ca9.jpg)

## Requis
Le projet a été réalisé sous NetBeans.

## Description
Le but du jeu est de représenter des canards qui se suivent dans un lac. Quand un canard naît, il se déplace dans l'étang et lorsqu'il rencontre un nénuphare, il le mange et grandit. Si un canard ne mange pas après un certain temps, il perdra du poids et finira par mourir.

## Execution
Selectionner les fichiers .java dans l'IDE Netbeans ou autres et lancer le .jar

Canvas.java est le fichier qui contient le code pour les actions au claviers & souris.
 ![a](https://user-images.githubusercontent.com/66492054/86806799-48587d00-c08a-11ea-8cab-5cb3e95fc9dd.png)
Nom de la classe & Importation d’élements

 ![b](https://user-images.githubusercontent.com/66492054/86806805-4a224080-c08a-11ea-8a76-c38889c6ce8f.png)
Définition du statut du keyboard & mouse -> down ou pas

 ![c](https://user-images.githubusercontent.com/66492054/86806808-4a224080-c08a-11ea-8c7a-b2f8fc1c6e94.png)
Utilisation d’une double mémoire tampon.
Cacher le curseur,& utiliser l’image choisit pour le remplacer
Ajout de l’écoute du clavier & souris au JPanel pour chaque action




 ![d](https://user-images.githubusercontent.com/66492054/86806810-4b536d80-c08a-11ea-8642-71434e6bfceb.png)
Element framework.java permettant le dessin 2D s’affichant à l’écran

 ![e](https://user-images.githubusercontent.com/66492054/86806814-4bec0400-c08a-11ea-8f7f-530c9b6ba9cb.png)
     @param touche utilize pour savoir son statut
     @return true si c’est down ou false si non
Ecoute de chaque actions clavier keypressed & indiquant le statut défini comme étant down ou non en Boolean
 
 ![f](https://user-images.githubusercontent.com/66492054/86806818-4d1d3100-c08a-11ea-94b7-93eaf5b68129.png)
Même chose pour la souris, écoute d’actions et indication de statuts avec les @param & @return













Duck.java est le fichier qui contient le code pour initialiser les variables en lien avec le canard et ses fonctionnalités.
 ![g](https://user-images.githubusercontent.com/66492054/86808568-0b8d8580-c08c-11ea-99e8-f1d02583c20b.png)
Temps pour la création entre chaque canard. 
 ![h](https://user-images.githubusercontent.com/66492054/86808573-0cbeb280-c08c-11ea-8d50-6696ae1b55ed.png)
   Ligne de canard , position du canard, vitesse, points que vaut le canard, coordonnes x & y du canard
 ![i](https://user-images.githubusercontent.com/66492054/86808577-0d574900-c08c-11ea-8c53-488468e4ef54.png)Init des valeurs & int Vitesse, score & intégration image du canard
 ![j](https://user-images.githubusercontent.com/66492054/86808582-0defdf80-c08c-11ea-9b3c-bbf8da5caa52.png)
Création du canard, 
x commence aux coordonnées x. Y même chose
speed = Vitesse du canard
score = combien vaut le canard
duckImg = image attribué
public void Update()
Déplacement du canard 
public void Draw(Graphics2D g2d)
Dessine le canard grâce à Graphic2D g2d
Framework.java est le fichier qui contient le code pour contrôler le game.java, l’actualise, & dessine à l’écran.

 ![k](https://user-images.githubusercontent.com/66492054/86808587-0f210c80-c08c-11ea-8a41-2f2db82e23d3.png)
Framework réutilisé dans le fichier game.java contenant des variables tels que :
Largeur/hauteur de la frame ; actualisation des fps ; état du jeu ; définition du temps ;  …

 ![l](https://user-images.githubusercontent.com/66492054/86808593-0fb9a300-c08c-11ea-9ba0-7402a43c275d.png)
Créer un nouveau processus pour lancer le jeu.
 
Ajout du son et de l’image voulu pour le jeu
 
Ces deux variables sont utilisées dans l'état de visualisation du jeu. Nous les avons utilisés pour attendre un certain temps afin d’obtenir la résolution de cadre / fenêtre correcte
On change le statut du jeu en main menu et ensuite on break. La boucle du jeu est opérationnelle.

 
 Ces variables sont utilisées pour calculer le temps qui définit pendant combien de temps nous devons mettre le threat pour atteindre le GAME_FPS. Si le temps est de moins de 10miliseconds, on met le threat en veille pour qu’un autre threat s’active.



 
Menu principal & ses caractéristiques
  Nouvelle partie
 Reset les variables & restart le jeu.

 
Recentrage de la souris dans la fenetre a X et Y = 0
Les actions à effectuer lorsque la touche échap est utilisé.
 
Action lorsque la touche gauche de la souris est appuyé pendant le menu, démarrer le jeu.



Game.java est le fichier qui contient le code pour 
 
Variable initialisé + création de threat & chargement des frameworks
 
Ajout des variables tels que canard en fuite, canard tué, score, tirs. Temps entre les tirs.
 
Chargement des images du jeux.
  Reset complète d’une partie pour restart.
 
On créer un canard, on l’ajoute à l’array list.
On augmente nextDuckLines  pour que le prochain canard soit créer à la ligne suivant.
Ensuite on met à jour l’affichage : ducks.get(i).Update();
Déplacement du canard & suppression du canard si il quitte l’écran. 
 
On veut savoir si le joueur tir, on vérifie ses tirs.
On parcours les canards et on vérifie si la position du curseur. 
Ensuite on le supprime de la arraylist, en updatant le score et les tirs et sortant de la boucle
On quitte si 200 canards se sont enfuits.
 
Ici on dessine les canards à l’écran grâce aux framework & on affiche les statuts enfuis, morts etc.
 
Ici on dessine le gameover à l’écran, le texte etc.

Window.java est le fichier qui contient le code pour 
 
Ici on définit le titre de la frame, la taille de la frame et on désactive les décorations.
On définit en plein écran, autrement c’est du fenêtré, sa taille est de 800x600 centré à l’écran. On l’empêche d’être resizer par l’utilisateur. Lorsque que le frame est fermé on quitte.
On réparti les thread pour la sécurité de performance.



Voici les images du jeu :
![sight](https://user-images.githubusercontent.com/66492054/86806158-a6d12b80-c089-11ea-9753-4159fa448db5.png)
![background](https://user-images.githubusercontent.com/66492054/86806164-a8025880-c089-11ea-8c54-32757e973136.jpg)
![duck](https://user-images.githubusercontent.com/66492054/86806181-aafd4900-c089-11ea-96a4-f1cb90c02131.png)
![grass](https://user-images.githubusercontent.com/66492054/86806184-ab95df80-c089-11ea-8bde-a8e43761c3b8.png)
![menu](https://user-images.githubusercontent.com/66492054/86806288-c9fbdb00-c089-11ea-897b-6a1c5a6b5ca9.jpg)

