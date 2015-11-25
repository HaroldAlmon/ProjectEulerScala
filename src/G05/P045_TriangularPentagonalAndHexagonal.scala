package G05

object TriangularPentagonalAndHexagonal {
    def main(args: Array[String]) {
    findNumber;
  }

  private def findNumber {
    (3 to 1000).foreach { x =>
      val triangle = Tn( x )
 		  if ( isPentagonal( triangle ) && isHexagonal( triangle ) )  {
 		    println( "triangle number found = " + triangle )
 		  }
    }
  }

  private def Tn(n: Int):Long = { n * (n + 1) / 2 }
  
  private def isHexagonal( Tn: Long ):Boolean = {
    var root1 = (1 + Math.sqrt( 1 + 8 * Tn)) / 4
    var root2 = (1 - Math.sqrt( 1 + 8 * Tn)) / 4

    //println ("\nroot1 = " + root1 + ", root2 = " + roroundot2) 
    
    if ( ((root1 == Math.round( root1 )) ) && root1 > 0  || (root2 == Math.round( root2 )) && (root2 > 0) )
      return true
    false
    
    //if ( ((root1 == Math.round( root1 )) ) && (root1 > 0) || (root2 == Math.round( root2 )) && (root2 > 0) )
     // return true
  }
 
  private def isPentagonal( Tn: Long ):Boolean = {
    var root1 = (1 + Math.sqrt( 1 + 24 * Tn)) / 6
    var root2 = (1 - Math.sqrt( 1 + 24 * Tn)) / 6
    
    //println ("root1 = " + root1 + ", root2 = " + root2)
    
    if ( ((root1 == Math.round( root1 )) ) && root1 > 0  || (root2 == Math.round( root2 )) && (root2 > 0) )
      return true
    false
  }
}