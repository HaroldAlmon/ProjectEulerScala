package com.translationdata.p050

import org.junit.Test
import org.junit.Assert._
import Math.pow
import Math.sqrt

import misc.SieveOfEratosthenes;

/** Strategy: Brute Force, Prime Sieve */
object P050_ConsecutivePrimeSum {
	val upperLimit = pow( 10, 6 ).toInt
	val sieve:SieveOfEratosthenes = new SieveOfEratosthenes( upperLimit )

  def mapTermCount( primeTuple: ( Int, Int ) ) =
    primeTuple._1

  def mapPrimeNumberSum( firstPrime:Int ) =
    primeSum( firstPrime )

  def getMaxSum:Int = {
    val primeList = extractPrimes( ( 2 to 7 ) )
    val primeNumberSums = primeList.toArray.map { mapPrimeNumberSum }


    for ( primePos <- 0 to primeNumberSums.size - 1) {
      val primeTuple = primeNumberSums( primePos )
      printf ( "Starting Prime = %d, Sum = %d, number of terms = %d\n", primeList(primePos), primeTuple._2, primeTuple._1 )
    }

    val termCount = primeNumberSums.map( mapTermCount )
    val maxCount = termCount.max
    val maxPos = termCount.indexWhere( _ == maxCount)
    val maxSum = primeNumberSums( maxPos )._2
    maxSum
  }
	
	def primeSum( firstPrime:Int ) = {
    val maxSum = 0 
    val maxPrimeSum = 0
    val primeCount = 0
    val maxPrimeCount = 0
    primeSumTailRecursion( firstPrime, maxSum, maxPrimeSum, primeCount, maxPrimeCount )
  }
  
  def primeSumTailRecursion( primeCandidate:Int, currentPrimeSum:Int, maxPrimeSum:Int, primeCount:Int, maxPrimeCount:Int ): ( Int,Int ) = {
	  val primeCandidateSum = primeCandidate + currentPrimeSum
	  
    if ( primeCandidateSum >= upperLimit )
    	return ( maxPrimeCount, maxPrimeSum )
      
    if ( sieve.isPrime(primeCandidate) == false )
      primeSumTailRecursion( primeCandidate + 1, currentPrimeSum, maxPrimeSum, primeCount, maxPrimeCount )
    else {
      if( sieve.isPrime( primeCandidateSum ) ) {
        primeSumTailRecursion( primeCandidate + 1, primeCandidateSum, primeCandidateSum, primeCount + 1, primeCount + 1 )
      }
      else
        primeSumTailRecursion( primeCandidate + 1, primeCandidateSum, maxPrimeSum, primeCount + 1, maxPrimeCount )
    }
  }
  
  def extractPrimes(candidates:Range.Inclusive) = {
    for ( num <- candidates if sieve.isPrime(num) )
        yield num
  }
}

class P050_ConsecutivePrimeSum_Junit {
  @Test def ConsecutivePrimeSum {
    val maxPrimeSum = P050_ConsecutivePrimeSum.getMaxSum
    println( "P050: Maximum prime is " + maxPrimeSum )
    assertEquals( 997651, maxPrimeSum )
  }
}