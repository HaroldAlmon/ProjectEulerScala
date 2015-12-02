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
  
def primeSumHelper( primeCandidate:Int, maxSum:Int, maxPrimeSum:Int, primeCount:Int ):(Int,Int) = {
	  val primeCandidateSum = primeCandidate + maxSum
	  
    if ( primeCandidateSum >= upperLimit ) {
      printf("sum = %d, count =%d\n", maxPrimeSum, primeCount)
    	//return maxPrimeSum
    	return (primeCount, maxPrimeSum)
    }
      
    val (parm1, parm2, parm3) = if ( sieve.isPrime(primeCandidate) == false )
      ( maxSum, maxPrimeSum, primeCount )
      
    else {
      
      if( sieve.isPrime( primeCandidateSum ) ) {
        //println("Adding prime " + primeCandidate) 
        ( primeCandidateSum, primeCandidateSum, primeCount + 1 )
      }
      else
        ( primeCandidateSum, maxPrimeSum, primeCount )
    }
	  primeSumHelper( primeCandidate + 1, parm1, parm2, parm3 )
  }
  
  def primeSum(firstPrime:Int) = {
    val maxSum = 0 
    val maxPrimeSum = 0
    primeSumHelper(firstPrime, maxSum, maxPrimeSum, 0)
  }

  def getMaxSum:Int = {
    val primeList = extractPrimes( (2 to 10) )
    val primeNumberSums = primeList.toArray.map { firstPrime => primeSum (firstPrime) }
    for (tup <- primeNumberSums) { 
      println (tup + ", " + tup._1.toString() + ", " + tup._2.toString())
    }
    val counts = primeNumberSums.map( tup => tup._1)
    val maxCount = counts.max
    
        val primeList2 = extractPrimes( (2 to 10) )
    //val primeNumberSums3 = extractPrimes( (2 to 10) )
    //val primeNumberSums2 = primeList.toArray.map { firstPrime => primeSum (firstPrime) }
    //val pos = primeNumberSums2.indexWhere(_ == primeNumberSums2.max)
    //val maxSeq = primeNumberSums2.max
    //primeSum ( primeList(pos) )
    1
  }
  
  def extractPrimes(candiates:Range.Inclusive) = {
    for ( num <- candiates if sieve.isPrime(num) )
        yield num
  }
}

class P050_ConsecutivePrimeSum_Junit {
  @Test def ConsecutivePrimeSum {
    val maxPrimeSum = P050_ConsecutivePrimeSum.getNumber
    val testSum = P050_ConsecutivePrimeSum.primeSum(2)
    println("testSum = " + testSum)
    println( "Maximum prime is " + maxPrimeSum )
    
    println("getMaxSum = " + P050_ConsecutivePrimeSum.getMaxSum )
    //assertEquals( 997651, maxPrimeSum )
  }
}