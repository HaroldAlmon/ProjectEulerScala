package com.translationdata.p050

/** Strategy: Brute Force */

import org.junit.Test
import org.junit.Assert._

object P052_PermutedMultiples {
  def getNumber:Int = {
    def match2xThru6x(candidate: Int): Boolean = {

      for( multiplier <- 2 to 6 ) {
        val product = (multiplier * candidate ).toString
        val productChars = product.toCharArray.sorted
        val candidateChars = candidate.toString.toCharArray.sorted

        def isLengthIncorrect: Boolean = product.length != candidate.toString.length
        def isProductAMultiple: Boolean = (productChars sameElements candidateChars) == false

        if ( isLengthIncorrect )
          return false

        if ( isProductAMultiple )
          return false
      }

      true
    }

    val result = for ( candidate <- 1 to 1000000 / 6 if match2xThru6x(candidate) )
       return candidate

    return 0
  }
}

class P052_PermutedMultiples {
  @Test def PermutedMultiples {
    val result = P052_PermutedMultiples.getNumber
    for ( multiplier <- 1 to 6 )
      printf("%dx = %d\n", multiplier, multiplier * result)
    assertEquals( 142857, result )
    printf( "\n P052: %d\n", result )
  }
}
