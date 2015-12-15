package com.translationdata.p050

import org.junit.Test
import org.junit.Assert._

object P053_CombinatoricSelections {
  def getCount = {
    for ( n <- 1 to 10 ) {
      val result = for (r <- 1 to n if combination(n, r) > 10)
        yield (1, n, r)

        //printf("n = %d, r = %d\n")
      printf( "count = %d, result = %s\n", result.size, result )
    }
  }

/*  def outer(n: Long): Long = {
    outerImpl(n, 1)
  }*/

/*  def outerImpl(n:Long, sum:Long): Long = {
    if (n <= 0) {
      sum
    } else
      outerImpl( n -1, innerImpl(n, sum ) )
  }*/

/*  def innerImpl(n:Long, sum:Long): Long = {
    if (n <= 0) {
      sum
    } else
      innerImpl(n - 1, combination + sum)
  }*/

  def combination( n:Int, r:Int ) = {
    factorial( n, n - r ) / factorial( r )
  }

  def factorial(n:Int, r:Int): Long = {
    factorialImpl(n, r, 1)
  }

  def factorialImpl(n:Int, r: Int, product: Long): Long = {
    if (n <= r) {
      product
    } else
      factorialImpl(n - 1, r, n * product)
  }
  def factorial(n: Int): Long = {
    factorialImpl(n, 1)
  }

  def factorialImpl(n:Int, product:Long): Long = {
    if (n <= 1) {
      product
    } else
      factorialImpl(n - 1, n * product)
  }
}

class P053_CombinatoricSelections {
  @Test def CombinatoricSelections {
    println(P053_CombinatoricSelections.getCount)
  }
}
