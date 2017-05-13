package main.scala.com.translationdata.p050
import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.Assert._

import scala.annotation.tailrec
import scala.math.BigInt

object P056_PowerfulDigitSum {
  def powerfulDigitSum = {
    println("P056_PowerfulDigitSum")
    (for {
      base <- 1 to 99
      exponent <- 1 to 99
    } yield {
        stringSum(BigInt(base) pow(exponent) toString)
        //BigInt(base).pow(exponent).toString().reduceLeft((a, b) => (a + b - '0').toChar)
        //BigInt(base) pow(exponent).toString().chars().reduce(0,(a, b) => a + b - '0');
      }).max
  }

  def stringSum(numberString: String):Int = {
    @tailrec
    def stringSumImpl(numberString: String, sum: Int):Int = {
      if ( numberString.isEmpty )
        sum
      else
        stringSumImpl(numberString.tail, sum + numberString(0).toInt - '0')
    }

    stringSumImpl(numberString, 0)
  }
}
