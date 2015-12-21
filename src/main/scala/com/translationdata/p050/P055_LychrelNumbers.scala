package com.translationdata.p050

import org.junit.Test
import org.junit.Assert._

import scala.annotation.tailrec

/** Strategy: Brute Force */
object P055_LychrelNumbers {
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

  def reverse(n:Int) = {
    @tailrec def reverseImpl(n:Int, sum:Int): Int = {
      n match {
        case 0 => sum
        case _ => reverseImpl(n / 10, sum * 10 + n % 10)
      }
    }
    reverseImpl(n, 0)
  }

  def isPalindrome(n:Int):Boolean = {
    val number = n.toString
    for ( leftPos <- 0 to number.length / 2 ) {
      val rightPos = number.length - leftPos - 1
      if ( number(leftPos) != number(rightPos) )
        return false
    }
    true
  }
}

class P055_LychrelNumbers {
  @Test def lychrelNumbers() {
    printf("P055: Lynchrel count = %d\n", P055_LychrelNumbers.lychrelCount )
  }
}

