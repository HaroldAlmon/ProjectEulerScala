package com.translationdata.p050

/** Strategy: Brute Force */

import org.junit.Test
import org.junit.Assert._

object P052_PermutedMultiples {
  def getNumber:Int = {
    def match2xThru6x(candidate: Int): Boolean = {

      for(multiplier <- 2 to 6) {
        val product = (multiplier * candidate ).toString
        if ( product.length != candidate.toString.length )
          return false

        val productCounts = product.toCharArray.sorted
        val candidateCounts = candidate.toString.toCharArray.sorted
        if ( (productCounts sameElements candidateCounts) == false )
          return false
      }

      true
    }

    val result = for (i <- 1 to 1000000/6 if match2xThru6x(i) )
       return i

    return 0
  }
}

class P052_PermutedMultiples {
  @Test def PermutedMultiples {
    val result = P052_PermutedMultiples.getNumber
    for (multiplier <- 1 to 6)
      printf("%dx = %d\n", multiplier, multiplier * result)
    assertEquals(142857, result)
  }
}
