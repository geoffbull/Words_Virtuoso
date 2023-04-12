package wordsvirtuoso
import  java.io.*
// Main - To run you need to add two words list to be read for use in the game 
fun main(args: Array<String>) {

    fun filesAreValid(): Boolean {
        if (args.size != 2) {
            println("Error: Wrong number of arguments.")
            return false
        }
        try {
            val file = FileReader(args[0])
            file.close()
        } catch(e: FileNotFoundException) {
            println("Error: The words file ${args[0]} doesn't exist.")
            return false
        }
        try {
            val file = FileReader(args[1])
            file.close()
        } catch(e: FileNotFoundException) {
            println("Error: The candidate words file ${args[1]} doesn't exist.")
            return false
        }
        return true
    }

    if(filesAreValid()) {
        val wordSearch = WordVirtuoso(args[0], args[1])
        wordSearch.mainMenu()
    }

}
