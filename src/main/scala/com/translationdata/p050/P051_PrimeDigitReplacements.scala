package com.translationdata.p050

object P051_PrimeDigitReplacements {

 val positions = Array(1,2,3,4)

 def main(args: Array[String]): Unit = {
   positions.foreach(println)
   printCombinations(positions, 4, 2)
 }

  def printCombinations (positions: Array[Int], n: Int, r:Int): Unit = {
    printf("n = %d, r = %d\n", n, r)

    printCombinationsImpl(positions, n, r, 0, "")
  }

  def printCombinationsImpl (positions: Array[Int], n: Int, r:Int, startPos:Int, str: String): Unit = {
    for (i <- startPos to n - r + 1) {
      if (r - startPos <= 1) {
        for(j <- startPos to n - 1)
          printf("%s\n", str + positions(j))
        return
      }
      else
        printCombinationsImpl(positions, n, r, i + 1,  str + positions(i))
    }
  }
}
