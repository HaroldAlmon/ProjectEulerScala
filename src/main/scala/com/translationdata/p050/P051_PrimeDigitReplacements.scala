package com.translationdata.p050

object P051_PrimeDigitReplacements {
  def main(args: Array[String]): Unit = {
   println("Test = " + combinationSeq("12", 1, 3, 3, 5).toString)
   val result = combinations(5, 3)
   printf("result = %s\n", result)
 }

 def combinations(n:Int, r:Int) = {
  combinationSeq2( 1 to r - 1, 1, r, r ,n)
 }

 // 1 2 3 4 5
  def combinationSeq (prefix:String, base:Int, runner:Int, r:Int, n:Int) = {
  val result =  for ( i <- runner to n)
   yield prefix + i
  //yield (base to runner -1).foreach(x => x.toString) + base.toString + runner.toString + (runner + i - 1).toString
  result
 }

 // 1 2 3 4 5
 def combinationSeq2 (prefix:Range.Inclusive, base:Int, runner:Int, r:Int, n:Int) = {
  println ( "Range = " + prefix.mkString )
  val result =  for ( i <- runner to n )
   yield prefix.mkString + i.toString
  //yield (base to runner -1).foreach(x => x.toString) + base.toString + runner.toString + (runner + i - 1).toString
  result
 }
}
