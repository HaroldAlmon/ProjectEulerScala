package com.translationdata.p050

import Math.pow

import misc.SieveOfEratosthenes

import scala.annotation.tailrec

// The class is here so I can run this with JUnit. JUnit also requires the main() function...
class P050_ConsecutivePrimeSum {
}

/** Strategy: Brute Force, Prime Sieve */
object P050_ConsecutivePrimeSum {
	val upperLimit = pow( 10, 6 ).toInt
	val sieve:SieveOfEratosthenes = new SieveOfEratosthenes( upperLimit )

  def main(arg:Array[String]): Unit = {
    println( getMaxSum )
  }

  def getMaxSum = {
    val listOfStartingPrimeNumbers = extractStartingPrimeNumbers( 2 to 23 )
    
    val primeNumberSums = listOfStartingPrimeNumbers.toArray.map(primeSum)

    // The code below is passed as a lambda expression for execution by findPrimeSum...
    printAllTermCountsAndSums {
      for (primePos <- primeNumberSums.indices) {
        val primeTuple = primeNumberSums(primePos)
        primeTuple match {
          case (termCount, primeSum) =>
            printf("Starting Prime = %d, Sum = %d, number of terms = %d%n",
              listOfStartingPrimeNumbers(primePos),
              primeSum,
              termCount)
        }
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
                     candidateMaxPrimeCount:Int,
                     maxPrimeCount:Int ): ( Int,Int ) = {
      val primeCandidateSum = primeCandidate + currentPrimeSum

      if ( primeCandidateSum >= upperLimit )
        return ( maxPrimeCount, maxPrimeSum )

      if ( !sieve.isPrime(primeCandidate) ) {
          primeSumImpl(primeCandidate + 1,
            currentPrimeSum,
            maxPrimeSum,
            candidateMaxPrimeCount,
            maxPrimeCount)
      }
      else {
        if (sieve.isPrime( primeCandidateSum ) ) {
          primeSumImpl (primeCandidate + 1,
                        primeCandidateSum,
                        primeCandidateSum,
                        candidateMaxPrimeCount + 1,
                        candidateMaxPrimeCount + 1 )
        }
        else
          primeSumImpl( primeCandidate + 1,
                        primeCandidateSum,
                        maxPrimeSum,
                        candidateMaxPrimeCount + 1,
                        maxPrimeCount )
      }
    }

    primeSumImpl( firstPrime,
                  currentPrimeSum=0,
                  maxPrimeSum=0,
                  candidateMaxPrimeCount=0,
                  maxPrimeCount=0 )
  }

  def extractStartingPrimeNumbers(candidates: Range.Inclusive) = {
    for (num <- candidates if sieve isPrime num)
      yield num
  }
  
  def printAllTermCountsAndSums(function: => Unit ) = {
    function
  }
}
