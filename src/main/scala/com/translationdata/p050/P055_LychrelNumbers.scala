package com.translationdata.p050

import org.junit.Test
import org.junit.Assert._

import scala.annotation.tailrec

/** Strategy: Brute Force */
object P055_LychrelNumbers {
  //def main(args: Array[String]) { printf("count = %d\n", P055_LychrelNumbers.reverse(47)) }

  def isLychrel(n:Int): Boolean = {

    def isLychrelImpl(n:Int, iteration:Int):Boolean = {
      val candidate = n + reverse(n)
      //printf("n=%d, iteration=%d\n",candidate, iteration)
      if (isPalindrome(candidate)) {
        printf("candidate = %d, iteration = %d\n", candidate, iteration)
        true
      }
      else
        if (iteration >= 50)
          return false
        else
          return isLychrelImpl(candidate, iteration + 1)
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
      if ( number(leftPos) != number(rightPos) ) {
        //printf("Chars differ at (%d, %d)\n", leftPos, rightPos)
        return false
      }
    }
    true
  }
}

class P055_LychrelNumbers {
  @Test def lychrelNumbers() {
    printf("%d = %b\n", 47, P055_LychrelNumbers.isLychrel(47) )
    printf("%d = %b\n", 48, P055_LychrelNumbers.isLychrel(48) )
    printf("%d = %b\n", 349, P055_LychrelNumbers.isLychrel(349) )
  }
}

