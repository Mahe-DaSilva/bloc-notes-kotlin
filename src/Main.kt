import java.io.File
import kotlin.text.trim

const val RESET = "\u001B[0m"
const val RED = "\u001B[31m"
const val GREEN = "\u001B[32m"
const val BLUE = "\u001B[34m"

fun normNomFichier(nom: String): String {
    return nom
        .trim()
        .replace(" ", "_")
        .replace(Regex("[^A-Za-z0-9_\\-]"), "")
        .trim('_')
}

fun demanderNomNote(action: String): String {
    print("${BLUE}Nom de la note $action : $RESET")
    val nomSaisi = readln()
    return normNomFichier(nomSaisi)
}

fun blocNotes(){

    val dossier = File("mes_notes")
    if (!dossier.exists()){
        dossier.mkdir()
    }

    while (true){
        println("===== Bloc-notes =====")
        println("1. Créer une note")
        println("2. Modifier une note")
        println("3. Lire une note")
        println("4. Supprimer une note")
        println("5. Afficher toutes les notes")
        println("6. Quitter")

        print("\n${BLUE}Choix : $RESET")
        val choix = readln().trim()

        when (choix) {
            "1" -> creerNote(dossier)
            "2" -> modifierNote(dossier)
            "3" -> lireNote(dossier)
            "4" -> supprimerNote(dossier)
            "5" -> afficherNotes(dossier)
            "6" -> {
                println("${GREEN}À bientôt !$RESET")
                return
            }
            else -> println("${RED}Choix invalide$RESET")
        }
    }
}

fun creerNote(dossier: File){
    println()

    var noteCree = false
    while (!noteCree) {

        val nomFichier = demanderNomNote("à créer")

        val fichiers = dossier.listFiles() ?: arrayOf()
        val fichierExistant = fichiers.find { it.nameWithoutExtension.equals(nomFichier, ignoreCase = true) }

        if (fichierExistant != null) {

            println("${RED}Une note portant ce nom existe déjà !$RESET")
            println("1. Écraser la note existante")
            println("2. Choisir un nouveau nom")
            print("${BLUE}Choix : $RESET")
            when (readln().trim()) {
                "1" -> {
                    print("${BLUE}Contenu à ajouter à $nomFichier : $RESET")
                    val contenu = readln()
                    fichierExistant.writeText(contenu + "\n")
                    println("${GREEN}La note \"$nomFichier\" a été écrasée.$RESET\n")
                    noteCree = true
                }
                "2" -> continue  // boucle pour demander un nouveau nom
                else -> println("${RED}Choix invalide$RESET\n")
            }
        } else {

            print("${BLUE}Contenu à ajouter à $nomFichier : $RESET")
            val contenu = readln()
            val fichier = File(dossier, "$nomFichier.txt")
            fichier.writeText(contenu + "\n")
            println("${GREEN}La note \"$nomFichier\" a été créée.$RESET\n")
            noteCree = true
        }
    }
}

fun modifierNote(dossier: File){
    afficherNotes(dossier)

    val nomNorm = demanderNomNote("à modifier")

    val fichiers = dossier.listFiles() ?: arrayOf()
    val fichier = fichiers.find { it.nameWithoutExtension.equals(nomNorm, ignoreCase = true) }

    if (fichier != null){
        println("1. Ajouter du contenu à \"$nomNorm\"")
        println("2. Remplacer le contenu actuel de \"$nomNorm\"")
        print("${BLUE}Choix : $RESET")
        when (readln().trim()){
            "1" -> {
                print("${BLUE}Contenu à ajouter : $RESET")
                val contenu = readln()
                fichier.appendText(contenu + "\n")
                println("${GREEN}La note \"$nomNorm\" a été mise à jour.$RESET\n")
            }
            "2" -> {
                print("${BLUE}Nouveau contenu : $RESET")
                val contenu = readln()
                fichier.writeText(contenu + "\n")
                println("${GREEN}La note \"$nomNorm\" a été mise à jour.$RESET\n")
            }
            else -> println("${RED}Choix invalide$RESET\n")
        }
    } else {
        println("${RED}Cette note n'existe pas.$RESET\n")
    }
}

fun lireNote(dossier: File){
    afficherNotes(dossier)

    val nomNorm = demanderNomNote("à lire")

    val fichiers = dossier.listFiles() ?: arrayOf()
    val fichier = fichiers.find { it.nameWithoutExtension.equals(nomNorm, ignoreCase = true) }

    if (fichier != null){
        println("\n--- Contenu ---")
        println(fichier.readText())
    } else {
        println("${RED}Cette note n'existe pas.$RESET\n")
    }
}

fun supprimerNote(dossier: File){
    afficherNotes(dossier)

    val nomNorm = demanderNomNote("à supprimer")

    val fichiers = dossier.listFiles() ?: arrayOf()
    val fichier = fichiers.find { it.nameWithoutExtension.equals(nomNorm, ignoreCase = true) }

    if (fichier != null){
        fichier.delete()
        println("${GREEN}La note \"$nomNorm\" a été supprimée.$RESET\n")
    } else {
        println("${RED}Cette note n'existe pas.$RESET\n")
    }
}

fun afficherNotes(dossier: File){
    println()

    val fichiers = dossier.listFiles()
    if (fichiers.isNullOrEmpty()){
        println("${RED}Aucune note disponibles$RESET")
    } else {
        println("Notes disponibles :")
        fichiers.forEach { println("- ${it.nameWithoutExtension}") }
    }
    println()
}


fun main() {
    println()
    blocNotes()
}