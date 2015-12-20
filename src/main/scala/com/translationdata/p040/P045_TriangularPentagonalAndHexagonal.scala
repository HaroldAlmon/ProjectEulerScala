package com.translationdata.p040

/** Strategy: Brute Force, Simple Mathematics */
object P045_TriangularPentagonalAndHexagonal {
    def main( args: Array[ String ] ) {
      val n = findSequence
      val triangleNumber = Tn(n)
      printf( "Tn(%d) = Pn(%d) = Hn(%d) = %d\n",
        n,
        PnQuadraticRoot(triangleNumber).toInt,
        HnQuadraticRoot(triangleNumber).toInt,
        triangleNumber )
      println( f"P045: Next triangular number is $triangleNumber" )
    }

  private def findSequence:Int = {
    286 to 60000 foreach { x =>
      val triangleNumber = Tn( x )
      if ( isPentagonal( triangleNumber ) && isHexagonal( triangleNumber ) )  {
        return x
      }
    }
    0
  }

  private def Tn(n: Long) = n * ( n + 1 ) / 2
  private def PnQuadraticRoot( Tn: Long ):Double = (1 + Math.sqrt( 1 + 24 * Tn ) ) / 6
  private def HnQuadraticRoot( Tn: Long ):Double = (1 + Math.sqrt( 1 + 8 * Tn  ) ) / 4

  private def isPentagonal( Tn: Long ): Boolean = {
    val root1 = PnQuadraticRoot( Tn )

    if ( root1 == Math.round( root1) )
      true
    else
      false
  }

  private def isHexagonal( Tn: Long ):Boolean = {
    val root1 = HnQuadraticRoot( Tn )

    if ( root1 == Math.round( root1 ) )
      true
    else
      false
  }
}