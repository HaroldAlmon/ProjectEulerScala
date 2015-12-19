package com.translationdata.p050

import org.junit.Test
import org.junit.Assert._

import scala.annotation.tailrec

/** Strategy:Brute Force */
object P055 {
  //def main(args: Array[String]) { printf("count = %d\n", P055_LychrelNumbers.reverse(47)) }

  def isLychrel(n:Int): Boolean = {
    if ( isPalindrome( n + reverse(n) ) )
      true
    else
      false
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

  def isPalindrome(n:Int) = {
    true
  }
}

class P055 {
  @Test  def lychrelNumbers {
    printf("count = %d\n", P055.reverse(47))
  }
}

