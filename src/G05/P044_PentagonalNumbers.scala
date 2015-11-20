package G05

object P044_PentagonalNumbers {
  val MAX = 3000

  def main(args: Array[String]) {
      findNumber();
  }

  private def findNumber() {
    val pentagonal = (1 to MAX).toArray.map { x => Pn(x) }
    val pentaSet = pentagonal.toSet

    (0 to MAX - 2).foreach {
      pos1 => (pos1 + 1 to MAX - 1).foreach {
          pos2 => isPentagonal(pos1, pos2)
        }
    }
    
    def isPentagonal(pos1: Int, pos2: Int) {
        val Pj = pentagonal(pos1)
        val Pk = pentagonal(pos2)
        
        val sum = Pj + Pk
        if ( pentaSet.contains( sum ) ) {
          val diff = Pk - Pj
          if ( pentaSet.contains( diff ) ) {
            println ( "The diff " + diff + " is pentagonal" )
          }
        }
    }

    /* (0 to 3).foreach {
       i => println("i = " + i)
    }*/
  }
  private def Pn(n: Int) = {
    n * (3 * n - 1) / 2
  }
}