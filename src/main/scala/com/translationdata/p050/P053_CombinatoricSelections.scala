package com.translationdata.p050

import org.junit.Test
import org.junit.Assert._

import scala.annotation.tailrec

/** Strategy: Brute Force, Simple Math */
object P053_CombinatoricSelections {
  def getCount( n: Int, upperLimit: Int ) = ( 1 to n ).
    map( n => for ( r <- 1 to n if combination( n, r ) > upperLimit ) yield 1 ).
    map( indexedSeqInt => indexedSeqInt.size ).
    sum

  def combination( n:Int, r:Int ) = binomialCoefficient( n, n - r ) / factorial( r )

def binomialCoefficient( n:Int, nMinusR:Int ): BigInt = {
    @tailrec def binomialCoefficientImpl( n:Int, r: Int, product: BigInt ): BigInt =
      if ( n <= r )
        product
      else
        binomialCoefficientImpl( n - 1, r, BigInt( n ) * product )

    binomialCoefficientImpl(n, nMinusR, 1)
  }

  def factorial( n: Int ) = {
    @tailrec def factorialImpl( n:Int, product:BigInt ): BigInt =
      if ( n <= 1 )
        product
      else
        factorialImpl ( n - 1, BigInt( n ) * product )

    factorialImpl( n, 1 )
  }
}

class P053_CombinatoricSelections {
  @Test def CombinatoricSelections():Unit = {
    val count = P053_CombinatoricSelections.getCount( n = 100, upperLimit = 1000000 )
    printf( "P053: Count = %d%n", count )
    assertEquals( 4075, count )
  }
}

