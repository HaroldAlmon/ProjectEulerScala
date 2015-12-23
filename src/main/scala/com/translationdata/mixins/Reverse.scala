package com.translationdata.mixins

import scala.annotation.tailrec

trait Reverse {
  def reverse(n:Int) = {
    @tailrec def reverseImpl(n:Int, sum:Int): Int = {
      n match {
        case 0 => sum
        case _ => reverseImpl(n / 10, sum * 10 + n % 10)
      }
    }
    reverseImpl(n, 0)
  }
}
