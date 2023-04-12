fun main() {
    // write your code here
    val phoneRegex = Regex("""\(?[0-8]{3}\)?-?[0-8]{3}-?[0-8]{4}""")
    val input = readln()
    val match = phoneRegex.findAll(input)
    for (number in match) println(number.value)
    phoneRegex.containsMatchIn(word)

}
