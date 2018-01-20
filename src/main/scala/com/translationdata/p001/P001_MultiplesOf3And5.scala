package com.translationdata.P001;

import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.Assert._

object P001_MultiplesOf3And5 {
  def main(args: Array[String]) {
    val sum = P001_MultiplesOf3And5.multiplesOf3And5(1000)
    println("P001: " + sum)
  }

  def multiplesOf3And5(upperLimit: Int) = {
    (calculateSumBelowLimit(upperLimit, 3 )
        + calculateSumBelowLimit(upperLimit, 5)
        - calculateSumBelowLimit(upperLimit, 15))
  }

  // This is a variation of the sum(1..n) formula.
  //
  // Sum(1k, 2k, 3k...kn) = k * n * (n + 1)
  //                   -----------
  //                        2
  // The formula includes n, the problem does not.
  private def calculateSumBelowLimit(upperLimit: Int, divisor: Int) = {
    val n = (upperLimit - 1) / divisor
    divisor * n * (n + 1) / 2
  }
}