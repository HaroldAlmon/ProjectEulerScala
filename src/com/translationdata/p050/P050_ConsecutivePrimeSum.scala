package com.translationdata.p050

import org.junit.Test
import org.junit.Assert._
import Math.pow
import Math.sqrt

import misc.SieveOfEratosthenes;

object P050_ConsecutivePrimeSum {
	//val upperLimit = pow(10, 6).toInt
		val upperLimit = 100
	val sieve:SieveOfEratosthenes = new SieveOfEratosthenes( upperLimit )
  def getNumber:Int = { 

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

        for ( prime <- ( firstPrime to upperLimit / 100) ) {
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
  
def getSeqSumHelper( primeCandidate:Int, maxSum:Int, maxPrimeSum:Int ): Int = {
	  val primeCandidateSum = primeCandidate + maxSum
	  
    if ( primeCandidateSum >= upperLimit )
      return maxPrimeSum
      
    val (parm1, parm2) = if ( sieve.isPrime(primeCandidate) == false )
      ( maxSum, maxPrimeSum )
      
    else {
      
      if( sieve.isPrime( primeCandidateSum ) ) {
        ( primeCandidateSum, primeCandidateSum )
      }
      else
        ( primeCandidateSum, maxPrimeSum )
    }
	  getSeqSumHelper( primeCandidate + 1, parm1, parm2 )
  }
  
  def primeSum(firstPrime:Int) = {
    val maxSum = 0 
    val maxPrimeSum = 0
    getSeqSumHelper(firstPrime, maxSum, maxPrimeSum)
  }
}

class P050_ConsecutivePrimeSum_Junit {
  @Test def ConsecutivePrimeSum {
    val maxPrimeSum = P050_ConsecutivePrimeSum.getNumber
    val testSum = P050_ConsecutivePrimeSum.primeSum(2)
    println("testSum = " + testSum)
    println( "Maximum prime is " + maxPrimeSum )
    //assertEquals( 997651, maxPrimeSum )
  }
}