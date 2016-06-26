package com.translationdata.p001;
import org.junit.Test
import org.junit.Assert._

object P001_MultiplesOf3And5{
  def multiplesOf3And5(upperLimit: Int) = {
    (calculateSumBelowLimit(upperLimit, 3 )
        + calculateSumBelowLimit(upperLimit, 5)
        - calculateSumBelowLimit(upperLimit, 15))
  }

  // This is a variation of the sum(1..n) formula.
  //
  // Sum(1...kn) = k * n * (n + 1)
  //                   -----------
  //                        2
  // The formula includes n, the problem does not.
  private def calculateSumBelowLimit(upperLimit: Int, divisor: Int) = {
    val n = (upperLimit - 1) / divisor
    divisor * n * (n + 1) / 2
  }
}

class P001_MultiplesOf3And5 {
  @Test def testMultiplesOf3And5() = {
    val sum = P001_MultiplesOf3And5.multiplesOf3And5(1000)
    assertEquals(233168, sum)
    println("Junit P001: " + sum)
  }
}