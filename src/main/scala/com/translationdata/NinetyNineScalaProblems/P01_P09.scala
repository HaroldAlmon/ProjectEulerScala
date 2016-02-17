package com.translationdata.NinetyNineScalaProblems

import scala.annotation.tailrec

object P01_P09 {
  def main(args: Array[String]) {
    val numList  = List(1, 2, 3, 4, 5, 6, 7)
    val fruitList  = List("peach", "apple", "pear")
    val palindromeList  = List("peach", "apple", "pear", "apple", "peach")
    val nestedList = List(List(1,1),2,List(3,List(5,8) ))
    val nestedList2 = List(List(1,1),List(5,8))

    printf("P01: %d%n", sumList(numList))
    printf("P01: %d%n", P01_last1(numList))
    printf("P01: %s%n", P01_last2(fruitList))
    printf("P01: %s%n", P02_penultimate(fruitList))

    printf("P05: %s%n", P05_reverse(fruitList))
    printf("P05: %s%n", P05_reverseTailRecursion(fruitList))
    printf("P01: %s%n", P05_reverseFunctional(fruitList))

    printf("P03: %d%n", P03_kthElement(2, numList))
    printf("P04: %d%n", P04_size(numList))
    printf("P05: %s%n", P05_reverse(numList))
    printf("P05: %s%n", P05_reverseTailRecursion(numList))
    printf("P06: %s%n", P06_palindrome(numList))
    printf("P06: %s%n", P06_palindrome(palindromeList))
    //printf("P07: %s%n", P07_flatten(nestedList))
  }

  def P01_last1[E](list: List[E]) = {
    list.reverse.head
  }

  def P01_last2[E](list: List[E]) = {
    list.last
  }

  def P02_penultimate[E](list: List[E]) = {
    list(list.size - 2)
  }

  def P03_kthElement[E](position:Int, list: List[E]) = {
    list.apply(position - 1)
  }

  def P04_size[E](list: List[E]) = {
    list.size
  }

  def P05_reverse[E](list: List[E]):List[E] = {
    list match {
      case Nil => Nil
      case theHead :: theTail => P05_reverse(theTail) ::: List(theHead)
    }
  }

  def P05_reverseTailRecursion[E](list: List[E]):List[E] = {
    @tailrec
    def reverse [E](theResult: List[E], theTail: List[E]):List[E] = {
      theTail match {
        case Nil => theResult
        case theHead :: theTail => reverse( theHead :: theResult, theTail )
      }
    }

    reverse(Nil, list)
  }

  def P05_reverseFunctional[E](list: List[E]):List[E] = {
    list.foldLeft(List[E]()) { (theResult, element) => element :: theResult }
  }

  def P06_palindrome[E](list: List[E]):Boolean = {
    for (i <- list.indices)
      if (list(i) != list(list.size - i - 1)) {
        return false
      }
    true
  }

  def sumList(list:List[Int]) = {
    list.foldLeft(0) { (total, number) => total + number }
  }
}
