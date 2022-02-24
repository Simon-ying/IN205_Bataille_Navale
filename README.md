# Bataille Navale

C'est un jeu de bataille navale en ligne de commande.

## Etapes du jeu

### Prérequis

1. Exécuter le fichier `Main.java` dans `Eclipse` pour commencer le jeu.
2. Si le joueur veut commencer un nouveau jeu, il faut supprimer le fichier `savegame.dat`. Sinon, le joueur continuera avec la sauvegarde précédente.

### Début

1. Choisir mode du jeu, jouer en binôme (multi-player mode) ou jouer tout seul.
2. Déterminer la position et l'orientation de chaque navire en tapant une ligne de texte comme `a1 north` , si on est dans le "muti-player mode" les deux joueurs détermineront les information naval par ordre. (Je vous conseille de ne pas regarder les informations naval d'autre joueur)

### Règle de jeu

1. chaque fois, un joueur frappe un endroit de son adversaire en tapant une ligne de texte comme `a1` , s'il réussit à touché un navire adverse, il peut continuer à frapper autre endroit. Sinon, c'est le tour d'autre joueur.
2. Chaque type de navire a la vie différentes, si le nombre de touche est supérieur à la vie de navire, il va couler. Le joueur dont tous les navires ont coulé va échouer le jeu.



## Notation du jeu

Dans ce jeu, on a deux plan, on affiche les positions des navires et des frappes.

### Plan des navires

- caractère jeune : la queue de navire
- caractère blanc : les autres parties de navire
- caractère rouge : le navire concerné a coulé
- `*` : espace inconnu
- `.` : espace vide



### Plan des frappes

- `X` blanc : frappe manqué
- `X` rouge : frappe touché
- `X` vert : frappe sur un navire coulé
- `.` : espace vide



Amuser-vous bien !
