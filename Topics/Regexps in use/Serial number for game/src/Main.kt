fun findSerialNumberForGame(listGames: List<String>) {
   val gameInput = readln()
   var gameString: String = ""
   for (game in listGames) {
       try {
            if (gameInput.toRegex().find(game)!!.value.isNotEmpty()) {
                gameString = game
           }  
       } catch(e: Exception) {
           continue
       }  
   }
   if(gameString.isNotEmpty()) {
        val xboxSerial = Regex("@\\d+@").find(gameString)!!.value.replace("@", "")
       val pcSerial = Regex("@\\d+\\Z").find(gameString)!!.value.replace("@", "")

       println("Code for Xbox - $xboxSerial, for PC - $pcSerial")
   }
  
}
