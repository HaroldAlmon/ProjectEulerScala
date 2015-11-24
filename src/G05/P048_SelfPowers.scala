package G05

object P048_SelfPowers {
  
  def main(args: Array[String]) { }

  // TODO: Convert var to a val
  var sum = 0L
  val TenDigits = Math.pow(10, 10).toLong
  (1 to 1000).foreach { x => sum += power(x, x) }
  println("Sum = " + sum % TenDigits)
  
  //(1 to 1000).toArray.map { x => power(x, x) }
  //println("Sum = " + powerSum(1000) % TenDigits)
  
  //TODO: This code causes a stack overflow...
 /* def powerSum( n:Int ): Long = {
    if (n == 1) {
      modPower(n, n)
    }
    modPower(n, n) + powerSum(n-1)
  }*/

  // Only keep track of last 10 digits...
  def power(base: Int, exponent: Int): Long = {
    if (exponent == 0) {
      1
    } else
      (base * power(base, exponent - 1) ) % TenDigits
  }
}