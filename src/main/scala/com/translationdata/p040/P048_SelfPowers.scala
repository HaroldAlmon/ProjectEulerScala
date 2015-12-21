package com.translationdata.p040
import org.junit.Test
import org.junit.Assert._
import scala.annotation.tailrec

/** Strategy : Brute Force, Tail Recursion */
object P048_SelfPowers {
  val tenDigits = Math.pow( 10, 10 ).toLong
  
  def main( args: Array[ String ] ) {  println ( "Last ten digits = " + sumMod10 ) }

  def sumMod10 = (1 to 1000).map {
    def powerMod10( base: Int, exponent: Int ): Long = {

      @tailrec
      def powerMod10Impl( base: Int, exponent: Int, product: Long ): Long = {
        if ( exponent == 0 )
          product
        else
          powerMod10Impl(base, exponent - 1, base * product % tenDigits)
      }

      powerMod10Impl(base, exponent, 1)
    }

    // Only keep track of last 10 digits...
    x => powerMod10( x, x ) }.sum % tenDigits
}

class P048_SelfPowers {
  @Test def SumMod10:Unit = {
    val SumMod10 = P048_SelfPowers.sumMod10
    println( f"P048: Last ten digits = ${SumMod10}" )
    assertEquals( 9110846700L, SumMod10 )
  }
}