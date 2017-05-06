package com.translationdata.P010

import org.hamcrest.CoreMatchers
import org.junit.Assert._
import org.junit.Test

object P010_SummationOfPrimes {
  /** Strategy: Sieve of SieveOfEratosthenes. */
  import misc.SieveOfEratosthenes

  def main(args: Array[String]){
     println( primesSum(2000000) )
  }
  def primesSum(upperLimit:Int) = {
    val primeSieve = new SieveOfEratosthenes( upperLimit )

    val primeSum = (2L to upperLimit)
      .filter( candidate => primeSieve isPrime (candidate toInt) )
      .sum
    primeSum
  }
}
