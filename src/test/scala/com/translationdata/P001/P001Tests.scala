package test.scala.com.translationdata.P001

import org.hamcrest.CoreMatchers
import org.junit.Assert._
import org.junit.Test
import com.translationdata.P001._

/**
  * Created by Harold on 4/7/2017.
  */
class P001Tests {
  @Test def testMultiplesOf3And5() = {
    val sum = P001_MultiplesOf3And5.multiplesOf3And5(1000)
    assertThat(s"Incorrect sum.",
      sum,
      CoreMatchers.is(233168))
    println("Junit P001: " + sum)
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