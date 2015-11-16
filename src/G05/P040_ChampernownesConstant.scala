object P040_ChampernownesConstant {
  def main(args: Array[String]) {
      champernownesConstant();
  }

  private def champernownesConstant() {
    var product = 1
    var number = 1
    var Dn = 1000000
    var targetDigits = Array(1, 10, 100, 1000, 10000, 100000, 10000000)
    var sequence = ""

    for (Dn <- targetDigits) {
      number = 1
      var seqLength = 0
      for (noOfSequences <- 1 to 5000) {
        sequence = ""
        for (increment <- 1 to 40) {
          sequence = sequence + number.toString
          number += 1
        }
        seqLength += sequence.length

        if (Dn <= seqLength && Dn > (seqLength - sequence.length)) {
          var offset = seqLength - Dn
          //println("targetDigit2 = " + Dn)
          var digit = sequence.charAt(sequence.length - offset - 1)
          println("sequence " + sequence)
          println("targetDigit = " + Dn + ", offset = " + (seqLength - Dn).toString + ", character = " + digit)
          //println("character = " + digit)
          product *= digit.toInt - 48
        }
      }
    }
    println("product = " + product)
  }
}