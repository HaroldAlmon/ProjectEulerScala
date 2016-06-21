package com.translationdata.p040
package com.translationdata.prototypes
import scala.annotation.tailrec

import org.junit.Assert._
import org.junit.Test

object P040_ChampernownesConstant {
  def main(args: Array[String]) = champernownesConstant
  val UPPERLIMIT = 1000000
  val SEQUENCESIZE = 50

  private def champernownesConstant = {
    searchSequence(100) match {
      case(product, nthDigit) => product
    }
  }

  def searchSequence(targetDigitPos: Int) : (Int, Int) = {
    searchSequenceImpl((1, targetDigitPos), 1, 0)
  }

  @tailrec def searchSequenceImpl(productTuple: (Int, Int),
                                  sequencePosition: Int,
                                  totalStringLength: Int) : (Int,Int) = {
    if ( (productTuple match
      {case (_, target) => target} ) > UPPERLIMIT)
      return productTuple

    val sequence = makeSequence(sequencePosition)
    productTuple match {
      case (product, nextDigit) =>
        val returnProductTuple = calcProduct(nextDigit, sequence, totalStringLength + sequence.length, product)

        return searchSequenceImpl(returnProductTuple,
          sequencePosition + SEQUENCESIZE,
          totalStringLength + sequence.length)
    }
  }

  def makeSequence(startNum:Int):String = {
    val sequence = makeSequenceImpl("", startNum, startNum + SEQUENCESIZE)
    sequence
  }

  @tailrec def makeSequenceImpl(sequence:String,
                                position:Int,
                                seqLimit: Int): String = {
    if ( position >= seqLimit )
      return sequence
    makeSequenceImpl(sequence + position.toString, position + 1, seqLimit)
  }

  private def isDigitInSequence( nthDigit: Int,
                                 sequence: String,
                                 totalSeqLength: Int) = {
    nthDigit <= totalSeqLength && nthDigit > ( totalSeqLength - sequence.length )
  }

  private def calcProduct( targetDigitPos: Int,
                           sequence: String,
                           totalSeqLength: Int,
                           product: Int) = {
    if ( isDigitInSequence( targetDigitPos, sequence, totalSeqLength ) ) {
      val offset = totalSeqLength - targetDigitPos
      val digit = sequence charAt ( sequence.length - offset - 1 )
      (product * ( digit.toInt - 48 ), targetDigitPos * 10)
    } else
      (product, targetDigitPos)
  }
}

class P040_ChampernownesConstant {
  @Test def champernownesConstant() = {
    val product = P040_ChampernownesConstant.champernownesConstant

    println("P040: Product d1 x d10 x ... x d1000000 = " + product)
    assertEquals(210, product)
  }
}

