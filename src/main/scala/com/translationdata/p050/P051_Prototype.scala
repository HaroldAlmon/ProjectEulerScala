package com.translationdata.p050
import org.junit.Test
import org.junit.Assert._

import scala.collection.immutable.IndexedSeq

object P051_Prototype {


  def combinations(n:Int, r:Int):Unit = {
/*    val elements = Array('1', '2')
    val emptyList:IndexedSeq[String]
    val result = combinationsImpl(2, 1, elements, 0, emptyList )
    printf("result = %s\n", result)*/
  }

/*  def combinationsImpl(n:Int, r:Int, elements:Array[Char], position:Int, comboList:IndexedSeq[String]):IndexedSeq[String] = {
    printf("Inputs %d %d\n", n, r)
    val list:IndexedSeq[String] = for (i <- 0 to (n - r -1) )
     yield combinationsImpl( n - 1, r - 1, elements, position + 1, comboList )
    return comboList.
  }*/
}

class P051_Prototype {
  @Test def runTest {
    println("Run Test")
    P051_Prototype.combinations(3, 1)
    assertEquals(1, 1)
  }
}

