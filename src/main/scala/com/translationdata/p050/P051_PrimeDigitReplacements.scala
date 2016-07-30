package com.translationdata.p050

import org.junit.Test

object P051_PrimeDigitReplacements {

 val positions = Array(1,2,3,4)

/*def main(args: Array[String]): Unit = {
   //positions foreach println
   printCombinations(positions, 4, 2)
 }*/

  def printCombinations (positions: Array[Int], n: Int, r:Int): Unit = {
    printf("n = %d, r = %d%n", n, r)

    printCombinationsImpl(positions,
                          n,
                          r,
                          1,
                          positions(0).toString)
  }

  def printCombinationsImpl (positions: Array[Int],
                             n: Int,
                             r:Int,
                             startPos:Int,
                             str: String): Unit = {
    for (i <- startPos to n - r + 1) {
      if (r - startPos <= 1) {
        for(j <- startPos to n - 1)
          printf("%s%n", str + positions(j))
      }
      else
        printCombinationsImpl(positions, n, r, i + 1,  str + positions(i))
    }
  }
}



class P051_PrimeDigitReplacements {
  @Test def test = {
    println("P051:")
    P051_PrimeDigitReplacements.positions foreach println
    P051_PrimeDigitReplacements.printCombinations(P051_PrimeDigitReplacements.positions, 4, 2)
  }
}
