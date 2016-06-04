package com.translationdata.P010

import org.junit.Assert._
import org.junit.Test

class P010_SummationOfPrimes {
  @Test(timeout = 10000)
  def TwoMillionPrimes(): Unit = {
    val upperLimit = 2000000
    val primeSum = P010_SummationOfPrimes.primesSum(upperLimit)
    printf("P010: Result(%d) = %d, %n", upperLimit, primeSum)
    assertEquals( "Incorrect sum", 142913828922L, primeSum )
  }
}

object P010_SummationOfPrimes {
  /** Strategy: Sieve of SieveOfEratosthenes. */
  import misc.SieveOfEratosthenes

  def primesSum(upperLimit:Int) = {
    val primeSieve = new SieveOfEratosthenes( upperLimit )

    val primeSum = (2L to upperLimit)
      .filter( candidate => primeSieve isPrime (candidate toInt) )
      .sum
    primeSum
  }
}
