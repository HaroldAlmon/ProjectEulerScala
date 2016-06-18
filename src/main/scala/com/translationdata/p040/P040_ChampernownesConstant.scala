package com.translationdata.p040
package com.translationdata.prototypes

import org.junit.Assert._
import org.junit.Test

object P040_ChampernownesConstant {
  val targetDigits = Array( 1, 10, 100, 1000, 10000, 100000, 10000000 )

  def main(args: Array[String]) = champernownesConstant

  private def champernownesConstant = {
    var product = 1
    var number = 1

//    for ( nthDigit <- targetDigits ) {
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
        product = calcProduct( 1, sequence, totalSeqLength, product )
      }
 //   }
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

  private def calcProductNew( nthDigit: Int, sequence: String, totalSeqLength: Int, product: Int, count: Int, limit: Int ) = {
    if ( isDigitInSequence( nthDigit, sequence, totalSeqLength ) ) {
      val offset = totalSeqLength - nthDigit
      val digit = sequence charAt ( sequence.length - offset - 1 )
      (product * ( digit.toInt - 48 ), nthDigit * 10)
    } else
      (product, nthDigit)
  }

  def outerLoop(targetDigit: Int) : (Int, Int) = {
    outerLoopImpl(targetDigit, (1,1), 1, 5000)
  }

  def outerLoopImpl(targetDigit: Int, productTuple: (Int, Int), count: Int, limit: Int) : (Int,Int) = {
    if (count < limit && targetDigit <= 10000000) {
      val sequence = makeSequence(count)
      productTuple match {
        case (product, nextDigit) =>
          val pt = calcProductNew(nextDigit, sequence, sequence.length, product, count, limit)

          return outerLoopImpl(targetDigit,
            pt, // product argument
            count + 40,
            limit)
      }
    }
    productTuple
  }


  def makeSequence(startNum:Int):String = {
    val sequence = makeSequenceImpl("", startNum, startNum + 40)
    sequence
  }
  def makeSequenceImpl(sequence:String, position:Int, limit: Int): String = {
    if ( position >= limit )
      return sequence
    makeSequenceImpl(sequence + position.toString, position + 1, limit)
  }
}

class P040_ChampernownesConstant {
  @Test def champernownesConstant() = {
    var outerLoop = P040_ChampernownesConstant.outerLoop(1)
    val result = P040_ChampernownesConstant.makeSequence(1)
    val product = P040_ChampernownesConstant.champernownesConstant

    println("P040: Product d1 x d10 x ... x d1000000 = " + product)
    assertEquals(210, product)
  }
}

