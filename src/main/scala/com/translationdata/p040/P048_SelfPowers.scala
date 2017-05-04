package com.translationdata.p040
import org.junit.Test
import org.junit.Assert._
import scala.annotation.tailrec

/** Strategy : Brute Force, Tail Recursion */
object P048_SelfPowers {
  val tenDigits = Math.pow( 10, 10 ).toLong
  
  def main( args: Array[ String ] ) = println ( "Last ten digits = " + sumMod10 )

  def powerMod10( base: Int, exponent: Int ): Long = {

    @tailrec def powerMod10Impl( base: Int, exponent: Int, product: Long ): Long = {
      if ( exponent == 0 )
        product
      else
        powerMod10Impl(base, exponent - 1, base * product % tenDigits)
    }

    powerMod10Impl(base, exponent, 1)
  }

  def sumMod10 =
    (1 to 1000).map( n => powerMod10( n, n ) )
               .sum % tenDigits }