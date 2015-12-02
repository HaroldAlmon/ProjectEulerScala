package com.translationdata.p050

import org.junit.Test
import org.junit.Assert._
import Math.pow
import Math.sqrt

import misc.SieveOfEratosthenes;

object P050_ConsecutivePrimeSum {
  def getNumber:Int = { 
		val upperLimit = pow(10, 6).toInt
		val sieve:SieveOfEratosthenes = new SieveOfEratosthenes( upperLimit )

    var maxPrimeSum = 0L
    var maxPrime = 0
    var maxPrimeCount = 0

    var primeSum = 0L
    val primeNumberSums = ( 2 to 10 ).toArray.map { firstPrime =>
      if (sieve.isPrime(firstPrime)) {
        var primeCount = 0
        primeSum = 0;
        primeCount = 0;
        primeCount = 0;

        for ( prime <- ( firstPrime to upperLimit / 100000) ) {
          if (sieve.isPrime(prime)) {
            primeSum += prime
            primeCount += 1

            if (primeSum <= upperLimit && sieve.isPrime( primeSum.toInt ) && primeCount > maxPrimeCount ) {
              maxPrime = prime
              maxPrimeSum = primeSum
              maxPrimeCount = primeCount
            }
          }
        }
      }
      maxPrimeSum
    }
		//println("firstPrimeNumbers MAX = " + firstPrimeNumbers.max)
    //println("maxPrimeCount = " + maxPrimeCount)
    //println("maxPrime = " + maxPrime)
    //println("x = " + firstPrimeNumbers.mkString(" "))
    primeNumberSums.max.toInt
  }
}

class P050_ConsecutivePrimeSum_Junit {
  @Test def ConsecutivePrimeSum {
    val maxPrimeSum = P050_ConsecutivePrimeSum.getNumber
    println( "Maximum prime is " + maxPrimeSum )
    assertEquals( 997651, maxPrimeSum )
  }
}