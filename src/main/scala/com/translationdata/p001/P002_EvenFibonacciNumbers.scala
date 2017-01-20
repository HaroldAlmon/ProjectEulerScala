package com.translationdata.p001

import org.hamcrest.CoreMatchers
import org.junit.Assert._
import org.junit.Test
;
object P002_EvenFibonacciNumbers {
  def evenFiboNumbersSum(upperLimit: Int ) = evenFiboNumbersSum_impl(upperLimit, 1, 2, 2)

  def evenFiboNumbersSum_impl(upperLimit: Int, fibo1: Int, fibo2: Int, sum: Int ) : Int = {
    val nextFibo = fibo1 + fibo2
    if ( nextFibo >= upperLimit )
      return sum

    val isFiboEven = nextFibo % 2 == 0
    val nextSum =
      if (isFiboEven)
        sum + nextFibo
      else
        sum

    val nextFibo1 = fibo2

    evenFiboNumbersSum_impl(upperLimit, nextFibo1, nextFibo, nextSum)
  }
}

class P002_EvenFibonacciNumbers() {
  @Test def PentagonalNumbers() = {
    val sum = P002_EvenFibonacciNumbers.evenFiboNumbersSum(4000000)

    println("P002: Sum is " + sum)

    assertThat("Incorrect sum.",
      sum,
      CoreMatchers.is(4613732))
  }
}
