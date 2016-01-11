package com.translationdata.p040

/** Strategy: Brute Force, Hash Set Lookup */
object P044_PentagonalNumbers {
  val pentagonalUpperLimit = 3000

  def main(args: Array[String]) { findNumber() }

  private def findNumber() {
    val Pn  = (n: Int) => { n * (3 * n - 1) / 2 }
    val pentagonalNumbers = ( 1 to pentagonalUpperLimit ).toArray.map { Pn }
    val pentagonalSet = pentagonalNumbers.toSet

    def findPair:(Long, Int, Int, Int, Int) = {
      (0 to pentagonalUpperLimit - 2).
        foreach { leftIndex => for (rightIndex <- leftIndex + 1 to pentagonalUpperLimit - 1
          if isPentagonal(pentagonalNumbers(leftIndex), pentagonalNumbers(rightIndex)))
            return ( pentagonalNumbers( rightIndex ) - pentagonalNumbers( leftIndex ), leftIndex, rightIndex, pentagonalNumbers( leftIndex ), pentagonalNumbers( rightIndex ))
        }
      (0L, 0, 0, 0, 0)
    }

    def isPentagonal( Pj: Int, Pk: Int ) =
      if (pentagonalSet.contains(Pj + Pk) && pentagonalSet.contains(Pk - Pj))
        true
      else
        false

    val result = findPair
    printf("P044:\n")
    printf("|Pk - Pj| = %d, j = %d, k = %d, Pj = %d, Pk = %d\n", result._1, result._2, result._3, result._4, result._5)
  }
}