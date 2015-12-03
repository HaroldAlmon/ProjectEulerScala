package com.translationdata.scala.p040

/** Strategy: Brute Force, Hash Set Lookup */
object P044_PentagonalNumbers {
  val pentagonalUpperLimit = 3000

  def main(args: Array[String]) { findNumber }

  private def findNumber {
    val pentagonalNumbers = ( 1 to pentagonalUpperLimit ).toArray.map { x => Pn( x ) }
    val pentagonalSet = pentagonalNumbers.toSet

    (0 to pentagonalUpperLimit - 2).
      foreach { leftIndex => ( leftIndex + 1 to pentagonalUpperLimit - 1).
      foreach { rightIndex => isPentagonal( pentagonalNumbers( leftIndex ), pentagonalNumbers( rightIndex ) ) } }

    def isPentagonal( Pj: Int, Pk: Int ) {
      if (pentagonalSet.contains( Pj + Pk ) && pentagonalSet.contains( Pk - Pj ) ) {
        printf("P040:\n" )
        printf("Pj = %d\n", Pj )
        printf("Pk = %d\n", Pk )
        printf("|Pk - Pj| = %d\n", (Pk - Pj) )
      }
    }
  }
  
  private def Pn(n: Int) = { n * (3 * n - 1) / 2 }
}