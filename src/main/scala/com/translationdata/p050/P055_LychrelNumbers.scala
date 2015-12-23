package com.translationdata.p050

import com.translationdata.mixins.{Reverse, Palindrome}
import org.junit.Test
import org.junit.Assert._

import scala.annotation.tailrec

/** Strategy: Brute Force */
object P055_LychrelNumbers extends Palindrome with Reverse {
  def lychrelCount = (for(candidate <- 1 to 9999 if isLychrel(candidate)) yield 1).size

  def isLychrel(n:Int): Boolean = {

    @tailrec def isLychrelImpl(n:Int, iteration:Int):Boolean = {
      val candidate = n + reverse(n)
      if (isPalindrome(candidate)) {
        true
      }
      else
        if (iteration >= 50)
          false
        else
          isLychrelImpl(candidate, iteration + 1)
    }

    isLychrelImpl(n, 1)
  }
}

class P055_LychrelNumbers {
  @Test def lychrelNumbers() {
    printf("P055: Lynchrel count = %d\n", P055_LychrelNumbers.lychrelCount )
  }
}

