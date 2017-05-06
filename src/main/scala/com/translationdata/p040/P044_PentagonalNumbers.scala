package com.translationdata.p040

import org.junit.Test
import org.junit.Assert._

/** Strategy: Brute Force, Hash Set Lookup */
object P044_PentagonalNumbers {
  val PENTAGONAL_UPPER_LIMIT = 3000

  def main(args: Array[String]) = findNumber()

  def findNumber() = {
    val Pn  = (n: Int) => n * (3 * n - 1) / 2
    val pentagonalNumbers = ( 1 to PENTAGONAL_UPPER_LIMIT ) map Pn
    val pentagonalSet = pentagonalNumbers.toSet

    def findPair:Option[(Int, Int, Int, Int, Int)] = {
      (0 to PENTAGONAL_UPPER_LIMIT - 2).
        foreach { leftIndex => for (rightIndex <- leftIndex + 1 to PENTAGONAL_UPPER_LIMIT - 1
          if isPentagonal(pentagonalNumbers(leftIndex), pentagonalNumbers(rightIndex)))
            return Some(
              ( pentagonalNumbers( rightIndex ) - pentagonalNumbers( leftIndex ),
                leftIndex,
                rightIndex,
                pentagonalNumbers( leftIndex ),
                pentagonalNumbers( rightIndex )))
        }
      None
    }

    def isPentagonal( Pj: Int, Pk: Int ) =
      if ((pentagonalSet contains (Pj + Pk)) && (pentagonalSet contains (Pk - Pj)) )
        true
      else
        false

    val result = findPair.get
    result match {
      case (diff, j, k, pAtJ, pAtK) =>
        printf("|Pk - Pj| = %d, j = %d, k = %d, Pj = %d, Pk = %d%n%n",
          diff,
          j,
          k,
          pAtJ,
          pAtK)
        diff
    }
  }
}