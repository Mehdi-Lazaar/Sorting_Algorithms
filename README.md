# Sorting_Algorithms
## Projet sur la complexité  des algorithmes de tri
Comparaison des algorithmes de tri : tri à Bulles, tri rapide, tri par dénombrement. Le tri s'effectue sur un tableau d'éléments.
Les éléments comportent un champ clé (entier positif ou nul ) et un champ contenu (qui pourrait être quelconque, mais nous supposerons que c'est un réel)
Le programme prendra en entrée le tableau, qui pourra être lu au clavier  (pour tester sur de petits tableaux) ou avoir été généré aléatoirement (pour tester des tableaux de grande taille).
A la fin de l'exécution, le même tableau contiendra les éléments, triés par ordre croissant des clés. Attention à bien respecter la correspondance entre une clé et le contenu associé.
### Tri à bulles
La version du tri à Bulles doit implémenter les deux optimisations évidentes: diminution  à chaque  itération de la taille des sous tableaux à trier, et détection que le tri est terminé.
### Tri rapide
La version du tri rapide utilisera obligatoirement le premier élément du sous-tableau courant comme pivot, et devra être récursive.
### Tri par dénombrement
La version du tri par dénombrement devra respecter l'ordre initial des éléments en cas de clés identiques.
### Les comparaisons entre les tris
Les comparaisons entre les tris se feront de deux façons. D'abord grâce à un comptage des opérations élémentaires : comparaison de clés, affectation (clés ou éléments), ensuite par la récupération du temps d'exécution. Ce sont les temps d'exécution qui seront  les outils de la comparaison.
Vous devrez rendre une présentation courte de chaque tri, le code java, et des courbes, que vous commenterez,  du temps d'exécution en fonction de la taille du tableau. Les tailles doivent être suffisamment grandes pour pouvoir vérifier les différences de comportement des algorithmes
