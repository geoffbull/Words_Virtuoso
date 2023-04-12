fun main() {
    val text = readLine()!!
    val regexColors = "#[0-9a-fA-F]{6}\\b".toRegex()
    val colours = regexColors.findAll(text)
    for (colour in colours) println(colour.value)
    // write your code here
}
