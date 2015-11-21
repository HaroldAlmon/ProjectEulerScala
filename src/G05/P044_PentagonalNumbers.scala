package G05

object P044_PentagonalNumbers {
  val MAX = 3000

  def main(args: Array[String]) { findNumber(); }

  private def findNumber() {
    val pentagonalNumbers = (1 to MAX).toArray.map { x => Pn(x) }
    val pentagonalSet = pentagonalNumbers.toSet

    (0 to MAX - 2).foreach {
      pos1 => (pos1 + 1 to MAX - 1).foreach { pos2 => isPentagonal(pos1, pos2) }
    }
    
    def isPentagonal(pos1: Int, pos2: Int) {
        val Pj = pentagonalNumbers(pos1)
        val Pk = pentagonalNumbers(pos2)
        
        if ( pentagonalSet.contains( Pj + Pk ) && pentagonalSet.contains( Pk - Pj )) println ( "The diff " + (Pk - Pj) + " is pentagonal" )
    }
  }
  private def Pn(n: Int) = { n * (3 * n - 1) / 2 }
}