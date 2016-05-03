package com.translationdata.p001

import org.junit.Assert._
import org.junit.Test
;
object P002_EvenFibonacciNumbers {
  println( "P002: " + evenFiboNumbersSum( 4000000 ) )

    def evenFiboNumbersSum(upperLimit: Int ) = {
      var EvenFiboNumbersSum = 2
      var fibo1 = 1
      var fibo2 = 2
      var nextFibo = 3

      /* Use a loop since we do not know the term
       * of the Fibonacci number we are seeking. */
      while ( nextFibo < upperLimit ) {
        var isEven = false

        isEven = ( nextFibo % 2 == 0 )

        if( isEven ) {
          EvenFiboNumbersSum += nextFibo
        }

        fibo1 = fibo2
        fibo2 = nextFibo
        nextFibo = fibo1 + fibo2
      }
      EvenFiboNumbersSum
    }
}

class P002_EvenFibonacciNumbers() {
  @Test def PentagonalNumbers() = {
    val sum = P002_EvenFibonacciNumbers.evenFiboNumbersSum(4000000)

    println("P002: Sum is " + sum)
    assertEquals(4613732, sum)
  }
}
