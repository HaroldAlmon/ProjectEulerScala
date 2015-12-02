package com.translationdata.p050

import org.junit.Test
import org.junit.Assert._
import Math.pow
import Math.sqrt

import misc.SieveOfEratosthenes;

object P050_ConsecutivePrimeSum {
	val upperLimit = pow(10, 6).toInt
	val sieve:SieveOfEratosthenes = new SieveOfEratosthenes( upperLimit )
  
def primeSumHelper( primeCandidate:Int, currentPrimeSum:Int, maxPrimeSum:Int, primeCount:Int, maxPrimeCount:Int ):(Int,Int) = {
	  val primeCandidateSum = primeCandidate + currentPrimeSum
	  
    if ( primeCandidateSum >= upperLimit ) {
    	return (maxPrimeCount, maxPrimeSum)
    }
      
    val (parm1, parm2, parm3, parm4) = if ( sieve.isPrime(primeCandidate) == false )
      ( currentPrimeSum, maxPrimeSum, primeCount, maxPrimeCount )
    else {
      if( sieve.isPrime( primeCandidateSum ) ) {
        ( primeCandidateSum, primeCandidateSum, primeCount + 1, primeCount + 1)
      }
      else
        ( primeCandidateSum, maxPrimeSum, primeCount + 1, maxPrimeCount)
    }
	  primeSumHelper( primeCandidate + 1, parm1, parm2, parm3, parm4 )
  }
  
  def primeSum(firstPrime:Int) = {
    val maxSum = 0 
    val maxPrimeSum = 0
    primeSumHelper(firstPrime, maxSum, maxPrimeSum, 0, 0 )
  }

  def getMaxSum:Int = {
    val primeList = extractPrimes( (2 to 10) )
    val primeNumberSums = primeList.toArray.map { firstPrime => primeSum (firstPrime) }
    
    for (primePos <- 0 to primeNumberSums.size - 1) {
      val tup = primeNumberSums(primePos)
      printf ("Starting Prime = %d, Sum = %d, number of terms = %d\n", primeList(primePos), tup._2, tup._1 )
    }
    val counts = primeNumberSums.map( tup => tup._1)
    val maxCount = counts.max
    val maxPos = counts.indexWhere(_ == maxCount)
    
    val maxSum = primeNumberSums(maxPos)._2
    
    maxSum
  }
  
  def extractPrimes(candiates:Range.Inclusive) = {
    for ( num <- candiates if sieve.isPrime(num) )
        yield num
  }
}

class P050_ConsecutivePrimeSum_Junit {
  @Test def ConsecutivePrimeSum {
    val maxPrimeSum = P050_ConsecutivePrimeSum.getMaxSum
    println( "Maximum prime is " + maxPrimeSum )
    assertEquals( 997651, maxPrimeSum )
  }
}