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
 		    println( f"triangle number found = $triangle for Tn($x), Pn(${PnRoot(triangle)}), Hn(${HnRoot(triangle)})" )
 		    return
 		  }
    }
  }

  private def Tn(n: Long):Long = { n * (n + 1) / 2 }
  private def PnRoot(Tn: Long):Int = { ((1 + Math.sqrt( 1 + 24 * Tn)) / 6).toInt }
  private def HnRoot(Tn: Long):Int = { ((1 + Math.sqrt( 1 + 8 * Tn)) / 4).toInt }
  
  private def isHexagonal( Tn: Long ):Boolean = {
    val root1 = (1 + Math.sqrt( 1 + 8 * Tn)) / 4
    val root2 = (1 - Math.sqrt( 1 + 8 * Tn)) / 4
    
    if ( ((root1 == Math.round( root1 )) ) && root1 > 0  || 
        (root2 == Math.round( root2 )) && (root2 > 0) )
      true
    else
      false
  }
 
  private def isPentagonal( Tn: Long ):Boolean = {
    val root1 = (1 + Math.sqrt( 1 + 24 * Tn)) / 6
    val root2 = (1 - Math.sqrt( 1 + 24 * Tn)) / 6
    
    if ( ((root1 == Math.round( root1 )) ) && root1 > 0  || 
        (root2 == Math.round( root2 )) && (root2 > 0) )
      true
    else
      false
  }
}