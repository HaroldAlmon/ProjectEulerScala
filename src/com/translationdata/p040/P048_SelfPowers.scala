package com.translationdata.p040

object P048_SelfPowers {
  val TenDigits = Math.pow(10, 10).toLong
  
  def main(args: Array[String]) {  println ( "Sum = " + sumMod10 ) }

  def sumMod10 = { (1 to 1000).map { x => powerMod10(x, x) }.sum % TenDigits }
  
  // Only keep track of last 10 digits...
  def powerMod10(base: Int, exponent: Int): Long = {
    if (exponent == 0) {
      1
    } else
      (base * powerMod10(base, exponent - 1) ) % TenDigits
  }
}