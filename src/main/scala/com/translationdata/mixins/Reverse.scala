package com.translationdata.mixins

import scala.annotation.tailrec
import scala.math.BigInt

trait Reverse {
  def reverse(n:BigInt) = {
    @tailrec def reverseImpl(n:BigInt, sum:BigInt): BigInt = {
      n.toString match {
        case "0" => sum
        case _ => reverseImpl(n / 10, sum * 10 + n % 10)
      }
    }
    reverseImpl(n, 0)
  }
}
