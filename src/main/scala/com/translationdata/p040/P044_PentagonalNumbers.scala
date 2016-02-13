package com.translationdata.p040

import org.junit.Test
import org.junit.Assert._

/** Strategy: Brute Force, Hash Set Lookup */
object P044_PentagonalNumbers {
  val pentagonalUpperLimit = 3000

  def main(args: Array[String]) = findNumber()

  private def findNumber() = {
    val Pn  = (n: Int) => n * (3 * n - 1) / 2
    val pentagonalNumbers = ( 1 to pentagonalUpperLimit ) map Pn
    val pentagonalSet = pentagonalNumbers.toSet

    def findPair:Option[(Int, Int, Int, Int, Int)] = {
      (0 to pentagonalUpperLimit - 2).
        foreach { leftIndex => for (rightIndex <- leftIndex + 1 to pentagonalUpperLimit - 1
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
    printf("|Pk - Pj| = %d, j = %d, k = %d, Pj = %d, Pk = %d%n%n",
      result._1,
      result._2,
      result._3,
      result._4,
      result._5)
    result._1
  }
}

class P044_PentagonalNumbers {
  @Test def PentagonalNumbers() = {
    val difference = P044_PentagonalNumbers.findNumber()

    println( "P044: Difference is " + difference )
    assertEquals(5482660, difference)
  }
}