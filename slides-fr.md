% Spécifications Exécutables
% Arnaud Bailly - Jonathan Perret
% 13/09/2011

# Plan

* 15': Principes des "tests d'acceptation" Agile
* 30': Exercice de _Spécification par l'Exemple_
* 15': Conclusion & Perspectives

# TDD

- Pratique centrale de XP, test unitaire, "Test First development"
- Tests orientés technologie qui soutiennent l'équipe
- *Idée fausse*: TDD est une technique pour créer des tests de
   regression 
- TDD est un outil pour guide le développement vers une "Conception
  Simple"

# BDD


> BDD is ....

Dan North

- ["TDD done right" ?](http://codebetter.com/jeremymiller/2007/09/06/bdd-tdd-and-the-other-double-d-s/)
- Remonter le niveau d'abstraction des "tests" à celui des "User
  Stories": Le "Quoi faire?" plutôt que le "Comment faire?"
- Définition fluctuante et changeante, souvent liée à des outils:
  RSpec, jBehave, jDave...

# ATDD

- *Acceptance Test-Driven Development* ou Développement Dirigé par les
   Tests de Recette
- Mise en place AA-FTT Workshop à partir d'Agile 2008
- Comment intégrer la pratique du test et les testeurs dans les
  équipes Agile ?
- Que deviennent les spécifications dans les projets Agile ?
- La *Recette* est un terme _contractuel_ or l'Agilité promeut la
  collaboration sur le contrat : quid des "Tests de recette" ?

#  Les quadrants de Marick

![](figures/marick-quadrants.jpg)

# Des tests orienté-métiers pour soutenir l'équipe

- Tests définis du point de vue de l'usage du produit, des
  utilisateurs
- Même approche que le TDD:
   - Expliciter les besoins  *avant* de développer: Quel est la
     fonctionalité que l'on souhaite produire ?
   - Construire une suite de tests de régression pour vérifier que des
     développements futurs ne cassent rien
- Collaborer pour:
   - Développer le *bon logiciel*, celui qui est attendu par les
     utilisateurs
   - Ne pas développer des fonctionnalités inutiles
   - Ne pas accumuler de dette technique et maintenir l'existant

# Les techniques traditionnelles...

- Test d'applications de bout en bout (ou *End-to-End Testing*)
- Test manuel scripté (ou *Monkey testing*)
- Scripts enregistrés et rejoués à la demande
- Tests contre une version *golden*

# ... ne sont pas appropriées

- Approche centrée sur des *outils* pour tester la *régression* d'un système
- Des tests fragiles qui entraînent des coûts de maintenance très élevés
- Des tests lents qui diminuent le "feedback"
- Des tests peu efficaces dans la détection des "bugs" ([How Many Bugs Do Regression Tests Find](http://www.qanc.co.kr/4research_0402_download.htm?data_no=54&name=Brian%20Marick-How%20Many%20Bugs%20Do%20Regression%20Tests%20Find.pdf))

# Formaliser les spécifications ?

- Approche _pilotage par les modèles_
- Travailler à un niveau d'abstraction plus élevé mais plus compréhensible pour les utilisateurs
- Automatiser le processus de réalisation du système à partir des modèles pour garantir la cohérence
- *Mais* modéliser, c'est déjà coder : on ne peut pas *automatiquement* produire une information qui n'est pas déjà dans le modèle

# Les problèmes que l'on cherche à résoudre

![](figures/sbe-before.jpg)

# La Spécification par l'exemple

> "Pour établir une pratique, les règles ne suffisent pas; on a également besoin d'exemples"

L.Wittgenstein, *De la certitude*, 1969

# La Spécification par l'exemple

- _ATDD Done Right !_
- Grandement inspiré par les travaux de Gojko Adzic et d'autres dans la communauté du Test Agile (Lisa Crispin, Janet Gregory, Brian Marick...) 
- On parlera aussi de  *Spécification Exécutable*, mais:
   - Une *spécification* est elle-même un encodage du problème considéré
   - On ne parle ici que d'exemples, ç.à.d. un *échantillonage* de l'espace du problème/des solutions
   - Terme plutôt en faveur pour des spécifications formelles 

# Définir le "Quoi?" 

- Spécification de "stories" par-delà le post-it
- Une "story" devrait être une opportunité de conversation, mais comment savoir quand
  nous avons fini ?
- Les *exemples* soutiennent la conversation, offrent des points d'appui pour étudier de nouvelles perspectives
- Ils sont nécessairement incomplets, mais *cadrent* le travail du développeur
- Mais **Attention** nous voulons construire un produit…

# Faire vivre le produit

- Les "stories" représentent le *chemin* que nous suivons pour développer
  le logiciel : chaque "story" modifie le *produit* d'une façon spécifique
- Mais le *produit* n'est pas la somme des "stories" : il n'est pas possible
  de reconstruire la séquence exacte de "stories" implémentées étant donné
  un état particulier du produit (sauf à consulter le système de gestion de versions,
  bien sûr)
- D'où la question : faut-il garder touse es tests que nous écrivons
  pour implémenter les "stories" ? 
- Et la réponse est : "Probablement non !"
- Les tests comme le code doivent être "refactorés", évoluer avec le produit/système
  
# Faire évoluer les Tests

  1. Définir les tests de recette pour une "story" donnée avant le
     début du codage, les écrire comme ils viennent sous forme
     exécutable
  2. Une fois la "story" finie, transformer les tests en
     *exemples de spécification* : les regrouper avec l'ensemble
     des tests pour la fonctionnalité que cette "story" ajoute
     ou complète
  3. Utiliser le *test exploratoire* pour améliorer les spécifications du produit, et ce faisant
     créer de nouvelles "stories". En particulier, 
     les testeurs (et les développeurs bien sûr) sont habiles à
     trouver des cas extrêmes, des chemins non couverts, des
     contradictions…

# Ecrire les exemples

- *Les gens et leurs interactions avant les processus et les outils*, l'automatisation ne doit pas être un pré-requis
- Automatiser l'exécution des exemples permet de maximiser le "feedback" fourni par ces tests
- **Attention** à ne pas retomber dans les ornières des suites de tests de régression classiques: trop lent, trop lourd, pas maintenable... 
- **Attention** aux exemples *scriptés*
- **Préférer** des exemples métiers, sans référence à l'IHM, sans script

# Ecrire les exemples

- **Proposition**: Utiliser des formes contraintes pour décrire les spécifications
- 1 story = But/Rôle/Action
- **Afin** d'atteindre un certain but un **Utilisateur** **Veut** réaliser une action
- 1 exemple = Etant donné/Quand/Alors
- **Etant donné** un certain état du système **Quand** l'utilisateur fait quelque chose **Alors** le système atteint tel état
- Ne pas confondre le *quoi* et le *comment*
- Ne pas oublier le *pourquoi*

# Mieux communiquer

> C'est donc que “suivre la règle” est une pratique. Croire que l'on suit la règle n'est pas la suivre. 
> C'est donc aussi qu'on ne peut pas suivre la règle privatim ; sinon croire que l'on suit la règle serait la même chose que la suivre. 

L.Wittgenstein, *Recherches Philosophiques*, §202, 1953

- On cherche à construire une  **documentation vivante** qui ne soit pas que le code
- Noeud de communication entre les différents rôles de l'équipe (testeurs, experts métiers, développeurs, designers...)
- Automatiser l'exécution de

# Références

* Gojko Adzic, _Specification By Example_, Manning 2011
* Gojko Adzic, _Bridging the Communication Gap_, Neuri 2009
* L.Crispin & J.Gregory, _Agile Testing_, Addison-Wesley, 2009

