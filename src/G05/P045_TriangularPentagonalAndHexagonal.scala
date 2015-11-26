package G05
/** Strategy: Brute Force, Simple Mathematics */
object TriangularPentagonalAndHexagonal {
    def main(args: Array[String]) {
    findNumber;
  }

  private def findNumber {
    (286 to 60000).foreach { x =>
      val triangle = Tn( x )
 		  if ( isPentagonal( triangle ) && isHexagonal( triangle ) )  {
 		    println( f"Tn($x) = Pn(${PnQuadraticRoot(triangle).toInt}) = Hn(${HnQuadraticRoot(triangle).toInt}) = $triangle" )
 		    return
 		  }
    }
  }

  private def Tn(n: Long) = n * (n + 1) / 2
  private def PnQuadraticRoot(Tn: Long):Double = (1 + Math.sqrt( 1 + 24 * Tn)) / 6
  private def HnQuadraticRoot(Tn: Long):Double = (1 + Math.sqrt( 1 + 8 * Tn)) / 4

  private def isPentagonal(Tn: Long): Boolean = {
    val root1 = PnQuadraticRoot( Tn )

    if ( root1 == Math.round(root1) )
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