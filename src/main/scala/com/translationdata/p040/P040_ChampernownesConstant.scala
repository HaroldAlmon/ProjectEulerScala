package com.translationdata.p040
package com.translationdata.prototypes
import scala.annotation.tailrec

import org.junit.Assert._
import org.junit.Test

object P040_ChampernownesConstant {
  val UPPER_LIMIT = 1000000
  val SEQUENCE_SIZE = 50

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
      {case (_, target) => target} ) > UPPER_LIMIT)
      return productTuple

    val sequence = makeSequence(sequencePosition)
    productTuple match {
      case (product, nextDigit) =>
        val returnProductTuple = calcProduct(nextDigit, sequence, totalStringLength + sequence.length, product)

        searchSequenceImpl(returnProductTuple,
          sequencePosition + SEQUENCE_SIZE,
          totalStringLength + sequence.length)
    }
  }

  private def makeSequence(startNum:Int):String = {
    val sequence = makeSequenceImpl("")(startNum)(startNum + SEQUENCE_SIZE)
    sequence
  }

  @tailrec private def makeSequenceImpl(sequence:String)
                                       (position:Int)
                                       (seqLimit: Int): String = {
    if ( position >= seqLimit )
      return sequence
    val sequenceStateToken = sequence + position.toString
    val positionStateToken = position + 1
    makeSequenceImpl(sequenceStateToken)(positionStateToken)(seqLimit)
  }

  private def isDigitInSequence( function: => Boolean )  = {
    function
  }

  private def calcProduct( targetDigitPos: Int,
                           sequence: String,
                           totalSeqLength: Int,
                           product: Int) = {
    if (isDigitInSequence(targetDigitPos <= totalSeqLength && targetDigitPos > (totalSeqLength - sequence.length))) {
      val offset = totalSeqLength - targetDigitPos
      val digit = sequence charAt ( sequence.length - offset - 1 )

      // The tuple that contains the product and the target digit acts as a state token
      // to track the machine state without modifying any variables...
      (product * ( digit.toInt - 48 ), targetDigitPos * 10)
    } else
      (product, targetDigitPos)
  }
}


class P040_ChampernownesConstant {
  @Test def champernownesConstant() = {
    val product = P040_ChampernownesConstant.champernownesConstant

    checkResult {
      println("P040: Product d1 x d10 x ... x d1000000 = " + product)
      assertEquals(210, product)
    }
  }

  def checkResult(function: => Unit) {
    function
  }
}

