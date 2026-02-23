# Bloc Note Kotlin

Ce **bloc note kotlin** est un petit programme écrit en kotlin.
Il fonctionne dans le terminal de commande et permet à l'utilisateur de créer, lire, modifier et supprimer des notes facilement.
Le programme utilise une gestion des fichiers basique pour sauvegarder les notes en local et les gérer facilement avec une interface textuelle interactive.

---

### Fonctionnalités
- Créer des notes dans un dossier ***mes_notes***
- Lire une note présente dans le dossier
- Modifier une note présente dans le dossier
- Supprimer une note présente dans le dossier
- Lister toutes les notes présentes dans le dossier

---

### Comment ça marche ?
Tout se passe dans la console une fois le code lancé.
Au démarrage, le menu est affiché directement les instructions sont ensuite données par l'utilisateur.
Les notes sont stockées localement sous forme de fichiers .txt et l'utilisateur interagit avec grâce à une interface textuelle dans le terminal.

---

### Prérequis
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) avec le plugin **Kotlin (version 2.0 ou supérieure)**
- Ou **Kotlin 2.0+** installé manuellement sur votre machine

---

### Structure du code
Le code est composé de façon très simple avec un menu provenant de la fonction ***blocNotes***, appelé au lancement par la fonction ***main***, qui permet d'appeler toutes les fonctions servant à réaliser les actions demandées par l'utilisateur.
Une fonction de standardisation des noms ***normNomFichier*** a été ajoutée, elle limite légèrement la liberté de création de noms pour les notes mais facilite grandement leur gestion dans l'interface textuelle.

---

### Structure du projet
Le projet n'est composé que du dossier ***src*** contenant le fichier ***Main.kt*** où est écrit le code source et du fichier ***README.md*** qui contient ce document de présentation rédigé en ***MarkDown***

---

### Objectifs
Ce programme a été créé dans le cadre d'un hackathon sur la plateforme ***Devpost***, avec pour objectif de proposer une mini application une interface en ligne de commande la plus intuitive et facile d'utilisation possible.
La version finale présentée est en anglais et est disponible sur mon GitHub avec pour nom ***kotlin-notepad-cli***, il contient un ***README*** plus complet avec des captures d'écran si le projet vous intéresse.

---

### Auteur
Projet développé en autodidacte par Mahé Da Silva, élève en classe de terminale spécialité mathématiques et NSI
