package com.translationdata.p040
import org.junit.Test
import org.junit.Assert._
object P048_SelfPowers {
  val tenDigits = Math.pow( 10, 10 ).toLong
  
  def main( args: Array[ String ] ) {  println ( "Last ten digits = " + sumMod10 ) }

  def sumMod10 = { (1 to 1000).map {
    def powerMod10( base: Int, exponent: Int ): Long = {
      if ( exponent == 0 )
        1
      else
        ( base * powerMod10( base, exponent - 1) ) % tenDigits
    }

    x => powerMod10( x, x ) }.sum % tenDigits
    // Only keep track of last 10 digits...
  }
}

class P048_SelfPowers {
  @Test def SumMod10:Unit = {
    val SumMod10 = P048_SelfPowers.sumMod10
    println( f"P048: Last ten digits = ${SumMod10}" )
    assertEquals( 9110846700L, SumMod10 )
  }
}