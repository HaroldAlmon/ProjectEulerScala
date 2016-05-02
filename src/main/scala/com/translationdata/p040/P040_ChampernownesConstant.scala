package com.translationdata.p040
import org.junit.Test
import org.junit.Assert._

object P040_ChampernownesConstant {
  def main(args: Array[String]) = champernownesConstant

  private def champernownesConstant = {
    var product = 1
    var number = 1
    val targetDigits = Array( 1, 10, 100, 1000, 10000, 100000, 10000000 )

    for ( nthDigit <- targetDigits ) {
      number = 1
      
      // TODO: Convert var to val...
      var totalSeqLength = 0
      for ( noOfSequences <- 1 to 5000 ) {
        var sequence = ""
        for ( increment <- 1 to 40 ) {
          sequence = sequence + number.toString
          number += 1
        }
        totalSeqLength += sequence.length
        product = calcProduct( nthDigit, sequence, totalSeqLength, product )
      }
    }
    product
  }
// Todo: convert to lambda expression
  private def isDigitInSequence( nthDigit: Int, sequence: String, totalSeqLength: Int) = {
    nthDigit <= totalSeqLength && nthDigit > ( totalSeqLength - sequence.length )
  }

  private def calcProduct( nthDigit: Int, sequence: String, totalSeqLength: Int, product: Int ) = {
    if ( isDigitInSequence( nthDigit, sequence, totalSeqLength ) ) {
      val offset = totalSeqLength - nthDigit
      val digit = sequence charAt ( sequence.length - offset - 1 )
      product * ( digit.toInt - 48 )
    } else
      product
  }
}

class P040_ChampernownesConstant {
  @Test def champernownesConstant() = {
    val product = P040_ChampernownesConstant.champernownesConstant

    println("P040: Product d1 x d10 x ... x d1000000 = " + product)
    assertEquals(210, product)
  }
}

