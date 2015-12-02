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
  
// Probably not tail recursive...
  def getSeqSumHelper( primeCandidate:Int, totalSum:Int, maxPrimeSum:Int ): Int = {
	  val sum = primeCandidate + totalSum
	  
    if ( sum >= upperLimit )
      return maxPrimeSum
      
    if ( sieve.isPrime(primeCandidate) == false )
      // keep going to find the next prime number
      getSeqSumHelper( primeCandidate + 1, totalSum, maxPrimeSum )
    else {
      
      // Add the next prime and if the sum is prime keep going...
      if( sieve.isPrime( sum ) ) {
        getSeqSumHelper( primeCandidate + 1, sum, sum )
      }
      // Sum is not prime so do not add to max and keep going...  
      else
        //totalSum
        getSeqSumHelper( primeCandidate + 1, sum, maxPrimeSum )
    }
  }

// Prototype function  to understand tuples...
def getSeqSumHelper2( primeCandidate:Int, totalSum:Int, maxPrimeSum:Int ): Int = {
	  val sum = primeCandidate + totalSum
	  
    if ( sum >= upperLimit )
      return maxPrimeSum
      
    val (p1, p2) = (1,1)
      
    val (p3, p4) = if ( sieve.isPrime(primeCandidate) == false )
      ( totalSum, maxPrimeSum )
	  1
  }


  def getSeqSumHelper3( primeCandidate:Int, maxSum:Int, maxPrimeSum:Int ): Int = {
	  val primeCandidateSum = primeCandidate + maxSum
	  
    if ( primeCandidateSum >= upperLimit )
      return maxPrimeSum
      
    val (parm1, parm2) = if ( sieve.isPrime(primeCandidate) == false )
      // keep going to find the next prime number
      //getSeqSumHelper( primeCandidate + 1, totalSum, maxPrimeSum )
      ( maxSum, maxPrimeSum )
      
    else {
      
      // Add the next prime and if the sum is prime keep going...
      if( sieve.isPrime( primeCandidateSum ) ) {
        //getSeqSumHelper( primeCandidate + 1, sum, sum )
        (primeCandidateSum, primeCandidateSum )
      }
      // Sum is not prime so do not add to max and keep going...  
      else
        //getSeqSumHelper( primeCandidate + 1, sum, maxPrimeSum )
        ( primeCandidateSum, maxPrimeSum )
    }
	  getSeqSumHelper( primeCandidate + 1, parm1, parm2 )
  }
  
  def getSeqSum(firstPrime:Int) = {
    getSeqSumHelper3(firstPrime, 0, 0)
  }
}

class P050_ConsecutivePrimeSum_Junit {
  @Test def ConsecutivePrimeSum {
    val maxPrimeSum = P050_ConsecutivePrimeSum.getNumber
    val testSum = P050_ConsecutivePrimeSum.getSeqSum(2)
    println("testSum = " + testSum)
    println( "Maximum prime is " + maxPrimeSum )
    //assertEquals( 997651, maxPrimeSum )
  }
}