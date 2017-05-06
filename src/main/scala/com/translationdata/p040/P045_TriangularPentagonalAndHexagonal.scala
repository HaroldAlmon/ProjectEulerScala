package com.translationdata.p040

import org.junit.Assert._
import org.junit.Test

/** Strategy: Brute Force, Simple Mathematics
  * Where did the root functions, HnQuadraticRoot and PnQuadraticRoot, come from?
  * 1. T(n) = H(n) = n(2n - 1)   <=> 2n^2 - n - T(n) = 0  and solve quadratic root for n
  * 2. T(n) = P(n) = n(3n - 1)/2 <=> 3n^2 - n - 2T(n) = 0 and solve quadratic root for n */
object P045_TriangularPentagonalAndHexagonal {
    def main( args: Array[ String ] ) {
      val n = findSequence
      val triangleNumber = Tn(n)
      printf( "T(%d) = P(%d) = H(%d) = %d%n",
        n,
        PnQuadraticRoot(triangleNumber).toInt,
        HnQuadraticRoot(triangleNumber).toInt,
        triangleNumber )
      println( f"P045: Next triangular number is $triangleNumber" )
    }

  def findSequence: Int = {
    286 to 60000 foreach { x =>
      val triangleNumber = Tn(x)
      if (isPentagonal(triangleNumber) && isHexagonal(triangleNumber))
        return x
    }
    0
  }

  def Tn(n: Long) = n * (n + 1) / 2

  def PnQuadraticRoot(Tn: Long): Double = (1 + (Math sqrt (1 + 24 * Tn))) / 6

  def HnQuadraticRoot(Tn: Long): Double = (1 + (Math sqrt (1 + 8 * Tn))) / 4

  private def isPentagonal( Tn: Long ): Boolean = {
    val root1 = PnQuadraticRoot( Tn )

    if (root1 == (Math round root1))
      true
    else
      false
  }

  private def isHexagonal( Tn: Long ):Boolean = {
    val root1 = HnQuadraticRoot( Tn )

    if ( root1 == (Math round root1) )
      true
    else
      false
  }
}