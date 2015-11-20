package G05

object PentagonalNumbers {
  val MAX = 3000
  def main(args: Array[String]) {
      findNumber();
  }

  private def findNumber() {
    val pentagonal = (1 to MAX).toArray.map { x => Pn(x) }
    val pentaSet = pentagonal.toSet
    var Pj = 0
    var Pk = 0
    var diff = 0
    var sum = 0
    for (pos1 <- 0 to MAX - 2)
      for (pos2 <- pos1 + 1 to MAX - 1) {
        Pj = pentagonal(pos1)
        Pk = pentagonal(pos2)
        //Pj.apply { x => printit(x)}
        
        sum = Pj + Pk
        if ( pentaSet.contains( sum ) ) {
          diff = Pk - Pj
          if ( pentaSet.contains( diff) ) {
            println("P1 = " + Pj + ", P2 = " + Pk)
            println ( "The sum " + sum + " is pentagonal" )
            println ( "The diff " + diff + " is pentagonal" )
          }
        }
    }
  }
  
  def printit = {
    println _
  }
  
  private def Pn(n: Int) = {
    n * ( 3 * n - 1 ) / 2
  }
}