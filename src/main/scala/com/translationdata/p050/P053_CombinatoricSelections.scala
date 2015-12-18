package com.translationdata.p050

import org.junit.Test
import org.junit.Assert._

object P053_CombinatoricSelections {
  def getCount( n: Int, upperLimit: Int ) = {
    val result = ( 1 to n ).
      map { n => for ( r <- 1 to n if combination( n, r ) > upperLimit )
                    yield 1  }.
      map( x => x.size ).sum
    result
  }

  def combination( n:Int, r:Int ) = {
    binomialCoefficient( n, n - r ) / factorial( r )
  }

  def binomialCoefficient(n:Int, r:Int ) = {
    def factorialImpl( n:Int, r: Int, product: BigInt ): BigInt =
      if ( n <= r )
        product
      else
        factorialImpl( n - 1, r, BigInt( n ) * product )

    factorialImpl(n, r, 1)
  }

  def factorial( n: Int ) = {
    def factorialImpl( n:Int, product:BigInt ): BigInt =
      if ( n <= 1 )
        product
      else
        factorialImpl ( n - 1, BigInt( n ) * product )

    factorialImpl( n, 1 )
  }
}

class P053_CombinatoricSelections {
  @Test def CombinatoricSelections {
    val count = P053_CombinatoricSelections.getCount( n = 100, upperLimit = 1000000 )
    println( count )
    assertEquals( 4075, count )
  }
}
