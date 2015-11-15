object P040_ChampernownesConstant {
  def main(args: Array[String]) {
      champernownesConstant();
  }

  private def champernownesConstant() {
    var product = 1
    var number = 1
    var targetDigit = 111
    println("target characeter = " + targetDigit)

    var powers = Array(1, 10, 100, 1000)
    //println("powers size = " + powers.size)

    /*for (number <- powers)
      println(number)*/
    var sequence = ""

    //  TODO: Loop through target digits
    number = 1
    var seqLength = 0
    for( noOfSequences <- 1 to 10) {
      sequence = ""
      for (increment <- 1 to 15) {
    	  sequence = sequence + number.toString
        number += 1
      }
      seqLength += sequence.length

      if ( targetDigit <= seqLength && targetDigit > (seqLength - sequence.length) ) {
        var offset = seqLength - targetDigit
        println( "offset = " + (seqLength - targetDigit).toString )
        println( "sequence " + sequence )
        var digit = sequence.charAt( sequence.length - offset - 1)
        println( "character = " + digit )
        product *= digit.toInt - 48
        // TODO: Get next target digit
      }
    }
    println("product = " + product)
  }
}