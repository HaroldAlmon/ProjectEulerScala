package com.translationdata.p050

import org.junit.Test
import org.junit.Assert._
import Math.pow

import misc.SieveOfEratosthenes

import scala.annotation.tailrec

/** Strategy: Brute Force, Prime Sieve */
object P050_ConsecutivePrimeSum {
	val upperLimit = pow( 10, 6 ).toInt
	val sieve:SieveOfEratosthenes = new SieveOfEratosthenes( upperLimit )

  def getMaxSum = {
    val primeList = extractPrimes( 2 to 7 )
    val primeNumberSums =
      primeList.toArray
               .map(primeSum)

    for (primePos <- primeNumberSums.indices) {
      val primeTuple = primeNumberSums(primePos)
      primeTuple match {
        case (termCount, primeSum) =>
          printf("Starting Prime = %d, Sum = %d, number of terms = %d%n",
            primeList(primePos),
            primeSum,
            termCount)
      }
    }

    val termCount = primeNumberSums map {
        case (termCount, primeSum) => termCount
    }
    val maxCount = termCount.max
    val maxPos = termCount indexWhere (_ == maxCount)
    val maxSum = primeNumberSums( maxPos ) match {
      case (termCount, primeSum) => primeSum
    }
    maxSum
  }

  def primeSum( firstPrime:Int ) = {
    @tailrec
    def primeSumImpl(primeCandidate:Int,
                     currentPrimeSum:Int,
                     maxPrimeSum:Int,
                     primeCount:Int,
                     maxPrimeCount:Int ): ( Int,Int ) = {
      val primeCandidateSum = primeCandidate + currentPrimeSum

      if ( primeCandidateSum >= upperLimit )
        return ( maxPrimeCount, maxPrimeSum )

      if ( !sieve.isPrime(primeCandidate) )
        primeSumImpl( primeCandidate + 1,
                      currentPrimeSum,
                      maxPrimeSum,
                      primeCount,
                      maxPrimeCount )
      else {
        if (sieve.isPrime( primeCandidateSum ) ) {
          primeSumImpl (primeCandidate + 1,
                        primeCandidateSum,
                        primeCandidateSum,
                        primeCount + 1,
                        primeCount + 1 )
        }
        else
          primeSumImpl( primeCandidate + 1,
                        primeCandidateSum,
                        maxPrimeSum,
                        primeCount + 1,
                        maxPrimeCount )
      }
    }

    primeSumImpl( firstPrime,
                  currentPrimeSum=0,
                  maxPrimeSum=0,
                  primeCount=0,
                  maxPrimeCount=0 )
  }

  def extractPrimes(candidates: Range.Inclusive) = {
    for (num <- candidates if sieve isPrime num)
      yield num
  }
}

class P050_ConsecutivePrimeSum {
  @Test def ConsecutivePrimeSum() = {
    val maxPrimeSum = P050_ConsecutivePrimeSum.getMaxSum
    println( "P050: Maximum prime is " + maxPrimeSum )
    assertEquals( 997651, maxPrimeSum )
  }
}