package G05

object P040_ChampernownesConstant {
  def main(args: Array[String]) {
      champernownesConstant();
  }

  private def champernownesConstant() {
    var product = 1
    var number = 1
    val targetDigits = Array(1, 10, 100, 1000, 10000, 100000, 10000000)
    var sequence = ""

    for (nthDigit <- targetDigits) {
      number = 1
      var seqLength = 0
      for (noOfSequences <- 1 to 5000) {
        sequence = ""
        for (increment <- 1 to 40) {
          sequence = sequence + number.toString
          number += 1
        }
        seqLength += sequence.length

        if (nthDigit <= seqLength && nthDigit > (seqLength - sequence.length)) {
          var offset = seqLength - nthDigit
          var digit = sequence.charAt(sequence.length - offset - 1)
          println("sequence " + sequence)
          println("targetDigit = " + nthDigit + ", offset = " + (seqLength - nthDigit).toString + ", character = " + digit)
          product *= digit.toInt - 48
        }
      }
    }
    println("Product d1 × d10 × ... × d1000000 = " + product)
  }
}

