package wordsvirtuoso

import kotlin.random.Random
import kotlin.system.exitProcess

// Class for the game
class WordVirtuoso(file1: String, file2: String) {
    private val allWords = WordCollection(file1)
    private val candidateWords = WordCollection(file2)
    private val secretWord = selectSecretWord()
    private var guesses = mutableListOf<String>()
    private var alreadyUsedWrongLetters = mutableSetOf<String>()
    private var clueList = mutableListOf<String>()
    private var start: Long = 0

    // Main menu
    fun mainMenu() {
        candidateWords.includedIn(allWords)
        println("Words Virtuoso")
        gameLoop()
    }
    // Select game word
    private fun selectSecretWord(): GameWord {
        val randomIndex = Random.nextInt(0, candidateWords.words.size)
        return candidateWords.words.elementAt(randomIndex)
    }
    // game loop
    private fun gameLoop() {
        start = System.currentTimeMillis()
        game@while(true) {
            println("Input a 5-letter word:")
            val input = GameWord(readln())
            if (input.word == "exit") {
                println("The game is over.")
                exitProcess(0)
            }
            if (!input.isValidWord(true))continue@game
            if (!input.wordIn(allWords))continue@game
            guesses.add(input.word)
            checkGuess(input)
        }
    }
    // check each guess
    private fun checkGuess(guess: GameWord) {
        var clue = String()

        for (i in 0 until guess.word.length) {
            clue += when {
                guess.word[i] == secretWord.word[i] -> {
                    "\u001B[48:5:10m${guess.word[i].uppercase()}\u001B[0m"
                }

                secretWord.word.contains(guess.word[i]) -> {
                    "\u001B[48:5:11m${guess.word[i].uppercase()}\u001B[0m"
                }

                else -> {
                    alreadyUsedWrongLetters.add(guess.word[i].uppercase())
                    "\u001B[48:5:7m${guess.word[i].uppercase()}\u001B[0m"
                }
            }
        }
        clueList.add(clue)
        clueList.forEach {  println(it) }
        if (guess.word == secretWord.word) {
            val end = System.currentTimeMillis()
            println("Correct!")
            if (guesses.size == 1) {
                println("Amazing luck! The solution was found at once.")
            } else {
                println("The solution was found after ${guesses.size} tries in ${(end - start)/1000} seconds.")
            }
            exitProcess(0)
        }
        println("\u001B[48:5:14m${alreadyUsedWrongLetters.sorted().joinToString("")}\u001B[0m")
    }
}