package wordsvirtuoso

// Game word class
class GameWord(val word: String) {
    // Word Check Helpers
    private fun isFiveLetters(printError: Boolean = false): Boolean {
        return when {
            word.length == 5 -> true
            printError -> {
                println("The input isn't a 5-letter word.")
                false
            }
            else -> false
        }
    }

    private fun isAllAlpha(printError: Boolean = false): Boolean {
        return when {
            word.matches(Regex("^[a-z|A-Z]{5}\$")) -> true
            printError -> {
                println("One or more letters of the input aren't valid.")
                false
            }
            else -> false
        }
    }
    private fun hasNoDuplicates(printError: Boolean = false): Boolean {
        for (letter in word.lowercase()) {
            if (word.lowercase().count {it == letter} > 1) {
                if (printError) {
                    println("The input has duplicate letters.")
                }
                return false
            }
        }
        return true
    }
    // Check if word is word set
    fun wordIn(wordSet: WordCollection, printError: Boolean = true): Boolean {
        return when {
            wordSet.words.contains(this) -> true
            printError -> {
                println("The input word isn't included in my words list.")
                false
            }
            else -> false
        }
    }
    // Check word is valid
    fun isValidWord(printError: Boolean = false): Boolean {
        if (printError) {
            return when  {
                !isFiveLetters(true) -> false
                !isAllAlpha(true) -> false
                else -> hasNoDuplicates(true)
            }
        }
        return when {
            !isFiveLetters() -> false
            !isAllAlpha() -> false
            else -> hasNoDuplicates()
        }
    }

    /*
        Override equals function and hashCode to compare two SecretWords
        !!this must always be done to compare two class instance!!
    */
    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (this === other) return true
        if (other !is GameWord) return false
        if (word != other.word) return false
        return true
    }
    // Override hash code
    override fun hashCode(): Int { return word.hashCode() }
    // Override toString function
    override fun toString(): String { return word}
}