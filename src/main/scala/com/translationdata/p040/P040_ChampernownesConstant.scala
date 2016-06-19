package com.translationdata.p040
package com.translationdata.prototypes

import org.junit.Assert._
import org.junit.Test

object P040_ChampernownesConstant {
  val targetDigits = Array( 1, 10, 100, 1000, 10000, 100000, 10000000 )

  def main(args: Array[String]) = champernownesConstant

  private def champernownesConstant = {
    outerLoop(100) match {
      case(product, nthDigit) => product
    }
  }

  // Todo: convert to lambda expression
  private def isDigitInSequence( nthDigit: Int, sequence: String, totalSeqLength: Int) = {
    nthDigit <= totalSeqLength && nthDigit > ( totalSeqLength - sequence.length )
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
    outerLoopImpl(targetDigit, (1,targetDigit), 1, 5000, 0)
  }

  def outerLoopImpl(targetDigit: Int, productTuple: (Int, Int), count: Int, limit: Int, totalStringLength: Int) : (Int,Int) = {
    if (count < limit && targetDigit <= 10000000) {
      val sequence = makeSequence(count)
      productTuple match {
        case (product, nextDigit) =>
          val prodTup = calcProductNew(nextDigit, sequence, totalStringLength + sequence.length, product, count, limit)

          return outerLoopImpl(targetDigit,
            prodTup, // product argument
            count + 40,
            limit,
            totalStringLength + sequence.length)
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
    val product = P040_ChampernownesConstant.champernownesConstant

    println("P040: Product d1 x d10 x ... x d1000000 = " + product)
    assertEquals(210, product)
  }
}

