package wordsvirtuoso

import java.io.FileReader
import kotlin.system.exitProcess

// Word Collection Class
class WordCollection(private val file: String) {
    val words = mutableSetOf<GameWord>()
    init {
        evaluatedWords(readWordFile())
    }
    // Read file of words
    private fun readWordFile(): String {
        return FileReader(file).use { it.readText() }
    }
    private fun evaluatedWords(wordsString: String) {
        val wordList = wordsString.split("\n")
        var invalidWordCount = 0
        for (word in wordList) {
            val wordToAdd = GameWord(word.lowercase())
            if (wordToAdd.isValidWord()) words.add(wordToAdd) else invalidWordCount++
        }
        if (invalidWordCount != 0) {
            println("Error: $invalidWordCount invalid words were found in the $file file.")
            exitProcess(0)
        }
    }
    fun includedIn(wordSet: WordCollection) {
        var notIncludedCount = 0
        for (word in words) {
            if (!wordSet.words.contains(word))
                notIncludedCount++
        }
        if (notIncludedCount != 0) {
            println("Error: $notIncludedCount candidate words are not included in the ${wordSet.file} file.")
            exitProcess(0)
        }
    }
}
