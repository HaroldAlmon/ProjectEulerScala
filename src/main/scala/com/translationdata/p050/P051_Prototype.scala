package com.translationdata.p050
import org.junit.Test
import org.junit.Assert._

import scala.collection.immutable.IndexedSeq

object P051_Prototype {

  //var result:IndexedSeq

  def combinations(digits:List[Int], n:Int, r:Int, result:IndexedSeq[Int]):IndexedSeq[Int] = {
    if (r == 1) {
      val result = for (i <- 0 to digits.size - 1 )
        yield digits(i)

      return result
    }
    combinations(digits.tail, n - 1, r - 1, result).map(x => x * 10 + digits.head).union(
      combinations(digits.tail, n - 1, r - 1, result))
  }
}

class P051_Prototype {
  @Test def runTest() {
    println("Run Test")
    println(P051_Prototype.combinations(List(1,2), 2, 1, IndexedSeq()))

    println(P051_Prototype.combinations(List(1,2,3), 3, 1, IndexedSeq()))

    println(P051_Prototype.combinations(List(1,2,3), 3, 2, IndexedSeq()))
    assertEquals(1, 1)
  }
}

