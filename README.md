#Art Space App

Une application Android interactive développée avec Kotlin et Jetpack Compose, qui permet à l’utilisateur de parcourir une galerie d’œuvres d’art.
Chaque œuvre affichée comprend une image, un titre, le nom de l’artiste et l’année de création.
La navigation est fluide et circulaire grâce à deux boutons permettant d’afficher l’œuvre précédente ou suivante.
L’interface est sobre, responsive et centrée à l’écran.

#Fonctionnement du projet

Au lancement de l’application, une œuvre d’art est affichée avec son image, son titre et le nom de son auteur.
L’utilisateur peut utiliser les boutons "Previous" et "Next" pour faire défiler les œuvres une par une.
Les images couvrent entièrement le cadre prévu avec un effet de carte arrondie et une ombre portée.
La navigation est cyclique : après la dernière œuvre, on revient à la première, et inversement.
L’état de l’image affichée est géré dynamiquement via Compose avec mutableIntStateOf.

#Technologies utilisées

Kotlin
Jetpack Compose
Android Studio version Meerkat Feature Drop 2024.3.2 Patch 1
