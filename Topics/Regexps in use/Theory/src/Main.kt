// You can experiment here, it won’t be checked

fun main(args: Array<String>) {
  val string = "A_modern_programming_language_that_makes_developers_happier"
  var result: String = ""
    var list = string.split("_")
    for (word in list) {
      result += word.replaceFirstChar { it.uppercase() }
    }

    print(result)
  }

