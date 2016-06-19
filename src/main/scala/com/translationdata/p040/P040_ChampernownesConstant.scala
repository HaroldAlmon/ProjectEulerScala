package com.translationdata.p040
package com.translationdata.prototypes
import scala.annotation.tailrec

import org.junit.Assert._
import org.junit.Test

object P040_ChampernownesConstant {
  def main(args: Array[String]) = champernownesConstant

  private def champernownesConstant = {
    searchSequence(100) match {
      case(product, nthDigit) => product
    }
  }



  def searchSequence(targetDigit: Int) : (Int, Int) = {
    searchSequenceImpl(targetDigit, (1, targetDigit), 1, 100000, 0)
  }

  @tailrec def searchSequenceImpl(targetDigit: Int,
                                  productTuple: (Int, Int),
                                  count: Int,
                                  limit: Int,
                                  totalStringLength: Int) : (Int,Int) = {
    if (count >= limit || targetDigit > 10000000)
      return productTuple

    val sequence = makeSequence(count)
    productTuple match {
      case (product, nextDigit) =>
        val prodTup = calcProduct(nextDigit, sequence, totalStringLength + sequence.length, product, count, limit)

        return searchSequenceImpl(targetDigit,
          prodTup, // product argument
          count + 40,
          limit,
          totalStringLength + sequence.length)
    }
  }

  def makeSequence(startNum:Int):String = {
    val sequence = makeSequenceImpl("", startNum, startNum + 40)
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

  private def calcProduct( nthDigit: Int,
                           sequence: String,
                           totalSeqLength: Int,
                           product: Int,
                           count: Int,
                           limit: Int ) = {
    if ( isDigitInSequence( nthDigit, sequence, totalSeqLength ) ) {
      val offset = totalSeqLength - nthDigit
      val digit = sequence charAt ( sequence.length - offset - 1 )
      (product * ( digit.toInt - 48 ), nthDigit * 10)
    } else
      (product, nthDigit)
  }
}


class P040_ChampernownesConstant {
  @Test def champernownesConstant() = {
    val product = P040_ChampernownesConstant.champernownesConstant

    println("P040: Product d1 x d10 x ... x d1000000 = " + product)
    assertEquals(210, product)
  }
}

