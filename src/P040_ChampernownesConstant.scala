object P040_ChampernownesConstant {
  def main(args: Array[String]) {
      champernownesConstant();
  }

  private def champernownesConstant() {
    var product = 0
    var number = 1

    var powers = Array(1, 10, 100, 1000)

    for (number <- powers)
      println(number)
    var sequence = ""

    number = 1
    for( i <- 1 to 3) {
      sequence = ""
      for (j <- 1 to 10) {
    	  sequence = sequence.concat( number.toString() )
        number += 1
      }
      println(sequence + ", length = " + sequence.length() )
    }
    
  }
}