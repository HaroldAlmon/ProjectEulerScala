package G05

object TriangularPentagonalAndHexagonal {
    def main(args: Array[String]) {
    findNumber();
  }

  private def findNumber() {
    for ( i <- 280 to 290) {
      val triangle = Tn( i )
 		  println( triangle + ", " + isHexagonal( triangle ) )
    }
  }

  private def Tn(n: Int) = { n * (n + 1) / 2 }
  
  private def isHexagonal( Hn: Int ) = {
    val root1 = (1 + Math.sqrt( 1 + 8 * Hn)) / 4
    val root2 = (1 - Math.sqrt( 1 + 8 * Hn)) / 4
    root1 == Math.floor( root1 ) || root2 == Math.floor( root2 ) && root2 > 0
  }
 
  // TODO return boolean
  private def isPentagonal( Pn: Int ) {
    // TODO: update formula...
    val root1 = (1 + Math.sqrt( 1 + 8 * Pn)) / 4
    val root2 = (1 + Math.sqrt( 1 + 8 * Pn)) / 4
    println ("root1 = " + root1 + ", root2 = " + root2) 
  }
  
}