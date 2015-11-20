package G05

object PentagonalNumbers {
  val MAX = 1000

  def main(args: Array[String]) {
      findNumber;
  }

  private def findNumber {
    var pentagonal = 1 to MAX toArray

    pentagonal = pentagonal.map { x => Pn(x) }
    pentagonal.foreach { println }
  }
  
  private def Pn(n: Int) = {
    n * ( 3 * n - 1 ) / 2
  }
}