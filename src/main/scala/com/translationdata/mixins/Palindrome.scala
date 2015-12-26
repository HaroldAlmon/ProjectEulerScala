package com.translationdata.mixins
trait Palindrome {
  def isPalindrome(n:BigInt):Boolean = {
    val number = n.toString
    for ( leftPos <- 0 to number.length / 2 ) {
      val rightPos = number.length - leftPos - 1
      if ( number(leftPos) != number(rightPos) )
        return false
    }
    true
  }
}
