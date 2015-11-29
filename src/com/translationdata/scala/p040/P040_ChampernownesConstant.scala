package com.translationdata.scala.p040

object P040_ChampernownesConstant {
  def main(args: Array[String]) {
      champernownesConstant;
  }

  private def champernownesConstant {
    var product = 1
    var number = 1
    val targetDigits = Array(1, 10, 100, 1000, 10000, 100000, 10000000)
    var sequence = ""
    
    for (nthDigit <- targetDigits) {
      //targetDigits 
      number = 1
      
      // TODO: Convert var to val...
      var totalSeqLength = 0
      for (noOfSequences <- 1 to 5000) {
        sequence = ""
        for (increment <- 1 to 40) {
          sequence = sequence + number.toString
          number += 1
        }
        totalSeqLength += sequence.length
        product = calcProduct(nthDigit, sequence, totalSeqLength, product)
      }
    }
    println("Product d1 � d10 � ... � d1000000 = " + product)
  }

  private def isDigitInSequence(nthDigit: Int, sequence: String, totalSeqLength: Int):Boolean = {
    nthDigit <= totalSeqLength && nthDigit > (totalSeqLength - sequence.length);
  }

  private def calcProduct(nthDigit: Int, sequence: String, totalSeqLength: Int, product: Int): Int = {
    if (isDigitInSequence(nthDigit, sequence, totalSeqLength)) {
      val offset = totalSeqLength - nthDigit
      val digit = sequence.charAt(sequence.length - offset - 1)
      //println("sequence " + sequence)
      //println("targetDigit = " + nthDigit + ", offset = " + (totalSeqLength - nthDigit).toString + ", character = " + digit)
      product * (digit.toInt - 48)
    } else
      product
  }
}
