package com.translationdata.scala.p040
import misc.SieveOfEratosthenes;
import org.junit.Test
import org.junit.Assert._

/** Strategy: Brute Force, Prime Sieve */
/* TODO: Make this run faster. This takes over 3 minutes to run. */
  
object P047_DistinctPrimeFactors {
	val sieve:SieveOfEratosthenes = new SieveOfEratosthenes( 135000 )
  def main(args: Array[String]) { 
    getNumber
  }

  def getNumber:Int = {
    (134000 to 135000 ).foreach { x =>
      val factors1 = findFactors(x)
      val factors2 = if(factors1.size == 4) findFactors(x + 1) else (0 to 0)
      val factors3 = if(factors2.size == 4) findFactors(x + 2) else (0 to 0)
      val factors4 = if(factors3.size == 4) findFactors(x + 3) else (0 to 0)
      
      
      if ( factors1.size + factors2.size + factors3.size + factors4.size == 16) {
        println (f"Four consequetive nums: ${x}, ${x+1}, ${x+2}, ${x+3}\n")
      
        printf( "%d factors are %s\n", x,     factors1.mkString(" ") ) 
        printf( "%d factors are %s\n", x + 1, factors2.mkString(" ") ) 
        printf( "%d factors are %s\n", x + 2, factors3.mkString(" ") )
        printf( "%d factors are %s\n\n", x + 3, factors4.mkString(" ") )
        return x
      }
    }
    return 0
  }
  
  def distinctFactorCount( x:Int ) = {
    findFactors( x ).size
  }

  def findFactors( x: Int ):IndexedSeq[Int] = {
    val factors:IndexedSeq[Int] = for ( factor <- ( 1 to x/2 ) if sieve.isPrime(factor) && ( x % factor == 0 ) )
       yield factor
      
    factors
  }
}

class P047_DistinctPrimeFactors {
  @Test def DistinctPrimeFactors {
    val firstNumber = P047_DistinctPrimeFactors.getNumber
    println( f"P047: First number is ${firstNumber}" )
    assertEquals( 134043, firstNumber )
  }
}