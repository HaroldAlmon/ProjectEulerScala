package com.translationdata.p050

import org.junit.Test
import org.junit.Assert._

object P053_CombinatoricSelections {
  def getCount(n: Int, upperLimit: Int) = {
    val result = (1 to n).
      map { n => for (r <- 1 to n if combination(n, r) > upperLimit)
                    yield 1  }.
      map( x => x.size ).sum
    result
  }

  def combination( n:Int, r:Int ) = {
    factorial( n, n - r ) / factorial( r )
  }

  def factorial(n:Int, r:Int): Long = {
    def factorialImpl(n:Int, r: Int, product: Long): Long = {
      if (n <= r) {
        product
      } else
      factorialImpl(n - 1, r, n * product)
    }

    factorialImpl(n, r, 1)
  }

  def factorial(n: Int): Long = {

    def factorialImpl(n:Int, product:Long): Long = {
      if (n <= 1) {
        product
      } else
      factorialImpl(n - 1, n * product)
    }

    factorialImpl(n, 1)
  }

}

class P053_CombinatoricSelections {
  @Test def CombinatoricSelections {
    println( P053_CombinatoricSelections.getCount( 50, 1000000 ) )
  }
}
