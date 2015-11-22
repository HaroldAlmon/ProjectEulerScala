package G05

/** Strategy: Brute Force, Hash Set Lookup */
object P044_PentagonalNumbers {
  val pentagonalUpperLimit = 3000

  def main(args: Array[String]) { findNumber(); }

  private def findNumber() {
    val pentagonalNumbers = ( 1 to pentagonalUpperLimit).toArray.map { x => Pn( x ) }
    val pentagonalSet = pentagonalNumbers.toSet

    (0 to pentagonalUpperLimit - 2).
      foreach { leftIndex => ( leftIndex + 1 to pentagonalUpperLimit - 1).
      foreach { rightIndex => isPentagonal( leftIndex, rightIndex ) } }

    def isPentagonal( leftIndex: Int, rightIndex: Int ) {
      val Pj = pentagonalNumbers( leftIndex )
      val Pk = pentagonalNumbers( rightIndex )

      if (pentagonalSet.contains( Pj + Pk ) && pentagonalSet.contains( Pk - Pj ) ) 
        println("Minimised difference is " + (Pk - Pj) )
    }
  }
  private def Pn(n: Int) = { n * (3 * n - 1) / 2 }
}