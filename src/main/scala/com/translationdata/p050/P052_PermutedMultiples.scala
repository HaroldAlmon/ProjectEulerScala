package com.translationdata.p050

/** Strategy: Brute Force */

import org.junit.Test
import org.junit.Assert._

object P052_PermutedMultiples {
  def getNumber:Int = {
    def match2xThru6x(candidate: Int): Boolean = {
      for( multiplier <- 2 to 6 ) {
        val product = (multiplier * candidate ) toString
        val productChars = product.toCharArray
          .sorted
        val candidateChars = candidate.toString
          .toCharArray
          .sorted

        def isLengthIncorrect: Boolean = product.length != candidate.toString.length
        def isProductAMultiple: Boolean = !(productChars sameElements candidateChars)

        if ( isLengthIncorrect )
          return false

        if ( isProductAMultiple )
          return false
      }
      true
    }

    for ( candidate <- 1 to 1000000 / 6 if match2xThru6x(candidate) )
       return candidate

    0
  }
}
